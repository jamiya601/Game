package game;

public class Cat extends NPC {
	
	private int talk = 0;

	public Cat(String name, String desc) {
		super("cat", "A cute cat!");
	}
	
	@Override
	public void talk() {
		talk++;
		switch(talk) {
			case 1: // Dialog 1
				say("*cutely* Meow?");
				String[] options = {
					"Awwww!",
					"Move!"
				};
				getResponse(options);
				break;
				
			case 2: // Dialog 2
				say("Hello human.");
				String[] options2 = {
					"Hello Mr. Whiskers."
				};
				getResponse(options2);
				break;
				
			case 3: // Dialog 3
				say("*purrs*");
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
						say("*rolls over*");
						break;
					case 2:
						say("Meanie! *hisses*");
						Game.print("Mr. Whiskers attempts to scratch you.");
						break;
						
					default:
						say("Yip!");
						break;
				}
				break;
				
			case 2: // Response 2
				switch(option) {
					case 1:
						say("*licks paw*");
						break;
				}
				break;
		}
	}
}
