package lt.sventes.country;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.sventes.model.User;

public interface CountryRepository extends JpaRepository<Country, Long> {

	void deleteCountryById(long id);

} 
