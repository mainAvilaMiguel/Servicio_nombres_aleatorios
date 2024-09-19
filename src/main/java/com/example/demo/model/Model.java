package com.example.demo.model;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    public int generateRandomName(ArrayList<String> arrayName) {
		Random rand = new Random();
		return rand.nextInt(arrayName.size());
	}
	public int generateRandomLastName(ArrayList<String> arrayLastName) {
		Random rand = new Random();
		return rand.nextInt(arrayLastName.size());
	}
}
