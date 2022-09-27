package spring.ejemplo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import spring.ejemplo.dominio.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long> {

	
}
