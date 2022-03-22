import java.util.ArrayList;

public class People {
    String name;
    String surname;
    String country;
    String uniqueId;


    People(String name, String surname, String country, String uniqueId) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.uniqueId = uniqueId;
    }
    ArrayList<Director> Directors = new ArrayList<Director>();
    ArrayList<Writer> Writers = new ArrayList<Writer>();
    ArrayList<Actor> Actors = new ArrayList<Actor>();
    ArrayList<ChildPerformer> ChildPerformer = new ArrayList<ChildPerformer>();
    ArrayList<StuntPerformer> StuntPerformers = new ArrayList<StuntPerformer>();
    ArrayList<User> Users = new ArrayList<User>();

    public void DirectorAdding(Director director) {
        Directors.add(director);
    }

    public void WritterAdding(Writer writer) {
        Writers.add(writer);
    }

    public void ActorAdding(Actor actor) {
        Actors.add(actor);
    }

    public void ChildPerformerAdding(ChildPerformer childPerformer) {
        ChildPerformer.add(childPerformer);
    }

    public void StuntPerformersAdding(StuntPerformer studentPerformer) {
        StuntPerformers.add(studentPerformer);
    }

    public void UserAdding(User user) {
        Users.add(user);
    }



}
