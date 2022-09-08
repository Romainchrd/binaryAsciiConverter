import java.util.Scanner;

public class binaryAsciiConverter {

    private static Scanner sc = new Scanner(System.in);

    public static void run(){
        System.out.println(
                """
                1. Text to binary
                2. Binary to text
                3. Quit 
                Enter choice:\s       
                """
        );
        int choice = sc.nextInt();
        sc.nextLine(); // Buffer
        if (choice == 1){
            textToBinary();
        }
        else if (choice == 2) {
            binaryToText();
        }
    }

    private static void binaryToText() {
        System.out.println("Enter binary: ");
        String text1 = sc.nextLine();
        int maxBinary = 128;
        int total1 = 0;
        String final1 = "";
        for(int i = 0; i < text1.length(); i++) {
            char ascii = text1.charAt(i);

            if(ascii == '1')
            {
                total1 += maxBinary;
            }
            else if(maxBinary == 0){
                char letter = (char) total1;
                total1 = 0;
                maxBinary = 128;
                final1 += letter;
            }
            else if(total1 == 0)
            {
                final1 += " ";
            }
            maxBinary = maxBinary / 2;
        }
        System.out.println(final1);

    }


    private static void textToBinary() {
        System.out.println("Enter text: ");
        String text = sc.nextLine();

        // String.charAt()
        // int ascii = String.charAt(i);
        String binary = "";
        int maxBinary = 128;
        for(int i = 0; i < text.length(); i++) {
            int ascii = text.charAt(i);
            for (int x = 0; x < 8; x++)
            {
                if ((ascii - maxBinary) >= 0) {
                    ascii -= maxBinary;
                    binary += "1";
                }
                else {
                    binary += "0";
                }
                maxBinary = maxBinary / 2;
            }
            maxBinary = 128;
        }
        System.out.println(binary);
    }
}


