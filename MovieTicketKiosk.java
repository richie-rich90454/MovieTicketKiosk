/*
    MovieTicketKiosk main runner file.
    A file that is created to create instances of the MovieTicketKioskUserRequirements class to process inputs and create ticket kiosk outputs with relevant and accurate information

    Completed challenge one (no duplicated seats+infinite printing) achieved via a non-ending while loop that is only terminated when the user enters false and a HashMap that stores the seats as a "row,seat" String to check for duplicates (using HashMap because it offers low time complexity lookup to avoid array iteration, as the former is O(1) while the latter is O(n)) to trigger a regeneration in the MovieTicketKioskUserRequirements class's generateBookingCodeAndSeatingAndMemberDiscount() method if the two are the same and only stops when they are different to prevent duplicated seats

    Richard Jiang
    2026/9/9

    jar build (reference from https://docs.oracle.com/javase/tutorial/deployment/jar/appman.html) with:
        1. javac -d out *.java   (compiling all .java files as .class files)
        2. jar cfe MovieTicketKiosk.jar MovieTicketKiosk -C out . (way to build an executable jar without Manifest.txt; referenced from https://docs.oracle.com/javase/tutorial/deployment/jar/appman.html and https://docs.oracle.com/javase/8/docs/technotes/tools/unix/jar.html to make it build the entire out directory with cfe being create-file entrypoint, which is the main class, and set as MovieTicketKiosk's .class file)
        3. java -jar MovieTicketKiosk.jar (run the compiled jar)
 */
import java.util.HashMap;
import java.util.Scanner;
public class MovieTicketKiosk{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        HashMap<String, Integer> usedSeats=new HashMap<String, Integer>();
        while(true){
            System.out.println("\nWelcome to the Starlight Cinema Kiosk!\n");
            MovieTicketKioskUserRequirements userRequirements=new MovieTicketKioskUserRequirements(usedSeats);
            System.out.print("How many tickets do you want to purchase (it must be greater than 0; if the value is smaller than 0, it would be set as 0): ");
            userRequirements.setTicketCount(input.nextInt());
            System.out.print("How many popcorn bags do you want to purchase (it must be greater than 0; if the value is smaller than 0, it would be set as 0): ");
            userRequirements.setPopcornCount(input.nextInt());
            System.out.print("How many drinks do you want to purchase (it must be greater than 0; if the value is smaller than 0, it would be set as 0): ");
            userRequirements.setDrinkCount(input.nextInt());
            input.nextLine();
            System.out.print("What is your name (the format is FirstName LastName with the start of both parts capitalized): ");
            userRequirements.setUsername(input.nextLine());
            System.out.print("What is the name of the movie: ");
            userRequirements.setMovieTitle(input.nextLine());
            userRequirements.generateBookingCodeAndSeatingAndMemberDiscount();
            String currentSeat=(userRequirements.getSeat())[0]+",";
            currentSeat+=(userRequirements.getSeat())[1];
            currentSeat+=" in "+userRequirements.getMovieTitle();
            usedSeats.put(currentSeat, 1);
            System.out.println(userRequirements);
            System.out.print("\nEnter true to continue, or enter false to exit: ");
            boolean continueOrNot=input.nextBoolean();
            input.nextLine();
            if (!continueOrNot){
                break;
            }
        }
    }
}