package edu.uniandes.dynamiccomparator.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uniandes.metamodels.Diff.DiffPackage;
import edu.uniandes.dynamiccomparator.Models.CompareVersionInput;
import edu.uniandes.dynamiccomparator.Models.IdentifyOutput;

public class Tools {

	public static DiffPackage registerDiffMetamodel() {
		DiffPackage diffPackage = DiffPackage.eINSTANCE;
		EPackage.Registry.INSTANCE.put(diffPackage.getNsURI(), diffPackage);

		return diffPackage;
	}

	/*
	 * public static OpenAPIPackage registerOpenAPIMetamodel() { OpenAPIPackage
	 * openAPIPackage = OpenAPIPackage.eINSTANCE;
	 * EPackage.Registry.INSTANCE.put(openAPIPackage.getNsURI(), openAPIPackage);
	 * 
	 * return openAPIPackage; }
	 */

	public static IdentifyOutput callStaticComparation(CompareVersionInput input) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL("http://ec2-54-188-195-2.us-west-2.compute.amazonaws.com:8080/comparer/api/diff/compare");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		OutputStream os = conn.getOutputStream();
		os.write(input.getInputForStaticComparator().getBytes());
		os.flush();

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String line;
		StringBuffer output = new StringBuffer();

		while ((line = br.readLine()) != null) {
			output.append(line);
		}

		conn.disconnect();
		return mapper.readValue(output.toString(), IdentifyOutput.class);

	}

	public static String saveModel(String model, String filename) throws IOException {

		return getPathFromBase64(model, filename);

	}

	private static String getPathFromBase64(String model, String filename) throws IOException {
		byte[] decodedMinorModel = Base64.getDecoder().decode(model.getBytes(StandardCharsets.UTF_8));
		Path destinationFileMinorModel = Files.createTempFile(filename, ".xmi");
		Files.write(destinationFileMinorModel, decodedMinorModel);

		return destinationFileMinorModel.toAbsolutePath().toString();
	}

	public static ResourceSet loadModel(String absolutePath) {
		ResourceSet resourceSet = new ResourceSetImpl();

		URI uri = URI.createFileURI(absolutePath);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		resourceSet.getResource(uri, true);

		return resourceSet;
	}
}
