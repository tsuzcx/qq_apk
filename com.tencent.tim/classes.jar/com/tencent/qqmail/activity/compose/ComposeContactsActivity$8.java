package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.view.ContactUIHelper;

class ComposeContactsActivity$8
  implements View.OnClickListener
{
  ComposeContactsActivity$8(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void onClick(View paramView)
  {
    ListView localListView = null;
    if (ComposeContactsActivity.access$1200(this.this$0).getVisibility() == 0)
    {
      localListView = ComposeContactsActivity.access$1200(this.this$0);
      if (localListView != null) {
        break label59;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ComposeContactsActivity.access$1300(this.this$0).getVisibility() != 0) {
        break;
      }
      localListView = ComposeContactsActivity.access$1300(this.this$0);
      break;
      label59:
      ContactUIHelper.smoothScrollToTop(localListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.8
 * JD-Core Version:    0.7.0.1
 */