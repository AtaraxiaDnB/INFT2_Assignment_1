import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister
{
   public static void main(String[] args)
   {
      String s = "", c = "";
      double balance;
      String mainMenu = "y";

      Scanner in = new Scanner(System.in);

      System.out.print("Please enter cash register's float: $");
      s = in.nextLine();
      balance = Double.parseDouble(s);

      while(mainMenu.equals("y"))
      {
         System.out.println("Would you like to proccess a transaction? (y/n) ");
         mainMenu = in.nextLine().toLowerCase();

         Transaction currentTransaction = new Transaction();

         String itemMenu = "y";

         while(itemMenu.equals("y"))
         {
            String itemName = "";
            String itemCost = "";

            System.out.println("Please enter the item's name: ");
            itemName = in.nextLine();

            System.out.println("Please enter the item's cost: $");
            itemCost = in.nextLine();

            currentTransaction.addItem(new Item(itemName, Double.parseDouble(itemCost)));


            System.out.println("Would you like to add another item? (y/n) ");
            itemMenu = in.nextLine().toLowerCase();


         }

         System.out.print("Please enter the cash amount tendered: $");
         s = in.nextLine();

         currentTransaction.calculateChange(Double.parseDouble(s));

         System.out.println("Amount of change required = $" + currentTransaction.change());

         c = Double.toString(balance + currentTransaction.total());
      }

      System.out.println("Balance of the Cash Register: $" + c);

   }
}
