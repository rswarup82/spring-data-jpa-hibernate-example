package org.springframework.data.jpa.example.domain;

public enum EStatus {

	ACTIVE("ACTIVE", "Active"),
	INACTIVE("INACTIVE", "Inactive"),
	CERTIFY("CERTIFY", "Certify"),
	PENDING("PENDING", "Pending");
	
	private String code;
	private String description;
	
	EStatus(String code, String description) {
		this.code = code;
		this.description = description;
	}
}
