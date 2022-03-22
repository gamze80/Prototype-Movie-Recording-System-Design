public class Actor extends  Performer{
    String height ;
    Actor(String uniqueId,String name,String surname, String country,  String height){
        super(name,surname, country, uniqueId);
        this.height = height;
    }
}
