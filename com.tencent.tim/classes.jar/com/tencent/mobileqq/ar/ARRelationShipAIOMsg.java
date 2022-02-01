package com.tencent.mobileqq.ar;

import adcx;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARRelationShipAIOMsg
  implements Parcelable
{
  public static final Parcelable.Creator<ARRelationShipAIOMsg> CREATOR = new adcx();
  public String brZ;
  public String bsa;
  public String bsb;
  public String bsc;
  public String bsd;
  
  public ARRelationShipAIOMsg() {}
  
  public ARRelationShipAIOMsg(Parcel paramParcel)
  {
    this.brZ = paramParcel.readString();
    this.bsa = paramParcel.readString();
    this.bsb = paramParcel.readString();
    this.bsc = paramParcel.readString();
    this.bsd = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.brZ);
    paramParcel.writeString(this.bsa);
    paramParcel.writeString(this.bsb);
    paramParcel.writeString(this.bsc);
    paramParcel.writeString(this.bsd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRelationShipAIOMsg
 * JD-Core Version:    0.7.0.1
 */