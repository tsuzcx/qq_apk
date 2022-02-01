package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;

class QMMailCGIManager$20
  implements Runnable
{
  QMMailCGIManager$20(QMMailCGIManager paramQMMailCGIManager, QMFolder paramQMFolder, IListCallback paramIListCallback, String paramString) {}
  
  public void run()
  {
    int i = this.val$folder.getAccountId();
    int j = this.val$folder.getId();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    QMMailUrlBuilder.createListUrl(localStringBuilder1, localStringBuilder2, this.val$folder);
    Object localObject = QMMailCGIManager.access$000(this.this$0).getReadableDatabase();
    QMMailUrlBuilder.getCursorUrl(localStringBuilder2, QMMailCGIManager.access$000(this.this$0).mail.getSinceQQMail((SQLiteDatabase)localObject, this.val$folder));
    localObject = new QMCallback();
    ((QMCallback)localObject).setOnBeforeSend(new QMMailCGIManager.20.1(this, j));
    ((QMCallback)localObject).setOnSuccess(new QMMailCGIManager.20.2(this, i, j));
    ((QMCallback)localObject).setOnError(new QMMailCGIManager.20.3(this, j));
    ((QMCallback)localObject).setOnComplete(new QMMailCGIManager.20.4(this));
    CGIManager.httpGet(i, localStringBuilder1.toString(), localStringBuilder2.toString(), (QMCallback)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.20
 * JD-Core Version:    0.7.0.1
 */