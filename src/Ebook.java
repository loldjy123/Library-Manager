public class Ebook extends Entire_Library implements Library{

    public Ebook(){
        super();
    }

    public Ebook(String title, String first, String last, String genre, String pub, String height,int location){
        super(title,first,last,genre,pub,height);
    }
}
