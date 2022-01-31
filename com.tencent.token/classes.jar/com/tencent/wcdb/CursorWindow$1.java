package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CursorWindow$1
  implements Parcelable.Creator
{
  public CursorWindow createFromParcel(Parcel paramParcel)
  {
    return new CursorWindow(paramParcel, null);
  }
  
  public CursorWindow[] newArray(int paramInt)
  {
    return new CursorWindow[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.CursorWindow.1
 * JD-Core Version:    0.7.0.1
 */