import java.util.Scanner;
import java.io.*;
class QE
{
public static void main (String[ ] args)
 {
int a,b,c,d;
double r1,r2;
Scanner sc = new Scanner (System.in);
System.out.print("Enter the values of a, b, c ");
a = sc.nextInt();
b = sc.nextInt();
c = sc.nextInt();
d= b * b - 4 * a * c;
if ( a*b*c == 0)
{
System.out.println("Invalid inputs”);
System.exit(0);
}
 if (d == 0)
{
System.out.println("Roots are real and equal”);
r1 = r2 = -b / (2 * a);
System.out.println(" Root1 =" + r1);
System.out.println("Root2= " + r2);
}
 if (d > 0)
{
System.out.println("Roots are real and different”);
 r1 = (-b + Math.sqrt(d)) / (2 * a);
 r2 = (-b - Math.sqrt(d)) / (2 * a);
System.out.println("Root1=”+r1);
System.out.println("Root2=”+r2);
}
if (d < 0 )
{
System.out.println("Roots are real and imaginary”);
r1= -b / (2 * a);
r2 = Math.sqrt(-d) / (2 * a);
System.out.println("Root1=" + r1+ ”+i” +r2);
System.out.println("Root1=" + r1+ ”-i” +r2);
 }
 }
}
