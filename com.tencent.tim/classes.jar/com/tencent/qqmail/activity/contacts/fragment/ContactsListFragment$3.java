package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncContactWatcher;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class ContactsListFragment$3
  implements SyncContactWatcher
{
  ContactsListFragment$3(ContactsListFragment paramContactsListFragment) {}
  
  public void onAddError(int paramInt, ArrayList<Long> paramArrayList, ArrayList<MailContact> paramArrayList1, QMNetworkError paramQMNetworkError) {}
  
  public void onAddSuccess(int paramInt, ArrayList<Long> paramArrayList, ArrayList<MailContact> paramArrayList1)
  {
    ContactsListFragment.access$900(this.this$0, new ContactsListFragment.3.1(this));
  }
  
  public void onDeleteError(int paramInt, ArrayList<Long> paramArrayList, QMNetworkError paramQMNetworkError) {}
  
  public void onDeleteSuccess(int paramInt, ArrayList<Long> paramArrayList)
  {
    ContactsListFragment.access$1100(this.this$0, new ContactsListFragment.3.3(this));
  }
  
  public void onEditError(int paramInt, ArrayList<MailContact> paramArrayList, QMNetworkError paramQMNetworkError) {}
  
  public void onEditSuccess(int paramInt, ArrayList<MailContact> paramArrayList)
  {
    ContactsListFragment.access$1000(this.this$0, new ContactsListFragment.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.3
 * JD-Core Version:    0.7.0.1
 */