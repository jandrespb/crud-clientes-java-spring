package spring.ejemplo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.ejemplo.dao.PersonaDao;
import spring.ejemplo.dominio.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaDao personaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarPersonas() {
		// Convertimos con un Cast nuestro objeto a tipo lista
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional()
	public void guardar(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	@Transactional()
	public void eliminar(Persona persona) {
		personaDao.delete(persona);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Persona encontrarPersona(Persona persona) {
		// Este recibe la llave primaria
		return personaDao.findById(persona.getIdPersona()).orElse(null);
	}

}
