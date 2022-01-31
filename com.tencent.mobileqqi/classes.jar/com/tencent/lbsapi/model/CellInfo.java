package com.tencent.lbsapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CellInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new CellInfo.1();
  public int cellId = -1;
  public int lac = -1;
  public int mcc = -1;
  public int mnc = -1;
  public int rssi = 0;
  public double stationLat = 0.0D;
  public double stationLon = 0.0D;
  
  public CellInfo() {}
  
  public CellInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble1, double paramDouble2)
  {
    this.mcc = paramInt1;
    this.mnc = paramInt2;
    this.lac = paramInt3;
    this.cellId = paramInt4;
    this.rssi = paramInt5;
    this.stationLat = paramDouble1;
    this.stationLon = paramDouble2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "CellInfo [mcc=" + this.mcc + ", mnc=" + this.mnc + ", lac=" + this.lac + ", cellId=" + this.cellId + ", rssi=" + this.rssi + ", stationLat=" + this.stationLat + ", stationLon=" + this.stationLon + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mcc);
    paramParcel.writeInt(this.mnc);
    paramParcel.writeInt(this.lac);
    paramParcel.writeInt(this.cellId);
    paramParcel.writeInt(this.rssi);
    paramParcel.writeDouble(this.stationLat);
    paramParcel.writeDouble(this.stationLon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.lbsapi.model.CellInfo
 * JD-Core Version:    0.7.0.1
 */