

public class Book extends Entire_Library implements Library {
    private int location;

    public Book(){
        super();
    }

    public Book(String title, String first, String last, String genre, String pub, String height,int location){
        super(title,first,last,genre,pub,height);
        this.location = location;
    }

    public int getLocation(){
        return this.location;
    }

    public void display(){
        System.out.println("Title: "+this.title);
        System.out.println("Author: "+this.first+" "+this.last);
        System.out.println("Genre: "+this.genre);
        System.out.println("Publisher: "+this.publisher);
        System.out.println("height: "+this.height);

    }


}
