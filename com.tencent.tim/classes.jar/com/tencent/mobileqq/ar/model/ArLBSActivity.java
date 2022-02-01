package com.tencent.mobileqq.ar.model;

import adkp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArLBSActivity
  implements Parcelable
{
  public static final Parcelable.Creator<ArLBSActivity> CREATOR = new adkp();
  public String activityName = "";
  public String bug = "";
  public String buh = "";
  public String bui = "";
  public String buj = "";
  public String buk = "";
  public String bul = "";
  public String logoUrl = "";
  
  public ArLBSActivity() {}
  
  public ArLBSActivity(Parcel paramParcel)
  {
    this.activityName = paramParcel.readString();
    this.logoUrl = paramParcel.readString();
    this.bug = paramParcel.readString();
    this.buh = paramParcel.readString();
    this.bui = paramParcel.readString();
    this.buj = paramParcel.readString();
    this.buk = paramParcel.readString();
    this.bul = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArLBSActivity{");
    localStringBuffer.append("activityName = ").append(this.activityName);
    localStringBuffer.append(", logoUrl = ").append(this.logoUrl);
    localStringBuffer.append(", mapBackgroundUrl = ").append(this.bug);
    localStringBuffer.append(", prizeImageUrl = ").append(this.buh);
    localStringBuffer.append(", prizeName = ").append(this.bui);
    localStringBuffer.append(", tipsForOutsideLBSLocation = ").append(this.buj);
    localStringBuffer.append(", tipsTitleForNoLBSLocation = ").append(this.buk);
    localStringBuffer.append(", tipsContentForNoLBSLocation = ").append(this.bul);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.activityName);
    paramParcel.writeString(this.logoUrl);
    paramParcel.writeString(this.bug);
    paramParcel.writeString(this.buh);
    paramParcel.writeString(this.bui);
    paramParcel.writeString(this.buj);
    paramParcel.writeString(this.buk);
    paramParcel.writeString(this.bul);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArLBSActivity
 * JD-Core Version:    0.7.0.1
 */