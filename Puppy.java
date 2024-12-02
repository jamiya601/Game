package game;

public class Puppy extends NPC {
	
	private int talk = 0;

	public Puppy(String name, String desc) {
		super("Puppy", "An adorable puppy!");
	}
	
	@Override
	public void talk() {
		talk++;
		switch(talk) {
			case 1: // Dialog 1
				say("Hi! I'm an adorable puppy!");
				String[] options = {
					"Yes you are! Who's a good boy?",
					"Ew, no. You're actually kinda hideous."
				};
				getResponse(options);
				break;
				
			case 2: // Dialog 2
				say("Hey! Wanna play fetch? Say yes! Say yes!");
				String[] options2 = {
					"Yes! I love fetch!",
					"No. I am a horrible person and don't like playing with puppies."
				};
				getResponse(options2);
				break;
				
			case 3: // Dialog 3
				say("Yip!");
				break;
		}
		talk++;
	}
	
	@Override
	public void response(int option) {
		switch(talk) {
			case 1: // Response 1
				switch(option) {
					case 1:
						say("I am! I'm a good boy!");
						break;
					case 2:
						say("I am adorable! Why are you so mean?");
						Game.print("The puppy bites you. You deserve it.");
						break;
						
					default:
						say("Yip!");
						break;
				}
				break;
				
			case 2: // Response 2
				switch(option) {
					case 1:
						say("Yay! Fetch!");
						Game.print("The puppy runs off and returns with a ball. The player receives the ball.");
						break;
					case 2:
						say("You're a bad person! I don't like you!");
						Game.print("You're a bad person! I don't like you!");
						break;
				}
				break;
		}
	}
}
