package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Iterator;

class ContactsListAdapter$1
  implements Runnable
{
  ContactsListAdapter$1(ContactsListAdapter paramContactsListAdapter) {}
  
  public void run()
  {
    Iterator localIterator = QMContactManager.sharedInstance().getCheckedAccountIds().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Integer)localIterator.next();
      localObject1 = QMComposeDataManager.sharedInstance().getQMAlias(((Integer)localObject1).intValue());
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          ContactsListAdapter.access$000(this.this$0).add(localObject2);
          i += 1;
        }
      }
    }
    Threads.runOnMainThread(new ContactsListAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListAdapter.1
 * JD-Core Version:    0.7.0.1
 */