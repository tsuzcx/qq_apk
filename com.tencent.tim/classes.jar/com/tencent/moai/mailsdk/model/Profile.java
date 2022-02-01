package com.tencent.moai.mailsdk.model;

public class Profile
{
  public static final int PROTOCOL_ACTIVE_SYNC = 4;
  public static final int PROTOCOL_EXCHANGE = 5;
  public static final int PROTOCOL_IMAP = 2;
  public static final int PROTOCOL_POP3 = 3;
  public static final int PROTOCOL_SMTP = 1;
  public static final int PROTOCOL_UNKNOWN = 0;
  private String accessToken;
  private String activeSyncDomain;
  private String activeSyncName;
  private String activeSyncPassword;
  private String activeSyncPolicyKey;
  private String activeSyncServer;
  private boolean activeSyncUsingSSL;
  private String activeSyncVersion;
  private String deviceId;
  private String deviceType;
  private String exchangeDomain;
  private boolean exchangeHttpLM;
  private String exchangeName;
  private String exchangePassword;
  private String exchangeServer;
  private boolean exchangeUsingSSL;
  private String exchangeVersion;
  private long expiresIn;
  private String idToken;
  private String imapAuthzid;
  private String imapName;
  private String imapNtlmDomain;
  private int imapNtlmFlag;
  private String imapPassword;
  private int imapPort;
  private int imapSSLPort;
  private String imapServer;
  private String imapUserAgent;
  private boolean imapUsingSSL;
  private boolean isOauth;
  private String mailAddress;
  private String popName;
  private String popPassword;
  private int popPort;
  private int popSSLPort;
  private String popServer;
  private boolean popUsingSSL;
  private int protocol = 0;
  private String proxyPassword;
  private int proxyPort = -1;
  private String proxyServer;
  private String proxyUserName;
  private String refreshToken;
  private String smtpAuthzid;
  private String smtpDigistMd5Host;
  private String smtpDigistMd5Realm;
  private String smtpName;
  private String smtpNtlmDomain;
  private int smtpNtlmFlag;
  private String smtpPassword;
  private int smtpPort;
  private int smtpSSLPort;
  private String smtpServer;
  private boolean smtpUsingSSL;
  private String tokenType;
  
  public String getAccessToken()
  {
    return this.accessToken;
  }
  
  public String getActiveSyncDomain()
  {
    return this.activeSyncDomain;
  }
  
  public String getActiveSyncName()
  {
    return this.activeSyncName;
  }
  
  public String getActiveSyncPassword()
  {
    return this.activeSyncPassword;
  }
  
  public String getActiveSyncPolicyKey()
  {
    return this.activeSyncPolicyKey;
  }
  
  public String getActiveSyncServer()
  {
    return this.activeSyncServer;
  }
  
  public String getActiveSyncVersion()
  {
    return this.activeSyncVersion;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public String getExchangeDomain()
  {
    return this.exchangeDomain;
  }
  
  public String getExchangeName()
  {
    return this.exchangeName;
  }
  
  public String getExchangePassword()
  {
    return this.exchangePassword;
  }
  
  public String getExchangeServer()
  {
    return this.exchangeServer;
  }
  
  public String getExchangeVersion()
  {
    return this.exchangeVersion;
  }
  
  public long getExpiresIn()
  {
    return this.expiresIn;
  }
  
  public String getIdToken()
  {
    return this.idToken;
  }
  
  public String getImapAuthzid()
  {
    return this.imapAuthzid;
  }
  
  public String getImapName()
  {
    return this.imapName;
  }
  
  public String getImapNtlmDomain()
  {
    return this.imapNtlmDomain;
  }
  
  public int getImapNtlmFlag()
  {
    return this.imapNtlmFlag;
  }
  
  public String getImapPassword()
  {
    return this.imapPassword;
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
  
  public String getImapUserAgent()
  {
    return this.imapUserAgent;
  }
  
  public String getMailAddress()
  {
    return this.mailAddress;
  }
  
  public String getPopName()
  {
    return this.popName;
  }
  
  public String getPopPassword()
  {
    return this.popPassword;
  }
  
  public int getPopPort()
  {
    return this.popPort;
  }
  
  public int getPopSSLPort()
  {
    return this.popSSLPort;
  }
  
  public String getPopServer()
  {
    return this.popServer;
  }
  
  public int getProtocol()
  {
    return this.protocol;
  }
  
  public String getProxyPassword()
  {
    return this.proxyPassword;
  }
  
  public int getProxyPort()
  {
    return this.proxyPort;
  }
  
  public String getProxyServer()
  {
    return this.proxyServer;
  }
  
  public String getProxyUserName()
  {
    return this.proxyUserName;
  }
  
  public String getRefreshToken()
  {
    return this.refreshToken;
  }
  
  public String getSmtpAuthzid()
  {
    return this.smtpAuthzid;
  }
  
  public String getSmtpDigistMd5Host()
  {
    return this.smtpDigistMd5Host;
  }
  
  public String getSmtpDigistMd5Realm()
  {
    return this.smtpDigistMd5Realm;
  }
  
  public String getSmtpName()
  {
    return this.smtpName;
  }
  
  public String getSmtpNtlmDomain()
  {
    return this.smtpNtlmDomain;
  }
  
  public int getSmtpNtlmFlag()
  {
    return this.smtpNtlmFlag;
  }
  
  public String getSmtpPassword()
  {
    return this.smtpPassword;
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
  
  public String getTokenType()
  {
    return this.tokenType;
  }
  
  public boolean isActiveSyncUsingSSL()
  {
    return this.activeSyncUsingSSL;
  }
  
  public boolean isExchangeHttpLM()
  {
    return this.exchangeHttpLM;
  }
  
  public boolean isExchangeUsingSSL()
  {
    return this.exchangeUsingSSL;
  }
  
  public boolean isImapUsingSSL()
  {
    return this.imapUsingSSL;
  }
  
  public boolean isOauth()
  {
    return this.isOauth;
  }
  
  public boolean isPopUsingSSL()
  {
    return this.popUsingSSL;
  }
  
  public boolean isSmtpUsingSSL()
  {
    return this.smtpUsingSSL;
  }
  
  public void setAccessToken(String paramString)
  {
    this.accessToken = paramString;
  }
  
  public void setActiveSyncDomain(String paramString)
  {
    this.activeSyncDomain = paramString;
  }
  
  public void setActiveSyncName(String paramString)
  {
    this.activeSyncName = paramString;
  }
  
  public void setActiveSyncPassword(String paramString)
  {
    this.activeSyncPassword = paramString;
  }
  
  public void setActiveSyncPolicyKey(String paramString)
  {
    this.activeSyncPolicyKey = paramString;
  }
  
  public void setActiveSyncServer(String paramString)
  {
    this.activeSyncServer = paramString;
  }
  
  public void setActiveSyncUsingSSL(boolean paramBoolean)
  {
    this.activeSyncUsingSSL = paramBoolean;
  }
  
  public void setActiveSyncVersion(String paramString)
  {
    this.activeSyncVersion = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public void setExchangeDomain(String paramString)
  {
    this.exchangeDomain = paramString;
  }
  
  public void setExchangeHttpLM(boolean paramBoolean)
  {
    this.exchangeHttpLM = paramBoolean;
  }
  
  public void setExchangeName(String paramString)
  {
    this.exchangeName = paramString;
  }
  
  public void setExchangePassword(String paramString)
  {
    this.exchangePassword = paramString;
  }
  
  public void setExchangeServer(String paramString)
  {
    this.exchangeServer = paramString;
  }
  
  public void setExchangeUsingSSL(boolean paramBoolean)
  {
    this.exchangeUsingSSL = paramBoolean;
  }
  
  public void setExchangeVersion(String paramString)
  {
    this.exchangeVersion = paramString;
  }
  
  public void setExpiresIn(long paramLong)
  {
    this.expiresIn = paramLong;
  }
  
  public void setIdToken(String paramString)
  {
    this.idToken = paramString;
  }
  
  public void setImapAuthzid(String paramString)
  {
    this.imapAuthzid = paramString;
  }
  
  public void setImapName(String paramString)
  {
    this.imapName = paramString;
  }
  
  public void setImapNtlmDomain(String paramString)
  {
    this.imapNtlmDomain = paramString;
  }
  
  public void setImapNtlmFlag(int paramInt)
  {
    this.imapNtlmFlag = paramInt;
  }
  
  public void setImapPassword(String paramString)
  {
    this.imapPassword = paramString;
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
  
  public void setImapUserAgent(String paramString)
  {
    this.imapUserAgent = paramString;
  }
  
  public void setImapUsingSSL(boolean paramBoolean)
  {
    this.imapUsingSSL = paramBoolean;
  }
  
  public void setMailAddress(String paramString)
  {
    this.mailAddress = paramString;
  }
  
  public void setOauth(boolean paramBoolean)
  {
    this.isOauth = paramBoolean;
  }
  
  public void setPopName(String paramString)
  {
    this.popName = paramString;
  }
  
  public void setPopPassword(String paramString)
  {
    this.popPassword = paramString;
  }
  
  public void setPopPort(int paramInt)
  {
    this.popPort = paramInt;
  }
  
  public void setPopSSLPort(int paramInt)
  {
    this.popSSLPort = paramInt;
  }
  
  public void setPopServer(String paramString)
  {
    this.popServer = paramString;
  }
  
  public void setPopUsingSSL(boolean paramBoolean)
  {
    this.popUsingSSL = paramBoolean;
  }
  
  public void setProtocol(int paramInt)
  {
    this.protocol = paramInt;
  }
  
  public void setProxyPassword(String paramString)
  {
    this.proxyPassword = paramString;
  }
  
  public void setProxyPort(int paramInt)
  {
    this.proxyPort = paramInt;
  }
  
  public void setProxyServer(String paramString)
  {
    this.proxyServer = paramString;
  }
  
  public void setProxyUserName(String paramString)
  {
    this.proxyUserName = paramString;
  }
  
  public void setRefreshToken(String paramString)
  {
    this.refreshToken = paramString;
  }
  
  public void setSmtpAuthzid(String paramString)
  {
    this.smtpAuthzid = paramString;
  }
  
  public void setSmtpDigistMd5Host(String paramString)
  {
    this.smtpDigistMd5Host = paramString;
  }
  
  public void setSmtpDigistMd5Realm(String paramString)
  {
    this.smtpDigistMd5Realm = paramString;
  }
  
  public void setSmtpName(String paramString)
  {
    this.smtpName = paramString;
  }
  
  public void setSmtpNtlmDomain(String paramString)
  {
    this.smtpNtlmDomain = paramString;
  }
  
  public void setSmtpNtlmFlag(int paramInt)
  {
    this.smtpNtlmFlag = paramInt;
  }
  
  public void setSmtpPassword(String paramString)
  {
    this.smtpPassword = paramString;
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
  
  public void setTokenType(String paramString)
  {
    this.tokenType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.model.Profile
 * JD-Core Version:    0.7.0.1
 */