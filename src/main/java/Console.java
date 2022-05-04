import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console {
    static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) {
        String connectionString = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1/address_table.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Addresses addresses =new Addresses(sql2o);
        System.out.println("Choose One");
        System.out.println("ADD UPDATE DELETE LIST");
        String input =scanner.nextLine();
        if (input.equals("ADD")){
            System.out.println("ADD NEW ENTRY: ");
            System.out.println("NAME: ");
            String name = scanner.nextLine();
            System.out.println("PHONE NUMBER");
            int phone_number = scanner.nextInt();
            scanner.nextLine(); //discard new line
            System.out.println("MAILING ADDRESS");
            String mailing_address = scanner.nextLine();
            System.out.println("EMAIL ADDRESS");
            String email_address = scanner.nextLine();
            Map<String, Object> model = new HashMap<>();
            Entry newEntry = new Entry(name,phone_number,mailing_address,email_address);
            addresses.add(newEntry);
            System.out.println("Works");
        }
        if (input.equals("LIST")){
            System.out.println("FULL LIST");
            Map<String, Object> model = new HashMap<>();
            List<Entry> entry = addresses.getAll(); //change
            model.put("entry", entry);
            System.out.println(model);
        }
    }
}
