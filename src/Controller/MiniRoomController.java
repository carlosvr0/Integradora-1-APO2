package Controller;

import java.io.IOException;

import application.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.CinemaData;
import model.TypeOfRoom;

public class MiniRoomController {
	
	@FXML
	private GridPane grid;
	
    @FXML
    private Button btn12;

    @FXML
    private Button btn01;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn21;

    @FXML
    private Button btn20;

    @FXML
    private Button btn30;

    @FXML
    private Button btn02;

    @FXML
    private Button btn31;

    @FXML
    private Button btn14;

    @FXML
    private Button btn03;

    @FXML
    private Button btn32;

    @FXML
    private Button btn22;

    @FXML
    private Button btn13;

    @FXML
    private Button btn04;

    @FXML
    private Button btn33;

    @FXML
    private Button btn23;

    @FXML
    private Button btn35;

    @FXML
    private Button btn24;

    @FXML
    private Button btn34;

    @FXML
    private Button btn05;

    @FXML
    private Button btn06;

    @FXML
    private Button btn25;

    @FXML
    private Button btn15;

    @FXML
    private Button btn36;

    @FXML
    private Button btn26;

    @FXML
    private Button btn16;

    @FXML
    private Button btn00;
    
    @FXML
    private Button btnJoker;
    
    @FXML
    private Button btnCancel;
    
    @FXML
    private Pane buttonPane;
    
    
    public void initialize()
    {
    	boolean[][] lista;
    	if(CinemaData.moviesList.get(CinemaData.moviesList.size()-1).getRoom()==TypeOfRoom.MINI_ROOM)
    	{
    		lista=new boolean[4][7];
    		lista=CinemaData.moviesList.get(CinemaData.moviesList.size()-1).getMovieList();
    		String txt="";
    		Button btn=btnJoker;
    		btn.setStyle("-fx-background-radius: 999999; -fx-background-color:  #1A5276;");
    		for(int i=0; i<4; i++)
    		{
    			for(int n=0; n<6; n++)
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
    	}else if(CinemaData.moviesList.get(CinemaData.moviesList.size()-1).getRoom()==TypeOfRoom.MEDIUM_ROOM)
    	{
    		lista=new boolean[6][7];
    	}
    	
    }
    
    public void setSeat(ActionEvent event)
    {
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
		main.showMiniRoomSeats();
    }
    
    public void assignSeat(ActionEvent event)
    {
    	Stage stage=(Stage) btnCancel.getScene().getWindow();
		stage.close();
    }
}
