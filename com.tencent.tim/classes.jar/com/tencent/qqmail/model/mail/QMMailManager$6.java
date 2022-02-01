package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager.FolderOperationType;
import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.mail.rule.QMRuleManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class QMMailManager$6
  extends FolderOperationCallback
{
  QMMailManager$6(QMMailManager paramQMMailManager, Account paramAccount, boolean paramBoolean1, int paramInt, QMFolderManager.FolderOperationType paramFolderOperationType, boolean paramBoolean2, String[] paramArrayOfString) {}
  
  public void onError(QMFolder paramQMFolder, QMNetworkError paramQMNetworkError)
  {
    QMWatcherCenter.triggrFolderOpertionError(this.val$type, paramQMNetworkError);
  }
  
  public void onSuccess(QMFolder paramQMFolder)
  {
    int j = 0;
    int k = QMMailManager.access$000(this.this$0).folder.getLatestSequence(this.val$account.getId(), this.val$isTag, this.val$account.isQQMail());
    Object localObject;
    int i;
    if (k == 0)
    {
      localObject = QMApplicationContext.sharedInstance();
      if (this.val$isTag)
      {
        i = 2131719549;
        i = Integer.parseInt(((QMApplicationContext)localObject).getString(i)) + k;
        label68:
        Log.d("QMMailManager", "addFolder, folderId:" + paramQMFolder.getId() + ", isTag:" + this.val$isTag + ", seq:" + i);
        paramQMFolder.setSequence(i);
        paramQMFolder.setSvrCount(0);
        paramQMFolder.setSvrUnreadCount(0);
        paramQMFolder.setCliConvUnreadCount(0);
        paramQMFolder.setCliUnreadCount(0);
        if (!this.val$account.isQQMail()) {
          break label358;
        }
        paramQMFolder.setParentId(-7);
      }
    }
    long[] arrayOfLong;
    for (;;)
    {
      paramQMFolder.setPush(true);
      this.this$0.updateFolderPushStatus(this.val$accountId, new String[] { paramQMFolder.getRemoteId() }, new boolean[] { true });
      localObject = QMMailManager.access$000(this.this$0).getWritableDatabase();
      QMMailManager.access$000(this.this$0).folder.increaseSequenceForAddFolder((SQLiteDatabase)localObject, this.val$account.getId(), i);
      QMMailManager.access$000(this.this$0).folder.insertFolder((SQLiteDatabase)localObject, paramQMFolder);
      QMWatcherCenter.triggrFolderOpertionSuccess(this.val$type, paramQMFolder, this.val$createRule);
      if (!this.val$createRule) {
        break label405;
      }
      ArrayList localArrayList = new ArrayList();
      QMMailManager.access$100(this.this$0).createAutoMove(this.val$accountId, this.val$createRuleAddress, paramQMFolder.getId(), new QMMailManager.6.1(this, localArrayList));
      arrayOfLong = new long[localArrayList.size()];
      i = j;
      while (i < arrayOfLong.length)
      {
        arrayOfLong[i] = ((Long)localArrayList.get(i)).longValue();
        i += 1;
      }
      i = 2131719550;
      break;
      i = k + 1;
      break label68;
      label358:
      if ((this.val$account.isPopMail()) || (this.val$isTag)) {
        paramQMFolder.setVirtual(true);
      }
    }
    if (this.val$account.isQQMail())
    {
      QMMailManager.access$200(this.this$0, (SQLiteDatabase)localObject, paramQMFolder, arrayOfLong);
      label405:
      return;
    }
    QMMailManager.access$300(this.this$0, (SQLiteDatabase)localObject, this.val$account, paramQMFolder, arrayOfLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.6
 * JD-Core Version:    0.7.0.1
 */