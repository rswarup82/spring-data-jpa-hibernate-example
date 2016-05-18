package org.springframework.data.jpa.example.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@MappedSuperclass
abstract public class AbstractEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 2007145887951677618L;
	
	@Version
    @Column(name = "LCKG_VER_NUM", nullable = true, length = 5)
    private int version;

    @Column(name = "CRT_TS", nullable = true)
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime created;

    @Column(name = "CHG_TS", nullable = true)
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime updated;

    @PrePersist
    protected void onCreate() {
        initializeTimestamps();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new DateTime();
    }

    public void initializeTimestamps() {
        updated = created = new DateTime();
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}