public class Documentary extends  Film{
    String releaseDate;
    Documentary(String uniquieFilmId, String filmTitle, String filmLanguage , String directors, String runtime, String country, String cast, String releaseDate){
        super(uniquieFilmId, filmTitle,filmLanguage ,directors, runtime,country,cast);
        this.releaseDate = releaseDate;
    }
}
