package de.propra.projekt7.repositories;

import org.springframework.data.repository.CrudRepository;

import entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, String>{
	public Profile findByUsername(String id);
	
}
