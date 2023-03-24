public interface Resume
{
void biodata();
}
class Teacher implements Resume
{
String name,qualification,achievements;
int experience;
public void biodata()
{
    name="CHIRAG";
    qualification="M.Tech";
    experience=10;
    achievements="Q1 publication";
    System.out.println("Teacher Resume");
    System.out.println("Name: " +name);
    System.out.println("Qualification : "+qualification);
    System.out.println("Experience : "+experience);
    System.out.println("Achievements : "+achievements);
}
}
class Student implements Resume
{
  String name,discipline;
  double result;
  public void biodata()
  {
    name="Odarsh";
    result=9.5;
    discipline="Computer Science and Engineering";
    System.out.println("Student Resume");
    System.out.println("Name : " +name);
    System.out.println("Result : "+result);
    System.out.println("Discipline : "+discipline);
 }
}
public class Seven
{
  public static void main(String[] args)
  {
      Teacher t=new Teacher();
      t.biodata();
      Student s=new Student();
      s.biodata();
   }
 }
