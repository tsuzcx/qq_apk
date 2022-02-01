package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdOpenMobileAcctRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import java.util.ArrayList;
import java.util.LinkedList;

class QMPrivateProtocolManager$24
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$24(QMPrivateProtocolManager paramQMPrivateProtocolManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    int j = 0;
    QMLog.log(4, "QMPrivateProtocolManager", "openPhoneAccount error code:" + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      Object[] arrayOfObject1 = paramCloudProtocolResult.open_mobile_acct_rsp_.exists_list.toArray();
      Object[] arrayOfObject2 = paramCloudProtocolResult.open_mobile_acct_rsp_.fail_list.toArray();
      paramCloudProtocolResult = paramCloudProtocolResult.open_mobile_acct_rsp_.success_list.toArray();
      if (this.val$callback != null)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        int k = arrayOfObject1.length;
        int i = 0;
        while (i < k)
        {
          localArrayList1.add((String)arrayOfObject1[i]);
          i += 1;
        }
        k = arrayOfObject2.length;
        i = 0;
        while (i < k)
        {
          localArrayList2.add((String)arrayOfObject2[i]);
          i += 1;
        }
        k = paramCloudProtocolResult.length;
        i = j;
        while (i < k)
        {
          localArrayList3.add((String)paramCloudProtocolResult[i]);
          i += 1;
        }
        this.val$callback.handleSuccess(localArrayList2, localArrayList3);
        this.val$callback.handleComplete(localArrayList1);
      }
      return;
    }
    new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.OpenMobileAcct");
    this.val$callback.handleError(null);
    this.val$callback.handleComplete(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.24
 * JD-Core Version:    0.7.0.1
 */