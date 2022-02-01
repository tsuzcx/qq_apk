package com.tencent.qqmail.activity.contacts.fragment;

import android.content.Intent;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.fragment.app.FragmentActivity;

class ContactDetailFragment$7$1
  implements QMUIDialogAction.ActionListener
{
  ContactDetailFragment$7$1(ContactDetailFragment.7 param7) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (AccountManager.shareInstance().getAccountList().getAccountById(ContactDetailFragment.access$100(this.this$1.this$0).getAccountId()).isQQMail()) {
      QMContactManager.sharedInstance().deleteContact(ContactDetailFragment.access$100(this.this$1.this$0));
    }
    for (;;)
    {
      if (this.this$1.this$0.getBaseFragmentActivity() != null)
      {
        this.this$1.this$0.getActivity().finish();
        Intent localIntent = ContactsFragmentActivity.createContactsListIntent();
        this.this$1.this$0.startActivity(localIntent);
      }
      paramQMUIDialog.dismiss();
      DataCollector.logEvent("Event_Delete_Contact_Click");
      return;
      QMContactManager.sharedInstance().deleteContactLocal(ContactDetailFragment.access$100(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.7.1
 * JD-Core Version:    0.7.0.1
 */