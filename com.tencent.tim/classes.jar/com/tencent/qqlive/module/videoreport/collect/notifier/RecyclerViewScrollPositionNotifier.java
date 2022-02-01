package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.support.v7.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public class RecyclerViewScrollPositionNotifier
  implements IEventNotifier
{
  private RecyclerView mView;
  
  public int getReuseType()
  {
    return 7;
  }
  
  public void init(RecyclerView paramRecyclerView)
  {
    this.mView = paramRecyclerView;
  }
  
  public void notifyEvent(IEventListener paramIEventListener)
  {
    paramIEventListener.onRecyclerViewScrollPosition(this.mView);
  }
  
  public void reset()
  {
    this.mView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewScrollPositionNotifier
 * JD-Core Version:    0.7.0.1
 */