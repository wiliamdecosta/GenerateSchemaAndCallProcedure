package com.gscp.repositories;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.gscp.entities.SchemaCreatedLog;

public interface SchemaRepository extends JpaRepository<SchemaCreatedLog, Integer> {
	
	@Procedure(name="jc.schemacreate")
	Map<String, Object> callCreateSchemaProcedure(String schemaName);
}
