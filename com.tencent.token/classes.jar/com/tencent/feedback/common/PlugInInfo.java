package com.tencent.feedback.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class PlugInInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PlugInInfo> CREATOR = new Parcelable.Creator() {};
  private static final long serialVersionUID = 1L;
  public final String plugInId;
  public final String plugInUUID;
  public final String plugInVersion;
  
  public PlugInInfo(Parcel paramParcel)
  {
    this.plugInId = paramParcel.readString();
    this.plugInVersion = paramParcel.readString();
    this.plugInUUID = paramParcel.readString();
  }
  
  public PlugInInfo(String paramString1, String paramString2, String paramString3)
  {
    this.plugInId = paramString1;
    this.plugInVersion = paramString2;
    this.plugInUUID = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "plid:" + this.plugInId + " plV:" + this.plugInVersion + " plUUID:" + this.plugInUUID;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.plugInId);
    paramParcel.writeString(this.plugInVersion);
    paramParcel.writeString(this.plugInUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.PlugInInfo
 * JD-Core Version:    0.7.0.1
 */