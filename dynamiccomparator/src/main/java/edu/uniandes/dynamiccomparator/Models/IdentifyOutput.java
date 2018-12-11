package edu.uniandes.dynamiccomparator.Models;

import org.eclipse.emf.ecore.resource.ResourceSet;

public class IdentifyOutput {
	private String outputType;
	private String diffModel;
	private boolean success;
	private String error;
	private ResourceSet outputModel;

	public String getOutputType() {
		return outputType;
	}

	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}

	public String getDiffModel() {
		return diffModel;
	}

	public void setDiffModel(String diffModel) {
		this.diffModel = diffModel;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		if (error == null)
			return "";
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ResourceSet getOutputModel() {
		return outputModel;
	}

	public void setOutputDiffModel(ResourceSet outputModel) {
		this.outputModel = outputModel;
	}
}
