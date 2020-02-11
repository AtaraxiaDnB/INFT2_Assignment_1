import java.util.Scanner;

public class CashRegister
{
   private Transaction _currentTransaction = new Transaction();
   private double _balance;
   private double _amountTendered;
   private double _change;

   public CashRegister(double balance) {
      this._balance = balance;
   }

   public Transaction currentTransaction() {
      return _currentTransaction;
   }

   public double balance() {
      return _balance;
   }

   public double amountTendered() {
      return _amountTendered;
   }

   public double change() {
      return _change;
   }

   public void calculateChange(Double amountTendered) {
      _amountTendered = amountTendered;
      _change = amountTendered - _currentTransaction.total();
   }

   public void printReceipt() {
      System.out.println("items" );
      System.out.println("----------" );
      for(Item object: _currentTransaction.cart()) {
         System.out.println(object.name() +" - $" + object.cost());
      }
      System.out.println("----------" );
      System.out.println("total:    $" + _currentTransaction.total());
      System.out.println("tendered: $" + _amountTendered);
      System.out.println("Change:   $" + _change);

   }

   public static void main(String[] args)
   {
      String s = "", c = "";
      String mainMenu = "y";


      Scanner in = new Scanner(System.in);

      System.out.println("Welcome to the cash register");

      System.out.print("Please enter cash register's float: $");
      s = in.nextLine();

      CashRegister register = new CashRegister(Double.parseDouble(s));

      while(mainMenu.equals("y"))
      {
         System.out.println("Would you like to proccess a transaction? (y/n) ");
         mainMenu = in.nextLine().toLowerCase();

         String itemMenu = "y";

         while(itemMenu.equals("y"))
         {
            String itemName = "";
            String itemCost = "";

            System.out.println("Please enter the item's name: ");
            itemName = in.nextLine();

            System.out.println("Please enter the item's cost: $");
            itemCost = in.nextLine();

            register.currentTransaction().addItem(new Item(itemName, Double.parseDouble(itemCost)));


            System.out.println("Would you like to add another item? (y/n) ");
            itemMenu = in.nextLine().toLowerCase();


         }

         System.out.print("Please enter the cash amount tendered: $");
         s = in.nextLine();

         register.calculateChange(Double.parseDouble(s));

         System.out.println("Amount of change required = $" + register.change());

         System.out.println("Would you like to print a receipt? y/n ");
         s = in.nextLine();

         if(s.equals("y")) {
            register.printReceipt();
         }

         c = Double.toString(register.balance() + register.currentTransaction().total());
      }

      System.out.println("Balance of the Cash Register: $" + c);


   }
}
