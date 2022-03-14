package model;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Movie {
	private String name;
	private LocalDate date;
	private LocalTime initTime;
	private LocalTime endTime;
	private TypeOfRoom room;
	private boolean[][] seats;
	private int lastX, lastY;
	
	public Movie(String name, LocalDate date, LocalTime initTime, LocalTime endTime, TypeOfRoom room)
	{
		this.name=name;
		this.date=date;
		this.setInitTime(initTime);
		this.setEndTime(endTime);
		this.room=room;
		if(this.room==TypeOfRoom.MINI_ROOM)
		{
			seats=new boolean[4][7];
			for(int i=0; i<4; i++)
			{
				for(int n=0; n<7; n++)
				{
					seats[i][n]=false;
				}
			}
		}
		else if(this.room==TypeOfRoom.MEDIUM_ROOM)
		{
			seats=new boolean[6][7];
			for(int i=0; i<6; i++)
			{
				for(int n=0; n<7; n++)
				{
					seats[i][n]=false;
				}
			}
		}
	}
	
	public void setSeatCoordinates(int x, int y)
	{
		seats[x][y]=true;
	}
	
	public boolean[][] getMovieList()
	{	
		return seats;
	}
	
	public void resetSeat(int x, int y)
	{
		seats[x][y]=false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public TypeOfRoom getRoom() {
		return room;
	}
	public void setRoom(TypeOfRoom room) {
		this.room = room;
	}

	public LocalTime getInitTime() {
		return initTime;
	}

	public void setInitTime(LocalTime initTime) {
		this.initTime = initTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public int getLastX() {
		return lastX;
	}

	public void setLastX(int lastX) {
		this.lastX = lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public void setLastY(int lastY) {
		this.lastY = lastY;
	}
	
	
}
