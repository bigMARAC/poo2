import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.print("Digite a primeira data (dd/MM/yyyy): ");
      String date01 = input.next();
      
      System.out.print("Digite a segunda data (dd/MM/yyyy): ");
      String date02 = input.next();
      try {
         System.out.println(DateController.compare(date01, date02));
      } catch (Exception e) {
         System.err.println(e);
      }
   }
}
