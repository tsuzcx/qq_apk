package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.provider.ConnectSelector;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

class QMMailProtocolService$7
  implements Runnable
{
  QMMailProtocolService$7(QMMailProtocolService paramQMMailProtocolService, HashMap paramHashMap, QMMailProtocolService.DomainConfig paramDomainConfig, ConnectSelector paramConnectSelector, String paramString, MailServiceProvider paramMailServiceProvider, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap;
      String str;
      if ((!this.val$dnsList.keySet().contains(this.val$domainConfig.server)) && (this.val$domainConfig.server != null))
      {
        localObject = new InetSocketAddress(this.val$domainConfig.server, 0);
        localHashMap = this.val$dnsList;
        str = this.val$domainConfig.server;
        if (((InetSocketAddress)localObject).getAddress() != null) {
          break label88;
        }
      }
      label88:
      for (Object localObject = null;; localObject = ((InetSocketAddress)localObject).getAddress().getHostAddress())
      {
        localHashMap.put(str, localObject);
        if (!this.val$selector.isCompleted()) {
          break;
        }
        return;
      }
      QMLog.log(4, "QMMailProtocolService", "query dns " + this.val$domainConfig.server);
      this.this$0.createChannel(this.val$domain, this.val$domainConfig, this.val$selector, this.val$mailServiceProvider, this.val$dnsList);
      if (this.val$selector.run())
      {
        this.val$selector.setCompleted();
        MailServiceManager.getInstance().setAutoFillMailProvider(this.val$domain, this.val$mailServiceProvider);
        this.val$countDownLatch.countDown();
        return;
      }
    }
    catch (IOException localIOException)
    {
      QMLog.log(6, "QMMailProtocolService", "createChannel " + localIOException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolService.7
 * JD-Core Version:    0.7.0.1
 */