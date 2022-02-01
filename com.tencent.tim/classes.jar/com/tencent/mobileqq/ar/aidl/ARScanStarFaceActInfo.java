package com.tencent.mobileqq.ar.aidl;

import adge;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARScanStarFaceActInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanStarFaceActInfo> CREATOR = new adge();
  public long SP;
  public long beginTime;
  public String bsI;
  public String bsJ;
  public String bsK;
  public String bsL;
  public long endTime;
  public String nu;
  public String starName;
  
  public ARScanStarFaceActInfo() {}
  
  public ARScanStarFaceActInfo(Parcel paramParcel)
  {
    this.starName = paramParcel.readString();
    this.bsI = paramParcel.readString();
    this.nu = paramParcel.readString();
    this.bsJ = paramParcel.readString();
    this.bsK = paramParcel.readString();
    this.bsL = paramParcel.readString();
    this.beginTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.SP = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ARScanStarFaceActInfo{actTitle='" + this.nu + '\'' + "actDescription='" + this.bsJ + '\'' + ", starName='" + this.starName + '\'' + ", starUin='" + this.bsI + '\'' + ", starWebUrl='" + this.bsK + '\'' + ", adImgUrl='" + this.bsL + '\'' + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", actID=" + this.SP + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.starName);
    paramParcel.writeString(this.bsI);
    paramParcel.writeString(this.nu);
    paramParcel.writeString(this.bsJ);
    paramParcel.writeString(this.bsK);
    paramParcel.writeString(this.bsL);
    paramParcel.writeLong(this.beginTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.SP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo
 * JD-Core Version:    0.7.0.1
 */