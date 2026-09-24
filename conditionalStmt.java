import java.util.*;
public class conditionalStmt {
  public static void main (String[] args )
  {
   /*if condition 
    int a = 10 ;
    if (a == 10){
    System.out.println("a is 10");
    }*/

    // if else comdition

    Scanner sc = new Scanner(System.in);
    /*

    System.out.println("Enter age");
    int age = sc.nextInt();

    if(age >= 18)
    {
      System.out.println("u r eligible to voting");
    }
    else {
      System.out.println("u r not eligible to voting");
    }*/
    
    // nested if else 

    // student grade 
   System.out.println("number is ");
   int num = sc.nextInt();
/* 
    if (num ==10){
      System.out.println("number is "+ num);
    }
    else if(num==20)
    {
      System.out.println("number is "+ num);
    }
    else if(num==30)
    {
      System.out.println("number is "+ num);
    }
    else {
      System.out.println("number is not foun ");
    }*/



    // switch statement 
    /*switch(num)
    {
     case 10:
      System.out.println("number:"+num);
      break;

       case 60:
      System.out.println("number:"+num);
      break;

       case 20:
      System.out.println("number:"+num);
      break;

       case 30:
      System.out.println("number:"+num);
      break;

       case 50:
      System.out.println("number:"+num);
      break;
      default:
      System.out.println("number not present :"+num);
    
      
    }*/



    // tearnary operator 

   String age = (num > 18) ? "u r eligible " : "u r not eligible ";
    System.out.println(age);


}
}
