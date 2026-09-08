import java.util.Scanner;
public class MovieTicketKiosk{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to the Starlight Cinema Kiosk!\n");
        MovieTicketKioskUserRequirements userRequirements=new MovieTicketKioskUserRequirements();
        System.out.print("\nHow many tickets do you want to purchase (it must be greater than 0; if the value is smaller than 0, it would be set as 0): ");
        userRequirements.setTicketCount(input.nextInt());
        System.out.print("\nHow many popcorn bags do you want to purchase (it must be greater than 0; if the value is smaller than 0, it would be set as 0): ");
        userRequirements.setPopcornCount(input.nextInt());
        System.out.print("\nHow many drinks do you want to purchase (it must be greater than 0; if the value is smaller than 0, it would be set as 0): ");
        userRequirements.setDrinkCount(input.nextInt());
        input.nextLine();
        System.out.print("\nWhat is your name (the format is FirstName LastName with the start of both parts capitalized): ");
        userRequirements.setUsername(input.nextLine());
        System.out.print("\nWhat is the name of the movie: ");
        userRequirements.setMovieTitle(input.nextLine());
        System.out.println();
    }
}