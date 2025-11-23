package Challenge;

// Shared resource between Teacher (writer) and Students (readers)
class WhiteBoard {
    String text;                 // Latest message written on board
    int numOfStudent = 0;        // Total students present (for attendance)
    int count = 0;               // Number of students left to read current message

    // Called by each student when it starts (to register total students)
    public void attendance() {
        numOfStudent++;
    }

    // Teacher writes a message
    synchronized public void write(String msg) {
        System.out.println("Teacher is writing: " + msg);

        // If count != 0, it means previous message is not yet read by all students
        // So teacher must wait before writing new text
        while (count != 0)
            try { wait(); } catch (Exception e) {}

        // Now safe to write
        text = msg;

        // Set count = number of students → all must read this message
        count = numOfStudent;

        // Wake up all students waiting to read message
        notifyAll();
    }

    // Students read the message
    synchronized public String read() {

        // If no new message → wait for teacher to write
        while (count == 0)
            try { wait(); } catch (Exception e) {}

        // Read the current message
        String t = text;

        // After reading, reduce the number of students left to read
        count--;

        // If last student has read → notify teacher to write next message
        if (count == 0)
            notify();

        return t;
    }
}

class Teacher extends Thread {
    WhiteBoard wb;

    Teacher(WhiteBoard w) {
        wb = w;
    }

    // Messages to write
    String notes[] = {
        "Java is a language",
        "It is Oops",
        "It is platform Independent",
        "It supports Thread",
        "end"
    };

    public void run() {
        for (int i = 0; i < notes.length; i++) {
            wb.write(notes[i]);  // Teacher writes one message at a time
        }
    }
}

class Student extends Thread {
    String name;
    WhiteBoard wb;

    Student(String n, WhiteBoard b) {
        name = n;
        wb = b;
    }

    public void run() {
        String text;

        // Register presence so teacher knows total readers
        wb.attendance();

        // Continuously read until "end" message arrives
        do {
            text = wb.read();
            System.out.println(name + " reading: " + text);
            System.out.flush();
        } while (!text.equals("end"));
    }
}

public class WhiteBoardProblemTesting {
    public static void main(String[] args) {
        
        WhiteBoard wb = new WhiteBoard();
        Teacher t = new Teacher(wb);

        Student s1 = new Student("1. Rahul", wb);
        Student s2 = new Student("2. Hariom", wb);
        Student s3 = new Student("3. Dev", wb);
        Student s4 = new Student("4. Rohit", wb);

        // Start threads
        t.start();
        s1.start();
        s2.start();
        s3.start();
        s4.start();
    }
}

/*
 	Explanation
Problem:
Teacher writes notes.
All students must read each note before teacher writes the next one.

Solution Approach:
This is a Producer–Consumer problem where:

Teacher = Producer (writes messages)
Students = Consumers (read messages)

Why wait() & notify()?
Teacher must wait until ALL students read the previous message (count != 0)
Students must wait until teacher writes a message (count == 0)
notifyAll() wakes all students to read the new message
notify() wakes the teacher when the last student finishes reading

Why count & numOfStudent?
numOfStudent: total students (attendance)
count: number of students who still need to read current message
This ensures perfect synchronization & order.

 */
















