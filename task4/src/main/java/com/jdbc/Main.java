package com.jdbc;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of entries in the table");
        int num = -1;
        while (num < 0) {
            try {
                num = input.nextInt();
                if (num < 0) {
                    System.out.println("Number of entries cannot be negative");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not an integer");
                num = -1;
            }
        }
        try(DatabaseConnection connection = DatabaseConnection.getInstance()) {
            DatabaseCommands commands = new DatabaseCommands(connection, num);
            boolean toExit = false;
            while (!toExit) {
                try {
                    System.out.println("Enter command");
                    String command = input.next();
                    switch(command) {
                        case "/add": {
                            String name = input.next();
                            long price = input.nextLong();
                            if (price <= 0) {
                                System.out.println("Price must be positive");
                                break;
                            }
                            commands.addEntry(name, price);
                            break;
                        }
                        case "/delete": {
                            String name = input.next();
                            commands.deleteEntry(name);
                            break;
                        }
                        case "/show_all": {
                            commands.showAll();
                            break;
                        }
                        case "/price": {
                            String name = input.next();
                            commands.showPrice(name);
                            break;
                        }
                        case "/change_price": {
                            String name = input.next();
                            long price = input.nextLong();
                            if (price <= 0) {
                                System.out.println("Price must be positive");
                                break;
                            }
                            commands.changePrice(name, price);
                            break;
                        }
                        case "/filter_by_price": {
                            long priceMin = input.nextLong();
                            long priceMax = input.nextLong();
                            if (priceMin > priceMax) {
                                System.out.println("Incorrect range");
                                break;
                            }
                            if (priceMin <= 0) {
                                System.out.println("Price must be positive");
                                break;
                            }
                            commands.filterPrice(priceMin, priceMax);
                            break;
                        }
                        case "/exit": {
                            toExit = true;
                            System.out.println("Exit program");
                            break;
                        }
                        default: {
                            System.out.println("Incorrect command");
                            break;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect number input");
                }
            }
        } catch (SQLException e) {
            System.out.println("Cannot connect to database");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
