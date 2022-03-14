package model;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CinemaData {
	
	public static ObservableList<Movie> movieData=FXCollections.observableArrayList(); //peliculas
	
	public static List<Movie> moviesList = new ArrayList<>(); 
	public static List<Viewer> spectatorList = new  ArrayList<>(); 
	
}
