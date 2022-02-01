package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import java.util.Arrays;

class QMPrivateProtocolManager$8
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$8(QMPrivateProtocolManager paramQMPrivateProtocolManager, String[] paramArrayOfString) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if (paramCloudProtocolResult.error_code_ != 0) {
      new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.SetContactType:" + Arrays.toString(this.val$address));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.8
 * JD-Core Version:    0.7.0.1
 */