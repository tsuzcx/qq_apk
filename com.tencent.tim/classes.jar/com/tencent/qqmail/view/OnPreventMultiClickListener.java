package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Date;

public abstract class OnPreventMultiClickListener
  implements View.OnClickListener
{
  private static final long DEFAULT_INTERVAL = 500L;
  private final long interval;
  private long lastClickTime = 0L;
  
  public OnPreventMultiClickListener()
  {
    this(500L);
  }
  
  public OnPreventMultiClickListener(long paramLong)
  {
    this.interval = paramLong;
  }
  
  public void onClick(View paramView)
  {
    long l = new Date().getTime();
    if (l - this.lastClickTime > this.interval)
    {
      this.lastClickTime = l;
      onUniqueClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public abstract void onUniqueClick(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.OnPreventMultiClickListener
 * JD-Core Version:    0.7.0.1
 */