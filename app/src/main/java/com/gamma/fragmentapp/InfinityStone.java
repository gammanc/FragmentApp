package com.gamma.fragmentapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by emers on 16/4/2018.
 */

public class InfinityStone implements Parcelable {

    private String name, location, description;
    private int image;

    public InfinityStone(String name, String location, String description, int image){
        this.name = name;
        this.location = location;
        this.description = description;
        this.image = image;
    }

    protected InfinityStone(Parcel in) {
        this.name = in.readString();
        this.location = in.readString();
        this.description = in.readString();
        this.image = in.readInt();
    }

    public static final Creator<InfinityStone> CREATOR = new Creator<InfinityStone>() {
        @Override
        public InfinityStone createFromParcel(Parcel in) {
            return new InfinityStone(in);
        }

        @Override
        public InfinityStone[] newArray(int size) {
            return new InfinityStone[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(description);
        dest.writeInt(image);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
