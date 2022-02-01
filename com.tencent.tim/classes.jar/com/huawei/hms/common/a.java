package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class a
  implements Parcelable.Creator<Feature>
{
  public final Feature a(Parcel paramParcel)
  {
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    String str = null;
    int i = 0;
    long l = -1L;
    while (paramParcel.dataPosition() < j)
    {
      int k = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(k))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, k);
        break;
      case 1: 
        str = SafeParcelReader.createString(paramParcel, k);
        break;
      case 2: 
        i = SafeParcelReader.readInt(paramParcel, k);
        break;
      case 3: 
        l = SafeParcelReader.readLong(paramParcel, k);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    return new Feature(str, i, l);
  }
  
  public final Feature[] a(int paramInt)
  {
    return new Feature[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.a
 * JD-Core Version:    0.7.0.1
 */