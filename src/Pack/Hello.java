package Pack;

/*  
// Ex)
class Tiger{
	
}

public class Hello {
	public static void main(String[] args) {
		System.out.println("1000");
	}
}
*/

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

/*

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