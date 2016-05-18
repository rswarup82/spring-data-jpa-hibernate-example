package org.springframework.data.jpa.example.repository;

import org.springframework.data.jpa.example.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaSpecificationExecutor<Actor>, JpaRepository<Actor, Long> {

	@Query("select actor from Actor actor where actor.firstName = ?1")
	public Actor getByFirstName(String firstName);
	
	@Query("select actor from Actor actor where actor.lastName = ?1")
	public Actor getByLastName(String lastName);
}
