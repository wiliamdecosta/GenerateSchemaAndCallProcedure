package com.gscp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gscp.inputs.CreateSchemaInput;
import com.gscp.outputs.CreateSchemaOutput;
import com.gscp.services.CreateSchemaService;

@RestController
@RequestMapping("/schema")
public class SchemaController {
	
	@Autowired
	private CreateSchemaService schemaService;

	@PostMapping("/create")
	public ResponseEntity<CreateSchemaOutput> createSchema(@RequestBody CreateSchemaInput inputSchema) {
		//if an error to call procedure, then check application.properties, it should be like this :
		//spring.datasource.url = jdbc:postgresql://localhost:5433/db_justclick?escapeSyntaxCallMode=callIfNoReturn
		
		CreateSchemaOutput createdSchemaOutput = schemaService.callCreateSchemaProcedure(inputSchema.getSchemaName());
		return ResponseEntity.ok().body(createdSchemaOutput);
	}
}
