package com.example.restservicedemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.PersonManager;

public class BLTest {

	PersonManager pm = new PersonManager();
	int size;
	

	@Test
	public void addPerson() {
		
		size = pm.getAllPersons().size();
		
		Person p1 = new Person();
		p1.setFirstName("Nowak");
		p1.setYob(1987);
		pm.addPerson(p1);
		
		assertEquals(size,pm.getAllPersons().size()-1);
	}
	
	@Test
	public void addCar() {
		
		size = pm.getAllCars().size();
		
		Car c1 = new Car();
		c1.setModel("Skoda");
		c1.setYop(2013);
		pm.addCar(c1);
		
		assertEquals(size,pm.getAllCars().size()-1);
	}
	
	@Test 
	public void DeleteAllPersons() {
		Person p1 = new Person();
		p1.setFirstName("Niemiec");
		p1.setYob(2000);

		Person p2 = new Person();
		p2.setFirstName("Polak");
		p2.setYob(1999);
		
		pm.addPerson(p1);
		pm.addPerson(p2);
		
		size = pm.getAllCars().size();
		
		pm.clearPersons();
		
		assertTrue(size != pm.getAllPersons().size());;
	}
	@Test
	public void checkGetAllPersons() {
		Person p1 = new Person();
		p1.setFirstName("Zieliński");
		p1.setYob(1978);

		Person p2 = new Person();
		p2.setFirstName("Kowalski");
		p2.setYob(1978);
		
		pm.addPerson(p1);
		pm.addPerson(p2);
		
		assertTrue(pm.getAllPersons().size() > 0);
	}
	


	@Test
	public void checkGetAllCars() {
		
		Car c1 = new Car();
		c1.setModel("Opel");
		c1.setYop(2003);

		Car c2 = new Car();
		c2.setModel("Fiat");
		c2.setYop(1989);
		
		pm.addCar(c1);
		pm.addCar(c2);
		
		assertTrue(pm.getAllCars().size() > 0);
	}
	
	@Test
	public void checkCarAdding() {

		Car c = new Car();
		c.setModel("Syrena");
		c.setYop(1973);

		assertEquals(1, pm.addCar(c));
	}

	@Test
	public void checkSell() {

		Car c1 = new Car();
		c1.setModel("Syrena");
		c1.setYop(1973);

		Car c2 = new Car();
		c2.setModel("Fiat Punto");
		c2.setYop(1999);

		assertEquals(1, pm.addCar(c1));
		assertEquals(1, pm.addCar(c2));

		List<Car> cars = pm.getAllCars();

		assertTrue(cars.size() > 0);

		Car carToSell = cars.get(1);

		Person p1 = new Person();
		p1.setFirstName("Zieliński");
		p1.setYob(1978);

		Person p2 = new Person();
		p2.setFirstName("Kowalski");
		p2.setYob(1978);

		assertEquals(1, pm.addPerson(p1));
		assertEquals(1, pm.addPerson(p2));

		List<Person> persons = pm.getAllPersons();

		assertTrue(persons.size() > 1);

		Person owner = persons.get(1);
		
		
		pm.sellCar(carToSell, owner);
		
		Car rCar = pm.getCarWithOwner(carToSell);
		
		assertEquals(owner.getFirstName(), rCar.getOwner().getFirstName());

	}


}
