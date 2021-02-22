package com.codeclan.example.pirateservice;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.models.Raid;
import com.codeclan.example.pirateservice.models.Ship;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import com.codeclan.example.pirateservice.repositories.RaidRepository;
import com.codeclan.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
class PirateserviceApplicationTests {

	//Dependency Injection
	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPirateAndShip() {
		Ship ship = new Ship("The Black Pearl");
		shipRepository.save(ship);
		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(jack);
	}

	@Test
	public void addPiratesAndRaids(){
		Ship ship = new Ship("The Black Pearl");
		shipRepository.save(ship);

		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(jack);

		Raid raid1 = new Raid("Tortuga", 100);
		raidRepository.save(raid1);

		raid1.addPirate(jack);
		raidRepository.save(raid1);

	}

}
