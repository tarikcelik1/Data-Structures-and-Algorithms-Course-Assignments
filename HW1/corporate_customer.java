public class corporate_customer extends customer{ // This class is the child class of the customer class.
    private String company_name;
    
    public corporate_customer(String name, String surname, String address, String phone, int ID,int operator_ID, String company_name) { // This is the constructor of the corporate_customer class.
        super(name, surname, address, phone, ID,operator_ID); // This part calls the constructor of the customer class.
        this.company_name = company_name; // This part initializes the company name.
    }
    
    void print_customer () { // This function prints the customer's information.
        System.out.println("Name & Surname : " + name + " " + surname);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("ID: " + ID);
        System.out.println("Company name: " + company_name);
        this.print_orders(); // This part prints the customer's orders.

}
}