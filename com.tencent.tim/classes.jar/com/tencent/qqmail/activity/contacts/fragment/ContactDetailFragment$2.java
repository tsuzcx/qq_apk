package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncContactWatcher;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class ContactDetailFragment$2
  implements SyncContactWatcher
{
  ContactDetailFragment$2(ContactDetailFragment paramContactDetailFragment) {}
  
  public void onAddError(int paramInt, ArrayList<Long> paramArrayList, ArrayList<MailContact> paramArrayList1, QMNetworkError paramQMNetworkError) {}
  
  public void onAddSuccess(int paramInt, ArrayList<Long> paramArrayList, ArrayList<MailContact> paramArrayList1)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramInt = 0;
      while (paramInt < paramArrayList.size())
      {
        if (((Long)paramArrayList.get(paramInt)).longValue() == ContactDetailFragment.access$100(this.this$0).getId())
        {
          ContactDetailFragment.access$102(this.this$0, (MailContact)paramArrayList1.get(paramInt));
          ContactDetailFragment.access$302(this.this$0, ContactDetailFragment.access$100(this.this$0).getId());
          ContactDetailFragment.access$402(this.this$0, ContactDetailFragment.access$100(this.this$0).getAccountId());
          ContactDetailFragment.access$502(this.this$0, ContactDetailFragment.access$100(this.this$0).getAddress());
          ContactDetailFragment.access$602(this.this$0, ContactDetailFragment.access$100(this.this$0).getName());
          this.this$0.refreshData();
          ContactDetailFragment.access$700(this.this$0, new ContactDetailFragment.2.1(this));
        }
        paramInt += 1;
      }
    }
  }
  
  public void onDeleteError(int paramInt, ArrayList<Long> paramArrayList, QMNetworkError paramQMNetworkError) {}
  
  public void onDeleteSuccess(int paramInt, ArrayList<Long> paramArrayList) {}
  
  public void onEditError(int paramInt, ArrayList<MailContact> paramArrayList, QMNetworkError paramQMNetworkError) {}
  
  public void onEditSuccess(int paramInt, ArrayList<MailContact> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramInt = 0;
      while (paramInt < paramArrayList.size())
      {
        MailContact localMailContact = (MailContact)paramArrayList.get(paramInt);
        if (localMailContact.getId() == ContactDetailFragment.access$100(this.this$0).getId())
        {
          ContactDetailFragment.access$102(this.this$0, localMailContact);
          ContactDetailFragment.access$302(this.this$0, ContactDetailFragment.access$100(this.this$0).getId());
          ContactDetailFragment.access$402(this.this$0, ContactDetailFragment.access$100(this.this$0).getAccountId());
          ContactDetailFragment.access$502(this.this$0, ContactDetailFragment.access$100(this.this$0).getAddress());
          ContactDetailFragment.access$602(this.this$0, ContactDetailFragment.access$100(this.this$0).getName());
          this.this$0.refreshData();
          ContactDetailFragment.access$800(this.this$0, new ContactDetailFragment.2.2(this));
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */