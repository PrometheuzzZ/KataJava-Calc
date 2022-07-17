package ru.fofanov.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите пример: ");

        String userInput = br.readLine();

        int[] dataInput = Helper.Validator(userInput);

        String value = Helper.Calc(dataInput);

        System.out.println(value);


    }

}
