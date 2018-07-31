package fr.sparkit.developer;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName="developer", type="developerSearch", shards=1, replicas=2)
public class Developer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long registrationNumber;
	private String name;
	private String lastName;
	private String town;
	private String email;
	private String description;
	
	
	
	
	public Long getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(Long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	public Developer(String name, String lastName, String town, String description, String developerType,
			String developmentBox) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.town = town;
		this.description = description;
		
	}
	public Developer() {
		super();
	
	}
	
	
	

}
