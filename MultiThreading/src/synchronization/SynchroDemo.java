package synchronization;


//METHOD LEVEL SYNCHRONIZATION - 
class Display{
	public synchronized void wish(String name) {//why InterruptedException using?
		for(int i=1; i<=5;i++) {
			System.out.print("Good evening ");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			System.out.println(name);
		}
	}
}

class MyThread extends Thread{
	Display d;
	String name;
	
	public MyThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}

public class SynchroDemo {

	public static void main(String[] args) {
		Display d = new Display();
		MyThread t1 = new MyThread(d,"rahul");
		MyThread t2 = new MyThread(d,"rohit");
		
		t1.start();
		t2.start();
		
		//if we declare wish method as synchronize than the threads will be executed one by one
		//that is until completing the first thread the second thread will wait. 
		//in this case will get the regular output
		
		
		/*
		 if there is two different object than it doesn't matter  
		 the method is synchronized or not the object will return alternatively
		 eg. 
		 Display d1 = new Display();
		 Display d2 = new Display();
		MyThread t1 = new MyThread(d1,"rahul");
		MyThread t2 = new MyThread(d2,"rohit");
		
		t1.start();
		t2.start();
		 */

	}

}
