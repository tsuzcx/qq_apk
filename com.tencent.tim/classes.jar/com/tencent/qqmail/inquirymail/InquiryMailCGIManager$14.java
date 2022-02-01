package com.tencent.qqmail.inquirymail;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;

class InquiryMailCGIManager$14
  implements QMCallback.ISuccessCallback
{
  InquiryMailCGIManager$14(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, InquiryMail paramInquiryMail) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(3, "InquiryMailCGIManager", "retrieveMail OnSuccess account:" + this.val$accountId + " page:" + this.val$page + " edgeTime:" + this.val$edgeTime + " msgId:" + this.val$msgId);
    RequestFilter.resetRequestRunningState(this.val$requestFilterKey);
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    SQLiteDatabase localSQLiteDatabase = InquiryMailCGIManager.access$000(this.this$0).getWritableDatabase();
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        paramQMNetworkResponse = InquiryMailCGIManager.access$200(this.this$0, paramQMNetworkRequest, this.val$accountId, this.val$inquiryMail.getPage(), this.val$inquiryMail.getEdgeTime());
        if ((paramQMNetworkResponse == null) || (paramQMNetworkResponse.size() <= 0)) {
          break label322;
        }
        paramQMNetworkRequest = (InquiryMail)paramQMNetworkResponse.get(0);
        paramQMNetworkRequest = paramQMNetworkRequest.getFolder(paramQMNetworkRequest.getInboxFolderId(this.val$accountId));
      }
      catch (Exception paramQMNetworkResponse)
      {
        try
        {
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          paramQMNetworkResponse = paramQMNetworkRequest;
          if (paramQMNetworkResponse != null) {
            paramQMNetworkRequest = QMFolderManager.sharedInstance();
          }
          switch (paramQMNetworkResponse.getFolder())
          {
          case 4: 
          case 5: 
          default: 
            paramQMNetworkRequest = null;
            if (paramQMNetworkRequest != null) {
              QMMailManager.sharedInstance().updateList(paramQMNetworkRequest, false, null);
            }
            QMWatcherCenter.triggerRetrieveMailListSuccess(this.val$accountId, paramQMNetworkResponse);
            return;
          }
        }
        catch (Exception paramQMNetworkResponse)
        {
          continue;
        }
        paramQMNetworkResponse = paramQMNetworkResponse;
        paramQMNetworkRequest = null;
        QMLog.log(6, "InquiryMailCGIManager", Log.getStackTraceString(paramQMNetworkResponse));
        localSQLiteDatabase.endTransaction();
        paramQMNetworkResponse = paramQMNetworkRequest;
        continue;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      continue;
      paramQMNetworkRequest = paramQMNetworkRequest.getFolder(paramQMNetworkRequest.getSpamFolderId(this.val$accountId));
      continue;
      paramQMNetworkRequest = paramQMNetworkRequest.getFolder(paramQMNetworkRequest.getTrashFolderId(this.val$accountId));
      continue;
      label322:
      paramQMNetworkRequest = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.14
 * JD-Core Version:    0.7.0.1
 */