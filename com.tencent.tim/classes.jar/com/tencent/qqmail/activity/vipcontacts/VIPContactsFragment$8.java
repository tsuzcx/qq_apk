package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.view.ContactUIHelper;

class VIPContactsFragment$8
  implements View.OnClickListener
{
  VIPContactsFragment$8(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onClick(View paramView)
  {
    ListView localListView = null;
    if (VIPContactsFragment.access$1800(this.this$0).getVisibility() == 0)
    {
      localListView = VIPContactsFragment.access$1800(this.this$0);
      if (localListView != null) {
        break label59;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (VIPContactsFragment.access$1900(this.this$0).getVisibility() != 0) {
        break;
      }
      localListView = VIPContactsFragment.access$1900(this.this$0);
      break;
      label59:
      ContactUIHelper.smoothScrollToTop(localListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.8
 * JD-Core Version:    0.7.0.1
 */