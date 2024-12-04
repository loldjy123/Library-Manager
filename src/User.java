public class User {
    private String emplId;
    private String title;
    private String  status; // 1 is yes, 0 is no

    public User(String id, String title){
        this.emplId = id;
        this.title = title;
    }

    public User(String id, String title,String status){
        this.emplId = id;
        this.title = title;
        this.status = status;
    }


    public String getEmplId(){
        return emplId;
    }

    public String getTitle(){
        return title;
    }

}
