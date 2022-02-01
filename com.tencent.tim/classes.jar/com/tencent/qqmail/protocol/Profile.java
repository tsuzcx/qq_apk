package com.tencent.qqmail.protocol;

import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Profile
  implements Serializable
{
  public static final int PROXY_TYPE_HTTP = 2;
  public static final int PROXY_TYPE_NOUSE = 0;
  public static final int PROXY_TYPE_SOCKS4 = 3;
  public static final int PROXY_TYPE_SOCKS5 = 4;
  public static final int PROXY_TYPE_SOCKS5H = 5;
  public static final int PROXY_TYPE_SYSTEM = 1;
  private static final long serialVersionUID = 1L;
  public String QQPassword;
  public String accessToken;
  public String activeSyncDomain;
  public String activeSyncName;
  public String activeSyncPassword;
  public String activeSyncPolicyKey;
  public String activeSyncServer;
  public boolean activeSyncUsingSSL;
  public String activeSyncVersion = "14.0";
  public boolean conformsToBizMail;
  public boolean conformsToQQMail;
  public boolean connected;
  public int deleteRemoteCopy;
  public String deviceId;
  public String deviceType = "android";
  public String domain;
  public boolean enableSign;
  public String exchangeDomain;
  public boolean exchangeHttpLM;
  public String exchangeName;
  public String exchangePassword;
  public String exchangeServer;
  public boolean exchangeUsingSSL;
  public int exchangeVersion;
  public long expiresIn;
  public boolean firstUse;
  public String fromName;
  public boolean groupMailAuthorized;
  public String idToken;
  public String imageCode;
  public String imapName;
  public String imapPassword;
  public int imapPort;
  public String imapPortString;
  public int imapSSLPort;
  public String imapSSLPortString;
  public String imapServer;
  public String imapUserAgentId = "(\"name\" \"QQMail\" \"os\" \"Android\" \"os-version\" \"" + DeviceUtil.getDeviceInfos().releaseVersion + "\" \"version\" \"" + AppConfig.getCodeVersionName() + "\" \"vendor\" \"Tencent Limited\" \"contact\" \"helpapp@qq.com\")";
  public boolean imapUsingSSL;
  public boolean isOauth;
  public boolean isSupportGroupMail;
  public boolean labelSupport;
  public int localStorageLimit;
  public String mailAddress;
  public boolean needAuth;
  public boolean needVerifySend;
  public String nickName;
  public boolean nickNameConfirmed;
  public boolean notFirstEnterGroupMail;
  public String pop3Name;
  public String pop3Password;
  public int pop3Port;
  public String pop3PortString;
  public int pop3SSLPort;
  public String pop3SSLPortString;
  public String pop3Server;
  public boolean pop3UsingSSL;
  public int protocolType;
  public String proxyPassword;
  public int proxyPort;
  public String proxyServer;
  public int proxyType;
  public String proxyUsername;
  public String refreshToken;
  public boolean reset;
  public boolean serverSearch;
  public String sign;
  public String smtpName;
  public String smtpPassword;
  public int smtpPort;
  public String smtpPortString;
  public int smtpSSLPort;
  public String smtpSSLPortString;
  public String smtpServer;
  public boolean smtpUsingSSL;
  public String tokenType;
  public int unique_id;
  public boolean usedProxy;
  public String userAgent;
  public boolean usingSSL;
  
  public static int getProtocol(Profile paramProfile)
  {
    int i = 4;
    if (paramProfile.protocolType == 100) {
      i = 6;
    }
    while (paramProfile.protocolType == 3) {
      return i;
    }
    if (paramProfile.protocolType == 1) {
      return 1;
    }
    if (paramProfile.protocolType == 0) {
      return 2;
    }
    if (paramProfile.protocolType == 4) {
      return 3;
    }
    return 0;
  }
  
  public Profile deepCopy()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      new ObjectOutputStream((OutputStream)localObject).writeObject(this);
      localObject = (Profile)new ObjectInputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray())).readObject();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public String getDomain()
  {
    if (!StringExtention.isNullOrEmpty(this.mailAddress))
    {
      int i = this.mailAddress.indexOf("@");
      if (i != -1) {
        return this.mailAddress.substring(i + 1, this.mailAddress.length());
      }
    }
    return "";
  }
  
  public String toString()
  {
    return "Profile [localStorageLimit=" + this.localStorageLimit + ", deleteRemoteCopy=" + this.deleteRemoteCopy + ", imapPort=" + this.imapPort + ", imapSSLPort=" + this.imapSSLPort + ", pop3Port=" + this.pop3Port + ", pop3SSLPort=" + this.pop3SSLPort + ", smtpPort=" + this.smtpPort + ", smtpSSLPort=" + this.smtpSSLPort + ", protocolType=" + this.protocolType + ", imapUsingSSL=" + this.imapUsingSSL + ", pop3UsingSSL=" + this.pop3UsingSSL + ", smtpUsingSSL=" + this.smtpUsingSSL + ", usingSSL=" + this.usingSSL + ", mailAddress=" + this.mailAddress + ", nickName=" + this.nickName + ", imapName=" + this.imapName + ", imapServer=" + this.imapServer + ", imapPortString=" + this.imapPortString + ", imapSSLPortString=" + this.imapSSLPortString + ", exchangeName=" + this.exchangeName + ", exchangeServer=" + this.exchangeServer + ", activeSyncName=" + this.activeSyncName + ", activeSyncServer=" + this.activeSyncServer + ", pop3Name=" + this.pop3Name + ", pop3Server=" + this.pop3Server + ", pop3PortString=" + this.pop3PortString + ", pop3SSLPortString=" + this.pop3SSLPortString + ", smtpName=" + this.smtpName + ", smtpServer=" + this.smtpServer + ", smtpPortString=" + this.smtpPortString + ", smtpSSLPortString=" + this.smtpSSLPortString + ", activeSyncUsingSSL=" + this.activeSyncUsingSSL + ", exchangeUsingSSL=" + this.exchangeUsingSSL + ", exchangeHttpLM=" + this.exchangeHttpLM + ", exchangeVersion=" + this.exchangeVersion + ", activeSyncDomain=" + this.activeSyncDomain + ", exchangeDomain=" + this.exchangeDomain + ", activeSyncVersion=" + this.activeSyncVersion + ", activeSyncPolicyKey=" + this.activeSyncPolicyKey + ", domain=" + this.domain + ", needVerifySend=" + ", proxyServer=" + this.proxyServer + ", proxyport=" + this.proxyPort + ", needVerifySend=" + this.needVerifySend + ", accessToken=" + this.accessToken + ", refreshToken=" + this.refreshToken + ", tokenType=" + this.tokenType + ", expiresIn=" + this.expiresIn + ", idToken=" + this.idToken + ", isOauth=" + this.isOauth + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.Profile
 * JD-Core Version:    0.7.0.1
 */