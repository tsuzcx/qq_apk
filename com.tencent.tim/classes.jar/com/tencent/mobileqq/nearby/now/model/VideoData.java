package com.tencent.mobileqq.nearby.now.model;

import ajwh;
import ajws;
import ajwt;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class VideoData
  implements Parcelable
{
  public static final Parcelable.Creator<VideoData> CREATOR = new ajwt();
  public long AC;
  public ajws a;
  public LocationInfo a;
  public long ads;
  public long adt;
  public long adu;
  public long adv;
  public long adw;
  public long adx;
  public int age;
  public String bSG;
  public String bSH;
  public String bSI;
  public String bSJ;
  public String coverUrl;
  public boolean cqF;
  public int dlA;
  public int dlB;
  public int dlC;
  public int dlw;
  public int dlx;
  public int dly;
  public int dlz;
  public String doodleUrl;
  public int feedType;
  public int gender;
  public String headerUrl;
  public String id;
  public boolean isFollowed;
  public boolean isLike;
  public boolean isReady;
  public String jumpUrl;
  public String shareUrl;
  public long time;
  public int type;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  public ArrayList<ajwh> yf = new ArrayList();
  
  public VideoData() {}
  
  public VideoData(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.id = paramParcel.readString();
    this.videoUrl = paramParcel.readString();
    this.coverUrl = paramParcel.readString();
    this.doodleUrl = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
    this.dlw = paramParcel.readInt();
    this.ads = paramParcel.readLong();
    this.headerUrl = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.isFollowed = bool1;
      if (paramParcel.readByte() == 0) {
        break label219;
      }
    }
    label219:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isLike = bool1;
      this.dly = paramParcel.readInt();
      this.bSG = paramParcel.readString();
      this.bSH = paramParcel.readString();
      this.adu = paramParcel.readLong();
      this.time = paramParcel.readLong();
      this.bSJ = paramParcel.readString();
      this.shareUrl = paramParcel.readString();
      this.adw = paramParcel.readLong();
      this.dlB = paramParcel.readInt();
      this.feedType = paramParcel.readInt();
      this.age = paramParcel.readInt();
      this.gender = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return hashCode();
  }
  
  public boolean isInvalid()
  {
    return (this.id == null) || (this.id.equals(""));
  }
  
  public String toString()
  {
    return "VideoData{id='" + this.id + '\'' + ", videoUrl='" + this.videoUrl + '\'' + ", coverUrl='" + this.coverUrl + '\'' + ", doodleUrl='" + this.doodleUrl + '\'' + ", headerUrl='" + this.headerUrl + '\'' + ", anchorNickName='" + this.bSG + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.videoUrl);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.doodleUrl);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeInt(this.dlw);
    paramParcel.writeLong(this.ads);
    paramParcel.writeString(this.headerUrl);
    if (this.isFollowed)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.isLike) {
        break label206;
      }
    }
    label206:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.dly);
      paramParcel.writeString(this.bSG);
      paramParcel.writeString(this.bSH);
      paramParcel.writeLong(this.adu);
      paramParcel.writeLong(this.time);
      paramParcel.writeString(this.bSJ);
      paramParcel.writeString(this.shareUrl);
      paramParcel.writeLong(this.adw);
      paramParcel.writeInt(this.dlB);
      paramParcel.writeInt(this.feedType);
      paramParcel.writeInt(this.age);
      paramParcel.writeInt(this.gender);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.VideoData
 * JD-Core Version:    0.7.0.1
 */