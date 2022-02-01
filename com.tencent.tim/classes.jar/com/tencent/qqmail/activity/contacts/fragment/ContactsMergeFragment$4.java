package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMTopBar;

class ContactsMergeFragment$4
  implements View.OnClickListener
{
  ContactsMergeFragment$4(ContactsMergeFragment paramContactsMergeFragment, QMTopBar paramQMTopBar) {}
  
  public void onClick(View paramView)
  {
    if (ContactsMergeFragment.access$800(this.this$0) < ContactsMergeFragment.access$900(this.this$0))
    {
      ContactsMergeFragment.access$1000(this.this$0, true);
      ContactsMergeFragment.access$802(this.this$0, ContactsMergeFragment.access$900(this.this$0));
      this.val$topBar.setButtonRightNormal(2131719470);
      ContactsMergeFragment.access$1100(this.this$0);
    }
    for (;;)
    {
      ContactsMergeFragment.access$1300(this.this$0).notifyDataSetChanged();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ContactsMergeFragment.access$1000(this.this$0, false);
      ContactsMergeFragment.access$802(this.this$0, 0);
      this.val$topBar.setButtonRightNormal(2131719469);
      ContactsMergeFragment.access$1200(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeFragment.4
 * JD-Core Version:    0.7.0.1
 */