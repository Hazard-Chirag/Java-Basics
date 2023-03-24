import java.util.Scanner;
class Student
{
String usn, name, branch,ph;
void accept( )
{
Scanner sc = new Scanner (System.in);
System.out.println(“Enter USN”);
usn=sc.next();
System.out.println(“Enter name”);
name=sc.next();
System.out.println(“Enter branch”);
branch=sc.next();
System.out.println(“Enter phone”);
ph=sc.next();
}
void display()
{
System.out.println(“Student details are”);
System.out.println(“USN=”+usn);
System.out.println(“Name=”+name);
System.out.println(“Branch=”+branch);
System.out.println(“Phone=”+ph);
} }
class StudentMain
{
public static void main(String args[ ])
{
Scanner sc = new Scanner (System.in);
int i,n;
System.out.println(“Enter number of students”);
n=sc.nextInt();
Student s[ ] = new Student[n];
for(i=0; i<n;i++)
{
s[i] = new Student();
s[i].accept();
}
for(i=0; i<n;i++)
{
s[i].display();
  }
 }
}
