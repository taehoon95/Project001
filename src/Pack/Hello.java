package Pack;

/*  

// Ex)
class Animal{
	
}

class Tiger extends Animal{
	
}

public class Hello {
	public static void main(String[] args) {
		System.out.println("1000");
	}
}
// sdk : software developer kit: 소프트웨어 개발하는 라이브러리
*/

public class Hello {
	public static void main(String[] args) {
		
	}
}



/*
//Ex58-4)스레드 : 실제사용되는 코드 
public class Hello {
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				System.out.println(1);
			};
		};
		t.start();// 호출이 아니라 스레드가 발동됨
		
		new Thread() {
			public void run() {
				System.out.println(1);
			};
		}.start();
		
	}
}

//Ex58 -3) 스레드 
class Tiger extends Thread {
	public void run() {
		System.out.println("Tiger start");
		Thread t = new Lion();
		t.start();
		Scanner sc = new Scanner(System.in);
		sc.nextInt(); //블로킹함수 : 특정한 작업이 없으면 중단되지않는다.
		System.out.println("Tiger end");
	}
}

class Lion extends Thread {
	public void run() {
		System.out.println("Lion start");
		Scanner sc = new Scanner(System.in);
		sc.nextInt(); //블로킹함수 : 특정한 작업이 없으면 중단되지않는다.
		System.out.println("Lion end");
	}
}


// 프로세스 살아있다면 디버그창을 열어서 Terminate and Remove로 끈다.
// 숫자 입력하고 엔터 쳤는데 둘다 안죽은 경우: 입력받은 후 제어권을 다음 객체에 넘겼다. 그래서 마지막에 한번에 수행된다.
public class Hello {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t = new Tiger();
		t.start();
		Scanner sc = new Scanner(System.in);
		sc.nextInt(); //블로킹함수 : 특정한 작업이 없으면 중단되지않는다.
		System.out.println("main end");
	}
}


//Ex58 -2) 스레드 
class Tiger extends Thread{
	public void run() { // 2
		System.out.println(2);
		// 반복문
		for(int i = 0; i < 10; i++) {
			System.out.println("호랑이" + i);
			
			try {
				Thread.sleep(0); // 0이면 쉬긴 쉬는데 1/1000초 보단 적게 쉼
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("종료");
	};
}

public class Hello {
	public static void main(String[] args) {
		Thread t = new Tiger();
		t.start(); // 1 Thread 안에는 start()가 있고 그 안에 run()이 있다.
		System.out.println(1);
		// 반복문
		for(int i = 0; i < 10; i++) {
			System.out.println("코끼리" + i);
			
			try {
				Thread.sleep(0); // 0이면 쉬긴 쉬는데 1/1000초 보단 적게 쉼
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("main Exit");
	}
}


//Ex58 -1) 스레드하기전 문법 정리 

class A {
	void start() {
		System.out.println("start call");
		run();
	}
	
	void run() {
		System.out.println("A run call");
	}
}

class B extends A {
	@Override
	void run() {
		System.out.println("스레드 시작");
		System.out.println("B run call");
		System.out.println("스레드 종료");
	}
}

public class Hello {
	public static void main(String[] args) {
		A a = new B();
		a.start();
	}
}


//Ex57) 제네릭 문법 : <T> 객체를 생성할때 타입을 정하므로 무한정 만들 필요 없다.
class A<E> {
	private E data;
	
	public E getData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = data;
	}
}

public class Hello{
	public static void main(String[] args) {
		A<Integer> a = new A<Integer>();
		a.setData(100);
		System.out.println(a.getData());
		
		A<String> b = new A<String>();
		b.setData("호랑이");
		System.out.println(b.getData());
	}
}
//Ex57) 문제: 타입이 바뀔때 마다 클래스를 생성해야된다.
class A {
	private int data;
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
}

class B {
	private String data;
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
}

class C {
	private float data;
	
	public float getData() {
		return data;
	}
	
	public void setData(float data) {
		this.data = data;
	}
}

public class Hello{
	public static void main(String[] args) {
		A a = new A();
		a.setData(100);
		System.out.println(a.getData());
		
		B b = new B();
		b.setData("호랑이");
		System.out.println(b.getData());
	}
}

//Ex56-4) 디자인 패턴 : 데코레이션 패턴(객체가 객체를 감싸는)
class 커피 {
	int 가격 = 30;
	
	int 계산() {
		System.out.println("커피 주문");
		return 가격;
	}
}

class 설탕 extends 커피 {
	int 가격 = 20;
	커피 a; //곧 사라질 객체를 백업
	
	설탕(커피 a){
		this.a = a;
	}
	
	int 계산() {
		System.out.println("설탕추가");
		return 가격 + a.계산();
	}
}

class 프림 extends 커피 {
	int 가격 = 10;
	커피 a; //곧 사라질 객체를 백업
	
	프림(커피 a){
		this.a = a;
	}
	
	int 계산() {
		System.out.println("프림 추가");
		return 가격 + a.계산();
	}
}

public class Hello {
	public static void main(String[] args) {
		커피 a = new 커피();
		//System.out.println(a.계산());
		
		a = new 설탕(a); 
		//System.out.println(a.계산());

		//System.out.println("--------------------------");
		a = new 프림(a); //인자 a는 B에 있던 a
		System.out.println(a.계산());
	}
}


//Ex56-3) 디자인 패턴 : 데코레이션 패턴(객체가 객체를 감싸는)
class A {
	int num = 10;
	
	int run() {
		System.out.println("A Run");
		return num;
	}
}

class B extends A {
	int num = 20;
	A a; //곧 사라질 객체를 백업
	
	B(A a){
		this.a = a;
	}
	
	int run() {
		System.out.println("B Run");
		return num + a.run();
	}
}

class C extends A {
	int num = 30;
	A a; //곧 사라질 객체를 백업
	
	C(A a){
		this.a = a;
	}
	
	int run() {
		System.out.println("C Run");
		return num + a.run();
	}
}

public class Hello {
	public static void main(String[] args) {
		A a = new A();
		
		a = new B(a); 
		System.out.println(a.run());

		System.out.println("--------------------------");
		a = new C(a); //인자 a는 B에 있던 a
		System.out.println(a.run());
	}
}



//Ex56-2 ) 디자인 패턴
class AA{}

class BB extends AA{}
class CC extends AA{}

public class Hello{
	public static void main(String[] args) {
		
		AA a1 = new BB();
		System.out.println("BB a1 : " +a1.hashCode());
		
		a1 = new CC();
		System.out.println("CC a1 : " +a1.hashCode());

		AA a2 = a1; //객체 백업
		System.out.println("a2 : " +a2.hashCode());
		
		a1 = new BB();
		System.out.println("BB a1 : " +a1.hashCode());
		System.out.println("a2 : " +a2.hashCode());
	}
}

//Ex56-1 ) 디자인 패턴
class AA{}

class BB extends AA{}
class CC extends AA{}

public class Hello{
	public static void main(String[] args) {
		
		AA a1 = new BB();
		System.out.println(a1.hashCode());
		
		a1 = new CC();
		System.out.println(a1.hashCode());
		
		AA a2 = a1; //객체 백업
		a1 = new BB();
		System.out.println(a1.hashCode());
	}
}

//Ex55 - 2) 파일 입출력 : 사용하고 닫는 작업을 무조건 수행해줘야 한다.

public class Hello {
	public static void main(String[] args) {
		try {
			Writer w = new FileWriter("test01.txt"); // "test01.txt"만들기
			
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					w.write((i + j) % 2 == 0 ? "O " : "X "); 
				}
				w.write("\n");
			}
			
			w.close();
			//Reader r = new FileReader("test02.txt", Charset.forName("UTF-8"));
			//Reader r = new FileReader("test02.txt", StandardCharsets.UTF_8);
			
			Reader r = new FileReader("test02.txt");
			int data;
			
			while(true){
				data = r.read();
				if(data == -1) {
					break;
				}
				System.out.print((char)data);
			}
			System.out.println();
			
			r.close();
			System.out.println("파일 입출력 종료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}


//Ex55 - 1) 이중 for문 파일 입출력

public class Hello {
	public static void main(String[] args) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print("[" + i + " " + j + "]");
			}
			System.out.println();
		}System.out.println();

		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 6; j++) {
				if((i + j) % 2 == 0) {
					System.out.print("O ");
				}else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}System.out.println();
		
		
	}
}


//Ex54) 디자인 패턴(싱글톤 패턴)
class Tiger{
	int num;
	private static Tiger instance = null;
	
	private Tiger() {}
	
	static Tiger getInstance() {
		if(instance == null) {
			System.out.println(1);
			instance = new Tiger();
		}
		return instance;
	}
	
	void m1() {
		System.out.println(22);
	}
}

public class Hello {
	public static void main(String[] args) {
//		Tiger t1 = new Tiger();
//		Tiger t2 = new Tiger();

		Tiger t1 = Tiger.getInstance();
		Tiger t2 = Tiger.getInstance();
		
		System.out.println(t1.hashCode() == t2.hashCode());
		t1.m1();
		t2.m1();
		t1.num = 2000;
		System.out.println("-----------------------------");
		System.out.println(t2.num);
	}
}



// Ex53)

class Tiger{
	private int num;
	
	// setter, getter (setter, getter제공으로 읽기전용,쓰기전용,둘다못하게 하려고 할 수 있다)
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return this.num;
	}
	//
	
	// 내부에서 작성할때 사용
	private void m1() {
		
	}
	
} 

public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.b = 10;
		//t.a = 20;
		
		t.setNum(100);
		System.out.println(t.getNum());
	}
}


//Ex52) 람다 실제 사용 모습
interface Test1 {
	void m1();
}

interface Test2 {
	int m1();
}

class Tiger {
	void m2(Test1 t) {
		t.m1();
	}
	
	void m3(Test2 t) {
		System.out.println(t.m1());
	}
}

public class Hello {
	public static void main(String[] args) {
		//ex1)
		Test1 t1 = () -> {
				System.out.println(1);
		};
		
		Tiger tiger = new Tiger();
		
		tiger.m2(t1);
		
		//실제 사용 모습
		tiger.m2(() -> {
			System.out.println(2);
		});
		
		// return 있는 경우 사용 모습
		tiger.m3(() -> 100);
		
		LinkedList<Integer> mm = new LinkedList<Integer>();
		mm.removeIf(lion -> {
			return lion % 2 == 0;
		});
		mm.removeIf(lion -> lion % 2 == 0);
		
		mm.removeIf(new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer tiger) {
				return tiger % 2 == 0;
			}
		});
		
	}
}

//Ex51) 람다 함수 사용(람다함수는 인터페이스 안에 함수가 하나가 있다는 전제하에 사용)

interface Test1{
	void m1();
}

interface Test2{
	void m1(int num);
}

interface Test3{
	int m1();
}

interface Test4{
	String m1(int num, String str);
}

public class Hello {
	public static void main(String[] args) {
		// ex1) 익명 객체 사용
		Test1 t1 = new Test1() {
			@Override
			public void m1() {
				System.out.println(1);
			}
		};
		t1.m1();  //1
		
		// ex2) 익명 객체 사용 -> 람다(스코프만 남기고 삭제 -> () -> {}; 람다함수의 기본형
		Test1 t2 = () -> {System.out.println(1);};
		t2.m1();  //1
		
		//ex3) 함수에 인수 전달이 있을 경우
		Test2 t3 = (n) -> {
			System.out.println(n);
		};
		
		t3.m1(3); //3
		
		//ex4) return값이 있는 경우
		Test3 t4 = () -> {
			System.out.print("Test3  "); 
			return 100;
		};
		System.out.println(t4.m1()); // Test3  100
		
		//ex5) return값과 인수전달(2개) 있는 경우
		Test4 t5 = (n,s) -> {
			return n + s;
		};
		System.out.println(t5.m1(10, "호랑이"));
		
		//ex6) return 한줄만 사용이 될 때는 스코프생략가능한데 그때는 return이라는 키워드도 생략 해야됌 
		Test3 t6 = () -> 100;
	}
}


Ex) Collection
class Message{
	String command;
	String to;
	
	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
}

class Coin{ //stack
	int value;

	Coin(int value) {
		this.value = value;
	}

	int getValue() {
		return value;
	}
}

class Person  implements Comparable<Person> { //treeSet, treeMap
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
//	@Override
//	public int compareTo(Person o) {
//		if(age<o.age) return -1;
//		else if(age==o.age) return 0;
//		else return 1;
//	}

	@Override
	public String toString() {
		return String.format("%s %s", name, age);
	}
	
}

public class Hello {
	public static void main(String[] args) {
		//1. ArrayList
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(3, 77);

//		for(Iterator<Integer> it = a.iterator(); it.hasNext();) {
//			System.out.println(it.next());
//		}
		
		//2. Set
		Set<String> s = new HashSet<String>();
		s.add(new String("1"));
		s.add(new String("2"));
		s.add(new String("1"));
		
		s.remove("1");
//		for(Iterator<String> it = s.iterator() ; it.hasNext();) {
//			System.out.println(it.next());
//		}
		
		//3.HashMap
		Map<Integer, Integer> m = new HashMap<>();
//		m.put(1, 1);
//		m.put(2, 2);
//		m.put(3, 3);
//		
//		for(Iterator<Integer> it = m.keySet().iterator(); it.hasNext();) {
//			System.out.println(it.next());
//		}
//
//		for(Iterator<Integer> it = m.values().iterator(); it.hasNext();) {
//			System.out.println(it.next());
//		}
		
		//4.TreeSet
		TreeSet<Integer> score = new TreeSet<Integer>();
		score.add(44);
		score.add(77);
		score.add(55);
		score.add(66);
		score.add(22);
		
//		for(Iterator<Integer> it = score.iterator(); it.hasNext();) {
//			System.out.println(it.next());
//		}
		
		NavigableSet<Integer> v = score.descendingSet();
		NavigableSet<Integer> asc = v.descendingSet();
		
//		for(Integer is : v) {
//			System.out.println(is);
//		}
	
//		for(Integer is : asc) {
//			System.out.println(is);
//		}

//		TreeSet<String> fruit = new TreeSet<String>();
//		fruit.add("cherry");
//		fruit.add("banana");
//		fruit.add("pear");
//		fruit.add("watermellon");
//		
//		String start = "b";
//		String end = "d";
//		System.out.println(start + " " + end + "사이의 단어 검색");
//		NavigableSet<String> sd = fruit.subSet(start, true, end, true);
//		for(String word : sd) {
//			System.out.println(word);
//		}
		
		//5.TreeMap
		TreeMap<Integer, String> trm = new TreeMap<>();
		trm.put(99, "A");
		trm.put(75, "B");
		trm.put(50, "C");
		trm.put(65, "D");
		trm.put(88, "E");
		
		NavigableSet<Integer> des = trm.descendingKeySet();
//		Set<Map.Entry<Integer, String>> se = trm.entrySet();
//		for(Map.Entry<Integer, String> n : se) {
//			System.out.println(n);
//		}
		
		//숫자 범위 검색
//		NavigableMap<Integer, String> nvm = trm.subMap(50, true, 88, true);
//		for(Map.Entry<Integer, String> asd : nvm.entrySet()) {
//			System.out.println(asd.getKey() + " " + asd.getValue());
//		}

		// Comparable을 구현 하지 않으면 ClassCastExeption발생 
		// Comparator인터페이스를 구현한 Asd()클래스 생성해서 에러발생을 막을수도있다.
		TreeSet<Person> trs = new TreeSet<Person>(new Asd());
		
		trs.add(new Person("이", 22));
		trs.add(new Person("김", 66));
		trs.add(new Person("홍", 44));
		trs.add(new Person("박", 84));
		trs.add(new Person("조", 14));
		
//		for(Iterator<Person> it = trs.iterator(); it.hasNext();) {
//			System.out.println(it.next());
//		}

		// 6.Stack
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(10));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(50));
		
//		while(!coinBox.isEmpty()) {
//			Coin coin = coinBox.pop();
//			System.out.println("꺼내온 동전 " + coin.getValue());
//		}
		
		//7.Queue
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "나1"));
		messageQueue.offer(new Message("sendSMS", "나2"));
		messageQueue.offer(new Message("sendkakaotalk", "나3"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch (message.command) {
			case "sendMail": System.out.println(message.to+" 님에게 메일을 보냅니다."); break;
			case "sendSMS": System.out.println(message.to+" 님에게 SMS을 보냅니다."); break;
			case "sendkakaotalk": System.out.println(message.to+" 님에게 카톡을 보냅니다."); break;
			}
		}
	}
}

class Asd implements Comparator<Person>{
	@Override
	public int compare(Person o1, Person o2) {
		if(o1.age <o2.age) return -1;
		else if(o1.age == o2.age) return 0;
		else return 1;
	}
}


//Ex)50
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>();
//		for(int i = 0; i < 10; i++) {
//			mm.add(i*10+i);
//		}
//		System.out.println(mm);
//		
//		int size = mm.size();
//		
//		for(int i = 0; i < size; i++) {
//			int num = mm.get(i);
//			if(num == 1111) {
//				System.out.println(i + " 번째 찾았다.");
//				break;
//			}
//			
//			if(i == mm.size()-1) {
//				System.out.println("못 찾았다.");
//			}
//		}
//		
//		
//		for(int i = 0; i < size-1; i++) {
//			int num = mm.get(i);
//			System.out.println(num);
//			if(num == 55) {
//				mm.remove(i);
//			}
//		}
//		System.out.println(mm);
		mm.add(33);
		mm.add(44);
		mm.add(77);
		
		for(int i = 0; i < 10; i++) {
			mm.add(i*2);
		}
		
		mm.add(101);
		mm.add(102);
		mm.add(103);
		System.out.println(mm);
		
//		int size =  mm.size()-1;
//		
//		for(int i = 0; i < size; i++) {
//			int num = mm.get(size - i);
//			if(num % 2 == 0) {
//				mm.remove(size - i);
//			}
//		}
//		
//		System.out.println(mm);

		// 풀이
		// 1.
//		for (int i = 0; i < mm.size(); i++) {
//			int num = mm.get(i);
//			if(num % 2 == 0) {
//				mm.remove(i);
//				i--; //i++만 되면 삭제될경우 건너뛰게 됨
//			}
//		}
		
		// 1-2.정석코드
//		for (int i = 0; i < mm.size();) {
//			int num = mm.get(i);
//			if(num % 2 == 0) {
//				mm.remove(i);
//			}else {
//				i++; 
//			}
//		}
		
		// 2. 이터레이터 사용
//		for(Iterator<Integer> it = mm.iterator(); it.hasNext();) {
//			Integer num = it.next();
//			if(num % 2 == 0) {
//				it.remove();
//			}
//		}

		// 3. removeIf((Predicate<> ) : 내부적으로 for문을 돌면서 조건에 맞추어서 remove
//		mm.removeIf(new Predicate<Integer> (){
//
//			@Override
//			public boolean test(Integer num) {
//				return num % 2 == 0;
//			}
//			
//		});
		
		// 4. 람다 함수 사용
		mm.removeIf( num -> num % 2 == 0);
		System.out.println(mm);
	}
}

// Ex)49 Collection : LinkedList 무난하게 다좋음
// 컨테이너<제네릭> : 한가지의 자료형 타입만 관리할 수 있는것 
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>();
		
		// C(reate)RUD
		mm.add(10);
		System.out.println(mm.size());
		for(int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		
		// CR(ead)UD
		// 1.
		System.out.println(mm);
		
		// 2.
		int size = mm.size(); // 함수를 한번만 호출하도록 하기위해 이렇게 사용한다.
		
		for(int i = 0; i < size; i++) {
			int data = mm.get(i);
			System.out.print(data + " ");
		}System.out.println();
		
		// 3. x, item, data, value
		for (Integer x : mm) {
			System.out.print(x + " ");
		}System.out.println();
		
		//CRU(pdate)D
		mm.set(5, 999);
		System.out.println(mm);
		
		//CRUD(elete)
		mm.remove(5);
		System.out.println(mm);
		
	}
}

//Ex48-3)비트연산( &, |)

public class Hello {
	
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);

		while(s.length() < 32) {
			s = "0" + s;
		}
		
		StringBuffer s1 = new StringBuffer(s);
		
		for(int i = 0; i < 7; i++) {
			s1.insert((7-i)*4, " ");
		}

		return s1.toString();
	}
	
	
	public static void main(String[] args) {
		int a = 0x3b12cd5a;
		
		int b = 0x0000ff00;
		int c = 0x0000cd5a;
//		
//		System.out.println(hexaToBinary(a));
//		System.out.println(hexaToBinary(b));
//		System.out.println(hexaToBinary(a & b)); // cd00
//		System.out.println(hexaToBinary((a & b) >> 8)); // cd 8비트 이동해라
//		System.out.println(hexaToBinary(a & b >> 8)); // 59 8비트 이동해라
//		System.out.println((a & b)); // cd00
//		System.out.println(hexaToBinary(((a >> 12) & b) >> 8)); // cd00
//		
//		System.out.println("c :" + hexaToBinary(c));
//
//		
//		System.out.println(hexaToBinary(0xf800));
//		System.out.println(hexaToBinary(c & 0xf800));
//		System.out.println((c & 0xf800) >> 11);
//		
//		System.out.println(hexaToBinary((c&0x7e0) >> 5));
//		System.out.println((c&0x7e0) >> 5);
//		
//		System.out.println(hexaToBinary(c&0x1f));
//		System.out.println((c&0x1f));
		
		int e = 0x77000000;
		
		int c1 = 25; //11번 옮긴사실을암
		int c2 = 42; 
		int c3 = 26;
		int c4;
		
//		System.out.println(Integer.toHexString((c1<<11 | c2 << 5 | c3))); 
		
		// 0000 0000 1101 1100
		char c5 = 0x00dc; //
		char mask = 0x0080; //2.마스크변수 자체가 쉬프트 되고 있는가?
		
		//1. 문자열 배열 있는가?
		String[] arr = {"냉장고","가스레인지","선풍기","밥솥","에어컨","전기장판","에어프라이기","전자레인지"};

		for(int i = 0; i < 8; i++, mask >>= 1 ) {
			//3. 삼항연산 되어있는가?
			System.out.println((c5 & mask) == mask ? arr[i] + " on" : arr[i] + " off");
		}
		
	}
}
//시프트 연산 들어오는것은 0 나가는것은 소실


// Ex48-2)StringBuffer를 이용한 이진수 출력

public class Hello {
	
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
//		System.out.println(s);
//		System.out.println(s.length());
		
		while(s.length() < 32) {
			s = "0" + s;
		}
		
		//String 객체는 insert할수 있는 메서드가 없다
		//StringBuffer의 객체는 수정,추가,삭제 가능
		
		StringBuffer s1 = new StringBuffer(s);
		
//		위치가 하나씩 밀림
//		for(int i = 1; i < 8; i++) {
//			s1.insert(4*i+(i-1), " ");
//		}
		
//		뒤에서부터 넣으면 들어가는 데이터위치 걱정할 필요 없다.
		for(int i = 0; i < 7; i++) {
			s1.insert((7-i)*4, " ");
		}
		return s1.toString();
		
	}
	
	static int m1() {
		return 100;
	}
	
	public static void main(String[] args) {
//		System.out.println(m1()*100+20);
		// 0011 1011 0001 0010 1100 1101 0101 1001
		int a = 0x3b12cd59;// 
		int b = 991087961; 
		
		if(a == b) {
//			System.out.println(1);
		}
		
		System.out.println(hexaToBinary(a));
		System.out.println(hexaToBinary(b));
	}
}

// Ex48-1) 이진수 출력

public class Hello {
	public static void main(String[] args) {
		int a = 1234; //
		int b = 0x1234; // 1001000110100
		System.out.println(a);                           //1234
		System.out.println(b);                           //4660
		System.out.println(Integer.toBinaryString(a));   //10011010010
		System.out.println(Integer.toBinaryString(b));   //1001000110100
		// 0000 0000 0000 0000 0001 0010 0011 0100
	}
}

// Ex47)String

public class Hello {
	public static void main(String[] args) {
		String s = "무궁화꽃이피었습니다";
		// 1. 길이
		System.out.println(s.length());

		// 2. char charAt(int index)
		System.out.println(s.charAt(3));
		
		// 3. int indexOf(String str)
		System.out.println(s.indexOf("화꽃이")); //2
		
		System.out.println(s.indexOf("목꽃이")); //-1
		
		int n = s.indexOf("화꽃이");
		if(n != -1) {
			System.out.println("found"); //2
		}else {
			System.out.println("not found"); //2
		}
		
		// 4. String replace(CharSequence target, CharSequence replacement)
		System.out.println(s.replace("꽃이", "나무가"));//나무가무궁화 나무가 피었습니다 나무가
		// 주의: 
		System.out.println(s); // 꽃이무궁화꽃이 피었습니다꽃이

		//String은 데이터자체를 변경시킬수 없다.
		//s="대한민국"; //기존의 객체를 날리고 "대한민국"이라는 새로운 객체를 만듬 
		//System.out.println(s);
		
		// 5. slicing
		System.out.println(s.substring(6));
		System.out.println(s.substring(3,6));
		
		// 6. trim
		String s2= "   App   le   ";
		System.out.print(s2.trim());
		System.out.println("호랑이");
		
		// 7. 대소문자 변경
		String s3 = "APpLe";
		System.out.println(s3.toUpperCase());
		System.out.println(s3.toLowerCase());
		
		// 8. String(byte[] bytes, int offset, int length) : 데이터를 받았을때
		byte[] data = new byte[] {
				65, 'B', 'C', 'D'
			};
		
		String s4 = new String(data, 0, data.length);
		System.out.println(s4);
		
		//  데이터를 전송할때
		String s5 = "Banana";
		byte[] data1 = s5.getBytes();
		for (byte value : data1) {
			System.out.println((char)value);
		}
	}
}

// Ex46-4)try catch finally
class Tiger{
	void m1(int a, int b) {
		if (a > b) {
			System.out.println(111);
		} else {
			return;
		}
		System.out.println(" m1 : " + 2222);
	}

	void m2(int a, int b) {
		try {
			if (a > b) {
				System.out.println(1111);
			} else {
				return;
			}
		} catch (Exception e) {

		} finally {
			System.out.println(" m2 : " + 2222);
		}
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1(1, 4);
		t1.m2(1, 4);
	}
}

// Ex46-3)
public class Hello {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			System.out.println(i);
			try {Thread.sleep(2000);} catch (InterruptedException e) {}
		}
	}
}

// Ex46-2)
class Tiger{
	void m1() {
		System.out.println(1);
		try {
			throw new Exception();
		}catch (Exception e) {
			System.out.println("Exception 발생함");
		}
	}

	void m2() throws Exception{
		System.out.println(2);
		throw new Exception();
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new  Tiger();
		t1.m1();
		
		//Unhandle Exception
		try {
			t1.m2();
		} catch (Exception e) {
			
		};
		System.out.println(3);
		
	}
}

// Ex46) Exception
public class Hello {
	public static void main(String[] args){
		System.out.println(1);
		try {
			int a = 10 / 0; // ArithmeticException발생 프로그램 종료
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(2);
		
		System.out.println("----------------------------------------");
		
		// ArrayIndexOutOfBoundsException 발생
		int[] ar = {1,2,3};
		try {
			ar[3] = 10;
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("안멈춤");

		System.out.println("----------------------------------------");
		String s = "무궁화꽃이피었습니다.";
		System.out.println(s.length());
		
		//NullPointerException 발생
		s = null;
		try {
			System.out.println(s.length());
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("안멈춤");
	}
}

//Ex45-4)
//문제 : 함수를 호출할때 마다 인공지능을 호출하고 있다.
class Baduk{
	Ai ai;
	
	Baduk(Ai ai) {
		this.ai = ai;
		System.out.println("대국을 시작합니다.");
	}
	
	void play() {
		ai.play();
	}
	
	void stop() {
		ai.stop();
	}
}

interface Ai{
	void play();
	void stop();
}

//Google에서 만듬
class Alphago implements Ai{
	public void play() {
		System.out.println("인공지능은 Alphago 입니다.");
	}
	
	@Override
	public void stop() {
		System.out.println("Alphago 점수계산을 합니다.");
	}
}

//Amazon에서 만듬
class Betago implements Ai{
	public void play() {
		System.out.println("인공지능은 Betago 입니다.");
	}
	
	@Override
	public void stop() {
		System.out.println("Betago 점수계산을 합니다.");
	}
}

public class Hello {
	public static void main(String[] args) {
		Baduk baduk1 = new Baduk(new Alphago());
		Baduk baduk2 = new Baduk(new Betago());
		baduk1.play();
		baduk1.stop();
		baduk2.play();
		baduk2.stop();
	}
}


//Ex45-3)
//문제 : 새로운 클래스가 생길떄마다 바둑클래스에 play메서드 하나더 만들어야한다.
class Baduk{
	Baduk() {
		System.out.println("대국을 시작합니다.");
	}
	void play(Ai ai) {
		ai.play();
	}
}

interface Ai{
	void play();
}

//Google에서 만듬
class Alphago implements Ai{
	public void play() {
		System.out.println("인공지능은 Alphago 입니다.");
	}
}

//Amazon에서 만듬
class Betago implements Ai{
	public void play() {
		System.out.println("인공지능은 Betago 입니다.");
	}
}

public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new Alphago());
		baduk.play(new Betago());
	}
}


//Ex45-2)
//새로운 클래스가 생길떄마다 바두클래스에 플레이메서드 하나더 만들어야한다.
class Baduk{
	Baduk() {
		System.out.println("대국을 시작합니다.");
	}
	
	void play(Alphago alphago) {
		alphago.play();
	}
	
	void play(Betago betago) {
		betago.play();
	}
}

//Google에서 만듬
class Alphago{
	void play() {
		System.out.println("인공지능은 Alphago 입니다.");
	}
}

//Amazon에서 만듬
class Betago{
	void play() {
		System.out.println("인공지능은 Betago 입니다.");
	}
}

//문제점 : 인공지능이 바뀐다면 어떻게 해야 할까?
public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new Alphago());
		baduk.play(new Betago());
	}
}


//Ex45-1)
class Baduk{

	Baduk() {
		System.out.println("대국을 시작합니다.");
	}
	
	void play() {
		System.out.println("인공지능은 알파고 입니다.");
	}
	
}

//문제점 : 인공지능이 바뀐다면 어떻게 해야 할까?
public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play();
	}
}

//Ex44-2)
interface Animal {
	void m1();
}

class Zoo {
	void sound(Animal t) {
		t.m1();
	}
}

public class Hello {
	public static void main(String[] args) {
		// 익명 클래스 쓰는 1번째 방법
		Animal t1 = new Animal() {
			public void m1() {
				System.out.println("출력 하기! -1-");
			}
		};
		t1.m1();
		
		Zoo t2 = new Zoo();
		t2.sound(new Animal() {
			public void m1() {
				System.out.println("출력 하기! -2-");
			}
		});
	}
}


//Ex44-1)
interface Animal{
	void m1();
}

class Zoo{
	
	void m1(Animal t) {
		
	}
	
}


class Tiger implements Animal {
	@Override
	public void m1() {
		System.out.println(1);
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1();

		Animal t2 = new Tiger();
		t2.m1();

		// 익명 클래스를 이용해서 객체를 생성한다. (실전에서 자주 쓰임)
		Animal t3 = new Animal() {
			@Override
			public void m1() {
				System.out.println(2);
			}
		};

		t3.m1();

		//익명객체
		new Animal() {
			@Override
			public void m1() {
				System.out.println(3);
			}
		}.m1();
		
		Zoo t4 = new Zoo();
		
		//함수인수에 객체를 이용해 코드를 전달
		t4.m1(new Animal() {
			@Override
			public void m1() {
				System.out.println(4);
			}
		});
		
	}
}



//Ex43-5) this4번째 이용법 : 자기 생성자 안에서 다른 생성자를 호출 할때

class Tiger {
	int a;
	
	Tiger() {
		System.out.println(1);
	}

	Tiger(int a) {
		this(); 
		System.out.println(a);
	}

	Tiger(int a, int b) {
		this(a+b); //인자 하나 가진 생성자 호출
		System.out.println(a + " " + b);
	}	

}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(10, 20);
	}
}


// Ex43-4) this3번째 이용법 : 자신의 객체를 보내면 호출한쪽은 받은 객체의 정보를 이용한다.

class Tiger{
	
	void m1() {
		System.out.print("가지고 있는 재산은 : ");
		Lion t1 = new Lion();
		if(t1.merry(this) == true) {
			System.out.println("감사합니다.");
		}else {
			System.out.println("ㅠㅠ");
		}
	}
	
	int m2() {
		return 50;
	}
	
	String m3() {
		return "난폭";
	}
}

class Lion {

	boolean merry(Tiger t) {
		System.out.println(t.m2());
		if (t.m2() >= 80) {
			return true;
		} else {
			String s = t.m3();
			System.out.println("성격 : " + s);
			switch (s) {
				case "온순": 
					return true;
				
				case "난폭": 
					return false;
				
			}
			return false;
		}
	}

}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1();
	}
}


//Ex43-3) this2번째 이용법 : 함수의 호출을 체이닝해서 사용

class Tiger{
	
	Tiger m1() {
//1.	return new Tiger();
		
//2.	Tiger t = new Tiger();
//		return t;
//3.
		System.out.println(1);
		return this; 
	}
	
	 Tiger m2() {
		 System.out.println(2);
		 return this;
	 }
	 
	 void m3() {
		 System.out.println(3);
	 }
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		
		Tiger t2 = new Tiger();
		
		System.out.println(t1.hashCode() + " " + t1.m1().hashCode());

		System.out.println(t2.hashCode() + " " + t2.m1().hashCode());
		
		System.out.println("----------------------------------------");
		t1.m1().m2().m1().m2().m3();//체이닝
	}
}

//Ex42-2)this1번째 이용법
class Tiger {

//	Tiger this;
//	
//	Tiger(Tiger t){
//		this = t;
//	}

	int a, b, size; //필드변수

	Tiger(int a, int b, int size) {// 멤버 필드를 초기화
		this.a = a; // 멤버 a = 전달받은 인수 a 
		this.b = b;
		this.size = size;
	}

	void show() {
		System.out.println(this.a + " " + this.b + " " + this.size);
	}
	
}

public class Hello {
	public static void main(String[] args) {

		Tiger t1 = new Tiger(10, 20, 5);
		int num = 10;
		num = num;// 셀프 대입(자기 대입), 쓸모없는 코드

		t1.show();
	}
}


// Ex42-1)this1

class Tiger{
	
	int a;
	int b;
	
//	Tiger this;
//	
//	Tiger(Tiger t) {
//		this = t;
//	} 기본 생성자에 생략된 부분 모두 표시한 경우
	
	Tiger(){}	
	
	Tiger(Tiger t,int a, int b) {
		//this = t;
		//t.a = a; => this.a = a;
		t.a = a;
		System.out.print(t.hashCode());
		System.out.print(this.hashCode());
	}
	
	Tiger(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.print(this.hashCode());
	}

	void m1(int a, String b, Tiger c) {
		System.out.println(1);
		
	}
	
}

public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger(); // -> Tiger t = new Tiger(t);
		
		
		Tiger t1 = new Tiger(10, 20);
		System.out.println(" " +t1.hashCode());
		
		Tiger t2 = new Tiger(30, 40);
		System.out.println(" " +t2.hashCode());
		t2.m1(0, null, t1);
//		t1.m1(1,"s0",new Tiger());
	}
}


// Ex41) final : 상수가 된다. (대문자, 더이상 값을 변경할 수 없다, 대입을 받는것이 여기가 마지막) 

class Animal{
//final class Animal{ class 앞에 final을 쓰면 상속을 불가능하게 한다.
	final int NUM = 10;
	
	final void m1() {//여기가 마지막 오버라이딩이다.
		}
}

class Tiger extends Animal{
//	void m1() {} 부모가 final로 메서드를 생성했기 떄문에 이 형태로는 메서드를 만들수 없다.

}




public class Hello {
	public static void main(String[] args) {
		Animal t1 = new Animal();
//		t1.NUM = 20; 자체가 성립이 안된다.
		System.out.println(Math.PI);
		System.out.println(t1.NUM);
		String s;
	}
}

// Ex40)
class A{
	void m1() {
		System.out.println(1);
	}
}

interface B{
	void m2(); // 함수원형(함수프로토타입)
}

interface C{
	void m3(); // 함수원형(함수프로토타입)
}

class D extends A implements B, C {
	@Override
	public void m2() {
		System.out.println(22);
	}

	@Override
	public void m3() {
		System.out.println(33);
	}
}

//인터페이스 분리 원칙 지키려고한다.
@FunctionalInterface // @FunctionalInterface: 인터페이스 안에는 반드시 1개의 메서드만 사용하기 위해 작성
interface E {
	void m1();
//	void m2();
}

public class Hello {
	public static void main(String[] args) {
		D t1 = new D();
		
		t1.m1();
		t1.m2();
		t1.m3();
		
		//Thread t2 = null : t2는 "지금 객체가 아니다" 강조
		Thread t2 = null;
		String t3 = null;
		StringBuffer t4 = null;
	}
}


// Ex39)
interface 한국은행{
	void 입금();
	void 출금();
	void 이체();
	void 대출();
}

class 국민은행 implements 한국은행{

	@Override
	public void 입금() {
		System.out.println("이자율은 3%입니다.");
	}

	@Override
	public void 출금() {
		
	}

	@Override
	public void 이체() {
		
	}

	@Override
	public void 대출() {
		
	}
	
}

class 우리은행 implements 한국은행{

	@Override
	public void 입금() {
		System.out.println("이자율은 6% 입니다.");
	}

	@Override
	public void 출금() {
		
	}

	@Override
	public void 이체() {
		
	}

	@Override
	public void 대출() {
		
	}
	
}

public class Hello {
	public static void main(String[] args) {
		한국은행 t1 = new 국민은행();
		한국은행 t2 = new 우리은행();
		
		t1.입금();
		t2.입금();
	}
}


// Ex38)

abstract class 대장장이{
	void 칼() {
		System.out.println("칼을 잘 만듭니다.");
	}

	// 단일책임원칙 위배 : 칼만 잘만드는데 방패를 억지로 만듬
//	void 방패() {
//		System.out.println("허접 방패");
//	}
	
	abstract void 방패();
}

//칼을 잘쓰는 대장장이를 이용
//나그네는 무조건 방패를 만들긴 해야됌
class 나그네1 extends 대장장이{

	void 방패() {
		System.out.println("방패 잘 만듬");
	}
	
}

class 나그네2 extends 대장장이{
	
	//@ : 어노테이션(프로그래머가 실수 할 수 있는 것을 미연에 방지 하기 위해 사용)
	//오버라이딩 : 자식이 사용하는 함수이름이 부모함수이름 이랑 동일 할 때
	
//	@Override //방파()에 빨간줄로 알려줌
//	void 방파() { //방파() -> 방패()로 착각
//		
//	}
	
	@Override
	void 방패() {
		
	}
	
}

public class Hello {
	public static void main(String[] args) {
		대장장이 t1 = new 나그네1();
		t1.칼();
		t1.방패();
		
		대장장이 t2 = new 나그네2();
		t2.칼();
		t2.방패();
	}
}


// Ex37)

//abstract class Animal{
//	abstract void m1();
//};

//class Tiger extends Animal{
//	void m1() {
//		System.out.println(2);
//	}
//}

//인터페이스로 바꿀수 있으면 왠만하면 인터페이스로 사용
interface Animal{
	void m1();
};

class Tiger implements Animal{
	
	//인터페이스를 상속 받아서 메서드를 만들면 앞에 public이 필요함
	public void m1() { 
		System.out.println(2);
	}
}

public class Hello {
	public static void main(String[] args) {
		Animal a = new Tiger();
		a.m1();
		
		//추상 클래스는 객체 생성 불가(코드가 미완성이라)
//		Animal t2 = new Animal();
		
	}
}

// Ex36)
class Animal{
	void cry() {
		System.out.println("...");
	}
}

class Dog extends Animal{
	void cry() {
		System.out.println("멍멍!");
	}
}

class Cat extends Animal{
	void cry() {
		System.out.println("야옹~");
	}
}

class Snake extends Animal{}

public class Hello {
	public static void main(String[] args) {
		Animal t0 = new Dog();
		Animal t1 = new Cat();
		Animal t2 = new Snake();

		Random rn = new Random();
		for (int i = 0; i < 10; i++) {
			int num = rn.nextInt(3);
			switch (num) {
				case 0: {
					t0.cry();
					break;
				}
				case 1: {
					t1.cry();
					break;
				}
				case 2: {
					t2.cry();
					break;
				}
			}
		}

		System.out.println("---------------------------------");
		for (int i = 0; i < 10; i++) {
			Animal[] t3 = new Animal[] { new Dog(), new Cat(), new Snake() };
			t3[rn.nextInt(3)].cry();
		}
	}
}

//Ex35)랜덤

public class Hello {
	public static void main(String[] args) {
		Random rn = new Random();
		System.out.println(rn.nextInt());
		for (int i = 0; i < 10; i++) {
			int num = rn.nextInt(2);
			System.out.println(num);
			System.out.println(rn.nextInt(10));
		}
	}
}

// Ex34)
public class Hello {
	public static void main(String[] args) {
		int a = 10;
		int[] ar = new int[5];

		int[] br = new int[] { 1, 2, 3, 4, 5 };

		int[] cr = { 10, 20, 30, 40, 50};

		System.out.println(ar.length);
		System.out.println(br.length);
		System.out.println(cr.length);

		for (int i = 0; i < cr.length; i++) {
			int j = cr[i];
			System.out.print(i + " : ");
			System.out.format("%d ", br[i]);
		}
		System.out.println();
		System.out.println("호랑이");

		// i대신 x , data, value 사용
		for (int x : cr) {
			System.out.print(x + " ");
		}
		
		//유효범위 : cr같은경우 메모리가 5개 []범위는 0~4까지 사용가능
		cr[0] = 100;
		cr[4] = 300;
//		cr[5] = 400; 유효범위를 벗어나서 에러
		
//		ar[-1] = 100; 유효범위 벗어남
		
		int num = 3;
		ar[num] = 500;
		
		ar[num*3 - 5] = 100;
		
		ar[2] = 3;
		ar[ar[2]] = 999;
		System.out.println();
		System.out.println(ar[2] + " " + ar[3]);
		
		ar[ar[3]-998] = 888;

		for (int x : ar) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("------------------------------");
		
		boolean[] dr = {false,false,true,true};
		for (boolean x : dr) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("------------------------------");
		
		String[] ss = new String[4];
		ss[0] = "호랑이";
		ss[1] = "사자";
		ss[2] = "사슴";
		ss[3] = "사마귀";
		
		for (int i = 0; i < ss.length; i++) {
			String string = ss[i];
			System.out.println(string);
		}
		
		String[] st = new String[] { "해바라기", "국화", "무궁화"};
		String s1 = "호랑이";
		String s2 = new String("독수리");
		String[] su = new String[] { new String("민들레"), s2, "무궁화"};
	}
}


// Ex33)
class Animal{
	void cry() {
		System.out.println("...");
	}
}

class Dog extends Animal{
	void cry() {
		System.out.println("멍멍!");
	}
}

class Cat extends Animal{
	void cry() {
		System.out.println("야옹~");
	}
}

class Snake extends Animal{}


class Zoo {
	
// 개방 폐쇄의 원칙 : 확장에는 열려있으나 수정은 닫혀있다.
//	void sound(Dog t) {
//		t.cry();
//	}
//
//	void sound(Cat t) {
//		t.cry();
//	}
//
//	void sound(Snake t) {
//		t.cry();
//	}
	
	void sound(Animal t) {
		t.cry();
	}
}

public class Hello {
	public static void main(String[] args) {
		Animal t1 = new Dog();
		Animal t2 = new Cat();
		Animal t3 = new Snake();
		
		t1.cry();
		t2.cry();
		t3.cry();
		
		System.out.println("-----------------");
		Dog t4 = new Dog();
		Cat t5 = new Cat();
		Snake t6 = new Snake();
		
		t4.cry();
		t5.cry();
		t6.cry();
		System.out.println("-----------------");

		Zoo t7 = new Zoo();
		t7.sound(new Dog());
		t7.sound(new Cat());
		t7.sound(new Snake());
	}
}


//Ex32)
class Animal{
	void m1() {
		System.out.println(1);
	}
	void m3() {
		System.out.println(31);
	}
}

class Tiger extends Animal{
	void m2() {
		System.out.println(2);
	}
	void m3() {
		System.out.println(32);
	}
}

public class Hello {
	public static void main(String[] args) {
		Animal t1 = new Animal(); //case1
		Tiger t2 = new Tiger();   //case2
		Animal t3 = new Tiger();  //case3 업캐스팅(부=자 관계) : 자식의 메모리를 쳐다보게 하기 위해
		t3.m1();// 1
		t3.m3();// 32 자식에게 똑같은 이름의 메서드가 있으면 자식꺼 사용
//		Tiger t4 = new Animal();  //case4 다운캐스팅
	}
}

// Ex31)
class Animal {
	Animal(){
		System.out.println("부모 생성자 콜");
	}
	
	Animal(int n){
		System.out.println("부모"+n);
	}
	
	Animal(int a, int b){
		System.out.println("부모a*b : "+a*b);
	}
}
class Tiger extends Animal{
	Tiger(){
		//현재라인에 코드가 한줄 생략 되어있다.
		super();
		System.out.println("자식 생성자 콜");
	}
	
	Tiger(int num){
		super(num + 100);
		System.out.println(num + "콜");
	}
	
	Tiger(int a, int b){
		super(2,3);
		System.out.println("3번째 생성자");
//		super(); 여기에 쓰면 에러 super()는 반드시 제일 위에 있는걸로 정해져있다.(생략시에도 맨위)
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		
		System.out.println("--------------------------------");
		Tiger t2 = new Tiger(100);
		
		System.out.println("--------------------------------");
		Tiger t3 = new Tiger(2,3);
	}
}

// Ex30)

class Animal{
	void m2() {
		System.out.println(2);
	}
	void m3() {
		System.out.println(31);
	}
}

class Tiger extends animal{ //호랑이는 동물이다(is a) 상속 관계
	void m1() {
		System.out.println(1);
	}
	void m3() {
		System.out.println(32);
	}
	void m4() {
		System.out.println(4);
		m3();
		super.m3();
	}
}

public class Hello {
	public static void main(String[] args) {
		animal t1 = new animal();
		
		Tiger t2 = new Tiger();
		t2.m1(); //1
		t2.m2(); //2
		t2.m3(); //32
		t2.m4(); //4 32
		
		animal t3 = new Tiger();
		
	}
}

// Ex28)
class Tiger{
	
	//컴파일 되면 객체 생성 여부와 관계없이 생성 됨, 객체끼리 공통으로 사용하는 변수
	static int num2 = 100;
	
	int num1;
	
	//컴파일 되면 객체 생성 여부와 관계없이 생성 됨, 비용이 많이 드는 코드(속도,메모리에 안좋음)
	//비용이 많이 드는 객체를 생성 안하고 사용하려고 함(비용 아낄려고)
	//수학 관련 함수들 속도를 조금이라도 높여 보려고 static 함수로 사용
	//예) 
	static void m1() {
		System.out.println("static 함수 콜");
		System.out.println(Math.abs(-10));
	}
}

public class Hello {
	public static void main(String[] args) {
		//static은 클래스이름으로 접근하는것이 원칙(그러나 객체이름으로도 할 수는 있지만 혼란을 일으킬 수 있다.)
		System.out.println(Tiger.num2); //100 Tiger 객체 생성 없이 사용
		
		Tiger t1 = new Tiger();
		System.out.println(t1.num2); //100
		Tiger t2 = new Tiger();
		t2.num2 = 200;
		
		System.out.println(t1.num2); //200
		System.out.println(Tiger.num2); //200
		
		Tiger.m1();
	}
}

// Ex27)
class Car {
	String name;
	int fuel = 100;
	
	Car() {
		name = "무명";
		System.out.println("default call");
	}
	
	Car(String n, int f) {
		System.out.println("인수있는 생성자 콜");
		fuel = f;
		name = n;
	}
	
	void move(String name){
		System.out.println(name + " 자동차 달린다~~~");
		fuel -= 30;
	}
	
	void stop(String name) {
		System.out.println(name + " 자동차 멈춤!");
		fuel -= 10;
	}
	
	//그냥 호출시 100 추가
	void inject() {
		fuel += 100;
	}
	
	//인수 받아서 함
	void inject(int f) {
		fuel += f;
	}
	
	void show() {
		System.out.println(name + " " + fuel);
	}
	
}

public class Hello {
	public static void main(String[] args) {
		Car car1 = new Car();
		car1.move(car1.name);
		car1.stop(car1.name);
		car1.show();
		
		Car car2 = new Car("꼬마",200);
		car2.move(car2.name);
		car2.stop(car2.name);
		car2.show();
	}
}

// Ex26)
class Tiger{
	Tiger(int a,int b){
		
	}
	
	Tiger() {}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger(10, 20);
	}
}
//Ex25)
class Tiger{
	//1.생성자는 함수고 그래서 생성자 함수라고 한다.
	//2.함수 이름은 클래스이름과 반드시 동일해야 한다.
	//3.생성자 함수는 리턴값을 가질 수 없다. 그래서 void 조차도 생략한다.
	//4.생성자 함수도 오버로딩이 가능하다.
	//5.생성자 함수는 객체가 생성 될 때 단 한번 호출된다.(임의로 호출 할 수 없다.)
	//6.생성자를 사용하는 목적은 멤버메서드를 초기화 시키는 목적으로 사용된다.
	//7.생성자 함수를 작성하지 않을시에는 자동으로 디폴트생성자가 만들어 진다.
	
	int age = 20;
	String name = "홍길동";
	
	//디폴트 생성자
	Tiger(){
//		age = 20;
//		name = "홍길동";
		System.out.println("생성자 호출");
	}
	
	Tiger(int a, String n){
		age = a;
		name = n;
	}
	
	void showInfo() {
		System.out.println(age + " " + name);
	}
	
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(); //생성자 호출
		t1.showInfo();  //t1 홍길동 20
		
		Tiger t2 = new Tiger(); //생성자 호출
		t2.showInfo();  //t2 홍길동 20
		
		Tiger t3 = new Tiger(100,"독수리"); //생성자 호출
		t3.showInfo();  //t3 독수리 100
		
		Tiger t4 = new Tiger(200,"앵무새"); //생성자 호출
		t4.showInfo();  //t4 앵무새 200
	}
}

//Ex24)

public class Hello {
	public static void main(String[] args) {
		int a = 100;
		String s1 = Integer.toString(a);
		System.out.println(s1 + 200);
		
		String s2 = a + "";
		System.out.println(s2 + 1200);
		
		String s3 = "456";
		int b = Integer.parseInt(s3);
		System.out.println(b + 234);
		
	}
}

//Ex23) 함수 오버로딩 (함수 재정의)
class Tiger{
	
	void method01() {
		System.out.println(1);
	}
	
	void method01(int a) {
		System.out.println(2);
	}

	void method01(int a, int b) {
		System.out.println(3);
	}

	void method01(String a, int b) {
		System.out.println(3);
	}
	
	int getAreaRect(int a) {
		return a * a;
	}

	int getAreaRect(int width, int height) {
		return width * height;
	}
	
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.method01();
	}
}

//Ex)22
public class Hello {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if(i < 3) {
				continue; //continue 만나면 제어권이 그자리에서 바로 i++
			}
			System.out.println(i);
			if(i == 7) {
				break; //자기자신을 감싸고 있는 가장 가까이 있는 반복문 탈출
			}
		}
		System.out.println("호랑이");
		
		int num = 0;
		while(true) {
			num++;
			if(num % 2 == 0) {
				System.out.println(num);
			}else{
				continue;
			}
			
			if(num == 10) {
				System.out.println("코끼리" + num);
				break;
			}
			
		}
		
	}
}

//Ex21)
class Tiger{
	int m1(int a , int b){
		if(a > b) {
			return 100;
		}else {
			return 200;
		}
	}
	
	void m2(){
		System.out.println(1);
		return;
		//System.out.println(2);
	}
	
	void m3(int num) {
		for(int i = 0; i < 10; i++) {
			if(i == num) {
				System.out.println("찾았다");
				return; //중단용
			};
		}
		System.out.println("못 찾았다.");
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		System.out.println(t.m1(1, 2));
		System.out.println(t.m1(11, 2));
		
		t.m3(3);
	}
}


//Ex20)
class Tiger{
	String m1(){
		return "독수리";
	}
	
	Lion m2() {
		//return new Lion();
		Lion t = new Lion();
		return t;
	}
	
	Lion m3(Lion t) {
		return t;
	}
	
}

class Lion {
	void show() {
		System.out.println(1000);
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		String s1 = t1.m1();
		System.out.println(t1.m1());
		System.out.println(s1);
		
		System.out.println("---------------------------");
		Lion t2 = t1.m3(new Lion());
		t2.show();
		
		System.out.println("---------------------------");
		
		t1.m3(new Lion()).show();
		
	}
}

//Ex19)
class Tiger{
	//주의 m1(int a, b)이렇게 하는 건 안됌
	void m1(int a, int b) {
		System.out.println(a + " " + b);
		System.out.println(a * b);
	}
	
	
	void m2(int a, char b, boolean c, float d, String e) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
	
	void m3(Lion a) {
		System.out.println(a.hashCode());
		a.sound();
	}
}
class Lion{
	void sound() {
		System.out.println("어흥");
	}
}

public class Hello {
	public static void main(String[] args) {
		String s1 = "호랑이gggggggggggggggggggggggggggggggggggggggggggggg";
		System.out.println(s1);
		System.out.println(s1.length());
		
		System.out.println("---------------------------");
		Tiger t1 = new Tiger();
		t1.m1(3, 4);
		
		System.out.println("---------------------------");
		t1.m2(10, '한', true, 3.14f, "호랑이");
		
		System.out.println("---------------------------");
		Lion t2 = new Lion();
		System.out.println(t2.hashCode());
		t1.m3(t2);
		
		System.out.println("---------------------------");
		t1.m3(new Lion());
	}
}

//Ex18)
class Tiger{
	// 필드(클래스안에서 선언되는변수)
	int a;
	int b = 20;
	int c,d = 30;
	// 생성자
	
	// 메서드(함수function)
	void merry() {
		System.out.println("멍");
	}
	
	void happy(int num) {
		for(int i = 0; i < num ; i++) {
			System.out.println("왕");
		}
	}
	
	int turtle(int num) {
		System.out.println("거북거북");
		int sum = 0;
		for (int i = 1; i < num + 1; i++) {
			sum += i;
		}
		return sum;
	}
	
	int fish(int num) {
		System.out.println("fish fish");
		int n = num * 3;
		return n;
	}
	
	//return값   인수전달
	//   X         X
	//   X         O
	//   O         X
	//   O         O
}

public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		
		for(int i = 0; i < 10; i++) {
			t.merry(); 
		}
		
		System.out.println("-----------------------------");
		t.happy(7);
		
		System.out.println("-----------------------------");
		int num = t.turtle(11);
		System.out.println(num);
		
		System.out.println("-----------------------------");
		int ct = t.fish(7);
		System.out.println(ct);
		System.out.println(t.fish(5));
	}
}

// Ex17)클래스
class Tiger{
	// 필드(클래스안에서 선언되는변수)
	int a;
	int b = 20;
	int c,d = 30;
	// 생성자
	
	// 메서드
	
}

public class Hello {
	
	public static void main(String[] args) {
		
		// 객체생성
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		
		// 멤버제어
		t1.a = 10;
		t1.c = t1.a + 30;
		System.out.println(t1.a);// 10
		System.out.println(t1.b);// 20
		System.out.println(t1.c);// 40
		System.out.println(t1.d);// 30
		
		System.out.println(t2.c);// 0
		
		// 객체 식별번호
		System.out.println(t1.hashCode()); // 2111991224
		System.out.println(t2.hashCode()); // 292938459
		
		Tiger t3;
		t3 = t2; // 메모리를 공유한다.(결국 동일함)
		System.out.println(t3.hashCode()); // 292938459
		
		t3.a = 999;
		System.out.println(t2.a); // 999
	}
}


// Ex)
public class Hello {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		short c = 30;
		b = (int)c;
		c = (short)a;
	}
}
//Ex14) 우박수
public class Hello {
	public static void main(String[] args) {
		int n = 77;
		while(n != 1) {
			System.out.println(n);
//			if(n % 2 == 0) {
//				n = n / 2;
//			}else {
//				n = n * 3 + 1;
//			}
			n =  (n % 2 == 0) ? n / 2 : n * 3 + 1; 
		}
		System.out.println(n);
		
		int n2 = 1234;
		int sum = 0;
		while(true) {
			int r = n2 % 10;
			n2 = n2 / 10;
			sum = sum + r;
			if(n2 == 0) {
				break;
			}
		}
		System.out.println(sum);
	}
}
// Ex9)제어문
public class Hello {
	public static void main(String[] args) {
		//1) if
		System.out.println(1);
		if (true) {
			System.out.println(2);
			System.out.println(4);
		};
		System.out.println(3);
		//2) if-else
		if(false) {
			System.out.println(5);
		}else {
			System.out.println(6);
		};
		//3) 삼항연산자
		int a = 10;
		int b = 5;
		int c;
		
		if (a > b) {
			c = 7;
		} else {
			c = 8;
		}
		System.out.println(c);
		
		c = a > b ? 7 : 8;// 논리식 ? 참일때 값 : 거짓일때 값 
		System.out.println(c);//7
		
		if (a > b) {
			System.out.println("호랑이");
		} else {
			System.out.println("코끼리");
		}
		
		System.out.println((a>b)?"호랑이":"코끼리");
		
		// for
		
		// switch
		
		// while
		
	}
}
//Ex7)변수 사용하는 방법
public class Hello {
	public static void main(String[] args) {
		//1)
		int a;
		a = 10;
		System.out.println(a);
		
		//2)
		int b,c,d;
		b=1;
		c=2;
		d=3;
		
		System.out.println(b + "" + c);
		System.out.println(b + " " + c);
		System.out.println(b + " " + c + " " + d);
		
		//3)
		int e = 10;
		int f = 20, g = 30;
		int h,i = 40,j; // i 만 40으로 초기화 , h,j 는 아무값도 못받음
		h = 50;
		j = 60;
		System.out.println(e);
		System.out.println(g);
		System.out.println(j);
		
		//4)
		int a10; //첫 글자 숫자X
		a10 = 10;
		System.out.println(a10);
		
		a10 = 20;
		System.out.println(a10);
		
		//5)교환프로그램 (자연스럽게 외울수 있도록 해야된다.)
		int aa = 88, bb = 99;
		System.out.println("aa " +aa + " bb " + bb);
		
		int temp; //temp = 0;
		temp = aa;//temp = 88;
		aa = bb;  //aa = 99;
		bb = temp;//bb = 88;
		System.out.println("aa " +aa + " bb " + bb);
		
		//6)
		int cc = 100;
		int dd = 200;
		int tt = cc;// 초기화를 cc의 값으로 해버려서 위 코드에 비해 한줄 준다.
		cc = dd;
		dd = tt;
		System.out.println(cc +" "+ dd);
		
		//7)산술연산, 비교연산
		int a2 = 17, b2 = 3;
		System.out.println(a2 + b2);
		System.out.println(a2 - b2);
		System.out.println(a2 * b2);
		System.out.println(a2 / b2);
		System.out.println(a2 % b2);
		
		System.out.println(a2 > b2);
		System.out.println(a2 >= b2);
		System.out.println(a2 < b2);
		System.out.println(a2 <= b2);
		System.out.println(a2 == b2);
		System.out.println(a2 != b2);
		
		System.out.println(a2 > b2*7);// 산술 -> 비교 -> 논리 순으로 연산이 일어난다.
		System.out.println(a2 > b2*7 || a2-10 > b2);
		
	}
}
//Ex6)정수, 실수, 문자, boolean 
public class Hello {
	public static void main(String[] args) {
		byte apple;
		apple = -128; // -128 <= apple <= 127
		System.out.println(Byte.MIN_VALUE); // -128  
		System.out.println(Byte.MAX_VALUE); // 127
		
		short banana; //2byte
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		int orange; // 4byte 20억 넘음
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		long mellon; // 8byte 920경
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		banana = 32222;
		System.out.println(banana);
		
		orange = 2000000000;
		System.out.println(orange);
		
		mellon = 333333333333333L;
		System.out.println(mellon);

		//실수
		float tiger; //실수 4byte
		tiger = 3.14f;
		
		double lion; //실수 8byte
		lion = 3.14;

		//문자
		char cat; //유일하게 음수값을 쓸수 없다. 2byte 문자한개 기억
		System.out.println("Char min.: " + (int)Character.MIN_VALUE);
		System.out.println("Char max.: " + (int)Character.MAX_VALUE);
		
		//cat = '1234';이런식으로 사용 안 한다.
		cat = '한';
		System.out.println(cat);

		//boolean
		boolean navy; //1byte true, false
		navy = true;
		System.out.println(navy);
	
	}
}
 
//Ex5) 
public class Hello {
	public static void main(String[] args) {
		System.out.println(10); // 숫자
		System.out.println('한'); // 문자
		System.out.println("호랑이"); // 문자열
		System.out.println("호랑1000이"); // 문자열
		
		System.out.println(10 + 20); // 숫자 + 숫자 = 숫자
		System.out.println(10 + "호랑이"); // 숫자 + 문자열 = 문자열
		System.out.println("호랑이" + 10); // 문자열 + 숫자 = 문자열
		System.out.println("호랑이" + "코끼리"); // 문자열 + 문자열 = 문자열
		
		System.out.println(10 + "호랑이" + 20); // 숫자 + 문자열 + 숫자 = 10호랑이20
		System.out.println(10 + 20 + "호랑이"); // 숫자 + 숫자 + 문자열 = 30호랑이
		System.out.println("호랑이" + 10 + 20 );// 문자열 + 숫자 + 숫자 = 호랑이1020
		System.out.println(10  + " " + 20  ); // 숫자 + 문자열 + 숫자 = 10 20
		
	}
}

//Ex4) 논리연산자
public class Hello {
	public static void main(String[] args) {
		
		System.out.println(false || false);
		System.out.println(false || true);
		System.out.println(true || false);
		System.out.println(true || true);
		
		System.out.println(false && false);
		System.out.println(false && true);
		System.out.println(true && false);
		System.out.println(true && true);
		
		System.out.println(true && true && false);
		System.out.println(false || true || true );
		System.out.println(false || true && true ); // ||, && 같이 사용하면 잘못된 코드
		System.out.println(false && (true || true)); //두개같이 사용할 때 괄호를 사용해야됌
		System.out.println(3 > 2 || false || 6 >= 3);

		System.out.println(!true);
		System.out.println(!(3 > 2));
		
	}
}
 
// Ex3) 비교연산자
public class Hello {
	public static void main(String[] args) {
		System.out.println(5 > 3);
		System.out.println(5 >= 3);
		System.out.println(5 < 3);
		System.out.println(5 <= 3);
		System.out.println(5 == 3);
		System.out.println(5 != 3);
	}
}
	
// Ex2) 산술연산자
public class Hello {
	public static void main(String[] args) {
		System.out.println(20+3);
		System.out.println(20-3);
		System.out.println(20*3);
		System.out.println(20/3);
		System.out.println(20%3);
		System.out.println(3+2*4);
		System.out.println((3+2)*4);
	}
}

// Ex1)
public class Hello {
	public static void main(String[] args) {
		System.out.println("더존1");
	}
}
*/