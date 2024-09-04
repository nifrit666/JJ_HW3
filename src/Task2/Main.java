package Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Задание 2: Используя JPA, создайте базу данных для хранения объектов класса Person. Реализуйте методы для добавления,
обновления и удаления объектов Person.
 */
public class Main {
    public static void main(String[] args) {
        List<Person> persons;
        File file = new File(PersonsListApp.FILE_JSON);
        if (file.exists() && !file.isDirectory()) {
            persons = PersonsListApp.readPersonsFromFile(PersonsListApp.FILE_JSON);
        } else {
            persons = preparePersonList();
        }
        PersonsListApp.savePersonsToFile(PersonsListApp.FILE_JSON, persons);
        PersonsListApp.savePersonsToFile(PersonsListApp.FILE_XML, persons);
        PersonsListApp.savePersonsToFile(PersonsListApp.FILE_BIN, persons);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Пожалуйста, выберите опцию:\n1.Показать список персон\n2.Добавить персону\n3.Изменить персону\n4.Удалить персону\n5.Выход");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    PersonsListApp.displayPersons(persons);
                    break;
                case "2":
                    PersonsListApp.addPerson(sc, persons);
                    PersonsListApp.displayPersons(persons);
                    break;
                case "3":
                    PersonsListApp.renewPerson(sc, persons);
                    PersonsListApp.displayPersons(persons);
                    break;
                case "4":
                    PersonsListApp.removePersonFromList(sc, persons);
                    PersonsListApp.displayPersons(persons);
                    break;
                case "5":
                    PersonsListApp.savePersonsToFile(PersonsListApp.FILE_JSON, persons);
                    PersonsListApp.savePersonsToFile(PersonsListApp.FILE_XML, persons);
                    PersonsListApp.savePersonsToFile(PersonsListApp.FILE_BIN, persons);
                    System.out.println("Пока пока");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Нет такой возможности");
                    break;
            }
        }

    }

    static List<Person> preparePersonList() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Василий", 38));
        list.add(new Person("Максим", 33));
        list.add(new Person("Татьяна", 39));
        return list;
    }
}
