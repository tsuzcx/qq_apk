package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class CommentListShowStateEvent
  extends SimpleBaseEvent
{
  public boolean shown;
  
  public CommentListShowStateEvent(boolean paramBoolean)
  {
    this.shown = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.CommentListShowStateEvent
 * JD-Core Version:    0.7.0.1
 */