package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import ovx;

public class QCircleFeedCommentEllipseEvent
  extends SimpleBaseEvent
{
  public ovx mInfo;
  
  public QCircleFeedCommentEllipseEvent(ovx paramovx)
  {
    this.mInfo = paramovx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent
 * JD-Core Version:    0.7.0.1
 */