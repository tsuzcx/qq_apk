package com.tencent.qqmail.namelist.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.namelist.NameListAdapter;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class NameListMainFragment$6
  implements AdapterView.OnItemClickListener
{
  NameListMainFragment$6(NameListMainFragment paramNameListMainFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    Object localObject1;
    if (!NameListMainFragment.access$400(this.this$0))
    {
      if (NameListMainFragment.access$300(this.this$0) == null) {
        break label282;
      }
      i = paramInt - NameListMainFragment.access$200(this.this$0).getHeaderViewsCount();
      if ((i < 0) || (i >= NameListMainFragment.access$300(this.this$0).getCount())) {
        break label282;
      }
      localObject1 = NameListMainFragment.access$300(this.this$0).getItem(i);
    }
    for (;;)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = QMContactManager.sharedInstance().getContactByAccountAndEmail(((NameListContact)localObject1).getAccountId(), ((NameListContact)localObject1).getEmail());
        if (localObject2 == null) {
          break label220;
        }
      }
      for (localObject1 = ContactsFragmentActivity.createContactDetailIntent(((MailContact)localObject2).getId(), ((MailContact)localObject2).getAccountId(), ((NameListContact)localObject1).getEmail(), ((MailContact)localObject2).getName(), 4, NameListMainFragment.access$100(this.this$0));; localObject1 = ContactsFragmentActivity.createContactDetailIntent(0L, ((NameListContact)localObject1).getAccountId(), ((NameListContact)localObject1).getEmail(), (String)localObject2, 4, NameListMainFragment.access$100(this.this$0)))
      {
        this.this$0.startActivityForResult((Intent)localObject1, 1);
        this.this$0.hideKeyBoard();
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (NameListMainFragment.access$500(this.this$0) == null) {
          break label282;
        }
        i = paramInt - NameListMainFragment.access$600(this.this$0).getHeaderViewsCount();
        if ((i < 0) || (i >= NameListMainFragment.access$500(this.this$0).getCount())) {
          break label282;
        }
        localObject1 = NameListMainFragment.access$500(this.this$0).getItem(i);
        break;
        label220:
        String str = localObject1.getEmail().split("@")[0];
        localObject2 = str;
        if (StringExtention.isNullOrEmpty(str)) {
          localObject2 = ((NameListContact)localObject1).getEmail();
        }
      }
      label282:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.6
 * JD-Core Version:    0.7.0.1
 */