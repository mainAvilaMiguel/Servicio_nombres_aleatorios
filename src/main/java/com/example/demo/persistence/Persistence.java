package com.example.demo.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Persistence {
    	public ArrayList<String> readNamesFile() {
		ArrayList<String> namesArray = new ArrayList<String>();
		String ruta = "src\\main\\resources\\Nombres.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea;
			while ((linea = br.readLine()) != null) {
				namesArray.add(linea);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namesArray;
	}
	public ArrayList<String> readLastNamesFile() {
		String ruta = "src\\main\\resources\\Apellidos.txt";
		ArrayList<String> lastNames = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea;
			while ((linea = br.readLine()) != null) {
				lastNames.add(linea);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lastNames;
	}
}
