package com.tencent.moai.database.sqlite;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CursorWindow$1
  implements Parcelable.Creator<CursorWindow>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.CursorWindow.1
 * JD-Core Version:    0.7.0.1
 */