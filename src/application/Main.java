package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import Controller.RegisterFilmController;
import Controller.RegisterViewerController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Cinema;
import model.CinemaData;
import model.TypeOfRoom;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Cinema cinemaObj;
	
	private RegisterFilmController registerFilmController;
	private RegisterViewerController registerViewerController;
	
	
	//Creo que esto esta mal
	@FXML
	private Stage stageMenu;
	@FXML
	private Stage stageRegisterFilm;
	@FXML
	private Stage stageRegisterViewer;
	@FXML
	private Stage miniRoomStage;
	@FXML
	private Stage mediaRoomStage;
	
	
	public static void main(String[] args) {
		setCinemaObj(new Cinema());
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {

		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../ui/Login.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exit()
	{
		System.exit(0);
	}
	
	 
	//VIEWS-----------------------------------------------------
	public void showMainMenu() throws IOException
	{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainMenu.fxml"));
		Parent p = (Parent) loader.load();
		stageMenu = new Stage();
		Scene scene = new Scene(p);
		stageMenu.setScene(scene);
		stageMenu.show();
	}
	
	public void showRegisterFilm() throws IOException
	{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/RegisterFilm.fxml"));
		Parent p = (Parent) loader.load();
		
		registerFilmController = loader.getController();
		registerFilmController.setMain(this);
		
		stageRegisterFilm= new Stage();
		Scene scene = new Scene(p);
		stageRegisterFilm.setScene(scene);
		stageRegisterFilm.show();
	}
	
	public void showRegisterViewer() throws IOException
	{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/RegisterViewer.fxml"));
		Parent p = (Parent) loader.load();
		
		registerViewerController = loader.getController();
		registerViewerController.setMain(this);
		
		stageRegisterViewer = new Stage();
		Scene scene = new Scene(p);
		stageRegisterViewer.setScene(scene);
		stageRegisterViewer.show();
	}
	
	public void showMiniRoomSeats() throws IOException
	{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MiniRoomSeats.fxml"));
		Parent p = (Parent) loader.load();
		miniRoomStage = new Stage();
		Scene scene = new Scene(p);
		miniRoomStage.setScene(scene);
		miniRoomStage.show();
	}
	
	public void showMediaRoomSeats() throws IOException
	{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MediaRoomSeats.fxml"));
		Parent p = (Parent) loader.load();
		mediaRoomStage = new Stage();
		Scene scene = new Scene(p);
		mediaRoomStage.setScene(scene);
		mediaRoomStage.show();
	}
	
	//OPERATIONS===============================================

	public void addMovie(String name, LocalDate date, LocalTime initTime, LocalTime endTime, TypeOfRoom room) {
		cinemaObj.registerMovie(name, date, initTime, endTime, room);
		System.out.println(CinemaData.movieData);
	}

	public void addSpectator(String name, String id, int posicion) {
		cinemaObj.registerViewer(name, id, posicion);
		printViewer();
	}

	private void printViewer() {
		for(int m = 0; m < CinemaData.spectatorList.size(); m++) {
			System.out.println(CinemaData.spectatorList.get(m).getName());
		}
	}

	public boolean verifyViewer(String codigo, int posicion) {
		if(cinemaObj.isTheSpectatorNew(codigo, posicion)) {
			return true; //es nuevo
		}else {
			return false;
		}
	}

	public boolean checkTime(LocalDate date, TypeOfRoom room, LocalTime initTime, LocalTime endTime) {
		if(cinemaObj.isThereAMovieAtThatTime(date, room, initTime, endTime))
			return true;
					
		return false;
	}

	
	public static void setCinemaObj(Cinema cinemaObj) {
		Main.cinemaObj = cinemaObj;
	}
		

}
