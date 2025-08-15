// TownController.java
package com.TownTalk.Controller;

import com.TownTalk.DTO.TownDTO;
import com.TownTalk.Entity.Town;
import com.TownTalk.Service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/towns")
public class TownController {
    @Autowired
    private TownService townService;

    @PostMapping
    public Town createTown(@RequestBody TownDTO townDTO) {
        return townService.save(townDTO);
        
    }

    @GetMapping
    public List<Town> getAllTowns() {
        return townService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Town> getTownById(@PathVariable String id) {
    	Town town =townService.findById(id);
        return new ResponseEntity<>(town , HttpStatus.OK);
    }
}
