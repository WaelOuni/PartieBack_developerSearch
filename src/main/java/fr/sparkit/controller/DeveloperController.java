package fr.sparkit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.sparkit.component.DeveloperComponent;
import fr.sparkit.developer.Developer;
import fr.sparkit.repository.DeveloperRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DeveloperController {
	
	@Autowired
	DeveloperComponent developerComponent;
	
	
	@Autowired
	DeveloperRepository developerRepository;
	

	
	@PostMapping(value="addDeveloper")
	public Developer addDeveloper(@RequestBody Developer developer) {
		
		return developerRepository.save(developer);
	}
	
	
	@PutMapping(value="updateDeveloper/{registrationNumber}")
	public Developer upadateDeveloper(@RequestBody Developer developer, @PathVariable Long registrationNumber) {
		Optional<Developer> dev = developerRepository.findByRegistrationNumber(registrationNumber);
		if(dev.isPresent()) {
			Developer newDeveloper = dev.get();
			newDeveloper.setRegistrationNumber(registrationNumber);
			newDeveloper.setName(developer.getName());
			newDeveloper.setLastName(developer.getLastName());
			newDeveloper.setTown(developer.getTown());
			newDeveloper.setEmail(developer.getEmail());
			newDeveloper.setDescription(developer.getDescription());
			return developerRepository.save(newDeveloper);
			
		}
		return addDeveloper(developer);
	}
	
	@DeleteMapping(value="deleteDeveloper/{registrationNumber}")
	public Developer deleteDeveloper(@PathVariable Long registrationNumber) {
		return developerRepository.deleteByRegistrationNumber(registrationNumber); 
		
	}
	
	@GetMapping(value="getDeveloper/{registrationNumber}")
	public Developer getDeveloper(@PathVariable Long registrationNumber) {
		Optional<Developer> dev = developerRepository.findByRegistrationNumber(registrationNumber);
		if(dev.isPresent()) {
			return dev.get();
		}
		return null;
	}
	
	
	@GetMapping(value="getDevelopers/{keyWord}")
	public Page<Developer> getdevelopers(@PathVariable String keyWord){
		
		if( developerComponent.getdevelopers(keyWord) != null) {
			
			return developerComponent.getdevelopers(keyWord);
			}
		return null;
		
	}

}
