package com.tencent.qqmail.activity.contacts.fragment;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class ContactDetailFragment$8
  implements View.OnClickListener
{
  ContactDetailFragment$8(ContactDetailFragment paramContactDetailFragment) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        if (this.this$0.from != 3) {
          continue;
        }
        localContactEditFragment = new ContactEditFragment(ContactDetailFragment.access$100(this.this$0), ContactDetailFragment.access$100(this.this$0), false, this.this$0.from, ContactDetailFragment.access$500(this.this$0));
        this.this$0.startFragmentForResult(localContactEditFragment, 100);
      }
      catch (Exception localException)
      {
        ContactEditFragment localContactEditFragment;
        QMLog.log(6, ContactDetailFragment.TAG, Log.getStackTraceString(localException));
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localContactEditFragment = new ContactEditFragment(ContactDetailFragment.access$100(this.this$0), ContactDetailFragment.access$100(this.this$0), false, this.this$0.from);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.8
 * JD-Core Version:    0.7.0.1
 */