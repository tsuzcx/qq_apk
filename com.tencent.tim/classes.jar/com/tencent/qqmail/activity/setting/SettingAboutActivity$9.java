package com.tencent.qqmail.activity.setting;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;

class SettingAboutActivity$9
  implements QMUIDialogAction.ActionListener
{
  SettingAboutActivity$9(SettingAboutActivity paramSettingAboutActivity, boolean paramBoolean, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (this.val$isUpgrade)
    {
      DataCollector.logEvent("Event_Setting_Download_Upgrade_Click");
      if (!IntentUtil.intentToPriorityMarket(this.this$0, QMApplicationContext.sharedInstance().getPackageName(), true)) {
        break label42;
      }
      QMPushConfigUtil.sendDownloadUpgrade();
    }
    label42:
    while (StringExtention.isNullOrEmpty(this.val$url))
    {
      return;
      DataCollector.logEvent("Event_Setting_Download_Beta_Click");
    }
    long l = QMAttachUtils.goToDownload(this.this$0.getActivity(), this.val$url, 1, "", null);
    SettingAboutActivity.access$1400().add(Long.valueOf(l));
    Toast.makeText(this.this$0.getApplicationContext(), 2131719974, 0).show();
    if (this.val$isUpgrade)
    {
      QMPushConfigUtil.sendDownloadUpgrade();
      return;
    }
    QMPushConfigUtil.sendDownloadBeta();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAboutActivity.9
 * JD-Core Version:    0.7.0.1
 */