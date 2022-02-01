package com.tencent.mobileqq.ar.model;

import adkm;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArAwardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ArAwardInfo> CREATOR = new adkm();
  public String btY;
  public String btZ;
  public String bua;
  public String bub;
  public String businessLogo;
  public String businessName;
  public int cHY;
  public int cHZ;
  
  public ArAwardInfo() {}
  
  public ArAwardInfo(Parcel paramParcel)
  {
    this.cHY = paramParcel.readInt();
    this.btY = paramParcel.readString();
    this.businessLogo = paramParcel.readString();
    this.businessName = paramParcel.readString();
    this.btZ = paramParcel.readString();
    this.cHZ = paramParcel.readInt();
    this.bua = paramParcel.readString();
    this.bub = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cHY);
    paramParcel.writeString(this.btY);
    paramParcel.writeString(this.businessLogo);
    paramParcel.writeString(this.businessName);
    paramParcel.writeString(this.btZ);
    paramParcel.writeInt(this.cHZ);
    paramParcel.writeString(this.bua);
    paramParcel.writeString(this.bub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArAwardInfo
 * JD-Core Version:    0.7.0.1
 */