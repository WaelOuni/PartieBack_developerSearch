package fr.sparkit.repository;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import fr.sparkit.developer.Developer;



@Repository
public interface DeveloperRepository extends ElasticsearchRepository<Developer, Long>{

	public Optional<Developer> findByRegistrationNumber(Long registrationNumber);
	public Developer deleteByRegistrationNumber(Long registrationNumber); 
}