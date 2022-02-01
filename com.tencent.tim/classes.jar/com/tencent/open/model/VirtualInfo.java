package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import asbb;

public class VirtualInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VirtualInfo> CREATOR = new asbb();
  public String avatarUrl;
  public long awT;
  public String nickName;
  
  public VirtualInfo() {}
  
  public VirtualInfo(Parcel paramParcel)
  {
    this.awT = paramParcel.readLong();
    this.nickName = paramParcel.readString();
    this.avatarUrl = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("VirtualInfo={");
    localStringBuilder.append("virtualId=").append(this.awT).append(",");
    localStringBuilder.append("nickName=").append(this.nickName).append(",");
    localStringBuilder.append("avatarUrl=").append(this.avatarUrl).append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.awT);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.avatarUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.model.VirtualInfo
 * JD-Core Version:    0.7.0.1
 */