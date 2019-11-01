package io.pivotal.cloudnativespring.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import io.pivotal.cloudnativespring.domain.City;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityRepository extends PagingAndSortingRepository<City, Long>{
	
	@RestResource(path="cityName",rel="cityName")
	public Page<City> findByCityNameIgnoreCase(@Param("q") String name, Pageable pageable); 

	@RestResource(path="cityNameContains", rel = "cityNameContains")
	public Page<City> findByCityNameContainsIgnoreCase(@Param("q") String name, Pageable pageable);
	
	@RestResource(path = "state", rel = "state")
	public Page<City> findByStateCodeIgnoreCase(@Param("q") String stateCode, Pageable pageable);

	@RestResource(path = "postalCode", rel = "postalCode")
	public Page<City> findByPostalCodeIgnoreCase(@Param("q") String postalCode, Pageable pageable);
}
