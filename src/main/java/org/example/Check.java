package org.example;

public class Check {

    public static void checkDateFormat(String date) throws IncorrectValueException{

        char[] checkData = date.toCharArray();
        if (checkData.length == 10 && (checkData[2] == '.' && checkData[5] == '.')){

        } else {
            throw new IncorrectValueException("Invalid date format. Enter correct date: dd.mm.yyyy");
        }
    }


    public static void checkPhoneNumberFormat(String phoneNumber) throws IncorrectValueException{
        try {
            long check = Long.parseLong(phoneNumber); // ошибка приведения вида
        } catch (IncorrectValueException e){
            throw new IncorrectValueException("Invalid phonenumber format. " +
                    "Enter correct format 111222334455");
        }
    }


    public static void checkGenderFormat(String gender) throws IncorrectValueException{
        if (gender.length() == 1){
            gender = gender.toLowerCase();
            if (gender.equals("m") || gender.equals("f")) {
                char[] charArray = gender.toCharArray();
                char convertedGender = charArray[0];
            } else {
                throw new IncorrectValueException("Invalid gender !\n" +
                        "Enter correct gender: m или f.");
            }
        } else {
            throw new IncorrectValueException("Invalid gender !\n" +
                    "Gender is indicated by one character, if a man is 'm', if a woman is 'f'.\n");
        }
    }
}