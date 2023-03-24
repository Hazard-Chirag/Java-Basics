class Calculator
{
public static void main(String[] args)
{
char op;
 int num1, num2, result;
Scanner sc = new Scanner(System.in);
System.out.println("Enter an operator");
 op = sc.next().charAt(0);
System.out.println("Enter first number");
 num1 = sc.nextInt();
System.out.println("Enter second number");
 num2 = sc.nextInt();
switch (op)
{
case '+':result = num1 + num2;
 break;
 case '-':result = num1 - num2;
 break;

case '*':result = num1 * num2;
 break;
case '/': if(num2==0)
          return;
          else
          result = num1 / num2;
 break;
case '%':result = num1 % num2;
 break;
 default: System.out.println("Invalid operator!");
 return;
 }
System.out.println(num1+” “ + op + " " + num2+”=”+result);
 }
}
