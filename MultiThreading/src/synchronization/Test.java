package synchronization;

class Mydata {
	synchronized public void display(String str) {
		//synchronized (this) {
			for (int i = 0; i < str.length(); i++) {
				System.out.print(str.charAt(i));
			}
		//}
	}
}

class MyThread1 extends Thread {
	Mydata d;

	MyThread1(Mydata d) {
		this.d = d;
	}

	public void run() {
		d.display("Hello World");
	}
}

class MyThread2 extends Thread {
	Mydata d;

	MyThread2(Mydata d) {
		this.d = d;
	}

	public void run() {
		d.display("Welcome");
	}
}

public class Test {
	public static void main(String[] args) {
		Mydata data = new Mydata();
		MyThread1 m1 = new MyThread1(data);
		MyThread2 m2 = new MyThread2(data);
		m1.start();
		m2.start();
	}

}
