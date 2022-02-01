package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.callback.SearchAddressCallback;
import com.tencent.qqmail.protocol.ASContact;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import java.util.ArrayList;

class QMMailProtocolManager$26
  implements SearchAddressCallback
{
  QMMailProtocolManager$26(QMMailProtocolManager paramQMMailProtocolManager, Account paramAccount, String paramString) {}
  
  public void searchError(QMProtocolError paramQMProtocolError)
  {
    QMContactManager.sharedInstance().triggerSearchExchangeAddressError(this.val$keyword, paramQMProtocolError);
  }
  
  public void searchSuccess(ArrayList<ASContact> paramArrayList)
  {
    QMContactManager.sharedInstance().setSearchGlobalAddressListCache(this.val$account.getId(), this.val$keyword, paramArrayList);
    QMContactManager.sharedInstance().triggerSearchExchangeAddressSuccess(this.val$keyword, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.26
 * JD-Core Version:    0.7.0.1
 */