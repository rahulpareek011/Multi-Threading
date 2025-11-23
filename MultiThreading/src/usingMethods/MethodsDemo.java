package usingMethods;

class MyThread extends Thread{
	public void run() {
		int count = 1;
		while(true) {
			System.out.println(count++ + " My thread");
		}
	}
}

public class MethodsDemo {
	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		//t.setDaemon(true);//daemon threads are dependent thread
		//if the main application is terminating, then the daemon thread will also terminated 
		//t.start(); //execute this line and print only 1 then main method will not wait for its completion it will complete
		//let make main method sleep for limited time and then t.start should print number for that much of time
		//try {Thread.sleep(100);}catch(Exception e) {}
		
		/*
		join- we will make the main method join other thread 
		even if it is daemon thread it should join,
		mean it should wait for that thread to complete
		so, i should call join method on this main thread
		*/
		//Thread mainThread = Thread.currentThread();
		//mainThread.join();//now main thread is joining means daemon thread will running
		
		//now yield method
		t.start();
		
		int count = 1;
		while(true) {
			System.out.println(count++ + " Main");
//			Thread.yield();//it will let other thread to complete so more time will given to "My thread"
			//after commenting yield i see main is running more but before our mythread ran more than main
		}
		
		
	}

}
