import java.util.Random;
class Square extends Thread
{
int x;
Square(int n)
{
x = n;
}
public void run( )
{
int sqr = x * x;
System.out.println("Square = " +sqr );
}
}
class Cube extends Thread
{
int x;
Cube(int n)
{
x = n;
}
public void run( )
{
int cub = x * x * x;
System.out.println("Cube = " +cub );
}
}
class Rnumber extends Thread
{
public void run( )
{
Random random = new Random();
for(int i =0; i<5; i++)
{
int ri = random.nextInt(10);
System.out.println("Random Integer generated : " + ri);
Square s = new Square(ri);
s.start( );
Cube c = new Cube(ri);
c.start( );
try
{
Thread.sleep(1000);
}
catch (InterruptedException ex)
{
System.out.println(ex);
}
}
}
}
public class ThreadP
{
public static void main( String[ ] args)
{
Rnumber n = new Rnumber();
n.start( );
}
}
