package Pack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

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
*/

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

class Person /* implements Comparable<Person> */{ //treeSet, treeMap
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
//		System.out.println(start + " " + end + "������ �ܾ� �˻�");
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
		
		//���� ���� �˻�
//		NavigableMap<Integer, String> nvm = trm.subMap(50, true, 88, true);
//		for(Map.Entry<Integer, String> asd : nvm.entrySet()) {
//			System.out.println(asd.getKey() + " " + asd.getValue());
//		}

		// Comparable�� ���� ���� ������ ClassCastExeption�߻� 
		// Comparator�������̽��� ������ Asd()Ŭ���� �����ؼ� �����߻��� ���������ִ�.
		TreeSet<Person> trs = new TreeSet<Person>(new Asd());
		
		trs.add(new Person("��", 22));
		trs.add(new Person("��", 66));
		trs.add(new Person("ȫ", 44));
		trs.add(new Person("��", 84));
		trs.add(new Person("��", 14));
		
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
//			System.out.println("������ ���� " + coin.getValue());
//		}
		
		//7.Queue
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "��1"));
		messageQueue.offer(new Message("sendSMS", "��2"));
		messageQueue.offer(new Message("sendkakaotalk", "��3"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch (message.command) {
			case "sendMail": System.out.println(message.to+" �Կ��� ������ �����ϴ�."); break;
			case "sendSMS": System.out.println(message.to+" �Կ��� SMS�� �����ϴ�."); break;
			case "sendkakaotalk": System.out.println(message.to+" �Կ��� ī���� �����ϴ�."); break;
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

/*

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
//				System.out.println(i + " ��° ã�Ҵ�.");
//				break;
//			}
//			
//			if(i == mm.size()-1) {
//				System.out.println("�� ã�Ҵ�.");
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

		// Ǯ��
		// 1.
//		for (int i = 0; i < mm.size(); i++) {
//			int num = mm.get(i);
//			if(num % 2 == 0) {
//				mm.remove(i);
//				i--; //i++�� �Ǹ� �����ɰ�� �ǳʶٰ� ��
//			}
//		}
		
		// 1-2.�����ڵ�
//		for (int i = 0; i < mm.size();) {
//			int num = mm.get(i);
//			if(num % 2 == 0) {
//				mm.remove(i);
//			}else {
//				i++; 
//			}
//		}
		
		// 2. ���ͷ����� ���
//		for(Iterator<Integer> it = mm.iterator(); it.hasNext();) {
//			Integer num = it.next();
//			if(num % 2 == 0) {
//				it.remove();
//			}
//		}

		// 3. removeIf((Predicate<> ) : ���������� for���� ���鼭 ���ǿ� ���߾ remove
//		mm.removeIf(new Predicate<Integer> (){
//
//			@Override
//			public boolean test(Integer num) {
//				return num % 2 == 0;
//			}
//			
//		});
		
		// 4. ���� �Լ� ���
		mm.removeIf( num -> num % 2 == 0);
		System.out.println(mm);
	}
}

// Ex)49 Collection : LinkedList �����ϰ� ������
// �����̳�<���׸�> : �Ѱ����� �ڷ��� Ÿ�Ը� ������ �� �ִ°� 
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
		int size = mm.size(); // �Լ��� �ѹ��� ȣ���ϵ��� �ϱ����� �̷��� ����Ѵ�.
		
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

//Ex48-2)StringBuffer�� �̿��� ������ ���

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
//		System.out.println(hexaToBinary((a & b) >> 8)); // cd 8��Ʈ �̵��ض�
//		System.out.println(hexaToBinary(a & b >> 8)); // 59 8��Ʈ �̵��ض�
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
		
		int c1 = 25; //11�� �ű�������
		int c2 = 42; 
		int c3 = 26;
		int c4;
		
//		System.out.println(Integer.toHexString((c1<<11 | c2 << 5 | c3))); 
		
		// 0000 0000 1101 1100
		char c5 = 0x00dc; //
		char mask = 0x0080; //2.����ũ���� ��ü�� ����Ʈ �ǰ� �ִ°�?
		
		//1. ���ڿ� �迭 �ִ°�?
		String[] arr = {"�����","����������","��ǳ��","���","������","��������","���������̱�","���ڷ�����"};

		for(int i = 0; i < 8; i++, mask >>= 1 ) {
			//3. ���׿��� �Ǿ��ִ°�?
			System.out.println((c5 & mask) == mask ? arr[i] + " on" : arr[i] + " off");
		}
		
	}
}
//����Ʈ ���� �����°��� 0 �����°��� �ҽ�


// Ex48-2)StringBuffer�� �̿��� ������ ���

public class Hello {
	
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
//		System.out.println(s);
//		System.out.println(s.length());
		
		while(s.length() < 32) {
			s = "0" + s;
		}
		
		//String ��ü�� insert�Ҽ� �ִ� �޼��尡 ����
		//StringBuffer�� ��ü�� ����,�߰�,���� ����
		
		StringBuffer s1 = new StringBuffer(s);
		
//		��ġ�� �ϳ��� �и�
//		for(int i = 1; i < 8; i++) {
//			s1.insert(4*i+(i-1), " ");
//		}
		
//		�ڿ������� ������ ���� ��������ġ ������ �ʿ� ����.
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

// Ex48-1) ������ ���

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
		String s = "����ȭ�����Ǿ����ϴ�";
		// 1. ����
		System.out.println(s.length());

		// 2. char charAt(int index)
		System.out.println(s.charAt(3));
		
		// 3. int indexOf(String str)
		System.out.println(s.indexOf("ȭ����")); //2
		
		System.out.println(s.indexOf("�����")); //-1
		
		int n = s.indexOf("ȭ����");
		if(n != -1) {
			System.out.println("found"); //2
		}else {
			System.out.println("not found"); //2
		}
		
		// 4. String replace(CharSequence target, CharSequence replacement)
		System.out.println(s.replace("����", "������"));//����������ȭ ������ �Ǿ����ϴ� ������
		// ����: 
		System.out.println(s); // ���̹���ȭ���� �Ǿ����ϴٲ���

		//String�� ��������ü�� �����ų�� ����.
		//s="���ѹα�"; //������ ��ü�� ������ "���ѹα�"�̶�� ���ο� ��ü�� ���� 
		//System.out.println(s);
		
		// 5. slicing
		System.out.println(s.substring(6));
		System.out.println(s.substring(3,6));
		
		// 6. trim
		String s2= "   App   le   ";
		System.out.print(s2.trim());
		System.out.println("ȣ����");
		
		// 7. ��ҹ��� ����
		String s3 = "APpLe";
		System.out.println(s3.toUpperCase());
		System.out.println(s3.toLowerCase());
		
		// 8. String(byte[] bytes, int offset, int length) : �����͸� �޾�����
		byte[] data = new byte[] {
				65, 'B', 'C', 'D'
			};
		
		String s4 = new String(data, 0, data.length);
		System.out.println(s4);
		
		//  �����͸� �����Ҷ�
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
			System.out.println("Exception �߻���");
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
			int a = 10 / 0; // ArithmeticException�߻� ���α׷� ����
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(2);
		
		System.out.println("----------------------------------------");
		
		// ArrayIndexOutOfBoundsException �߻�
		int[] ar = {1,2,3};
		try {
			ar[3] = 10;
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�ȸ���");

		System.out.println("----------------------------------------");
		String s = "����ȭ�����Ǿ����ϴ�.";
		System.out.println(s.length());
		
		//NullPointerException �߻�
		s = null;
		try {
			System.out.println(s.length());
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�ȸ���");
	}
}

//Ex45-4)
//���� : �Լ��� ȣ���Ҷ� ���� �ΰ������� ȣ���ϰ� �ִ�.
class Baduk{
	Ai ai;
	
	Baduk(Ai ai) {
		this.ai = ai;
		System.out.println("�뱹�� �����մϴ�.");
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

//Google���� ����
class Alphago implements Ai{
	public void play() {
		System.out.println("�ΰ������� Alphago �Դϴ�.");
	}
	
	@Override
	public void stop() {
		System.out.println("Alphago ��������� �մϴ�.");
	}
}

//Amazon���� ����
class Betago implements Ai{
	public void play() {
		System.out.println("�ΰ������� Betago �Դϴ�.");
	}
	
	@Override
	public void stop() {
		System.out.println("Betago ��������� �մϴ�.");
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
//���� : ���ο� Ŭ������ ���拚���� �ٵ�Ŭ������ play�޼��� �ϳ��� �������Ѵ�.
class Baduk{
	Baduk() {
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play(Ai ai) {
		ai.play();
	}
}

interface Ai{
	void play();
}

//Google���� ����
class Alphago implements Ai{
	public void play() {
		System.out.println("�ΰ������� Alphago �Դϴ�.");
	}
}

//Amazon���� ����
class Betago implements Ai{
	public void play() {
		System.out.println("�ΰ������� Betago �Դϴ�.");
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
//���ο� Ŭ������ ���拚���� �ٵ�Ŭ������ �÷��̸޼��� �ϳ��� �������Ѵ�.
class Baduk{
	Baduk() {
		System.out.println("�뱹�� �����մϴ�.");
	}
	
	void play(Alphago alphago) {
		alphago.play();
	}
	
	void play(Betago betago) {
		betago.play();
	}
}

//Google���� ����
class Alphago{
	void play() {
		System.out.println("�ΰ������� Alphago �Դϴ�.");
	}
}

//Amazon���� ����
class Betago{
	void play() {
		System.out.println("�ΰ������� Betago �Դϴ�.");
	}
}

//������ : �ΰ������� �ٲ�ٸ� ��� �ؾ� �ұ�?
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
		System.out.println("�뱹�� �����մϴ�.");
	}
	
	void play() {
		System.out.println("�ΰ������� ���İ� �Դϴ�.");
	}
	
}

//������ : �ΰ������� �ٲ�ٸ� ��� �ؾ� �ұ�?
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
		// �͸� Ŭ���� ���� 1��° ���
		Animal t1 = new Animal() {
			public void m1() {
				System.out.println("��� �ϱ�! -1-");
			}
		};
		t1.m1();
		
		Zoo t2 = new Zoo();
		t2.sound(new Animal() {
			public void m1() {
				System.out.println("��� �ϱ�! -2-");
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

		// �͸� Ŭ������ �̿��ؼ� ��ü�� �����Ѵ�. (�������� ���� ����)
		Animal t3 = new Animal() {
			@Override
			public void m1() {
				System.out.println(2);
			}
		};

		t3.m1();

		//�͸�ü
		new Animal() {
			@Override
			public void m1() {
				System.out.println(3);
			}
		}.m1();
		
		Zoo t4 = new Zoo();
		
		//�Լ��μ��� ��ü�� �̿��� �ڵ带 ����
		t4.m1(new Animal() {
			@Override
			public void m1() {
				System.out.println(4);
			}
		});
		
	}
}



//Ex43-5) this4��° �̿�� : �ڱ� ������ �ȿ��� �ٸ� �����ڸ� ȣ�� �Ҷ�

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
		this(a+b); //���� �ϳ� ���� ������ ȣ��
		System.out.println(a + " " + b);
	}	

}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(10, 20);
	}
}


// Ex43-4) this3��° �̿�� : �ڽ��� ��ü�� ������ ȣ�������� ���� ��ü�� ������ �̿��Ѵ�.

class Tiger{
	
	void m1() {
		System.out.print("������ �ִ� ����� : ");
		Lion t1 = new Lion();
		if(t1.merry(this) == true) {
			System.out.println("�����մϴ�.");
		}else {
			System.out.println("�Ф�");
		}
	}
	
	int m2() {
		return 50;
	}
	
	String m3() {
		return "����";
	}
}

class Lion {

	boolean merry(Tiger t) {
		System.out.println(t.m2());
		if (t.m2() >= 80) {
			return true;
		} else {
			String s = t.m3();
			System.out.println("���� : " + s);
			switch (s) {
				case "�¼�": 
					return true;
				
				case "����": 
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


//Ex43-3) this2��° �̿�� : �Լ��� ȣ���� ü�̴��ؼ� ���

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
		t1.m1().m2().m1().m2().m3();//ü�̴�
	}
}

//Ex42-2)this1��° �̿��
class Tiger {

//	Tiger this;
//	
//	Tiger(Tiger t){
//		this = t;
//	}

	int a, b, size; //�ʵ庯��

	Tiger(int a, int b, int size) {// ��� �ʵ带 �ʱ�ȭ
		this.a = a; // ��� a = ���޹��� �μ� a 
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
		num = num;// ���� ����(�ڱ� ����), ������� �ڵ�

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
//	} �⺻ �����ڿ� ������ �κ� ��� ǥ���� ���
	
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


// Ex41) final : ����� �ȴ�. (�빮��, ���̻� ���� ������ �� ����, ������ �޴°��� ���Ⱑ ������) 

class Animal{
//final class Animal{ class �տ� final�� ���� ����� �Ұ����ϰ� �Ѵ�.
	final int NUM = 10;
	
	final void m1() {//���Ⱑ ������ �������̵��̴�.
		}
}

class Tiger extends Animal{
//	void m1() {} �θ� final�� �޼��带 �����߱� ������ �� ���·δ� �޼��带 ����� ����.

}




public class Hello {
	public static void main(String[] args) {
		Animal t1 = new Animal();
//		t1.NUM = 20; ��ü�� ������ �ȵȴ�.
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
	void m2(); // �Լ�����(�Լ�������Ÿ��)
}

interface C{
	void m3(); // �Լ�����(�Լ�������Ÿ��)
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

//�������̽� �и� ��Ģ ��Ű�����Ѵ�.
@FunctionalInterface // @FunctionalInterface: �������̽� �ȿ��� �ݵ�� 1���� �޼��常 ����ϱ� ���� �ۼ�
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
		
		//Thread t2 = null : t2�� "���� ��ü�� �ƴϴ�" ����
		Thread t2 = null;
		String t3 = null;
		StringBuffer t4 = null;
	}
}


// Ex39)
interface �ѱ�����{
	void �Ա�();
	void ���();
	void ��ü();
	void ����();
}

class �������� implements �ѱ�����{

	@Override
	public void �Ա�() {
		System.out.println("�������� 3%�Դϴ�.");
	}

	@Override
	public void ���() {
		
	}

	@Override
	public void ��ü() {
		
	}

	@Override
	public void ����() {
		
	}
	
}

class �츮���� implements �ѱ�����{

	@Override
	public void �Ա�() {
		System.out.println("�������� 6% �Դϴ�.");
	}

	@Override
	public void ���() {
		
	}

	@Override
	public void ��ü() {
		
	}

	@Override
	public void ����() {
		
	}
	
}

public class Hello {
	public static void main(String[] args) {
		�ѱ����� t1 = new ��������();
		�ѱ����� t2 = new �츮����();
		
		t1.�Ա�();
		t2.�Ա�();
	}
}


// Ex38)

abstract class ��������{
	void Į() {
		System.out.println("Į�� �� ����ϴ�.");
	}

	// ����å�ӿ�Ģ ���� : Į�� �߸���µ� ���и� ������ ����
//	void ����() {
//		System.out.println("���� ����");
//	}
	
	abstract void ����();
}

//Į�� �߾��� �������̸� �̿�
//���׳״� ������ ���и� ����� �ؾ߉�
class ���׳�1 extends ��������{

	void ����() {
		System.out.println("���� �� ����");
	}
	
}

class ���׳�2 extends ��������{
	
	//@ : ������̼�(���α׷��Ӱ� �Ǽ� �� �� �ִ� ���� �̿��� ���� �ϱ� ���� ���)
	//�������̵� : �ڽ��� ����ϴ� �Լ��̸��� �θ��Լ��̸� �̶� ���� �� ��
	
//	@Override //����()�� �����ٷ� �˷���
//	void ����() { //����() -> ����()�� ����
//		
//	}
	
	@Override
	void ����() {
		
	}
	
}

public class Hello {
	public static void main(String[] args) {
		�������� t1 = new ���׳�1();
		t1.Į();
		t1.����();
		
		�������� t2 = new ���׳�2();
		t2.Į();
		t2.����();
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

//�������̽��� �ٲܼ� ������ �ظ��ϸ� �������̽��� ���
interface Animal{
	void m1();
};

class Tiger implements Animal{
	
	//�������̽��� ��� �޾Ƽ� �޼��带 ����� �տ� public�� �ʿ���
	public void m1() { 
		System.out.println(2);
	}
}

public class Hello {
	public static void main(String[] args) {
		Animal a = new Tiger();
		a.m1();
		
		//�߻� Ŭ������ ��ü ���� �Ұ�(�ڵ尡 �̿ϼ��̶�)
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
		System.out.println("�۸�!");
	}
}

class Cat extends Animal{
	void cry() {
		System.out.println("�߿�~");
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

//Ex35)����

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
		System.out.println("ȣ����");

		// i��� x , data, value ���
		for (int x : cr) {
			System.out.print(x + " ");
		}
		
		//��ȿ���� : cr������� �޸𸮰� 5�� []������ 0~4���� ��밡��
		cr[0] = 100;
		cr[4] = 300;
//		cr[5] = 400; ��ȿ������ ����� ����
		
//		ar[-1] = 100; ��ȿ���� ���
		
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
		ss[0] = "ȣ����";
		ss[1] = "����";
		ss[2] = "�罿";
		ss[3] = "�縶��";
		
		for (int i = 0; i < ss.length; i++) {
			String string = ss[i];
			System.out.println(string);
		}
		
		String[] st = new String[] { "�عٶ��", "��ȭ", "����ȭ"};
		String s1 = "ȣ����";
		String s2 = new String("������");
		String[] su = new String[] { new String("�ε鷹"), s2, "����ȭ"};
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
		System.out.println("�۸�!");
	}
}

class Cat extends Animal{
	void cry() {
		System.out.println("�߿�~");
	}
}

class Snake extends Animal{}


class Zoo {
	
// ���� ����� ��Ģ : Ȯ�忡�� ���������� ������ �����ִ�.
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
		Animal t3 = new Tiger();  //case3 ��ĳ����(��=�� ����) : �ڽ��� �޸𸮸� �Ĵٺ��� �ϱ� ����
		t3.m1();// 1
		t3.m3();// 32 �ڽĿ��� �Ȱ��� �̸��� �޼��尡 ������ �ڽĲ� ���
//		Tiger t4 = new Animal();  //case4 �ٿ�ĳ����
	}
}

// Ex31)
class Animal {
	Animal(){
		System.out.println("�θ� ������ ��");
	}
	
	Animal(int n){
		System.out.println("�θ�"+n);
	}
	
	Animal(int a, int b){
		System.out.println("�θ�a*b : "+a*b);
	}
}
class Tiger extends Animal{
	Tiger(){
		//������ο� �ڵ尡 ���� ���� �Ǿ��ִ�.
		super();
		System.out.println("�ڽ� ������ ��");
	}
	
	Tiger(int num){
		super(num + 100);
		System.out.println(num + "��");
	}
	
	Tiger(int a, int b){
		super(2,3);
		System.out.println("3��° ������");
//		super(); ���⿡ ���� ���� super()�� �ݵ�� ���� ���� �ִ°ɷ� �������ִ�.(�����ÿ��� ����)
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

class Tiger extends animal{ //ȣ���̴� �����̴�(is a) ��� ����
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
	
	//������ �Ǹ� ��ü ���� ���ο� ������� ���� ��, ��ü���� �������� ����ϴ� ����
	static int num2 = 100;
	
	int num1;
	
	//������ �Ǹ� ��ü ���� ���ο� ������� ���� ��, ����� ���� ��� �ڵ�(�ӵ�,�޸𸮿� ������)
	//����� ���� ��� ��ü�� ���� ���ϰ� ����Ϸ��� ��(��� �Ƴ�����)
	//���� ���� �Լ��� �ӵ��� �����̶� ���� ������ static �Լ��� ���
	//��) 
	static void m1() {
		System.out.println("static �Լ� ��");
		System.out.println(Math.abs(-10));
	}
}

public class Hello {
	public static void main(String[] args) {
		//static�� Ŭ�����̸����� �����ϴ°��� ��Ģ(�׷��� ��ü�̸����ε� �� ���� ������ ȥ���� ����ų �� �ִ�.)
		System.out.println(Tiger.num2); //100 Tiger ��ü ���� ���� ���
		
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
		name = "����";
		System.out.println("default call");
	}
	
	Car(String n, int f) {
		System.out.println("�μ��ִ� ������ ��");
		fuel = f;
		name = n;
	}
	
	void move(String name){
		System.out.println(name + " �ڵ��� �޸���~~~");
		fuel -= 30;
	}
	
	void stop(String name) {
		System.out.println(name + " �ڵ��� ����!");
		fuel -= 10;
	}
	
	//�׳� ȣ��� 100 �߰�
	void inject() {
		fuel += 100;
	}
	
	//�μ� �޾Ƽ� ��
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
		
		Car car2 = new Car("����",200);
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
	//1.�����ڴ� �Լ��� �׷��� ������ �Լ���� �Ѵ�.
	//2.�Լ� �̸��� Ŭ�����̸��� �ݵ�� �����ؾ� �Ѵ�.
	//3.������ �Լ��� ���ϰ��� ���� �� ����. �׷��� void ������ �����Ѵ�.
	//4.������ �Լ��� �����ε��� �����ϴ�.
	//5.������ �Լ��� ��ü�� ���� �� �� �� �ѹ� ȣ��ȴ�.(���Ƿ� ȣ�� �� �� ����.)
	//6.�����ڸ� ����ϴ� ������ ����޼��带 �ʱ�ȭ ��Ű�� �������� ���ȴ�.
	//7.������ �Լ��� �ۼ����� �����ÿ��� �ڵ����� ����Ʈ�����ڰ� ����� ����.
	
	int age = 20;
	String name = "ȫ�浿";
	
	//����Ʈ ������
	Tiger(){
//		age = 20;
//		name = "ȫ�浿";
		System.out.println("������ ȣ��");
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
		Tiger t1 = new Tiger(); //������ ȣ��
		t1.showInfo();  //t1 ȫ�浿 20
		
		Tiger t2 = new Tiger(); //������ ȣ��
		t2.showInfo();  //t2 ȫ�浿 20
		
		Tiger t3 = new Tiger(100,"������"); //������ ȣ��
		t3.showInfo();  //t3 ������ 100
		
		Tiger t4 = new Tiger(200,"�޹���"); //������ ȣ��
		t4.showInfo();  //t4 �޹��� 200
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

//Ex23) �Լ� �����ε� (�Լ� ������)
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
				continue; //continue ������ ������� ���ڸ����� �ٷ� i++
			}
			System.out.println(i);
			if(i == 7) {
				break; //�ڱ��ڽ��� ���ΰ� �ִ� ���� ������ �ִ� �ݺ��� Ż��
			}
		}
		System.out.println("ȣ����");
		
		int num = 0;
		while(true) {
			num++;
			if(num % 2 == 0) {
				System.out.println(num);
			}else{
				continue;
			}
			
			if(num == 10) {
				System.out.println("�ڳ���" + num);
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
				System.out.println("ã�Ҵ�");
				return; //�ߴܿ�
			};
		}
		System.out.println("�� ã�Ҵ�.");
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
		return "������";
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
	//���� m1(int a, b)�̷��� �ϴ� �� �ȉ�
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
		System.out.println("����");
	}
}

public class Hello {
	public static void main(String[] args) {
		String s1 = "ȣ����gggggggggggggggggggggggggggggggggggggggggggggg";
		System.out.println(s1);
		System.out.println(s1.length());
		
		System.out.println("---------------------------");
		Tiger t1 = new Tiger();
		t1.m1(3, 4);
		
		System.out.println("---------------------------");
		t1.m2(10, '��', true, 3.14f, "ȣ����");
		
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
	// �ʵ�(Ŭ�����ȿ��� ����Ǵº���)
	int a;
	int b = 20;
	int c,d = 30;
	// ������
	
	// �޼���(�Լ�function)
	void merry() {
		System.out.println("��");
	}
	
	void happy(int num) {
		for(int i = 0; i < num ; i++) {
			System.out.println("��");
		}
	}
	
	int turtle(int num) {
		System.out.println("�źϰź�");
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
	
	//return��   �μ�����
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

// Ex17)Ŭ����
class Tiger{
	// �ʵ�(Ŭ�����ȿ��� ����Ǵº���)
	int a;
	int b = 20;
	int c,d = 30;
	// ������
	
	// �޼���
	
}

public class Hello {
	
	public static void main(String[] args) {
		
		// ��ü����
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		
		// �������
		t1.a = 10;
		t1.c = t1.a + 30;
		System.out.println(t1.a);// 10
		System.out.println(t1.b);// 20
		System.out.println(t1.c);// 40
		System.out.println(t1.d);// 30
		
		System.out.println(t2.c);// 0
		
		// ��ü �ĺ���ȣ
		System.out.println(t1.hashCode()); // 2111991224
		System.out.println(t2.hashCode()); // 292938459
		
		Tiger t3;
		t3 = t2; // �޸𸮸� �����Ѵ�.(�ᱹ ������)
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
//Ex14) ��ڼ�
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
// Ex9)���
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
		//3) ���׿�����
		int a = 10;
		int b = 5;
		int c;
		
		if (a > b) {
			c = 7;
		} else {
			c = 8;
		}
		System.out.println(c);
		
		c = a > b ? 7 : 8;// ���� ? ���϶� �� : �����϶� �� 
		System.out.println(c);//7
		
		if (a > b) {
			System.out.println("ȣ����");
		} else {
			System.out.println("�ڳ���");
		}
		
		System.out.println((a>b)?"ȣ����":"�ڳ���");
		
		// for
		
		// switch
		
		// while
		
	}
}
//Ex7)���� ����ϴ� ���
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
		int h,i = 40,j; // i �� 40���� �ʱ�ȭ , h,j �� �ƹ����� ������
		h = 50;
		j = 60;
		System.out.println(e);
		System.out.println(g);
		System.out.println(j);
		
		//4)
		int a10; //ù ���� ����X
		a10 = 10;
		System.out.println(a10);
		
		a10 = 20;
		System.out.println(a10);
		
		//5)��ȯ���α׷� (�ڿ������� �ܿ�� �ֵ��� �ؾߵȴ�.)
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
		int tt = cc;// �ʱ�ȭ�� cc�� ������ �ع����� �� �ڵ忡 ���� ���� �ش�.
		cc = dd;
		dd = tt;
		System.out.println(cc +" "+ dd);
		
		//7)�������, �񱳿���
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
		
		System.out.println(a2 > b2*7);// ��� -> �� -> �� ������ ������ �Ͼ��.
		System.out.println(a2 > b2*7 || a2-10 > b2);
		
	}
}
//Ex6)����, �Ǽ�, ����, boolean 
public class Hello {
	public static void main(String[] args) {
		byte apple;
		apple = -128; // -128 <= apple <= 127
		System.out.println(Byte.MIN_VALUE); // -128  
		System.out.println(Byte.MAX_VALUE); // 127
		
		short banana; //2byte
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		int orange; // 4byte 20�� ����
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		long mellon; // 8byte 920��
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		banana = 32222;
		System.out.println(banana);
		
		orange = 2000000000;
		System.out.println(orange);
		
		mellon = 333333333333333L;
		System.out.println(mellon);

		//�Ǽ�
		float tiger; //�Ǽ� 4byte
		tiger = 3.14f;
		
		double lion; //�Ǽ� 8byte
		lion = 3.14;

		//����
		char cat; //�����ϰ� �������� ���� ����. 2byte �����Ѱ� ���
		System.out.println("Char min.: " + (int)Character.MIN_VALUE);
		System.out.println("Char max.: " + (int)Character.MAX_VALUE);
		
		//cat = '1234';�̷������� ��� �� �Ѵ�.
		cat = '��';
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
		System.out.println(10); // ����
		System.out.println('��'); // ����
		System.out.println("ȣ����"); // ���ڿ�
		System.out.println("ȣ��1000��"); // ���ڿ�
		
		System.out.println(10 + 20); // ���� + ���� = ����
		System.out.println(10 + "ȣ����"); // ���� + ���ڿ� = ���ڿ�
		System.out.println("ȣ����" + 10); // ���ڿ� + ���� = ���ڿ�
		System.out.println("ȣ����" + "�ڳ���"); // ���ڿ� + ���ڿ� = ���ڿ�
		
		System.out.println(10 + "ȣ����" + 20); // ���� + ���ڿ� + ���� = 10ȣ����20
		System.out.println(10 + 20 + "ȣ����"); // ���� + ���� + ���ڿ� = 30ȣ����
		System.out.println("ȣ����" + 10 + 20 );// ���ڿ� + ���� + ���� = ȣ����1020
		System.out.println(10  + " " + 20  ); // ���� + ���ڿ� + ���� = 10 20
		
	}
}

//Ex4) ��������
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
		System.out.println(false || true && true ); // ||, && ���� ����ϸ� �߸��� �ڵ�
		System.out.println(false && (true || true)); //�ΰ����� ����� �� ��ȣ�� ����ؾ߉�
		System.out.println(3 > 2 || false || 6 >= 3);

		System.out.println(!true);
		System.out.println(!(3 > 2));
		
	}
}
 
// Ex3) �񱳿�����
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
	
// Ex2) ���������
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
		System.out.println("����1");
	}
}
*/