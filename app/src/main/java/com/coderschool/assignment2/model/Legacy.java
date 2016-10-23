package com.coderschool.assignment2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by duongthoai on 10/23/16.
 */
public class Legacy implements Parcelable {
    @SerializedName("wide")
    String wide;
    @SerializedName("wideheight")
    String wideheight;

    public String getWide() {
        return wide;
    }

    public String getWideheight() {
        return wideheight;
    }

    public String getWidewidth() {
        return widewidth;
    }

    @SerializedName("widewidth")
    String widewidth;

    protected Legacy(Parcel in) {
        wide = in.readString();
        wideheight = in.readString();
        widewidth = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(wide);
        dest.writeString(wideheight);
        dest.writeString(widewidth);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Legacy> CREATOR = new Creator<Legacy>() {
        @Override
        public Legacy createFromParcel(Parcel in) {
            return new Legacy(in);
        }

        @Override
        public Legacy[] newArray(int size) {
            return new Legacy[size];
        }
    };
}
