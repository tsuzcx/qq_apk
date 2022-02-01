package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeContactsActivity$11
  implements AdapterView.OnItemClickListener
{
  ComposeContactsActivity$11(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (!ComposeContactsActivity.access$1500(this.this$0)) {
      if (ComposeContactsActivity.access$1400(this.this$0) != null)
      {
        i = paramInt - ComposeContactsActivity.access$1200(this.this$0).getHeaderViewsCount();
        if ((i >= 0) && (i < ComposeContactsActivity.access$1400(this.this$0).getCount())) {
          ComposeContactsActivity.access$1400(this.this$0).toggleSelected(paramView, i);
        }
      }
    }
    for (;;)
    {
      ComposeContactsActivity.access$1700(this.this$0);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (ComposeContactsActivity.access$1600(this.this$0) != null)
      {
        i = paramInt - ComposeContactsActivity.access$1300(this.this$0).getHeaderViewsCount();
        if ((i >= 0) && (i < ComposeContactsActivity.access$1600(this.this$0).getCount())) {
          ComposeContactsActivity.access$1600(this.this$0).toggleSelected(paramView, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.11
 * JD-Core Version:    0.7.0.1
 */