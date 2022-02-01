package com.tencent.mobileqq.ar.model;

import adkn;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArDefaultSetting
  implements Parcelable
{
  public static final Parcelable.Creator<ArDefaultSetting> CREATOR = new adkn();
  public int cIa;
  public int cIb;
  public String key;
  public int type;
  
  public ArDefaultSetting() {}
  
  public ArDefaultSetting(Parcel paramParcel)
  {
    this.key = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.cIa = paramParcel.readInt();
    this.cIb = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ArDefaultSetting{key='" + this.key + '\'' + ", type=" + this.type + ", modelLevel=" + this.cIa + ", traceLevel=" + this.cIb + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.key);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.cIa);
    paramParcel.writeInt(this.cIb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArDefaultSetting
 * JD-Core Version:    0.7.0.1
 */