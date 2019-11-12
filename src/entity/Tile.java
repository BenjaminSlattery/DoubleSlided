package entity;

public class Tile {
	String labels[];
	boolean isFlipped;
	
	public Tile(String top, String bottom, boolean isFlipped) {
		labels = new String[2];
		labels[0] = top;
		labels[1] = bottom;
		this.isFlipped = isFlipped;
		print();
	}
	
	public boolean equals(Tile other) {
		return other != null && isFlipped == other.isFlipped && getCurrentLabel().contentEquals(other.getCurrentLabel());
	}
	
	public void print() {
		System.out.print("\nTile: ");
		System.out.print(labels[0]);
		System.out.print(labels[1]);
		System.out.print(isFlipped);
	}
	
	public String getCurrentLabel() {
		return labels[isFlipped?1:0];
	}
	
	public void flip() {
		isFlipped = !isFlipped;
	}
	
	public boolean getIsFlipped() {
		return isFlipped;
	}
}
