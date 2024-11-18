package game;

public class Safe extends Item {

	public Safe() {
		super("A safe, to hold special items.");
		setName("Safe");
	}
	
	@Override
	public void open() {
		Item combination = Game.getInvItemName("Combination");
		if(combination == null) {
			System.out.println("The safe is locked and you don't have the combination.");
			
			Item diamond = new Item("A shiny diamond.");
			diamond.setName("Diamond");
			Game.inventory.add(diamond);
		} else {
			System.out.println("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
		}
		
	}
	
}
