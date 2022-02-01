package com.tencent.tim.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aujx;

public class PadIdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PadIdInfo> CREATOR = new aujx();
  String cjc;
  int domainId;
  
  public PadIdInfo(Parcel paramParcel)
  {
    this.domainId = paramParcel.readInt();
    this.cjc = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.domainId);
    paramParcel.writeString(this.cjc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.PadIdInfo
 * JD-Core Version:    0.7.0.1
 */