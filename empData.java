class emp{
  int id;
  String name;
  double salray;

  public  emp( int id ,String name , double salray)
    {
      this.id = id;
      this.name = name;
      this.salray = salray;

    }

    
    public void  display()
        {
          
            System.out.println(id);  
            System.out.println(name);
            System.out.println(salray);
        }
}


class main
{
  public static void display(emp e)
  {
        e.display();
  }
}

public class empData {
  public static void main(String[] args)
  {
    
emp e1 = new emp (20,"mayuri",20000);

emp e2 = new emp  (30,"sheetal",50000);

main.display(e1);
main.display(e2);
}
}