public class StuntPerformer extends Performer{
    String height ;
    String realActorId;
    StuntPerformer(String uniqueId,String name,String surname, String country,  String height, String realActorId){
        super(name,surname, country, uniqueId);
        this.height = height;
        this.realActorId = realActorId;
    }
}
