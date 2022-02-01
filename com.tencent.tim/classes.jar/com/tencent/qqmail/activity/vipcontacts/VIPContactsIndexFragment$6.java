package com.tencent.qqmail.activity.vipcontacts;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.model.qmdomain.MailContact;

class VIPContactsIndexFragment$6
  implements AdapterView.OnItemClickListener
{
  VIPContactsIndexFragment$6(VIPContactsIndexFragment paramVIPContactsIndexFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= VIPContactsIndexFragment.access$700(this.this$0).getHeaderViewsCount();
    if ((paramInt >= 0) && (paramInt < VIPContactsIndexFragment.access$600(this.this$0).getCount()))
    {
      if (paramInt != VIPContactsIndexFragment.access$600(this.this$0).getCount() - 1) {
        break label66;
      }
      VIPContactsIndexFragment.access$900(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label66:
      if (paramInt < VIPContactsIndexFragment.access$600(this.this$0).getCount() - 2)
      {
        Object localObject = VIPContactsIndexFragment.access$600(this.this$0).getItem(paramInt);
        if (((MailContact)localObject).getId() != 0L) {
          try
          {
            localObject = ContactsFragmentActivity.createContactDetailIntent(((MailContact)localObject).getId(), ((MailContact)localObject).getAccountId(), ((MailContact)localObject).getAddress(), ((MailContact)localObject).getName(), 0);
            this.this$0.startActivity((Intent)localObject);
          }
          catch (Exception localException) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment.6
 * JD-Core Version:    0.7.0.1
 */