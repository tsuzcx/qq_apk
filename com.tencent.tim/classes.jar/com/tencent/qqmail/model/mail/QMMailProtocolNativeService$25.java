package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.SearchAddressCallback;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import java.util.ArrayList;

class QMMailProtocolNativeService$25
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$25(QMMailProtocolNativeService paramQMMailProtocolNativeService, SearchAddressCallback paramSearchAddressCallback, Profile paramProfile, Account paramAccount) {}
  
  public void onResult(ProtocolResult paramProtocolResult)
  {
    if ((paramProtocolResult.as_contact_result_list_ != null) && (paramProtocolResult.error_code_ == 0))
    {
      ArrayList localArrayList = Lists.newArrayList(paramProtocolResult.as_contact_result_list_);
      QMLog.log(4, "QMMailProtocolNativeService", "searchExchangeGlobalAddressList size:" + localArrayList.size());
      if (this.val$callback != null) {
        this.val$callback.searchSuccess(localArrayList);
      }
      if (this.val$profile.protocolType == 4) {
        this.this$0.saveActiveSync(this.val$account.getId(), paramProtocolResult);
      }
    }
    do
    {
      do
      {
        return;
        if (paramProtocolResult.error_code_ != 4) {
          break;
        }
        QMLog.log(6, "QMMailProtocolNativeService", "searchExchangeGlobalAddressList auth err : " + this.val$account.getId());
        PasswordErrHandler.saveStateAndShowErr(this.val$account.getId(), -1);
        paramProtocolResult = new QMProtocolError(paramProtocolResult.error_code_);
      } while (this.val$callback == null);
      this.val$callback.searchError(paramProtocolResult);
      return;
      QMLog.log(6, "QMMailProtocolNativeService", "searchExchangeGlobalAddressList code:" + paramProtocolResult.error_code_);
      paramProtocolResult = new QMProtocolError(paramProtocolResult.error_code_);
    } while (this.val$callback == null);
    this.val$callback.searchError(paramProtocolResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.25
 * JD-Core Version:    0.7.0.1
 */