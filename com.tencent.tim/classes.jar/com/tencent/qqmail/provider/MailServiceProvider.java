package com.tencent.qqmail.provider;

import com.tencent.qqmail.utilities.log.QMLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MailServiceProvider
  implements Serializable
{
  public static final int CONFIG_FROM_LOCAL = 1;
  public static final int CONFIG_FROM_SERVICE = 0;
  public static final String PROTOCOL_ACTIVESYNC = "ActiveSync";
  public static final String PROTOCOL_ACTIVESYNC_TEST = "TestActiveSync";
  public static final String PROTOCOL_EXCHANGE = "Exchange";
  public static final String PROTOCOL_IMAP = "IMAP";
  public static final String PROTOCOL_POP3 = "POP3";
  private static final long serialVersionUID = 4040352922087705599L;
  private String activeSyncDomain;
  private int activeSyncName;
  private String activeSyncServer;
  private boolean activeSyncUsingSSL;
  private boolean cloudEditEnable;
  private String defaultRecvProtocol;
  private String exchangeDomain;
  private int exchangeName;
  private String exchangeServer;
  private boolean exchangeUsingSSL;
  private int imapName;
  private int imapPort = 0;
  private int imapSSLPort = 0;
  private String imapServer;
  private boolean imapUsingSSL;
  private String[] mailAddressSuffix;
  private boolean needAuthentication;
  private int pop3Name;
  private int pop3Port = 0;
  private int pop3SSLPort = 0;
  private String pop3Server;
  private boolean pop3UsingSSL;
  private String providerAvatar;
  private List<String> providerCompanyEntrys;
  private String providerIcon;
  private String providerName;
  private int smtpName;
  private int smtpPort = 0;
  private int smtpSSLPort = 0;
  private String smtpServer;
  private boolean smtpUsingSSL;
  private boolean sslConnection;
  private boolean useCloudSupport;
  
  public void addProviderCompanyEntry(String paramString)
  {
    if (this.providerCompanyEntrys == null) {
      this.providerCompanyEntrys = new ArrayList();
    }
    this.providerCompanyEntrys.add(paramString);
  }
  
  public MailServiceProvider deepCopy()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      new ObjectOutputStream((OutputStream)localObject).writeObject(this);
      localObject = (MailServiceProvider)new ObjectInputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray())).readObject();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public String getActiveSyncDomain()
  {
    return this.activeSyncDomain;
  }
  
  public int getActiveSyncName()
  {
    return this.activeSyncName;
  }
  
  public String getActiveSyncServer()
  {
    return this.activeSyncServer;
  }
  
  public String getDefaultRecvProtocol()
  {
    return this.defaultRecvProtocol;
  }
  
  public String getExchangeDomain()
  {
    return this.exchangeDomain;
  }
  
  public int getExchangeName()
  {
    return this.exchangeName;
  }
  
  public String getExchangeServer()
  {
    return this.exchangeServer;
  }
  
  public int getImapName()
  {
    return this.imapName;
  }
  
  public int getImapPort()
  {
    return this.imapPort;
  }
  
  public int getImapSSLPort()
  {
    return this.imapSSLPort;
  }
  
  public String getImapServer()
  {
    return this.imapServer;
  }
  
  public String[] getMailAddressSuffix()
  {
    return this.mailAddressSuffix;
  }
  
  public int getPop3Name()
  {
    return this.pop3Name;
  }
  
  public int getPop3Port()
  {
    return this.pop3Port;
  }
  
  public int getPop3SSLPort()
  {
    return this.pop3SSLPort;
  }
  
  public String getPop3Server()
  {
    return this.pop3Server;
  }
  
  public String getProviderAvatar()
  {
    return this.providerAvatar;
  }
  
  public List<String> getProviderCompanyEntrys()
  {
    return this.providerCompanyEntrys;
  }
  
  public String getProviderIcon()
  {
    return this.providerIcon;
  }
  
  public String getProviderName()
  {
    return this.providerName;
  }
  
  @Deprecated
  public int getSmtpName()
  {
    return this.smtpName;
  }
  
  public int getSmtpPort()
  {
    return this.smtpPort;
  }
  
  public int getSmtpSSLPort()
  {
    return this.smtpSSLPort;
  }
  
  public String getSmtpServer()
  {
    return this.smtpServer;
  }
  
  public boolean isActiveSyncUseSSL()
  {
    return this.activeSyncUsingSSL;
  }
  
  public boolean isCloudEditEnable()
  {
    return this.cloudEditEnable;
  }
  
  public boolean isExchangeUsingSSL()
  {
    return this.exchangeUsingSSL;
  }
  
  public boolean isImapUsingSSL()
  {
    return this.imapUsingSSL;
  }
  
  public boolean isNeedAuthentication()
  {
    return this.needAuthentication;
  }
  
  public boolean isPop3UsingSSL()
  {
    return this.pop3UsingSSL;
  }
  
  public boolean isSmtpUsingSSL()
  {
    return this.smtpUsingSSL;
  }
  
  public boolean isSslConnection()
  {
    return this.sslConnection;
  }
  
  public boolean isUseCloudSupport()
  {
    return this.useCloudSupport;
  }
  
  public void setActiveSyncDomain(String paramString)
  {
    this.activeSyncDomain = paramString;
  }
  
  public void setActiveSyncName(int paramInt)
  {
    this.activeSyncName = paramInt;
  }
  
  public void setActiveSyncServer(String paramString)
  {
    this.activeSyncServer = paramString;
  }
  
  public void setActiveSyncUsingSSL(boolean paramBoolean)
  {
    this.activeSyncUsingSSL = paramBoolean;
  }
  
  public void setCloudEditEnable(boolean paramBoolean)
  {
    this.cloudEditEnable = paramBoolean;
  }
  
  public void setDefaultRecvProtocol(String paramString)
  {
    this.defaultRecvProtocol = paramString;
  }
  
  public void setExchangeDomain(String paramString)
  {
    this.exchangeDomain = paramString;
  }
  
  public void setExchangeName(int paramInt)
  {
    this.exchangeName = paramInt;
  }
  
  public void setExchangeServer(String paramString)
  {
    this.exchangeServer = paramString;
  }
  
  public void setExchangeUsingSSL(boolean paramBoolean)
  {
    this.exchangeUsingSSL = paramBoolean;
  }
  
  public void setImapName(int paramInt)
  {
    this.imapName = paramInt;
  }
  
  public void setImapPort(int paramInt)
  {
    this.imapPort = paramInt;
  }
  
  public void setImapSSLPort(int paramInt)
  {
    this.imapSSLPort = paramInt;
  }
  
  public void setImapServer(String paramString)
  {
    this.imapServer = paramString;
  }
  
  public void setImapUsingSSL(boolean paramBoolean)
  {
    this.imapUsingSSL = paramBoolean;
  }
  
  public void setMailAddressSuffix(String[] paramArrayOfString)
  {
    this.mailAddressSuffix = paramArrayOfString;
  }
  
  public void setNeedAuthentication(boolean paramBoolean)
  {
    this.needAuthentication = paramBoolean;
  }
  
  public void setPop3Name(int paramInt)
  {
    this.pop3Name = paramInt;
  }
  
  public void setPop3Port(int paramInt)
  {
    this.pop3Port = paramInt;
  }
  
  public void setPop3SSLPort(int paramInt)
  {
    this.pop3SSLPort = paramInt;
  }
  
  public void setPop3Server(String paramString)
  {
    this.pop3Server = paramString;
  }
  
  public void setPop3UsingSSL(boolean paramBoolean)
  {
    this.pop3UsingSSL = paramBoolean;
  }
  
  public void setProviderAvatar(String paramString)
  {
    this.providerAvatar = paramString;
  }
  
  public void setProviderCompanyEntrys(List<String> paramList)
  {
    this.providerCompanyEntrys = paramList;
  }
  
  public void setProviderIcon(String paramString)
  {
    this.providerIcon = paramString;
  }
  
  public void setProviderName(String paramString)
  {
    this.providerName = paramString;
  }
  
  public void setSmtpName(int paramInt)
  {
    this.smtpName = paramInt;
  }
  
  public void setSmtpPort(int paramInt)
  {
    this.smtpPort = paramInt;
  }
  
  public void setSmtpSSLPort(int paramInt)
  {
    this.smtpSSLPort = paramInt;
  }
  
  public void setSmtpServer(String paramString)
  {
    this.smtpServer = paramString;
  }
  
  public void setSmtpUsingSSL(boolean paramBoolean)
  {
    this.smtpUsingSSL = paramBoolean;
  }
  
  public void setSslConnection(boolean paramBoolean)
  {
    this.sslConnection = paramBoolean;
  }
  
  public void setUseCloudSupport(boolean paramBoolean)
  {
    this.useCloudSupport = paramBoolean;
  }
  
  public String toString()
  {
    try
    {
      String str = "[providerName=" + this.providerName + ", providerIcon=" + this.providerIcon + ", providerAvatar=" + this.providerAvatar + ", providerCompanyEntrys=" + this.providerCompanyEntrys + ", mailAddressSuffix=" + Arrays.toString(this.mailAddressSuffix) + ", defaultRecvProtocol=" + this.defaultRecvProtocol + ", exchangeServer=" + this.exchangeServer + ", exchangeDomain=" + this.exchangeDomain + ", exchangeUsingSSL=" + this.exchangeUsingSSL + ", activeSyncServer=" + this.activeSyncServer + ", activeSyncDomain=" + this.activeSyncDomain + ", activeSyncName=" + this.activeSyncName + ", activeSyncUsingSSL=" + this.activeSyncUsingSSL + ", imapServer=" + this.imapServer + ", imapPort=" + this.imapPort + ", imapSSLPort=" + this.imapSSLPort + ", imapUsingSSL=" + this.imapUsingSSL + ", pop3Server=" + this.pop3Server + ", pop3Port=" + this.pop3Port + ", pop3SSLPort=" + this.pop3SSLPort + ", pop3UsingSSL=" + this.pop3UsingSSL + ", smtpServer=" + this.smtpServer + ", smtpPort=" + this.smtpPort + ", smtpSSLPort=" + this.smtpSSLPort + ", smtpUsingSSL=" + this.smtpUsingSSL + ", sslConnection=" + this.sslConnection + ", needAuthentication=" + this.needAuthentication + ", useCloudSupport=" + this.useCloudSupport + ", cloudEditEnable=" + this.cloudEditEnable + ", imapName=" + this.imapName + ", pop3Name=" + this.pop3Name + ", exchangeName=" + this.exchangeName + ", smtpName=" + this.smtpName + "]";
      return str;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "MailServiceProvider", "toString err:" + localException.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.provider.MailServiceProvider
 * JD-Core Version:    0.7.0.1
 */