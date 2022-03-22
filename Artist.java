import java.util.ArrayList;
import java.util.Collections;

public class Artist extends People {
    Artist(String name, String surname, String country, String uniqueId) {
        super(name, surname, country, uniqueId);

    }

    public String ArtistFromCountry(People peopleInformations, ArrayList<String> peopleFile, String country) {
        String output = "";
        output += "Directors: \n";
        int DirectorCheckpoint = 0;
        int WriterCheckPoint = 0;
        int ChildCheck = 0;
        int StudentCheck = 0;
        int ActorCheck = 0;
        if (peopleInformations.Directors.size() == 0) {
            output += "No result \n";
        } else {
            for (Director director : peopleInformations.Directors) {
                if (director.country.equals(country)) {
                    output += director.name + " " + director.surname + " " + director.agents + "\n";
                    DirectorCheckpoint++;
                }
            }

        }
        if (DirectorCheckpoint == 0) {
            output += "No result \n";
        }
        output += "\nWriters: \n";
        if (peopleInformations.Writers.size() == 0) {
            output += "No result \n";
        } else {
            for (Writer director : peopleInformations.Writers) {
                if (director.country.equals(country)) {
                    output += director.name + " " + director.surname + " " + director.writingStyle + "\n";
                    WriterCheckPoint++;
                }
            }

        }
        if (WriterCheckPoint == 0) {
            output += "No result \n";
        }
        output += "\nActors: \n";
        if (peopleInformations.Actors.size() == 0) {
            output += "No result \n";
        } else {
            for (Actor director : peopleInformations.Actors) {
                if (director.country.equals(country)) {
                    output += director.name + " " + director.surname + " " + director.height + " cm" + "\n";
                    ActorCheck++;

                }
            }

        }
        if (ActorCheck == 0) {
            output += "No result \n";
        }
        output += "\nChildActors: \n";
        if (peopleInformations.ChildPerformer.size() == 0) {
            output += "No result \n";
        } else {
            for (ChildPerformer director : peopleInformations.ChildPerformer) {
                if (director.country.equals(country)) {
                    output += director.name + " " + director.surname + " " + director.age + "\n";
                    ChildCheck++;
                }
            }

        }
        if (ChildCheck == 0) {
            output += "No result \n";
        }
        output += "\nStuntPerformers: \n";
        if (peopleInformations.StuntPerformers.size() == 0) {
            output += "No result \n";
        } else {
            for (StuntPerformer director : peopleInformations.StuntPerformers) {
                if (director.country.equals(country)) {
                    output += director.name + " " + director.surname + " " + director.height + " cm" + "\n";
                    StudentCheck++;
                }
            }

        }
        if (StudentCheck == 0) {
            output += "No result \n";
        }
        output += "\n-----------------------------------------------------------------------------------------------------\n";
        return output;
    }
}
