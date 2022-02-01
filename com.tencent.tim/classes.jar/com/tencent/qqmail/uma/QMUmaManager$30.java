package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.ContactListInfo;
import com.tencent.qqmail.protocol.UMA.ContactSyncListResp;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import java.util.LinkedList;
import rx.functions.Action1;

class QMUmaManager$30
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$30(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      ContactSyncListResp localContactSyncListResp = new ContactSyncListResp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.contact_sync_info_list_ = ((ContactListInfo[])localContactSyncListResp.listinfos.toArray(new ContactListInfo[localContactSyncListResp.listinfos.size()]));
      localCloudProtocolResult.error_code_ = 0;
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general result.contact_sync_info_list_ error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.30
 * JD-Core Version:    0.7.0.1
 */