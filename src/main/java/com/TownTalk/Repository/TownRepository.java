package com.TownTalk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TownTalk.Entity.Town;

public interface TownRepository extends JpaRepository<Town ,Long>{

	@Query(
	        value = "SELECT COUNT(*) FROM post p WHERE p.town_id = :town_Id",
	        nativeQuery = true
	    )
	    long countPostsByTownId(@Param("town_Id") String town_Id);

	@Query(
	        value = "SELECT * FROM town t WHERE t.town_id = :string",
	        nativeQuery = true
	    )
    	Town findTownById(String string);

}
