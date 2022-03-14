package Controller;
import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	private Main main;
	@FXML
	private Button btnIngresar;
	@FXML
	private TextField documentTextField;
	
	public void submit(ActionEvent event) throws IOException
	{
		main=new Main();
		main.showMainMenu();
		Stage stage=(Stage) btnIngresar.getScene().getWindow();
		stage.close();
	}
}
