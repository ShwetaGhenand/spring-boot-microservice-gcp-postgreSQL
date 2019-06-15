package com.example.identityservice.util;

import java.util.HashSet;
import java.util.Set;

public class APIListResponse {

	private int totalResults;
	private Set<?> resources;

	public APIListResponse(int totalResults, Set<?> resources) {
		super();
		this.totalResults = totalResults;
		this.resources = resources;
	}

	/**
	 *
	 */
	public APIListResponse() {
		super();
		this.totalResults = 0;
		this.resources = new HashSet<Object>();
	}

	/**
	 * @return the totalResults
	 */
	public int getTotalResults() {
		return totalResults;
	}

	/**
	 * @param totalResults the totalResults to set
	 */
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	/**
	 * @return the resources
	 */
	public Set<?> getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(Set<?> resources) {
		this.resources = resources;
	}
}
