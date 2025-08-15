package com.TownTalk.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.TownTalk.DTO.TownDTO;
import com.TownTalk.Entity.Town;

import com.TownTalk.Repository.TownRepository;


import java.util.List;


@Service
public class TownService {
 @Autowired
 private TownRepository townRepository;

 public Town save(TownDTO townDTO) {
	 Town town=new Town();
	 town.setId(townDTO.getId());
	 town.setBio(townDTO.getBio());
	 town.setLocation(townDTO.getLocation());
	 town.setName(townDTO.getName());
	 town.setPopulation(townDTO.getPopulation());
	 town.setProfilePicture(townDTO.getProfilePicture());
     return townRepository.save(town);
 }

 public List<Town> findAll() {
     return townRepository.findAll();
 }

 public Town findById(String id) {
     return townRepository.findTownById(id);
 }
}
