package com.huawei.hms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class DataHolderCreator
  implements Parcelable.Creator<DataHolder>
{
  public final DataHolder createFromParcel(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(m))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, m);
        break;
      case 1: 
        arrayOfString = SafeParcelReader.createStringArray(paramParcel, m);
        break;
      case 2: 
        arrayOfCursorWindow = (CursorWindow[])SafeParcelReader.createTypedArray(paramParcel, m, CursorWindow.CREATOR);
        break;
      case 3: 
        i = SafeParcelReader.readInt(paramParcel, m);
        break;
      case 4: 
        localBundle = SafeParcelReader.createBundle(paramParcel, m);
        break;
      case 1000: 
        j = SafeParcelReader.readInt(paramParcel, m);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    return new DataHolder(j, arrayOfString, arrayOfCursorWindow, i, localBundle);
  }
  
  public final DataHolder[] newArray(int paramInt)
  {
    return new DataHolder[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.data.DataHolderCreator
 * JD-Core Version:    0.7.0.1
 */