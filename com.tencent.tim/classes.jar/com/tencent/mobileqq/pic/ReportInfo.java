package com.tencent.mobileqq.pic;

import akyc;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ReportInfo> CREATOR = new akyc();
  public long afA = -1L;
  public long afB = -1L;
  public long afC = -1L;
  public int dpS = -1;
  public int dpT = -1;
  public int dpU = -1;
  public int dpV = -1;
  public int dpW = -1;
  public int dpX = -1;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nReportInfo");
    localStringBuilder.append("\n |-").append("rpStep:").append(this.dpS);
    localStringBuilder.append("\n |-").append("rpMsgRecvTime:").append(this.afA);
    localStringBuilder.append("\n |-").append("rpMsgNetwork:").append(this.dpT);
    localStringBuilder.append("\n |-").append("rpThumbNetwork:").append(this.dpU);
    localStringBuilder.append("\n |-").append("rpThumbDownMode:").append(this.dpV);
    localStringBuilder.append("\n |-").append("rpThumbTimeDiff:").append(this.afB);
    localStringBuilder.append("\n |-").append("rpBigDownMode:").append(this.dpW);
    localStringBuilder.append("\n |-").append("rpBigTimeDiff:").append(this.afC);
    localStringBuilder.append("\n |-").append("rpBigNetwork:").append(this.dpX);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.dpS);
    paramParcel.writeInt(this.dpT);
    paramParcel.writeInt(this.dpU);
    paramParcel.writeInt(this.dpX);
    paramParcel.writeInt(this.dpV);
    paramParcel.writeInt(this.dpW);
    paramParcel.writeLong(this.afA);
    paramParcel.writeLong(this.afB);
    paramParcel.writeLong(this.afC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.ReportInfo
 * JD-Core Version:    0.7.0.1
 */