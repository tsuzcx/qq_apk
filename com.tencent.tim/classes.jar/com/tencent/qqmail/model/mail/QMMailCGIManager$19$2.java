package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class QMMailCGIManager$19$2
  implements QMCallback.ISuccessCallback
{
  private long[] mailIds = new long[0];
  private int[] newMailCount = { 0 };
  
  QMMailCGIManager$19$2(QMMailCGIManager.19 param19, int paramInt, Account paramAccount, ArrayList paramArrayList) {}
  
  private void updateListOperation(JSONObject paramJSONObject, ArrayList<Mail> paramArrayList, QMFolder paramQMFolder, Integer paramInteger, int paramInt, ArrayList<Object[]> paramArrayList1, SQLiteDatabase paramSQLiteDatabase)
  {
    QMMailCGIManager.access$1000(this.this$1.this$0, paramSQLiteDatabase, paramInt, this.this$1.val$preload, paramJSONObject);
    for (;;)
    {
      try
      {
        paramQMFolder = QMMailCGIManager.access$1600(this.this$1.this$0, paramArrayList, 2048, paramInt, paramJSONObject, true);
        if (paramQMFolder == null) {
          break label308;
        }
        paramArrayList = (String)paramQMFolder[0];
        this.mailIds = ((long[])paramQMFolder[1]);
        this.newMailCount[0] = ((Integer)paramQMFolder[3]).intValue();
        QMMailCGIManager.access$000(this.this$1.this$0).folder.updateSinceUTCByFolderId(paramSQLiteDatabase, paramInteger.intValue(), paramArrayList);
        if (this.mailIds != null) {
          DataCollector.logDetailEvent("DetailEvent_RecvMail", paramInt, 0L, String.valueOf(this.mailIds.length));
        }
        paramArrayList = QMMailParser.parseIndexes(paramJSONObject);
        paramJSONObject = new String[0];
        if (paramArrayList.values().iterator().hasNext()) {
          paramJSONObject = (String[])paramArrayList.values().iterator().next();
        }
        paramJSONObject = QMMailCGIManager.access$1700(this.this$1.this$0, paramSQLiteDatabase, paramInt, paramArrayList1, paramJSONObject, new QMMailCGIManager.19.2.2(this, paramSQLiteDatabase, paramInt));
        if ((paramJSONObject != null) && (paramJSONObject.length > 0)) {
          this.this$1.this$0.preloadMails(paramInt, paramJSONObject, this.this$1.val$withoutSession);
        }
        int i = paramInteger.intValue();
        paramArrayList = QMMailManager.LoadListType.PRELOAD_LIST;
        if (paramJSONObject != null)
        {
          paramInt = paramJSONObject.length;
          QMWatcherCenter.triggerLoadListSuccess(i, paramArrayList, paramInt, false);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QMWatcherCenter.triggerLoadListError(paramInteger.intValue(), new QMNetworkError(3, 0, "updatelist parseMail Error: " + paramJSONObject.toString()));
        return;
      }
      paramInt = 0;
      continue;
      label308:
      paramArrayList = null;
    }
  }
  
  private void updateListSuccess(QMFolder paramQMFolder, Integer paramInteger, int paramInt, Account paramAccount, ArrayList<Object[]> paramArrayList, QMNetworkResponse paramQMNetworkResponse)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      StringBuilder localStringBuilder;
      int i;
      try
      {
        localJSONObject = (JSONObject)paramQMNetworkResponse.getResponseJson();
        localArrayList1 = QMMailParser.parseMails(paramInt, localJSONObject);
        if ((localArrayList1 == null) || (localArrayList1.size() <= 0)) {
          break label446;
        }
        localArrayList2 = new ArrayList();
        localStringBuilder = new StringBuilder("updateList, account: " + paramAccount.getEmail() + ", folder: " + paramQMFolder + ", mailNum: " + localArrayList1.size() + ", foreground: " + AppStatusUtil.isAppOnForeground());
        i = paramQMFolder.getType();
        if (!paramQMFolder.isPush()) {
          break label377;
        }
        if ((i == 1) || (i == 0) || (i == 12) || (i == 8)) {
          break label482;
        }
        if (i != 15) {
          break label377;
        }
      }
      catch (Exception paramQMFolder)
      {
        Iterator localIterator;
        Mail localMail;
        String str1;
        String str2;
        paramQMFolder = new QMNetworkError(3, 0, "updateList parseMail Error");
        if (this.this$1.val$callback == null) {
          continue;
        }
        this.this$1.val$callback.error(paramQMFolder);
        QMWatcherCenter.triggerLoadListError(paramInteger.intValue(), paramQMFolder);
        return;
      }
      localIterator = localArrayList1.iterator();
      if (localIterator.hasNext())
      {
        localMail = (Mail)localIterator.next();
        paramQMNetworkResponse = localMail.getInformation();
        if (paramQMNetworkResponse != null)
        {
          str1 = paramQMNetworkResponse.getSubject();
          str2 = paramQMNetworkResponse.getRemoteId();
          long l;
          if (paramQMNetworkResponse.getDate() != null)
          {
            l = System.currentTimeMillis() - paramQMNetworkResponse.getDate().getTime();
            if (paramQMNetworkResponse.getFrom() != null)
            {
              paramQMNetworkResponse = paramQMNetworkResponse.getFrom().getAddress();
              localStringBuilder.append(", [").append(str1).append("/").append(str2).append("/").append(l).append("/").append(paramQMNetworkResponse).append("]");
              if ((i == 0) || (localArrayList2.size() > 10)) {
                continue;
              }
              localArrayList2.add(localMail);
              continue;
              label377:
              i = 0;
            }
          }
          else
          {
            l = -9223372036854775808L;
            continue;
          }
          paramQMNetworkResponse = null;
        }
      }
      else
      {
        QMLog.log(4, "QMMailCGIManager", localStringBuilder.toString());
        if ((!this.this$1.val$withoutSession) && (localArrayList2.size() > 0) && (AppStatusUtil.isAppOnBackGround())) {
          QMMailManager.sharedInstance().postSyncResult(localArrayList2, "updatelist");
        }
        label446:
        QMMailCGIManager.access$1500(this.this$1.this$0).withFolderUnreadCount(paramAccount.getId(), new QMMailCGIManager.19.2.1(this, paramInteger, localJSONObject, localArrayList1, paramQMFolder, paramInt, paramArrayList));
        return;
        label482:
        i = 1;
      }
    }
  }
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    updateListSuccess(this.this$1.val$folder, this.this$1.val$folderId, this.val$accountId, this.val$account, this.val$incrementalMailIds, paramQMNetworkResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.19.2
 * JD-Core Version:    0.7.0.1
 */