package br.com.viacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.viacep.service.ViaCepService;

@RestController
@RequestMapping("api")
public class ViaCepController {

	@Autowired
	private ViaCepService service;

	@GetMapping("{zipCode}")
	public ResponseEntity<Object> consumer(@PathVariable String zipCode, @RequestParam long idFormat) {
		return ResponseEntity.ok(service.consumer(zipCode, idFormat));
	}
	
}
