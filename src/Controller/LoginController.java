package Controller;
import java.io.IOException;

import application.Main;
import exception.UserNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
	
	private Main main;
	
	@FXML
	private Button btnIngresar;
	@FXML
	private TextField documentTextField;
	
	@FXML
	public void submit(ActionEvent event) throws IOException, UserNotFoundException {
		
		String id = documentTextField.getText();
		
		if(main.canAccess(id)) {
			main.showMainMenu();
			Stage stage=(Stage) btnIngresar.getScene().getWindow();
			stage.close();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Usuario no autorizado");
			alert.setContentText("Debe ingresar un usuario valido");				
			alert.showAndWait();
			//throw new UserNotFoundException();
		}
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
}
