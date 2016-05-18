package org.springframework.data.jpa.example.domain;

public enum ESecurityType {

	BASICAUTH("BASICAUTH", "BasicAuth"),
	CERTIFICATE("CERTIFICATE", "Certificate");

	private String code;
	private String description;
	
	ESecurityType(String code, String description) {
		this.code = code;
		this.description = description;
	}
}
