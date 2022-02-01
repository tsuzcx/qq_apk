package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleCommonAnimationEvent
  extends SimpleBaseEvent
{
  public static int STATE_ANIMATION_END = 2;
  public static int STATE_ANIMATION_START;
  public static int TYPE_SPLASH_VIDEO = 1;
  public int mState;
  public int mType;
  
  static
  {
    STATE_ANIMATION_START = 1;
  }
  
  public QCircleCommonAnimationEvent(int paramInt1, int paramInt2)
  {
    this.mType = paramInt1;
    this.mState = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleCommonAnimationEvent
 * JD-Core Version:    0.7.0.1
 */