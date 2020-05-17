package com.jdbc;

import java.sql.*;

public class DatabaseCommands {
    private DatabaseConnection connection;
    private int currentCount = 0;
    public DatabaseCommands(DatabaseConnection connection, int num) {
        this.connection = connection;
        try (Statement statement = connection.getConnection().createStatement()) {
            try {
                statement.executeUpdate("truncate table task4.products");
            } catch(SQLSyntaxErrorException e) {
                statement.executeUpdate("create table task4.products (id int unsigned auto_increment primary key, prodid int not null, title varchar(20) not null, cost long not null)");
            }
            for (int i = 1; i <= num; ++i) {
                addEntry("товар" + i, (long) (Math.random() * 10000));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addEntry(String title, long cost) {
        try (Statement statement = connection.getConnection().createStatement()) {
            ResultSet resSet = statement.executeQuery("select title from task4.products where title='" + title + "'");
            if (resSet.next()) {
                System.out.println("An entry with this name already exists");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Statement Statement = connection.getConnection().createStatement()) {
            ++currentCount;
            Statement.executeUpdate("insert into task4.products (prodid, title, cost) values (" + currentCount + ", '" + title + "', " + cost + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEntry(String title) {
        try (Statement statement = connection.getConnection().createStatement()) {
            statement.executeUpdate("delete from task4.products where title='" + title + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printResult(ResultSet resSet) {
        try {
            while (resSet.next()) {
                System.out.println(resSet.getInt("id") + " " + resSet.getInt("prodid") + " " + resSet.getString("title") + " " + resSet.getLong("cost"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAll() {
        try (Statement statement = connection.getConnection().createStatement()) {
            ResultSet resSet = statement.executeQuery("select * from task4.products");
            printResult(resSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showPrice(String title) {
        try (Statement statement = connection.getConnection().createStatement()) {
            ResultSet resSet = statement.executeQuery("select * from task4.products where title='" + title + "'");
            if (!resSet.next()) {
                System.out.println("An entry with this name does not exist");
                return;
            }
            System.out.println(resSet.getLong("cost"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePrice(String title, long newCost) {
        try (Statement statement = connection.getConnection().createStatement()) {
            statement.executeUpdate("update task4.products set cost=" + newCost + " where title='" + title + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void filterPrice(long priceMin, long priceMax) {
        try (Statement statement = connection.getConnection().createStatement()) {
            ResultSet resSet = statement.executeQuery("select * from task4.products where cost between " + priceMin + " AND " + priceMax);
            printResult(resSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
