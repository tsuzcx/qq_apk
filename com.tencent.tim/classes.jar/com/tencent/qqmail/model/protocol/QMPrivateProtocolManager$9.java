package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import java.util.Arrays;

class QMPrivateProtocolManager$9
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$9(QMPrivateProtocolManager paramQMPrivateProtocolManager, String[] paramArrayOfString) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if (paramCloudProtocolResult.error_code_ != 0) {
      new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.ClearContactType:" + Arrays.toString(this.val$address));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.9
 * JD-Core Version:    0.7.0.1
 */