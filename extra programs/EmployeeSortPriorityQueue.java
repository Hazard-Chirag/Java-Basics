import java.util.Comparator;
import java.util.*;

public class Employee {
	int age;
	String name;
	public Employee(int age, String name){
		
		this.age = age;
		this.name = name;
	}
	
}

public class CompareAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return Integer.compare(o1.age, o2.age);
	}
}

public class Demo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PriorityQueue <Employee> q=new PriorityQueue <Employee>(new CompareAge());
		System.out.println("Enter age and name");
		for(int i=0;i<3;i++)
		{
			int age=sc.nextInt();
			String name=sc.next();
			q.add(new Employee(age,name));
		}
		while(!(q.isEmpty()))
		{
			Employee es=q.poll();
			System.out.println(es.name+""+es.age+"\n");
		}
		for(Employee es: q)
			System.out.println(es.age);
	}

}
