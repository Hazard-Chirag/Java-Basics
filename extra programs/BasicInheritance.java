  import java.util.Scanner;
  class Staff
  {
  String staffId, name;
  long phone, salary;
  void accept()
  {
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Staff Id: ");
  staffId = sc.next();
  System.out.println("Enter Name: ");
  name = sc.next();
  System.out.println("Enter Phone: ");
  phone = sc.nextLong();
  System.out.println("Enter Salary: ");
  salary = sc.nextLong();
  }
  void display()
  {
  System.out.println("Staff Id: " + staffId);
  System.out.println("Name: " + name);
  System.out.println("Phone: " + phone);
  System.out.println("Salary: " + salary);
  }
  }
  class Teaching extends Staff
  {
  String domain, publications[ ];
  void accept()
  {
  super.accept();
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Domain: ");
  domain = sc.next();
  System.out.println("Enter Number of Publications: ");
  int n = sc.nextInt();
  publications = new String[n];
  System.out.println("Enter Publications: ");
  for (int i = 0; i < n; i++)
  {
  publications[i] = sc.next();
  }
  }
  void display()
  {
  super.display();
  System.out.println("Domain: " + domain);
  System.out.println("Publications:");
  for (int i = 0; i < publications.length; i++)
  {
  System.out.println(publications[i]);
  }
  }
  }
  class Technical extends Staff
  {
  String skills[ ];
  void accept()
  {
  super.accept();
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter Number of Skills: ");
  int n = sc.nextInt();
  skills = new String[n];
  System.out.println("Enter Skills:");
  for (int i = 0; i < n; i++)
  {
  skills[i] = scanner.next();
  }
  }
  void display()
  {
  super.display();
  System.out.println("Skills:");
  for (int i = 0; i < skills.length; i++)
  {
  System.out.println(skills[i]);
  }
  }
  }
  class Contract extends Staff
  {
  int period;
  void accept()
  {
  super.accept();
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter Period: ");
  period = sc.nextInt();
  }
  void display()
  {
  super.display();
  System.out.println("Period: " + period);
  }
  }
  class StaffMain
  {
  public static void main(String[] args)
  {
  Teaching teaching = new Teaching();
  Technical technical = new Technical();
  Contract contract = new Contract();
  System.out.println("Enter Details for Teaching Staff Member");
  teaching.accept();
  System.out.println("Enter Details for Technical Staff Member");
  technical.accept();
  System.out.println("Enter Details for Contract Staff Member");
  contract.accept();
  System.out.println("Details for Teaching Staff Member are");
  teaching.display();
  System.out.println("Details for Technical Staff Member are");
  technical.display();
  System.out.println("Details for Contract Staff Member are");
  contract.display();
  }
  }
