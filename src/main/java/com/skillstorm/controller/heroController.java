package com.skillstorm.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.skillstorm.beans.Hero;
import com.skillstorm.service.heroService;



@RestController
@RequestMapping("heroes/v1")
@CrossOrigin("http://localhost:4200")
public class heroController {

	private static final Logger log = Logger.getLogger(heroController.class);
	
	@Autowired
	private heroService service;

	// GET list of heros
	@GetMapping("heroes")
	public ResponseEntity<List<Hero>> findAll(){
	
		log.info("findAll() was called");
		
		return  new ResponseEntity<List<Hero>>(service.findAll(), HttpStatus.OK);
		
	}

	// GET hero by id
	@GetMapping("hero")
	public ResponseEntity<Hero> findHero(@RequestParam(required = true, name = "id") int id) {

		log.info("findHero() was called");

		return new ResponseEntity<Hero>(service.findById(id), HttpStatus.OK);

	}

	// POST new hero
	@PostMapping("newHero")
	public ResponseEntity<Hero> save(@RequestBody Hero hero) {

		log.info("saveHero() was called");
		
		Hero newHero = service.save(hero);

		return new ResponseEntity<>(newHero, HttpStatus.CREATED);

	}
	
	// PUT update hero
	@PutMapping("existingHero")
	public ResponseEntity<Hero> update(@RequestBody Hero hero) {

		log.info("updateHero() was called");
		
		service.update(hero);

		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	//Delete hero
	@DeleteMapping("delete")
	public ResponseEntity<Hero> delete(@RequestParam(required = true, name = "id") int id){
		
		log.info("deleteHero() was called");
		
		service.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	// GET hero by name
	@GetMapping("heroByName")
	public ResponseEntity<List<Hero>> findByName(@RequestParam(required = true, name = "name") String name) {

		log.info("findByName() was called");

		List<Hero> hero = service.findByName(name);

		return new ResponseEntity<List<Hero>>(hero,HttpStatus.OK);
	}

}
