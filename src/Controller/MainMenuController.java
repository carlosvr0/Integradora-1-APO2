package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import java.io.IOException;

import application.Main;

public class MainMenuController {
	private Main main;
	
	@FXML
	public void registerFilm(ActionEvent event) throws IOException
	{
		main.showRegisterFilm();
	}
	
	@FXML
	public void registerViewer(ActionEvent event) throws IOException
	{
		main.showRegisterViewer();
	}
	
	@FXML
	public void logOut(ActionEvent event)
	{
		main.exit();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
}
