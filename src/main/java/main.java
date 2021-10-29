import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "Vadym280576";
    static Connection conn;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n;

        try {
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            Search search = new Search();
            System.out.println("Please, choose the parameter for searching: ");
            System.out.println("1 - search by district");
            System.out.println("2 - search by address");
            System.out.println("3 - search by area");
            System.out.println("4 - search by quantity of rooms");
            System.out.println("5 - search by price");
            System.out.print("-> ");

            int s = Integer.parseInt(sc.nextLine());
            while (s >= 1 && s <= 5) {
                switch (s) {
                    case 1:
                        System.out.println("Enter the district: ");
                        n = sc.nextLine();
                        search.searchFlats(conn, "district", n);
                        System.out.println("Succes!");
                        break;
                    case 2:
                        System.out.println("Enter the address: ");
                        n = sc.nextLine();
                        search.searchFlats(conn, "address",n);
                        System.out.println("Succes!");
                        break;
                    case 3:
                        System.out.println("Enter the value of area: ");
                        n = sc.nextLine();
                        search.searchFlats(conn, "area", n);
                        System.out.println("Succes!");
                        break;
                    case 4:
                        System.out.println("Enter quantity of rooms: ");
                        n = sc.nextLine();
                        search.searchFlats(conn, "rooms", n);
                        System.out.println("Succes!");
                        break;
                    case 5:
                        System.out.println("Enter amount in $: ");
                        n = sc.nextLine();
                        search.searchFlats(conn, "price", n);
                        System.out.println("Succes!");
                        break;
                    default:


                        return;

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }


    }
}
