package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePolyPraiseUpdateEvent
  extends SimpleBaseEvent
{
  public QQCircleFeedBase.StPolyLike mNewStPolyLike;
  public int mPraisedNum;
  public int mPraisedStatus;
  public String mTargetFeedId;
  public QQCircleFeedBase.StPolyLike moldStPolyLike;
  
  public QCirclePolyPraiseUpdateEvent(String paramString, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2, int paramInt1, int paramInt2)
  {
    this.moldStPolyLike = paramStPolyLike1;
    this.mPraisedStatus = paramInt1;
    this.mNewStPolyLike = paramStPolyLike2;
    this.mTargetFeedId = paramString;
    this.mPraisedNum = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent
 * JD-Core Version:    0.7.0.1
 */