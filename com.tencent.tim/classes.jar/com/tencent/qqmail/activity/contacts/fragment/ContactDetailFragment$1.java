package com.tencent.qqmail.activity.contacts.fragment;

import android.content.res.Resources;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;
import com.tencent.qqmail.calendar.fragment.ReadScheduleFragment;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.ArrayList;
import java.util.Iterator;
import moai.fragment.app.FragmentActivity;

class ContactDetailFragment$1
  implements ContactItemViewOperateCallback
{
  ContactDetailFragment$1(ContactDetailFragment paramContactDetailFragment) {}
  
  public void callPhone(String paramString)
  {
    if (this.this$0.isAttachedToActivity()) {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131692029)).setMessage(String.format(this.this$0.getResources().getString(2131692030), new Object[] { paramString })).addAction(2131691246, new ContactDetailFragment.1.2(this))).addAction(2131696547, new ContactDetailFragment.1.1(this, paramString))).create().show();
    }
  }
  
  public void clickToCopy(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.this$0.isAttachedToActivity());
        if (ContactDetailFragment.access$000(this.this$0) != null)
        {
          Iterator localIterator = ContactDetailFragment.access$000(this.this$0).iterator();
          while (localIterator.hasNext()) {
            if (((String)localIterator.next()).equals(paramString))
            {
              this.this$0.getActivity().finish();
              return;
            }
          }
          QMContactManager.sharedInstance().postAddComposeEmailNotification(paramString, ContactDetailFragment.access$100(this.this$0).getName(), ContactDetailFragment.access$100(this.this$0).getMark(), ContactDetailFragment.access$100(this.this$0).getId());
          this.this$0.getActivity().finish();
          return;
        }
      } while (QMActivityManager.shareInstance().finishTopActivityExclusiveComposeMailActivity());
      paramString = ComposeMailActivity.createIntentWithContact(ContactDetailFragment.access$100(this.this$0).getId(), ContactDetailFragment.access$100(this.this$0).getName(), paramString, ContactDetailFragment.access$100(this.this$0).getAccountId());
      this.this$0.startActivity(paramString);
      this.this$0.overridePendingTransition(2130772401, 2130772402);
      return;
    } while (!this.this$0.isAttachedToActivity());
    CommUtils.copyText(paramString);
    this.this$0.getTips().showSuccess(this.this$0.getResources().getString(2131692025));
  }
  
  public void goToCalendar(String paramString)
  {
    if (ContactDetailFragment.access$200(this.this$0) != null)
    {
      paramString = new ReadScheduleFragment();
      paramString.prepareEvent(ContactDetailFragment.access$200(this.this$0));
      this.this$0.startFragment(paramString);
    }
  }
  
  public void notifyDataChange() {}
  
  public void removeSelf() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.1
 * JD-Core Version:    0.7.0.1
 */