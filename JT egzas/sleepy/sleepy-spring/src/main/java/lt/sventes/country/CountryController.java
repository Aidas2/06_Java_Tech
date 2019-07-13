package lt.sventes.country;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.sventes.dao.UserDao;

@RestController
@Api(value = "country")
@RequestMapping(value = "/countrys")
public class CountryController {

	//private final CountryDao countryDao; // pridedame DAO
	private final CountryService countryService; // pridedame Service
	
	//konstruktorius
	@Autowired
	//public CountrysController(CountryDao countryDao) {
	//this.countryDao = countryDao;
	public CountryController(CountryService countryService) {
	this.countryService = countryService;
	}

//--------------------------------------------------------------------	
	/* Apdoros užklausas: GET /api/users */
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get countrys",notes="Returns existing countrys")
	public List<Country> getCountrys() {
		//return Collections.emptyList(); -> pirma versija
		//return countryDao.getCountrys();// skaitome per DAO
		return countryService.getCountrys();// skaitome per Service
	}
//--------------------------------------------------------------------		
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create new country",notes="Creates new country with provided data")
	public void createCountry(@ApiParam(value="Country data",required=true)
	@Valid
	@RequestBody final CreateCountryCommand cmd) {

		countryService.createCountry(new Country(cmd.getTitle(), new CountryDetails(cmd.getImage(), cmd.getDescription()),
				cmd.getPrice(), cmd.getQuantity()));
		System.out.println(cmd);
	}
//--------------------------------------------------------------------	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete country", notes = "Deletes selected country")
	public void deleteCountry(@PathVariable final long id) {
		countryService.deleteCountry(id);
		System.out.println("Deleting country: " + id);
	}
//--------------------------------------------------------------------	
	// mano metodas produkto atnaujinimui
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK) 
	@ApiOperation(value = "Edit country", notes = "Change selected country's data")

	public void updateCountry(@ApiParam(value = "Country id", required = true) @Valid @PathVariable final long id,
			@ApiParam(value = "Country data", required = true) @Valid @RequestBody final CreateCountryCommand cmd) {

		countryService.updateCountry(new Country(id, cmd.getTitle(), new CountryDetails(cmd.getImage(), cmd.getDescription()),
				cmd.getPrice(), cmd.getQuantity()));

		// countryDao.updateCountry(countryToUpdate);
		}	
}
