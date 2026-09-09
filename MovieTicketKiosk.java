import java.util.HashMap;
import java.util.Scanner;
public class MovieTicketKiosk{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        HashMap<String, Integer> usedSeats=new HashMap<String, Integer>();
        while(true){
            System.out.println("Welcome to the Starlight Cinema Kiosk!\n");
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
            String currentSeat=(userRequirements.getSeat())[0]+", ";
            currentSeat+=(userRequirements.getSeat())[1];
            usedSeats.put(currentSeat, 1);
            System.out.println(userRequirements);
            System.out.print("Enter true to continue: ");
            boolean continueOrNot=input.nextBoolean();
            input.nextLine();
            if (!continueOrNot){
                break;
            }
        }
    }
}