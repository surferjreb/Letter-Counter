
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        Controller controller;
        String word;


        System.out.print("\tWelcome to Letter counter\nPlease enter a sentence: ");
        word = input.nextLine();
        controller = Controller.getInstance(word);
        controller.runMenu();
    }
}
