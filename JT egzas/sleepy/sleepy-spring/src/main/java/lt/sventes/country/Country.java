package lt.sventes.country;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String title;
	@Column
	private double price;
	@Column
	private int quantity;
//	@Column
//	private String presidentName;
//	@Column
//	private String dateOfHoliday;
	@OneToOne(cascade = {CascadeType.ALL}) // CascadeType.MERGE, CascadeType.DETACH})
	private CountryDetails countryDetails;
	
	

	public Country() {
	}

	public Country(long id, String title, CountryDetails countryDetails, double price, int quantity) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.countryDetails = countryDetails;
	}
	
	//konstruktorius be id
	public Country(String title, CountryDetails countryDetails, double price, int quantity) {
		//this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.countryDetails = countryDetails;
	}
	
	// toliau - get ir set metodai

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//naujo lauko seteris ir geteris
	public CountryDetails getCountryDetails() {
		return countryDetails;
	}

	public void setCountryDetails(CountryDetails countryDetails) {
		this.countryDetails = countryDetails;
	}
	
}
