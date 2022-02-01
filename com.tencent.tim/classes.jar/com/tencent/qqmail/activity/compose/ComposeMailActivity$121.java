package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateEmail;
import java.util.ArrayList;
import java.util.Iterator;

class ComposeMailActivity$121
  implements ICallBack
{
  ComposeMailActivity$121(ComposeMailActivity paramComposeMailActivity) {}
  
  public void callback(Object paramObject)
  {
    Object localObject1;
    if ((paramObject instanceof MailContact))
    {
      localObject1 = (MailContact)paramObject;
      paramObject = null;
      if (((MailContact)localObject1).getId() != 0L) {
        paramObject = QMContactManager.sharedInstance().getContactById(((MailContact)localObject1).getId());
      }
      if (paramObject != null) {
        break label322;
      }
      paramObject = QMContactManager.sharedInstance().getContactByEmailAndName(((MailContact)localObject1).getAddress(), ((MailContact)localObject1).getName());
    }
    label322:
    for (;;)
    {
      if (paramObject != null)
      {
        Object localObject2 = ComposeMailActivity.access$8600(this.this$0).getReceiver().getAddrsViewControl();
        ArrayList localArrayList = Lists.newArrayList();
        localObject2 = ((MailAddrsViewControl)localObject2).getMailAddrs().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MailContact localMailContact = (MailContact)((Iterator)localObject2).next();
          if (ValidateEmail.isMailAddressVerified(localMailContact.getAddress())) {
            localArrayList.add(localMailContact.getAddress());
          }
        }
        paramObject = ContactsFragmentActivity.createContactDetailIntent(paramObject.getId(), paramObject.getAccountId(), ((MailContact)localObject1).getAddress(), paramObject.getName(), 3, localArrayList);
        this.this$0.startActivity(paramObject);
        ComposeMailActivity.access$17102(this.this$0, true);
        return;
      }
      if (StringExtention.isNullOrEmpty(((MailContact)localObject1).getName())) {}
      for (paramObject = ((MailContact)localObject1).getAddress();; paramObject = ((MailContact)localObject1).getName() + "<" + ((MailContact)localObject1).getAddress() + ">")
      {
        paramObject = ComposeEditEmailActivity.createIntent(paramObject, ComposeMailActivity.access$17200(this.this$0).getId());
        this.this$0.startActivity(paramObject);
        this.this$0.overridePendingTransition(2130772401, 2130772423);
        return;
      }
      localObject1 = (String)paramObject;
      paramObject = localObject1;
      if (((String)localObject1).length() > 1) {
        paramObject = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
      }
      paramObject = ComposeEditEmailActivity.createIntent(paramObject, ComposeMailActivity.access$17200(this.this$0).getId());
      this.this$0.startActivity(paramObject);
      this.this$0.overridePendingTransition(2130772401, 2130772423);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.121
 * JD-Core Version:    0.7.0.1
 */