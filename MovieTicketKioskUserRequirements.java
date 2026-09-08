public class MovieTicketKioskUserRequirements {
    private int ticketCount;
    private int popcornCount;
    private int drinkCount;
    private String username;
    private String movieTitle;
    private String bookingCode;
    private int[] seat;
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
    }
    public void setMovieTitle(String movieTitle){
        this.movieTitle=movieTitle;
    }
    public void generateBookingCodeAndSeating(){
        seat[0]=(int)(Math.random()*10)+1;
        seat[1]=(int)(Math.random()*20)+1;

    }
}
