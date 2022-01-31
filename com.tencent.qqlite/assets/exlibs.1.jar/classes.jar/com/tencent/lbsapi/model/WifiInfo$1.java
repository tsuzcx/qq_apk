package com.tencent.lbsapi.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WifiInfo$1
  implements Parcelable.Creator
{
  public WifiInfo createFromParcel(Parcel paramParcel)
  {
    return new WifiInfo(paramParcel.readString(), paramParcel.readInt());
  }
  
  public WifiInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.lbsapi.model.WifiInfo.1
 * JD-Core Version:    0.7.0.1
 */