import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.lang.Math;
import java.lang.*;

public class Calculator {


    public class MathTest {
        public void main(String arg[]){
            MathTest testelest = new MathTest(); //Test
            //int i = testelest.sekundUdregner();
            //double sqrt = Math.sqrt(6)/4 + Math.sqrt(2)/4;
            //System.out.println("Sqrt: " + sqrt + "\n" + Math.pow(sqrt, 2));
        }

        public double mathDistance(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a til ligningen for en ret ling:");
            double a = scanner.nextInt();

            System.out.println("Enter b til ligningen for en ret ling:");
            double b = scanner.nextInt();

            System.out.println("Enter X0 koordinat:");
            double x = scanner.nextInt();

            System.out.println("Enter Y0 koordinat:");
            double y = scanner.nextInt();

            double result = (a*x-y+b) / Math.sqrt(1+Math.pow(a,2));
            return result;
        }

        public int sekundUdregner(){
            final int dag = 24*60*60;
            final int time = 60*60;
            final int minut = 60;

            System.out.println("Enter the amount of seconds:");
            Scanner scanner = new Scanner(System.in);
            int totalsekunder = scanner.nextInt();

            int dageialt = totalsekunder / dag;
            int timerialt = totalsekunder % dag / time;
            int minutterialt = totalsekunder % dag % time / minut;
            int sekunderialt = totalsekunder % dag % time % minut;

            System.out.println("Dage: " + dageialt + "\nTimer: "+ timerialt + "\nMinutter: " + minutterialt +"\nSekunder: " + sekunderialt +"");
            return 1;
        }

        public void passwordCheck(){
            Scanner scan = new Scanner(System.in);
            String password = scan.nextLine();

            if(password.length() <= 4){ // Det er uoverenstemmelse, opgaven siger en ting, men deres løsning siger en anden ting.
                System.out.println("Password length is too short");
            }
            else if(password.length() >= 9){
                System.out.println("Password is too long");
            }
            else {
                System.out.println("Your password has been set");
            }
        }

        public void Andengradsligning(){
            double a,b,c;

            Scanner scan = new Scanner(System.in);
            System.out.println("For andengrads ligning skriv a værdi: ");
            a = scan.nextDouble();
            System.out.println("b værdi: ");
            b = scan.nextDouble();
            System.out.println("c værdi");
            c = scan.nextDouble();

            if (a == 0){
                if (b == 0) {
                    System.out.println("Der findes ingen rødder");
                }
                else{
                    double x0 = -c/b;
                    System.out.println("Der findes en løsning:\n" + x0);
                }
            }
            else{
                double diskriminant = Math.pow(b,2) - 4*a*c;
                if (diskriminant<0){
                    System.out.println("Der findes ingen rødder");
                }
                else if(diskriminant == 0){
                    double x0 = -b / 2*a;
                    System.out.println("Der findes en løsning til ligningen:\n" + x0);
                }
                else {
                    double x0 = (-b + Math.sqrt(diskriminant)) / 2*a;
                    double x1 = (-b - Math.sqrt(diskriminant)) / 2*a;
                    System.out.println("Der findes to løsning til ligning:\nx = " + x0 +" x= " + x1);
                }
            }
        }
    }


    class Opgave4{
        public void main(String args[]){
            Opgave4 opg4 = new Opgave4();
        /*opg4.passwordCheck2();
        System.out.println("We are done.");*/
            //opg4.udskrivAscii();
            opg4.calculator();

        }
        public void passwordCheck2(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter a password");
            while (true) {
                String password = scan.nextLine();

                if (password.length() < 4) {
                    System.out.println("Password length is too short, please enter a password < 4 & > 9");
                } else if (password.length() > 9) {
                    System.out.println("Password is too long, please enter a password < 4 & > 9");
                } else {
                    System.out.println("Your password has been set");
                    break;
                }
            }
        }

        public void udskrivAscii(){
            Scanner scan = new Scanner(System.in);

            System.out.println("Please enter an ascii charecter:");
            char brugerinput = scan.next().charAt(0);

            if (Character.isUpperCase(brugerinput)){
                System.out.println("Tegnet er et stort bogstav, A-Z");
            } else if (Character.isLowerCase(brugerinput)){
                System.out.println("Tegnet er et lille bogstav");
            } else if (Character.isDigit(brugerinput)){
                System.out.println("Tegner er en int");
            } else {
                int ascii = (int) brugerinput;
                ArrayList<Integer> asciichars = new ArrayList<>();
                asciichars.add(33);
                asciichars.add(35);
                asciichars.add(43);
                asciichars.add(92);
                if(asciichars.contains(ascii)){
                    System.out.println("Tegnet er et af de 4 special tegn " + ascii);
                } else{
                    System.out.println("This is not a known ascii");
                }

            }
        }

        public void calculator(){
            double firstNum=0.0;
            double secondNum=0.0;
            char operator;
            double answer =0.0;
            ArrayList<Character> validOps = new ArrayList<Character>();
            validOps.add('+');
            validOps.add('-');
            validOps.add('/');
            validOps.add('*');

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the first number:");
            while(true) {
                try {
                    firstNum = scan.nextDouble();
                    break;
                }catch (Exception e){
                    System.out.println("Please select a number!");
                    scan.next();
                }
            }
            System.out.println("Select operator:");
            operator = scan.next().charAt(0);
            while (!validOps.contains(operator)){
                System.out.println("This is not a valid operator, please select one of the valids:\n"+validOps);
                operator = scan.next().charAt(0);
            }
            System.out.println("Enter the second number:");
            while(true) {
                try {
                    secondNum = scan.nextDouble();
                    break;
                } catch(Exception e){
                    System.out.println("Please select a number!");
                    scan.next();
                }
            }
            scan.close();

            switch (operator){
                case '+': answer = firstNum + secondNum;
                    break;
                case '-': answer = firstNum - secondNum;
                    break;
                case '*': answer = firstNum * secondNum;
                    break;
                case '/': answer = firstNum / secondNum;
                    break;
                //default: System.out.println("That is not a valid operator, please use either of these operators:\n+,-,/,*");
            }

            System.out.println("Your answer is:\n" +answer);
        }
    }




}
