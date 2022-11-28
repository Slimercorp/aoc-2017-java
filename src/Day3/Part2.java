package Day3;

import java.util.HashMap;
import java.util.Map;

public class Part2 {

	public static void main(String[] args) {
		int input = 325489;
		Map<String, Integer> map = new HashMap<>();
		map.put("0;0", 1);
		map.put("1;0", 1);
		
		Pointer pointer = new Pointer(1, 0);
		
		while (true) {
			getNewPointer(map, pointer);
			int sum = getSumNeigb(map, pointer);
			map.put(pointer.getCoord(), sum);
			if (sum > input) {
				System.out.println(sum);
				break;
			}
		}		
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

	public static int getSumNeigb(Map<String, Integer> map, Pointer pointer) {
		// 11 12 13
		// 21 XY 23
		// 31 32 33
		
		int sum = 0;
		for (int i = -1; i<=1; i++) {
			for (int j = -1; j<=1; j++) {
				if ((i == 0) && (j == 0)) {
					continue;
				}
				
				String key = (pointer.getX()+i) + ";" + (pointer.getY()+j);
				sum += map.containsKey(key) ? map.get(key) : 0;
				
			}
		}
	
		return sum;
	}

	
}