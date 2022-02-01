package com.tencent.qqmail.maillist.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.validate.ValidateEmail.EmailException;

class MailListFragment$26
  implements View.OnClickListener
{
  MailListFragment$26(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      Intent localIntent = LoginFragmentActivity.createIntentForMailList(AccountType.analyse(MailListFragment.access$3600(this.this$0).getPopEmail(), AccountType.other) + "", MailListFragment.access$3600(this.this$0).getPopEmail());
      this.this$0.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (ValidateEmail.EmailException localEmailException)
    {
      for (;;)
      {
        QMLog.log(6, "MailListFragment", "go add seperate account. analyse email err : " + localEmailException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.26
 * JD-Core Version:    0.7.0.1
 */