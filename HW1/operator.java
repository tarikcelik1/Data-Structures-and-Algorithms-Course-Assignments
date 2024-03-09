public class operator extends person{ // This class is the child class of the person class.
    private int wage;
    protected customer[] customers = new customer[100];

    public operator(String name, String surname, String address, String phone, int ID, int wage) { // This is the constructor of the operator class.
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.ID = ID;
        this.wage = wage;
        this.customers = new customer[100];
    }

    void print_operator () { // This function prints the operator's information.
        System.out.println("Name & Surname : " + name + " " + surname);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("ID: " + ID);
        System.out.println("Wage: " + wage);
    }

    void print_customers() { // This function prints the operator's customers.
        for (int i = 0; i < customers.length; i++) {
            if(customers[i] != null) { // If the customer is not null, it prints the customer.
            System.out.println("-----------------------------");
            System.out.print("Customer #" + (i+1) + " ");
            if(customers[i] instanceof retail_customer){ // This part checks if the customer is retail_customer or corporate_customer.
            System.out.println("(a retail customer) :"); // This part prints the customer's type.
            }
            if(customers[i] instanceof corporate_customer){ // This part checks if the customer is retail_customer or corporate_customer.
                System.out.println("(a corporate customer) :"); // This part prints the customer's type.
            }
            customers[i].print_customer(); // This part prints the customer's information.
            
            }
        }
    }

    public void define_customers(customer[] customers) { // This function defines the operator's customers.
        int customerIndex = 0;
        for (int i = 0; i < customers.length; i++) { // This part checks if the customer's operator ID is the same as the operator's ID.
            if(customers[i] != null){   // If the customer is not null, it checks the operator ID.
                if (customers[i].operator_ID == this.ID) { // If the operator ID is the same as the customer's operator ID, it defines the customer.
                    this.customers[customerIndex] = customers[i]; // This part defines the customer.
                    customerIndex++;
            }
        }
    }
}
}
