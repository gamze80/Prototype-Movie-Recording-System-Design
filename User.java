import java.util.ArrayList;

public class User extends People {
    private  ArrayList<String> RatingList = new ArrayList<String>();

    User(String uniqueId, String name, String surname, String country) {
        super(name, surname, country, uniqueId);

    }

    public String UserRating(Film filmInformations, String filmId, double RatingPoint) {
        int checkPoint = 0;
        String output = "";
        if (getRatingList().size() != 0) {
            for (String k : getRatingList()) {
                String[] ratedData = k.split("/");
                if (ratedData[0].equals(filmId)) {
                    checkPoint += 1;
                }
            }
        }
        if (checkPoint == 0) {
            for (ShortMovie film : filmInformations.ShortMovies) {
                if (filmId.equals(film.uniquieFilmId)) {
                    film.ratingSquare += RatingPoint;
                    film.ratingCount += 1;
                    getRatingList().add(filmId + "/" + String.valueOf(RatingPoint));
                    output += "Film type: ShortMovie\n";
                    output += "Film title: " + film.filmTitle + "\n";
                }

            }
            for (FeatureFilms film : filmInformations.FeatureFilmsCount) {
                if (filmId.equals(film.uniquieFilmId)) {
                    film.ratingSquare += RatingPoint;
                    film.ratingCount += 1;
                    getRatingList().add(filmId + "/" + String.valueOf(RatingPoint));
                    output += "Film type: FeatureFilm\n";
                    output += "Film title: " + film.filmTitle + "\n";
                }

            }
            for (Documentary film : filmInformations.Documentaries) {
                if (filmId.equals(film.uniquieFilmId)) {
                    film.ratingSquare += RatingPoint;
                    film.ratingCount += 1;
                    getRatingList().add(filmId + "/" + String.valueOf(RatingPoint));
                    output += "Film type: Documentary\n";
                    output += "Film title: " + film.filmTitle + "\n";
                }

            }
            for (TVSeries film : filmInformations.TVSeriesCount) {
                if (filmId.equals(film.uniquieFilmId)) {
                    film.ratingSquare += RatingPoint;
                    film.ratingCount += 1;
                    getRatingList().add(filmId + "/" + String.valueOf(RatingPoint));
                    output += "Film type: TVSeries\n";
                    output += "Film title: " + film.filmTitle + "\n";
                }

            }
            return output;

        } else {
            return "No";

        }
    }
    public String ListingRatedFilms(ArrayList<String> RatingList, Film filmInformations, String data){
        String output = "";
        int Checkpoint = 0;
        output += data + "\n\n";
        if(RatingList.size() >0){
        for(String h: RatingList){
            String[] ratingListArray = h.split("/");
            String myRate = "";
            if(ratingListArray[1].substring(0,2).equals("10")){
                myRate ="10";
            }
            else{
                myRate = ratingListArray[1].substring(0,1);
            }
            for(ShortMovie shortMovie : filmInformations.ShortMovies){
                if(shortMovie.uniquieFilmId.equals(ratingListArray[0])){
                    Checkpoint ++;
                    output += shortMovie.filmTitle+ ": " + myRate+ "\n";
                }
            }

            for(FeatureFilms featureFilms : filmInformations.FeatureFilmsCount){
                if(featureFilms.uniquieFilmId.equals(ratingListArray[0])){
                    Checkpoint ++;
                    output += featureFilms.filmTitle+ ": " + myRate + "\n";
                }
            }
            for(Documentary documentary : filmInformations.Documentaries){
                if(documentary.uniquieFilmId.equals(ratingListArray[0])){
                    Checkpoint ++;
                    output += documentary.filmTitle+ ": " + myRate + "\n";
                }
            }
            for(TVSeries tvSeries : filmInformations.TVSeriesCount){
                if(tvSeries.uniquieFilmId.equals(ratingListArray[0])){
                    Checkpoint ++;
                    output +=tvSeries.filmTitle+ ": " + myRate + "\n";
                }
            }
        }}
        else{
            output += "There is not any ratings so far\n";
        }
        output += "\n" +
                "-----------------------------------------------------------------------------------------------------\n";
        return  output;
    }
    public String NewRatingScore(String data, ShortMovie shortMovie,User user, String newRate){
        String output = "";
        output += data +"\n\n";
        output += "New ratings done successfully\n";
        output += "Film title: "+ shortMovie.filmTitle + "\n";
        output += "Your rating: " + newRate + "\n\n";
        output += "-----------------------------------------------------------------------------------------------------\n";
        ArrayList<String> UserRattings = new ArrayList<String>();
        double myOldRate = 0;
        for(String h : user.getRatingList()){
            String[] innerList = h.split("/");
            if(innerList[0].equals(shortMovie.uniquieFilmId)){
                UserRattings.add(innerList[0] + "/" + newRate);
                myOldRate = Double.parseDouble(innerList[1]);
            }
            else{
                UserRattings.add(h);
            }
        }
        user.setRatingList(UserRattings);
        shortMovie.ratingSquare = shortMovie.ratingSquare - myOldRate + Double.parseDouble(newRate);

        return output;
    }
    public String NewRatingScore(String data, FeatureFilms shortMovie,User user, String newRate){
        String output = "";
        output += data +"\n\n";
        output += "New ratings done successfully\n";
        output += "Film title: "+ shortMovie.filmTitle + "\n";
        output += "Your rating: " + newRate + "\n\n";
        output += "-----------------------------------------------------------------------------------------------------\n";
        ArrayList<String> UserRattings = new ArrayList<String>();
        double myOldRate = 0;
        for(String h : user.getRatingList()){
            String[] innerList = h.split("/");
            if(innerList[0].equals(shortMovie.uniquieFilmId)){
                UserRattings.add(innerList[0] + "/" + newRate);
                myOldRate = Double.parseDouble(innerList[1]);
            }
            else{
                UserRattings.add(h);
            }
        }
        user.setRatingList(UserRattings);
        shortMovie.ratingSquare = shortMovie.ratingSquare - myOldRate + Double.parseDouble(newRate);

        return output;
    }
    public String NewRatingScore(String data, Documentary shortMovie,User user, String newRate){
        String output = "";
        output += data +"\n\n";
        output += "New ratings done successfully\n";
        output += "Film title: "+ shortMovie.filmTitle + "\n";
        output += "Your rating: " + newRate + "\n\n";
        output += "-----------------------------------------------------------------------------------------------------\n";
        ArrayList<String> UserRattings = new ArrayList<String>();
        double myOldRate = 0;
        for(String h : user.getRatingList()){
            String[] innerList = h.split("/");
            if(innerList[0].equals(shortMovie.uniquieFilmId)){
                UserRattings.add(innerList[0] + "/" + newRate);
                myOldRate = Double.parseDouble(innerList[1]);
            }
            else{
                UserRattings.add(h);
            }
        }
        user.setRatingList(UserRattings);
        shortMovie.ratingSquare = shortMovie.ratingSquare - myOldRate + Double.parseDouble(newRate);

        return output;
    }
    public String NewRatingScore(String data, TVSeries shortMovie,User user, String newRate){
        String output = "";
        output += data +"\n\n";
        output += "New ratings done successfully\n";
        output += "Film title: "+ shortMovie.filmTitle + "\n";
        output += "Your rating: " + newRate + "\n\n";
        output += "-----------------------------------------------------------------------------------------------------\n";
        ArrayList<String> UserRattings = new ArrayList<String>();
        double myOldRate = 0;
        for(String h : user.getRatingList()){
            String[] innerList = h.split("/");
            if(innerList[0].equals(shortMovie.uniquieFilmId)){
                UserRattings.add(innerList[0] + "/" + newRate);
                myOldRate = Double.parseDouble(innerList[1]);
            }
            else{
                UserRattings.add(h);
            }
        }
        user.setRatingList(UserRattings);
        shortMovie.ratingSquare = shortMovie.ratingSquare - myOldRate + Double.parseDouble(newRate);

        return output;
    }
    public String RemovingScore(String data, ShortMovie shortMovie,User user){
        String output = "";
        output += data +"\n\n";
        output += "Your film rating was removed successfully\n";
        output += "Film title: "+ shortMovie.filmTitle + "\n\n";
        output += "-----------------------------------------------------------------------------------------------------\n";
        ArrayList<String> UserRattings = new ArrayList<String>();
        double myOldRate = 0;
        for(String h : user.getRatingList()){
            String[] innerList = h.split("/");
            if(innerList[0].equals(shortMovie.uniquieFilmId)){
                myOldRate = Double.parseDouble(innerList[1]);

            }
            else{
                UserRattings.add(h);
            }
        }
        user.setRatingList(UserRattings);
        shortMovie.ratingSquare = shortMovie.ratingSquare - myOldRate;
        shortMovie.ratingCount = shortMovie.ratingCount -1;

        return output;
    }
    public String RemovingScore(String data, FeatureFilms shortMovie,User user){
        String output = "";
        output += data +"\n\n";
        output += "Your film rating was removed successfully\n";
        output += "Film title: "+ shortMovie.filmTitle + "\n\n";
        output += "-----------------------------------------------------------------------------------------------------\n";
        ArrayList<String> UserRattings = new ArrayList<String>();
        double myOldRate = 0;
        for(String h : user.getRatingList()){
            String[] innerList = h.split("/");
            if(innerList[0].equals(shortMovie.uniquieFilmId)){
                myOldRate = Double.parseDouble(innerList[1]);
            }
            else{
                UserRattings.add(h);
            }
        }
        user.setRatingList(UserRattings);
        shortMovie.ratingSquare = shortMovie.ratingSquare - myOldRate;
        shortMovie.ratingCount = shortMovie.ratingCount -1;

        return output;
    }
    public String RemovingScore(String data, Documentary shortMovie,User user){
        String output = "";
        output += data +"\n\n";
        output += "Your film rating was removed successfully\n";
        output += "Film title: "+ shortMovie.filmTitle + "\n\n";
        output += "-----------------------------------------------------------------------------------------------------\n";
        ArrayList<String> UserRattings = new ArrayList<String>();
        double myOldRate = 0;
        for(String h : user.getRatingList()){
            String[] innerList = h.split("/");
            if(innerList[0].equals(shortMovie.uniquieFilmId)){
                myOldRate = Double.parseDouble(innerList[1]);
            }
            else{
                UserRattings.add(h);
            }
        }
        user.setRatingList(UserRattings);
        shortMovie.ratingSquare = shortMovie.ratingSquare - myOldRate;
        shortMovie.ratingCount = shortMovie.ratingCount -1;

        return output;
    }
    public String RemovingScore(String data,TVSeries shortMovie,User user){
        String output = "";
        output += data +"\n\n";
        output += "Your film rating was removed successfully\n";
        output += "Film title: "+ shortMovie.filmTitle + "\n\n";
        output += "-----------------------------------------------------------------------------------------------------\n";
        ArrayList<String> UserRattings = new ArrayList<String>();
        double myOldRate = 0;
        for(String h : user.getRatingList()){
            String[] innerList = h.split("/");
            if(innerList[0].equals(shortMovie.uniquieFilmId)){
                myOldRate = Double.parseDouble(innerList[1]);
            }
            else{
                UserRattings.add(h);
            }
        }
        user.setRatingList(UserRattings);
        shortMovie.ratingSquare = shortMovie.ratingSquare - myOldRate;
        shortMovie.ratingCount = shortMovie.ratingCount -1;

        return output;
    }
    public String  EditingRate(String data, People peopleInformations, Film filmInformations ){
        String output = "";
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
        String newRate = dataArray[4];
        String filmID = dataArray[3];
        if(Integer. parseInt(newRate) <11 &Integer. parseInt(newRate) >=0){
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
                    output += user.NewRatingScore(data, shortMovie1, user, newRate);

                }
            }
            for (FeatureFilms featureFilms1 : filmInformations.FeatureFilmsCount) {
                if (featureFilms1.uniquieFilmId.equals(filmID)) {
                    ifFilmExcistsCheckPoint++;
                    output += user.NewRatingScore(data, featureFilms1, user, newRate);
                }
            }
            for (Documentary documentary1 : filmInformations.Documentaries) {
                if (documentary1.uniquieFilmId.equals(filmID)) {
                    ifFilmExcistsCheckPoint++;
                    output += user.NewRatingScore(data, documentary1, user, newRate);
                }
            }
            for (TVSeries tvSeries1 : filmInformations.TVSeriesCount) {
                if (tvSeries1.uniquieFilmId.equals(filmID)) {
                    ifFilmExcistsCheckPoint++;
                    output += user.NewRatingScore(data, tvSeries1, user, newRate);
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
        return  output;
    }else{
            System.out.println("Rating Score must be between 1 and 10 integers");
            return "";
        }
    }


    public ArrayList<String> getRatingList() {
        return RatingList;
    }

    public void setRatingList(ArrayList<String> ratingList) {
        RatingList = ratingList;
    }
}

