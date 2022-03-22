public class Director extends Artist {
     String agents ;
    Director(String uniqueId,String name, String surname, String country, String agents){
        super(name, surname, country, uniqueId);
        this.agents = agents;
    }
}
