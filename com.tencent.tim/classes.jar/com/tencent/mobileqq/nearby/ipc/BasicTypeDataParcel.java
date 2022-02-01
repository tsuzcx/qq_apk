package com.tencent.mobileqq.nearby.ipc;

import ajva;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BasicTypeDataParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BasicTypeDataParcel> CREATOR = new ajva();
  public Object[] s;
  public int what;
  
  public BasicTypeDataParcel(int paramInt, Object... paramVarArgs)
  {
    this.what = paramInt;
    this.s = paramVarArgs;
  }
  
  public BasicTypeDataParcel(Parcel paramParcel)
  {
    this.what = paramParcel.readInt();
    this.s = paramParcel.readArray(Object.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--------------------start-------------------");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.what);
    localStringBuilder.append("\n");
    if (this.s != null)
    {
      int i = 0;
      while (i < this.s.length)
      {
        localStringBuilder.append(this.s[i]);
        localStringBuilder.append("\n");
        i += 1;
      }
    }
    localStringBuilder.append("--------------------end-------------------");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.what);
    paramParcel.writeArray(this.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel
 * JD-Core Version:    0.7.0.1
 */