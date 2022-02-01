package com.tencent.qqmail.activity.vipcontacts;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.view.MailListItemView;

class VIPContactsIndexFragment$7
  implements View.OnClickListener
{
  VIPContactsIndexFragment$7(VIPContactsIndexFragment paramVIPContactsIndexFragment) {}
  
  public void onClick(View paramView)
  {
    if (VIPContactsIndexFragment.access$700(this.this$0) != null)
    {
      if (Build.VERSION.SDK_INT < 8) {
        break label102;
      }
      int i = VIPContactsIndexFragment.access$700(this.this$0).getFirstVisiblePosition();
      int j = MailListItemView.VIEW_HEIGHT;
      float f = VIPContactsIndexFragment.access$700(this.this$0).getHeight() * 1.5F;
      int k = Math.round(f / MailListItemView.VIEW_HEIGHT);
      if (i * j > f) {
        VIPContactsIndexFragment.access$700(this.this$0).setSelectionFromTop(k, 0);
      }
      VIPContactsIndexFragment.access$700(this.this$0).smoothScrollToPosition(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label102:
      VIPContactsIndexFragment.access$700(this.this$0).setSelectionFromTop(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment.7
 * JD-Core Version:    0.7.0.1
 */