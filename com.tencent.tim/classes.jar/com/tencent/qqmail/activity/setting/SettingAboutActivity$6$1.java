package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.PushConfig;
import com.tencent.qqmail.pushconfig.QMPushConfig;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.pushconfig.QMUpgradePushConfig;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class SettingAboutActivity$6$1
  extends SimpleOnProtocolListener
{
  SettingAboutActivity$6$1(SettingAboutActivity.6 param6) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.check_upgrade_resp_ != null))
    {
      QMLog.log(4, "SettingAboutActivity", "check upgrade success");
      paramCloudProtocolResult = paramCloudProtocolResult.check_upgrade_resp_;
      QMPushConfig localQMPushConfig = new QMPushConfig();
      localQMPushConfig.setId(paramCloudProtocolResult.id);
      localQMPushConfig.setType(paramCloudProtocolResult.type);
      localQMPushConfig.setHash(paramCloudProtocolResult.hash);
      if (paramCloudProtocolResult.content == null) {}
      for (paramCloudProtocolResult = "";; paramCloudProtocolResult = new String(paramCloudProtocolResult.content.getBytes()))
      {
        localQMPushConfig.setContent(paramCloudProtocolResult);
        paramCloudProtocolResult = new QMUpgradePushConfig(localQMPushConfig);
        paramCloudProtocolResult.parseWithDictionary();
        QMPushConfigUtil.handlePushConfig(paramCloudProtocolResult);
        QMSettingManager.sharedInstance().setNewVersionRead(true);
        Threads.runOnMainThread(new SettingAboutActivity.6.1.1(this));
        return;
      }
    }
    Threads.runOnMainThread(new SettingAboutActivity.6.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAboutActivity.6.1
 * JD-Core Version:    0.7.0.1
 */