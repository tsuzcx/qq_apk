package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.subscribe.QMSubscribeThumbManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;
import java.util.Date;

class QMMailCGIManager$44
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$44(QMMailCGIManager paramQMMailCGIManager, int paramInt, Mail paramMail, boolean paramBoolean) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    ArrayList localArrayList = QMMailCGIManager.access$2000(this.this$0, this.val$accountId, QMMailParser.parseSubscribeMail(paramQMNetworkRequest));
    SQLiteDatabase localSQLiteDatabase = QMMailCGIManager.access$000(this.this$0).getWritableDatabase();
    int j;
    int i;
    long l;
    int m;
    if (localArrayList.size() > 0)
    {
      paramQMNetworkRequest = null;
      j = 0;
      i = 0;
      l = this.val$mail.getInformation().getDate().getTime();
      m = 0;
      if (m < localArrayList.size())
      {
        paramQMNetworkResponse = (SubscribeMail)localArrayList.get(m);
        if (paramQMNetworkResponse.getIndex() == SubscribeMail.INDEX_ENTRANCE_MAIL)
        {
          paramQMNetworkResponse.setReceive(new Date(1000L + l));
          if ((paramQMNetworkResponse.getFromName() != null) && (!paramQMNetworkResponse.getFromName().equals(""))) {
            break label392;
          }
          paramQMNetworkResponse.setFromAddress(this.val$mail.getInformation().getFrom().getAddress());
          paramQMNetworkResponse.setFromName(this.val$mail.getInformation().getFrom().getName());
          paramQMNetworkRequest = paramQMNetworkResponse;
        }
      }
    }
    for (;;)
    {
      label173:
      QMMailCGIManager.access$000(this.this$0).mail.insertSubscribeMails(localSQLiteDatabase, paramQMNetworkResponse);
      int k = i;
      if (this.val$preloadThumb) {
        if ((j == 0) && (paramQMNetworkResponse.getBigIcon() != null) && (!paramQMNetworkResponse.getBigIcon().equals("")))
        {
          QMSubscribeThumbManager.sharedInstance().loadSubscribeThumb(this.val$accountId, paramQMNetworkResponse.getBigIcon(), 2, null);
          j = 1;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        paramQMNetworkResponse.setReceive(new Date(l - m * 1000));
        break label173;
        k = i;
        if (j != 0)
        {
          k = i;
          if (i < 4)
          {
            k = i;
            if (paramQMNetworkResponse.getIcon() != null)
            {
              k = i;
              if (!paramQMNetworkResponse.getIcon().equals(""))
              {
                k = i + 1;
                QMSubscribeThumbManager.sharedInstance().loadSubscribeThumb(this.val$accountId, paramQMNetworkResponse.getIcon(), 3, null);
              }
            }
          }
        }
        i = k;
      }
      if (paramQMNetworkRequest != null)
      {
        QMMailCGIManager.access$000(this.this$0).mail.updateMailAttr(localSQLiteDatabase, new long[] { paramQMNetworkRequest.getMid() }, 262144L);
        QMWatcherCenter.triggerSubscribeMailSuccess(paramQMNetworkRequest.getId());
        return;
      }
      QMWatcherCenter.triggerSubscribeMailError(this.val$accountId, null);
      return;
      label392:
      paramQMNetworkRequest = paramQMNetworkResponse;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.44
 * JD-Core Version:    0.7.0.1
 */