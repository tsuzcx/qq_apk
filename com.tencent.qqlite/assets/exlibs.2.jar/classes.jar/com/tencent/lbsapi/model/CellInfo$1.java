package com.tencent.lbsapi.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CellInfo$1
  implements Parcelable.Creator
{
  public CellInfo createFromParcel(Parcel paramParcel)
  {
    return new CellInfo(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readDouble(), paramParcel.readDouble());
  }
  
  public CellInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.lbsapi.model.CellInfo.1
 * JD-Core Version:    0.7.0.1
 */