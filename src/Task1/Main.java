package Task1;/*
Задание 1: Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл.
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person user1 = new Person("Андрей", 45);
        try (FileOutputStream fileOutputStream = new FileOutputStream("user.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(user1);
            System.out.println("Объект сереализован");
        }

        try (FileInputStream fileInputStream = new FileInputStream("user.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            user1 = (Person) objectInputStream.readObject();
            System.out.println("Объект десериализован");
        }
        System.out.println("Имя: " + user1.getName());
        System.out.println("Возраст: " + user1.getAge());

    }

}
