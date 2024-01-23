package es.iesaguadulce.ejemploui;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Persona implements Parcelable {

    private String name;
    private String edad;

    public Persona(String name, String edad) {
        this.name = name;
        this.edad = edad;
    }

    protected Persona(Parcel in) {
        name = in.readString();
        edad = in.readString();
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getEdad() {
        return edad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(edad);
    }
}
