package game;

public class Item {
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

}
	

