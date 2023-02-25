package com.taller.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taller.spring.entity.Client;

/**
 * @author Eva
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	/**
	 * Busca clientes por nombre y apellidos
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 */
	Client findByNameAndSurname1AndSurname2(String name, String surname1, String surname2);

	/**
	 * Busca clientes por su username.
	 * 
	 * @param username
	 */
	Client findByUsername(String username);

	/**
	 * Busca el usuario y contraseña
	 * 
	 * @param username
	 * @param password
	 */

	Client findByUsernameAndPassword(String username, String password);
	
	/**
	 * Busca el usuario y el rol
	 * 
	 * @param username
	 * @param rol
	 */

	Client findByRol(String username);

}
