import java.util.Scanner;

public class Input {
    String spam_email;
    String ham_email;
    String new_email;

    public Input() {
    }
    public String SampleSpamInput() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter spam email sample: ");
//        spam_email = input.nextLine();
        spam_email = "you can now buy one product and get another free";
        return spam_email;
    }
    public String SampleHamInput() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter ham email sample: ");
//        ham_email = input.nextLine();
        ham_email = "hi how are you free";
        return ham_email;
    }
    public String NewEmail() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new email sample: ");
        new_email = input.nextLine();
        return new_email;
    }
}
