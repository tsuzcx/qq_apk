package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aqdt;

public class HeadRequest
  implements Parcelable
{
  public static final Parcelable.Creator<HeadRequest> CREATOR = new aqdt();
  public QQHeadInfo b;
  public int dYL;
  public int dYM;
  public String mID;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.mID = paramParcel.readString();
    this.dYL = paramParcel.readInt();
    this.dYM = paramParcel.readInt();
    this.b = ((QQHeadInfo)paramParcel.readParcelable(getClass().getClassLoader()));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mID);
    paramParcel.writeInt(this.dYL);
    paramParcel.writeInt(this.dYM);
    paramParcel.writeParcelable(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.HeadRequest
 * JD-Core Version:    0.7.0.1
 */