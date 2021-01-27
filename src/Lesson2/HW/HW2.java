package Lesson2.HW;

import javax.swing.*;

public class HW2 {
    public static void main(String[] args) {
        String[][] arr1 = {
                {"5", "3", "2", "1"},
                {"12", "Index", "8", "7"},
                {"15", "3", "1", "0"},
                {"5", "3", "6", "7"}
        };
        String[][] arr2 = {
                {"5", "3", "2", "1"},
                {"12", "4", "8", "7"},
                {"15", "3", "1", "0"},
                {"5", "3", "6", "8"}
        };
        String[][] arr3 = {
                {"1", "5", "7", "9"},
                {"9", "4", "5", "1"},
                {"2", "1", "0", "8"}
        };
        String[][] arr4 = {
                {"4", "3", "2", "3"},
                {"7", "8", "7"},
                {"8", "9", "6", "2"},
                {"1", "3", "5", "6"}
        };

        try {
            stringsExceptionTest(arr1);
            System.out.println();

            stringsExceptionTest(arr2);
            System.out.println();

            stringsExceptionTest(arr3);
            System.out.println();

            stringsExceptionTest(arr4);
            System.out.println();


        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
        try {
            dataExceptionTest(arr2);
        } catch (MyArrayDataException t) {
            t.printStackTrace();
        }
    }


    private static void stringsExceptionTest(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4) throw new MyArraySizeException("Проверьте, строки должно быть 4!");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4)
                throw new MyArraySizeException(String.format("Проверьте количество столбцов в строке номер %d", i + 1));
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dataExceptionTest(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        int number = 0;
        int string = 0;
        int column = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                string = i;
                for (int j = 0; j < arr.length; j++) {
                    column = j;
                    number = Integer.parseInt(arr[i][j]);
                    sum += number;
                }
            }
            System.out.println(sum);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(String.format("Обнаружено не числовое значение в ячейке %d %d", string, column));
        }
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}
