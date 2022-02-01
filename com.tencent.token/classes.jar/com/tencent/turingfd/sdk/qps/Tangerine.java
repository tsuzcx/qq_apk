package com.tencent.turingfd.sdk.qps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Tangerine
  implements Parcelable
{
  public static final Parcelable.Creator<Tangerine> a = new a();
  public int b;
  public byte[] c;
  public int d;
  
  public Tangerine(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.createByteArray();
    this.d = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeByteArray(this.c);
    paramParcel.writeInt(this.d);
  }
  
  public final class a
    implements Parcelable.Creator<Tangerine>
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      return new Tangerine(paramParcel);
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new Tangerine[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Tangerine
 * JD-Core Version:    0.7.0.1
 */