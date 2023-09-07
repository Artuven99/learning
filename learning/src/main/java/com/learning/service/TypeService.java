package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.entities.Type;
import com.learning.repository.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
	TypeRepository repository;
	
	public Type saveType (Type type) {
		if (type.getName()==null)
			throw new RuntimeException("No se puede agregar este nombre");
		return repository.save(type);
	}
	
	public List<Type> getType() {
		return repository.findAll();
	}
	
	public Type getType (Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No se encontro"));
	}
	
	public Type updateType (Long id, Type newType) {
		Type typeToBeUpdated = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tipo no encontrado"));
		typeToBeUpdated.setName(newType.getName());
		return repository.save(typeToBeUpdated);
	}
	
	public String deleteType (Long id) {
		repository.deleteById(id);
		return "Tipo eliminado";
	}

}
