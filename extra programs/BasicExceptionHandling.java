import java.util.*;
public class TryP
{
int c;
void div(int a,int b)
{
try
{
c=a/b;
System.out.println("Result="+c);
}
catch(ArithmeticException e)
{
System.out.println("Cannot divide by zero");
}
}
public static void main(String args[ ])
{
TryP obj=new TryP( );
int n1,n2;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the values of a");
n1=sc.nextInt();
System.out.println("Enter the values of b");
n2=sc.nextInt();
obj.div(n1,n2);
}
}
