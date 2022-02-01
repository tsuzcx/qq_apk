package com.tencent.qqmail.activity.contacts.fragment;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsMergeChooseNameFragment$3
  implements View.OnClickListener
{
  ContactsMergeChooseNameFragment$3(ContactsMergeChooseNameFragment paramContactsMergeChooseNameFragment) {}
  
  public void onClick(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      ContactsMergeChooseNameFragment.access$300(this.this$0).smoothScrollToPosition(0, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ContactsMergeChooseNameFragment.access$300(this.this$0).setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeChooseNameFragment.3
 * JD-Core Version:    0.7.0.1
 */