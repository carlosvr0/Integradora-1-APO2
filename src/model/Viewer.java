package model;

public class Viewer {
	
	private String name;
	private String id; //Codigo 
	private String movieName;
	
	public Viewer(String name, String id, String movieName) {
		this.name = name;
		this.id = id;
		this.setMovieName(movieName);
	}

	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
}
