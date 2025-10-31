package meaning;
/*
Concurrently
Two or more tasks appear to run at the same time. 
The CPU switches rapidly between them, giving the illusion of parallel execution.
*/

//🔹 MultiThreading in Java
//→ It allows multiple parts (threads) of a program to run concurrently.
//→ It is called a "lightweight process" because multiple threads share the same memory space of a single program.


//Example: Why do we need multiThreading?

public class MultiThreadingNeed {

 static void display() { // Infinite loop method
     int i = 1;
     while (true) {
         System.out.println(i + " Hello");
         i++;
     }
 }

 public static void main(String[] args) {
     // 🔸 Single Thread Execution (default)
     display(); 
     // The above call will keep running forever,
     // so the below loop will NEVER execute.

     int i = 1;
     while (true) { 
         System.out.println(i + " World");
         i++;
     }

     // 🔹 Our Problem:
     // We want both loops (Hello + World) to run simultaneously.
     // But Java runs programs using a single thread by default — the "main" thread.
     // Hence, only one task runs at a time.

     // 🔹 Our Need:
     // To make both loops run together, we must create a separate thread.
     // That’s why we need MultiThreading.
 }
}
