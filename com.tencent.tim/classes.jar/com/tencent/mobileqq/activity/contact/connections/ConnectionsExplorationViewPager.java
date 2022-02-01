package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ConnectionsExplorationViewPager
  extends ViewPager
{
  private boolean scrollable = true;
  
  public ConnectionsExplorationViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ConnectionsExplorationViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.scrollable;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.scrollable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationViewPager
 * JD-Core Version:    0.7.0.1
 */