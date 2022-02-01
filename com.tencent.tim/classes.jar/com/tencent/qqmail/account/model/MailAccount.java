package com.tencent.qqmail.account.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.accountlist.QMAccountHelper;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolInfo;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMProxy;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import moai.oss.KvHelper;
import moai.oss.OssHelper;
import org.apache.commons.lang3.StringUtils;

public class MailAccount
  extends Account
{
  private static final String TAG = "MailAccount";
  private long lastDeAesThreadId = 0L;
  private long lastDeAesTime = 0L;
  private volatile Profile mProfile;
  
  private String encodePwd(String paramString)
  {
    String str3 = Aes.getPureDeviceToken();
    String str2 = Aes.encode(paramString, str3);
    if (str2 == null) {}
    for (String str1 = "";; str1 = Aes.decode(str2, str3))
    {
      if ((StringExtention.isNullOrEmpty(paramString)) || (!paramString.equals(str1)))
      {
        KvHelper.decodeErrorAfterEncode(new double[0]);
        OssHelper.protocolOsslog(new Object[] { "decode_pwd_err", "after_encode", "" + str1, "" + str2, str3 });
      }
      paramString = SPManager.getSp("accounts_info");
      str1 = "" + str2 + "#" + str3;
      paramString.edit().putString("encode_data_" + getEmail(), str1).apply();
      return str2;
    }
  }
  
  private static void fillConfigProxy(Profile paramProfile, boolean paramBoolean)
  {
    if ((paramProfile != null) && (paramProfile.mailAddress != null) && (paramProfile.mailAddress.split("@").length > 1)) {
      if (!paramBoolean) {
        break label167;
      }
    }
    label167:
    for (Object localObject = "gmail.com";; localObject = paramProfile.mailAddress.split("@")[1])
    {
      localObject = QMProxyUtil.getSock5HProxy((String)localObject);
      if (localObject != null)
      {
        paramProfile.proxyType = ((QMProxy)localObject).transferProfileProxyType();
        paramProfile.proxyUsername = ((QMProxy)localObject).getProxyUserName();
        paramProfile.proxyPassword = ((QMProxy)localObject).getProxyPassword();
        paramProfile.proxyServer = ((QMProxy)localObject).getProxyHost();
        paramProfile.proxyPort = ((QMProxy)localObject).getProxyPort();
        QMLog.log(4, "MailAccount", "isOauth " + paramBoolean + ",proxyType:" + paramProfile.proxyType + ",proxyUsername:" + paramProfile.proxyUsername + ",proxyPassword:" + paramProfile.proxyPassword + ",proxyServer:" + paramProfile.proxyServer + ",proxyPort:" + paramProfile.proxyPort);
      }
      return;
    }
  }
  
  private static void fillProfile(String paramString1, Profile paramProfile, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    label212:
    label487:
    label617:
    label623:
    label629:
    label635:
    do
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder().append("QQMail/Android/").append(AppConfig.getCodeVersion()).append("/");
      Object localObject;
      boolean bool;
      if (Build.VERSION.RELEASE == null)
      {
        localObject = "";
        paramProfile.userAgent = ((String)localObject);
        localObject = paramString1.split("\\|", -1);
        paramProfile.protocolType = Integer.parseInt(localObject[0].split("\\,", -1)[0]);
        paramString1 = localObject[1].split("\\,", -1);
        paramProfile.proxyType = Integer.parseInt(paramString1[0]);
        paramProfile.proxyServer = paramString1[1];
        paramProfile.proxyPort = Integer.parseInt(paramString1[2]);
        paramProfile.proxyUsername = paramString1[3];
        paramProfile.proxyPassword = paramString1[4];
        if (!TextUtils.isEmpty(paramProfile.proxyPassword)) {
          paramProfile.proxyPassword = Aes.decode(paramProfile.proxyPassword, Aes.getPureDeviceToken());
        }
        paramString1 = localObject[2].split("\\,", -1);
        paramProfile.smtpServer = paramString1[0];
        paramProfile.smtpPort = Integer.parseInt(paramString1[1]);
        paramProfile.smtpSSLPort = Integer.parseInt(paramString1[2]);
        if (Integer.parseInt(paramString1[3]) != 1) {
          break label611;
        }
        bool = true;
        paramProfile.smtpUsingSSL = bool;
        paramProfile.smtpName = paramString3;
        if (((paramString4 == null) || (paramString4.equals(""))) && (paramProfile.accessToken == null)) {
          QMLog.log(5, "MailAccount", "sendPsw empty:" + paramProfile.mailAddress);
        }
        paramProfile.smtpPassword = paramString4;
        paramString1 = localObject[3].split("\\,", -1);
        paramProfile.pop3Server = paramString1[0];
        paramProfile.pop3Port = Integer.parseInt(paramString1[1]);
        paramProfile.pop3SSLPort = Integer.parseInt(paramString1[2]);
        if (Integer.parseInt(paramString1[3]) != 1) {
          break label617;
        }
        bool = true;
        paramProfile.pop3UsingSSL = bool;
        if (((paramString2 == null) || (paramString2.equals(""))) && (StringUtility.isNullOrEmpty(paramProfile.accessToken))) {
          QMLog.log(5, "MailAccount", "receivePsw empty:" + paramProfile.mailAddress);
        }
        paramProfile.pop3Password = paramString2;
        paramString1 = localObject[4].split("\\,", -1);
        paramProfile.imapServer = paramString1[0];
        paramProfile.imapPort = Integer.parseInt(paramString1[1]);
        paramProfile.imapSSLPort = Integer.parseInt(paramString1[2]);
        if (Integer.parseInt(paramString1[3]) != 1) {
          break label623;
        }
        bool = true;
        paramProfile.imapUsingSSL = bool;
        paramProfile.imapPassword = paramString2;
        paramString1 = localObject[5].split("\\,", -1);
        paramProfile.exchangeServer = paramString1[0];
        if (Integer.parseInt(paramString1[1]) != 1) {
          break label629;
        }
        bool = true;
        paramProfile.exchangeUsingSSL = bool;
        paramProfile.exchangePassword = paramString2;
        paramProfile.usingSSL = true;
        paramString1 = localObject[6].split("\\,", -1);
        paramProfile.activeSyncServer = paramString1[0];
        paramProfile.activeSyncDomain = paramString1[1];
        if (Integer.parseInt(paramString1[2]) != 1) {
          break label635;
        }
        bool = true;
        paramProfile.activeSyncUsingSSL = bool;
        paramProfile.activeSyncVersion = paramString1[3];
        if (paramString1.length <= 4) {
          break label641;
        }
      }
      for (paramString1 = paramString1[4];; paramString1 = "")
      {
        paramProfile.activeSyncPolicyKey = paramString1;
        paramProfile.activeSyncPassword = paramString2;
        paramString1 = localObject[7].split("\\,", -1);
        if (paramProfile.protocolType != 1) {
          break label647;
        }
        paramProfile.imapName = paramString1[0];
        return;
        localObject = Build.VERSION.RELEASE;
        break;
        bool = false;
        break label212;
        bool = false;
        break label331;
        bool = false;
        break label445;
        bool = false;
        break label487;
        bool = false;
        break label542;
      }
      if (paramProfile.protocolType == 0)
      {
        paramProfile.pop3Name = paramString1[0];
        return;
      }
      if (paramProfile.protocolType == 3)
      {
        paramProfile.exchangeName = paramString1[0];
        paramProfile.exchangeDomain = paramString1[1];
        paramProfile.exchangeHttpLM = paramString1[2].equals("1");
        paramProfile.exchangeVersion = Integer.parseInt(paramString1[3]);
        return;
      }
    } while (paramProfile.protocolType != 4);
    label331:
    label611:
    paramProfile.activeSyncName = paramString1[0];
    label445:
    paramProfile.activeSyncDomain = paramString1[1];
    label542:
    paramProfile.userAgent = paramString1[2];
    label641:
    label647:
    return;
  }
  
  private void fillSmtpServer(int paramInt, Profile paramProfile)
  {
    String str1;
    String str3;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (paramInt != 0) {
        break label206;
      }
      str1 = "pop.";
      String str2 = str1 + this.mProfile.domain;
      str3 = "smtp." + this.mProfile.domain;
      if (str1.startsWith("pop"))
      {
        if ((this.mProfile.pop3Server == null) || (!this.mProfile.pop3Server.equals(str2))) {
          break label213;
        }
        paramProfile.smtpServer = str3;
      }
      label112:
      if (str1.startsWith("imap")) {
        if ((this.mProfile.imapServer == null) || (!this.mProfile.imapServer.equals(str2))) {
          break label224;
        }
      }
    }
    label206:
    label213:
    label224:
    for (paramProfile.smtpServer = str3;; paramProfile.smtpServer = paramProfile.imapServer)
    {
      if (paramProfile.smtpPort == 0) {
        paramProfile.smtpPort = Integer.valueOf(QMApplicationContext.sharedInstance().getString(2131720368)).intValue();
      }
      if (paramProfile.smtpSSLPort == 0) {
        paramProfile.smtpSSLPort = Integer.valueOf(QMApplicationContext.sharedInstance().getString(2131720370)).intValue();
      }
      return;
      str1 = "imap.";
      break;
      paramProfile.smtpServer = paramProfile.pop3Server;
      break label112;
    }
  }
  
  public static String getActiveSyncProfileString(Profile paramProfile)
  {
    return getNullableName(paramProfile.activeSyncVersion) + "," + getNullableName(paramProfile.activeSyncPolicyKey);
  }
  
  private static String getNullableName(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static Profile getProfile(Account paramAccount)
  {
    if (paramAccount == null) {
      return null;
    }
    Profile localProfile = new Profile();
    String str2 = paramAccount.getDeviceId();
    localProfile.deviceId = str2;
    if (!TextUtils.isEmpty(paramAccount.getPwd())) {}
    for (String str1 = Aes.decode(paramAccount.getPwd(), str2);; str1 = null)
    {
      if ((str1 == null) || (str1.equals(""))) {
        Threads.runInBackground(new MailAccount.3(paramAccount));
      }
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (paramAccount.getSmtppwd() != null)
      {
        localObject1 = localObject2;
        if (!paramAccount.getSmtppwd().equals("")) {
          localObject1 = Aes.decode(paramAccount.getSmtppwd(), str2);
        }
      }
      if ((localObject1 == null) || (((String)localObject1).equals("")))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendpwdempty:").append(paramAccount.getEmail());
        if (AppConfig.isBeta())
        {
          ((StringBuilder)localObject2).append("#");
          ((StringBuilder)localObject2).append(paramAccount.getSmtppwd());
          ((StringBuilder)localObject2).append("#");
          ((StringBuilder)localObject2).append(str2);
        }
        QMLogStream.logWithoutUma(-40035, ((StringBuilder)localObject2).toString(), "Event_Error");
      }
      localProfile.mailAddress = paramAccount.getEmail();
      localObject2 = paramAccount.getName();
      localProfile.fromName = ((String)localObject2);
      localProfile.nickName = ((String)localObject2);
      localObject2 = paramAccount.getSmtpUserName();
      fillProfile(paramAccount.getProfileString(), localProfile, str1, (String)localObject2, (String)localObject1);
      localProfile.unique_id = paramAccount.getId();
      if (paramAccount.isImapMail())
      {
        str1 = QMSettingManager.sharedInstance().getImapUserAgentId();
        if ((str1 != null) && (!str1.equals(""))) {
          localProfile.imapUserAgentId = str1.replace("$os$", "Android").replace("$osversion$", DeviceUtil.getDeviceInfos().releaseVersion).replace("$appversion$", AppConfig.getCodeVersionName());
        }
      }
      if (!StringExtention.isNullOrEmpty(paramAccount.getRefreshToken()))
      {
        localProfile.isOauth = true;
        localProfile.accessToken = paramAccount.getAccessToken();
        localProfile.refreshToken = paramAccount.getRefreshToken();
        localProfile.expiresIn = ((int)paramAccount.getExpireIn());
        localProfile.idToken = paramAccount.getIdToken();
        localProfile.tokenType = paramAccount.getTokenType();
        if (StringExtention.isNullOrEmpty(localProfile.accessToken)) {
          OssHelper.protocolOsslog(new Object[] { "gmail_access_token_empty", localProfile.mailAddress });
        }
      }
      fillConfigProxy(localProfile, localProfile.isOauth);
      return localProfile;
    }
  }
  
  public static String getProfileString(Profile paramProfile)
  {
    int j = 0;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(String.valueOf(paramProfile.protocolType)).append("|");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramProfile.proxyType).append(",");
    ((StringBuilder)localObject).append(getNullableName(paramProfile.proxyServer)).append(",");
    ((StringBuilder)localObject).append(paramProfile.proxyPort).append(",");
    ((StringBuilder)localObject).append(getNullableName(paramProfile.proxyUsername)).append(",");
    if ((paramProfile.proxyPassword != null) && (!paramProfile.proxyPassword.equals(""))) {
      ((StringBuilder)localObject).append(Aes.encode(paramProfile.proxyPassword, Aes.getPureDeviceToken()));
    }
    localStringBuilder1.append(((StringBuilder)localObject).toString()).append("|");
    localObject = new StringBuilder().append(getNullableName(paramProfile.smtpServer)).append(",").append(paramProfile.smtpPort).append(",").append(paramProfile.smtpSSLPort).append(",");
    int i;
    label292:
    label371:
    StringBuilder localStringBuilder2;
    if (paramProfile.smtpUsingSSL)
    {
      i = 1;
      localStringBuilder1.append(i).append("|");
      localObject = new StringBuilder().append(getNullableName(paramProfile.pop3Server)).append(",").append(paramProfile.pop3Port).append(",").append(paramProfile.pop3SSLPort).append(",");
      if (!paramProfile.pop3UsingSSL) {
        break label606;
      }
      i = 1;
      localStringBuilder1.append(i).append("|");
      localObject = new StringBuilder().append(getNullableName(paramProfile.imapServer)).append(",").append(paramProfile.imapPort).append(",").append(paramProfile.imapSSLPort).append(",");
      if (!paramProfile.imapUsingSSL) {
        break label611;
      }
      i = 1;
      localStringBuilder1.append(i).append("|");
      localObject = new StringBuilder().append(getNullableName(paramProfile.exchangeServer)).append(",");
      if (!paramProfile.exchangeUsingSSL) {
        break label616;
      }
      i = 1;
      label424:
      localStringBuilder1.append(i).append("|");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getNullableName(paramProfile.activeSyncServer)).append(",");
      ((StringBuilder)localObject).append(getNullableName(paramProfile.activeSyncDomain)).append(",");
      i = j;
      if (paramProfile.activeSyncUsingSSL) {
        i = 1;
      }
      ((StringBuilder)localObject).append(i).append(",");
      ((StringBuilder)localObject).append(getNullableName(paramProfile.activeSyncVersion)).append(",");
      ((StringBuilder)localObject).append(getNullableName(paramProfile.activeSyncPolicyKey));
      localStringBuilder1.append((CharSequence)localObject).append("|");
      localStringBuilder2 = new StringBuilder();
      if (paramProfile.protocolType != 1) {
        break label621;
      }
      localStringBuilder2.append(getNullableName(paramProfile.imapName));
    }
    for (;;)
    {
      localStringBuilder1.append(localStringBuilder2.toString());
      return localStringBuilder1.toString();
      i = 0;
      break;
      label606:
      i = 0;
      break label292;
      label611:
      i = 0;
      break label371;
      label616:
      i = 0;
      break label424;
      label621:
      if (paramProfile.protocolType == 0)
      {
        localStringBuilder2.append(getNullableName(paramProfile.pop3Name));
      }
      else
      {
        if (paramProfile.protocolType == 3)
        {
          localStringBuilder2.append(getNullableName(paramProfile.exchangeName)).append(",");
          localStringBuilder2.append(getNullableName(paramProfile.exchangeDomain)).append(",");
          if (paramProfile.exchangeHttpLM) {}
          for (localObject = Integer.valueOf(1);; localObject = "0,")
          {
            localStringBuilder2.append(localObject);
            localStringBuilder2.append(paramProfile.exchangeVersion);
            break;
          }
        }
        if (paramProfile.protocolType == 4)
        {
          localStringBuilder2.append(getNullableName(paramProfile.activeSyncName)).append(",");
          localStringBuilder2.append(getNullableName(paramProfile.activeSyncDomain)).append(",");
          localStringBuilder2.append(getNullableName(paramProfile.userAgent));
        }
      }
    }
  }
  
  private static String getUserNameByStyle(String paramString, int paramInt)
  {
    String str = paramString;
    if ((paramInt & 0x2) != 0) {
      str = paramString.split("@")[0];
    }
    return str;
  }
  
  private boolean isConnectError(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 10) || (paramInt == 15) || (paramInt == 3);
  }
  
  private boolean isNetworkError(int paramInt)
  {
    return (paramInt == 5) && (!QMNetworkUtils.isNetworkAvailable());
  }
  
  private void saveUser()
  {
    setName(this.mProfile.mailAddress.split("@")[0]);
    setEmail(this.mProfile.mailAddress);
    setDeviceId(Aes.getPureDeviceToken());
    int i;
    String str1;
    if (isQQMail())
    {
      i = generateId(getUin());
      setId(i);
      str1 = "";
      switch (this.mProfile.protocolType)
      {
      case 2: 
      default: 
        str1 = "";
        i = -1;
      }
    }
    for (;;)
    {
      String str3 = "";
      String str2 = str3;
      if (this.mProfile.smtpPassword != null)
      {
        str2 = str3;
        if (!this.mProfile.smtpPassword.equals("")) {
          str2 = Aes.encode(this.mProfile.smtpPassword, Aes.getPureDeviceToken());
        }
      }
      setPwd(str1);
      setSmtppwd(str2);
      setSmtpUserName(this.mProfile.smtpName);
      setProtocol(i);
      if ((this.mProfile.smtpServer == null) || (this.mProfile.smtpServer.equals(""))) {
        fillSmtpServer(this.mProfile.protocolType, this.mProfile);
      }
      if (this.mProfile.isOauth)
      {
        setAccessToken(this.mProfile.accessToken);
        setRefreshToken(this.mProfile.refreshToken);
        setTokenType(this.mProfile.tokenType);
        setExpireIn(this.mProfile.expiresIn);
        setIdToken(this.mProfile.idToken);
        setLastTokenTime(System.currentTimeMillis());
      }
      setProfileString(getProfileString(this.mProfile));
      setActiveSyncProfileString(getActiveSyncProfileString(this.mProfile));
      setLogined();
      return;
      i = generateId(getEmail());
      break;
      str1 = encodePwd(this.mProfile.pop3Password);
      i = 11;
      continue;
      if (!TextUtils.isEmpty(this.mProfile.imapPassword)) {
        str1 = encodePwd(this.mProfile.imapPassword);
      }
      i = 12;
      continue;
      str1 = encodePwd(this.mProfile.exchangePassword);
      i = 13;
      continue;
      str1 = encodePwd(this.mProfile.activeSyncPassword);
      i = 14;
    }
  }
  
  private void setInfoToProfile(Profile paramProfile, ProtocolInfo[] paramArrayOfProtocolInfo)
  {
    if ((paramProfile == null) || (paramArrayOfProtocolInfo == null) || (paramArrayOfProtocolInfo.length == 0)) {}
    int j;
    int i;
    do
    {
      return;
      QMLog.log(4, "MailAccount", "setInfoToProfile");
      j = paramArrayOfProtocolInfo.length;
      i = 0;
    } while (i >= j);
    ProtocolInfo localProtocolInfo = paramArrayOfProtocolInfo[i];
    Log.w("MailAccount", "" + localProtocolInfo.toString());
    String str1 = localProtocolInfo.server_addr_;
    String str2 = localProtocolInfo.username_;
    String str3 = localProtocolInfo.server_domain_;
    String str4 = localProtocolInfo.activesync_version_;
    String str5 = localProtocolInfo.activesync_policykey_;
    boolean bool1 = localProtocolInfo.ssl_support_;
    boolean bool2 = localProtocolInfo.http_realm_;
    switch (localProtocolInfo.type_)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      QMLog.log(4, "MailAccount", "server back. pop :" + str1 + "," + str2 + ", " + bool1);
      paramProfile.pop3Server = str1;
      paramProfile.pop3Name = str2;
      paramProfile.pop3UsingSSL = bool1;
      continue;
      QMLog.log(4, "MailAccount", "server back. imap :" + str1 + "," + str2 + ", " + bool1);
      paramProfile.imapServer = str1;
      paramProfile.imapName = str2;
      paramProfile.imapUsingSSL = bool1;
      continue;
      QMLog.log(4, "MailAccount", "server back. smtp :" + str1 + "," + str2 + ", " + bool1);
      paramProfile.smtpServer = str1;
      paramProfile.smtpName = str2;
      paramProfile.smtpUsingSSL = bool1;
      continue;
      QMLog.log(4, "MailAccount", "server back. ex :" + str1 + "," + str2 + ", " + bool1);
      paramProfile.exchangeServer = str1;
      paramProfile.exchangeName = str2;
      paramProfile.exchangeUsingSSL = bool1;
      paramProfile.exchangeDomain = str3;
      paramProfile.exchangeHttpLM = bool2;
      paramProfile.exchangeVersion = localProtocolInfo.exchange_version_;
      continue;
      QMLog.log(4, "MailAccount", "server back. ac :" + str1 + "," + str2 + ", " + bool1 + "," + str3 + "," + str5 + "," + str4);
      paramProfile.activeSyncServer = str1;
      paramProfile.activeSyncName = str2;
      paramProfile.activeSyncUsingSSL = bool1;
      paramProfile.activeSyncDomain = str3;
      paramProfile.activeSyncVersion = str4;
      paramProfile.activeSyncPolicyKey = str5;
    }
  }
  
  private void setSend(MailServiceProvider paramMailServiceProvider, String paramString1, String paramString2)
  {
    this.mProfile.smtpServer = paramMailServiceProvider.getSmtpServer();
    this.mProfile.smtpPort = paramMailServiceProvider.getSmtpPort();
    this.mProfile.smtpSSLPort = paramMailServiceProvider.getSmtpSSLPort();
    this.mProfile.smtpUsingSSL = paramMailServiceProvider.isSmtpUsingSSL();
    this.mProfile.smtpName = paramString1;
    this.mProfile.smtpPassword = paramString2;
  }
  
  public Profile getProfile()
  {
    if ((this.mProfile == null) || (this.mProfile.reset)) {}
    for (;;)
    {
      try
      {
        if ((this.mProfile == null) || (this.mProfile.reset)) {
          this.mProfile = getProfile(this);
        }
        if ((this.mProfile != null) && ((StringUtils.isEmpty(this.mProfile.imapPassword)) || (StringUtils.isEmpty(this.mProfile.pop3Password)) || (StringUtils.isEmpty(this.mProfile.exchangePassword)) || (StringUtils.isEmpty(this.mProfile.activeSyncPassword))))
        {
          l = Thread.currentThread().getId();
          if (l != this.lastDeAesThreadId)
          {
            this.lastDeAesThreadId = l;
            this.lastDeAesTime = new Date().getTime();
            reDeAesPwd();
          }
        }
        else
        {
          return this.mProfile;
        }
      }
      finally {}
      long l = new Date().getTime();
      if (l - this.lastDeAesTime > 180000L)
      {
        this.lastDeAesTime = l;
        reDeAesPwd();
      }
    }
  }
  
  public void login(long paramLong1, int paramInt1, Profile paramProfile, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, boolean paramBoolean2)
  {
    paramProfile.needVerifySend = paramBoolean1;
    paramProfile.deviceId = CloudProtocolHelper.getDeviceId();
    if ((paramProfile.domain != null) && (paramBoolean2)) {}
    try
    {
      paramProfile.accessToken = QMAccountHelper.calcGmailAccessToken(paramProfile.mailAddress, paramString1);
      paramProfile.refreshToken = paramString2;
      paramProfile.tokenType = paramString3;
      paramProfile.expiresIn = paramLong2;
      paramProfile.idToken = paramString4;
      paramProfile.isOauth = true;
      QMLog.log(4, "MailAccount", "gmail auth. " + paramProfile.protocolType + ";" + paramProfile.accessToken + ";" + paramProfile.refreshToken + ";" + paramProfile.tokenType + ";" + paramProfile.expiresIn + ";" + paramProfile.idToken + ";" + true + ";");
      fillConfigProxy(paramProfile, paramBoolean2);
      QMLog.log(4, "MailAccount", "setting verify acc. profile : " + getProfileString(paramProfile));
      paramString1 = new MailAccount.1(this, paramProfile, paramLong1, paramInt1);
      QMMailManager.sharedInstance().login(paramProfile, paramString1, paramBoolean1);
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void login(long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MailServiceProvider paramMailServiceProvider, boolean paramBoolean1, String paramString6, String paramString7, String paramString8, long paramLong2, String paramString9, boolean paramBoolean2)
  {
    this.mProfile = new Profile();
    this.mProfile.mailAddress = paramString1;
    this.mProfile.domain = paramString1.split("@")[1];
    String str2 = paramMailServiceProvider.getDefaultRecvProtocol();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.equals("")) {}
    }
    else
    {
      str1 = "ActiveSync";
    }
    if (str1.equalsIgnoreCase("POP3"))
    {
      this.mProfile.protocolType = 0;
      this.mProfile.pop3Name = getUserNameByStyle(paramString2, paramMailServiceProvider.getPop3Name());
      this.mProfile.pop3Password = paramString3;
      this.mProfile.pop3Server = paramMailServiceProvider.getPop3Server();
      this.mProfile.pop3UsingSSL = paramMailServiceProvider.isPop3UsingSSL();
      this.mProfile.pop3Port = paramMailServiceProvider.getPop3Port();
      this.mProfile.pop3SSLPort = paramMailServiceProvider.getPop3SSLPort();
      QMLog.log(4, "MailAccount", "pop;" + this.mProfile.protocolType + ";" + this.mProfile.pop3Name + ";" + this.mProfile.pop3Server + ";" + this.mProfile.usingSSL + ";" + this.mProfile.pop3Port + ";" + this.mProfile.pop3SSLPort + ";" + paramString1 + ";" + paramString2 + ";" + paramString4 + ";" + paramBoolean1);
    }
    for (;;)
    {
      this.mProfile.deviceId = CloudProtocolHelper.getDeviceId();
      setSend(paramMailServiceProvider, paramString4, paramString5);
      this.mProfile.needVerifySend = paramBoolean1;
      if ((paramBoolean1) && (this.mProfile != null)) {
        QMLog.log(4, "MailAccount", "smtpsetting. " + this.mProfile.protocolType + ";" + this.mProfile.smtpName + ";" + this.mProfile.smtpServer + ";" + this.mProfile.smtpUsingSSL + ";" + this.mProfile.smtpPort + ";" + this.mProfile.smtpSSLPort);
      }
      fillConfigProxy(this.mProfile, paramBoolean2);
      if (this.mProfile != null) {
        QMLog.log(4, "MailAccount", ",proxytype:" + this.mProfile.proxyType + ",proxyusername:" + this.mProfile.proxyUsername + ",proxypassword:" + this.mProfile.proxyPassword + ",proxyserver:" + this.mProfile.proxyServer + ",proxyport:" + this.mProfile.proxyPort);
      }
      paramString1 = new MailAccount.2(this, paramLong1, paramMailServiceProvider, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean1, str1);
      QMMailManager.sharedInstance().login(this.mProfile, paramString1, paramBoolean1);
      return;
      if (!str1.equalsIgnoreCase("IMAP")) {
        break;
      }
      this.mProfile.protocolType = 1;
      this.mProfile.imapName = getUserNameByStyle(paramString2, paramMailServiceProvider.getImapName());
      this.mProfile.imapPassword = paramString3;
      this.mProfile.imapServer = paramMailServiceProvider.getImapServer();
      this.mProfile.imapUsingSSL = paramMailServiceProvider.isImapUsingSSL();
      this.mProfile.imapPort = paramMailServiceProvider.getImapPort();
      this.mProfile.imapSSLPort = paramMailServiceProvider.getImapSSLPort();
      QMLog.log(4, "MailAccount", "imap. " + this.mProfile.protocolType + ";" + this.mProfile.imapName + ";" + this.mProfile.imapServer + ";" + this.mProfile.imapUsingSSL + ";" + this.mProfile.imapPort + ";" + this.mProfile.imapSSLPort + ";" + paramString1 + ";" + paramString2 + ";" + paramString4 + ";" + paramBoolean1);
      if ((this.mProfile.domain != null) && (paramBoolean2)) {
        try
        {
          this.mProfile.accessToken = QMAccountHelper.calcGmailAccessToken(paramString1, paramString6);
          this.mProfile.refreshToken = paramString7;
          this.mProfile.tokenType = paramString8;
          this.mProfile.expiresIn = paramLong2;
          this.mProfile.idToken = paramString9;
          this.mProfile.isOauth = true;
          QMLog.log(4, "MailAccount", "imap. " + this.mProfile.protocolType + ";" + this.mProfile.accessToken + ";" + this.mProfile.refreshToken + ";" + this.mProfile.tokenType + ";" + this.mProfile.expiresIn + ";" + this.mProfile.idToken + ";" + true + ";" + paramString1 + ";" + paramString2 + ";" + paramString4 + ";" + paramBoolean1);
        }
        catch (UnsupportedEncodingException paramString6)
        {
          paramString6.printStackTrace();
        }
      }
    }
    if ((str1.equalsIgnoreCase("Exchange")) || (str1.equals("TestActiveSync")))
    {
      this.mProfile.protocolType = 3;
      if (paramMailServiceProvider.getExchangeDomain() == null)
      {
        paramString6 = paramMailServiceProvider.getActiveSyncDomain();
        label1160:
        paramString8 = this.mProfile;
        paramString7 = paramString6;
        if (paramString6 == null) {
          paramString7 = paramString1.split("@")[1];
        }
        paramString8.exchangeDomain = paramString7;
        this.mProfile.exchangeName = getUserNameByStyle(paramString2, paramMailServiceProvider.getExchangeName());
        this.mProfile.exchangePassword = paramString3;
        paramString7 = this.mProfile;
        if (paramMailServiceProvider.getExchangeServer() != null) {
          break label1394;
        }
      }
      label1394:
      for (paramString6 = paramMailServiceProvider.getActiveSyncServer();; paramString6 = paramMailServiceProvider.getExchangeServer())
      {
        paramString7.exchangeServer = paramString6;
        this.mProfile.exchangeUsingSSL = paramMailServiceProvider.isExchangeUsingSSL();
        QMLog.log(4, "MailAccount", "ex. " + this.mProfile.protocolType + ";" + this.mProfile.exchangeName + ";" + this.mProfile.exchangeServer + ";" + this.mProfile.exchangeUsingSSL + ";" + paramString1 + ";" + paramString2 + ";" + paramString4 + ";" + paramBoolean1);
        break;
        paramString6 = paramMailServiceProvider.getExchangeDomain();
        break label1160;
      }
    }
    if (!str1.equalsIgnoreCase("ActiveSync")) {
      paramMailServiceProvider.setDefaultRecvProtocol("TestActiveSync");
    }
    this.mProfile.protocolType = 4;
    this.mProfile.activeSyncName = getUserNameByStyle(paramString2, paramMailServiceProvider.getActiveSyncName());
    this.mProfile.activeSyncPassword = paramString3;
    this.mProfile.activeSyncServer = paramMailServiceProvider.getActiveSyncServer();
    this.mProfile.activeSyncUsingSSL = paramMailServiceProvider.isActiveSyncUseSSL();
    paramString7 = this.mProfile;
    if (paramMailServiceProvider.getActiveSyncDomain() == null) {}
    for (paramString6 = paramString1.split("@")[1];; paramString6 = paramMailServiceProvider.getActiveSyncDomain())
    {
      paramString7.activeSyncDomain = paramString6;
      QMLog.log(4, "MailAccount", "ac. " + this.mProfile.protocolType + ";" + this.mProfile.activeSyncName + ";" + this.mProfile.activeSyncServer + ";" + this.mProfile.activeSyncUsingSSL + paramString1 + ";" + paramString2 + ";" + paramString4 + ";" + paramBoolean1);
      break;
    }
  }
  
  public void reDeAesPwd()
  {
    String str2 = getPwd();
    String str1 = getDeviceId();
    String str3;
    if (!StringUtils.isEmpty(str2))
    {
      str3 = Aes.decode(getPwd(), str1);
      QMLog.log(4, "MailAccount", "reDeAesPwd. email:" + getEmail() + ",deviceid:" + str1);
      if (!StringUtils.isEmpty(str3)) {
        break label280;
      }
      QMLogStream.logWithoutUmaNow(-40037, "recv:" + getEmail(), "Event_Error");
      QMLog.log(6, "MailAccount", "decode psw error " + getPwd());
      str3 = SPManager.getSp("accounts_info").getString("encode_data_" + getEmail(), null);
      KvHelper.decodePwdError(new double[0]);
      OssHelper.protocolOsslog(new Object[] { "decode_pwd_err", "decode", "" + str3, str2, str1 });
    }
    for (;;)
    {
      str2 = getSmtppwd();
      if (!StringUtils.isEmpty(str2))
      {
        str1 = Aes.decode(str2, str1);
        if (!StringUtils.isEmpty(str1)) {
          break;
        }
        QMLogStream.logWithoutUmaNow(-40037, "smtp:" + getEmail(), "Event_Error");
      }
      return;
      label280:
      this.mProfile.pop3Password = str3;
      this.mProfile.imapPassword = str3;
      this.mProfile.exchangePassword = str3;
      this.mProfile.activeSyncPassword = str3;
    }
    this.mProfile.smtpPassword = str1;
  }
  
  public void resetProfile()
  {
    try
    {
      if (this.mProfile != null) {
        this.mProfile.reset = true;
      }
      return;
    }
    finally {}
  }
  
  public void updateActiveSyncProfile(String paramString1, String paramString2)
  {
    String str = getNullableName(paramString1) + "," + getNullableName(paramString2);
    if (!str.equals(getActiveSyncProfileString()))
    {
      setActiveSyncProfileString(str);
      if (this.mProfile != null)
      {
        this.mProfile.activeSyncVersion = paramString1;
        this.mProfile.activeSyncPolicyKey = paramString2;
      }
      AccountManager.shareInstance().updateProfile(getId(), null, str, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.MailAccount
 * JD-Core Version:    0.7.0.1
 */