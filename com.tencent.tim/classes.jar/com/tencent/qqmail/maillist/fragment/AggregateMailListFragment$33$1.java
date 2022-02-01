package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.activity.readmail.model.VirtualAdManager;
import com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter;
import com.tencent.qqmail.nativepages.NativeAdsHelper;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;

class AggregateMailListFragment$33$1
  implements Runnable
{
  AggregateMailListFragment$33$1(AggregateMailListFragment.33 param33, int paramInt) {}
  
  public void run()
  {
    Popularize localPopularize = AggregateMailListFragment.access$200(this.this$1.this$0).getPopularizedData(this.val$position);
    PopularizeUIHelper.handleCancel(localPopularize);
    if (localPopularize.getType() == 9)
    {
      VirtualAdManager.getInstance().reportDeleteOrUnLike(2, localPopularize);
      NativeAdsHelper.getInstance().log(localPopularize.getServerId(), "Event_Native_AD_Inner_Mail_List_Delete");
    }
    AggregateMailListFragment.access$900(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.33.1
 * JD-Core Version:    0.7.0.1
 */