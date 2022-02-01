package com.tencent.qqmail.folderlist;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMTopBar;

class FolderListFragment$27
  implements View.OnClickListener
{
  FolderListFragment$27(FolderListFragment paramFolderListFragment) {}
  
  public void onClick(View paramView)
  {
    if (FolderListFragment.access$4800(this.this$0))
    {
      QMLog.log(4, "FolderListFragment", "topBarRightClick enterNormalMode");
      FolderListFragment.access$5000(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (FolderListFragment.access$900())
      {
        this.this$0.gotoCompose();
      }
      else
      {
        this.this$0.showPopWindow(paramView);
        if (QMPushConfigUtil.getTopbarRightButtonHasNewUnClick())
        {
          this.this$0.getTopBar().showRedDot(false);
          QMPushConfigUtil.setTopbarRightButtonHasNewUnClick(false);
          if ((QMSettingManager.sharedInstance().getNewVersionRead()) || (!QMPushConfigUtil.showUpgradeVersion())) {
            break label127;
          }
          DataCollector.logEvent("Event_Topbar_Red_Dot_Click");
        }
        for (;;)
        {
          if ((!QMPushConfigUtil.showUpgradeVersion()) || (QMSettingManager.sharedInstance().getNewVersionRead()) || (!QMPushConfigUtil.getTopbarPopWindowHasNewUnClick())) {
            break label147;
          }
          DataCollector.logEvent("Event_Topbar_Popwindow_Red_Dot_Show");
          break;
          label127:
          if ((QMPushConfigUtil.getBetaPopWindowItem()) && (QMPushConfigUtil.showBetaVersion())) {
            DataCollector.logEvent("Event_Beta_Topbar_Red_Dot_Click");
          }
        }
        label147:
        if ((QMPushConfigUtil.showBetaVersion()) && (QMPushConfigUtil.getBetaPopWindowItem())) {
          DataCollector.logEvent("Event_Topbar_Popwindow_Beta_Show");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.27
 * JD-Core Version:    0.7.0.1
 */