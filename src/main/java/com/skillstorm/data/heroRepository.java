package com.skillstorm.data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.skillstorm.beans.Hero;

@Repository
public interface heroRepository extends JpaRepository<Hero, Integer> {

	@Query(value = "select * from heros", nativeQuery = true)
	public List<Hero> findAll();
	
	public Hero save(Hero hero);

	@Transactional
	@Modifying
	@Query(value ="Update heros set heros.name = ?2, heros.damage = ?3, heros.shield = ?4, heros.stamina = ?5, heros.superpower = ?6 where heros.id = ?1", nativeQuery = true)
	public void updateHero(int id, String name, Integer damage, Integer shield, Integer stamina, String superpower);

	@Query(value = "select * from heros where id = ?1", nativeQuery = true)
	public Hero findById(int id);

	public List<Hero> findByNameStartsWithIgnoreCase(String name);

}
