package org.example;

public class Check {

    public static void checkDateFormat(String date) throws IncorrectValueException{

        char[] checkData = date.toCharArray();
        if (checkData.length == 10 && (checkData[2] == '.' && checkData[5] == '.')){

        } else {
            throw new IncorrectValueException("������ ���� ������ �� ���������. ���������� ������ ����� ������ dd.mm.yyyy");
        }
    }


    public static void checkPhoneNumberFormat(String phoneNumber) throws IncorrectValueException{
        try {
            long check = Long.parseLong(phoneNumber); // ������ ���������� ����
        } catch (IncorrectValueException e){
            throw new IncorrectValueException("������ �������� ������������ ������ �� ���������. " +
                    "���������� ������ ����� ������ 111222334455");
        }
    }


    public static void checkGenderFormat(String gender) throws IncorrectValueException{
        if (gender.length() == 1){
            gender = gender.toLowerCase();
            if (gender.equals("m") || gender.equals("f")) {
                char[] charArray = gender.toCharArray();
                char convertedGender = charArray[0];
            } else {
                throw new IncorrectValueException("�� ��������� ������� ��� !\n" +
                        "���������� ������ ����� ������: m ��� f.");
            }
        } else {
            throw new IncorrectValueException("�� ����������� ������� ���!\n" +
                    "��� ����������� ����� ��������, ���� ������� 'm', ���� ������� 'f'.\n" +
                    "���������� ������ ����� ������, ���� �� ������� - 'm', ���� ������� - 'f'.");
        }
    }
}