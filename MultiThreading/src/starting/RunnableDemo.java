package starting;

public class RunnableDemo implements Runnable {//runnable functional Interface have single abstract method
	
	public void run() {//must implement abstract method Runnable.run
		System.out.println("Task By "+Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		RunnableDemo rd = new RunnableDemo();
		rd.run();
		
		Thread t1 = new Thread(rd);
		t1.start();
		Thread t2 = new Thread(rd);
		t2.start();
		//why implementing runnable is preferred over extending Thread
		//Implements Runnable can extend another class but extending not
		//Thread object used once while Runnable reused with multiple threads
		//Always prefer implementing Runnable in real projects
	}

}
