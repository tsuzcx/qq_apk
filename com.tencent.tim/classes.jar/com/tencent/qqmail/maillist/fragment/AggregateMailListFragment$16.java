package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import java.util.ArrayList;
import java.util.Iterator;

class AggregateMailListFragment$16
  implements Runnable
{
  AggregateMailListFragment$16(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void run()
  {
    Iterator localIterator = AggregateMailListFragment.access$200(this.this$0).getPopularizedData().iterator();
    while (localIterator.hasNext())
    {
      Popularize localPopularize = (Popularize)localIterator.next();
      if (localPopularize.getType() == 9)
      {
        if ((!localPopularize.isRead()) || (QMSharedPreferenceManager.getInstance().getAdvertiseMailReadTime() <= 0L)) {
          QMSharedPreferenceManager.getInstance().setAdvertiseMailReadTime(System.currentTimeMillis());
        }
        localPopularize.setIsRead(true);
        PopularizeManager.sharedInstance().updatePopularizeIsRead(true, localPopularize);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.16
 * JD-Core Version:    0.7.0.1
 */