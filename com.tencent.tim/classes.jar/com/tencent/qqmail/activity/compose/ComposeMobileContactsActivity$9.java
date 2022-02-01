package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeMobileContactsActivity$9
  implements AdapterView.OnItemClickListener
{
  ComposeMobileContactsActivity$9(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (!ComposeMobileContactsActivity.access$1200(this.this$0)) {
      if (ComposeMobileContactsActivity.access$1100(this.this$0) != null)
      {
        i = paramInt - ComposeMobileContactsActivity.access$900(this.this$0).getHeaderViewsCount();
        if ((i >= 0) && (i < ComposeMobileContactsActivity.access$1100(this.this$0).getCount())) {
          ComposeMobileContactsActivity.access$1100(this.this$0).toggleSelected(paramView, i);
        }
      }
    }
    for (;;)
    {
      ComposeMobileContactsActivity.access$1400(this.this$0);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (ComposeMobileContactsActivity.access$1300(this.this$0) != null)
      {
        i = paramInt - ComposeMobileContactsActivity.access$1000(this.this$0).getHeaderViewsCount();
        if ((i >= 0) && (i < ComposeMobileContactsActivity.access$1300(this.this$0).getCount())) {
          ComposeMobileContactsActivity.access$1300(this.this$0).toggleSelected(paramView, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.9
 * JD-Core Version:    0.7.0.1
 */