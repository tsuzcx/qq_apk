package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dzx;

public class ReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new dzx();
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public long a = -1L;
  public long b = -1L;
  public long c = -1L;
  public int e = -1;
  public int f = -1;
  public int g = -1;
  public int h = -1;
  public int i = -1;
  public int j = -1;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nReportInfo");
    localStringBuilder.append("\n |-").append("rpStep:").append(this.e);
    localStringBuilder.append("\n |-").append("rpMsgRecvTime:").append(this.a);
    localStringBuilder.append("\n |-").append("rpMsgNetwork:").append(this.f);
    localStringBuilder.append("\n |-").append("rpThumbNetwork:").append(this.g);
    localStringBuilder.append("\n |-").append("rpThumbDownMode:").append(this.h);
    localStringBuilder.append("\n |-").append("rpThumbTimeDiff:").append(this.b);
    localStringBuilder.append("\n |-").append("rpBigDownMode:").append(this.i);
    localStringBuilder.append("\n |-").append("rpBigTimeDiff:").append(this.c);
    localStringBuilder.append("\n |-").append("rpBigNetwork:").append(this.j);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeLong(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.ReportInfo
 * JD-Core Version:    0.7.0.1
 */