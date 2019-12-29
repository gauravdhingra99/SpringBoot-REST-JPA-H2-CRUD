package com.gaurav.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gaurav.demo.model.Alien;

//import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

//	List<Alien> findByTech(String tech);
//	
//	@Query("from Alien where tech=?1 order by aname")
//	List<Alien> findByTechSorted(String tech);
	

}
