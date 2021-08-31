package Pack;

public class Student implements Comparable<Student>{
	int score;
	String id;
	
	public Student(String id, int score) {
		this.score = score;
		this.id = id;
	}

	@Override
	public int compareTo(Student o) {
		if(o.score > score) return -1;
		else if(o.score == score) return 0;
		else return 1;
	}

	
}
