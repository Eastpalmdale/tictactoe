import java.util.Scanner;

public class safeinput {

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean done = false;
        String userChoiceYesOrNo;

        System.out.println(prompt);
        userChoiceYesOrNo = pipe.nextLine();

        userChoiceYesOrNo = userChoiceYesOrNo.toLowerCase();

        switch (userChoiceYesOrNo) {
            case "y":
                done = true;
                break;
            case "n":
                break;
            default:
                System.out.println("That is not a valid input, please enter y or n only.");
        }

        return done;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int userInput = 0;
        String trash;
        boolean done = false;
        // loop
        do {
            System.out.println(prompt);
            if (pipe.hasNextInt()) {
                userInput = pipe.nextInt();

                if (userInput >= low && userInput <= high) {

                    done = true;
                } else {
                    System.out.println("This number is not in the range accepted.");
                }
            } else {
                trash = pipe.nextLine();

                System.out.println(trash+" is not a correct input. Enter numbers only.");
            }


        } while (!done);
        return userInput;
    }


}
