package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.tencent.androidqqmail.tim.TimNotificationManager;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.callback.MailListCallback;
import com.tencent.qqmail.model.mail.rule.QMRuleManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class QMMailProtocolManager$19
  implements MailListCallback
{
  StringBuilder mRecvMailLog = new StringBuilder("fetchMailList, foreground: ").append(AppStatusUtil.isAppOnForeground()).append(", account: ").append(this.val$account.getEmail()).append(", folder: ").append(this.val$folder);
  
  QMMailProtocolManager$19(QMMailProtocolManager paramQMMailProtocolManager, Account paramAccount, QMFolder paramQMFolder, IListCallback paramIListCallback, int[] paramArrayOfInt1, ArrayList paramArrayList1, int[] paramArrayOfInt2, HashSet paramHashSet, ArrayList paramArrayList2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {}
  
  public void onRetrieveError(QMProtocolError paramQMProtocolError)
  {
    if (this.val$callback != null) {
      this.val$callback.error(paramQMProtocolError);
    }
    QMWatcherCenter.triggerLoadListError(this.val$folderId, paramQMProtocolError);
    this.mRecvMailLog.insert(15, "onRetrieveError, ");
    this.mRecvMailLog.append(", error: ").append(paramQMProtocolError);
    QMLog.log(5, "QMMailProtocolManager", this.mRecvMailLog.toString());
  }
  
  public void onRetrieveMail(Mail paramMail)
  {
    int i = this.val$folder.getId();
    int j = QMMailProtocolManager.access$100(this.this$0).getTrashFolderId(this.val$account.getId());
    int k = QMMailProtocolManager.access$100(this.this$0).getInboxFolderId(this.val$account.getId());
    QMMailProtocolManager.access$700(this.this$0, paramMail, this.val$account.getProtocolType());
    QMMailProtocolManager.access$800(this.this$0, this.val$localSentMails, paramMail);
    Object localObject = this.val$newMailCount;
    localObject[0] += 1;
    if (paramMail.getStatus().isStarred())
    {
      localObject = this.val$starMailCount;
      localObject[0] += 1;
    }
    localObject = paramMail.getInformation();
    QMRuleManager.sharedInstance().apply(paramMail, new QMMailProtocolManager.19.1(this, i, k, j, (MailInformation)localObject));
    this.val$convHashes.add(Integer.valueOf(((MailInformation)localObject).getConvHash()));
    long l;
    if (((MailInformation)localObject).getDate() != null)
    {
      l = System.currentTimeMillis() - ((MailInformation)localObject).getDate().getTime();
      if (((MailInformation)localObject).getFrom() == null) {
        break label261;
      }
    }
    label261:
    for (paramMail = ((MailInformation)localObject).getFrom().getAddress();; paramMail = null)
    {
      this.mRecvMailLog.append(", [").append(((MailInformation)localObject).getSubject()).append("/").append(((MailInformation)localObject).getRemoteId()).append("/").append(l).append("/").append(paramMail).append("]");
      return;
      l = -9223372036854775808L;
      break;
    }
  }
  
  public void onRetrieveStatus(Mail[] paramArrayOfMail)
  {
    QMMailProtocolManager.access$600(this.this$0, paramArrayOfMail);
    long[] arrayOfLong = new long[paramArrayOfMail.length];
    int i = 0;
    while (i < paramArrayOfMail.length)
    {
      arrayOfLong[i] = paramArrayOfMail[i].getInformation().getId();
      i += 1;
    }
    if (this.val$callback != null)
    {
      this.val$callback.success(arrayOfLong, false);
      return;
    }
    QMWatcherCenter.triggerLoadListSuccess(this.val$folder.getId(), null, this.val$newMailCount[0], false);
  }
  
  public void onRetrieveSuccess(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    Log.i("QMMailProtocolManager", "onRetrieveSuccess " + this.val$folder.getName() + " newMails length = " + paramArrayOfString1.length);
    if ((this.val$account != null) && (this.val$account.isGMail()))
    {
      int m = paramArrayOfString1.length;
      j = 0;
      i = 0;
      while (i < m)
      {
        localObject1 = paramArrayOfString1[i];
        int k = j;
        if (!QMMailProtocolManager.access$900(this.this$0).contains(localObject1))
        {
          QMMailProtocolManager.access$900(this.this$0).add(localObject1);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      TimNotificationManager.getInstance().updateNewMailCount(this.val$account.getEmail(), j);
    }
    Object localObject3;
    for (;;)
    {
      localObject3 = new HashSet();
      j = paramArrayOfString1.length;
      i = 0;
      while (i < j)
      {
        localObject1 = paramArrayOfString1[i];
        if (!this.val$ruleAppliedMailIds.contains(localObject1)) {
          ((HashSet)localObject3).add(localObject1);
        }
        i += 1;
      }
      TimNotificationManager.getInstance().updateNewMailCount(this.val$account.getEmail(), paramArrayOfString1.length);
    }
    Object localObject1 = (String[])((HashSet)localObject3).toArray(new String[((HashSet)localObject3).size()]);
    Object localObject2 = QMMailProtocolManager.access$000(this.this$0).getWritableDatabase();
    long[] arrayOfLong = QMMailProtocolManager.access$000(this.this$0).mail.getMailIdByRemoteIds((SQLiteDatabase)localObject2, this.val$folderId, (String[])localObject1);
    QMFolder localQMFolder = QMMailProtocolManager.access$000(this.this$0).folder.getFolderById(this.val$folderId);
    if (localQMFolder == null) {
      return;
    }
    boolean bool;
    if ((localQMFolder.hasNewMail()) || ((this.val$isUpdate) && (((HashSet)localObject3).size() > 0)))
    {
      bool = true;
      QMMailProtocolManager.access$000(this.this$0).folder.updateFolder((SQLiteDatabase)localObject2, this.val$folderId, -1, paramInt, bool, false);
      if (localQMFolder.getType() == 1) {
        Threads.runInBackground(new QMMailProtocolManager.19.2(this), 1000L);
      }
      if (paramArrayOfString3.length != 0)
      {
        localObject3 = QMMailProtocolManager.access$000(this.this$0).mail.getMailIdByRemoteIds((SQLiteDatabase)localObject2, this.val$folderId, paramArrayOfString3);
        if (localObject3 != null)
        {
          if (this.val$protocol == 0) {
            break label516;
          }
          QMMailProtocolManager.access$000(this.this$0).mail.deleteMailsWithConv((SQLiteDatabase)localObject2, localQMFolder.getAccountId(), (long[])localObject3);
          QMMailProtocolManager.access$200(this.this$0).cancelNewMailNotify(this.val$accountId, (long[])localObject3);
        }
      }
    }
    for (;;)
    {
      localObject3 = new int[this.val$convHashes.size()];
      i = 0;
      while (i < localObject3.length)
      {
        localObject3[i] = ((Integer)this.val$convHashes.get(i)).intValue();
        i += 1;
      }
      bool = false;
      break;
      label516:
      QMMailProtocolManager.access$000(this.this$0).mail.updateMailAttr((SQLiteDatabase)localObject2, (long[])localObject3, 549755813888L);
    }
    QMMailProtocolManager.access$000(this.this$0).mail.rebuildConvParents((SQLiteDatabase)localObject2, this.val$accountId, (int[])localObject3);
    QMMailProtocolManager.access$100(this.this$0).updateLocalMailUnreadCountIntoFolder(this.val$folderId);
    if (this.val$starMailCount[0] > 0)
    {
      localObject2 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.val$accountId, 16);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
        QMFolderManager.sharedInstance().updateLocalMailUnreadCountIntoFolder(((QMFolder)((ArrayList)localObject2).get(0)).getId());
      }
    }
    QMMailProtocolManager.access$200(this.this$0).handleUnknownMail(this.val$accountId);
    QMMailProtocolManager.access$200(this.this$0).updateAdvertiseEntrance(this.val$accountId);
    if (this.val$callback != null) {
      this.val$callback.success(arrayOfLong, paramBoolean);
    }
    int j = this.val$folderId;
    long l;
    if (arrayOfLong != null)
    {
      i = arrayOfLong.length;
      QMWatcherCenter.triggerLoadListSuccess(j, null, i, paramBoolean);
      if (this.val$protocol != 0) {
        QMMailProtocolManager.access$1000(this.this$0, this.val$folderId, (String[])localObject1, 5);
      }
      QMMailProtocolManager.access$1100(this.this$0, this.val$localSentMails, this.val$account, localQMFolder);
      l = this.val$accountId;
      if (arrayOfLong == null) {
        break label912;
      }
    }
    label912:
    for (int i = arrayOfLong.length;; i = 0)
    {
      DataCollector.logDetailEvent("DetailEvent_RecvMail", l, 0L, String.valueOf(i));
      this.mRecvMailLog.insert(15, "onRetrieveSuccess, ");
      this.mRecvMailLog.append(", totalCount: ").append(paramInt);
      if (paramArrayOfString1.length > 0) {
        this.mRecvMailLog.append(", newMailsNum: ").append(paramArrayOfString1.length);
      }
      if (paramArrayOfString2.length > 0) {
        this.mRecvMailLog.append(", updateMails: ").append(paramArrayOfString2.length);
      }
      if (paramArrayOfString3.length > 0) {
        this.mRecvMailLog.append(", deleteMails: ").append(paramArrayOfString3.length);
      }
      if ((arrayOfLong != null) && (arrayOfLong.length > 0)) {
        this.mRecvMailLog.append(", actualNewMailsNum: ").append(arrayOfLong.length);
      }
      QMLog.log(4, "QMMailProtocolManager", this.mRecvMailLog.toString());
      return;
      i = 0;
      break;
    }
  }
  
  public void process()
  {
    if (this.val$callback != null) {
      this.val$callback.process();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.19
 * JD-Core Version:    0.7.0.1
 */