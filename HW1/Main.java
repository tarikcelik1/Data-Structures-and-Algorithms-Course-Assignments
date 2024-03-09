import java.util.Scanner;
import java.io.File;

public class Main {

    public static int stringIsEmpty(String[] str) {  // This function checks if the string is empty or not.
        for (int i = 0; i < str.length; i++) {
            if(str[i] == null || str[i].isEmpty()) {
                return 0;
            }
        }
        return 1;   
    }

    public static int isIntegerRightFormat(String str) { // This function checks if the string is in the right format for integer or not.
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return 0;
            }
            if(Integer.parseInt(str) < 0) {
                return 0;
            }
        return 1;
    }

    public static int isIDexists(int ID, customer[] customers, operator[] operators) { // This function checks if the ID is already exists or not.
        for (int i = 0; i < customers.length; i++) {
            if(customers[i] != null && customers[i].ID == ID) { // If the ID is already exists in customers, it returns 0.
                return 0;
            }
        }
        for (int i = 0; i < operators.length; i++) {
            if(operators[i] != null && operators[i].ID == ID) { // If the ID is already exists in operators, it returns 0.
                return 0;
            }
        }
            return 1;
    }
    public static void main(String[] args) {
        customer[] customers = new customer[100]; 
        operator[] operators = new operator[100];
        order[] orders = new order[100];
        
        int customerIndex = 0;
        int operatorIndex = 0;
        int orderIndex = 0;
        
        File file = new File("content.txt");
        try {
            Scanner scanner = new Scanner(file); // This part reads the file and creates the objects according to the given information.
            while (scanner.hasNextLine()) {  // This part reads the file line by line.
                String line = scanner.nextLine();
                String[] splittedStrings = line.split(";"); // This part splits the line by semicolon.
                
                switch (splittedStrings[0]) {
                    case "order": // This part creates the order object.
                        if(splittedStrings.length == 6 && stringIsEmpty(splittedStrings) == 1 && isIntegerRightFormat(splittedStrings[2]) == 1 && isIntegerRightFormat(splittedStrings[3]) == 1 && isIntegerRightFormat(splittedStrings[4]) == 1&& isIntegerRightFormat(splittedStrings[5]) == 1 && line.charAt(line.length() - 1) != ';'){
                        order Order = new order(splittedStrings[1], Integer.parseInt(splittedStrings[2]), Integer.parseInt(splittedStrings[3]), Integer.parseInt(splittedStrings[4]), Integer.parseInt(splittedStrings[5])); // This part creates the order object.
                        orders[orderIndex++] = Order;
                            break;
                        }
                        break;
                    case "retail_customer":     // This part creates the retail_customer object.
                    if(splittedStrings.length == 7 && stringIsEmpty(splittedStrings) == 1 && isIntegerRightFormat(splittedStrings[5]) == 1 && isIntegerRightFormat(splittedStrings[6]) == 1 && isIDexists(Integer.parseInt(splittedStrings[5]), customers, operators) == 1 && line.charAt(line.length() - 1) != ';'){
                        retail_customer Retail_customer = new retail_customer(splittedStrings[1], splittedStrings[2], splittedStrings[3], splittedStrings[4], Integer.parseInt(splittedStrings[5]),Integer.parseInt(splittedStrings[6])); // This part creates the retail_customer object.
                        Retail_customer.define_orders(orders); // This part defines the retail_customer's orders.
                        customers[customerIndex++] = Retail_customer;
                        break;
                    }
                        break;
                    case "corporate_customer":  // This part creates the corporate_customer object.
                    if(splittedStrings.length == 8 && stringIsEmpty(splittedStrings) == 1 && isIntegerRightFormat(splittedStrings[5]) == 1&& isIntegerRightFormat(splittedStrings[6]) == 1 && isIDexists(Integer.parseInt(splittedStrings[5]), customers, operators) == 1 && line.charAt(line.length() - 1) != ';'){
                        corporate_customer Corporate_customer = new corporate_customer(splittedStrings[1], splittedStrings[2], splittedStrings[3], splittedStrings[4], Integer.parseInt(splittedStrings[5]), Integer.parseInt(splittedStrings[6]), splittedStrings[7]);     // This part creates the corporate_customer object.
                        Corporate_customer.define_orders(orders); // This part defines the corporate_customer's orders.
                        customers[customerIndex++] = Corporate_customer;
                        break;
                    }
                    break;
                    case "operator": // This part creates the operator object.
                    if(splittedStrings.length == 7 && stringIsEmpty(splittedStrings) == 1 && isIntegerRightFormat(splittedStrings[5]) == 1 && isIntegerRightFormat(splittedStrings[6]) == 1 && isIDexists(Integer.parseInt(splittedStrings[5]), customers, operators) == 1 && line.charAt(line.length() - 1) != ';'){
                        operator Operator = new operator(splittedStrings[1], splittedStrings[2], splittedStrings[3], splittedStrings[4], Integer.parseInt(splittedStrings[5]), Integer.parseInt(splittedStrings[6])); // This part creates the operator object.
                        Operator.define_customers(customers); // This part defines the operator's customers.
                        operators[operatorIndex++] = Operator;
                        break;
                    }
                    break;
                    default:
                        break;
                }
            }
            scanner.close(); // This part closes the scanner.
        } catch (Exception e) {
            System.exit(0);
        }

        System.out.println("Please enter your ID...");
        Scanner scanner = new Scanner(System.in);
        String Input = scanner.nextLine();
        scanner.close();
        if(isIntegerRightFormat(Input) == 1){
        int ID = Integer.parseInt(Input);
        for(int i = 0; i < operatorIndex; i++) { // This part checks if the ID is operator's ID or not.
            if(operators[i].ID == ID) {
                System.out.println("*** Operator Screen ***");
                System.out.println("-----------------------------");
                operators[i].print_operator(); // This part prints the operator's information.
                if(operators[i].customers[0] != null){ // This part checks if the operator has any customer or not.
                operators[i].print_customers(); // This part prints the operator's customers.
                }
                else {
                    System.out.println("-----------------------------");
                    System.out.println("This operator doesn't have any customer.");
                }
                System.out.println("-----------------------------");
                System.exit(0); // This part terminate the program.
            }
        }
        for(int i = 0; i < customerIndex; i++) {
            if(customers[i].ID == ID) {
                System.out.println("*** Customer Screen ***");
                System.out.println("-----------------------------");
                if(customers[i] instanceof retail_customer) { // This part checks if the customer is retail_customer or corporate_customer.
                    retail_customer Retail_customer = (retail_customer) customers[i]; // This part casts the customer to retail_customer.
                    Retail_customer.print_customer();   // This part prints the customer's information.
                    System.out.println("-----------------------------");
                    System.exit(0);     // This part terminate the program.
                }
                else if(customers[i] instanceof corporate_customer) { // This part checks if the customer is corporate_customer or not.
                    corporate_customer Corporate_customer = (corporate_customer) customers[i]; // This part casts the customer to corporate_customer.
                    Corporate_customer.print_customer(); // This part prints the customer's information.
                    System.out.println("-----------------------------");
                    System.exit(0); // This part terminate the program.
                }
            }
        }
    
        System.out.println("No operator/customer was found with ID " + ID +". Please try again."); // This part prints the error message.
    }
    }
}
