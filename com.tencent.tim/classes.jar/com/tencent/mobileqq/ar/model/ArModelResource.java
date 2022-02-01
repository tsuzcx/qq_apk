package com.tencent.mobileqq.ar.model;

import adkq;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArModelResource
  implements Parcelable
{
  public static final Parcelable.Creator<ArModelResource> CREATOR = new adkq();
  public long Ur;
  public String bum;
  public String bun;
  public String buo;
  public String bup;
  public String buq;
  public int cIc;
  public String zipFileName;
  
  public ArModelResource() {}
  
  public ArModelResource(Parcel paramParcel)
  {
    this.Ur = paramParcel.readLong();
    this.bum = paramParcel.readString();
    this.bun = paramParcel.readString();
    this.buo = paramParcel.readString();
    this.bup = paramParcel.readString();
    this.cIc = paramParcel.readInt();
    this.buq = paramParcel.readString();
    this.zipFileName = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArModelResource{");
    localStringBuffer.append("modelResourceSize='").append(this.Ur).append('\'');
    localStringBuffer.append(", modelResourceMD5=").append(this.bum).append('\'');
    localStringBuffer.append(", modelResourceUrl=").append(this.bun).append('\'');
    localStringBuffer.append(", modelResourceBgMusic=").append(this.buo).append('\'');
    localStringBuffer.append(", modelConfigFile=").append(this.bup).append('\'');
    localStringBuffer.append(", modelRepeatTimes=").append(this.cIc).append('\'');
    localStringBuffer.append(", videoLayout=").append(this.buq).append('\'');
    localStringBuffer.append(", zipFileName=").append(this.zipFileName).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.Ur);
    paramParcel.writeString(this.bum);
    paramParcel.writeString(this.bun);
    paramParcel.writeString(this.buo);
    paramParcel.writeString(this.bup);
    paramParcel.writeInt(this.cIc);
    paramParcel.writeString(this.buq);
    paramParcel.writeString(this.zipFileName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArModelResource
 * JD-Core Version:    0.7.0.1
 */