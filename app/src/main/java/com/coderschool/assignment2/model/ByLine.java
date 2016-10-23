package com.coderschool.assignment2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by duongthoai on 10/23/16.
 */
public class ByLine implements Parcelable {
    @SerializedName("original")
    String original;

    public String getOriginal() {
        return original;
    }

    public List<Person> getPersons() {
        return persons;
    }

    @SerializedName("person")
    List<Person> persons;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.original);
        dest.writeTypedList(this.persons);
    }

    public ByLine() {
    }

    protected ByLine(Parcel in) {
        this.original = in.readString();
        this.persons = in.createTypedArrayList(Person.CREATOR);
    }

    public static final Creator<ByLine> CREATOR = new Creator<ByLine>() {
        @Override
        public ByLine createFromParcel(Parcel source) {
            return new ByLine(source);
        }

        @Override
        public ByLine[] newArray(int size) {
            return new ByLine[size];
        }
    };
}
