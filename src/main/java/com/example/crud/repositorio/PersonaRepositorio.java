package com.example.crud.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.modelo.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long>{

	 public Optional<Persona> findByNombre(String nombre);
}
