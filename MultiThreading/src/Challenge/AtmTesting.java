package Challenge;

// Customer thread representing a person using the ATM
class Customer extends Thread {
    Atm atm;
    String name;
    int amount;

    // Constructor assigning the customer details
    Customer(String name, Atm a, int amount) {
        this.name = name;
        atm = a;
        this.amount = amount;
    }

    // Customer's ATM operations
    void useAtm() {
        // Both operations are synchronized inside Atm class
        atm.checkBalance(name);
        atm.withdraw(name, amount);
    }

    // Thread's run method
    public void run() {
        useAtm();
    }
}

// Shared resource class
class Atm {

    // synchronized → only one customer/thread can check balance at a time
    synchronized void checkBalance(String name) {
        System.out.println(name + " balance is checking...");
        
        // Simulating time taken by ATM to fetch balance
        try { Thread.sleep(1000); } catch (Exception e) {}

        System.out.println("Balance checked for " + name);
    }

    // synchronized → ensures withdrawing is done by one thread at a time
    synchronized void withdraw(String name, int amount) {
        System.out.println(name + " is withdrawing...");
        
        // Simulating processing delay
        try { Thread.sleep(1000); } catch (Exception e) {}

        System.out.println(name + " withdrew: " + amount);
    }
}

public class AtmTesting {
    public static void main(String[] args) {
        
        // Single ATM shared by two customers (shared resource)
        Atm atm = new Atm();
        
        // Two customer threads trying to use the same ATM
        Customer c1 = new Customer("Rahul", atm, 100);
        Customer c2 = new Customer("Rohit", atm, 200);

        // Start threads (parallel execution)
        c1.start();
        c2.start();
    }
}

/*
 EXPLANATION
1. Atm is a shared resource
Both Rahul and Rohit are using one ATM object, so both threads try to access the same methods.

2. Why do we use synchronized?
ATM should be used by one person at a time.
If both threads execute checkBalance() or withdraw() at the same time → output will mix → race condition.
synchronized ensures mutual exclusion:
	Only one thread can enter checkBalance()
	Only one thread can enter withdraw()
	Other thread waits outside until lock is released

3. What happens internally?
When a thread calls a synchronized method:
	It tries to acquire the intrinsic lock of the ATM object
	If the lock is free → thread enters
	If another thread is already inside → it waits
	This ensures thread-safe ATM operations.

4. Why Thread.sleep()?
Just to simulate:
	Time for checking balance
	Time for withdrawing amount
	This makes synchronization effect clearly visible.
	
	
 */






