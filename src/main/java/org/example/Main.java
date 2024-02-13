package org.example;
//Напишите приложение, которое будет запрашивать у пользователя следующие данные в заданном ниже порядке, разделенные пробелом:
//
//Фамилия Имя Отчество дата рождения номер телефона пол
//
//Форматы данных:
//
//фамилия, имя, отчество - строки
//дата _ рождения - строка формата dd.mm.yyyy
//номер _ телефона - целое беззнаковое число без форматирования
//пол - символ латиницей f или m.
//
//Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
//
//Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//
//Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
//<Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>
//
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//Не забудьте закрыть соединение с файлом.
//При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в заданном ниже порядке, разделенные пробелом:\n" +
                "//Фамилия Имя Отчество дата рождения номер телефона пол");
        String input = scanner.nextLine();


        try {
            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException("Количество данных не соответствует требуемому");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            Date dateOfBirth = parseDate(data[3]);
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            // Вывод обработанных данных
            System.out.println("Фамилия: " + lastName);
            System.out.println("Имя: " + firstName);
            System.out.println("Отчество: " + middleName);
            System.out.println("Дата рождения: " + dateOfBirth);
            System.out.println("Номер телефона: " + phoneNumber);
            System.out.println("Пол: " + gender);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Неверный формат номера телефона!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Ошибка: Неверный формат даты");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка! Недостаточно данных!");
        }
    }

    private static Date parseDate(String dataStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.parse(dataStr);
    }

    private static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(date);

    }
}