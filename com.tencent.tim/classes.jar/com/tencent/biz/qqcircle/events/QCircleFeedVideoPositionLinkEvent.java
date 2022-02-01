package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFeedVideoPositionLinkEvent
  extends SimpleBaseEvent
{
  public long mCurrentPlayPosition;
  public String mFeedUrl;
  
  public QCircleFeedVideoPositionLinkEvent(String paramString, long paramLong)
  {
    this.mFeedUrl = paramString;
    this.mCurrentPlayPosition = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent
 * JD-Core Version:    0.7.0.1
 */