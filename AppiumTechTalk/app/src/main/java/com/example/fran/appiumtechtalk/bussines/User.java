package com.example.fran.appiumtechtalk.bussines;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{

    private String name;
    private String lastName;
    private String gender;
    private String eyeColor;

    public User() {
    }

    public User(String name, String lastName, String gender, String eyeColor) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.eyeColor = eyeColor;
    }

    protected User(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        gender = in.readString();
        eyeColor = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeString(gender);
        dest.writeString(eyeColor);
    }
}
