import java.util.*;

class DatabaseSimulator {

    static ArrayList<String> databases = new ArrayList<>();
    static HashMap<String, ArrayList<String>> tables = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- DATABASE SIMULATOR ---");
            System.out.println("1. Create Database");
            System.out.println("2. Show Databases");
            System.out.println("3. Create Table");
            System.out.println("4. Show Table Structure");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter database name: ");
                    String db = sc.nextLine();

                    if (!databases.contains(db)) {
                        databases.add(db);
                        System.out.println("Database created: " + db);
                    } else {
                        System.out.println("Database already exists.");
                    }
                    break;

                case 2:
                    System.out.println("\nDatabases:");

                    if (databases.isEmpty()) {
                        System.out.println("No databases found.");
                    } else {
                        for (String d : databases) {
                            System.out.println(d);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter table command: ");
                    String command = sc.nextLine();

                    StringTokenizer st =
                            new StringTokenizer(command, " (),");

                    st.nextToken(); // CREATE
                    st.nextToken(); // TABLE

                    String tableName = st.nextToken();

                    ArrayList<String> columns = new ArrayList<>();

                    while (st.hasMoreTokens()) {
                        String column = st.nextToken();

                        // Skip data types
                        if (!column.equalsIgnoreCase("INT")
                                && !column.equalsIgnoreCase("VARCHAR")
                                && !column.equalsIgnoreCase("CHAR")) {

                            columns.add(column);
                        }
                    }

                    tables.put(tableName, columns);

                    System.out.println("Table created: " + tableName);
                    break;

                case 4:
                    System.out.print("Enter table name: ");
                    String table = sc.nextLine();

                    if (tables.containsKey(table)) {

                        System.out.println("\nTable Structure: " + table);

                        for (String column : tables.get(table)) {
                            System.out.println(column);
                        }

                    } else {
                        System.out.println("Table not found.");
                    }
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}