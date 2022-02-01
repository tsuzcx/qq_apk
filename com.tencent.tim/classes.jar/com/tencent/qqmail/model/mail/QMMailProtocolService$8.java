package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.provider.ConnectSelector;
import com.tencent.qqmail.provider.ConnectSelector.Connectable;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

class QMMailProtocolService$8
  implements ConnectSelector.Connectable
{
  QMMailProtocolService$8(QMMailProtocolService paramQMMailProtocolService, QMMailProtocolService.DomainConfig paramDomainConfig, MailServiceProvider paramMailServiceProvider, ConnectSelector paramConnectSelector) {}
  
  public void onConnectable(SelectionKey paramSelectionKey)
  {
    Object localObject = (SocketChannel)paramSelectionKey.channel();
    if (((SocketChannel)localObject).isConnectionPending()) {}
    try
    {
      ((SocketChannel)localObject).finishConnect();
      if (((SocketChannel)localObject).isConnected())
      {
        QMLog.log(4, "QMMailProtocolService", "connected " + this.val$config.server + " " + this.val$config.port);
        localObject = this.val$config.protocol;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          }
          break;
        }
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        for (;;)
        {
          int i;
          paramSelectionKey.channel().close();
          label167:
          paramSelectionKey.cancel();
          return;
          if (((String)localObject).equals("IMAP"))
          {
            i = 0;
            continue;
            if (((String)localObject).equals("POP"))
            {
              i = 1;
              continue;
              if (((String)localObject).equals("SMTP"))
              {
                i = 2;
                continue;
                if (((String)localObject).equals("ACTIVESYNC"))
                {
                  i = 3;
                  continue;
                  if (StringExtention.isNullOrEmpty(this.val$mailServiceProvider.getDefaultRecvProtocol())) {
                    this.val$mailServiceProvider.setDefaultRecvProtocol("IMAP");
                  }
                  if (this.val$config.isUsingSSL) {
                    this.val$mailServiceProvider.setImapSSLPort(this.val$config.port);
                  }
                  for (;;)
                  {
                    this.val$mailServiceProvider.setImapServer(this.val$config.server);
                    this.val$mailServiceProvider.setImapUsingSSL(this.val$config.isUsingSSL);
                    this.val$selector.setImapConnected(true);
                    break;
                    this.val$mailServiceProvider.setImapPort(this.val$config.port);
                  }
                  if (StringExtention.isNullOrEmpty(this.val$mailServiceProvider.getDefaultRecvProtocol())) {
                    this.val$mailServiceProvider.setDefaultRecvProtocol("POP3");
                  }
                  if (this.val$config.isUsingSSL) {
                    this.val$mailServiceProvider.setPop3SSLPort(this.val$config.port);
                  }
                  for (;;)
                  {
                    this.val$mailServiceProvider.setPop3Server(this.val$config.server);
                    this.val$mailServiceProvider.setPop3UsingSSL(this.val$config.isUsingSSL);
                    this.val$selector.setPopConnected(true);
                    break;
                    this.val$mailServiceProvider.setPop3Port(this.val$config.port);
                  }
                  if (this.val$config.isUsingSSL) {
                    this.val$mailServiceProvider.setSmtpSSLPort(this.val$config.port);
                  }
                  for (;;)
                  {
                    this.val$mailServiceProvider.setSmtpServer(this.val$config.server);
                    this.val$mailServiceProvider.setSmtpUsingSSL(this.val$config.isUsingSSL);
                    this.val$selector.setSmtpConnected(true);
                    break;
                    this.val$mailServiceProvider.setSmtpPort(this.val$config.port);
                  }
                  if (StringExtention.isNullOrEmpty(this.val$mailServiceProvider.getDefaultRecvProtocol())) {
                    this.val$mailServiceProvider.setDefaultRecvProtocol("ActiveSync");
                  }
                  this.val$mailServiceProvider.setActiveSyncServer(this.val$config.server);
                  this.val$mailServiceProvider.setActiveSyncUsingSSL(this.val$config.isUsingSSL);
                  this.val$selector.setExchangeConnected(true);
                }
              }
            }
          }
        }
        localIOException = localIOException;
      }
      catch (Exception localException)
      {
        break label167;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolService.8
 * JD-Core Version:    0.7.0.1
 */