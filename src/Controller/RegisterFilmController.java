package Controller;

import java.time.*;

import application.Main;
import model.*;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterFilmController {

	private Main main;
	
    @FXML
    private TextField movieName;

    @FXML
    private DatePicker movieDate;

    @FXML
    private TextField movieTimeHour;
    
    @FXML
    private TextField movieTimeMin;
    
    @FXML
    private TextField movieEndTimeHour;
    
    @FXML
    private TextField movieEndTimeMin;

    @FXML
    private ComboBox<String> boxMovieRoom;

    @FXML
    private Button btnRegisterMovie;

    @FXML
    private Button btnCancelMovieRegistration;
    
    @FXML
    private TextField durationText;
    
    
    public void initialize()
    {
    	boxMovieRoom.setItems(FXCollections.observableArrayList("Mini Room", "Medium Room"));
    }
    
    @FXML
    public void registrar(ActionEvent event)
    {
    	int hour, hour2, min, min2;
    	LocalTime initTime, endTime;
    	LocalDate date;
    	TypeOfRoom room;
    	try {
    		String name=movieName.getText();
    		hour=Integer.parseInt(movieTimeHour.getText());
    		min=Integer.parseInt(movieTimeMin.getText());
    		hour2=Integer.parseInt(movieEndTimeHour.getText());
    		min2=Integer.parseInt(movieEndTimeMin.getText());
    		initTime=LocalTime.of(hour, min);
    		endTime=LocalTime.of(hour2, min2);
    		date=movieDate.getValue();
    		room = null;
    		if(boxMovieRoom.getValue()=="Mini Room") {
    			room=TypeOfRoom.MINI_ROOM;
    		}else if(boxMovieRoom.getValue()=="Medium Room"){
    			room=TypeOfRoom.MEDIUM_ROOM;
    		}
    		
    		if(initTime.isBefore(endTime) && !(main.checkTime( date, room, initTime, endTime)))
			{
        		
    			main.addMovie(name, date, initTime, endTime, room);
    			Stage stage=(Stage) btnRegisterMovie.getScene().getWindow();
    			stage.close();
    		
    			
			}else {
				Alert a=new Alert(AlertType.ERROR);
				a.setContentText("La hora de inicio debe ser antes de la de fin o ya hay una película registrada a esa hora");
				a.show();
			}
    	}catch(Exception e)
    	{
    		Alert alert=new Alert(AlertType.ERROR);
    		alert.setContentText("Hay un error en los datos ingresados");
    		alert.show();
    	}

    }
    
    
    @FXML
    public void cancelMovieRegistration(ActionEvent event){
    	movieName.setText(null);
    	movieDate.setValue(null);
    	movieTimeHour.setText(null);
    	movieTimeMin.setText(null);
    	movieEndTimeHour.setText(null);
    	movieEndTimeMin.setText(null);
    	boxMovieRoom.setValue(null);
    	
    	Alert cancelAlert =new Alert(AlertType.CONFIRMATION);
    	cancelAlert.setHeaderText("Haz cancelado el registro de la película");
    	cancelAlert.setContentText("¿Deseas regresar al menu?");
    	cancelAlert.showAndWait();
    	
    	if(cancelAlert.getResult() == ButtonType.OK) {
    		Stage stage =(Stage) movieEndTimeMin.getScene().getWindow();
    		stage.close();
		}
    	
    }
    
    
	public void setMain(Main main) {
		this.main = main;
	}
}
