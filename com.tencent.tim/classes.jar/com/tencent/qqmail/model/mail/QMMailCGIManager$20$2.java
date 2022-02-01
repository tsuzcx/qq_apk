package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$20$2
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$20$2(QMMailCGIManager.20 param20, int paramInt1, int paramInt2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = null;
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    SQLiteDatabase localSQLiteDatabase = QMMailCGIManager.access$000(this.this$1.this$0).getWritableDatabase();
    QMMailCGIManager.access$1000(this.this$1.this$0, localSQLiteDatabase, this.val$accountId, false, paramQMNetworkResponse);
    for (;;)
    {
      try
      {
        arrayOfObject = QMMailCGIManager.access$1100(this.this$1.this$0, this.val$accountId, 0, paramQMNetworkResponse);
        if (arrayOfObject != null)
        {
          paramQMNetworkResponse = (String)arrayOfObject[0];
          paramQMNetworkRequest = (long[])arrayOfObject[1];
          i = ((Integer)arrayOfObject[3]).intValue();
          QMMailCGIManager.access$000(this.this$1.this$0).folder.updateSinceUTCByFolderId(localSQLiteDatabase, this.val$folderId, paramQMNetworkResponse);
          if (paramQMNetworkRequest != null) {
            DataCollector.logDetailEvent("DetailEvent_RecvMail", this.val$accountId, 0L, String.valueOf(paramQMNetworkRequest.length));
          }
          if (this.this$1.val$callback != null) {
            this.this$1.val$callback.success(paramQMNetworkRequest, false);
          }
          QMWatcherCenter.triggerLoadListSuccess(this.val$folderId, QMMailManager.LoadListType.LOAD_MORE, i, false);
          return;
        }
      }
      catch (Exception paramQMNetworkRequest)
      {
        paramQMNetworkRequest = new QMNetworkError(3, 0, "loadMore parseMail Error");
        if (this.this$1.val$callback != null) {
          this.this$1.val$callback.error(paramQMNetworkRequest);
        }
        QMWatcherCenter.triggerLoadListError(this.val$folderId, paramQMNetworkRequest);
        return;
      }
      int i = 0;
      Object[] arrayOfObject = null;
      paramQMNetworkResponse = paramQMNetworkRequest;
      paramQMNetworkRequest = arrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.20.2
 * JD-Core Version:    0.7.0.1
 */