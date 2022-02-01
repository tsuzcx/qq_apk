package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.ReadMailDetailInformationView.MailContactClickListener;

class ReadMailFragment$106
  implements ReadMailDetailInformationView.MailContactClickListener
{
  ReadMailFragment$106(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView, MailContact paramMailContact, int paramInt)
  {
    paramView.setEnabled(false);
    Threads.runOnMainThread(new ReadMailFragment.106.1(this, paramView), 500L);
    paramView = paramMailContact.getAddress();
    String str1 = paramMailContact.getName();
    String str2 = QMContactManager.sharedInstance().getPossibleNickname(ReadMailFragment.access$200(this.this$0), paramView, str1, ReadMailFragment.access$000(this.this$0));
    if (paramInt == 2) {
      if (!QMActivityManager.shareInstance().finishTopActivityExclusiveComposeMailActivity())
      {
        paramView = ComposeMailActivity.createIntentWithContact(paramMailContact.getId(), str1, paramView, ReadMailFragment.access$200(this.this$0));
        this.this$0.startActivity(paramView);
      }
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        paramView = ContactsFragmentActivity.createContactCreateIntent(str2, paramView);
        this.this$0.startActivity(paramView);
        return;
      }
      if (paramInt == 0)
      {
        paramView = ContactsFragmentActivity.createContactDetailIntent(paramMailContact.getId(), ReadMailFragment.access$200(this.this$0), paramView, str2, 2);
        this.this$0.startActivity(paramView);
        return;
      }
    } while (paramInt != 3);
    this.this$0.copy(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.106
 * JD-Core Version:    0.7.0.1
 */