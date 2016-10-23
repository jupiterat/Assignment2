package com.coderschool.assignment2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by duongthoai on 10/23/16.
 */
public class Mutilmedia implements Parcelable {
    @SerializedName("width")
    String width;
    @SerializedName("url")
    String url;
    @SerializedName("height")
    String height;

    public String getWidth() {
        return width;
    }

    public String getUrl() {
        return url;
    }

    public String getHeight() {
        return height;
    }

    public String getSubtype() {
        return subtype;
    }

    public Legacy getLegacy() {
        return legacy;
    }

    public String getType() {
        return type;
    }

    @SerializedName("subtype")
    String subtype;
    @SerializedName("legacy")
    Legacy legacy;
    @SerializedName("type")
    String type;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.width);
        dest.writeString(this.url);
        dest.writeString(this.height);
        dest.writeString(this.subtype);
        dest.writeParcelable(this.legacy, flags);
        dest.writeString(this.type);
    }

    public Mutilmedia() {
    }

    protected Mutilmedia(Parcel in) {
        this.width = in.readString();
        this.url = in.readString();
        this.height = in.readString();
        this.subtype = in.readString();
        this.legacy = in.readParcelable(Legacy.class.getClassLoader());
        this.type = in.readString();
    }

    public static final Creator<Mutilmedia> CREATOR = new Creator<Mutilmedia>() {
        @Override
        public Mutilmedia createFromParcel(Parcel source) {
            return new Mutilmedia(source);
        }

        @Override
        public Mutilmedia[] newArray(int size) {
            return new Mutilmedia[size];
        }
    };
}
