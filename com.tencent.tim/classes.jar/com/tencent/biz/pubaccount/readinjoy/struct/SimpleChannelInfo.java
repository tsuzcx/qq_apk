package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mia;

public class SimpleChannelInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleChannelInfo> CREATOR = new mia();
  public long channelID;
  public String name;
  public long vL;
  
  public SimpleChannelInfo() {}
  
  public SimpleChannelInfo(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.vL = paramParcel.readLong();
    this.channelID = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeLong(this.vL);
    paramParcel.writeLong(this.channelID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SimpleChannelInfo
 * JD-Core Version:    0.7.0.1
 */