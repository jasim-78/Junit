package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class FirstAppApplication {
	@Autowired
	UserRepository Repo;
	@Test
	public void testCreate() {
		User u=new User();
		u.setId(3);
		u.setFirstname("jasim");
		u.setLastname("hussain");
		Repo.save(u);
		asserNotNull(Repo.findById(3).get());	
	}
	private void asserNotNull(User user) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testReadall() {
		List<User> list=Repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	    public void testUpdate() {
	        User user = Repo.findById(4).orElse(null);
	        if (user != null) {
	            user.setFirstname("shree");
	            Repo.save(user);
	            assertNotEquals("jasim", Repo.findById(4).map(User::getFirstname).orElse(null));
	        }
	    }

	    private void assertNotEquals(String string, String orElse) {
		// TODO Auto-generated method stub
		
	}
		@Test
	    public void testDelete() {
	        Repo.deleteById(3);
	        assertThat(Repo.findById(3)).isEmpty();
	    }
	}

	

