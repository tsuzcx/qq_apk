package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import trl;

public class FromService
  implements Parcelable
{
  public static final Parcelable.Creator<FromService> CREATOR = new trl();
  public Bundle U;
  public int cmd;
  public int seq;
  public int subCmd;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cmd);
    paramParcel.writeInt(this.subCmd);
    paramParcel.writeInt(this.seq);
    paramParcel.writeBundle(this.U);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.FromService
 * JD-Core Version:    0.7.0.1
 */