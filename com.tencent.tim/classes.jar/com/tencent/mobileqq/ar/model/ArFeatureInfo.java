package com.tencent.mobileqq.ar.model;

import adko;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArFeatureInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ArFeatureInfo> CREATOR = new adko();
  public long Uq;
  public String buc;
  public String bud;
  public String bue;
  public String buf;
  
  public ArFeatureInfo() {}
  
  public ArFeatureInfo(Parcel paramParcel)
  {
    this.buc = paramParcel.readString();
    this.Uq = paramParcel.readLong();
    this.bud = paramParcel.readString();
    this.bue = paramParcel.readString();
    this.buf = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArFeatureInfo{");
    localStringBuffer.append("featureMd5='").append(this.buc).append('\'');
    localStringBuffer.append(", featureSize=").append(this.Uq).append('\'');
    localStringBuffer.append(", featureUrl=").append(this.bud).append('\'');
    localStringBuffer.append(", featurefileName=").append(this.bue).append('\'');
    localStringBuffer.append(", modelRootDir=").append(this.buf).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.buc);
    paramParcel.writeLong(this.Uq);
    paramParcel.writeString(this.bud);
    paramParcel.writeString(this.bue);
    paramParcel.writeString(this.buf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArFeatureInfo
 * JD-Core Version:    0.7.0.1
 */