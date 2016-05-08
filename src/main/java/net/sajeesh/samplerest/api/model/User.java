/**
 * 
 */
package net.sajeesh.samplerest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sajeesh
 * 
 * Entity class for User object.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	private String username;
	private String email;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
