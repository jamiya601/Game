package game;

public class Combination extends Item {
	
	public Combination() {
		super("A combination for a safe.");
		setName("Combination");
	}
	
	@Override
	public void use() {
		Game.print("If you find a safe, try opening it!");
	}
}
