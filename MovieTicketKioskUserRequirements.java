public class MovieTicketKioskUserRequirements {
    private int ticketCount;
    private int popcornCount;
    private int drinkCount;
    private String username;
    private String movieTitle;
    private String bookingCode;
    private int[] seat;//index 0 denoting row while index 1 denotes seat number
    public String usernameInitials;
    private final double ticketPrice=12.50;
    private final double popcornPrice=6.75;
    private final double drinkPrice=4.25;
    private final double salesTaxPercentage=8.25;
    private double memberDiscount;
    public void setTicketCount(int ticketCount){
        this.ticketCount=ticketCount;
    }
    public void setPopcornCount(int popcornCount){
        this.popcornCount=popcornCount;
    }
    public void setDrinkCount(int drinkCount){
        this.drinkCount=drinkCount;
    }
    public void setUsername(String username){
        this.username=username;
        usernameInitials=username.substring(0, 1)+username.substring(username.indexOf(" ")+1, username.indexOf(" ")+2);
    }
    public void setMovieTitle(String movieTitle){
        this.movieTitle=movieTitle;
    }
    public void generateBookingCodeAndSeating(){
        int randomUserCode=(int)(Math.random()*900)+100;
        if (movieTitle.length()<=3){
            bookingCode=movieTitle+randomUserCode;
        }
        else{
            bookingCode=movieTitle.substring(0, 4)+randomUserCode;
        }
        seat[0]=(int)(Math.random()*10)+1;
        seat[1]=(int)(Math.random()*20)+1;
    }
    public String toString(){
        
    }
}
