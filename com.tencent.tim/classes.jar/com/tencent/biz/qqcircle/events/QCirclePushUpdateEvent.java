package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StUser;

public class QCirclePushUpdateEvent
  extends SimpleBaseEvent
{
  public int mAllPushTimes;
  public FeedCloudMeta.StUser mCurrentUser;
  public String mTargetFeedId;
  
  public QCirclePushUpdateEvent(FeedCloudMeta.StUser paramStUser, String paramString, int paramInt)
  {
    this.mTargetFeedId = paramString;
    this.mCurrentUser = paramStUser;
    this.mAllPushTimes = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent
 * JD-Core Version:    0.7.0.1
 */