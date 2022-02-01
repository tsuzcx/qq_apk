package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VIPContactsFragment$11
  implements AdapterView.OnItemClickListener
{
  VIPContactsFragment$11(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (!VIPContactsFragment.access$2100(this.this$0)) {
      if (VIPContactsFragment.access$2000(this.this$0) != null)
      {
        i = paramInt - VIPContactsFragment.access$1800(this.this$0).getHeaderViewsCount();
        if ((i >= 0) && (i < VIPContactsFragment.access$2000(this.this$0).getCount())) {
          VIPContactsFragment.access$2000(this.this$0).toggleSelected(paramView, i);
        }
      }
    }
    for (;;)
    {
      VIPContactsFragment.access$2300(this.this$0);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (VIPContactsFragment.access$2200(this.this$0) != null)
      {
        i = paramInt - VIPContactsFragment.access$1900(this.this$0).getHeaderViewsCount();
        if ((i >= 0) && (i < VIPContactsFragment.access$2200(this.this$0).getCount())) {
          VIPContactsFragment.access$2200(this.this$0).toggleSelected(paramView, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.11
 * JD-Core Version:    0.7.0.1
 */