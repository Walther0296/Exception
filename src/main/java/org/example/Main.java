package org.example;
//�������� ����������, ������� ����� ����������� � ������������ ��������� ������ � �������� ���� �������, ����������� ��������:
//
//������� ��� �������� ���� �������� ����� �������� ���
//
//������� ������:
//
//�������, ���, �������� - ������
//���� _ �������� - ������ ������� dd.mm.yyyy
//����� _ �������� - ����� ����������� ����� ��� ��������������
//��� - ������ ��������� f ��� m.
//
//���������� ������ ��������� ��������� ������ �� ����������. ���� ���������� �� ���������, ������� ��� ������, ���������� ��� � �������� ������������ ���������, ��� �� ���� ������ � ������ ������, ��� ���������.
//
//���������� ������ ���������� ���������� ������ � �������� �� ��� ��������� ��������. ���� ������� ������ �� ���������, ����� ������� ����������, ��������������� ���� ��������. ����� ������������ ���������� ���� java � ������� ����. ���������� ������ ���� ��������� ����������, ������������ �������� ��������� � �����������, ��� ������ �������.
//
//���� �� ������� � ���������� �����, ������ ��������� ���� � ���������, ������ �������, � ���� � ���� ������ ������ ���������� ���������� ������, ����
//<�������> <���> <��������> <���� _ ��������> <����� _ ��������> <���>
//
//������������ ������ ���������� � ���� � ��� �� ����, � ��������� ������.
//�� �������� ������� ���������� � ������.
//��� ������������� �������� � �������-������� � ����, ���������� ������ ���� ��������� ����������, ������������ ������ ������� ��������� ������.

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ������ � �������� ���� �������, ����������� ��������:\n" +
                "//������� ��� �������� ���� �������� ����� �������� ���");
        String input = scanner.nextLine();


        try {
            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException("���������� ������ �� ������������� ����������");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            Date dateOfBirth = parseDate(data[3]);
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            // ����� ������������ ������
            System.out.println("�������: " + lastName);
            System.out.println("���: " + firstName);
            System.out.println("��������: " + middleName);
            System.out.println("���� ��������: " + dateOfBirth);
            System.out.println("����� ��������: " + phoneNumber);
            System.out.println("���: " + gender);
        } catch (NumberFormatException e) {
            System.out.println("������! �������� ������ ������ ��������!");
        } catch (IllegalArgumentException e) {
            System.out.println("������: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("������: �������� ������ ����");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("������! ������������ ������!");
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