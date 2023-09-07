package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entities.Type;
import com.learning.service.TypeService;

@RestController
@RequestMapping("type")
public class TypeController {
	
	@Autowired
	TypeService service;
	
	@PostMapping()
	public Type createType(@RequestBody Type type) {
		return service.saveType(type);
	}
	
	@GetMapping
	public List<Type> getType(){
		return service.getType();
	}
	
	@GetMapping("/{id}")
	public Type getType(@PathVariable("id") Long id) {
		return service.getType(id);
	}
	
	@PutMapping("/{id}")
	public Type updateType(@PathVariable("id") Long id, @RequestBody Type type) {
		return service.updateType(id, type);
	}
	
	@DeleteMapping("/{id}")
	public String deleteType(@PathVariable("id") Long id) {
		return service.deleteType(id);
	}

}
