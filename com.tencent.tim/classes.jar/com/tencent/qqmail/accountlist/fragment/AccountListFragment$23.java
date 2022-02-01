package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMTopBar;

class AccountListFragment$23
  implements View.OnClickListener
{
  AccountListFragment$23(AccountListFragment paramAccountListFragment) {}
  
  public void onClick(View paramView)
  {
    if (AccountListFragment.access$1100(this.this$0))
    {
      QMLog.log(4, "AccountListFragment", "topBarRightClick toggleEditMode");
      AccountListFragment.access$1900(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.showPopMenuWindow(paramView);
      if (QMPushConfigUtil.getTopbarRightButtonHasNewUnClick())
      {
        if ((QMSettingManager.sharedInstance().getNewVersionRead()) || (!QMPushConfigUtil.showUpgradeVersion())) {
          break label111;
        }
        DataCollector.logEvent("Event_Topbar_Red_Dot_Click");
      }
      for (;;)
      {
        this.this$0.getTopBar().showRedDot(false);
        QMPushConfigUtil.setTopbarRightButtonHasNewUnClick(false);
        if ((!QMPushConfigUtil.showUpgradeVersion()) || (QMSettingManager.sharedInstance().getNewVersionRead()) || (!QMPushConfigUtil.getTopbarPopWindowHasNewUnClick())) {
          break label131;
        }
        DataCollector.logEvent("Event_Topbar_Popwindow_Red_Dot_Show");
        break;
        label111:
        if ((QMPushConfigUtil.getBetaPopWindowItem()) && (QMPushConfigUtil.showBetaVersion())) {
          DataCollector.logEvent("Event_Beta_Topbar_Red_Dot_Click");
        }
      }
      label131:
      if ((QMPushConfigUtil.showBetaVersion()) && (QMPushConfigUtil.getBetaPopWindowItem())) {
        DataCollector.logEvent("Event_Topbar_Popwindow_Beta_Show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.23
 * JD-Core Version:    0.7.0.1
 */