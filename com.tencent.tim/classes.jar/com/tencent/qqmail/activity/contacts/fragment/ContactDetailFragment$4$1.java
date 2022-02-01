package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.activity.contacts.view.ContactHeaderItemView;
import com.tencent.qqmail.model.qmdomain.MailContact;
import java.util.Iterator;
import java.util.List;

class ContactDetailFragment$4$1
  implements Runnable
{
  ContactDetailFragment$4$1(ContactDetailFragment.4 param4, List paramList) {}
  
  public void run()
  {
    if ((this.val$emails != null) && (ContactDetailFragment.access$100(this.this$1.this$0) != null) && (ContactDetailFragment.access$1100(this.this$1.this$0) != null))
    {
      Iterator localIterator = this.val$emails.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (ContactDetailFragment.access$100(this.this$1.this$0).getAddress().equals(str)) {
          ContactDetailFragment.access$1100(this.this$1.this$0).setAvatarViewEmail(ContactDetailFragment.access$100(this.this$1.this$0).getName(), ContactDetailFragment.access$100(this.this$1.this$0).getAddress());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.4.1
 * JD-Core Version:    0.7.0.1
 */