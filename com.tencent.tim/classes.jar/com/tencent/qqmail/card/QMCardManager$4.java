package com.tencent.qqmail.card;

import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMCardManager$4
  implements QMCallback.ISuccessCallback
{
  QMCardManager$4(QMCardManager paramQMCardManager, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = paramQMNetworkResponse.getResponseString();
    if (CardUtil.isContentCorrect(paramQMNetworkRequest))
    {
      QMCardManager.access$200(this.this$0).insertCardDataContent(QMCardManager.access$200(this.this$0).getWritableDatabase(), this.val$cardUrl, paramQMNetworkRequest);
      QMWatcherCenter.triggerLoadCardContentSuccess(this.val$cardUrl, paramQMNetworkRequest);
      return;
    }
    QMLog.log(6, "QMCardManager", "loadCardDataContent response fail empty");
    QMWatcherCenter.triggerLoadCardContentError(this.val$cardUrl, new QMNetworkError(-10000, -1, "empty"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.4
 * JD-Core Version:    0.7.0.1
 */