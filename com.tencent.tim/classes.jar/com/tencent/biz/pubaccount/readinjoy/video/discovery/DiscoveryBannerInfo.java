package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import nab;

public class DiscoveryBannerInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DiscoveryBannerInfo> CREATOR = new nab();
  public String akX;
  public String akY;
  public String coverUrl;
  public int jumpType;
  public long xg;
  
  public DiscoveryBannerInfo() {}
  
  public DiscoveryBannerInfo(Parcel paramParcel)
  {
    this.xg = paramParcel.readLong();
    this.coverUrl = paramParcel.readString();
    this.akX = paramParcel.readString();
    this.jumpType = paramParcel.readInt();
    this.akY = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DiscoveryBannerInfo{bannerId=" + this.xg + ", coverUrl='" + this.coverUrl + '\'' + ", coverTitle='" + this.akX + '\'' + ", jumpType=" + this.jumpType + ", jumpDataJson='" + this.akY + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.xg);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.akX);
    paramParcel.writeInt(this.jumpType);
    paramParcel.writeString(this.akY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.DiscoveryBannerInfo
 * JD-Core Version:    0.7.0.1
 */