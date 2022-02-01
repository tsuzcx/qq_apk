package com.tencent.qqmail.pushconfig;

import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.PushConfig;
import com.tencent.qqmail.utilities.log.QMLog;

final class QMPushConfigUtil$7
  extends SimpleOnProtocolListener
{
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMPushConfig localQMPushConfig;
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.check_upgrade_resp_ != null))
    {
      QMLog.log(4, "PushConfigUtil", "check upgrade success");
      paramCloudProtocolResult = paramCloudProtocolResult.check_upgrade_resp_;
      localQMPushConfig = new QMPushConfig();
      localQMPushConfig.setId(paramCloudProtocolResult.id);
      localQMPushConfig.setType(paramCloudProtocolResult.type);
      localQMPushConfig.setHash(paramCloudProtocolResult.hash);
      if (paramCloudProtocolResult.content != null) {
        break label93;
      }
    }
    label93:
    for (paramCloudProtocolResult = "";; paramCloudProtocolResult = new String(paramCloudProtocolResult.content.getBytes()))
    {
      localQMPushConfig.setContent(paramCloudProtocolResult);
      paramCloudProtocolResult = new QMUpgradePushConfig(localQMPushConfig);
      paramCloudProtocolResult.parseWithDictionary();
      QMPushConfigUtil.handlePushConfig(paramCloudProtocolResult);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMPushConfigUtil.7
 * JD-Core Version:    0.7.0.1
 */