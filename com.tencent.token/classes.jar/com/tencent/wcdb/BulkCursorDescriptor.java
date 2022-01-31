package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BulkCursorDescriptor
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new BulkCursorDescriptor.1();
  public String[] columnNames;
  public int count;
  public IBulkCursor cursor;
  public boolean wantsAllOnMoveCalls;
  public CursorWindow window;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.cursor = BulkCursorNative.asInterface(paramParcel.readStrongBinder());
    this.columnNames = readStringArray(paramParcel);
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.wantsAllOnMoveCalls = bool;
      this.count = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        this.window = ((CursorWindow)CursorWindow.CREATOR.createFromParcel(paramParcel));
      }
      return;
    }
  }
  
  public final String[] readStringArray(Parcel paramParcel)
  {
    Object localObject = null;
    int j = paramParcel.readInt();
    if (j >= 0)
    {
      String[] arrayOfString = new String[j];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfString;
        if (i >= j) {
          break;
        }
        arrayOfString[i] = paramParcel.readString();
        i += 1;
      }
    }
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.cursor.asBinder());
    paramParcel.writeStringArray(this.columnNames);
    if (this.wantsAllOnMoveCalls) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.count);
      if (this.window == null) {
        break;
      }
      paramParcel.writeInt(1);
      this.window.writeToParcel(paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorDescriptor
 * JD-Core Version:    0.7.0.1
 */