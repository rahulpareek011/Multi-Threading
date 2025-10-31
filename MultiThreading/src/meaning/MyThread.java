package meaning;

class Test extends Thread{//Thread[class]
	public void run() {
		int i=1;
		while(true) {
			System.out.println(i+"Hello");
			i++;
		}
	}
	
}

public class MyThread {
	public static void main(String[] args) {
		Thread t = new Thread();//Thread object which will run run()
		t.start();//this will run the run() method which is present in runnable interface but part of Thread Clss
		int i=1;
		while(true) {
			System.out.println(i+" World");
			i++;
		}

	}

}
