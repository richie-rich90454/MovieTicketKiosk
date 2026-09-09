public class MovieTicketKioskUserRequirements {
    private int ticketCount;
    private int popcornCount;
    private int drinkCount;
    private String username;
    private String movieTitle;
    private String bookingCode;
    private int[] seat=new int[2];//index 0 denoting row while index 1 denotes seat number
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
        usernameInitials=(username.substring(0, 1)+username.substring(username.indexOf(" ")+1, username.indexOf(" ")+2)).toUpperCase();
    }
    public void setMovieTitle(String movieTitle){
        this.movieTitle=movieTitle;
    }
    public void generateBookingCodeAndSeatingAndMemberDiscount(){
        int randomUserCode=(int)(Math.random()*900)+100;
        if (movieTitle.length()<=3){
            bookingCode=movieTitle.toUpperCase()+"-"+randomUserCode;
        }
        else{
            bookingCode=movieTitle.substring(0, 3).toUpperCase()+"-"+randomUserCode;
        }
        seat[0]=(int)(Math.random()*10+1);
        seat[1]=(int)(Math.random()*20+1);
        memberDiscount=(int)((Math.random()*10+5)*1000)/1000.0;
    }
    public String toString(){
        String finalReturnString="\n\n\n-----------------------------------------------\nSTARLIGHT CINEMA MOVIE TICKET\n\n\n";
        finalReturnString+="Booking Code: "+bookingCode;
        finalReturnString+="\nCustomer: "+username+" ("+usernameInitials+")";
        finalReturnString+="\nMovie: "+movieTitle;
        finalReturnString+="\nSeat: Row "+seat[0]+" Seat "+seat[1]+"\n\n";
        finalReturnString+="ITEM\tQTY\tPRICE\tTOTAL";
        finalReturnString+="\nTicket\t"+ticketCount+"\t"+ticketPrice+"\t"+(ticketPrice*ticketCount);
        finalReturnString+="\nPopcorn\t"+popcornCount+"\t"+popcornPrice+"\t"+(popcornCount*popcornPrice);
        finalReturnString+="\nDrink\t"+popcornCount+"\t"+drinkPrice+"\t"+(drinkCount*drinkPrice);
        double totalValue=(ticketPrice*ticketCount)+(popcornCount*popcornPrice)+(drinkCount*drinkPrice);
        finalReturnString+="\n\nSubtotal\t"+totalValue;
        double memberDiscountValue=(int)(totalValue*(memberDiscount/100)*1000)/1000.0;
        finalReturnString+="\nMember Discount ("+memberDiscount+"%)\t-"+memberDiscountValue;
        totalValue-=memberDiscountValue;
        double salesTaxValue=(int)(totalValue*(salesTaxPercentage/100)*1000)/1000.0;
        finalReturnString+="\nTax ("+salesTaxPercentage+"%)\t"+salesTaxValue;
        totalValue+=salesTaxValue;
        totalValue=((int)totalValue*1000)/1000.0;
        finalReturnString+="\nTOTAL\t"+totalValue;
        finalReturnString+="\n-----------------------------------------------";
        finalReturnString+="\n\nThank you, "+usernameInitials+" - enjoy "+movieTitle+"!";
        return finalReturnString;
    }
}
