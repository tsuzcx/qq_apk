package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public class ListScrollNotifier
  implements IEventNotifier
{
  private AbsListView mListView;
  private int mScrollState;
  
  public int getReuseType()
  {
    return 1;
  }
  
  public void init(AbsListView paramAbsListView, int paramInt)
  {
    this.mListView = paramAbsListView;
    this.mScrollState = paramInt;
  }
  
  public void notifyEvent(IEventListener paramIEventListener)
  {
    paramIEventListener.onListScrollStateChanged(this.mListView, this.mScrollState);
  }
  
  public void reset()
  {
    this.mListView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.ListScrollNotifier
 * JD-Core Version:    0.7.0.1
 */