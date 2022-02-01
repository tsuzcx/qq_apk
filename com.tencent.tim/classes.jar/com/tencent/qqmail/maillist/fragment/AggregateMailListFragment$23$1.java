package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.activity.readmail.model.VirtualAdManager;
import com.tencent.qqmail.animation.SynchronousAnimator;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;

class AggregateMailListFragment$23$1
  implements Runnable
{
  AggregateMailListFragment$23$1(AggregateMailListFragment.23 param23, int[] paramArrayOfInt) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.val$ids.length)
    {
      Popularize localPopularize = PopularizeManager.sharedInstance().getPopularizeById(this.val$ids[i]);
      if (localPopularize != null)
      {
        PopularizeUIHelper.handleCancel(localPopularize);
        if (localPopularize.getType() == 9) {
          VirtualAdManager.getInstance().reportDeleteOrUnLike(2, localPopularize);
        }
      }
      i += 1;
    }
    this.this$1.this$0.isCancelPopularizeAnimationComplete = true;
    AggregateMailListFragment.access$1800(this.this$1.this$0).animationCompelete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.23.1
 * JD-Core Version:    0.7.0.1
 */