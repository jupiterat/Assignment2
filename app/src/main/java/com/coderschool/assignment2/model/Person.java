package com.coderschool.assignment2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by duongthoai on 10/23/16.
 */
public class Person implements Parcelable {
    @SerializedName("organization")
    String organization;

    @SerializedName("role")
    String role;

    public String getOrganization() {
        return organization;
    }

    public String getRole() {
        return role;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getRank() {
        return rank;
    }

    public String getLastname() {
        return lastname;
    }

    @SerializedName("firstname")
    String firstname;

    @SerializedName("rank")
    String rank;

    @SerializedName("lastname")
    String lastname;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.organization);
        dest.writeString(this.role);
        dest.writeString(this.firstname);
        dest.writeString(this.rank);
        dest.writeString(this.lastname);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.organization = in.readString();
        this.role = in.readString();
        this.firstname = in.readString();
        this.rank = in.readString();
        this.lastname = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
