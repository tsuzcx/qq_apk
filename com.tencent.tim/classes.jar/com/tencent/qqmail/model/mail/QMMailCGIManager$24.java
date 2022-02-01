package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class QMMailCGIManager$24
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$24(QMMailCGIManager paramQMMailCGIManager, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      StringBuilder localStringBuilder;
      try
      {
        localArrayList1 = QMMailParser.parseMails(this.val$accountId, paramQMNetworkResponse);
        if ((localArrayList1 == null) || (localArrayList1.size() <= 0)) {
          break label448;
        }
        localArrayList2 = new ArrayList();
        paramQMNetworkRequest = AccountManager.shareInstance().getAccountList().getAccountById(this.val$accountId);
        if (paramQMNetworkRequest == null) {
          break label422;
        }
        localStringBuilder = new StringBuilder("updateListAll, account: " + paramQMNetworkRequest.getEmail() + ", mailNum: " + localArrayList1.size() + ", foreground: " + AppStatusUtil.isAppOnForeground());
        Iterator localIterator = localArrayList1.iterator();
        if (!localIterator.hasNext()) {
          break label411;
        }
        Mail localMail = (Mail)localIterator.next();
        MailInformation localMailInformation = localMail.getInformation();
        if (localMailInformation == null) {
          continue;
        }
        QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(localMailInformation.getFolderId());
        if (localQMFolder == null) {
          continue;
        }
        long l;
        if (localMailInformation.getDate() != null)
        {
          l = System.currentTimeMillis() - localMailInformation.getDate().getTime();
          if (localMailInformation.getFrom() == null) {
            break label406;
          }
          paramQMNetworkRequest = localMailInformation.getFrom().getAddress();
          localStringBuilder.append(", [").append(localMailInformation.getSubject()).append("/").append(localMailInformation.getRemoteId()).append("/").append(l).append("/").append(localQMFolder).append("/").append(paramQMNetworkRequest).append("]");
        }
        switch (localQMFolder.getType())
        {
        case 0: 
        case 1: 
        case 8: 
        case 12: 
        case 15: 
          if ((!localQMFolder.isPush()) || (localArrayList2.size() > 10)) {
            continue;
          }
          localArrayList2.add(localMail);
          continue;
          l = -9223372036854775808L;
        }
      }
      catch (Exception paramQMNetworkRequest)
      {
        QMWatcherCenter.triggerLoadListError(0, new QMNetworkError(3, 0, "updateListAll parseMail Error: " + paramQMNetworkRequest.toString()));
        return;
      }
      continue;
      label406:
      paramQMNetworkRequest = null;
      continue;
      label411:
      QMLog.log(4, "QMMailCGIManager", localStringBuilder.toString());
      label422:
      if ((localArrayList2.size() > 0) && (AppStatusUtil.isAppOnBackGround())) {
        QMMailManager.sharedInstance().postSyncResult(localArrayList2, "updatelistall");
      }
      label448:
      paramQMNetworkResponse = QMMailCGIManager.access$1600(this.this$0, localArrayList1, 0, this.val$accountId, paramQMNetworkResponse, false);
      int i;
      if (paramQMNetworkResponse != null)
      {
        paramQMNetworkRequest = (long[])paramQMNetworkResponse[1];
        i = ((Integer)paramQMNetworkResponse[3]).intValue();
      }
      for (;;)
      {
        if (paramQMNetworkRequest != null) {
          DataCollector.logDetailEvent("DetailEvent_RecvMail", this.val$accountId, 0L, String.valueOf(i));
        }
        QMMailCGIManager.access$1500(this.this$0).updateEntrance(this.val$accountId);
        QMWatcherCenter.triggerLoadListSuccess(0, QMMailManager.LoadListType.UPDATE_LIST, i, false);
        paramQMNetworkRequest = QMMailCGIManager.access$000(this.this$0).folder.getFolderById(QMMailCGIManager.access$1800(this.this$0).getInboxFolderId(this.val$accountId));
        if ((paramQMNetworkRequest == null) || (!paramQMNetworkRequest.isOverdue())) {
          break;
        }
        this.this$0.updateList(paramQMNetworkRequest, true);
        return;
        i = 0;
        paramQMNetworkRequest = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.24
 * JD-Core Version:    0.7.0.1
 */