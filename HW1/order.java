public class order { 
    protected String product_name;
    protected int count;
    protected int total_price;
    protected int status;
    protected int customer_ID;

    order(String product_name, int count, int total_price, int status, int customer_ID) { // This is the constructor of the order class.
        this.product_name = product_name;
        this.count = count;
        this.total_price = total_price;
        this.status = status;
        this.customer_ID = customer_ID;
    }

    public String convertStatus() { // This function converts the status to a string.
        switch (status) {
            case 0:
                return "Initialized";
            case 1:
                return "In progress";
            case 2:
                return "Delivered";
            case 3:
                return "Cancelled";
            default:
                return " "; 
        }
    }
    
    void print_order() { // This function prints the order.
        System.out.print("Product name: " + product_name + "- Count: " + count + "- Total price: " + total_price + "- Status: " + convertStatus() +"\n");
    }
}
