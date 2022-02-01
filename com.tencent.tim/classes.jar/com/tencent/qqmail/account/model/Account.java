package com.tencent.qqmail.account.model;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import org.apache.commons.lang3.StringUtils;

public class Account
{
  public static final int ACCOUNT_ID_ALL = 0;
  public static final int ACCOUNT_TYPE_ACTIVESYNC = 14;
  public static final int ACCOUNT_TYPE_BIZMAIL = 2;
  public static final int ACCOUNT_TYPE_EXCHANGE = 13;
  public static final int ACCOUNT_TYPE_IMAP = 12;
  public static final int ACCOUNT_TYPE_POP = 11;
  public static final int ACCOUNT_TYPE_QQMAIL = 1;
  public static final int ATTR_BEGIN_POS = 0;
  public static final int ATTR_IS_WTLOGIN = 1;
  public static final int ATTR_PHONE_LOGIN = 16;
  public static final int ATTR_QUICK_LOGIN = 64;
  public static final int ATTR_SMTP_CHECKED = 2;
  public static final int ATTR_SMTP_PASSED = 4;
  public static final int ATTR_UMA_ADDACCOUNT_FAIL = 32;
  public static final int LOCK_MY = 2;
  public static final int LOCK_NOTE = 4;
  public static final int LOCK_POP = 1;
  private static final String TAG = "Account";
  public static final int TYPE_UNKNOW = -1;
  private String accessToken = "";
  private String activeSyncProfile;
  private int attr = 0;
  private String deviceId = "";
  private String email;
  private String encryptedFolderPwd = "";
  private String encryptedUin;
  private long expireIn = 0L;
  private String folderListSyncKey;
  private int id;
  private String idToken = "";
  private boolean isLogined = false;
  private long lastTokenTime = 0L;
  public boolean mLockMy = false;
  public boolean mLockNote = false;
  public boolean mLockPop = false;
  private String password;
  private String profile;
  private int protocol;
  private String qqPassword;
  private String recordSyncKey;
  private String refreshToken = "";
  private String secondPassword;
  private long sequence;
  private String smtpUserName;
  private String smtppwd;
  private int state;
  private String tokenType = "";
  private String uin;
  private String username;
  
  public static int generateId(int paramInt)
  {
    return QMMath.hashPositivetInt("u_" + paramInt);
  }
  
  public static int generateId(String paramString)
  {
    return QMMath.hashPositivetInt("e_" + paramString);
  }
  
  public String getAccessToken()
  {
    return this.accessToken;
  }
  
  public int getAccountState()
  {
    return this.state;
  }
  
  public String getActiveSyncProfileString()
  {
    return this.activeSyncProfile;
  }
  
  public int getAttr()
  {
    return this.attr;
  }
  
  public String getConfigString()
  {
    int j = 1;
    int i = 1;
    Profile localProfile = getProfile();
    if ((localProfile == null) || (localProfile.protocolType == 100)) {
      return "";
    }
    int k = localProfile.protocolType;
    Object localObject = this.email + ",";
    switch (k)
    {
    case 2: 
    default: 
      return localObject;
    case 0: 
      localObject = (String)localObject + localProfile.pop3Server + ",";
      if (localProfile.pop3UsingSSL) {}
      for (localObject = (String)localObject + localProfile.pop3Port + ",1,";; localObject = (String)localObject + localProfile.pop3SSLPort + ",0,")
      {
        localObject = (String)localObject + localProfile.smtpServer + ",";
        if (!localProfile.smtpUsingSSL) {
          break;
        }
        return (String)localObject + localProfile.smtpSSLPort + ",1,";
      }
      return (String)localObject + localProfile.smtpPort + ",0,";
    case 1: 
      localObject = (String)localObject + localProfile.imapServer + ",";
      if (localProfile.imapUsingSSL) {}
      for (localObject = (String)localObject + localProfile.imapSSLPort + ",1,";; localObject = (String)localObject + localProfile.imapPort + ",0,")
      {
        localObject = (String)localObject + localProfile.smtpServer + ",";
        if (!localProfile.smtpUsingSSL) {
          break;
        }
        return (String)localObject + localProfile.smtpSSLPort + ",1,";
      }
      return (String)localObject + localProfile.smtpPort + ",0,";
    case 3: 
      localObject = new StringBuilder().append((String)localObject).append(localProfile.exchangeServer).append(",0,");
      if (localProfile.exchangeUsingSSL) {}
      for (;;)
      {
        localObject = i + ",";
        return (String)localObject + ",,," + localProfile.exchangeDomain;
        i = 0;
      }
    }
    localObject = new StringBuilder().append((String)localObject).append(localProfile.activeSyncServer).append(",0,");
    if (localProfile.activeSyncUsingSSL) {}
    for (i = j;; i = 0)
    {
      localObject = i + ",";
      return (String)localObject + ",,," + localProfile.activeSyncDomain;
    }
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getEncryptedFolderPwd()
  {
    return this.encryptedFolderPwd;
  }
  
  public String getEncryptedUin()
  {
    return this.encryptedUin;
  }
  
  public long getExpireIn()
  {
    return this.expireIn;
  }
  
  public String getFolderListSyncKey()
  {
    if ((this.folderListSyncKey == null) || ("".equals(StringUtils.trim(this.folderListSyncKey)))) {
      this.folderListSyncKey = "0";
    }
    return this.folderListSyncKey;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getIdToken()
  {
    return this.idToken;
  }
  
  public long getLastTokenTime()
  {
    return this.lastTokenTime;
  }
  
  public int getLockState()
  {
    int j = 0;
    if (this.mLockMy) {
      j = 2;
    }
    int i = j;
    if (this.mLockNote) {
      i = j | 0x4;
    }
    j = i;
    if (this.mLockPop) {
      j = i | 0x1;
    }
    return j;
  }
  
  public int getLoginStatus()
  {
    return -1;
  }
  
  public String getName()
  {
    return this.username;
  }
  
  public Profile getProfile()
  {
    return null;
  }
  
  public String getProfileString()
  {
    return this.profile;
  }
  
  public int getProtocol()
  {
    return this.protocol;
  }
  
  public int getProtocolType()
  {
    if (getProtocol() == 13) {
      return 3;
    }
    if (getProtocol() == 12) {
      return 1;
    }
    if (getProtocol() == 14) {
      return 4;
    }
    if (getProtocol() == 11) {
      return 0;
    }
    return -1;
  }
  
  public String getPwd()
  {
    return this.password;
  }
  
  public String getQqPassword()
  {
    return this.qqPassword;
  }
  
  public String getRecordSyncKey()
  {
    if ((this.recordSyncKey == null) || ("".equals(StringUtils.trim(this.recordSyncKey)))) {
      this.recordSyncKey = "0";
    }
    return this.recordSyncKey;
  }
  
  public String getRefreshToken()
  {
    return this.refreshToken;
  }
  
  public String getSecondPassword()
  {
    return this.secondPassword;
  }
  
  public String getSendEmail()
  {
    if ((getProfile() != null) && (!StringExtention.isNullOrEmpty(getProfile().smtpName)))
    {
      String str = getProfile().smtpName;
      if (str.contains("@")) {
        return getProfile().smtpName;
      }
      if (this.email.contains("@")) {
        return str + "@" + this.email.split("@")[1];
      }
    }
    return this.email;
  }
  
  public long getSequence()
  {
    return this.sequence;
  }
  
  public String getSmtpUserName()
  {
    return this.smtpUserName;
  }
  
  public String getSmtppwd()
  {
    return this.smtppwd;
  }
  
  public String getTokenType()
  {
    return this.tokenType;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public boolean isActiveSyncMail()
  {
    return this.protocol == 14;
  }
  
  public boolean isBizMail()
  {
    return this.protocol == 2;
  }
  
  public boolean isExchangeMail()
  {
    return this.protocol == 13;
  }
  
  public boolean isFoxMail()
  {
    return (this.email != null) && (this.email.toLowerCase().endsWith("@foxmail.com"));
  }
  
  public boolean isGMail()
  {
    Profile localProfile = getProfile();
    return (!StringExtention.isNullOrEmpty(this.refreshToken)) || ((localProfile != null) && ("imap.gmail.com".equalsIgnoreCase(localProfile.imapServer)));
  }
  
  public boolean isICloud()
  {
    return (this.email != null) && (this.email.endsWith("@icloud.com"));
  }
  
  public boolean isImapMail()
  {
    return this.protocol == 12;
  }
  
  public boolean isLocked()
  {
    return (isQQMail()) && ((this.mLockMy) || (this.mLockPop)) && (StringUtils.isEmpty(getEncryptedFolderPwd()));
  }
  
  public boolean isLogined()
  {
    return this.isLogined;
  }
  
  public boolean isOutlook()
  {
    return (this.email != null) && (this.email.endsWith("@outlook.com"));
  }
  
  public boolean isPopMail()
  {
    return this.protocol == 11;
  }
  
  public boolean isQQMail()
  {
    return (this.protocol == 1) || (this.protocol == 2);
  }
  
  public boolean isQQPhoneMailLogin()
  {
    boolean[] arrayOfBoolean = AccountManager.shareInstance().getAccountList().getAccountAttr(getId(), new int[] { 16 });
    return (arrayOfBoolean != null) && (arrayOfBoolean.length > 0) && (arrayOfBoolean[0] != 0);
  }
  
  public boolean isQuickLogin()
  {
    boolean[] arrayOfBoolean = AccountManager.shareInstance().getAccountList().getAccountAttr(getId(), new int[] { 64 });
    return (arrayOfBoolean != null) && (arrayOfBoolean.length > 0) && (arrayOfBoolean[0] != 0);
  }
  
  public boolean isTencentDotCom()
  {
    return (this.email != null) && (this.email.endsWith("@tencent.com"));
  }
  
  public boolean isUmaAddAccountStatus()
  {
    boolean[] arrayOfBoolean = AccountManager.shareInstance().getAccountList().getAccountAttr(getId(), new int[] { 32 });
    return (arrayOfBoolean != null) && (arrayOfBoolean.length > 0) && (arrayOfBoolean[0] != 0);
  }
  
  public void parseLockState(int paramInt)
  {
    boolean bool2 = true;
    if ((paramInt & 0xFFFFFFFC) != 0)
    {
      bool1 = true;
      this.mLockNote = bool1;
      if ((paramInt & 0xFFFFFFF9) == 0) {
        break label50;
      }
      bool1 = true;
      label25:
      this.mLockPop = bool1;
      if ((paramInt & 0xFFFFFFFA) == 0) {
        break label55;
      }
    }
    label50:
    label55:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mLockMy = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
    }
  }
  
  public void reAuthSuccess()
  {
    SendMailHelper.revertAllSendingTask();
    SendMailHelper.autoRestartSendingTasks();
  }
  
  public void resetProfile() {}
  
  public void save()
  {
    AccountManager.shareInstance().saveAccount(this, 0L);
  }
  
  public void setAccessToken(String paramString)
  {
    this.accessToken = paramString;
  }
  
  public void setAccountState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public void setActiveSyncProfileString(String paramString)
  {
    this.activeSyncProfile = paramString;
  }
  
  public void setAttr(int paramInt)
  {
    this.attr = paramInt;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setEncryptedFolderPwd(String paramString)
  {
    this.encryptedFolderPwd = paramString;
  }
  
  public void setEncryptedUin(String paramString)
  {
    this.encryptedUin = paramString;
  }
  
  public void setExpireIn(long paramLong)
  {
    this.expireIn = paramLong;
  }
  
  public void setFolderListSyncKey(String paramString)
  {
    this.folderListSyncKey = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIdToken(String paramString)
  {
    this.idToken = paramString;
  }
  
  public void setLastTokenTime(long paramLong)
  {
    this.lastTokenTime = paramLong;
  }
  
  public void setLogined()
  {
    this.isLogined = true;
  }
  
  public void setName(String paramString)
  {
    this.username = paramString;
  }
  
  public void setProfileString(String paramString)
  {
    this.profile = paramString;
  }
  
  public void setProtocol(int paramInt)
  {
    this.protocol = paramInt;
  }
  
  public void setPwd(String paramString)
  {
    this.password = paramString;
  }
  
  public void setQQPhoneMailLogin(boolean paramBoolean)
  {
    AccountManager.shareInstance().updateAccountAttr(getId(), 16, paramBoolean);
  }
  
  public void setQqPassword(String paramString)
  {
    this.qqPassword = "";
  }
  
  public void setQuickLogin(boolean paramBoolean)
  {
    AccountManager.shareInstance().updateAccountAttr(getId(), 64, paramBoolean);
  }
  
  public void setRecordSyncKey(String paramString)
  {
    this.recordSyncKey = paramString;
  }
  
  public void setRefreshToken(String paramString)
  {
    this.refreshToken = paramString;
  }
  
  public void setSecondPassword(String paramString)
  {
    this.secondPassword = paramString;
  }
  
  public void setSequence(long paramLong)
  {
    this.sequence = paramLong;
  }
  
  public void setSmtpUserName(String paramString)
  {
    this.smtpUserName = paramString;
  }
  
  public void setSmtppwd(String paramString)
  {
    this.smtppwd = paramString;
  }
  
  public void setTokenType(String paramString)
  {
    this.tokenType = paramString;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public void setUmaAddAccountStatus(boolean paramBoolean)
  {
    AccountManager.shareInstance().updateAccountAttr(getId(), 32, paramBoolean);
  }
  
  public void setWtlogin(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.attr |= 0x1;; this.attr &= 0xFFFFFFFE)
    {
      AccountManager.shareInstance().updateAccountAttr(this.id, 1, paramBoolean);
      return;
    }
  }
  
  public String toString()
  {
    return "{id: " + this.id + ", name: " + this.username + ", email: " + this.email + ", uin: " + this.uin + ", protocol: " + this.protocol + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.Account
 * JD-Core Version:    0.7.0.1
 */