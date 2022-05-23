package com.example.crud.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.modelo.Persona;
import com.example.crud.servicio.PersonaServicio;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class PersonaRest {
	@Autowired
	private PersonaServicio personaServicio;
	
	@PostMapping
	private ResponseEntity<Void> guardar (@RequestBody Persona persona){
		personaServicio.crea(persona);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/get")
	private ResponseEntity<List<Persona>> listaPersonas (){
		return ResponseEntity.ok(personaServicio.getAllPersonas());
	}
	
	@DeleteMapping("/eliminar")
	private ResponseEntity<Void> eliminarPersona (@RequestBody Persona persona){
		personaServicio.elimina(persona);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/persona")
	private ResponseEntity<Persona> listarPersonasPorID (@RequestParam (value = "id") long id){
		return ResponseEntity.ok(personaServicio.getPersona(id));
	}
	
	@GetMapping("/nombre/{nombre}" )
	private Persona nombre (@ModelAttribute("nombre") String nombre){
		Optional<Persona> personaOp = personaServicio.getPersonaNombre(nombre);
		Persona persona = null;
		if(personaOp.isPresent()){
			persona = personaOp.get();
			return persona;
		}else {
			return null;
		}
	}
}