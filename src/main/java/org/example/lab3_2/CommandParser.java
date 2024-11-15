package org.example.lab3_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
    private StorageDAO storageDAO = new StorageDAO();
    private Group_of_goodsDAO groupOfGoodsDAO = new Group_of_goodsDAO();
    private GoodsDAO goodsDAO = new GoodsDAO();

    public void executeCommand(String command) {
        // Команда для додавання нового складу
        if (command.startsWith("insert storage")) {
            Pattern pattern = Pattern.compile("id=(\\d+), location='(.+?)', storage_number='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String location = matcher.group(2);
                String storageNumber = matcher.group(3);
                storageDAO.addStorage(id, location, storageNumber);
                System.out.println("Inserted storage successfully.");
            } else {
                System.out.println("Invalid insert storage command format.");
            }

            // Команда для оновлення складу
        } else if (command.startsWith("update storage")) {
            Pattern pattern = Pattern.compile("id=(\\d+), location='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String location = matcher.group(2);
                storageDAO.updateStorage(id, location);
                System.out.println("Updated storage successfully.");
            } else {
                System.out.println("Invalid update storage command format.");
            }

            // Команда для видалення складу за id
        } else if (command.startsWith("delete storage")) {
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                storageDAO.deleteStorage(id);
                System.out.println("Deleted storage successfully.");
            } else {
                System.out.println("Invalid delete storage command format.");
            }

            // Команда для зчитування всіх складів
        } else if (command.startsWith("read storage")) {
            storageDAO.getAllStorage();


            // Команда для додавання нової групи товарів
        } else if (command.startsWith("insert group_of_goods")) {
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)', packaging_type='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String name = matcher.group(2);
                String packagingType = matcher.group(3);
                groupOfGoodsDAO.addGroupOfGoods(id, name, packagingType);
                System.out.println("Inserted group_of_goods successfully.");
            } else {
                System.out.println("Invalid insert group_of_goods command format.");
            }

            // Команда для оновлення назви групи товарів
        } else if (command.startsWith("update group_of_goods")) {
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String newName = matcher.group(2);
                groupOfGoodsDAO.updateGroupOfGoods(id, newName, null);
                System.out.println("Updated group_of_goods successfully.");
            } else {
                System.out.println("Invalid update group_of_goods command format.");
            }

            // Команда для видалення групи товарів за id
        } else if (command.startsWith("delete group_of_goods")) {
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                groupOfGoodsDAO.deleteGroupOfGoods(id);
                System.out.println("Deleted group_of_goods successfully.");
            } else {
                System.out.println("Invalid delete group_of_goods command format.");
            }

            // Команда для зчитування всіх груп товарів
        } else if (command.startsWith("read group_of_goods")) {
            groupOfGoodsDAO.getAllGroupsOfGoods();


            // Команда для додавання нового товару
        } else if (command.startsWith("insert goods")) {
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)', price=(\\d+\\.\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String name = matcher.group(2);
                double price = Double.parseDouble(matcher.group(3));
                goodsDAO.addGoods(id, name, price);
                System.out.println("Inserted goods successfully.");
            } else {
                System.out.println("Invalid insert goods command format.");
            }

            // Команда для оновлення товару
        } else if (command.startsWith("update goods")) {
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String name = matcher.group(2);
                goodsDAO.updateGoods(id, name);
                System.out.println("Updated goods successfully.");
            } else {
                System.out.println("Invalid update goods command format.");
            }

            // Команда для видалення товару за id
        } else if (command.startsWith("delete goods")) {
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                goodsDAO.deleteGoods(id);
                System.out.println("Deleted goods successfully.");
            } else {
                System.out.println("Invalid delete goods command format.");
            }

            // Команда для зчитування всіх товарів
        } else if (command.startsWith("read goods")) {
            goodsDAO.getAllGoods();
        } else {
            System.out.println("Unknown command. Please try again.");
        }
    }
}
