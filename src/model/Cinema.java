package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//import exception.UserNotFoundException;

public class Cinema {
	
	static String PathPasswords = "docs\\passwords.txt";
	static String PathToReport = ".\\files\\reporte.txt";
	static List<UsersData> passwords;
	
	
	public Cinema() {
		passwords = new ArrayList<>();
	}
	
	
	public void cargarData() throws IOException { 
		File file = new File(PathPasswords); 
		FileReader fr = new FileReader(file);
		BufferedReader input = new BufferedReader(fr);
		input.readLine();

		while (input.ready()) {
			String line = input.readLine();

			addPsswrd(line);
		}

		input.close();
		fr.close();
	}
	
	public void addPsswrd(String contra) {
		passwords.add(new UsersData(contra));
	}
	
	public boolean isTheUserExists(String contra) {
		
		for(int m = 0; m < passwords.size(); m++) {
			if(passwords.get(m).getPasswords().equals(contra)) {
				return true;
			}
		}
		return false;
	}
	
	public void registerMovie(String name, LocalDate date, LocalTime initTime, LocalTime endTime, TypeOfRoom room) {
		Movie newMovie = new Movie(name, date, initTime, endTime, room);
		CinemaData.movieData.add(newMovie);
		CinemaData.moviesList.add(newMovie);
	}
	
	public void registerViewer(String name, String id, int posicion) {
		String movie = CinemaData.moviesList.get(posicion).getName();
		Viewer newViewer = new Viewer(name, id, movie);
		CinemaData.spectatorList.add(newViewer);
	}
	
	public boolean isTheSpectatorNew(String codigo, int posicion) {
		String movie = CinemaData.moviesList.get(posicion).getName();
		
		for(int m = 0; m < CinemaData.spectatorList.size(); m++) {
			if(codigo.equalsIgnoreCase(CinemaData.spectatorList.get(m).getId()) && movie.equalsIgnoreCase(CinemaData.spectatorList.get(m).getMovieName())) {
				return false; // NO es nuevo el espectador
			}
		}
		return true;//SI es nuevo el espectador
	}
	
	public boolean isThereAMovieAtThatTime(LocalDate date, TypeOfRoom room, LocalTime initTime, LocalTime endTime) {
		
		for(int m = 0; m < CinemaData.moviesList.size(); m++) {
			if(date.equals(CinemaData.moviesList.get(m).getDate()) && room.equals(CinemaData.moviesList.get(m).getRoom())) {
				if((initTime.equals(CinemaData.moviesList.get(m).getInitTime()) || (initTime.isAfter(CinemaData.moviesList.get(m).getInitTime()) && 
					initTime.isBefore(CinemaData.moviesList.get(m).getInitTime()))) || (endTime.equals(CinemaData.moviesList.get(m).getEndTime()) ||
					(endTime.isAfter(CinemaData.moviesList.get(m).getInitTime()) && endTime.isBefore(CinemaData.moviesList.get(m).getEndTime())))){
					return true; ///si hay una pelicula a esa hora
				}		
			}
		}
		
		return false;//no hay una pelicula a esa hora
	}
	
	
	public String writeReport() {
		String info = "";
		
		info += "==================================\n"; 
		info += "			CINE BIENESTAR			\n";
		info += "==================================\n";
		
		for(int m = 0; m < CinemaData.moviesList.size(); m++) {
			info += m+1 + ". " + CinemaData.moviesList.get(m).toString() + "\n";
			
			for(int n = 0; n < CinemaData.spectatorList.size(); n++) {
				info += "	" + CinemaData.spectatorList.get(n).toString() + "\n";
			}
		}
		
		return info;
	}
	
	public void makeReport(String report) throws IOException {
		File file = new File(PathToReport);
		FileWriter fw = new FileWriter(file);
		
		BufferedWriter output = new BufferedWriter(fw);
		output.write(report);
		
		output.newLine();
		output.close();
		fw.close();
	}
	
	
}
