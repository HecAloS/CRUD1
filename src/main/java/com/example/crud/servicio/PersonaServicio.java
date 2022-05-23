package com.example.crud.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.modelo.Persona;
import com.example.crud.repositorio.PersonaRepositorio;

@Service
public class PersonaServicio {
	@Autowired
	PersonaRepositorio personaRepositorio;
	
	/*Metodos del CRUD*/
	/*Create*/
	public void crea(Persona persona) {
		personaRepositorio.save(persona);
	}
	/*Consulta de todas las personas*/
	public List<Persona> getAllPersonas(){
		return personaRepositorio.findAll();
	}
	/*Consulta de una persona*/
	public Persona getPersona(long id){
		return personaRepositorio.getById(id);
	}
	/*Elimina persona*/
	public void elimina (Persona persona) {
		personaRepositorio.delete(persona);
	}
	/*Update*/
	public void actualiza (Persona persona) {
		
	}
	
	/*Consulta de una persona*/
	public Optional<Persona> getPersonaNombre(String nombre){
		return personaRepositorio.findByNombre(nombre);
		
	
	}
}
