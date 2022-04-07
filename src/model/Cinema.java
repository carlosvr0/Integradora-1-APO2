package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Cinema {
	
	public Cinema() {
		
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
}
