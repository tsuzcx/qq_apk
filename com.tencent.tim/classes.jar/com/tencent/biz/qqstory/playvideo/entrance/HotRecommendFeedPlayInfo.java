package com.tencent.biz.qqstory.playvideo.entrance;

public class HotRecommendFeedPlayInfo
  extends FeedBasePlayInfo
{
  public final int mPullType;
  
  public HotRecommendFeedPlayInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramString1, paramString2, paramString3, false, false);
    this.mPullType = paramInt;
  }
  
  public String toString()
  {
    return "HotRecommendFeedPlayInfo{mPullType=" + this.mPullType + ", mFeedFeedId='" + this.mFeedFeedId + '\'' + ", mStartVideoFeedId='" + this.mStartVideoFeedId + '\'' + ", mStartVid='" + this.mStartVid + '\'' + ", mForcePlayVidFromOld2New=" + this.mForcePlayVidFromOld2New + ", mForceNotUseVidCache=" + this.mForceNotUseVidCache + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo
 * JD-Core Version:    0.7.0.1
 */