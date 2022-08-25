package com.gscp.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gscp.outputs.CreateSchemaOutput;
import com.gscp.repositories.SchemaRepository;

@Service
public class CreateSchemaService {
	@Autowired
	private SchemaRepository schemaRepo;
	
	public CreateSchemaOutput callCreateSchemaProcedure(String schemaName) {
		Map<String, Object> outputParam =  schemaRepo.callCreateSchemaProcedure(schemaName);
		CreateSchemaOutput createdSchemaOutput = new CreateSchemaOutput();
		
		outputParam.forEach((k, v) -> {
			if(k.compareTo("outMessage") == 0) {
				System.err.println(v);
				createdSchemaOutput.setMessage((String) v);
			}
			
			if(k.compareTo("isSuccess") == 0) {
				System.err.println(v);
				createdSchemaOutput.setSuccess((boolean)v);
			}
		});
		
		return createdSchemaOutput;
	}
}
