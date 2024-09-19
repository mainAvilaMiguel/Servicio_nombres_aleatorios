package com.example.demo.persistence;

import java.io.*;
import java.util.ArrayList;

public class Persistence {
    	public ArrayList<String> readNamesFile() {
		ArrayList<String> namesArray = new ArrayList<String>();
		String nameRoute =System.getProperty("user.dir")+"/Libraries/Nombres.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(nameRoute))){
				 String linea;
			while ((linea = br.readLine()) !=null) {
				namesArray.add(linea);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namesArray;
	}
	public ArrayList<String> readLastNamesFile() {
		ArrayList<String> lastNames = new ArrayList<String>();
		String lastNamesRoute = System.getProperty("user.dir")+"/Libraries/Apellidos.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(lastNamesRoute))){
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
