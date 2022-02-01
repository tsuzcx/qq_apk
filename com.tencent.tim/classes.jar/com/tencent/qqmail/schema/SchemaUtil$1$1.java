package com.tencent.qqmail.schema;

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

class SchemaUtil$1$1
  extends SimpleOnProtocolListener
{
  SchemaUtil$1$1(SchemaUtil.1 param1) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMPushConfig localQMPushConfig;
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.check_upgrade_resp_ != null))
    {
      QMLog.log(4, "SchemaUtil", "check upgrade success");
      paramCloudProtocolResult = paramCloudProtocolResult.check_upgrade_resp_;
      localQMPushConfig = new QMPushConfig();
      localQMPushConfig.setId(paramCloudProtocolResult.id);
      localQMPushConfig.setType(paramCloudProtocolResult.type);
      localQMPushConfig.setHash(paramCloudProtocolResult.hash);
      if (paramCloudProtocolResult.content != null) {
        break label128;
      }
    }
    label128:
    for (paramCloudProtocolResult = "";; paramCloudProtocolResult = new String(paramCloudProtocolResult.content.getBytes()))
    {
      localQMPushConfig.setContent(paramCloudProtocolResult);
      paramCloudProtocolResult = new QMUpgradePushConfig(localQMPushConfig);
      paramCloudProtocolResult.parseWithDictionary();
      QMPushConfigUtil.handlePushConfig(paramCloudProtocolResult);
      QMSettingManager.sharedInstance().setNewVersionRead(true);
      if (QMPushConfigUtil.showUpgradeVersion())
      {
        QMLog.log(4, "SchemaUtil", "has new version");
        Threads.runOnMainThread(new SchemaUtil.1.1.1(this), 1000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaUtil.1.1
 * JD-Core Version:    0.7.0.1
 */