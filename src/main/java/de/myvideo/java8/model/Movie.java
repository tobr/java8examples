package de.myvideo.java8.model;

public class Movie {
    private int id;
    private String title;
    private Integer viewCount;
    private boolean premium;
    private MovieType movieType;

    public Movie() {
        super();
    }

    public Movie(final int id, final String title, final Integer viewCount, final MovieType movieType, final boolean premium) {
        this.id = id;
        this.title = title;
        this.viewCount = viewCount;
        this.premium = premium;
        this.movieType = movieType;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(final Integer viewCount) {
        this.viewCount = viewCount;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(final boolean premium) {
        this.premium = premium;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(final MovieType movieType) {
        this.movieType = movieType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (premium != movie.premium) return false;
        if (movieType != movie.movieType) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (viewCount != null ? !viewCount.equals(movie.viewCount) : movie.viewCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        result = 31 * result + (premium ? 1 : 0);
        result = 31 * result + (movieType != null ? movieType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", viewCount=" + viewCount +
                ", premium=" + premium +
                ", movieType=" + movieType +
                "}\n";
    }
}
