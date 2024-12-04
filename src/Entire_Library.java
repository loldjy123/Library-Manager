
abstract class Entire_Library {
    String title, first, last , genre, publisher, height;
    
    public Entire_Library(){

    }

    public Entire_Library(String title, String first, String last, String genre, String pub, String height){
        this.title = title;
        this.first  = first;
        this.last = last;
        this.genre = genre;
        this.publisher = pub;
        this.height = height;

    }

    public String getTitle(){
        return this.title;
    }

    public String getFirst(){
        return this.first;
    }

    public String getLast(){
        return this.last;
    }

    public String getGenre(){
        return this.genre;
    }

    public String getPublisher(){
        return this.publisher;
    }


}
