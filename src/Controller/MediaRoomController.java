package Controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.CinemaData;
import model.TypeOfRoom;

public class MediaRoomController {

    @FXML
    private Button btnJoker;

    @FXML
    private Button btnReservarSelectedSeat;

    @FXML
    private Button btnCancel;
    
    @FXML
    private GridPane grid;
    
    @FXML
    private Pane buttonPane;

    @FXML
    public void initialize()
    {
    	boolean[][] lista;
		lista=new boolean[6][7];
		lista=CinemaData.moviesList.get(CinemaData.moviesList.size()-1).getMovieList();
		String txt="";
		Button btn=btnJoker;
		btn.setStyle("-fx-background-radius: 999999; -fx-background-color:  #1A5276;");
		for(int i=0; i<6; i++)
		{
			for(int n=0; n<7; n++)
			{
				if(lista[i][n]==true)
				{
					txt+=String.valueOf(i);
					txt+=String.valueOf(n);
					btn.setText(txt);
					btn.setDisable(true);
					grid.getChildren().remove(n, i);
					grid.add(btn, n, i);
					
				}
				txt="";
			}
    	}
    }
    
    @FXML
    void setSeat(ActionEvent event) {
    	Button btn=(Button) event.getTarget();
    	int x=Integer.parseInt(String.valueOf(btn.getText().charAt(0)));
    	int y=Integer.parseInt(String.valueOf(btn.getText().charAt(1)));
    	CinemaData.moviesList.get(CinemaData.moviesList.size()-1).setSeatCoordinates(x, y);
    	CinemaData.moviesList.get(CinemaData.moviesList.size()-1).setLastX(x);
    	CinemaData.moviesList.get(CinemaData.moviesList.size()-1).setLastY(y);
    	grid.getChildren().remove(btn);
    	btn.setStyle("-fx-background-radius: 999999; -fx-background-color: #F39C12;"); 
    	grid.add(btn, y, x);
    	buttonPane.setDisable(true);
    	buttonPane.setOpacity(1);
    	System.out.println(x+"  "+y);
    }
    
    public void cancelSelection(ActionEvent event) throws IOException
    {
    	int x=CinemaData.moviesList.get(CinemaData.moviesList.size()-1).getLastX();
    	int y=CinemaData.moviesList.get(CinemaData.moviesList.size()-1).getLastY();
    	CinemaData.moviesList.get(CinemaData.moviesList.size()-1).resetSeat(x, y);
    	Stage stage=(Stage) btnCancel.getScene().getWindow();
		stage.close();
		Main main=new Main();
		main.showMediaRoomSeats();
    }
    
    public void assignSeat(ActionEvent event)
    {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
    }
    
}
