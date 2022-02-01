package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.view.ContactUIHelper;

class ComposeMobileContactsActivity$6
  implements View.OnClickListener
{
  ComposeMobileContactsActivity$6(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public void onClick(View paramView)
  {
    ListView localListView = null;
    if (ComposeMobileContactsActivity.access$900(this.this$0).getVisibility() == 0)
    {
      localListView = ComposeMobileContactsActivity.access$900(this.this$0);
      if (localListView != null) {
        break label59;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ComposeMobileContactsActivity.access$1000(this.this$0).getVisibility() != 0) {
        break;
      }
      localListView = ComposeMobileContactsActivity.access$1000(this.this$0);
      break;
      label59:
      ContactUIHelper.smoothScrollToTop(localListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.6
 * JD-Core Version:    0.7.0.1
 */