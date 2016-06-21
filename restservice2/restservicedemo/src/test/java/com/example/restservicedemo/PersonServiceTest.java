package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;

public class PersonServiceTest {
	
	private static final String PERSON_FIRST_NAME = "Jasiu";
	
	@BeforeClass
    public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";   	
    }
	
	@Test
	public void addPersons(){		
		
		delete("/person/").then().assertThat().statusCode(200);
		
		Person person = new Person(1L, PERSON_FIRST_NAME, 1976);
		
		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(person).
	    when().	     
	    post("/person/").then().assertThat().statusCode(201);
				
		Person rPerson = get("/person/1").as(Person.class);
		
		//assertThat(PERSON_FIRST_NAME, equalToIgnoringCase(rPerson.getFirstName()));
		
	}
	
	
	@Test
    public void getCarsById() {


        Car c1 = new Car(0, "Opel", 2000);
        given().
                contentType(MediaType.APPLICATION_JSON).
                body(c1).
                when().
                post("/car/").then().assertThat().statusCode(201);

        Car c2 = new Car(1, "Skoda", 2010);
        given().
                contentType(MediaType.APPLICATION_JSON).
                body(c2).
                when().
                post("/car/").then().assertThat().statusCode(201);

        Car c3 = new Car(2, "Jaguar", 2008);
        given().
                contentType(MediaType.APPLICATION_JSON).
                body(c3).
                when().
                post("/car/").then().assertThat().statusCode(201);

        JSONArray obj = null;
        try {
           obj = new JSONArray(get("/car/0").prettyPrint());
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < obj.length(); i++) {
            try {
                try {
                    Car r = mapper.readValue(obj.get(i).toString(), Car.class);
                    list.add(r);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                	
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        assertThat(list.size(), is(equalTo(2)));
        assertThat(list.get(0).getModel(), is(equalTo("Opel")));
        assertThat(list.get(1).getModel(), is(equalTo("Skoda")));
	
	}
	

	@Test
		public void getGame(){

		    Person person = new Person(1L, PERSON_FIRST_NAME, 1976);
		    
			given().
					contentType(MediaType.APPLICATION_JSON).
					body(person).
			when().
					post("/person/").
			then().
					assertThat().statusCode(201);

			given().
					contentType(MediaType.APPLICATION_JSON).
			when().
					get("/person/0").
			then().
					body("id", equalTo(1L)).
					body("firstName", equalTo(PERSON_FIRST_NAME)).
					body("yob", equalTo(1976)).
					statusCode(200);
	}
	
}
