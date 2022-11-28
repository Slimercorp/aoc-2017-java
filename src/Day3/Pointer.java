package Day3;

public class Pointer {
	private int x;
	private int y;
	
	Pointer(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String getCoord() {
		return x + ";" + y;
	}
}
