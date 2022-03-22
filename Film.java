import java.util.ArrayList;
import java.util.Collections;

public class Film {
    String uniquieFilmId;
    String filmTitle;
    String filmLanguage;
    String runtime;
    double ratingSquare;
    String country;
    String directors;
    String cast;
    int ratingCount;

    Film(String uniquieFilmId, String filmTitle, String filmLanguage, String directors, String runtime, String country, String cast) {
        this.uniquieFilmId = uniquieFilmId;
        this.filmTitle = filmTitle;
        this.filmLanguage = filmLanguage;
        this.directors = directors;
        this.runtime = runtime;
        this.country = country;
        this.cast = cast;
        this.ratingSquare = 0;
        this.ratingCount = 0;
    }

    ArrayList<ShortMovie> ShortMovies = new ArrayList<ShortMovie>();
    ArrayList<FeatureFilms> FeatureFilmsCount = new ArrayList<FeatureFilms>();
    ArrayList<Documentary> Documentaries = new ArrayList<Documentary>();
    ArrayList<TVSeries> TVSeriesCount = new ArrayList<TVSeries>();
    ArrayList<FeatureFilms> NewAddedFeatureFilmsArray = new ArrayList<FeatureFilms>();

    public void ShortMovieAdding(ShortMovie shortMovie) {
        ShortMovies.add(shortMovie);
    }

    public void FeatureFilmsAdding(FeatureFilms featureFilms) {
        FeatureFilmsCount.add(featureFilms);
    }

    public void DocumentaryAdding(Documentary documentary) {
        Documentaries.add(documentary);
    }

    public void TvSerieAdding(TVSeries tvSeries) {
        TVSeriesCount.add(tvSeries);
    }

    public void NewFeatureFilmAdding(FeatureFilms featureFilms) {
        NewAddedFeatureFilmsArray.add(featureFilms);
    }


    public String ViewingFilm(String data, Film filmInformations, People peopleInformations) {
        String output = "";
        String[] dataArray = data.split("\t");
        int checkPointShortFilm = 0;
        int checkPointFeatureFilm = 0;
        FeatureFilms featureFilms1 = new FeatureFilms("", "", "", "",
                "", "", "", "", "", "", "");
        ShortMovie shortMovie1 = new ShortMovie("", "", "", "",
                "", "", "", "", "", "");
        int StarterCheckPoint = 0;
        for (FeatureFilms featureFilms : filmInformations.FeatureFilmsCount) {
            if (dataArray[1].equals(featureFilms.uniquieFilmId)) {
                StarterCheckPoint++;

            }
        }
        for (ShortMovie shortMovie : filmInformations.ShortMovies) {
            if (dataArray[1].equals(shortMovie.uniquieFilmId)) {
                StarterCheckPoint++;
            }
        }
        for (Documentary documentary : filmInformations.Documentaries) {
            if (dataArray[1].equals(documentary.uniquieFilmId)) {
                StarterCheckPoint++;
            }
        }
        for (TVSeries tvSeries : filmInformations.TVSeriesCount) {
            if (dataArray[1].equals(tvSeries.uniquieFilmId)) {
                StarterCheckPoint++;
            }
        }
        if (StarterCheckPoint == 0) {
            output += data + "\n\n";
            output += "Command failed \n";
            output += "Film ID: " + dataArray[1];
            output += "\n\n";
            output += "-----------------------------------------------------------------------------------------------------\n";
        }
        for (FeatureFilms featureFilms : filmInformations.FeatureFilmsCount) {
            if (dataArray[1].equals(featureFilms.uniquieFilmId)) {
                checkPointFeatureFilm++;
                featureFilms1 = featureFilms;
            }
        }
        for (ShortMovie shortMovie : filmInformations.ShortMovies) {
            if (dataArray[1].equals(shortMovie.uniquieFilmId)) {
                checkPointShortFilm++;
                shortMovie1 = shortMovie;
            }
        }
        int checkPointDocumentary = 0;
        Documentary documentary1 = new Documentary("", "", "", "", "", "", "", "");
        for (Documentary documentary : filmInformations.Documentaries) {
            if (dataArray[1].equals(documentary.uniquieFilmId)) {
                checkPointDocumentary++;
                documentary1 = documentary;
            }
        }
        int checkPointTvSeries = 0;
        TVSeries tvSeries1 = new TVSeries("", "", "", "", "",
                "", "", "", "", "", "", "", "");
        for (TVSeries tvSeries : filmInformations.TVSeriesCount) {
            if (dataArray[1].equals(tvSeries.uniquieFilmId)) {
                checkPointTvSeries++;
                tvSeries1 = tvSeries;
            }
        }
        if (checkPointShortFilm == 1) {
            output += data + "\n\n";
            output += shortMovie1.filmTitle + " (" + shortMovie1.releaseDate.substring(shortMovie1.releaseDate.length() - 4, shortMovie1.releaseDate.length()) + ")\n";
            ArrayList<String> myGenreArray = new ArrayList<String>();
            if (shortMovie1.genre.contains(",")) {
                String[] myInnerArray = shortMovie1.genre.split(",");
                for (String j : myInnerArray) {
                    myGenreArray.add(j);
                }
            } else {
                myGenreArray.add(shortMovie1.genre);
            }
            int myIndex4 = 0;
            int mySize4 = myGenreArray.size();
            for (String k : myGenreArray) {
                if (myIndex4 < mySize4 - 1) {
                    output += k + ", ";
                    myIndex4++;
                } else {
                    output += k + "\n";
                }
            }
            ArrayList<String> myWriterArray = new ArrayList<String>();
            if (shortMovie1.writers.contains(",")) {
                String[] myInnerArray = shortMovie1.writers.split(",");
                for (String j : myInnerArray) {
                    myWriterArray.add(j);
                }
            } else {
                myWriterArray.add(shortMovie1.writers);
            }
            ArrayList<String> myDirectorArray = new ArrayList<String>();
            if (shortMovie1.directors.contains(",")) {
                String[] myInnerArray = shortMovie1.directors.split(",");
                for (String j : myInnerArray) {
                    myDirectorArray.add(j);
                }
            } else {
                myDirectorArray.add(shortMovie1.directors);
            }
            ArrayList<String> myCastArray = new ArrayList<String>();
            if (shortMovie1.cast.contains(",")) {
                String[] myInnerArray = shortMovie1.cast.split(",");
                for (String j : myInnerArray) {
                    myCastArray.add(j);
                }
            } else {
                myCastArray.add(shortMovie1.cast);
            }
            output += "Writers:";
            int myIndex = 0;
            int mySize1 = myWriterArray.size();
            for (String k : myWriterArray) {
                if (myIndex < mySize1 - 1) {
                    for (Writer writer : peopleInformations.Writers) {
                        if (writer.uniqueId.equals(k)) {
                            output += " " + writer.name + " " + writer.surname + ",";
                            myIndex++;
                        }
                    }
                }
            }
            for (Writer writer : peopleInformations.Writers) {
                if (writer.uniqueId.equals(myWriterArray.get(mySize1 - 1))) {
                    output += " " + writer.name + " " + writer.surname + "\n";
                }
            }
            output += "Directors: ";
            int myIndex1 = 0;
            int mySize2 = myDirectorArray.size();
            for (String k : myDirectorArray) {
                if (myIndex1 < mySize2 - 1) {
                    for (Director director : peopleInformations.Directors) {
                        if (director.uniqueId.equals(k)) {
                            output += " " + director.name + " " + director.surname + ",";
                            myIndex1++;
                        }
                    }
                }
            }
            for (Director director : peopleInformations.Directors) {
                if (director.uniqueId.equals(myDirectorArray.get(mySize2 - 1))) {
                    output += " " + director.name + " " + director.surname + "\n";
                }
            }
            output += "Stars: ";
            int myIndex3 = 0;
            int mySize3 = myCastArray.size();
            for (String k : myCastArray) {
                if (myIndex3 < mySize3 - 1) {
                    for (ChildPerformer childPerformer : peopleInformations.ChildPerformer) {
                        if (childPerformer.uniqueId.equals(k)) {
                            output += " " + childPerformer.name + " " + childPerformer.surname + ",";
                            myIndex3++;
                        }
                    }
                    for (Actor actor : peopleInformations.Actors) {
                        if (actor.uniqueId.equals(k)) {
                            output += " " + actor.name + " " + actor.surname + ",";
                            myIndex3++;
                        }
                    }
                    for (StuntPerformer studentPerformer : peopleInformations.StuntPerformers) {
                        if (studentPerformer.uniqueId.equals(k)) {
                            output += " " + studentPerformer.name + " " + studentPerformer.surname + ",";
                            myIndex3++;
                        }
                    }

                } else {
                    for (ChildPerformer childPerformer : peopleInformations.ChildPerformer) {
                        if (childPerformer.uniqueId.equals(k)) {
                            output += " " + childPerformer.name + " " + childPerformer.surname + "\n";
                            myIndex3++;
                        }
                    }
                    for (Actor actor : peopleInformations.Actors) {
                        if (actor.uniqueId.equals(k)) {
                            output += " " + actor.name + " " + actor.surname + "\n";
                            myIndex3++;
                        }
                    }
                    for (StuntPerformer studentPerformer : peopleInformations.StuntPerformers) {
                        if (studentPerformer.uniqueId.equals(k)) {
                            output += " " + studentPerformer.name + " " + studentPerformer.surname + "\n";
                            myIndex3++;
                        }
                    }
                }
            }
            if (shortMovie1.ratingSquare != 0) {
                double ratingValue = shortMovie1.ratingSquare / shortMovie1.ratingCount;
                String ratingStringValue = Double.toString(ratingValue);
                if (ratingStringValue.charAt(2) == '0') {
                    ratingStringValue = ratingStringValue.substring(0, 1);
                } else if (ratingStringValue.charAt(1) == '0') {
                    ratingStringValue = ratingStringValue.substring(0, 2);
                } else {
                    ratingStringValue = ratingStringValue.substring(0, 1) + "," + ratingStringValue.substring(2, 3);
                }
                output += "RATINGS: " + ratingStringValue + "/10 from " + shortMovie1.ratingCount + " users" + "\n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";
            } else {
                output += "Awaiting for votes \n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";
            }

        }
        if (checkPointFeatureFilm == 1) {
            output += data + "\n\n";
            output += featureFilms1.filmTitle + " (" + featureFilms1.releaseDate.substring(featureFilms1.releaseDate.length() - 4, featureFilms1.releaseDate.length()) + ")\n";
            ArrayList<String> myGenreArray = new ArrayList<String>();
            if (featureFilms1.genre.contains(",")) {
                String[] myInnerArray = featureFilms1.genre.split(",");
                for (String j : myInnerArray) {
                    myGenreArray.add(j);
                }
            } else {
                myGenreArray.add(featureFilms1.genre);
            }
            int myIndex4 = 0;
            int mySize4 = myGenreArray.size();
            for (String k : myGenreArray) {
                if (myIndex4 < mySize4 - 1) {
                    output += k + ", ";
                    myIndex4++;
                } else {
                    output += k + "\n";
                }
            }
            ArrayList<String> myWriterArray = new ArrayList<String>();
            if (featureFilms1.writers.contains(",")) {
                String[] myInnerArray = featureFilms1.writers.split(",");
                for (String j : myInnerArray) {
                    myWriterArray.add(j);
                }
            } else {
                myWriterArray.add(featureFilms1.writers);
            }
            ArrayList<String> myDirectorArray = new ArrayList<String>();
            if (featureFilms1.directors.contains(",")) {
                String[] myInnerArray = featureFilms1.directors.split(",");
                for (String j : myInnerArray) {
                    myDirectorArray.add(j);
                }
            } else {
                myDirectorArray.add(featureFilms1.directors);
            }
            ArrayList<String> myCastArray = new ArrayList<String>();
            if (featureFilms1.cast.contains(",")) {
                String[] myInnerArray = featureFilms1.cast.split(",");
                for (String j : myInnerArray) {
                    myCastArray.add(j);
                }
            } else {
                myCastArray.add(featureFilms1.cast);
            }
            output += "Writers:";
            int myIndex = 0;
            int mySize1 = myWriterArray.size();
            for (String k : myWriterArray) {
                if (myIndex < mySize1 - 1) {
                    for (Writer writer : peopleInformations.Writers) {
                        if (writer.uniqueId.equals(k)) {
                            output += " " + writer.name + " " + writer.surname + ",";
                            myIndex++;
                        }
                    }
                }
            }
            for (Writer writer : peopleInformations.Writers) {
                if (writer.uniqueId.equals(myWriterArray.get(mySize1 - 1))) {
                    output += " " + writer.name + " " + writer.surname + "\n";
                }
            }
            output += "Directors: ";
            int myIndex1 = 0;
            int mySize2 = myDirectorArray.size();
            for (String k : myDirectorArray) {
                if (myIndex1 < mySize2 - 1) {
                    for (Director director : peopleInformations.Directors) {
                        if (director.uniqueId.equals(k)) {
                            output += " " + director.name + " " + director.surname + ",";
                            myIndex1++;
                        }
                    }
                }
            }
            for (Director director : peopleInformations.Directors) {
                if (director.uniqueId.equals(myDirectorArray.get(mySize2 - 1))) {
                    output += " " + director.name + " " + director.surname + "\n";
                }
            }
            output += "Stars: ";
            int myIndex3 = 0;
            int mySize3 = myCastArray.size();
            for (String k : myCastArray) {
                if (myIndex3 < mySize3 - 1) {
                    for (ChildPerformer childPerformer : peopleInformations.ChildPerformer) {
                        if (childPerformer.uniqueId.equals(k)) {
                            output += " " + childPerformer.name + " " + childPerformer.surname + ",";
                            myIndex3++;
                        }
                    }
                    for (Actor actor : peopleInformations.Actors) {
                        if (actor.uniqueId.equals(k)) {
                            output += " " + actor.name + " " + actor.surname + ",";
                            myIndex3++;
                        }
                    }
                    for (StuntPerformer studentPerformer : peopleInformations.StuntPerformers) {
                        if (studentPerformer.uniqueId.equals(k)) {
                            output += " " + studentPerformer.name + " " + studentPerformer.surname + ",";
                            myIndex3++;
                        }
                    }

                } else {
                    for (ChildPerformer childPerformer : peopleInformations.ChildPerformer) {
                        if (childPerformer.uniqueId.equals(k)) {
                            output += " " + childPerformer.name + " " + childPerformer.surname + "\n";
                            myIndex3++;
                        }
                    }
                    for (Actor actor : peopleInformations.Actors) {
                        if (actor.uniqueId.equals(k)) {
                            output += " " + actor.name + " " + actor.surname + "\n";
                            myIndex3++;
                        }
                    }
                    for (StuntPerformer studentPerformer : peopleInformations.StuntPerformers) {
                        if (studentPerformer.uniqueId.equals(k)) {
                            output += " " + studentPerformer.name + " " + studentPerformer.surname + "\n";
                            myIndex3++;
                        }
                    }
                }
            }
            if (featureFilms1.ratingCount != 0) {
                double ratingValue = featureFilms1.ratingSquare / featureFilms1.ratingCount;
                String ratingStringValue = Double.toString(ratingValue);
                if (ratingStringValue.charAt(2) == '0') {
                    ratingStringValue = ratingStringValue.substring(0, 1);
                } else if (ratingStringValue.charAt(1) == '0') {
                    ratingStringValue = ratingStringValue.substring(0, 2);
                } else {
                    ratingStringValue = ratingStringValue.substring(0, 1) + "," + ratingStringValue.substring(2, 3);
                }
                output += "RATINGS: " + ratingStringValue + "/10 from " + featureFilms1.ratingCount + " users" + "\n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";
            } else {
                output += "Awaiting for votes \n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";
            }

        }
        if (checkPointDocumentary == 1) {
            output += data + "\n\n";
            output += documentary1.filmTitle + " (" + documentary1.releaseDate.substring(documentary1.releaseDate.length() - 4, documentary1.releaseDate.length()) + ")\n";
            ArrayList<String> myDirectorArray = new ArrayList<String>();
            if (documentary1.directors.contains(",")) {
                String[] myInnerArray = documentary1.directors.split(",");
                for (String j : myInnerArray) {
                    myDirectorArray.add(j);
                }
            } else {
                myDirectorArray.add(featureFilms1.directors);
            }
            ArrayList<String> myCastArray = new ArrayList<String>();
            if (documentary1.cast.contains(",")) {
                String[] myInnerArray = documentary1.cast.split(",");
                for (String j : myInnerArray) {
                    myCastArray.add(j);
                }
            } else {
                myCastArray.add(featureFilms1.cast);
            }
            output += "Directors: ";
            int myIndex1 = 0;
            int mySize2 = myDirectorArray.size();
            for (String k : myDirectorArray) {
                if (myIndex1 < mySize2 - 1) {
                    for (Director director : peopleInformations.Directors) {
                        if (director.uniqueId.equals(k)) {
                            output += " " + director.name + " " + director.surname + ",";
                            myIndex1++;
                        }
                    }
                }
            }
            for (Director director : peopleInformations.Directors) {
                if (director.uniqueId.equals(myDirectorArray.get(mySize2 - 1))) {
                    output += " " + director.name + " " + director.surname + "\n";
                }
            }
            output += "Stars: ";
            int myIndex3 = 0;
            int mySize3 = myCastArray.size();
            for (String k : myCastArray) {
                if (myIndex3 < mySize3 - 1) {
                    for (ChildPerformer childPerformer : peopleInformations.ChildPerformer) {
                        if (childPerformer.uniqueId.equals(k)) {
                            output += " " + childPerformer.name + " " + childPerformer.surname + ",";
                            myIndex3++;
                        }
                    }
                    for (Actor actor : peopleInformations.Actors) {
                        if (actor.uniqueId.equals(k)) {
                            output += " " + actor.name + " " + actor.surname + ",";
                            myIndex3++;
                        }
                    }
                    for (StuntPerformer studentPerformer : peopleInformations.StuntPerformers) {
                        if (studentPerformer.uniqueId.equals(k)) {
                            output += " " + studentPerformer.name + " " + studentPerformer.surname + ",";
                            myIndex3++;
                        }
                    }

                } else {
                    for (ChildPerformer childPerformer : peopleInformations.ChildPerformer) {
                        if (childPerformer.uniqueId.equals(k)) {
                            output += " " + childPerformer.name + " " + childPerformer.surname + "\n";
                            myIndex3++;
                        }
                    }
                    for (Actor actor : peopleInformations.Actors) {
                        if (actor.uniqueId.equals(k)) {
                            output += " " + actor.name + " " + actor.surname + "\n";
                            myIndex3++;
                        }
                    }
                    for (StuntPerformer studentPerformer : peopleInformations.StuntPerformers) {
                        if (studentPerformer.uniqueId.equals(k)) {
                            output += " " + studentPerformer.name + " " + studentPerformer.surname + "\n";
                            myIndex3++;
                        }
                    }
                }
            }
            if (documentary1.ratingCount != 0) {
                double ratingValue = documentary1.ratingSquare / documentary1.ratingCount;
                String ratingStringValue = Double.toString(ratingValue);
                if (ratingStringValue.charAt(2) == '0') {
                    ratingStringValue = ratingStringValue.substring(0, 1);
                } else if (ratingStringValue.charAt(1) == '0') {
                    ratingStringValue = ratingStringValue.substring(0, 2);
                } else {
                    ratingStringValue = ratingStringValue.substring(0, 1) + "," + ratingStringValue.substring(2, 3);
                }
                output += "RATINGS: " + ratingStringValue + "/10 from " + documentary1.ratingCount + " users" + "\n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";
            } else {
                output += "Awaiting for votes \n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";
            }
        }
        if (checkPointTvSeries == 1) {
            output += data + "\n\n";
            output += tvSeries1.filmTitle + " (" + tvSeries1.startDate.substring(tvSeries1.startDate.length() - 4, tvSeries1.startDate.length()) +
                    "-" + tvSeries1.endDate.substring(tvSeries1.endDate.length() - 4, tvSeries1.endDate.length()) + ")\n";
            output += tvSeries1.seasons + " seasons" + " " + tvSeries1.episodes + " episodes\n";
            ArrayList<String> myGenreArray = new ArrayList<String>();
            if (tvSeries1.genre.contains(",")) {
                String[] myInnerArray = tvSeries1.genre.split(",");
                for (String j : myInnerArray) {
                    myGenreArray.add(j);
                }
            } else {
                myGenreArray.add(tvSeries1.genre);
            }
            int myIndex4 = 0;
            int mySize4 = myGenreArray.size();
            for (String k : myGenreArray) {
                if (myIndex4 < mySize4 - 1) {
                    output += k + ", ";
                    myIndex4++;
                } else {
                    output += k + "\n";
                }
            }
            ArrayList<String> myWriterArray = new ArrayList<String>();
            if (tvSeries1.writers.contains(",")) {
                String[] myInnerArray = tvSeries1.writers.split(",");
                for (String j : myInnerArray) {
                    myWriterArray.add(j);
                }
            } else {
                myWriterArray.add(tvSeries1.writers);
            }
            ArrayList<String> myDirectorArray = new ArrayList<String>();
            if (tvSeries1.directors.contains(",")) {
                String[] myInnerArray = tvSeries1.directors.split(",");
                for (String j : myInnerArray) {
                    myDirectorArray.add(j);
                }
            } else {
                myDirectorArray.add(tvSeries1.directors);
            }
            ArrayList<String> myCastArray = new ArrayList<String>();
            if (tvSeries1.cast.contains(",")) {
                String[] myInnerArray = tvSeries1.cast.split(",");
                for (String j : myInnerArray) {
                    myCastArray.add(j);
                }
            } else {
                myCastArray.add(tvSeries1.cast);
            }
            output += "Writers:";
            int myIndex = 0;
            int mySize1 = myWriterArray.size();
            for (String k : myWriterArray) {
                if (myIndex < mySize1 - 1) {
                    for (Writer writer : peopleInformations.Writers) {
                        if (writer.uniqueId.equals(k)) {
                            output += " " + writer.name + " " + writer.surname + ",";
                            myIndex++;
                        }
                    }
                }
            }
            for (Writer writer : peopleInformations.Writers) {
                if (writer.uniqueId.equals(myWriterArray.get(mySize1 - 1))) {
                    output += " " + writer.name + " " + writer.surname + "\n";
                }
            }
            output += "Directors: ";
            int myIndex1 = 0;
            int mySize2 = myDirectorArray.size();
            for (String k : myDirectorArray) {
                if (myIndex1 < mySize2 - 1) {
                    for (Director director : peopleInformations.Directors) {

                        if (director.uniqueId.equals(k)) {
                            output += " " + director.name + " " + director.surname + ",";
                            myIndex1++;
                        }
                    }
                }
            }
            for (Director director : peopleInformations.Directors) {
                if (director.uniqueId.equals(myDirectorArray.get(mySize2 - 1))) {
                    output += " " + director.name + " " + director.surname + "\n";
                }

            }
            output += "Stars: ";
            int myIndex3 = 0;
            int mySize3 = myCastArray.size();
            for (String k : myCastArray) {
                if (myIndex3 < mySize3 - 1) {
                    for (ChildPerformer childPerformer : peopleInformations.ChildPerformer) {
                        if (childPerformer.uniqueId.equals(k)) {
                            output += " " + childPerformer.name + " " + childPerformer.surname + ",";
                            myIndex3++;
                        }
                    }
                    for (Actor actor : peopleInformations.Actors) {
                        if (actor.uniqueId.equals(k)) {
                            output += " " + actor.name + " " + actor.surname + ",";
                            myIndex3++;
                        }
                    }
                    for (StuntPerformer studentPerformer : peopleInformations.StuntPerformers) {
                        if (studentPerformer.uniqueId.equals(k)) {
                            output += " " + studentPerformer.name + " " + studentPerformer.surname + ",";
                            myIndex3++;
                        }
                    }

                } else {
                    for (ChildPerformer childPerformer : peopleInformations.ChildPerformer) {
                        if (childPerformer.uniqueId.equals(k)) {
                            output += " " + childPerformer.name + " " + childPerformer.surname + "\n";
                            myIndex3++;
                        }
                    }
                    for (Actor actor : peopleInformations.Actors) {
                        if (actor.uniqueId.equals(k)) {
                            output += " " + actor.name + " " + actor.surname + "\n";
                            myIndex3++;
                        }
                    }
                    for (StuntPerformer studentPerformer : peopleInformations.StuntPerformers) {
                        if (studentPerformer.uniqueId.equals(k)) {
                            output += " " + studentPerformer.name + " " + studentPerformer.surname + "\n";
                            myIndex3++;
                        }
                    }
                }
            }
            if (tvSeries1.ratingCount != 0) {
                double ratingValue = tvSeries1.ratingSquare / tvSeries1.ratingCount;
                String ratingStringValue = Double.toString(ratingValue);
                if (ratingStringValue.charAt(2) == '0') {
                    ratingStringValue = ratingStringValue.substring(0, 1);
                } else if (ratingStringValue.charAt(1) == '0') {
                    ratingStringValue = ratingStringValue.substring(0, 2);
                } else {
                    ratingStringValue = ratingStringValue.substring(0, 1) + "," + ratingStringValue.substring(2, 3);
                }
                output += "RATINGS: " + ratingStringValue + "/10 from " + tvSeries1.ratingCount + " users" + "\n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";
            } else {
                output += "Awaiting for votes \n\n";
                output += "-----------------------------------------------------------------------------------------------------\n";
            }

        }


        return output;
    }

    public String ListRatedMovies(Film filmInformations, ArrayList<String> filmFile) {
        String output = "";
        output += "FeatureFilms: \n";
        if (filmInformations.FeatureFilmsCount.size() == 0) {
            output += "No result \n";
        } else {
            double myPoint = 0;
            ArrayList<Double> AllPoints = new ArrayList<Double>();
            for (FeatureFilms featureFilms : filmInformations.FeatureFilmsCount) {
                if (featureFilms.ratingCount != 0) {
                    myPoint = featureFilms.ratingSquare / featureFilms.ratingCount;
                    int check = 0;
                    for (double number : AllPoints) {
                        if (number == myPoint) {
                            check++;

                        }
                    }
                    if (check == 0) {
                        AllPoints.add(myPoint);
                    }
                }
            }
            AllPoints.add(0.0);
            Collections.sort(AllPoints, Collections.reverseOrder());

            for (double h : AllPoints) {
                for (FeatureFilms featureFilms : filmInformations.FeatureFilmsCount) {
                    double myPoint2 = featureFilms.ratingSquare / featureFilms.ratingCount;
                    if (h == myPoint2) {
                        String myRating = Double.toString(h);
                        String newRating = "";
                        if (myRating.charAt(1) == '.' & myRating.charAt(2) == '0') {
                            newRating = myRating.substring(0, 1);

                        }
                        if (myRating.charAt(1) == '.' & myRating.charAt(2) != '0') {
                            newRating = myRating.substring(0, 1) + "," + myRating.substring(2, 3);
                        }
                        if (myRating.charAt(1) == '0') {
                            newRating = "10";
                        }
                        myRating = newRating;

                        output += featureFilms.filmTitle + " (" + featureFilms.releaseDate.substring(featureFilms.releaseDate.length() - 4, featureFilms.releaseDate.length())
                                + ") Ratings: " + myRating + "/10 from " + featureFilms.ratingCount + " users \n";
                    }

                }


            }
            for (FeatureFilms featureFilms : filmInformations.FeatureFilmsCount) {
                if (featureFilms.ratingCount == 0) {
                    output += featureFilms.filmTitle + " (" + featureFilms.releaseDate.substring(featureFilms.releaseDate.length() - 4, featureFilms.releaseDate.length())
                            + ") Ratings: " + "0" + "/10 from " + featureFilms.ratingCount + " users \n";
                }
            }
        }
        output += "\nShortFilms: \n";
        if (filmInformations.ShortMovies.size() == 0) {
            output += "No result \n";
        } else {
            double myPoint = 0;
            ArrayList<Double> AllPoints = new ArrayList<Double>();
            for (ShortMovie featureFilms : filmInformations.ShortMovies) {
                if (featureFilms.ratingCount != 0) {
                    myPoint = featureFilms.ratingSquare / featureFilms.ratingCount;
                    int check = 0;
                    for (double number : AllPoints) {
                        if (number == myPoint) {
                            check++;

                        }
                    }
                    if (check == 0) {
                        AllPoints.add(myPoint);
                    }
                }
            }
            AllPoints.add(0.0);
            Collections.sort(AllPoints, Collections.reverseOrder());
            for (double h : AllPoints) {
                for (ShortMovie featureFilms : filmInformations.ShortMovies) {
                    double myPoint2 = featureFilms.ratingSquare / featureFilms.ratingCount;
                    if (h == myPoint2) {
                        String myRating = Double.toString(h);
                        String newRating = "";
                        if (myRating.charAt(1) == '.' & myRating.charAt(2) == '0') {
                            newRating = myRating.substring(0, 1);

                        }
                        if (myRating.charAt(1) == '.' & myRating.charAt(2) != '0') {
                            newRating = myRating.substring(0, 1) + "," + myRating.substring(2, 3);
                        }
                        if (myRating.charAt(1) == '0') {
                            newRating = "10";
                        }
                        myRating = newRating;

                        output += featureFilms.filmTitle + " (" + featureFilms.releaseDate.substring(featureFilms.releaseDate.length() - 4, featureFilms.releaseDate.length())
                                + ") Ratings: " + myRating + "/10 from " + featureFilms.ratingCount + " users \n";
                    }
                }
            }
            for (ShortMovie featureFilms : filmInformations.ShortMovies) {
                if (featureFilms.ratingCount == 0) {
                    output += featureFilms.filmTitle + " (" + featureFilms.releaseDate.substring(featureFilms.releaseDate.length() - 4, featureFilms.releaseDate.length())
                            + ") Ratings: " + "0" + "/10 from " + featureFilms.ratingCount + " users \n";
                }
            }
        }
        output += "\nDocumentary: \n";
        if (filmInformations.Documentaries.size() == 0) {
            output += "No result \n";
        } else {
            double myPoint = 0;
            ArrayList<Double> AllPoints = new ArrayList<Double>();
            for (Documentary featureFilms : filmInformations.Documentaries) {
                if (featureFilms.ratingCount != 0) {
                    myPoint = featureFilms.ratingSquare / featureFilms.ratingCount;
                    int check = 0;
                    for (double number : AllPoints) {
                        if (number == myPoint) {
                            check++;

                        }
                    }
                    if (check == 0) {
                        AllPoints.add(myPoint);
                    }
                }
            }
            AllPoints.add(0.0);
            Collections.sort(AllPoints, Collections.reverseOrder());
            for (double h : AllPoints) {
                for (Documentary featureFilms : filmInformations.Documentaries) {
                    double myPoint2 = featureFilms.ratingSquare / featureFilms.ratingCount;
                    if (h == myPoint2) {
                        String myRating = Double.toString(h);
                        String newRating = "";
                        if (myRating.charAt(1) == '.' & myRating.charAt(2) == '0') {
                            newRating = myRating.substring(0, 1);

                        }
                        if (myRating.charAt(1) == '.' & myRating.charAt(2) != '0') {
                            newRating = myRating.substring(0, 1) + "," + myRating.substring(2, 3);
                        }
                        if (myRating.charAt(1) == '0') {
                            newRating = "10";
                        }
                        myRating = newRating;


                        output += featureFilms.filmTitle + " (" + featureFilms.releaseDate.substring(featureFilms.releaseDate.length() - 4, featureFilms.releaseDate.length())
                                + ") Ratings: " + myRating + "/10 from " + featureFilms.ratingCount + " users \n";
                    }
                }
            }
            for (Documentary featureFilms : filmInformations.Documentaries) {
                if (featureFilms.ratingCount == 0) {
                    output += featureFilms.filmTitle + " (" + featureFilms.releaseDate.substring(featureFilms.releaseDate.length() - 4, featureFilms.releaseDate.length())
                            + ") Ratings: " + "0" + "/10 from " + featureFilms.ratingCount + " users \n";
                }
            }
        }
        output += "\nTVSeries: \n";
        if (filmInformations.TVSeriesCount.size() == 0) {
            output += "No result \n";
        } else {
            double myPoint = 0;
            ArrayList<Double> AllPoints = new ArrayList<Double>();
            for (TVSeries featureFilms : filmInformations.TVSeriesCount) {
                if (featureFilms.ratingCount != 0) {
                    myPoint = featureFilms.ratingSquare / featureFilms.ratingCount;
                    int check = 0;
                    for (double number : AllPoints) {
                        if (number == myPoint) {
                            check++;

                        }
                    }
                    if (check == 0) {
                        AllPoints.add(myPoint);
                    }
                }
            }
            AllPoints.add(0.0);
            Collections.sort(AllPoints, Collections.reverseOrder());
            for (double h : AllPoints) {
                for (TVSeries featureFilms : filmInformations.TVSeriesCount) {
                    double myPoint2 = featureFilms.ratingSquare / featureFilms.ratingCount;
                    if (h == myPoint2) {
                        String myRating = Double.toString(h);
                        String newRating = "";
                        if (myRating.charAt(1) == '.' & myRating.charAt(2) == '0') {
                            newRating = myRating.substring(0, 1);

                        }
                        if (myRating.charAt(1) == '.' & myRating.charAt(2) != '0') {
                            newRating = myRating.substring(0, 1) + "," + myRating.substring(2, 3);
                        }
                        if (myRating.charAt(1) == '0') {
                            newRating = "10";
                        }
                        myRating = newRating;

                        output += featureFilms.filmTitle + " (" + featureFilms.startDate.substring(featureFilms.startDate.length() - 4, featureFilms.startDate.length())
                                + "-" + featureFilms.endDate.substring(featureFilms.endDate.length() - 4, featureFilms.endDate.length())
                                + ") Ratings: " + myRating + "/10 from " + featureFilms.ratingCount + " users \n";
                    }
                }
            }
            for (TVSeries featureFilms : filmInformations.TVSeriesCount) {
                if (featureFilms.ratingCount == 0) {
                    output += featureFilms.filmTitle + " (" + featureFilms.startDate.substring(featureFilms.startDate.length() - 4, featureFilms.startDate.length())
                            + "-" + featureFilms.endDate.substring(featureFilms.endDate.length() - 4, featureFilms.endDate.length())
                            + ") Ratings: " + "0" + "/10 from " + featureFilms.ratingCount + " users \n";
                }
            }
        }
        output += "\n-----------------------------------------------------------------------------------------------------\n";

        return output;
    }


}
