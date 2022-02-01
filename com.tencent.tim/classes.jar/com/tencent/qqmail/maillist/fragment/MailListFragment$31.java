package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.SyncErrorActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.SyncErrorBar;
import com.tencent.qqmail.view.SyncErrorBar.onBarItemClickListener;
import moai.oss.KvHelper;

class MailListFragment$31
  implements SyncErrorBar.onBarItemClickListener
{
  MailListFragment$31(MailListFragment paramMailListFragment) {}
  
  public void onItemClick(View paramView)
  {
    int i = MailListFragment.access$7000(this.this$0).getCode();
    QMLog.log(4, "MailListFragment", "click sync error bar:" + i);
    if (i == 3)
    {
      KvHelper.syncUnauthClick(new double[0]);
      if ((MailListFragment.access$5300(this.this$0).isQQMail()) || (MailListFragment.access$5300(this.this$0).isGMail()))
      {
        paramView = LoginFragmentActivity.createIntentForVerifyPswError(MailListFragment.access$5300(this.this$0).getId(), MailListFragment.access$5300(this.this$0).getEmail());
        this.this$0.startActivity(paramView);
        return;
      }
      paramView = LoginFragmentActivity.createIntentForSettingProtocol(MailListFragment.access$5300(this.this$0).getId(), true);
      this.this$0.startActivity(paramView);
      return;
    }
    paramView = SyncErrorActivity.createIntent(this.this$0.getActivity(), i);
    this.this$0.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.31
 * JD-Core Version:    0.7.0.1
 */