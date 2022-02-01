package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StTagInfo;

public class QCircleTopTagEvent
  extends SimpleBaseEvent
{
  public int followState;
  public FeedCloudMeta.StTagInfo stTagInfo;
  
  public QCircleTopTagEvent(FeedCloudMeta.StTagInfo paramStTagInfo, int paramInt)
  {
    this.stTagInfo = paramStTagInfo;
    this.followState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleTopTagEvent
 * JD-Core Version:    0.7.0.1
 */