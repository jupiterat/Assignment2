package com.coderschool.assignment2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by duongthoai on 10/23/16.
 */
public class Headline implements Parcelable {
    public String getMain() {
        return main;
    }

    public String getContent_kicker() {
        return content_kicker;
    }

    @SerializedName("main")

    String main;
    @SerializedName("content_kicker")
    String content_kicker;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.main);
        dest.writeString(this.content_kicker);
    }

    public Headline() {
    }

    protected Headline(Parcel in) {
        this.main = in.readString();
        this.content_kicker = in.readString();
    }

    public static final Creator<Headline> CREATOR = new Creator<Headline>() {
        @Override
        public Headline createFromParcel(Parcel source) {
            return new Headline(source);
        }

        @Override
        public Headline[] newArray(int size) {
            return new Headline[size];
        }
    };
}
