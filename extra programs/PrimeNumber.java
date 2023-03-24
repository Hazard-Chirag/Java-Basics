import java.util.Scanner;
class Prime
{
public static void main(String[] args)
 {
 int num, i, flag=0;
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter a number: ");
 num = sc.nextInt();
 if(num==0||num==1)
     flag=1;
 else
 {
 for(i=2; i<=num/2; i++)
 {
 if(num%i == 0)
 {
 flag=1;
 break;
 }
 }
 }
 if(flag==0)
{
 System.out.println("It is a prime number");
}
 else
{
 System.out.println("It is not a prime number");
}
 }
}
