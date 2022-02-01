package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import trm;

public class ToService
  implements Parcelable
{
  public static final Parcelable.Creator<ToService> CREATOR = new trm();
  public long EM;
  public String aJJ;
  public int cmd;
  public Bundle k;
  public int seq;
  public int subCmd;
  public int timeout;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cmd);
    paramParcel.writeInt(this.subCmd);
    paramParcel.writeInt(this.seq);
    paramParcel.writeInt(this.timeout);
    paramParcel.writeLong(this.EM);
    paramParcel.writeString(this.aJJ);
    paramParcel.writeBundle(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.ToService
 * JD-Core Version:    0.7.0.1
 */