package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Model;
import com.example.demo.persistence.Persistence;
@RestController
public class Controller {
    private Model model;
	private Persistence persistence;
	
	public Controller() {
		persistence = new Persistence();
		model = new Model();
	}
    @GetMapping("/")
	public String run() {
		return "Nombre: "+ this.selectName()+" "+this.selectLastName();
	}
	public String selectLastName(){
		ArrayList<String> lastNamesList = persistence.readLastNamesFile();
		return lastNamesList.get(model.generateRandomLastName(lastNamesList));
	}
	public String selectName(){
		ArrayList<String> namesList = persistence.readNamesFile();
		return namesList.get(model.generateRandomName(namesList));	
	}
}
