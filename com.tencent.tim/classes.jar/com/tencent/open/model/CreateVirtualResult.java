package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import asaz;

public class CreateVirtualResult
  implements Parcelable
{
  public static final Parcelable.Creator<CreateVirtualResult> CREATOR = new asaz();
  public long awT;
  public String headUrl;
  
  public CreateVirtualResult() {}
  
  public CreateVirtualResult(Parcel paramParcel)
  {
    this.awT = paramParcel.readLong();
    this.headUrl = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CreateVirtualResult={");
    localStringBuilder.append("virtualId=").append(this.awT).append(",");
    localStringBuilder.append("headUrl=").append(this.headUrl).append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.awT);
    paramParcel.writeString(this.headUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.model.CreateVirtualResult
 * JD-Core Version:    0.7.0.1
 */