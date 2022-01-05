package com.skillstorm.beans;


import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "heros")
public class Hero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="damage")
	private Integer damage;
	
	@Column(name ="shield")
	private Integer shield;
	
	@Column(name ="stamina")
	private Integer stamina;
	
	@Column(name ="superpower")
	private String superpower;
	
	public Hero() {
		super();
	}

	public Hero(Integer id, String name, Integer damage, Integer shield, Integer stamina, String superpower) {
		super();
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.shield = shield;
		this.stamina = stamina;
		this.superpower = superpower;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	public Integer getShield() {
		return shield;
	}

	public void setShield(Integer shield) {
		this.shield = shield;
	}

	public Integer getStamina() {
		return stamina;
	}

	public void setStamina(Integer stamina) {
		this.stamina = stamina;
	}

	public String getSuperpower() {
		return superpower;
	}

	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}

	@Override
	public int hashCode() {
		return Objects.hash(damage, id, name, shield, stamina, superpower);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		return Objects.equals(damage, other.damage) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(shield, other.shield) && Objects.equals(stamina, other.stamina)
				&& Objects.equals(superpower, other.superpower);
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", damage=" + damage + ", shield=" + shield + ", stamina="
				+ stamina + ", superpower=" + superpower + "]";
	}

	
	
	
	
}