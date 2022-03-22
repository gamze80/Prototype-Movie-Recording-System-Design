import java.util.ArrayList;
import java.util.concurrent.Callable;

public class FeatureFilms extends Film {
    String releaseDate;
    String budget;
    String writers;
    String genre;

    FeatureFilms(String uniquieFilmId, String filmTitle, String filmLanguage, String directors, String runtime, String country, String cast, String genre, String releaseDate, String writers, String budget) {
        super(uniquieFilmId, filmTitle, filmLanguage, directors, runtime, country, cast);
        this.budget = budget;
        this.releaseDate = releaseDate;
        this.writers = writers;
        this.genre = genre;
    }

    public String AddFeatureFilmToList(Film filmInformations, People peopleInformations, String data, ArrayList<String> ourPersons, String ID, FeatureFilms featureFilms) {
        String output = "";
        int CheckPoint = 0;
        for (FeatureFilms featureFilms1 : filmInformations.FeatureFilmsCount) {
            if (featureFilms1.uniquieFilmId.equals(ID)) {
                CheckPoint++;
                output += data + "\n\n";
                output += "Command Failed\n";
                output += "Film ID: " + featureFilms1.uniquieFilmId + "\n";
                output += "Film title: " + featureFilms1.filmTitle + "\n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";
            }
        }
        if (CheckPoint == 0) {


            int myPersonel = ourPersons.size();
            for (String k : ourPersons) {
                for (Writer writer : peopleInformations.Writers) {
                    if (writer.uniqueId.equals(k)) {
                        myPersonel = myPersonel - 1;
                    }
                }
                for (Director director : peopleInformations.Directors) {
                    if (director.uniqueId.equals(k)) {
                        myPersonel = myPersonel - 1;
                    }
                }
                for (ChildPerformer childPerformer : peopleInformations.ChildPerformer) {
                    if (childPerformer.uniqueId.equals(k)) {
                        myPersonel = myPersonel - 1;
                    }
                }
                for (StuntPerformer studentPerformer : peopleInformations.StuntPerformers) {
                    if (studentPerformer.uniqueId.equals(k)) {
                        myPersonel = myPersonel - 1;
                    }
                }
                for (Actor actor : peopleInformations.Actors) {
                    if (actor.uniqueId.equals(k)) {
                        myPersonel = myPersonel - 1;
                    }
                }

            }

            if (myPersonel == 0) {
                filmInformations.FeatureFilmsAdding(featureFilms);
                filmInformations.NewFeatureFilmAdding(featureFilms);
                output += data + "\n\n";
                output += "FeatureFilm added successfully\n";
                output += "Film ID: " + featureFilms.uniquieFilmId + "\n";
                output += "Film title: " + featureFilms.filmTitle + "\n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";

            } else {
                output += data + "\n\n";
                output += "Command Failed\n";
                output += "Film ID: " + featureFilms.uniquieFilmId + "\n";
                output += "Film title: " + featureFilms.filmTitle + "\n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";

            }
        }

        return output;
    }

    public String ListFeatureFilmsBefore(String data, Film filmInformations, ArrayList<String> filmFile) {
        String output = "";
        String[] dataArray = data.split("\t");
        String YEAR = dataArray[3];
        int FilmExistsCheckPoint = 0;
        output += data + "\n\n";
        for (String h : filmFile) {
            String[] innerList = h.split("\t");
            if (innerList[0].equals("FeatureFilm:")) {
                String myFilmID = innerList[1];
                for (FeatureFilms shortMovie : filmInformations.FeatureFilmsCount) {
                    if (shortMovie.uniquieFilmId.equals(myFilmID)) {
                        if (Integer.parseInt(shortMovie.releaseDate.substring((shortMovie.releaseDate.length() - 4), shortMovie.releaseDate.length())) < Integer.parseInt(YEAR)) {
                            output += "Film title: " + shortMovie.filmTitle +
                                    " (" + shortMovie.releaseDate.substring((shortMovie.releaseDate.length() - 4), shortMovie.releaseDate.length()) + ")" + "\n";
                            output += shortMovie.runtime + " min\n";
                            output += "Language: " + shortMovie.filmLanguage + "\n";
                            output += "\n";
                            FilmExistsCheckPoint++;
                        }
                    }
                }
            }
        }
        for (FeatureFilms shortMovie : filmInformations.NewAddedFeatureFilmsArray) {

            if (Integer.parseInt(shortMovie.releaseDate.substring((shortMovie.releaseDate.length() - 4), shortMovie.releaseDate.length())) < Integer.parseInt(YEAR)) {
                output += "Film title: " + shortMovie.filmTitle +
                        " (" + shortMovie.releaseDate.substring((shortMovie.releaseDate.length() - 4), shortMovie.releaseDate.length()) + ")" + "\n";
                output += shortMovie.runtime + " min\n";
                output += "Language: " + shortMovie.filmLanguage + "\n";
                output += "\n";
                FilmExistsCheckPoint++;

            }
        }
        if (FilmExistsCheckPoint == 0) {
            output += "No result \n\n";
            output += "-----------------------------------------------------------------------------------------------------\n";
        } else {
            output += "-----------------------------------------------------------------------------------------------------\n";
        }


        return output;
    }
    public String ListFeatureFilmsAfter(String data, Film filmInformations , ArrayList<String> filmFile){
        String output = "";
        String[] dataArray = data.split("\t");
        String YEAR = dataArray[3];
        int FilmExistsCheckPoint = 0;
        output += data + "\n\n";
        for (String h : filmFile) {
            String[] innerList = h.split("\t");
            if (innerList[0].equals("FeatureFilm:")) {
                String myFilmID = innerList[1];
                for (FeatureFilms shortMovie : filmInformations.FeatureFilmsCount) {
                    if (shortMovie.uniquieFilmId.equals(myFilmID)) {
                        if (Integer.parseInt(shortMovie.releaseDate.substring((shortMovie.releaseDate.length() - 4), shortMovie.releaseDate.length())) >= Integer.parseInt(YEAR)) {
                            output += "Film title: " + shortMovie.filmTitle +
                                    " (" + shortMovie.releaseDate.substring((shortMovie.releaseDate.length() - 4), shortMovie.releaseDate.length()) + ")" + "\n";
                            output += shortMovie.runtime + " min\n";
                            output += "Language: " + shortMovie.filmLanguage + "\n";
                            output += "\n";
                            FilmExistsCheckPoint++;
                        }
                    }
                }
            }
        }
        for (FeatureFilms shortMovie : filmInformations.NewAddedFeatureFilmsArray) {

            if (Integer.parseInt(shortMovie.releaseDate.substring((shortMovie.releaseDate.length() - 4), shortMovie.releaseDate.length())) >= Integer.parseInt(YEAR)) {
                output += "Film title: " + shortMovie.filmTitle +
                        " (" + shortMovie.releaseDate.substring((shortMovie.releaseDate.length() - 4), shortMovie.releaseDate.length()) + ")" + "\n";
                output += shortMovie.runtime + " min\n";
                output += "Language: " + shortMovie.filmLanguage + "\n";
                output += "\n";
                FilmExistsCheckPoint++;

            }
        }
        if (FilmExistsCheckPoint == 0) {
            output += "No result \n\n";
            output += "-----------------------------------------------------------------------------------------------------\n";
        } else {
            output += "-----------------------------------------------------------------------------------------------------\n";
        }
        return output;
    }

}
