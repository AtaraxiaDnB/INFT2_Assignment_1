public class Item
{
    private String _name;
    private double _cost;

    public Item(String name, double cost) {
        this._name = name;
        this._cost = cost;
    }

    public double cost() {
        return _cost;
    }

    public void setCost(double cost) {
        this._cost = cost;
    }

    public String name() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

}

