package FastRecap;
//
//class Test implements Runnable {
//		@Override
//		public void run(){
//			try{
//				System.out.println(Thread.currentThread().getName());
//				for(int i=1;i<=5;i++){
//					Thread.sleep(3000);
//					System.out.println("focus on development");
//				}
//			} catch(Exception e){
//				System.out.println(e);
//			}
//		}
//}
//
//public class Demo{
//	public static void main(String[] args) {
//		//1.New born state
//		Test t = new Test(); 
//
//		Thread t1 = new Thread(t);
//		System.out.println(t1.isAlive());//thread got alive when we start thread
//		t1.setName("Student1");
//
//		//2. Runnable state
//		t1.start();
//		System.out.println(t1.isAlive());
//		
//		
//
//	}


class Test implements Runnable {
//	@Override
//	public synchronized void run(){
//		System.out.println(Thread.currentThread().getName()+" accessing resource");
//	}
	
	@Override
	public synchronized void run(){
		System.out.println(Thread.currentThread().getName());
		
		try {
			Thread.sleep(2000);
			System.out.println("Parking are mei aao");
			
			synchronized(this){ //if we want to add sub-process then we use block synchronization
				System.out.println("Car mei baitho");
				System.out.println("Car chalao");
				System.out.println("Wapas aao aur car ko park kar do");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Demo{
	public static void main(String[] args){
		Test t = new Test();
		Thread t1 = new Thread(t);
		t1.setName("Son1");
		Thread t2 = new Thread(t);
		t2.setName("Son2");
		Thread t3 = new Thread(t);
		t3.setName("Son3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

//}