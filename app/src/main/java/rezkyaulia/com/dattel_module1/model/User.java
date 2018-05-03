package rezkyaulia.com.dattel_module1.model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rezky Aulia Pratama on 3/1/2018.
 */

public class User implements Parcelable{
    public User() {
    }
    public  String login;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
    }

    protected User(Parcel in) {
        this.login = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
