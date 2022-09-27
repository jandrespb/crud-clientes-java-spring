package spring.ejemplo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.ejemplo.dominio.Usuario;



public interface UsuarioDao extends JpaRepository<Usuario, Long>{

	Usuario findByUsername(String username);
}
