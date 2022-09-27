package spring.ejemplo.servicio;

import java.util.List;

import spring.ejemplo.dominio.Persona;

public interface PersonaService {
	
	public List<Persona> listarPersonas();
	
	// Methods CRUD person
	public void guardar (Persona persona);
	public void eliminar(Persona persona);
	public Persona encontrarPersona(Persona persona);

}
