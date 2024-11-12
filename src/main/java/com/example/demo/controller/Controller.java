package com.example.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Model;
import com.example.demo.model.Person;
import com.example.demo.persistence.Persistence;


@RestController
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
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
	@GetMapping("/division")
	public String division(@RequestParam int numerator, @RequestParam int divisor){
			logger.info("doing the division with parameters: numerator = {}, denominator = {}", numerator, divisor);
			return "Resultado: "+model.division(numerator,divisor);
    }
}

