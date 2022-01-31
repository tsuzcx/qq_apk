package com.tencent.lbsapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WifiInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new WifiInfo.1();
  public String mac = "";
  public int rssi = 0;
  
  public WifiInfo() {}
  
  public WifiInfo(String paramString, int paramInt)
  {
    this.mac = paramString;
    this.rssi = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WifiInfo [mac=" + this.mac + ", rssi=" + this.rssi + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mac);
    paramParcel.writeInt(this.rssi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.lbsapi.model.WifiInfo
 * JD-Core Version:    0.7.0.1
 */