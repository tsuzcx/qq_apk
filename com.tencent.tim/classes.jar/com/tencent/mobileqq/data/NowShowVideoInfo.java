package com.tencent.mobileqq.data;

public class NowShowVideoInfo
  extends ProfilePhotoWall
{
  public String mCoverUrl;
  public String mJumpUrl;
  
  public NowShowVideoInfo(String paramString1, String paramString2, long paramLong)
  {
    this.type = 2;
    this.mCoverUrl = paramString1;
    this.mJumpUrl = paramString2;
    this.time = paramLong;
  }
  
  public String getOriginUrl()
  {
    return this.mCoverUrl;
  }
  
  public String getThumbUrl(int paramInt)
  {
    return this.mCoverUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.NowShowVideoInfo
 * JD-Core Version:    0.7.0.1
 */