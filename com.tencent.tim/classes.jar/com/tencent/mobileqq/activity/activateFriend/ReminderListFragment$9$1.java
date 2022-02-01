package com.tencent.mobileqq.activity.activateFriend;

import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import wib;

public class ReminderListFragment$9$1
  implements Runnable
{
  public ReminderListFragment$9$1(wib paramwib) {}
  
  public void run()
  {
    PullToRefreshRecyclerView localPullToRefreshRecyclerView = ReminderListFragment.a(this.a.this$0);
    if (ReminderListFragment.a(this.a.this$0)) {}
    for (PullToRefreshBase.Mode localMode = PullToRefreshBase.Mode.BOTH;; localMode = PullToRefreshBase.Mode.PULL_FROM_START)
    {
      localPullToRefreshRecyclerView.setMode(localMode);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.9.1
 * JD-Core Version:    0.7.0.1
 */