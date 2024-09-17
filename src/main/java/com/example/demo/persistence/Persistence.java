package com.example.demo.persistence;

import java.io.*;
import java.util.ArrayList;

public class Persistence {
    	public ArrayList<String> readNamesFile() {
		ArrayList<String> namesArray = new ArrayList<String>();
			try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Nombres.txt");

				 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
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
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Apellidos.txt");
			 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
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
