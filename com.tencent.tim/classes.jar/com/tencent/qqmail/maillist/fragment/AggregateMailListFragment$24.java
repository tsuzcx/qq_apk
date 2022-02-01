package com.tencent.qqmail.maillist.fragment;

import android.util.Log;
import com.tencent.qqmail.animation.SynchronousAnimator;
import java.util.HashMap;

class AggregateMailListFragment$24
  extends SynchronousAnimator
{
  AggregateMailListFragment$24(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public boolean isAllAnimationComplete()
  {
    if ((this.this$0.isDeleteMailAnimationStart) && (this.this$0.isDeleteMailAnimationComplete) && (!this.this$0.isCancelPopularizeAnimationStart)) {}
    while (((!this.this$0.isDeleteMailAnimationStart) && (this.this$0.isCancelPopularizeAnimationStart) && (this.this$0.isCancelPopularizeAnimationComplete)) || ((this.this$0.isDeleteMailAnimationStart) && (this.this$0.isDeleteMailAnimationComplete) && (this.this$0.isCancelPopularizeAnimationStart) && (this.this$0.isCancelPopularizeAnimationComplete))) {
      return true;
    }
    return false;
  }
  
  public boolean isAllAnimationStart()
  {
    int i;
    int j;
    if (AggregateMailListFragment.access$1600(this.this$0).size() > 0)
    {
      i = 1;
      if (AggregateMailListFragment.access$1500(this.this$0).size() <= 0) {
        break label65;
      }
      j = 1;
      label30:
      if (((i == 0) && (!this.this$0.hasScollDeleteMail)) || (!this.this$0.isDeleteMailAnimationStart) || (j != 0)) {
        break label70;
      }
    }
    label65:
    label70:
    while (((i == 0) && (j != 0) && (this.this$0.isCancelPopularizeAnimationStart)) || ((i != 0) && (this.this$0.isDeleteMailAnimationStart) && (j != 0) && (this.this$0.isCancelPopularizeAnimationStart)))
    {
      return true;
      i = 0;
      break;
      j = 0;
      break label30;
    }
    return false;
  }
  
  public void onAllAnimationComplete()
  {
    this.this$0.hasScollDeleteMail = false;
    this.this$0.isDeleteMailAnimationStart = false;
    this.this$0.isCancelPopularizeAnimationStart = false;
    this.this$0.isDeleteMailAnimationComplete = false;
    this.this$0.isCancelPopularizeAnimationComplete = false;
    Log.v("AdMailListFragment", "onAllAnimationComplete");
    AggregateMailListFragment.access$1400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.24
 * JD-Core Version:    0.7.0.1
 */