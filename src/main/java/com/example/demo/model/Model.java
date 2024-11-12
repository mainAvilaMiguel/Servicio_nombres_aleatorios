package com.example.demo.model;

import com.example.demo.exception.InvalidRangeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Model {
	private static final Logger logger = LoggerFactory.getLogger(Model.class);
    public int generateRandomName(ArrayList<String> arrayName) {
		Random rand = new Random();
		return rand.nextInt(arrayName.size());
	}
	public int generateRandomLastName(ArrayList<String> arrayLastName) {
		Random rand = new Random();
		return rand.nextInt(arrayLastName.size());
	}
	public double division(double numerator, double denominator){
		if(denominator==0) {
			logger.error(" Metodo division");
		}
		return numerator/denominator;
	}
}
