package lt.sventes.country;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CountryDetails {
	@Column
	private String image;
	@Id
	private String description;
	//@OneToOne(mappedBy="countryDetails", cascade = {CascadeType.MERGE, CascadeType.DETACH})
	//public Country country;
	
	public CountryDetails() {
		
	}
	
	
	public CountryDetails(String image, String description) {
		this.image = image;
		this.description = description;		
	}


	//seteriai ir geteriai
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Country getCountry() {
//		return country;
//	}
//
//	public void setCountry(Country country) {
//		this.country = country;
//	}
}
