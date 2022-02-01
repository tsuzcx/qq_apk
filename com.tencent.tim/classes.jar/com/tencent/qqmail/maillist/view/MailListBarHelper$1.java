package com.tencent.qqmail.maillist.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.accountlist.QMAccountHelper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMTips;
import moai.oss.KvHelper;

final class MailListBarHelper$1
  implements View.OnClickListener
{
  MailListBarHelper$1(RelativeLayout paramRelativeLayout, QMTips paramQMTips, QMFolder paramQMFolder) {}
  
  public void onClick(View paramView)
  {
    this.val$folderTopOrShowHomeBar.setVisibility(8);
    if (MailListBarHelper.access$000())
    {
      this.val$tips.showInfo(2131693926);
      QMNotification.postNotification("folder_top_tip_click", this.val$folder);
      KvHelper.eventFolderBarShowSetTopClick(new double[0]);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (MailListBarHelper.access$100())
      {
        this.val$tips.showInfo(2131693921);
        AccountList localAccountList = AccountManager.shareInstance().getAccountList();
        QMAccountHelper.addActiveFolderToDB(this.val$folder, localAccountList);
        QMNotification.postNotification("folder_show_home_tip_click", this.val$folder);
        KvHelper.eventFolderBarShowMailBoxClick(new double[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.view.MailListBarHelper.1
 * JD-Core Version:    0.7.0.1
 */