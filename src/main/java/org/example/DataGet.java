package org.example;

import java.io.IOException;
import java.util.Scanner;

public class DataGet {
    public static void getData() throws EmptyStringException, ArrayCountElementException, IncorrectValueException, IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ������ � ������� ��������� ���� ����������:\n" +
                " <�������> <���> <��������> <���� ��������> <�������> <���>\n " +
                "������:\n" +
                "������� �������� ��������� 27.02.1996 89207345698 M");
        String inputData;
        inputData = scanner.nextLine();
        if (inputData.isEmpty()){
            throw new EmptyStringException("������ �������� ������");
        }

        inputData = inputData.replaceAll("\\s+", " ");
        inputData = inputData.trim();
        String[] bufferArray = inputData.split(" ");
        if (bufferArray.length == 6){
            Check.checkDateFormat(bufferArray[3]);
            Check.checkPhoneNumberFormat(bufferArray[4]);
            Check.checkGenderFormat(bufferArray[5]);
            DataWrite.createFile(bufferArray);


        } else {
            throw new ArrayCountElementException("������� �� ��� ������ ���\n" +
                    "�� ���������� ������");
        }




    }
}