package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.MailContact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import moai.fragment.base.BaseFragment;

class ContactsHistoryMailListFragment$4
  implements View.OnClickListener
{
  ContactsHistoryMailListFragment$4(ContactsHistoryMailListFragment paramContactsHistoryMailListFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new ArrayList();
    Iterator localIterator = ContactsHistoryMailListFragment.access$1000(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(Integer.valueOf(((Account)localIterator.next()).getId()));
    }
    localObject = new ContactFilterHistoryMailFragment((List)localObject, ContactsHistoryMailListFragment.access$1100(this.this$0), ContactsHistoryMailListFragment.access$1200(this.this$0), ContactsHistoryMailListFragment.access$1300(this.this$0).getName());
    this.this$0.startFragmentForResult((BaseFragment)localObject, 1);
    paramView.postDelayed(new ContactsHistoryMailListFragment.4.1(this), 300L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment.4
 * JD-Core Version:    0.7.0.1
 */