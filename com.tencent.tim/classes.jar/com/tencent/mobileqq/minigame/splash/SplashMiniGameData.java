package com.tencent.mobileqq.minigame.splash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class SplashMiniGameData
  implements Parcelable
{
  public static final Parcelable.Creator<SplashMiniGameData> CREATOR = new SplashMiniGameData.1();
  public String appId;
  public String desc;
  public String developerDesc;
  public ArrayList<String> downloadFileDomianList;
  public String downloadUrl;
  public int enable;
  public long endTime;
  public int fileSize;
  public int guide;
  public String iconUrl;
  public Boolean isPlayed;
  public String name;
  public String picLocalPath;
  public String picUrl;
  public int priority;
  public ArrayList<String> requestDomianList;
  public long startTime;
  public String version;
  public int videoDuration;
  public String videoLocalPath;
  public int videoMute;
  public String videoUrl;
  
  public SplashMiniGameData() {}
  
  protected SplashMiniGameData(Parcel paramParcel)
  {
    int i = paramParcel.readByte();
    Boolean localBoolean;
    if (i == 0)
    {
      localBoolean = null;
      this.isPlayed = localBoolean;
      this.videoUrl = paramParcel.readString();
      this.videoDuration = paramParcel.readInt();
      this.videoMute = paramParcel.readInt();
      this.videoLocalPath = paramParcel.readString();
      this.picUrl = paramParcel.readString();
      this.picLocalPath = paramParcel.readString();
      this.enable = paramParcel.readInt();
      this.guide = paramParcel.readInt();
      this.startTime = paramParcel.readLong();
      this.endTime = paramParcel.readLong();
      this.priority = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.version = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.fileSize = paramParcel.readInt();
      this.iconUrl = paramParcel.readString();
      this.name = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.developerDesc = paramParcel.readString();
      this.downloadFileDomianList = paramParcel.createStringArrayList();
      this.requestDomianList = paramParcel.createStringArrayList();
      return;
    }
    if (i == 1) {}
    for (;;)
    {
      localBoolean = Boolean.valueOf(bool);
      break;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "SplashMiniGameData{isPlayed=" + this.isPlayed + ", videoUrl='" + this.videoUrl + '\'' + ", videoDuration=" + this.videoDuration + ", videoMute=" + this.videoMute + ", videoLocalPath='" + this.videoLocalPath + '\'' + ", picUrl='" + this.picUrl + '\'' + ", picLocalPath='" + this.picLocalPath + '\'' + ", enable=" + this.enable + ", guide=" + this.guide + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", priority=" + this.priority + ", appId='" + this.appId + '\'' + ", version='" + this.version + '\'' + ", downloadUrl='" + this.downloadUrl + '\'' + ", fileSize=" + this.fileSize + ", iconUrl='" + this.iconUrl + '\'' + ", name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + ", developerDesc='" + this.developerDesc + '\'' + ", downloadFileDomianList=" + this.downloadFileDomianList + ", requestDomianList=" + this.requestDomianList + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.isPlayed == null) {
      paramInt = 0;
    }
    for (;;)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.videoUrl);
      paramParcel.writeInt(this.videoDuration);
      paramParcel.writeInt(this.videoMute);
      paramParcel.writeString(this.videoLocalPath);
      paramParcel.writeString(this.picUrl);
      paramParcel.writeString(this.picLocalPath);
      paramParcel.writeInt(this.enable);
      paramParcel.writeInt(this.guide);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeLong(this.endTime);
      paramParcel.writeInt(this.priority);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.version);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeInt(this.fileSize);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.developerDesc);
      paramParcel.writeStringList(this.downloadFileDomianList);
      paramParcel.writeStringList(this.requestDomianList);
      return;
      if (this.isPlayed.booleanValue()) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameData
 * JD-Core Version:    0.7.0.1
 */