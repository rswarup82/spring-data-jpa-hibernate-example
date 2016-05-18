package org.springframework.data.jpa.example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
public class BaseEntity extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 6180347997534687629L;

	@Temporal(TemporalType.DATE)
    @Column(name = "CREATEDON")
	protected Date createdOn;
	
	@Column(name = "CREATEDBY", length = 20)
	protected String createdBy;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "MODIFIEDON")
	protected Date modifiedOn;
	
	@Column(name = "MODIFIEDBY", length = 20)
	protected String modifiedBy;
	
	@Column(name = "VERSION")
	private Integer version;
	
	public Long getId() {
		return super.getId();
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@PrePersist
    protected void onCreate() {
        initializeTimestamps();
    }

    public void initializeTimestamps() {
		modifiedOn = createdOn = new Date();
	}

    @PreUpdate
    protected void onUpdate() {
    	modifiedOn = new Date();
    }
}