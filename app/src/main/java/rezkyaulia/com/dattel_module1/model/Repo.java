package rezkyaulia.com.dattel_module1.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezky Aulia Pratama on 3/1/2018.
 */

public class Repo implements Parcelable {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeParcelable(this.owner, flags);
        dest.writeLong(this.stars);
        dest.writeLong(this.forks);
    }

    protected Repo(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.description = in.readString();
        this.owner = in.readParcelable(User.class.getClassLoader());
        this.stars = in.readLong();
        this.forks = in.readLong();
    }

    public static final Creator<Repo> CREATOR = new Creator<Repo>() {
        @Override
        public Repo createFromParcel(Parcel source) {
            return new Repo(source);
        }

        @Override
        public Repo[] newArray(int size) {
            return new Repo[size];
        }
    };
}
