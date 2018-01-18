package de.propra.projekt7.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, String>{
	public List<Profile> findById(String id);
	
}
