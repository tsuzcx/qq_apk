package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class QMMailCGIManager$21
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$21(QMMailCGIManager paramQMMailCGIManager, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = null;
    for (paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();; paramQMNetworkResponse = null)
    {
      try
      {
        Object[] arrayOfObject = QMMailCGIManager.access$1100(this.this$0, this.val$accountId, 0, paramQMNetworkResponse);
        if (arrayOfObject != null)
        {
          paramQMNetworkResponse = (String)arrayOfObject[0];
          paramQMNetworkRequest = (long[])arrayOfObject[1];
          i = ((Integer)arrayOfObject[3]).intValue();
          QMMailCGIManager.access$000(this.this$0).folder.updateSinceUTCByAccountId(QMMailCGIManager.access$000(this.this$0).getWritableDatabase(), this.val$accountId, paramQMNetworkResponse);
          if (paramQMNetworkRequest != null) {
            DataCollector.logDetailEvent("DetailEvent_RecvMail", this.val$accountId, 0L, String.valueOf(i));
          }
          QMMailCGIManager.access$1500(this.this$0).updateEntrance(this.val$accountId);
          QMWatcherCenter.triggerLoadListSuccess(0, QMMailManager.LoadListType.LOAD_LIST, i, false);
          if ((QMNetworkUtils.isWifiConnected()) && (this.val$accountId != 0)) {
            this.this$0.preloadSubscribes(this.val$accountId, SubscribeMail.LOAD_MORE_PER_COUNT);
          }
          return;
        }
      }
      catch (Exception paramQMNetworkRequest)
      {
        QMWatcherCenter.triggerLoadListError(0, new QMNetworkError(3, 0, "loadListAll parseMail Error: " + paramQMNetworkRequest.toString()));
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.21
 * JD-Core Version:    0.7.0.1
 */