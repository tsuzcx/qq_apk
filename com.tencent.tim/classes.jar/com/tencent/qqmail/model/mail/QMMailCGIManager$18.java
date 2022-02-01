package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;

class QMMailCGIManager$18
  implements Runnable
{
  QMMailCGIManager$18(QMMailCGIManager paramQMMailCGIManager, QMFolder paramQMFolder, IListCallback paramIListCallback, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    QMMailUrlBuilder.createListUrl(localStringBuilder1, localStringBuilder2, this.val$folder);
    QMMailUrlBuilder.getCursorUrl(localStringBuilder2, null);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new QMMailCGIManager.18.1(this));
    localQMCallback.setOnSuccess(new QMMailCGIManager.18.2(this));
    localQMCallback.setOnError(new QMMailCGIManager.18.3(this));
    localQMCallback.setOnComplete(new QMMailCGIManager.18.4(this));
    CGIManager.httpGet(this.val$accountId, localStringBuilder1.toString(), localStringBuilder2.toString(), localQMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.18
 * JD-Core Version:    0.7.0.1
 */