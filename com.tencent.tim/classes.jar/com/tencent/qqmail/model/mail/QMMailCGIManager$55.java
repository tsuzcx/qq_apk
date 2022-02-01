package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailRecall;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;

class QMMailCGIManager$55
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$55(QMMailCGIManager paramQMMailCGIManager, long paramLong, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    int k = 1;
    int j = 1;
    int i = 0;
    QMLog.log(4, "QMMailCGIManager", "recallMailQuery Success:" + paramQMNetworkResponse.getResponseString());
    ArrayList localArrayList = new ArrayList();
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if (paramQMNetworkRequest != null)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int m;
        try
        {
          localObject1 = paramQMNetworkRequest.getString("errcode");
          localObject2 = paramQMNetworkRequest.getString("maildatacnt");
          if ((localObject1 == null) || (((String)localObject1).equals("")) || (localObject2 == null) || (((String)localObject2).equals(""))) {
            break label461;
          }
          long l = Long.valueOf((String)localObject1).longValue();
          if ((Long.valueOf((String)localObject2).longValue() <= 0L) || (l != 0L)) {
            break label461;
          }
          paramQMNetworkRequest = paramQMNetworkRequest.getJSONArray("maildata");
          if (paramQMNetworkRequest == null) {
            break label461;
          }
          m = paramQMNetworkRequest.size();
          if (m <= 0) {
            break label461;
          }
          j = 0;
          i = 0;
        }
        catch (Exception paramQMNetworkRequest) {}
        try
        {
          if (j < paramQMNetworkRequest.size())
          {
            localObject1 = paramQMNetworkRequest.getJSONObject(j);
            localObject2 = new MailRecall();
            ((MailRecall)localObject2).setMid(this.val$mailId);
            ((MailRecall)localObject2).setReceiver(((JSONObject)localObject1).getString("receiver"));
            ((MailRecall)localObject2).setStatus(((JSONObject)localObject1).getInteger("status").intValue());
            ((MailRecall)localObject2).setId(MailRecall.generateId(((MailRecall)localObject2).getMid(), ((MailRecall)localObject2).getReceiver(), ((MailRecall)localObject2).getStatus()));
            localArrayList.add(localObject2);
            if (((MailRecall)localObject2).getStatus() != 0)
            {
              m = ((MailRecall)localObject2).getStatus();
              if (m != 1) {
                continue;
              }
            }
          }
        }
        catch (Exception paramQMNetworkRequest)
        {
          break label395;
        }
        try
        {
          QMLog.log(4, "QMMailCGIManager", "recallMailQuery hasInitReceiver " + ((MailRecall)localObject2).getReceiver() + ":" + ((MailRecall)localObject2).getStatus());
          i = 1;
          j += 1;
        }
        catch (Exception paramQMNetworkRequest)
        {
          i = 1;
          break label395;
        }
      }
      j = 0;
    }
    for (;;)
    {
      if ((j == 0) && (i == 0))
      {
        QMMailCGIManager.access$000(this.this$0).mail.insertMailRecall(QMMailCGIManager.access$000(this.this$0).getWritableDatabase(), localArrayList);
        if (this.val$callback != null) {
          this.val$callback.handleSuccess(Long.valueOf(this.val$mailId), paramQMNetworkResponse);
        }
        QMWatcherCenter.triggerQueryRecallMailSuccess(this.val$mailId);
        return;
        label395:
        QMLog.log(6, "QMMailCGIManager", Log.getStackTraceString(paramQMNetworkRequest));
        j = k;
      }
      else
      {
        paramQMNetworkRequest = new QMNetworkError(3, -10015, "撤回邮件失败");
        if (this.val$callback != null) {
          this.val$callback.handleError(paramQMNetworkRequest);
        }
        QMWatcherCenter.triggerQueryRecallMailError(this.val$mailId, paramQMNetworkRequest);
        return;
        label461:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.55
 * JD-Core Version:    0.7.0.1
 */