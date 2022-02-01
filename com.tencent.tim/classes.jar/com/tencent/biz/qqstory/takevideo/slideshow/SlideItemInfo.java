package com.tencent.biz.qqstory.takevideo.slideshow;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aqfy;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.net.URL;
import pkd;
import rlu;

public class SlideItemInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SlideItemInfo> CREATOR = new rlu();
  public String aBo;
  public String aBp;
  public boolean aIN;
  public boolean aIO;
  public LocalMediaInfo d;
  public int endIndex;
  public long endTime;
  public pkd f;
  public boolean hasAudioTrack;
  public URL k;
  public long mDuration;
  public int mSampleRate;
  public String mSrcPath;
  public int mTextId = -1;
  public String mTextStr;
  public String mTransId = "LinearBlur";
  public int mediaType;
  public int scrollX;
  public int startIndex;
  public long startTime;
  
  public SlideItemInfo(Parcel paramParcel)
  {
    this.d = ((LocalMediaInfo)paramParcel.readParcelable(LocalMediaInfo.class.getClassLoader()));
    this.mTextId = paramParcel.readInt();
    this.mTextStr = paramParcel.readString();
    this.mediaType = paramParcel.readInt();
    this.mSrcPath = paramParcel.readString();
    this.mDuration = paramParcel.readLong();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.aBo = paramParcel.readString();
    this.aBp = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hasAudioTrack = bool1;
      this.mSampleRate = paramParcel.readInt();
      this.scrollX = paramParcel.readInt();
      this.startIndex = paramParcel.readInt();
      this.endIndex = paramParcel.readInt();
      this.mTransId = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label193;
      }
      bool1 = true;
      label168:
      this.aIN = bool1;
      if (paramParcel.readByte() == 0) {
        break label198;
      }
    }
    label193:
    label198:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aIO = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label168;
    }
  }
  
  public SlideItemInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    try
    {
      this.d = paramLocalMediaInfo;
      this.mSrcPath = paramLocalMediaInfo.path;
      this.mediaType = aqfy.getMediaType(paramLocalMediaInfo);
      if (!TextUtils.isEmpty(paramLocalMediaInfo.mTransId)) {
        this.mTransId = paramLocalMediaInfo.mTransId;
      }
      if (!TextUtils.isEmpty(paramLocalMediaInfo.mTextStr)) {
        this.mTextStr = paramLocalMediaInfo.mTextStr;
      }
      this.mTextId = paramLocalMediaInfo.mTextId;
      switch (this.mediaType)
      {
      case 0: 
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(paramLocalMediaInfo.path);
        this.k = aqfy.generateAlbumThumbURL(paramLocalMediaInfo);
        this.mDuration = 2000L;
        this.endTime = this.mDuration;
        return;
      }
    }
    catch (Exception paramLocalMediaInfo)
    {
      paramLocalMediaInfo.printStackTrace();
      return;
    }
    if (paramLocalMediaInfo.isSystemMeidaStore == true) {}
    for (this.k = aqfy.generateAlbumThumbURL(paramLocalMediaInfo, "VIDEO");; this.k = aqfy.generateAlbumThumbURL(paramLocalMediaInfo, "APP_VIDEO"))
    {
      this.mDuration = paramLocalMediaInfo.mDuration;
      if (this.endTime != 0L) {
        break;
      }
      this.endTime = this.mDuration;
      return;
    }
  }
  
  public long dU()
  {
    if (this.startTime <= 0L) {
      this.startTime = 0L;
    }
    if ((this.endTime <= 0L) || (this.endTime >= this.mDuration)) {
      this.endTime = this.mDuration;
    }
    if (this.endTime <= this.startTime) {
      return this.mDuration;
    }
    return this.endTime - this.startTime;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof SlideItemInfo))
    {
      paramObject = (SlideItemInfo)paramObject;
      return TextUtils.equals(this.mSrcPath, paramObject.mSrcPath);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeParcelable(this.d, paramInt);
    paramParcel.writeInt(this.mTextId);
    paramParcel.writeString(this.mTextStr);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeString(this.mSrcPath);
    paramParcel.writeLong(this.mDuration);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeString(this.aBo);
    paramParcel.writeString(this.aBp);
    if (this.hasAudioTrack)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.mSampleRate);
      paramParcel.writeInt(this.scrollX);
      paramParcel.writeInt(this.startIndex);
      paramParcel.writeInt(this.endIndex);
      paramParcel.writeString(this.mTransId);
      if (!this.aIN) {
        break label174;
      }
      paramInt = 1;
      label147:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aIO) {
        break label179;
      }
    }
    label174:
    label179:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label147;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo
 * JD-Core Version:    0.7.0.1
 */