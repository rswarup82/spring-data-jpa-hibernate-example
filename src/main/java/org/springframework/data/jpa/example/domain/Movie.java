package org.springframework.data.jpa.example.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="MOVIE")
public class Movie {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "NAME", length = 100, nullable = false)
	private String name;
	
	@Column(name = "RELEASE_DATETIME", nullable = true)
	private DateTime releaseDateTime;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "security", fetch = FetchType.LAZY)
	private List<Actor> actors;
	
	//Be Happy
	public Movie() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTime getReleaseDateTime() {
		return releaseDateTime;
	}

	public void setReleaseDateTime(DateTime releaseDateTime) {
		this.releaseDateTime = releaseDateTime;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
}