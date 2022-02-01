package com.tencent.qqmail.activity.readmail.model;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;

class VirtualAdManager$3
  extends SimpleOnProtocolListener
{
  VirtualAdManager$3(VirtualAdManager paramVirtualAdManager) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "VirtualAdManager", "reportDeleteOrUnLike " + paramCloudProtocolResult.error_code_);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.model.VirtualAdManager.3
 * JD-Core Version:    0.7.0.1
 */