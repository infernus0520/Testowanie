package wejsciowka01.sportowcy.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import wejsciowka01.Sportowiec;
import wejsciowka01.SportowiecManager;

public class SportowcyTest {

	@Test
	public void testAdd(){
		SportowiecManager sm = new SportowiecManager();
		Sportowiec sportowiec = new Sportowiec("Lukasz", "Wlodarczyk", 22, "Karate");
		sm.add(sportowiec);
		assertEquals(1,sm.getSportowcy().size());
	}
	
	@Test
	public void testgetAll(){
		SportowiecManager sm = new SportowiecManager();
		Sportowiec sportowiec1 = new Sportowiec("Lukasz", "Wlodarczyk", 21, "Karate");
		Sportowiec sportowiec2 = new Sportowiec("Lukasz", "Wlodarczyk", 20, "Karate");
		sm.add(sportowiec1);
		sm.add(sportowiec2);
		
		assertEquals(20,sm.getAll().get(1).getAge());
		
	}
}


