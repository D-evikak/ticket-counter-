package ticketcounter;

public enum Gender {
MALE, FEMALE, OTHER;

}
public class Person {
	
	    private String name;
	    private int age;
	    private Gender gender;

	    public Person(String name, int age, Gender gender) {
	        this.name = name;
	        this.age = age;
	        this.gender = gender;
	    }

	    public void displayPerson() {
	        System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender);
	    }
	}
public class Stack {
	    private Person arr[];
	    private int top;
	    private int capacity;

	    // Constructor Empty stack with given size
	    public Stack(int size) {
	        capacity = size;
	        arr = new Person[capacity];
	        top = -1;
	    }

	    // Constructor Initialize stack directly from array
	    public Stack(Person[] inputArr) {
	        capacity = inputArr.length;
	        arr = new Person[capacity];
	        top = -1;
	        for (int i = 0; i < inputArr.length; i++) {
	            arr[++top] = inputArr[i];
	        }
	    }

	    // Push single Person
	    public void push(Person p) {
	        if (top == capacity - 1) {
	            System.out.println("Stack Overflow!");
	            return;
	        }
	        arr[++top] = p;
	    }

	    // Overloaded Push: Push 2 Persons
	    public void push(Person p1, Person p2) {
	        push(p1);
	        push(p2);
	    }

	    // Pop single Person
	    public Person pop() {
	        if (top == -1) {
	            System.out.println("Stack Underflow!");
	            return null;
	        }
	        return arr[top--];
	    }

	    // Overloaded Pop: Pop n Persons
	    public void pop(int n) {
	        for (int i = 0; i < n; i++) {
	            Person p = pop();
	            if (p != null) {
	                System.out.print("Popped -> ");
	                p.displayPerson();
	            } else break;
	        }
	    }

	    // Display all Persons
	    public void display() {
	        if (top == -1) {
	            System.out.println("Stack is empty.");
	            return;
	        }
	        System.out.println("Stack contents (bottom to top):");
	        for (int i = 0; i <= top; i++) {
	            arr[i].displayPerson();
	        }
	    }

	    // Overloaded Display: Show top n Persons
	    public void display(int n) {
	        if (top == -1) {
	            System.out.println("Stack is empty.");
	            return;
	        }
	        if (n > top + 1) n = top + 1;
	        System.out.println("Top " + n + " Persons:");
	        for (int i = top; i > top - n; i--) {
	            arr[i].displayPerson();
	        }
	    }
	}
package ticketcounter;
import java.util.Scanner;

public class TicketCounterStack {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Stack st = null;
System.out.println("Choose initialization:");
System.out.println("1. Empty stack with size");
System.out.println("2. Stack initialized with array of Persons");
 int choice = sc.nextInt();
	        sc.nextLine(); // consume newline

	        if (choice == 1) {
	            System.out.print("Enter size: ");
	            int size = sc.nextInt();
	            st = new Stack(size);
	        } else if (choice == 2) {
	            System.out.print("Enter number of Persons: ");
	            int n = sc.nextInt();
	            sc.nextLine();
	            Person arr[] = new Person[n];
	            for (int i = 0; i < n; i++) {
	                System.out.print("Enter name: ");
	                String name = sc.nextLine();
	                System.out.print("Enter age: ");
	                int age = sc.nextInt();
	                sc.nextLine();
	                System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
	                Gender g = Gender.valueOf(sc.nextLine().toUpperCase());
	                arr[i] = new Person(name, age, g);
	            }
	            st = new Stack(arr);
	        }

	        int option;
	        do {
	            System.out.println("\n--- Menu ---");
	            System.out.println("1. Push one Person");
	            System.out.println("2. Push two Persons");
	            System.out.println("3. Pop one Person");
	            System.out.println("4. Pop multiple Persons");
	            System.out.println("5. Display all Persons");
	            System.out.println("6. Display top n Persons");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");
	            option = sc.nextInt();
	            sc.nextLine();

	            switch(option) {
	                case 1: {
	                    System.out.print("Enter name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Enter age: ");
	                    int age = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
	                    Gender g = Gender.valueOf(sc.nextLine().toUpperCase());
	                    st.push(new Person(name, age, g));
	                    break;
	                }
	                case 2: {
	                    System.out.println("Enter details of Person 1:");
	                    System.out.print("Name: ");
	                    String name1 = sc.nextLine();
	                    System.out.print("Age: ");
	                    int age1 = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Gender: ");
	                    Gender g1 = Gender.valueOf(sc.nextLine().toUpperCase());

	                    System.out.println("Enter details of Person 2:");
	                    System.out.print("Name: ");
	                    String name2 = sc.nextLine();
	                    System.out.print("Age: ");
	                    int age2 = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Gender: ");
	                    Gender g2 = Gender.valueOf(sc.nextLine().toUpperCase());

	                    st.push(new Person(name1, age1, g1), new Person(name2, age2, g2));
	                    break;
	                }
	                case 3: {
	                    Person popped = st.pop();
	                    if (popped != null) {
	                        System.out.print("Popped -> ");
	                        popped.displayPerson();
	                    }
	                    break;
	                }
	                case 4: {
	                    System.out.print("Enter number of Persons to pop: ");
	                    int n = sc.nextInt();
	                    sc.nextLine();
	                    st.pop(n);
	                    break;
	                }
	                case 5:
	                    st.display();
	                    break;
	                case 6: {
	                    System.out.print("Enter number of top Persons: ");
	                    int topN = sc.nextInt();
	                    sc.nextLine();
	                    st.display(topN);
	                    break;
	                }
	                case 7:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        } while(option != 7);
	    }
	}
