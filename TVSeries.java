public class TVSeries extends Film{
    String genre;
    String writers;
    String startDate;
    String endDate;
    String seasons;
    String episodes;
    TVSeries(String uniquieFilmId, String filmTitle, String filmLanguage , String directors, String runtime, String country, String cast,
    String genre,String writers,String startDate, String endDate, String seasons, String episodes){
        super(uniquieFilmId, filmTitle,filmLanguage ,directors, runtime,country,cast);
        this.genre = genre;
        this.writers = writers;
        this.startDate = startDate;
        this.endDate = endDate;
        this.seasons = seasons;
        this.episodes = episodes;
    }

}
