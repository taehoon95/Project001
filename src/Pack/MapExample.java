package Pack;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;

		Set<Entry<String, Integer>> EntrySet = map.entrySet();
		for(Map.Entry<String, Integer> entry : EntrySet) {
			int stdScore = entry.getValue();
			if(stdScore > maxScore) {
				maxScore = stdScore;
				name = entry.getKey();
			}
			totalScore += stdScore;
		}
		
		
		System.out.println("평균점수: " + totalScore / map.size());
		System.out.println("최고점수: " + maxScore);
		System.out.println("최고점수를 받은 아이디: " + name);
	}
}
