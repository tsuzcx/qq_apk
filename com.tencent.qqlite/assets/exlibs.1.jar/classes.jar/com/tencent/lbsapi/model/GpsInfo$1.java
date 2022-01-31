package com.tencent.lbsapi.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GpsInfo$1
  implements Parcelable.Creator
{
  public GpsInfo createFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    int j = paramParcel.readInt();
    int k = paramParcel.readInt();
    int m = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false) {
      return new GpsInfo(i, j, k, m, bool, paramParcel.readFloat());
    }
  }
  
  public GpsInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.lbsapi.model.GpsInfo.1
 * JD-Core Version:    0.7.0.1
 */