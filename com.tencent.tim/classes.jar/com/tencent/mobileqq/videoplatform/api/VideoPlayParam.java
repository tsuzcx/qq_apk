package com.tencent.mobileqq.videoplatform.api;

import java.util.ArrayList;
import java.util.Arrays;

public class VideoPlayParam
{
  public VideoPlayerCallback mCallback;
  public ArrayList<String> mCookies;
  public String mFileID;
  public long mFileSize;
  public boolean mIsLocal;
  public boolean mIsLoop;
  public boolean mIsMute;
  public long mLastPlayPosMs;
  public long mMaxPlayTimeMs;
  public boolean mNeedPlayProgress;
  public String mSavePath;
  public int mSceneId;
  public String mSceneName;
  public long mStartPlayPosMs;
  public String[] mUrls;
  public long mVideoFileTimeMs;
  public int mVideoFormat = 101;
  public String mVideoPath;
  
  public boolean isSameVideo(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof VideoPlayParam)) {}
    do
    {
      return false;
      paramObject = (VideoPlayParam)paramObject;
    } while ((paramObject.mIsLocal != this.mIsLocal) || (paramObject.mIsLoop != this.mIsLoop) || (paramObject.mIsMute != this.mIsMute));
    if ((paramObject.mVideoPath != null) && (this.mVideoPath != null) && (paramObject.mVideoPath.equals(this.mVideoPath))) {
      return true;
    }
    if ((paramObject.mUrls != null) && (this.mUrls != null) && (Arrays.equals(paramObject.mUrls, this.mUrls))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */