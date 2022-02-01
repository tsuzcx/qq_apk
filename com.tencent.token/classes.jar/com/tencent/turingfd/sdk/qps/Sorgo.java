package com.tencent.turingfd.sdk.qps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Sorgo
  implements Parcelable
{
  public static final Parcelable.Creator<Sorgo> a = new a();
  public int b;
  public byte[] c;
  public int d;
  
  public Sorgo(Parcel paramParcel)
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
    implements Parcelable.Creator<Sorgo>
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      return new Sorgo(paramParcel);
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new Sorgo[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Sorgo
 * JD-Core Version:    0.7.0.1
 */