package com.tencent.thumbplayer.core.config;

public class TPPlayerCoreConfig
{
  private static boolean mMediaDrmReuseEnable = false;
  private static int mVideoMediaCodecCoexistMaxCnt = 0;
  
  public static boolean getMediaDrmReuseEnable()
  {
    return mMediaDrmReuseEnable;
  }
  
  public static int getVideoMediaCodecCoexistMaxCnt()
  {
    return mVideoMediaCodecCoexistMaxCnt;
  }
  
  public static void setMediaDrmReuseEnable(boolean paramBoolean)
  {
    mMediaDrmReuseEnable = paramBoolean;
  }
  
  public static void setVideoMediaCodecCoexistMaxCnt(int paramInt)
  {
    mVideoMediaCodecCoexistMaxCnt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.config.TPPlayerCoreConfig
 * JD-Core Version:    0.7.0.1
 */