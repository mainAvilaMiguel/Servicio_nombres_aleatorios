package com.example.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Model;
import com.example.demo.model.Person;
import com.example.demo.persistence.Persistence;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class Controller {
    private Model model;
	private Persistence persistence;
	
	public Controller() {
		persistence = new Persistence();
		model = new Model();
	}
    @GetMapping("/")
	public Person run() throws UnknownHostException {
		String hostName= InetAddress.getLocalHost().getHostName();
		return new Person(LocalDateTime.now(),hostName,this.selectName(),this.selectLastName());
	}
	public String selectLastName(){
		ArrayList<String> lastNamesList = persistence.readLastNamesFile();
		return lastNamesList.get(model.generateRandomLastName(lastNamesList));
	}
	public String selectName(){
		ArrayList<String> namesList = persistence.readNamesFile();
		return namesList.get(model.generateRandomName(namesList));	
	}
	@DeleteMapping
	public Person deletePerson(@RequestBody Person person){
		ArrayList<String> namesList = persistence.readNamesFile();
		ArrayList<String> lastNamesList = persistence.readLastNamesFile();
		if(person.getName()!=null && person.getName()==null ){
			namesList.remove(person.getName());
		if(person.getName()==null && person.getName()!=null ){
			lastNamesList.remove(person.getLastName());
		}if(person.getName()!=null && person.getName()!=null ){
			namesList.remove(person.getName());
			lastNamesList.remove(person.getLastName());
		}
		persistence.writeNamesFile(namesList);
		persistence.writeLastNamesFile(lastNamesList);
	}
		return person;
	}
	@PostMapping()
	public Person addPerson(@RequestBody Person person){
		ArrayList<String> namesList = persistence.readNamesFile();
		ArrayList<String> lastNamesList = persistence.readLastNamesFile();
		if(person.getName()!=null && person.getName()==null ){
			namesList.add(person.getName());
		if(person.getName()==null && person.getName()!=null ){
			lastNamesList.add(person.getLastName());
		}if(person.getName()!=null && person.getName()!=null ){
			namesList.add(person.getName());
			lastNamesList.add(person.getLastName());
		}
		persistence.writeNamesFile(namesList);
		persistence.writeLastNamesFile(lastNamesList);
	}
		return person;
	}
}
