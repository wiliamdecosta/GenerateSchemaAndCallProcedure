package com.gscp.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedStoredProcedureQuery(name = "jc.schemacreate",
procedureName = "p_create_schema",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name="schemaName", type=String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name="outMessage", type=String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name="isSuccess", type=Boolean.class)
})
@Table(name = "schema_created_log")

public class SchemaCreatedLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name_of_schema", length=100, nullable = false)
	private String schemaName;
	
	@Column(name = "description", length=255, nullable = false)
	private String description;
	
	@Column(name="created_at", nullable = false)
	private LocalDateTime createdAt;
	
	@Column(name="status", length=100, nullable = false)
	private String status;
}
