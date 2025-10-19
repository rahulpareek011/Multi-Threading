package starting;

public class Demo extends Thread{//you have to extend Thread
	public void run() {
		System.out.println("Task by "+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		//Thread is predefined in java.lang package
		Thread currentThread = Thread.currentThread();//static method of Thread Class
		System.out.println(currentThread);//Thread[#1,main,5,main]
		//coz it returns reference of current thread
		//internally calls Threads.toString()
		//return "Thread["+ getId() + "," + getName() + "," + getPriority() + "," + getThreadGroup().getName() + "]";
		//starting Thread is -> Class name
		System.out.println(currentThread.getId());//1 -> Thread ID — unique number assigned by JVM
		System.out.println(currentThread.getName());//main -> Thread name (default for main thread)
		System.out.println(currentThread.getPriority());//5 -> Thread priority (default = 5, range = 1–10)
		System.out.println(currentThread.getThreadGroup().getName());//main -> Thread group name
		
		
		Demo d1 = new Demo();
		d1.run();//Here you are calling the method directly, like a normal function call.
		//It does not start a new thread.
		//using main thread
		//Thread implements Runnable[functional Interface]
		Thread t1 = new Thread(d1);
		t1.start();//using new thread
		//main thread → t1.start() 
        //↓ (new thread created by JVM)
    //new thread → calls d1.run() → prints message
		Thread t2 = new Thread(d1);
		t2.start();

	}

}
