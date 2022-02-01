package com.tencent.oskplayer.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class VideoInfo$1
  implements Parcelable.Creator<VideoInfo>
{
  public VideoInfo createFromParcel(Parcel paramParcel)
  {
    VideoInfo localVideoInfo = new VideoInfo(paramParcel.createStringArray(), paramParcel.createStringArray(), paramParcel.readInt());
    localVideoInfo.setCurrentStream(paramParcel.readInt());
    localVideoInfo.setCurrentPosition(paramParcel.readInt());
    localVideoInfo.setDurationAllow(paramParcel.readInt());
    VideoInfo.access$002(localVideoInfo, paramParcel.readString());
    VideoInfo.access$102(localVideoInfo, paramParcel.readString());
    return localVideoInfo;
  }
  
  public VideoInfo[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.model.VideoInfo.1
 * JD-Core Version:    0.7.0.1
 */