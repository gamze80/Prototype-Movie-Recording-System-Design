public class ChildPerformer extends Performer{
    String age;
    ChildPerformer(String uniqueId,String name,String surname, String country,  String age){
        super(name,surname, country, uniqueId);
        this.age = age;
    }
}
