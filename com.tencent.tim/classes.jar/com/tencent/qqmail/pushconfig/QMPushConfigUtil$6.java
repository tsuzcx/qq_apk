package com.tencent.qqmail.pushconfig;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;

final class QMPushConfigUtil$6
  extends SimpleOnProtocolListener
{
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.push_config_handle_resp_ != null)) {
      QMLog.log(4, "PushConfigUtil", "handle pushConfig download beta send success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMPushConfigUtil.6
 * JD-Core Version:    0.7.0.1
 */