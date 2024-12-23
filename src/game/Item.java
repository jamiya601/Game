package game;

import java.io.Serializable;

public class Item implements Serializable {
	private String name;
	private String description;
	
	public Item(String d) {
		description = d;	
	} 
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setDescription(String d) {
		description = d;
	}
	
	public String toString() {
		return name;
	}
	
	public void open() {
		Game.print("You can't open that!");
	}
	
	public void use() {
		Game.print("You can't use that!");
	}

}
	

