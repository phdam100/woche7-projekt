package de.propra.projekt7.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, String>{
	public List<Profile> findByUsername(String id);
	
}
