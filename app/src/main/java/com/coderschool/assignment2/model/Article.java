package com.coderschool.assignment2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by duongthoai on 10/23/16.
 */

public class Article implements Parcelable {
    @SerializedName("web_url")
    String web_url;
    @SerializedName("snippet")
    String snippet;
    @SerializedName("lead_paragraph")
    String lead_paragraph;


    @SerializedName("abstract")
    String abstractStr;
    @SerializedName("print_page")
    String print_page;
    @SerializedName("source")
    String source;
    @SerializedName("keywords")
    String keywords;
    @SerializedName("pub_date")
    String pub_date;
    @SerializedName("document_type")
    String document_type;
    @SerializedName("news_desk")
    String news_desk;

    public String getWeb_url() {
        return web_url;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getLead_paragraph() {
        return lead_paragraph;
    }

    public String getAbstractStr() {
        return abstractStr;
    }

    public String getPrint_page() {
        return print_page;
    }

    public String getSource() {
        return source;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getPub_date() {
        return pub_date;
    }

    public String getDocument_type() {
        return document_type;
    }

    public String getNews_desk() {
        return news_desk;
    }

    public String getSection_name() {
        return section_name;
    }

    public String getSubsection_name() {
        return subsection_name;
    }

    public String getType_of_material() {
        return type_of_material;
    }

    public String get_id() {
        return _id;
    }

    public String getWord_count() {
        return word_count;
    }

    public String getSlideshow_credits() {
        return slideshow_credits;
    }

    public List<Mutilmedia> getMutilmedias() {
        return mutilmedias;
    }

    public Headline getHeadline() {
        return headline;
    }

    public ByLine getByLine() {
        return byLine;
    }

    @SerializedName("section_name")
    String section_name;
    @SerializedName("subsection_name")
    String subsection_name;
    @SerializedName("type_of_material")
    String type_of_material;
    @SerializedName("_id")
    String _id;
    @SerializedName("word_count")
    String word_count;
    @SerializedName("slideshow_credits")
    String slideshow_credits;

    @SerializedName("multimedia")
    List<Mutilmedia> mutilmedias;

    @SerializedName("headline")
    Headline headline;

    @SerializedName("byline")
    ByLine byLine;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.web_url);
        dest.writeString(this.snippet);
        dest.writeString(this.lead_paragraph);
        dest.writeString(this.abstractStr);
        dest.writeString(this.print_page);
        dest.writeString(this.source);
        dest.writeString(this.keywords);
        dest.writeString(this.pub_date);
        dest.writeString(this.document_type);
        dest.writeString(this.news_desk);
        dest.writeString(this.section_name);
        dest.writeString(this.subsection_name);
        dest.writeString(this.type_of_material);
        dest.writeString(this._id);
        dest.writeString(this.word_count);
        dest.writeString(this.slideshow_credits);
        dest.writeTypedList(this.mutilmedias);
        dest.writeParcelable(this.headline, flags);
        dest.writeParcelable(this.byLine, flags);
    }

    public Article() {
    }

    protected Article(Parcel in) {
        this.web_url = in.readString();
        this.snippet = in.readString();
        this.lead_paragraph = in.readString();
        this.abstractStr = in.readString();
        this.print_page = in.readString();
        this.source = in.readString();
        this.keywords = in.readString();
        this.pub_date = in.readString();
        this.document_type = in.readString();
        this.news_desk = in.readString();
        this.section_name = in.readString();
        this.subsection_name = in.readString();
        this.type_of_material = in.readString();
        this._id = in.readString();
        this.word_count = in.readString();
        this.slideshow_credits = in.readString();
        this.mutilmedias = in.createTypedArrayList(Mutilmedia.CREATOR);
        this.headline = in.readParcelable(Headline.class.getClassLoader());
        this.byLine = in.readParcelable(ByLine.class.getClassLoader());
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
