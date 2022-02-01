package com.tencent.mobileqq.activity.photo.album.preview;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public class PreviewBean
{
  LocalMediaInfo mMediaInfo;
  public int mMediaType;
  String mPath;
  
  public LocalMediaInfo getMediaInfo()
  {
    return this.mMediaInfo;
  }
  
  public int getMediaType()
  {
    return this.mMediaType;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public void setMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    this.mMediaInfo = paramLocalMediaInfo;
  }
  
  public void setMediaType(int paramInt)
  {
    this.mMediaType = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.mPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.PreviewBean
 * JD-Core Version:    0.7.0.1
 */