public class ShortMovie extends Film{
    String releaseDate;
    String writers;
    String genre;
    ShortMovie(String uniquieFilmId, String filmTitle, String filmLanguage , String directors, String runtime, String country, String cast, String genre,String releaseDate, String writers){
        super(uniquieFilmId, filmTitle,filmLanguage ,directors, runtime,country,cast);
        this.releaseDate = releaseDate;
        this.writers = writers;
        this.genre = genre;
    }
}
