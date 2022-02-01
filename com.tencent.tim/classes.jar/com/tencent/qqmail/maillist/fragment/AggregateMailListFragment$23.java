package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.readmail.model.VirtualAdManager;
import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;

class AggregateMailListFragment$23
  implements View.OnClickListener
{
  AggregateMailListFragment$23(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (AggregateMailListFragment.access$800(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((AggregateMailListFragment.access$2800(this.this$0).length == 0) && (AggregateMailListFragment.access$3100(this.this$0).length == 0))
      {
        this.this$0.getTips().showSuccess(2131695646, 700L);
      }
      else
      {
        int[] arrayOfInt;
        if ((AggregateMailListFragment.access$3100(this.this$0).length > 0) && (AggregateMailListFragment.access$2800(this.this$0).length == 0))
        {
          arrayOfInt = AggregateMailListFragment.access$3100(this.this$0);
          this.this$0.isCancelPopularizeAnimationStart = true;
          ListViewRemoveItemAnimator.animateRemoval(AggregateMailListFragment.access$1700(this.this$0), AggregateMailListFragment.access$1500(this.this$0).keySet(), new AggregateMailListFragment.23.1(this, arrayOfInt));
        }
        else
        {
          arrayOfInt = AggregateMailListFragment.access$3100(this.this$0);
          int i = 0;
          while (i < arrayOfInt.length)
          {
            Popularize localPopularize = PopularizeManager.sharedInstance().getPopularizeById(arrayOfInt[i]);
            if (localPopularize != null)
            {
              PopularizeUIHelper.handleCancel(localPopularize);
              if (localPopularize.getType() == 9) {
                VirtualAdManager.getInstance().reportDeleteOrUnLike(2, localPopularize);
              }
            }
            i += 1;
          }
          Threads.runInBackground(new AggregateMailListFragment.23.2(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.23
 * JD-Core Version:    0.7.0.1
 */