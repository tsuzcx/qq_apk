package com.tencent.qqmail.calendar.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.note.ReadNoteActivity;
import com.tencent.qqmail.utilities.ui.QMTips;

class ReadScheduleFragment$15
  implements View.OnClickListener
{
  ReadScheduleFragment$15(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadScheduleFragment.access$100(this.this$0) == null) {
      this.this$0.getTips().showError(2131691092);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AccountManager.shareInstance().getAccountList().getAccountById(ReadScheduleFragment.access$100(this.this$0).getRelateAccountId()) != null)
      {
        Object localObject;
        if (ReadScheduleFragment.access$100(this.this$0).getRelateType() == 1)
        {
          if (QMMailManager.sharedInstance().getMailInfoByRemoteId(ReadScheduleFragment.access$100(this.this$0).getRelateAccountId(), ReadScheduleFragment.access$100(this.this$0).getRelatedId()) == null)
          {
            this.this$0.getTips().showError(2131691092);
          }
          else
          {
            localObject = ReadScheduleFragment.access$100(this.this$0).getRelatedId();
            QMActivityManager.shareInstance().finishAllActivity();
            localObject = MailFragmentActivity.createIntentToReadmailById(ReadScheduleFragment.access$100(this.this$0).getRelateAccountId(), (String)localObject);
            this.this$0.startActivity((Intent)localObject);
          }
        }
        else if (ReadScheduleFragment.access$100(this.this$0).getRelateType() == 2)
        {
          localObject = ReadScheduleFragment.access$100(this.this$0).getRelatedId();
          QMActivityManager.shareInstance().finishAllActivity();
          Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ReadNoteActivity.class);
          localIntent.putExtra("position", 0);
          localIntent.putExtra("noteId", (String)localObject);
          this.this$0.startActivity(localIntent);
        }
      }
      else if (ReadScheduleFragment.access$100(this.this$0).getRelateType() == 1)
      {
        this.this$0.getTips().showError(2131691092);
      }
      else if (ReadScheduleFragment.access$100(this.this$0).getRelateType() == 2)
      {
        this.this$0.getTips().showError(2131691093);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.15
 * JD-Core Version:    0.7.0.1
 */