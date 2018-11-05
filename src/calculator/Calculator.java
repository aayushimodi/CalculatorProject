/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.*;

/**
 *
 * @author aayus
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Aayushi's IB Computer Science calculator!"); //greets user
        String input = getInput();  //calls a method that returns user input, and stores this input into a variable

        while (!input.equals("quit")) {  //while loop that runs until the user types in quit
            if (input.equals("i")) {  //calls in info method if the user types in i
                info();
                
            } else if (input.equals("")) { //if the user just presses enter, an error message is printed
                System.out.println("error: invalid input");

            } else {
                int tokenNum = countTokens(input); //count number of tokens in the user input string to determine which operand method to call

                if (tokenNum == 2) { //if there are 2 tokens the one operand method is called
                    evalOneOperand(input);

                } else if (tokenNum == 1) { //if there is only one token, an error message is printed
                    System.out.println("error: invalid input");

                } else { //if there are 3 or more tokens a method to decide the expression type is called
                    decideExpressionType(input);
                }
            }

            input = getInput(); //after an error message has been printed or the expression has been evaluated, the user input method is called and the returned String is saved in a variable
        }

        System.out.println("Thank you for using Aayushi's IB Computer Science calculator!"); //thanks user
    }

    public static String getInput() { //this method gets user input from the console and then returns it as a String
        Scanner sc = new Scanner(System.in); //a scanner is created to scan user input from the console 
        System.out.print("Enter an expression, i for info, or quit to exit: ");
        String input = sc.nextLine(); //the user input is stored into a variable

        if (input.equalsIgnoreCase("i")) { //if the user types in i, no matter what case, the method returns "i"
            return "i";
        }
        if (input.equalsIgnoreCase("quit")) { //if the user types in quit, no matter what case, the method returns "quit"
            return "quit";
        }

        return input; //the user input is returned if it was not "i" or "quit"
    }

    public static int countTokens(String input) { //this method counts the number of tokens in the user input
        Scanner sc = new Scanner(input); //a scanner is created to scan the tokens of the input
        int count = 0;

        while (sc.hasNext()) { //while the input has more tokens, the count of tokens is incremented and the scanner is advanced
            count++;
            sc.next();
        }

        return count; //the amount of tokens is returned

    }

    public static void evalOneOperand(String input) { //this method evaluates one operand expressions
        Scanner sc = new Scanner(input); //a scanner is created to scan the tokens of the input

        String operator = ""; 
        double operand = 0;

        if (sc.hasNext()) { //if the user input has a next, which means it has some symbol, then the symbol is stored in the variable
            operator = sc.next();
        } else { //if there is no next token an error message is printed
            System.out.println("error: invalid input");
            return;
        }

        if (sc.hasNextDouble()) { //if the user input has a next double, which means it has some number, then the number is stored in the variable
            operand = sc.nextDouble();
        } else { //if there is no next double token an error message is printed
            System.out.println("error: invalid input");
            return;
        }

        if (operator.equals("|")) { //absolute value

            System.out.print(input + " = "); //echos input
            System.out.println(Math.abs(operand)); //prints answer

        } else if (operator.equals("v")) { //square root

            if (operand < 0) { //if operand is less than 0, error message printed
                System.out.println("error: invalid input");
                return;
            }

            System.out.print(input + " = "); //echos input
            System.out.println(Math.sqrt(operand)); //prints answer

        } else if (operator.equals("~")) { //rounds number

            System.out.print(input + " = "); //echos input
            System.out.println(Math.round(operand)); //prints answer

        } else if (operator.equals("s")) { //sin 

            System.out.print(input + " = "); //echos input
            System.out.println(Math.sin(Math.toRadians(operand))); //prints answer

        } else if (operator.equals("c")) { //cosine

            System.out.print(input + " = "); //echos input
            System.out.println(Math.cos(Math.toRadians(operand))); //prints answer

        } else if (operator.equals("t")) { //tangent

            System.out.print(input + " = "); //echos input
            System.out.println(Math.tan(Math.toRadians(operand))); //prints answer

        } else if (operator.equals("ln")) { //ln 

            if (operand < 0) { //if operand is less than 0, error message printed
                System.out.println("error: invalid input");
                return;
            }

            System.out.print(input + " = "); //echos input
            System.out.println(Math.log(operand)); //prints answer

        } else if (operator.equals("l")) { //log base 10

            if (operand < 0) { //if operand is less than 0, error message printed
                System.out.println("error: invalid input");
                return;
            }

            System.out.print(input + " = "); //echos input
            System.out.println(Math.log10(operand)); //prints answer

        } else if (operator.equals("as")) { //arcsin

            if (operand < 0) { //if operand is less than 0, error message printed
                System.out.println("error: invalid input");
                return;
            }

            System.out.print(input + " = "); //echos input
            System.out.println(Math.toDegrees(Math.asin(operand))); //prints answer

        } else if (operator.equals("ac")) { //arccosine

            if (operand < 0) { //if operand is less than 0, error message printed
                System.out.println("error: invalid input"); 
                return;
            }

            System.out.print(input + " = "); //echos input
            System.out.println(Math.toDegrees(Math.acos(operand))); //prints answer

        } else if (operator.equals("at")) { //arctangent

            if (operand < 0) { //if operand is less than 0, error message printed
                System.out.println("error: invalid input");
                return;
            }

            System.out.print(input + " = "); //echos input
            System.out.println(Math.toDegrees(Math.atan(operand))); //prints answer

        } else if (operator.equals("!")) { //factorial

            if (operand == (int) operand && operand > 0) { //checks if the operand is an integer and a positive number because factorials do not work on negative numbers and non-integers
                System.out.print(input + " = "); //echos input
                System.out.println(calculateFactorial(operand)); //calles method to calculate the factorial and prints the value returned by the method
            } else { //if the operand is not an integer and a positive number an error message is printed
                System.out.println("error: invalid input");
            }

        } else { //if the operator is not any of the specified symbols, an error message is printed
            System.out.println("error: invalid input");
        }

    }

    public static void evalTwoOperand(String input) { //this method evaluates two operand expressions
        Scanner sc = new Scanner(input); //a scanner is created to scan the tokens of the input

        String operator = "";
        double operand1 = 0;
        double operand2 = 0;
        double answer = 0;

        if (sc.hasNextDouble()) { //if the user input has a next double, which means it has some number, then the number is stored in the variable
            operand1 = sc.nextDouble();
        } else { //if there is no next double token an error message is printed
            System.out.println("error: invalid input");
            return;
        }

        while (sc.hasNext()) { //the code inside this while continues to happen until the scanner scans through all the tokens in the string
            if (sc.hasNext()) { //if the user input has a next, which means it has some symbol, then the symbol is stored in the variable
                operator = sc.next();
            } else { //if there is no next token an error message is printed
                System.out.println("error: invalid input");
                return;
            }

            if (sc.hasNextDouble()) { //if the user input has a next double, which means it has some number, the the number is stored in the variable
                operand2 = sc.nextDouble();
            } else { //if there is no next double token an error message is printed
                System.out.println("error: invalid input");
                return;
            }

            if (operator.equals("+")) { //addition, answer saved in a variable

                answer = operand1 + operand2; 

            } else if (operator.equals("-")) { //subtraction, answer saved in a variable

                answer = operand1 - operand2;

            } else if (operator.equals("*")) { //multiplication, answer saved in a variable

                answer = operand1 * operand2;
                
            } else if (operator.equals("/")) { //division, answer saved in a variable

                answer = operand1 / operand2;

            } else if (operator.equals("%")) { //modulus, answer saved in a variable

                answer = operand1 % operand2;

            } else if (operator.equals("^")) { //exponent, answer saved in a variable

                answer = Math.pow(operand1, operand2);

            } else { //if the operator is not any of the specified symbols, an error message is printed
                System.out.println("error: invalid input");
                return;
            }

            operand1 = answer; 
            
//the answer calculated is set equal to the first operand so that if there are multiple operations they can be evaluated
//for example: 3 + 4 + 5
//The code first does 3 + 4 and gets 7
//then 7 is set to operand1 so the code evaluates 7 + 5 to end up with 12 as the answer

        }
        System.out.println(input + " = " + answer); //the input is echoed and the answer is printed as well 
    }

    public static void decideExpressionType(String input) { //this method is called when the input has 3 or more tokens and the method decides what kind of expression was inputted 
        Scanner sc = new Scanner(input); //a scanner is created to scan the tokens of the input
        String operand = sc.next(); //the first token is saved into the operand variable

        if (operand.equals("avg")) { //if the operand equals to "avg", the code tries to find the average of the numbers

            double avgAnswer = calculateAverage(input); //the returned average from the method that calculates average is saved in a variable
            System.out.println(input + " = " + avgAnswer); //the input is echoed and the answer is printed as well

        } else if (operand.equals("max")) { //if the operand equals to "max", the code tries to find the maximum of all the numbers 

            double maxAnswer = calculateMax(input); //the returned maximum from the method that calculates the maximum is saved in a variable
            System.out.println(input + " = " + maxAnswer); //the input is echoed and the answer printed as well

        } else if (operand.equals("min")) { //if the operand equals to "min", the code tries to find the minimum of all the numbers

            double minAnswer = calculateMin(input); //the returned minimum from the method that calculates the minimum is saved in a variable
            System.out.println(input + " = " + minAnswer); //the input is echoed and the answer printed as well

        } else { //if the operand is not one of the specified phrases, the two operand method is called
            evalTwoOperand(input);
        }
    }

    public static int calculateFactorial(double operand) { //this method calculates the factorial of a number
        int factorial = 1;
        for (int i = 1; i <= operand; i++) { //the loop runs from 1 to the operand that was parsed from the user input string, each time i is incremented by 1
            factorial *= i; //the factorial is multiplied by i each time the loop runs and saved back into the factorial variable
        }

        return factorial; //the factorial is returned

    }

    public static double calculateAverage(String input) { //this method calculates the average of inputted numbers
        Scanner sc = new Scanner(input); //a scanner is created to scan the tokens of the input
        double sum = 0;
        int count = 0;
        String operand = sc.next(); //the next token is stored into a variable called operand

        while (sc.hasNext()) { //while the scanner has more tokens to scan
            if (sc.hasNextDouble()) { //if the next token is a double, this token is added to the sum, and the count variable is incremented
                sum += sc.nextDouble();
                count++;
            } else {
                return 0; //if there is no next double, 0 is returned 
                }
            }

            return sum / count; //the average is returned 
        }

    public static double calculateMax(String input) { //this method calculates the maximum of inputted numbers
        Scanner sc = new Scanner(input); // a scanner is created to scan the tokens of the input
        double num = 0;
        double num2 = 0;
        double max = 0;
        String operand = sc.next(); //the next token is stored into a variable called operand

        if (sc.hasNextDouble()) { //if the scanner has more doubles to scan
            num = sc.nextDouble(); //the next double is saved into a variable
        } else { //if there are no more tokens to scan, 0 is returned
            return 0;
        }

        while (sc.hasNext()) { //while the scanner has more tokens to scan
            if (sc.hasNextDouble()) { //if there is a next double 
                num2 = sc.nextDouble(); //the next double is saved into a variable
            } else { //if there are no more tokens to scan, 0 is returned
                return 0;
            }

            max = Math.max(num, num2); //the maximum of the two numbers is calculated

            num = max; //the maxmimum is saved as the first number so that it can be compared with any other numbers the user inputted
        }

        return max; //the max value is returned
    }

    public static double calculateMin(String input) { //this method calculates the minimum of inputted numbers
        Scanner sc = new Scanner(input); //a scanner is created to scan the tokens of the input
        double num = 0;
        double num2 = 0;
        double min = 0;
        String operand = sc.next(); //the next token is stored into a variable called operand

        if (sc.hasNextDouble()) { //if the scanner has more doubles to scan
            num = sc.nextDouble(); //the next double is saved into a variable
        } else { //if there are no more tokens to scan, 0 is returned
            return 0;
        }

        while (sc.hasNext()) { //while the scanner has more tokens to scan
            if (sc.hasNextDouble()) { //if there is a next double
                num2 = sc.nextDouble(); //the next double is saved into a variable
            } else { //if there are no more tokens to scan, 0 is returned
                return 0;
            }

            min = Math.min(num, num2); //the minimum of the two numbers is calculated

            num = min; //the minimum is saved as rhe first number so that it can be comapred with any other numbers the user inputted
        }

        return min; //the min value is returned
    }

    public static void info() { //this method prints out information about the calculator and how it works
        System.out.println();
        System.out.println("This calculator performs a variety of operations.");
        System.out.println();
        System.out.println("The one operand functions should be entered as a function symbol (composed of one of more letters) and the number, seperated by spaces. ex: v 4");
        System.out.println("All angles should be entered and will be returned as degrees.");
        System.out.println("One operand functions:");
        System.out.println();
        System.out.println("| -> absolute value");
        System.out.println("v -> square root");
        System.out.println("~ -> round to nearest integer");
        System.out.println("s -> sin");
        System.out.println("c -> cosine");
        System.out.println("t -> tangent");
        System.out.println("ln -> log base e or natural log");
        System.out.println("l -> log base 10");
        System.out.println("as -> arcsin");
        System.out.println("ac -> arccosine");
        System.out.println("at -> arctangent");
        System.out.println("! -> factorial (only works on integers)");
        System.out.println();
        System.out.println();
        System.out.println("The two operand functions should be entered as a number, the operator, a number, and so on, seperated by spaces. ex: 4 + 5 / 3");
        System.out.println("Two operand functions:");
        System.out.println();
        System.out.println("+ -> addition");
        System.out.println("- -> subtraction");
        System.out.println("* -> multiplication");
        System.out.println("/ -> division");
        System.out.println("% -> modulus");
        System.out.println("^ -> exponent");
        System.out.println();
        System.out.println();
        System.out.println("There are some other functions the calculator can perform, and these should be entered as the name of the function and then the numbers, seperated by spaces. ex: avg 1 2 3");
        System.out.println("Other functions:");
        System.out.println("avg -> average");
        System.out.println("max -> maximum");
        System.out.println("min -> minimum");
        System.out.println();

    }
}
