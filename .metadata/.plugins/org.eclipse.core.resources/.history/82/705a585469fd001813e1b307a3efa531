package edu.uniandes.dynamiccomparator;

import org.eclipse.emf.ecore.resource.ResourceSet;

import edu.uniandes.dynamiccomparator.Models.CompareVersionInput;
import edu.uniandes.dynamiccomparator.Models.IdentifyOutput;
import edu.uniandes.dynamiccomparator.Tools.Tools;

public class DynamicComparator {

	public static void execute(CompareVersionInput input) {
		try {
			//register Metamodels
			Tools.registerDiffMetamodel();						
			
			//Call static comparation
			IdentifyOutput output = Tools.callStaticComparation(input);
			
			//Save models
			String diffModelPath = Tools.saveModel(output.getDiffModel(), "diffModel");
			String minorModelPath = Tools.saveModel(input.getMinorVersionModel(), "minorModel");
			String mayorModelPath = Tools.saveModel(input.getMinorVersionModel(), "mayorModel");
			
			ResourceSet diffModel = Tools.loadModel(diffModelPath);
			int i = 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
