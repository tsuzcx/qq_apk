package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.cursor.QMSyncFolderCursor;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import java.util.ArrayList;

class QMMailCGIManager$19
  implements Runnable
{
  QMMailCGIManager$19(QMMailCGIManager paramQMMailCGIManager, QMFolder paramQMFolder, int paramInt, IListCallback paramIListCallback, Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void run()
  {
    int i = this.val$folder.getAccountId();
    Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(i);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    QMMailUrlBuilder.createListUrl(localStringBuilder1, localStringBuilder2, this.val$folder);
    QMMailUrlBuilder.getCursorUrl(localStringBuilder2, null);
    Object localObject2 = new QMSyncFolderCursor(QMMailCGIManager.access$000(this.this$0), this.val$folder.getId(), false, this.val$limit);
    ArrayList localArrayList = new ArrayList();
    QMMailUrlBuilder.getIncrementalUrl(localStringBuilder2, (IMailListCursor)localObject2, localArrayList, false);
    ((QMMailListCursor)localObject2).close();
    localObject2 = new QMCallback();
    ((QMCallback)localObject2).setOnBeforeSend(new QMMailCGIManager.19.1(this));
    ((QMCallback)localObject2).setOnSuccess(new QMMailCGIManager.19.2(this, i, (Account)localObject1, localArrayList));
    ((QMCallback)localObject2).setOnError(new QMMailCGIManager.19.3(this));
    ((QMCallback)localObject2).setOnComplete(new QMMailCGIManager.19.4(this));
    CGIManager.httpGet(i, localStringBuilder1.toString(), localStringBuilder2.toString(), this.val$withoutSession, (QMCallback)localObject2);
    if (this.val$folder.isQQPopFolder())
    {
      localObject1 = new StringBuilder();
      localStringBuilder1 = new StringBuilder();
      QMMailUrlBuilder.createSyncPopUrl((StringBuilder)localObject1, localStringBuilder1, this.val$folder);
      CGIManager.httpGet(i, ((StringBuilder)localObject1).toString(), localStringBuilder1.toString(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.19
 * JD-Core Version:    0.7.0.1
 */