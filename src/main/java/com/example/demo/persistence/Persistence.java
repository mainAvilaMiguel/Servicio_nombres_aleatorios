package com.example.demo.persistence;

import java.io.*;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	@PostMapping("/name")
	public void writeNamesFile(@RequestBody ArrayList<String> names) {
		String nameRoute =System.getProperty("user.dir")+"/Libraries/Nombres.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nameRoute, false))){
				for (String name : names) {
				bw.write(name);
				bw.newLine();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@PostMapping("/lastName")
	public void writeLastNamesFile(@RequestBody ArrayList<String> lastNames) {
		String lastNamesRoute = System.getProperty("user.dir")+"/Libraries/Apellidos.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(lastNamesRoute, false))){
				for (String lastName : lastNames) {
				bw.write(lastName);
				bw.newLine();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
