



import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private static Controller control_instance = null;
    private WordCount myLetters;
    private String word;

    private Controller(String word){
        myLetters = WordCount.getInstance(word);
        this.word = word;
    }//End constructor

    public static Controller getInstance(String word){
        if(control_instance == null) {
            control_instance = new Controller(word);
        }
        else{
            control_instance = new Controller(word);
        }
        return control_instance;
    }

    private boolean menu(int selection){
        Scanner input = new Scanner(System.in);
        boolean quit = false;


        while(!quit) {
            switch (selection) {
                case 0:
                    quit = true;
                    return quit;
                case 1:
                    printMenu();
                    break;

                case 2:
                    displayWordChart();
                    break;

                case 3:
                    showLetters();
                    break;

                case 4:
                    getLetterOccurrence();
                    break;

                case 5:
                    showSingleLetters();
                    break;

                case 6:
                    showRecurrenceLetters();
                    break;
                default:
                    System.out.println("Invalid Selection, Please try again.");
            }//End switch
            System.out.println();

            System.out.print("Enter a selection: ");
            input.reset();
            selection = input.nextInt();
         //   quit = menu(mySelection);
        }
        return false;
    }//End menu
//-------------------------------------
    private void printMenu(){
        System.out.println("\tMenu\t");
        System.out.println();
        System.out.println("0 - to enter a new sentence or exit.\n1 - to print menu.\n2 - to display letter occurrence chart.\n"+
                "3 - to show the letters in the sentence.\n4 - to get a specific letter occurrence.\n"+
                "5 - to show just the letters that appear once.\n6 - to show the letters that occur " +
                "multiple times.");
    }
//-------------------------------------
    private void displayWordChart(){
        myLetters.displayLetterChart();
    }
//-------------------------------------
    private void showLetters(){
        myLetters.displayLetters();
    }
//-------------------------------------
    private void getLetterOccurrence(){
        Scanner input = new Scanner(System.in);
        String letter;
        System.out.println("Enter your letter: ");
        letter = input.nextLine();
        System.out.println(myLetters.getLetterOccurrence(letter));

    }
//-------------------------------------
    private void showSingleLetters(){
        myLetters.getSingleOccurrenceLetters();
    }
//-------------------------------------
    private void showRecurrenceLetters(){
        myLetters.getRecurringLetters();
    }
//-------------------------------------
    public void runMenu(){
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        boolean quit = false;
        try {

            while(!quit) {
                control_instance.printMenu();
                System.out.print("Enter your selection: ");
                int selection = input.nextInt();
                control_instance.menu(selection);
                input.reset();
                System.out.print("Do you wish to continue(y/n): ");
                String answer = input2.nextLine();
                    if(answer.equalsIgnoreCase("n")){
                        quit = true;
                    }
                    else{
                        reset();
                    }
				input.reset();
            }
        }
        catch(InputMismatchException e){
            System.out.println("****************************");
            System.out.println("****************************");
            System.out.println("Do not use any numbers.");
            reset();
        }

    }
//-------------------------------------
    private void reset(){
        Scanner input = new Scanner(System.in);
        Controller controller;

        System.out.print("\tWelcome to Letter counter\nPlease enter a sentence: ");
        input.reset();
        word = input.nextLine();
        controller = getInstance(word);
        controller.runMenu();
    }
}//End class
