package org.springframework.data.jpa.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GLBSTATUS")
public class Status extends BaseEntity {

	private static final long serialVersionUID = -7598668099163425210L;

	@Id
    @Column(name = "CODE")
	private String code;
	
	@Column(name = "DESCRIPTION", length = 100)
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
