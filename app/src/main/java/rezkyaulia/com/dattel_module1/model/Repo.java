package rezkyaulia.com.dattel_module1.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezky Aulia Pratama on 3/1/2018.
 */

public class Repo {
    public final long id;
    public final String name;
    public final String description;
    public final User owner;

    @SerializedName("stargazers_count")
    public final long stars;

    @SerializedName("forks_count")
    public final long forks;

    public Repo(long id, String name, String description, User owner, long stars, long forks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.stars = stars;
        this.forks = forks;
    }
}
