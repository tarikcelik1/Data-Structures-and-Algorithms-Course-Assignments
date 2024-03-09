public class customer extends person{ // This class is the child class of the person class.
    protected order[] orders = new order[100];

    public customer(String name, String surname, String address, String phone, int ID ,int operator_ID) { // This is the constructor of the customer class.
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.ID = ID;
        this.operator_ID = operator_ID;
        this.orders = new order[100];
    }

    void print_orders() { // This function prints the orders of the customer.
        for (int i = 0; i < orders.length; i++) {
            if(orders[i] != null){ // If the order is not null, it prints the order.
                System.out.print("Order #" + (i+1) + ": ");
                orders[i].print_order(); // This part prints the order.
            }
        }
}

    void print_customer () { // This function prints the customer's information.
        System.out.println("Name & Surname : " + name + " " + surname);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("ID: " + ID);
        System.out.println("Operator ID: " + operator_ID);
        this.print_orders();
    }
     public void define_orders(order[] orders) { // This function defines the customer's orders.
        int orderIndex = 0;
        for (int i = 0; i < orders.length; i++) { // This part checks if the order's customer ID is the same as the customer's ID.
            if(orders[i] != null){  // If the order is not null, it checks the customer ID.
                if (orders[i].customer_ID == this.ID) { // If the customer ID is the same as the order's customer ID, it defines the order.
                    if(orders[i].count != 0) // If the order's count is not 0, it defines the order.
                    this.orders[orderIndex] = orders[i]; // This part defines the order.
                    orderIndex++;
            } 
        }
        }
    }


}
