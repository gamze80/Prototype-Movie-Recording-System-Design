public class Writer extends Artist{
    String writingStyle;
    Writer(String uniqueId,String name,String surname, String country,  String writingStyle){
        super(name, surname, country, uniqueId);
        this.writingStyle = writingStyle;
    }
}
