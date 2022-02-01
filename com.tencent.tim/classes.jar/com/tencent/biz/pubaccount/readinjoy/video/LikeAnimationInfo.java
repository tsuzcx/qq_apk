package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import msb;

public class LikeAnimationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LikeAnimationInfo> CREATOR = new msb();
  public int aTU;
  public String[] bA;
  
  public LikeAnimationInfo() {}
  
  public LikeAnimationInfo(Parcel paramParcel)
  {
    this.bA = paramParcel.createStringArray();
    this.aTU = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "LikeAnimationInfo{icons=" + Arrays.toString(this.bA) + ", nextReqInterval=" + this.aTU + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(this.bA);
    paramParcel.writeInt(this.aTU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo
 * JD-Core Version:    0.7.0.1
 */