package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter;
import com.tencent.qqmail.model.uidomain.MailOperate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class AggregateMailListFragment$8$1
  implements Runnable
{
  AggregateMailListFragment$8$1(AggregateMailListFragment.8 param8, long[] paramArrayOfLong) {}
  
  public void run()
  {
    if (AggregateMailListFragment.access$1300(this.this$1.this$0).canHandleDelete(this.val$mailIds))
    {
      this.this$1.this$0.isDeleteMailAnimationStart = true;
      int i = AggregateMailListFragment.access$200(this.this$1.this$0).getPopularizedCount();
      ArrayList localArrayList = new ArrayList(AggregateMailListFragment.access$1500(this.this$1.this$0).keySet());
      Iterator localIterator = AggregateMailListFragment.access$1600(this.this$1.this$0).keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Integer.valueOf(((Integer)localIterator.next()).intValue() + i));
      }
      ListViewRemoveItemAnimator.animateRemoval(AggregateMailListFragment.access$1700(this.this$1.this$0), localArrayList, new AggregateMailListFragment.8.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.8.1
 * JD-Core Version:    0.7.0.1
 */