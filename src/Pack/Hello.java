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
*/

//Ex)
class Animal{
	
}

class Tiger extends Animal{
	
}

public class Hello {
	public static void main(String[] args) {
		System.out.println("1000");
	}
}

/*

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