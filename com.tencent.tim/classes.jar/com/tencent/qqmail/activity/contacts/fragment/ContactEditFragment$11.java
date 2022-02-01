package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import moai.fragment.base.BaseFragment;

class ContactEditFragment$11
  implements QMUIDialogAction.ActionListener
{
  ContactEditFragment$11(ContactEditFragment paramContactEditFragment, MailContact paramMailContact) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Object localObject2 = QMContactManager.sharedInstance().mergeContactsInfo(this.val$sameContact, ContactEditFragment.access$200(this.this$0));
    Object localObject1 = (MailContact)((ArrayList)localObject2).get(0);
    localObject2 = (MailContact)((ArrayList)localObject2).get(1);
    if (ContactEditFragment.access$1000(this.this$0) == ContactEditFragment.EditType.CREATE_CONTACT) {
      if (((MailContact)localObject2).getAccountId() == ((MailContact)localObject1).getAccountId())
      {
        QMContactManager.sharedInstance().syncContact((MailContact)localObject1, (MailContact)localObject1);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("edit_new_id", Long.valueOf(this.val$sameContact.getId()));
        this.this$0.setFragmentResult(-1, (HashMap)localObject1);
        if (this.this$0.from != 1) {
          break label279;
        }
        this.this$0.backToContactDetail();
      }
    }
    for (;;)
    {
      if (ContactEditFragment.access$1000(this.this$0) == ContactEditFragment.EditType.CREATE_CONTACT)
      {
        localObject1 = new ContactDetailFragment(this.val$sameContact.getId(), this.val$sameContact.getAccountId(), this.val$sameContact.getAddress(), this.val$sameContact.getName(), false);
        this.this$0.startFragment((BaseFragment)localObject1);
      }
      paramQMUIDialog.dismiss();
      return;
      QMContactManager.sharedInstance().syncContact((MailContact)localObject1, (MailContact)localObject1);
      QMContactManager.sharedInstance().syncContact((MailContact)localObject2, (MailContact)localObject2);
      break;
      if (ContactEditFragment.access$1000(this.this$0) != ContactEditFragment.EditType.MODIFY_CONTACT) {
        break;
      }
      if (((MailContact)localObject2).getAccountId() == ((MailContact)localObject1).getAccountId())
      {
        QMContactManager.sharedInstance().syncContact((MailContact)localObject1, (MailContact)localObject1);
        QMContactManager.sharedInstance().deleteContact(ContactEditFragment.access$200(this.this$0));
        break;
      }
      QMContactManager.sharedInstance().syncContact((MailContact)localObject1, (MailContact)localObject1);
      QMContactManager.sharedInstance().syncContact((MailContact)localObject2, (MailContact)localObject2);
      break;
      label279:
      this.this$0.popBackStack();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactEditFragment.11
 * JD-Core Version:    0.7.0.1
 */