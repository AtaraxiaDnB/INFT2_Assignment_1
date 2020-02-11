import java.util.ArrayList;

public class Transaction
{
   private ArrayList<Item> _cart = new ArrayList<Item>();
   private double _total;
   private double _amountTendered;
   private double _change;
   private int _numOfItems;

   public Transaction() {

   }

   public ArrayList cart() {
      return _cart;
   }

   public double total() {
      return _total;
   }

   public double amountTendered() {
      return _amountTendered;
   }

   public double change() {
      return _change;
   }

   public int numOfItems() {
      return _numOfItems;
   }

   public Item item(int index) {
      return _cart.get(index);
   }

   public void addItem(Item item) {
      _cart.add(item);

      this.calculateTotal();
   }

   public void addItem(int index, Item item) {
      _cart.add(index, item);
      _numOfItems++;
      this.calculateTotal();
   }

   public void calculateChange(Double amountTendered) {
      _amountTendered = amountTendered;
      _change = amountTendered - _total;
       }

   public void printReceipt() {

   }

   private void calculateTotal() {
      for (int i = 0; i < _cart.size(); i++) {
         _total += _cart.get(i).cost();
      }
   }

}
