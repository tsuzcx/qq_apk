package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.MailServiceManager.QueryProviderListener;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdQueryDomainConfigRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;

class QMPrivateProtocolManager$13
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$13(QMPrivateProtocolManager paramQMPrivateProtocolManager, MailServiceManager.QueryProviderListener paramQueryProviderListener) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "queryDomainConfigFromWeb error code:" + paramCloudProtocolResult.error_code_);
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.query_domain_rsp_ != null)) {
      if (paramCloudProtocolResult.query_domain_rsp_.available)
      {
        paramCloudProtocolResult = MailServiceManager.getInstance().parseDomainConfig(paramCloudProtocolResult);
        if (this.val$callback != null) {
          this.val$callback.onSuccess(paramCloudProtocolResult);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (this.val$callback == null);
      this.val$callback.onError("no_config_on_server");
      return;
      new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.QueryDomainConfig");
    } while (this.val$callback == null);
    this.val$callback.onError("unknown_error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.13
 * JD-Core Version:    0.7.0.1
 */