public class Plot {
	private int x;
	private int y;
	private int depth;
	private int width;
	
	//Default constructor
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	//Copy contructor
	public Plot(Plot plot) {
		x = plot.getX();
		y = plot.getY();
		width = plot.getWidth();
		depth = plot.getDepth();
	}
	
	//Full info contructor
	public Plot(int xPosition, int yPosition, int propertyWidth, int propertyDepth) {
		x = xPosition;
		y = yPosition;
		depth = propertyDepth;
		width = propertyWidth;
	}
	
	//Overlap check 
	public boolean overlaps(Plot plot) {
		int x2 = plot.getX();
		int y2 = plot.getY();
		int depth2 = plot.getDepth();
		int width2 = plot.getWidth();
		boolean overlap = false;
		
		if((x < x2) && (x2 < (x+width))) {
			if(((y < y2) && (y2 < (y+depth))) || ( (y < (y2+depth2)) && ((y2+depth2) < (y+depth)))) {
				overlap = true;
			}
		}
		if((x < (x2+width2)) && ((x2+width2) < (x+width))) {
			if(((y < y2) && (y2 < (y+depth))) || ( (y < (y2+depth2)) && ((y2+depth2) < (y+depth)))) {
				overlap = true;
			}
		}
		
		if((x2 < x) && (x < (x2+width2))) {
			if(((y2 < y) && (y < (y2+depth2))) || ( (y2 < (y+depth)) && ((y+depth) < (y2+depth2)))) {
				overlap = true;
			}
		}
		if((x2 < (x+width)) && ((x+width) < (x2+width2))) {
			if(((y2 < y) && (y < (y2+depth2))) || ( (y2 < (y+depth)) && ((y+depth) < (y2+depth2)))) {
				overlap = true;
			}
		}
		
		if(encompasses(plot)) {
			overlap = true;
		}
		
		return overlap;
	}
	
	//Encompass method check
	public boolean encompasses(Plot plot) {
		int x2 = plot.getX();
		int y2 = plot.getY();
		int depth2 = plot.getDepth();
		int width2 = plot.getWidth();
		
		if((x <= x2) && (x2 <= (x+width))) {
			if((y <= y2) && (y2 <= (y+depth))) {
				if((x <= (x2+width2)) && ((x2+width2) <= (x+width))) {
					if((y <= (y2+depth2)) && ((y2+depth2) <= (y+depth))) {
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
	//SETTERS AND GETTERS
	public void setX(int xPosition) {
		x = xPosition;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int yPosition) {
		y = yPosition;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWidth(int propertyWidth) {
		width = propertyWidth;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setDepth(int propertyDepth) {
		depth = propertyDepth;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public String toString() {
		String message;
		message = "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
		return message;
	}
}