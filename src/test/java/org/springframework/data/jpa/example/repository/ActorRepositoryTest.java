package org.springframework.data.jpa.example.repository;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.example.domain.Actor;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ActorRepositoryTest extends BaseIntegrationTest {

	@Autowired
	private ActorRepository actorRespository;
	
	@Before
	public void setup() {
		Actor actor = new Actor();
		actor.setFirstName("TOM");
		actor.setLastName("HANKS");
		actor.setAge(49);
			
		actorRespository.save(actor);
		
		actor = new Actor();
		actor.setFirstName("JENNIFER");
		actor.setLastName("LOPEZ");
		actor.setAge(43);
		
		actorRespository.save(actor);
	}
	
	@After
	public void tiredown() {
		actorRespository.deleteAll();
	}

	@Test
	public void testActorCount() {
		assertEquals(2, actorRespository.findAll().size());
	}
	
	@Test
	public void testGetByFirstName() {
		Actor actor = actorRespository.getByFirstName("TOM");
		assertNotNull(actor);
		assertEquals("TOM", actor.getFirstName());
		assertEquals("HANKS", actor.getLastName());
	}
	
	@Test
	public void testGetByLastName() {
		Actor actor = actorRespository.getByLastName("LOPEZ");
		assertNotNull(actor);
		assertEquals("JENNIFER", actor.getFirstName());
		assertEquals("LOPEZ", actor.getLastName());
	}
}