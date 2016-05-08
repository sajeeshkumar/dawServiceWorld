/**
 * 
 */
package net.sajeesh.samplerest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sajeesh
 * External user response entity class.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalUserResponse {

	private User user;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	
	
}
