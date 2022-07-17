package ru.fofanov.calc;



import static ru.fofanov.calc.Converter.RomanToInt10;

public class Helper {

    public static String[] StrSplit(String line){
        String[] arrSplit = line.split(" ");
        return arrSplit;
    }


    public static int[] Validator(String userInput){
        boolean valide;
        boolean arabic;
        String numberOneString;
        String numberTwoString;
        int numberOne;
        int numberTwo;
        int[] valideData = new int[4];

        String[] userInputArr = StrSplit(userInput);

        if(userInputArr.length==3){
            String operand = userInputArr[1];
            if("+-/*".contains(operand)){
                numberOneString = userInputArr[0];
                numberTwoString = userInputArr[2];
              if ("12345678910".contains(numberOneString) && ("12345678910".contains(numberTwoString))){
                  arabic = true;

                  numberOne = Integer.parseInt(numberOneString);
                  numberTwo = Integer.parseInt(numberTwoString);

                  if(numberOne<=10 && numberTwo<=10 && numberOne>=1 && numberTwo>=1){
                      valide = true;
                  } else {
                      throw new RuntimeException("Exception: Number > 10 or Number < 1");
                  }

              } else if(RomanToInt10(numberOneString)!=-1 && RomanToInt10(numberTwoString)!=-1){
                  numberOne = RomanToInt10(numberOneString);
                  numberTwo = RomanToInt10(numberTwoString);
                  arabic = false;
                  valide = true;
              } else {
                  throw new RuntimeException("Exception: format");
              }

              if(valide){
                // [0] - num one, [1] - num two, [2] operand int code, [3] arabic false/true - 0/1
                valideData[0] = numberOne;
                valideData[1] = numberTwo;
                valideData[2] = operand.charAt(0);
                if(arabic) {
                   valideData[3] = 1;
                } else {
                   valideData[3] = 0;
                }


                return valideData;
              }

            } else {
                throw new RuntimeException("Exception: no operand");
            }

        }else {
            throw new RuntimeException("Exception: format");
        }

        return null;
    }






    public static String Calc(int[] data){
        // [0] - num one, [1] - num two, [2] operand int code, [3] arabic false/true - 0/1
        // operand '+' = 43, '-' = 45, '/' = 47, '*' = 42
        int value = 0;

        switch (data[2]) {
            case  (43):
                value = data[0] + data[1];
                break;
            case (45):
                value = data[0] - data[1];
                break;
            case (47):
                value = data[0] / data[1];
                break;
            case (42):
                value = data[0] * data[1];
                break;
        }


        if(data[3]==0){
            if(value>0){
                return Converter.ArabicToRoman100(value);
            } else {
                throw new RuntimeException("Exception: roman number less than zero");
            }

        }

        return Integer.toString(value);
    }



}



