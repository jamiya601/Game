package game;
import java.util.Scanner;

public class NPC {
	private String name;
	private String description;
	
	public NPC(String name, String desc) {
		this.name = name;
		this.description = desc;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDesc(String desc) {
		this.description = desc;
		}
		public void say(String dialog) {
		Game.print(name+": "+dialog);
		}
		public void talk() {
		Game.print("You can't talk to "+name+".");
		}
		public void response(int option) {
		// This method intentionally left blank.
		}
		public void getResponse(String[] options) {
		for(int i=0; i<options.length; i++) {
		Game.print("Option "+(i+1)+": "+options[i]);
		}
		Game.print("Enter an option (1-"+options.length+"):");
		int option = Game.scan.nextInt();
		Game.scan.nextLine(); // Flush input buffer
		response(option);
		}
		}
