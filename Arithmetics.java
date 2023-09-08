public class Arithmetics
{
 public static void main(String[] args)
 {
     int myId = 12345678;
     int numLet = 8;
     System.out.println("My first name is Leonardo");
     System.out.println("My 8 digit number is " + myId);
     System.out.println("The number of characters in my first name is " + numLet);
     System.out.println("\n");
     System.out.println("Expression 1 --> " + myId%17);
     System.out.println("Expression 2 --> " + (numLet+17)%11);
     System.out.println("Expression 3 --> " + myId/(numLet+800.));
     System.out.println("Expression 4 --> " + (1+2+3+4+5+6+7+8));
     System.out.println("Expression 5 --> " + (15000./(80.+((myId-123456)/((numLet+20.)*(numLet+20.))))));
 }
}
/*----------Run----------
My first name is Leonardo
My 8 digit number is 12345678
The number of characters in my first name is 8

Expression 1 --> 6
Expression 2 --> 3
Expression 3 --> 15279.304455445545
Expression 4 --> 36
Expression 5 --> 0.9572694767301303
------------------------*/
