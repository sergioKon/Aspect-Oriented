package com.base.common;

public class WrongDataSource extends Exception {
    private String provider;
	public WrongDataSource(String provider) {
	   this.setProvider(provider);
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
