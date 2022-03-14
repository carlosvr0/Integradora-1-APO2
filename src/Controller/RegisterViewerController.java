package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.CinemaData;
import model.Movie;
import model.TypeOfRoom;

public class RegisterViewerController {
	
	private Main main;
	
	@FXML
	private TableView<Movie> moviesTable;
	@FXML
	private TableColumn<Movie, String> nameColumn;
	@FXML
	private TableColumn<Movie, LocalDate> releaseDateColumn;
	@FXML
	private TableColumn<Movie, LocalTime> startTimeCollumn;
	@FXML
	private TableColumn<Movie, LocalTime> endTimeColumn;
	@FXML
	private TableColumn<Movie, TypeOfRoom> roomColumn;
	
	@FXML
	private Pane boxToRegisterViewer;
	@FXML
	private TextField viewerName;
	@FXML
	private TextField viewerID;
	
	public void initialize() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<Movie, String>("name"));
		releaseDateColumn.setCellValueFactory(new PropertyValueFactory<Movie, LocalDate>("date"));
		startTimeCollumn.setCellValueFactory(new PropertyValueFactory<Movie, LocalTime>("initTime"));
		endTimeColumn.setCellValueFactory(new PropertyValueFactory<Movie, LocalTime>("endTime"));
		roomColumn.setCellValueFactory(new PropertyValueFactory<Movie, TypeOfRoom>("room"));
		
		moviesTable.setItems(CinemaData.movieData);
	}
	
	@FXML
	public void allowRegisterViewer(ActionEvent event) {
		if(moviesTable.getSelectionModel().getSelectedIndex() != -1) {
			boxToRegisterViewer.setDisable(false);
		}
	}
	
	@FXML
	public void addViewer(ActionEvent event) throws IOException {
		if(isTheViewerNew()) {
			String name = viewerName.getText();
			String id = viewerID.getText();
			int posicion = moviesTable.getSelectionModel().getSelectedIndex();  
			main=new Main();
			if(moviesTable.getSelectionModel().getSelectedItem().getRoom()==TypeOfRoom.MINI_ROOM)
			{
				main.showMiniRoomSeats();
			}
			else if(moviesTable.getSelectionModel().getSelectedItem().getRoom()==TypeOfRoom.MEDIUM_ROOM)
			{
				main.showMediaRoomSeats();
			}
			
			
			//main.addSpectator(name, id, posicion);
			/*
				Alert viewerRegistered = new Alert(AlertType.CONFIRMATION);
				viewerRegistered.setHeaderText("Espectador registrado exitosamente");  lo pongo así pq no vamos registrar a alguien antes de guardar su asiento.
				viewerRegistered.setContentText("¿Deseas agregar otro espectador?");
				viewerRegistered.showAndWait();
	
			if(viewerRegistered.getResult() == ButtonType.OK) {
				viewerName.setText(null);
				viewerID.setText(null);
			}else {
				Stage stage =(Stage) boxToRegisterViewer.getScene().getWindow();
	    		stage.close();
			}
			
		}else {
			Alert viewerExistenteAlert = new Alert(AlertType.ERROR);
			viewerExistenteAlert.setContentText("El espectador ya cuenta con un asiento para esa película");
			viewerExistenteAlert.show();
		*/
		}
		
	}
	
	public boolean isTheViewerNew() {
		String codigo = viewerID.getText();
		int posicion = moviesTable.getSelectionModel().getSelectedIndex();
		if(!main.verifyViewer(codigo, posicion)) {
			return false;
		}
		return true;
	}
	
	
	public void setMain(Main main) {
		this.main = main;
	}
	
}
