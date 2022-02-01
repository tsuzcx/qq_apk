package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.SearchMailQueueHandler.ISearchGetCarrier;
import com.tencent.qqmail.model.mail.SearchMailQueueHandler.SearchMailCallback;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.qmnetwork.IAbortable;

class QMSearchCursor$4
  implements SearchMailQueueHandler.ISearchGetCarrier
{
  QMSearchCursor$4(QMSearchCursor paramQMSearchCursor1, QMSearchCursor paramQMSearchCursor2) {}
  
  public IAbortable run(SearchInfo paramSearchInfo, SearchMailQueueHandler.SearchMailCallback paramSearchMailCallback)
  {
    int i = paramSearchInfo.getAccountId();
    if (AccountManager.shareInstance().getAccountList().getAccountById(i).isQQMail()) {
      return this.this$0.cgiMgr.searchMails(this.val$self, paramSearchInfo, paramSearchMailCallback, QMSearchCursor.access$900(this.this$0));
    }
    return this.this$0.protocolMgr.searchMails(this.val$self, paramSearchInfo, paramSearchMailCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSearchCursor.4
 * JD-Core Version:    0.7.0.1
 */