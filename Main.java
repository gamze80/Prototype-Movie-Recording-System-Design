import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) throws IOException {
        String peopleTxt = args[0];
        String filmsTxt = args[1];
        String commandTxt = args[2];
        String outputTxt = args[3];
        ArrayList<String> peopleFile = new ArrayList<String>();
        People peopleInformations = new People("", "", "", "");
        try {
            File myObj = new File(peopleTxt);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                peopleFile.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //Storing informations from peopleFile
        for (String data : peopleFile) {
            if (data.charAt(0) == 'D') {
                String[] dataArray = data.split("\t");
                if (dataArray.length == 6) {
                    Director director = new Director(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);
                    peopleInformations.DirectorAdding(director);
                }
            }
            if (data.charAt(0) == 'W') {
                String[] dataArray = data.split("\t");
                if (dataArray.length == 6) {
                    Writer writer = new Writer(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);
                    peopleInformations.WritterAdding(writer);
                }
            }
            if (data.charAt(0) == 'A') {
                String[] dataArray = data.split("\t");
                if (dataArray.length == 6) {
                    Actor actor = new Actor(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);
                    peopleInformations.ActorAdding(actor);
                }
            }
            if (data.charAt(0) == 'C') {
                String[] dataArray = data.split("\t");
                if (dataArray.length == 6) {
                    ChildPerformer childPerformer = new ChildPerformer(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);
                    peopleInformations.ChildPerformerAdding(childPerformer);
                }
            }
            if (data.charAt(0) == 'S') {
                String[] dataArray = data.split("\t");
                if (dataArray.length == 7) {
                    StuntPerformer studentPerformer = new StuntPerformer(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5], dataArray[6]);
                    peopleInformations.StuntPerformersAdding(studentPerformer);
                }
            }
            if (data.charAt(0) == 'U') {
                String[] dataArray = data.split("\t");
                if (dataArray.length == 5) {
                    User user = new User(dataArray[1], dataArray[2], dataArray[3], dataArray[4]);
                    peopleInformations.UserAdding(user);
                }
            }
        }
        ArrayList<String> filmFile = new ArrayList<String>();
        Film filmInformations = new Film("", "", "", "", "", "", "");
        try {
            File myObj = new File(filmsTxt);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                filmFile.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //Storing information from filmFile
        for (String data : filmFile) {
            if (data.charAt(0) == 'F') {
                String[] dataArray = data.split("\t");
                FeatureFilms featureFilms = new FeatureFilms(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5], dataArray[6], dataArray[7], dataArray[8], dataArray[9], dataArray[10], dataArray[11]);
                filmInformations.FeatureFilmsAdding(featureFilms);
            }
            if (data.charAt(0) == 'S') {
                String[] dataArray = data.split("\t");
                ShortMovie shortMovie = new ShortMovie(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5], dataArray[6], dataArray[7], dataArray[8], dataArray[9], dataArray[10]);
                if(Integer. parseInt(shortMovie.runtime) <41){
                    filmInformations.ShortMovieAdding(shortMovie);
                }
                else{
                    System.out.println("Shortfilm runtime bigger than 40 min");
                }

            }
            if (data.charAt(0) == 'D') {
                String[] dataArray = data.split("\t");
                Documentary documentary = new Documentary(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5], dataArray[6], dataArray[7], dataArray[8]);
                filmInformations.DocumentaryAdding(documentary);
            }
            if (data.charAt(0) == 'T') {
                String[] dataArray = data.split("\t");
                TVSeries tvSeries = new TVSeries(dataArray[1], dataArray[2], dataArray[3], dataArray[4],
                        dataArray[5], dataArray[6], dataArray[7], dataArray[8], dataArray[9], dataArray[10],
                        dataArray[11], dataArray[12], dataArray[13]);
                filmInformations.TvSerieAdding(tvSeries);
            }
        }
        ArrayList<String> commandFile = new ArrayList<String>();
        String output = "";
        try {
            File myObj = new File(commandTxt);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                commandFile.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (String data : commandFile) {
            //RATE FILM COMMAND CODE BLOCK
            if (data.substring(0, 2).equals("RA")) {
                String[] dataArray = data.split("\t");
                String UserId = dataArray[1];
                String FilmId = dataArray[2];
                int RatingPoint = Integer.parseInt(dataArray[3]);
                int checkPoint = 0;
                for (User user : peopleInformations.Users) {
                    if (user.uniqueId.equals(UserId)) {
                        checkPoint++;
                    }
                }
                if (checkPoint == 0) {
                    output += data + "\n\n";
                    output += "Command failed \n" + "User ID: " + UserId + "\n" + "Film ID: " + FilmId + "\n";
                    output += "\n";
                    output += "-----------------------------------------------------------------------------------------------------\n";
                } else {
                    for (User user : peopleInformations.Users) {
                        if (user.uniqueId.equals(UserId)) {
                            if(RatingPoint <11 & RatingPoint >=0){
                            String a = user.UserRating(filmInformations, FilmId, RatingPoint);
                            if (a.equals("No")) {
                                output += data + "\n\n";
                                output += "This film was earlier rated\n";
                                output += "\n";
                                output += "-----------------------------------------------------------------------------------------------------\n";
                            } else {
                                output += data + "\n\n";
                                output += "Film rated succesfully\n";
                                output += a;
                                output += "\n";
                                output += "-----------------------------------------------------------------------------------------------------\n";
                            }
                        }
                            else{
                                System.out.println("Rating Score must be between 1 and 10 integers");
                            }
                    }


                }}
            }
            //ADD FEATUREFILM COMMAND BLOCK
            if (data.substring(0, 2).equals("AD")) {
                String[] dataArray = data.split("\t");
                FeatureFilms featureFilms = new FeatureFilms(dataArray[2], dataArray[3], dataArray[4], dataArray[5], dataArray[6],
                        dataArray[7], dataArray[8], dataArray[9], dataArray[10], dataArray[11], dataArray[12]);
                String myWriters = dataArray[11];
                String myID = dataArray[2];
                String performers = dataArray[8];
                String director = dataArray[5];
                ArrayList<String> ourPerformers = new ArrayList<String>();
                int writerCheckPoint = 0;
                if (myWriters.contains(",")) {
                    String[] myWritersArray = myWriters.split(",");
                    for (String h : myWritersArray) {
                        ourPerformers.add(h);
                    }
                    writerCheckPoint++;
                } else {
                    ourPerformers.add(myWriters);
                }
                int directorCheckPoint = 0;
                if (director.contains(",")) {
                    String[] myDirectorsArray = director.split(",");
                    for (String h : myDirectorsArray) {
                        ourPerformers.add(h);
                        directorCheckPoint++;
                    }
                } else {
                    ourPerformers.add(director);

                }
                int performersCheckPoint = 0;
                if (performers.contains(",")) {
                    String[] myPerformersArray = performers.split(",");
                    for (String h : myPerformersArray) {
                        ourPerformers.add(h);
                        performersCheckPoint++;
                    }
                } else {
                    ourPerformers.add(performers);
                }
                output += featureFilms.AddFeatureFilmToList(filmInformations, peopleInformations, data, ourPerformers, myID, featureFilms);
            }
            if (data.substring(0, 2).equals("VI")) {
                Film film = new Film("", "", "", "", "", "", "");
                output += film.ViewingFilm(data, filmInformations, peopleInformations);
            }
            //LIST USER COMMAND BLOCK
            if (data.substring(0, 9).equals("LIST\tUSER")) {
                String[] dataArray = data.split("\t");
                String UserID = dataArray[2];
                User user = new User("", "", "", "");
                int ifUserExcistsCheckPoint = 0;
                for (User user1 : peopleInformations.Users) {
                    if (user1.uniqueId.equals(UserID)) {
                        ifUserExcistsCheckPoint++;
                        user = user1;
                    }
                }
                if (ifUserExcistsCheckPoint != 0) {
                    output += user.ListingRatedFilms(user.getRatingList(), filmInformations, data);
                } else {
                    output += data + "\n\n";
                    output += "Command Failed\n";
                    output += "User ID: " + UserID + "\n\n";
                    output += "-----------------------------------------------------------------------------------------------------\n";
                }
            }
            //EDIT RATE COMMAND CODE BLOCK
            if (data.substring(0, 9).equals("EDIT\tRATE")) {
                User user = new User("", "", "", "");
                output += user.EditingRate(data, peopleInformations, filmInformations);
            }
            // REMOVE RATE CODE BLOCK
            if (data.substring(0, 6).equals("REMOVE")) {
                String[] dataArray = data.split("\t");
                User user = new User("", "", "", "");
                ShortMovie shortMovie = new ShortMovie("", "", "",
                        "", "", "", "", "", "", "");
                FeatureFilms featureFilms = new FeatureFilms("", "", "",
                        "", "", "", "", "", "", "", "");
                Documentary documentary = new Documentary("", "", "",
                        "", "", "", "", "");
                TVSeries tvSeries = new TVSeries("", "", "",
                        "", "", "", "", "", "", "", "", "", "");
                String UserID = dataArray[2];
                String filmID = dataArray[3];
                int ifUserExcistsCheckPoint = 0;
                int ifFilmExcistsCheckPoint = 0;

                for (User user1 : peopleInformations.Users) {
                    if (user1.uniqueId.equals(UserID)) {
                        ifUserExcistsCheckPoint++;
                        user = user1;
                    }
                }
                int ifNeverRated = 0;
                for (String h : user.getRatingList()) {
                    String[] ArrayOfError = h.split("/");
                    if (filmID.equals(ArrayOfError[0])) {
                        ifNeverRated++;
                    }
                }
                if (ifUserExcistsCheckPoint == 0) {
                } else if (ifNeverRated != 0) {
                    for (ShortMovie shortMovie1 : filmInformations.ShortMovies) {
                        if (shortMovie1.uniquieFilmId.equals(filmID)) {
                            ifFilmExcistsCheckPoint++;
                            output += user.RemovingScore(data, shortMovie1, user);

                        }
                    }
                    for (FeatureFilms featureFilms1 : filmInformations.FeatureFilmsCount) {
                        if (featureFilms1.uniquieFilmId.equals(filmID)) {
                            ifFilmExcistsCheckPoint++;
                            output += user.RemovingScore(data, featureFilms1, user);
                        }
                    }
                    for (Documentary documentary1 : filmInformations.Documentaries) {
                        if (documentary1.uniquieFilmId.equals(filmID)) {
                            ifFilmExcistsCheckPoint++;
                            output += user.RemovingScore(data, documentary1, user);
                        }
                    }
                    for (TVSeries tvSeries1 : filmInformations.TVSeriesCount) {
                        if (tvSeries1.uniquieFilmId.equals(filmID)) {
                            ifFilmExcistsCheckPoint++;
                            output += user.RemovingScore(data, tvSeries1, user);
                        }
                    }
                }
                if (ifFilmExcistsCheckPoint == 0 | ifUserExcistsCheckPoint == 0 | ifNeverRated == 0) {
                    output += data + "\n\n";
                    output += "Command Failed\n";
                    output += "User ID: " + UserID + "\n";
                    output += "Film ID: " + filmID + "\n\n";
                    output += "-----------------------------------------------------------------------------------------------------\n";
                }

            }
            //LIST SERIES COMMAND CODE BLOCK
            if (data.substring(0, 4).equals("LIST") & data.substring(data.length() - 6, data.length()).equals("SERIES")) {
                output += data + "\n\n";
                if (filmInformations.TVSeriesCount.size() == 0) {
                    output += "No result \n\n";
                    output += "-----------------------------------------------------------------------------------------------------\n";
                } else {
                    for (TVSeries tvSeries : filmInformations.TVSeriesCount) {
                        output += tvSeries.filmTitle + " (" + tvSeries.startDate.substring(tvSeries.startDate.length() - 4, tvSeries.startDate.length()) +
                                "-" + tvSeries.endDate.substring(tvSeries.endDate.length() - 4, tvSeries.endDate.length()) + ")\n";
                        output += tvSeries.seasons + " seasons and " + tvSeries.episodes + " episodes\n\n";
                    }
                    output += "-----------------------------------------------------------------------------------------------------\n";
                }

            }
            //LIST FILMS BY COUNTRY COMMAND BLOCK
            if (data.length() > 23) {
                if (data.substring(0, 21).equals("LIST\tFILMS\tBY\tCOUNTRY")) {
                    String[] dataArray = data.split("\t");
                    String CountryName = dataArray[4];
                    int FilmExistsCheckPoint = 0;
                    output += data + "\n\n";
                    for (String h : filmFile) {
                        String[] innerList = h.split("\t");
                        if (innerList[6].equals(CountryName)) {
                            String myFilmID = innerList[1];
                            for (ShortMovie shortMovie : filmInformations.ShortMovies) {
                                if (shortMovie.uniquieFilmId.equals(myFilmID)) {
                                    output += "Film title: " + shortMovie.filmTitle + "\n";
                                    output += shortMovie.runtime + " min\n";
                                    output += "Language: " + shortMovie.filmLanguage + "\n";
                                    output += "\n";
                                    FilmExistsCheckPoint++;
                                }
                            }
                            for (FeatureFilms shortMovie : filmInformations.FeatureFilmsCount) {
                                if (shortMovie.uniquieFilmId.equals(myFilmID)) {
                                    output += "Film title: " + shortMovie.filmTitle + "\n";
                                    output += shortMovie.runtime + " min\n";
                                    output += "Language: " + shortMovie.filmLanguage + "\n";
                                    output += "\n";
                                    FilmExistsCheckPoint++;
                                }
                            }
                            for (Documentary shortMovie : filmInformations.Documentaries) {
                                if (shortMovie.uniquieFilmId.equals(myFilmID)) {
                                    output += "Film title: " + shortMovie.filmTitle + "\n";
                                    output += shortMovie.runtime + " min\n";
                                    output += "Language: " + shortMovie.filmLanguage + "\n";
                                    output += "\n";
                                    FilmExistsCheckPoint++;
                                }
                            }
                            for (TVSeries shortMovie : filmInformations.TVSeriesCount) {
                                if (shortMovie.uniquieFilmId.equals(myFilmID)) {
                                    output += "Film title: " + shortMovie.filmTitle + "\n";
                                    output += shortMovie.runtime + " min\n";
                                    output += "Language: " + shortMovie.filmLanguage + "\n";
                                    output += "\n";
                                    FilmExistsCheckPoint++;
                                }
                            }


                        }
                    }
                    for (FeatureFilms featureFilms : filmInformations.NewAddedFeatureFilmsArray) {
                        if (featureFilms.country.equals(CountryName)) {
                            output += "Film title: " + featureFilms.filmTitle + "\n";
                            output += featureFilms.runtime + " min\n";
                            output += "Language: " + featureFilms.filmLanguage + "\n";
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
                }

            }
            //LIST FEATUREFILMS BEFORE COMMAND CODE BLOCK
            if (data.length() > 25) {
                if (data.substring(0, 24).equals("LIST\tFEATUREFILMS\tBEFORE")) {
                    FeatureFilms featureFilms = new FeatureFilms("", "", "", "", "", "", "", "",
                            "", "", "");
                    output += featureFilms.ListFeatureFilmsBefore(data, filmInformations, filmFile);
                }
            }
            //LIST FEATUREFILMS AFTER COMMAND CODE BLOCK
            if (data.length() > 25) {
                if (data.substring(0, 23).equals("LIST\tFEATUREFILMS\tAFTER")) {
                    FeatureFilms featureFilms = new FeatureFilms("","","","","","","","",
                            "","","");
                    output += featureFilms.ListFeatureFilmsAfter(data, filmInformations, filmFile);

                }
            }
            //LIST FILMS BY RATE DEGREE
            if (data.length() > 24) {
                if (data.substring(0, 25).equals("LIST\tFILMS\tBY\tRATE\tDEGREE")) {
                    output += data + " \n\n";
                    Film film = new Film("", "", "", "", "", "", "");
                    output += film.ListRatedMovies(filmInformations, filmFile);
                }
            }
            //LIST ARTIST FROM COUNTRY CODE BLOCK
            if (data.length() > 17) {
                if (data.substring(0, 17).equals("LIST\tARTISTS\tFROM")) {
                    output += data + " \n\n";
                    Artist artist = new Artist("", "", "", "");
                    String[] dataArray = data.split("\t");
                    String country = dataArray[3];
                    output += artist.ArtistFromCountry(peopleInformations, peopleFile, country);
                }
            }
        }
        try {
            FileWriter myWriter = new FileWriter(outputTxt);
            myWriter.write(output);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}