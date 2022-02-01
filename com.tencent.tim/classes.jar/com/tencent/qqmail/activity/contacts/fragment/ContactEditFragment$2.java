package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncContactWatcher;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class ContactEditFragment$2
  implements SyncContactWatcher
{
  ContactEditFragment$2(ContactEditFragment paramContactEditFragment) {}
  
  public void onAddError(int paramInt, ArrayList<Long> paramArrayList, ArrayList<MailContact> paramArrayList1, QMNetworkError paramQMNetworkError) {}
  
  public void onAddSuccess(int paramInt, ArrayList<Long> paramArrayList, ArrayList<MailContact> paramArrayList1)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramInt = 0;
      while (paramInt < paramArrayList.size())
      {
        if (((Long)paramArrayList.get(paramInt)).longValue() == ContactEditFragment.access$200(this.this$0).getId())
        {
          this.this$0.refreshData();
          ContactEditFragment.access$300(this.this$0, new ContactEditFragment.2.1(this));
        }
        paramInt += 1;
      }
    }
  }
  
  public void onDeleteError(int paramInt, ArrayList<Long> paramArrayList, QMNetworkError paramQMNetworkError) {}
  
  public void onDeleteSuccess(int paramInt, ArrayList<Long> paramArrayList) {}
  
  public void onEditError(int paramInt, ArrayList<MailContact> paramArrayList, QMNetworkError paramQMNetworkError) {}
  
  public void onEditSuccess(int paramInt, ArrayList<MailContact> paramArrayList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactEditFragment.2
 * JD-Core Version:    0.7.0.1
 */