package Day3;

import java.util.HashMap;
import java.util.Map;

public class Part1 {

	public static void main(String[] args) {
		int input = 325489;
		Map<String, Integer> map = new HashMap<>();
		map.put("0;0", 1);
		map.put("1;0", 2);
		
		Pointer pointer = new Pointer(1, 0);
		
		for (int i = 3; i <= input; i++) {
			getNewPointer(map, pointer);
			map.put(pointer.getCoord(), i);
		}
		
		System.out.println(Math.abs(pointer.getX()) + Math.abs(pointer.getY()));
		
	}
	
	private static void getNewPointer(Map<String, Integer> map, Pointer pointer) {
		final int x = pointer.getX();
		final int y = pointer.getY();
		
		// слева занято и сверху свободно -> двигаемся вверх
		// снизу занято и слева свободно -> двигаемся влево
		// справа занято и внизу свободно -> двигаемся вниз
		// сверху занято и справа свободно -> двигаемся вправо
		// 
		
		final boolean leftBusy = map.containsKey((x-1) + ";" + y);
		final boolean upFree = !map.containsKey(x + ";" + (y+1));
		final boolean downBusy = map.containsKey(x + ";" + (y-1));
		final boolean leftFree = !leftBusy;
		final boolean rightBusy = map.containsKey((x+1) + ";" + y);
		final boolean downFree = !downBusy;
		final boolean upBusy = !upFree;
		final boolean rightFree = !rightBusy;
		
		if (leftBusy && upFree) {
			pointer.setY(y + 1);
		} else if (downBusy && leftFree) {
			pointer.setX(x - 1);
		} else if (rightBusy && downFree) {
			pointer.setY(y - 1);
		} else if (upBusy && rightFree) {
			pointer.setX(x + 1);
		}
	}

	
}


