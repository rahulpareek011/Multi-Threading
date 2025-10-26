package starting;

public class MainThread {
	public static void main(String[] args) {
		//main Thread in java, byDefault jvm create one main thread to run main method 
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread);//Thread[#1,main,5,main]
		System.out.println(currentThread.getName());
	}
}
