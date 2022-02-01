package com.tencent.oskplayer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new VideoInfo.1();
  private int currentPosition;
  private int currentStream;
  private int defaultStream;
  private int durationAllow = -1;
  private String playScene;
  private String refer;
  private String[] streamNames;
  private String[] streamUrls;
  
  public VideoInfo(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this(paramArrayOfString1, paramArrayOfString2, 0);
  }
  
  public VideoInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt)
  {
    this(paramArrayOfString1, paramArrayOfString2, paramInt, -1);
  }
  
  public VideoInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, int paramInt2)
  {
    this(paramArrayOfString1, paramArrayOfString2, paramInt1, paramInt2, "", "");
  }
  
  public VideoInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.streamNames = paramArrayOfString1;
    this.streamUrls = paramArrayOfString2;
    this.defaultStream = paramInt1;
    this.currentStream = paramInt1;
    this.currentPosition = 0;
    this.durationAllow = paramInt2;
    this.playScene = paramString1;
    this.refer = paramString2;
  }
  
  public VideoInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2)
  {
    this(paramArrayOfString1, paramArrayOfString2, 0, -1, paramString1, paramString2);
  }
  
  public static void validate(VideoInfo paramVideoInfo)
    throws IllegalArgumentException
  {
    if (paramVideoInfo == null) {
      throw new IllegalArgumentException("videoInfo is null");
    }
    if ((paramVideoInfo.streamNames == null) || (paramVideoInfo.streamUrls == null) || (paramVideoInfo.streamNames.length == 0) || (paramVideoInfo.streamUrls.length == 0) || (paramVideoInfo.streamNames.length != paramVideoInfo.streamUrls.length)) {
      throw new IllegalArgumentException("Illegal streamNames or streamUrls");
    }
    if ((paramVideoInfo.defaultStream < 0) || (paramVideoInfo.defaultStream >= paramVideoInfo.streamNames.length)) {
      throw new IllegalArgumentException("default stream index out of bound");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getCurrentPosition()
  {
    return this.currentPosition;
  }
  
  public int getCurrentStream()
  {
    return this.currentStream;
  }
  
  public String getCurrentStreamUrl()
  {
    return this.streamUrls[this.currentStream];
  }
  
  public int getDefaultStream()
  {
    return this.defaultStream;
  }
  
  public String getDefaultStreamName()
  {
    if ((this.streamNames == null) || (this.streamNames.length < this.defaultStream) || (this.defaultStream < 0)) {
      return null;
    }
    return this.streamNames[this.defaultStream];
  }
  
  public String getDefaultStreamUrl()
  {
    if ((this.streamUrls == null) || (this.streamUrls.length < this.defaultStream) || (this.defaultStream < 0)) {
      return null;
    }
    return this.streamUrls[this.defaultStream];
  }
  
  public int getDurationAllow()
  {
    return this.durationAllow;
  }
  
  public String getPlayScene()
  {
    return this.playScene;
  }
  
  public String getRefer()
  {
    return this.refer;
  }
  
  public String[] getStreamNames()
  {
    return this.streamNames;
  }
  
  public String[] getStreamUrls()
  {
    return this.streamUrls;
  }
  
  public void setCurrentPosition(int paramInt)
  {
    this.currentPosition = paramInt;
  }
  
  public void setCurrentStream(int paramInt)
  {
    this.currentStream = paramInt;
  }
  
  public void setDurationAllow(int paramInt)
  {
    this.durationAllow = paramInt;
  }
  
  public void setPlayScene(String paramString)
  {
    this.playScene = paramString;
  }
  
  public void setRefer(String paramString)
  {
    this.refer = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(this.streamNames);
    paramParcel.writeStringArray(this.streamUrls);
    paramParcel.writeInt(this.defaultStream);
    paramParcel.writeInt(this.currentStream);
    paramParcel.writeInt(this.currentPosition);
    paramParcel.writeInt(this.durationAllow);
    paramParcel.writeString(this.playScene);
    paramParcel.writeString(this.refer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.model.VideoInfo
 * JD-Core Version:    0.7.0.1
 */