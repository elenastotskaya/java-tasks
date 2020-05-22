package com.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCommands {
    private DatabaseConnection connection;
    private int currentCount = 0;
    public DatabaseCommands(DatabaseConnection connection) {
        this.connection = connection;
        try (Statement statement = connection.getConnection().createStatement()) {
            try {
                statement.executeUpdate("truncate table task4.products");
            } catch(SQLSyntaxErrorException e) {
                statement.executeUpdate("create table task4.products (id int unsigned auto_increment primary key, prodid int not null, title varchar(20) not null, cost long not null)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generateEntries(int num) {
        try (Statement statement = connection.getConnection().createStatement()) {
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

    public List<Product> getList() {
        List<Product> products = new ArrayList<>();
        try(Statement statement = connection.getConnection().createStatement()) {
            ResultSet resSet = statement.executeQuery("select * from task4.products");
            while (resSet.next()) {
                int id = resSet.getInt(1);
                int prodid = resSet.getInt(2);
                String title = resSet.getString(3);
                long cost = resSet.getLong(4);
                products.add(new Product(id, prodid, title, cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public  List<Product> getList(long priceMin, long priceMax) {
        List<Product> products = new ArrayList<>();
        try(Statement statement = connection.getConnection().createStatement()) {
            ResultSet resSet = statement.executeQuery("select * from task4.products where cost between " + priceMin + " AND " + priceMax);
            while (resSet.next()) {
                int id = resSet.getInt(1);
                int prodid = resSet.getInt(2);
                String title = resSet.getString(3);
                long cost = resSet.getLong(4);
                products.add(new Product(id, prodid, title, cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public long showPrice(String title) {
        long cost = 0;
        try (Statement statement = connection.getConnection().createStatement()) {
            ResultSet resSet = statement.executeQuery("select * from task4.products where title='" + title + "'");
            if (!resSet.next()) {
                return 0;
            }
            cost = resSet.getLong("cost");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cost;
    }

    public void changePrice(String title, long newCost) {
        try (Statement statement = connection.getConnection().createStatement()) {
            statement.executeUpdate("update task4.products set cost=" + newCost + " where title='" + title + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
