package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.activity.contacts.view.ContactHeaderItemView;
import com.tencent.qqmail.model.qmdomain.MailContact;
import java.util.Iterator;
import java.util.List;

class ContactEditFragment$3$1
  implements Runnable
{
  ContactEditFragment$3$1(ContactEditFragment.3 param3, List paramList) {}
  
  public void run()
  {
    if ((this.val$emails != null) && (ContactEditFragment.access$200(this.this$1.this$0) != null) && (ContactEditFragment.access$400(this.this$1.this$0) != null))
    {
      Iterator localIterator = this.val$emails.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (ContactEditFragment.access$200(this.this$1.this$0).getAddress().equals(str)) {
          ContactEditFragment.access$400(this.this$1.this$0).setAvatarViewEmail(ContactEditFragment.access$200(this.this$1.this$0).getName(), ContactEditFragment.access$200(this.this$1.this$0).getAddress());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactEditFragment.3.1
 * JD-Core Version:    0.7.0.1
 */