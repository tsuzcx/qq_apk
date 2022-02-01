package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import jyo;

public class EncryptUinInfo
  implements Parcelable
{
  public static final Parcelable.Creator<EncryptUinInfo> CREATOR = new jyo();
  public String UZ;
  public int code;
  public long rb;
  
  public EncryptUinInfo() {}
  
  public EncryptUinInfo(Parcel paramParcel)
  {
    this.rb = paramParcel.readLong();
    this.code = paramParcel.readInt();
    this.UZ = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.rb);
    paramParcel.writeInt(this.code);
    paramParcel.writeString(this.UZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.EncryptUinInfo
 * JD-Core Version:    0.7.0.1
 */