package com.tencent.component.network.downloader.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPInfo
  implements Parcelable
{
  public static final Parcelable.Creator<IPInfo> CREATOR = new a();
  public String a;
  public int b;
  
  public IPInfo() {}
  
  public IPInfo(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }
  
  public IPInfo(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof IPInfo))) {
        break;
      }
      paramObject = (IPInfo)paramObject;
      String str1 = paramObject.a;
      String str2 = this.a;
      boolean bool;
      if (str1 != null) {
        bool = str1.equals(str2);
      }
      while ((!bool) || (paramObject.b != this.b))
      {
        return false;
        if (str2 == null) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    return false;
  }
  
  public String toString()
  {
    return new String(this.a + ":" + this.b);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.common.IPInfo
 * JD-Core Version:    0.7.0.1
 */