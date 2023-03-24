package com.java.project;
import java.sql.*;
import java.util.*;

public class GameList {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/game_list"; 
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
        	System.out.println();
            System.out.println("Connected to database");
            
            // create a new table called "games" if it doesn't exist
            String createTableSql = "CREATE TABLE IF NOT EXISTS games (id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(255), platform VARCHAR(255), price FLOAT NULL)";
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(createTableSql);
            } catch (SQLException e) {
                System.out.println("Error creating table: " + e.getMessage());
                
            }


            boolean exit = false;
            while (!exit) {
            	System.out.println();
                System.out.println("\nSelect an option:");
                System.out.println("1. Read/Display data list");
                System.out.println("2. Update data");
                System.out.println("3. Delete data");
                System.out.println("4. Add new data");
                System.out.println("5. Exit");
                System.out.println();
                

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        // read data from the table
                        try (Statement stmt = conn.createStatement()) {
                            ResultSet rs = stmt.executeQuery("SELECT * FROM games");
                            boolean flag=false;
                            System.out.println("Retrieving the game list from MYSQL database....");
                            while (rs.next()) {
                            	flag=true;
                                float price=rs.getFloat("price");
                                String title = rs.getString("title");
                                String platform = rs.getString("platform");
                                System.out.println();
                                System.out.println("Game title = "+title + ", Platform = " + platform+", Price in rupees = "+price);
                                System.out.println();
                            }
                            if(!flag)
                            	System.out.println("Nothing found in database.");
                        } catch (SQLException e) {
                            System.out.println("Error reading data: " + e.getMessage());
                        }
                        break;
                    case 2:
                        // update data in the table
                        try (PreparedStatement pstmt = conn.prepareStatement("UPDATE games SET platform = ?, price = ? WHERE title = ?")) {
                            String title = getUserInput("Enter game title to update:");
                            String platform = getUserInput("Enter new platform:");
                            float price;
                            try {
                            	price=Float.parseFloat(getUserInput("Enter new price"));
                            }
                            catch(Exception e)
                            {
                            	System.out.println("This is not a float value,Not adding this to database");
                            	continue;
                            }
                            pstmt.setString(1, platform);
                            pstmt.setFloat(2, price);
                            pstmt.setString(3, title);
                            int rowsUpdated = pstmt.executeUpdate();
                            if (rowsUpdated > 0) {
                                System.out.println("Data updated successfully.");
                            } else {
                                System.out.println("No rows updated.");
                            }
                        } catch (SQLException e) {
                            System.out.println("Error updating data: " + e.getMessage());
                        }
                        break;
                    case 3:
                        // delete data from the table
                        try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM games WHERE title = ?")) {
                            String title = getUserInput("Enter game title to delete:");
                            pstmt.setString(1, title);
                            int rowsDeleted = pstmt.executeUpdate();
                            if (rowsDeleted > 0) {
                                System.out.println("Data deleted successfully.");
                            } else {
                                System.out.println("No rows deleted.");
                            }
                        } catch (SQLException e) {
                            System.out.println("Error deleting data: " + e.getMessage());
                        }
                        break;
                    case 4:
                    	String Title;
                        try(Statement stmt = conn.createStatement()) {
                            Title = getUserInput("Enter game title:");
                            stmt.executeQuery("SELECT `title` FROM games WHERE `title` = '" + Title + "';");
                            ResultSet rs  = stmt.getResultSet();
                            if(rs.next()) {
                                System.out.println("This game data already exists");
                                continue;
                            }
                        }

                        // add new data to the table
                        try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO games (title, platform, price) VALUES (?, ?, ?)")) {
                            String platform = getUserInput("Enter platform:");
                            float price;
                            try {
                            	price=Float.parseFloat(getUserInput("Enter new price"));
                            }
                            catch(Exception e)
                            {
                            	System.out.println("This is not a price value,Not adding this to database");
                            	continue;
                            }
                            pstmt.setString(1, Title);
                            pstmt.setString(2, platform);
                            pstmt.setFloat(3, price);
                            int rowsInserted = pstmt.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("Data inserted successfully.");
                            } else {
                                System.out.println("No rows inserted.");
                            }
                        } catch (SQLException e) {
                            System.out.println("Error inserting data: " + e.getMessage());
                        }
                        break;

                    case 5:
                        exit = true;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: Enter correct username and password ," + e.getMessage());
            System.out.println();
           
            attempts++;
            
        }
    }
      
        	
    }
    private static String getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(message);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
        return input;
    }

}