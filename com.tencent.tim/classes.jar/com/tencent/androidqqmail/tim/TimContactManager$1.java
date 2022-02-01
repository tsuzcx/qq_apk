package com.tencent.androidqqmail.tim;

import android.util.Log;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class TimContactManager$1
  implements Runnable
{
  TimContactManager$1(TimContactManager paramTimContactManager) {}
  
  public void run()
  {
    TimContactManager.access$000(this.this$0);
    TimContactManager.access$100(this.this$0).clear();
    Object localObject = QMContactManager.sharedInstance().fetchLocalCachingShowingContacts();
    Log.i("TimContactManager", "local contacts " + ((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MailContact localMailContact = (MailContact)((Iterator)localObject).next();
      if (localMailContact.getType() != MailContact.ContactType.QQFriendContact)
      {
        String str = localMailContact.getId() + "" + localMailContact.getAccountId() + localMailContact.getName();
        if (TimContactManager.access$100(this.this$0).contains(str))
        {
          Log.i("TimContactManager", "has existed " + localMailContact.getName() + "  " + str + " size " + TimContactManager.access$100(this.this$0).size());
        }
        else
        {
          TimContactManager.access$100(this.this$0).add(str);
          localMailContact = QMContactManager.sharedInstance().getContactByAccountAndEmailAndName(localMailContact.getAccountId(), localMailContact.getAddress(), localMailContact.getName());
          TimContactManager.access$200(this.this$0, localMailContact);
        }
      }
    }
    TimContactManager.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimContactManager.1
 * JD-Core Version:    0.7.0.1
 */