package com.tencent.mobileqq.ar.model;

import adkr;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArVideoResourceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ArVideoResourceInfo> CREATOR = new adkr();
  public String buq;
  public String bur;
  public String bus;
  public int cId;
  public int cIe;
  public int cIf;
  public String videoMd5;
  public long videoSize;
  public int videoType;
  public String videoUrl;
  
  public ArVideoResourceInfo() {}
  
  public ArVideoResourceInfo(Parcel paramParcel)
  {
    this.cId = paramParcel.readInt();
    this.videoSize = paramParcel.readLong();
    this.bur = paramParcel.readString();
    this.buq = paramParcel.readString();
    this.videoMd5 = paramParcel.readString();
    this.cIe = paramParcel.readInt();
    this.cIf = paramParcel.readInt();
    this.videoType = paramParcel.readInt();
    this.videoUrl = paramParcel.readString();
    this.bus = paramParcel.readString();
  }
  
  public boolean aeK()
  {
    return this.cId == 0;
  }
  
  public boolean aeL()
  {
    return this.cId == 1;
  }
  
  public boolean aeM()
  {
    return this.cId == 2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cId);
    paramParcel.writeLong(this.videoSize);
    paramParcel.writeString(this.bur);
    paramParcel.writeString(this.buq);
    paramParcel.writeString(this.videoMd5);
    paramParcel.writeInt(this.cIe);
    paramParcel.writeInt(this.cIf);
    paramParcel.writeInt(this.videoType);
    paramParcel.writeString(this.videoUrl);
    paramParcel.writeString(this.bus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArVideoResourceInfo
 * JD-Core Version:    0.7.0.1
 */