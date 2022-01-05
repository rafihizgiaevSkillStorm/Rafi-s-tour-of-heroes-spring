package com.skillstorm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skillstorm.beans.Hero;
import com.skillstorm.data.heroRepository;

@Service
public class heroService {
	
	@Autowired
	heroRepository repository;

    public List<Hero> findAll() {
	
		return repository.findAll();
	}

	public Hero save(Hero hero) {

		return repository.save(hero);
	}

	public void update(Hero hero) {
	
		repository.updateHero(hero.getId(), hero.getName(), hero.getDamage(), hero.getShield(), hero.getStamina(), hero.getSuperpower());
	}

	public Hero findById(int id) {
		
		return repository.findById(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public List<Hero> findByName(String name) {
		return repository.findByNameStartsWithIgnoreCase(name);	
	}

}
