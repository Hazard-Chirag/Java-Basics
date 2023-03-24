import java.util.*;

public class Employee implements Comparable<Employee> {
	
	int id;
	String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}

public class Demo{
public static void main(String[] args) {
		int n;
    Scanner sc=new Scanner(System.in);
		ArrayList<Employee> arr = new ArrayList<Employee> ();
    System.out.println("Enter the number of Employees: ");
    n=sc.nextInt();
		System.out.println("Enter the employee details: ");
    for(int i=0;i<n;i++)
    {   
      System.out.println("Enter age and name : ");
      int age=sc.nextInt();
      String name=sc.next();
      arr.add(new Employee(age,name));
    }
		System.out.println("Before Sorting");
		for(Employee i : arr) {
			System.out.println(i);
		}
		
		Collections.sort(arr);
		
		System.out.println("\nAfter Sorting");
		for(Employee j : arr) {
			System.out.println(j);
		}
	}
}
