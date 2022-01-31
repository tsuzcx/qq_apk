package com.tencent.lbsapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GpsInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new GpsInfo.1();
  public float accuracy = 0.0F;
  public int alt = -10000000;
  public int eType = 0;
  public boolean hasAccuracy = false;
  public int lat = 900000000;
  public int lon = 900000000;
  
  public GpsInfo() {}
  
  public GpsInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, float paramFloat)
  {
    this.lat = paramInt1;
    this.lon = paramInt2;
    this.alt = paramInt3;
    this.eType = paramInt4;
    this.hasAccuracy = paramBoolean;
    this.accuracy = paramFloat;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "GpsInfo [lat=" + this.lat + ", lon=" + this.lon + ", alt=" + this.alt + ", eType=" + this.eType + ", hasAccuracy=" + this.hasAccuracy + ", accuracy=" + this.accuracy + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.lat);
    paramParcel.writeInt(this.lon);
    paramParcel.writeInt(this.alt);
    paramParcel.writeInt(this.eType);
    if (this.hasAccuracy) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeFloat(this.accuracy);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.lbsapi.model.GpsInfo
 * JD-Core Version:    0.7.0.1
 */