package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.NameListUIHelper;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.ArrayList;

class ContactDetailFragment$12
  implements View.OnClickListener
{
  ContactDetailFragment$12(ContactDetailFragment paramContactDetailFragment) {}
  
  public void onClick(View paramView)
  {
    String[] arrayOfString;
    if ((ContactDetailFragment.access$100(this.this$0) != null) && (ContactDetailFragment.access$100(this.this$0).getEmails() != null))
    {
      arrayOfString = new String[ContactDetailFragment.access$100(this.this$0).getEmails().size()];
      int i = 0;
      while (i < ContactDetailFragment.access$100(this.this$0).getEmails().size())
      {
        arrayOfString[i] = ((ContactEmail)ContactDetailFragment.access$100(this.this$0).getEmails().get(i)).getEmail();
        i += 1;
      }
      if (ContactDetailFragment.access$1500(this.this$0) == NameListContact.NameListContactType.WHITE.ordinal()) {
        NameListManager.sharedInstance().deleteNameList(ContactDetailFragment.access$400(this.this$0), ContactDetailFragment.access$1500(this.this$0), arrayOfString);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      NameListUIHelper.showDeleteConfirmDialog(this.this$0.getActivity(), ContactDetailFragment.access$400(this.this$0), ContactDetailFragment.access$1500(this.this$0), arrayOfString);
      continue;
      this.this$0.getTips().showError(2131690885);
      QMLog.log(6, ContactDetailFragment.TAG, "name list remove contact is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.12
 * JD-Core Version:    0.7.0.1
 */