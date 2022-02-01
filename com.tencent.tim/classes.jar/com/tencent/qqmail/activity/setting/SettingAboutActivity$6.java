package com.tencent.qqmail.activity.setting;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.WelcomePagesActivity;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.UMA.CheckUpgradeReq;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingAboutActivity$6
  implements UITableView.ClickListener
{
  SettingAboutActivity$6(SettingAboutActivity paramSettingAboutActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingAboutActivity.access$700(this.this$0))
    {
      paramUITableItemView = SimpleWebViewExplorer.createIntent("https://i.mail.qq.com/app/app_intro_android_5.3.3.html", this.this$0.getString(2131719880), SimpleWebViewExplorer.TOPBAR_LEFT_ICON);
      this.this$0.startActivity(paramUITableItemView);
    }
    do
    {
      return;
      if (paramUITableItemView == SettingAboutActivity.access$800(this.this$0))
      {
        IntentUtil.intentToPriorityMarket(this.this$0, QMApplicationContext.sharedInstance().getPackageName(), false);
        return;
      }
      if (paramUITableItemView == SettingAboutActivity.access$900(this.this$0))
      {
        DataCollector.logEvent("Event_Click_History_Splash_List");
        paramUITableItemView = SimpleWebViewExplorer.createIntent("http://i.mail.qq.com/cgi-bin/uma_get_cards", this.this$0.getString(2131719972), SimpleWebViewExplorer.TOPBAR_LEFT_ICON);
        this.this$0.startActivity(paramUITableItemView);
        return;
      }
      if (paramUITableItemView == SettingAboutActivity.access$1000(this.this$0))
      {
        paramUITableItemView = WelcomePagesActivity.createIntent("", true);
        this.this$0.startActivity(paramUITableItemView);
        this.this$0.overridePendingTransition(2130772024, 2130772430);
        return;
      }
    } while (paramUITableItemView != SettingAboutActivity.access$500(this.this$0));
    if (SettingAboutActivity.access$1100(this.this$0))
    {
      if (QMPushConfigUtil.getUpgradeItemShowNew())
      {
        QMPushConfigUtil.setUpgradeItemShowNew(false);
        SettingAboutActivity.access$500(this.this$0).showNew(false);
      }
      SettingAboutActivity.access$1200(this.this$0);
      DataCollector.logEvent("Event_Setting_Upgrade_Click");
      return;
    }
    if (SettingAboutActivity.access$1300(this.this$0))
    {
      if (QMPushConfigUtil.getBetaItemShowNew())
      {
        QMPushConfigUtil.setBetaItemShowNew(false);
        SettingAboutActivity.access$500(this.this$0).showNew(false);
      }
      SettingAboutActivity.access$600(this.this$0);
      DataCollector.logEvent("Event_Setting_Join_Beta_Click");
      return;
    }
    DataCollector.logEvent("Event_Setting_Check_Version_Click");
    QMLog.log(4, "SettingAboutActivity", "click check upgrade version!");
    paramUITableItemView = CloudProtocolHelper.getCommonInfo();
    CheckUpgradeReq localCheckUpgradeReq = new CheckUpgradeReq();
    localCheckUpgradeReq.version = new ByteString(AppConfig.getCodeVersion().getBytes());
    paramUITableItemView.check_upgrade_req_ = localCheckUpgradeReq;
    CloudProtocolService.CheckUpgrade(paramUITableItemView, new SettingAboutActivity.6.1(this));
    Toast.makeText(this.this$0.getApplicationContext(), 2131719973, 0).show();
    SettingAboutActivity.access$500(this.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAboutActivity.6
 * JD-Core Version:    0.7.0.1
 */