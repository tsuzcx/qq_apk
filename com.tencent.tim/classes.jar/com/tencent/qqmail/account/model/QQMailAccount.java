package com.tencent.qqmail.account.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.callback.LoginCallback;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager.SessionTask;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class QQMailAccount
  extends Account
{
  private static final String ITEM_SEPARATOR = ";";
  public static final String KEY_SAVE_AES_KEY = "save_aes_key";
  public static final String KEY_SAVE_SID = "save_sid";
  public static final String KEY_SAVE_SID_TIME = "save_sid_time";
  public static final String KEY_SAVE_SKEY_TIME = "save_skey_time";
  public static final String LOCK_MY_FOLDER = "fldmy";
  public static final String LOCK_NOTE_FOLDER = "fldnote";
  public static final String LOCK_POP_FOLDER = "fldpop";
  static final String LOGIN_DATA_VERSION = "7";
  private static final long SESSION_OVERDUE_TIME = 5400000L;
  private static final String TAG = "QQMailAccount";
  private final HashMap<String, Boolean> folderLock = new HashMap();
  private long lastSaveSidTime = 0L;
  private String mAesKey;
  private final CopyOnWriteArrayList<Cookie> mCookies = new CopyOnWriteArrayList();
  private volatile Profile mProfile;
  private String mSid;
  private String masterUin = "";
  private String relpwd;
  public final ArrayList<NetworkManager.SessionTask> requestWaitingForSession = new ArrayList();
  private LoginUser user = null;
  
  private void autoLoginWithCallback(LoginCallback paramLoginCallback)
  {
    boolean bool2 = true;
    organizeLoginUser();
    this.user.autoLogin(paramLoginCallback);
    StringBuilder localStringBuilder = new StringBuilder().append("autologin user is null:");
    if (this.user == null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(",callback null:");
      if (paramLoginCallback != null) {
        break label100;
      }
      bool1 = true;
      label56:
      paramLoginCallback = localStringBuilder.append(bool1).append(", autologin autologin psw is null : ");
      if (this.user.getAutoLoginPwd() != null) {
        break label105;
      }
    }
    label100:
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QMLog.log(4, "QQMailAccount", bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label56;
    }
  }
  
  private void deserialization(String paramString, Context paramContext)
    throws Exception
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new Exception();
    }
    paramString = paramString.split(";", -1);
    if ((paramString.length > 6) && ("7".equals(paramString[0])))
    {
      this.mSid = paramString[4];
      this.mCookies.clear();
      int j = Integer.parseInt(paramString[6]);
      while (i < j)
      {
        this.mCookies.add(new BasicClientCookie(paramString[(i * 2 + 7)], paramString[(i * 2 + 7 + 1)]));
        i += 1;
      }
      setCookies(this.mCookies);
      setSid(this.mSid);
      return;
    }
    throw new Exception();
  }
  
  private String getSerializableString()
  {
    int i = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("7");
    localStringBuilder.append(';');
    ??? = getEmail();
    Object localObject3 = getUin();
    Object localObject4 = getEncryptedUin();
    String str = this.mSid;
    if (isBizMail()) {}
    for (;;)
    {
      localStringBuilder.append(String.format("%s;%s;%s;%s;%d", new Object[] { ???, localObject3, localObject4, str, Integer.valueOf(i) }));
      localStringBuilder.append(';');
      synchronized (this.mCookies)
      {
        localStringBuilder.append(this.mCookies.size());
        localObject3 = this.mCookies.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (Cookie)((Iterator)localObject3).next();
        localStringBuilder.append(';');
        localStringBuilder.append(((Cookie)localObject4).getName());
        localStringBuilder.append(';');
        localStringBuilder.append(((Cookie)localObject4).getValue());
      }
      i = 0;
    }
    return localObject1.toString();
  }
  
  public void autoLogin()
  {
    QMLog.log(4, "QQMailAccount", "autoLoginWithCallback null");
    autoLoginWithCallback(null);
  }
  
  public void autoLogin(LoginCallback paramLoginCallback)
  {
    QMLog.log(4, "QQMailAccount", "autoLoginWithCallback");
    autoLoginWithCallback(paramLoginCallback);
  }
  
  public void autoLogin(QMCGIError paramQMCGIError)
  {
    QMLog.log(6, "QQMailAccount", "autoLogin with error, error.isSessionTimeouted():" + paramQMCGIError.isSessionTimeouted() + ",error.isWtloginSkeyTimeout():" + paramQMCGIError.isWtloginSkeyTimeout());
    if (paramQMCGIError.isSessionTimeouted())
    {
      autoLoginWithCallback(null);
      return;
    }
    if (paramQMCGIError.isWtloginSkeyTimeout())
    {
      wtAutoLogin(null);
      return;
    }
    QMLog.log(6, "QQMailAccount", "autoLogin with error wtf:" + paramQMCGIError);
  }
  
  public void clearLoginedStatus()
  {
    QMLog.log(4, "QQMailAccount", "clearSid");
    SPManager.getEditor("user_info").remove(getId() + "save_sid_time").remove(getId() + "save_sid").apply();
    this.lastSaveSidTime = 0L;
    this.mSid = "";
    setSid("");
  }
  
  public String getAesKey()
  {
    if (this.user != null) {
      return this.user.getAesKey();
    }
    return "";
  }
  
  public String getAutologinKey()
  {
    if ((SharedPreferenceUtil.isWtlogin()) && (!isBizMail()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(SharedPreferenceUtil.getLoginSvrUtc()).append("\t").append(getUin()).append("\t").append(QMWtLoginManager.getInstance().getA2(getUin())).append("\t");
      if (getSecondPassword() == null) {}
      for (String str = "";; str = getSecondPassword()) {
        return Aes.encode(str, Aes.getServerKey());
      }
    }
    return getPwd();
  }
  
  public ArrayList<Cookie> getCookies()
  {
    if (this.user != null) {
      return this.user.getCookies();
    }
    return null;
  }
  
  public int getLoginStatus()
  {
    if (this.user == null) {
      return 0;
    }
    return this.user.getLoginStatus();
  }
  
  public LoginUser getLoginUser()
  {
    return this.user;
  }
  
  public String getMasterUin()
  {
    return this.masterUin;
  }
  
  public Profile getProfile()
  {
    if ((this.mProfile == null) || (this.mProfile.reset)) {}
    try
    {
      if ((this.mProfile == null) || (this.mProfile.reset))
      {
        Profile localProfile = new Profile();
        localProfile.deviceId = CloudProtocolHelper.getDeviceId();
        localProfile.protocolType = 100;
        localProfile.mailAddress = getEmail();
        localProfile.QQPassword = getPwd();
        this.mProfile = localProfile;
      }
      return this.mProfile;
    }
    finally {}
  }
  
  public String getRelpwd()
  {
    return this.relpwd;
  }
  
  public String getSid()
  {
    if (this.user != null) {
      return this.user.getSid();
    }
    return "";
  }
  
  public boolean getUserLock(String paramString)
  {
    ValidateHelper.notNullAndNotEmpty(paramString);
    paramString = (Boolean)this.folderLock.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  public boolean isRelativeAccount()
  {
    if (this.masterUin == null) {}
    while (this.masterUin.equals("")) {
      return false;
    }
    return true;
  }
  
  public boolean isSessionExpire()
  {
    return (this.lastSaveSidTime == 0L) || (TextUtils.isEmpty(this.mSid)) || (System.currentTimeMillis() - this.lastSaveSidTime >= 5400000L);
  }
  
  public void login(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, String paramString5)
  {
    this.user = new LoginUser(this);
    this.user.setCurrentEmail(paramString1);
    this.user.setPassword(paramString3);
    if ((paramString2 != null) && (paramString2.equals(""))) {}
    this.user.setBiz(paramBoolean1);
    this.user.setCurrentUin(paramString4);
    setEmail(paramString1);
    paramString1 = getEncryptedFolderPwd();
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      this.user.setEncryptedFolderPwd(paramString1);
    }
    this.user.isBindPhone(paramBoolean2);
    this.user.setPhoneNum(paramString5);
    this.user.login(paramLong);
  }
  
  public void login(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.user = new LoginUser(this);
    this.user.setCurrentEmail(paramString1);
    this.user.setPassword(paramString2);
    setEmail(paramString1);
    this.user.setBiz(paramBoolean);
    paramString2 = getEncryptedFolderPwd();
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      this.user.setEncryptedFolderPwd(paramString2);
    }
    this.user.setCurrentUin(paramString1.split("@")[0]);
    this.user.login(paramLong);
  }
  
  public void loginWithSecondPassword(long paramLong, String paramString)
  {
    ValidateHelper.notNullAndNotEmpty(paramString);
    if (this.user != null)
    {
      this.user.setSecondPassword(paramString);
      this.user.loginWithSecondPassword(paramLong);
    }
  }
  
  public void loginWithVerify(long paramLong, String paramString)
  {
    this.user.loginWithVerify(paramLong, paramString);
  }
  
  public void organizeLoginUser()
  {
    if (this.user == null) {
      this.user = new LoginUser(this);
    }
    this.user.setAutoLoginPwd(getPwd());
    this.user.setSecondPassword(getSecondPassword());
    String str = getEncryptedFolderPwd();
    if ((str != null) && (!str.equals(""))) {
      this.user.setEncryptedFolderPwd(str);
    }
    this.user.setCurrentEmail(getEmail());
    this.user.setCurrentUin(getUin());
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
  
  public void restoreAesKey()
  {
    organizeLoginUser();
    String str = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString(getId() + "save_aes_key", "");
    if (str.length() > 0)
    {
      this.mAesKey = str;
      setAesKey(str);
    }
  }
  
  public void restoreSidAndCookies()
  {
    organizeLoginUser();
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    Object localObject = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    long l = new Date().getTime();
    this.lastSaveSidTime = ((SharedPreferences)localObject).getLong(getId() + "save_sid_time", 0L);
    localObject = ((SharedPreferences)localObject).getString(getId() + "save_sid", "");
    if ((l - this.lastSaveSidTime < 5400000L) && (((String)localObject).length() > 0)) {
      localObject = Aes.decode((String)localObject, Aes.getIMEIKey());
    }
    try
    {
      deserialization((String)localObject, localQMApplicationContext);
      this.user.setLogined();
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public void saveAesKeyToLocalStorage()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 457	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   5: ldc_w 258
    //   8: iconst_0
    //   9: invokevirtual 461	com/tencent/qqmail/QMApplicationContext:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   12: invokeinterface 498 1 0
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 468	com/tencent/qqmail/account/model/QQMailAccount:mAesKey	Ljava/lang/String;
    //   22: ifnull +58 -> 80
    //   25: aload_0
    //   26: getfield 468	com/tencent/qqmail/account/model/QQMailAccount:mAesKey	Ljava/lang/String;
    //   29: ldc 73
    //   31: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifne +46 -> 80
    //   37: aload_1
    //   38: new 97	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 267	com/tencent/qqmail/account/model/QQMailAccount:getId	()I
    //   49: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 11
    //   54: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 468	com/tencent/qqmail/account/model/QQMailAccount:mAesKey	Ljava/lang/String;
    //   64: invokeinterface 502 3 0
    //   69: pop
    //   70: aload_1
    //   71: invokeinterface 505 1 0
    //   76: pop
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_1
    //   81: new 97	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   88: aload_0
    //   89: invokevirtual 267	com/tencent/qqmail/account/model/QQMailAccount:getId	()I
    //   92: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc 11
    //   97: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: ldc 73
    //   105: invokeinterface 502 3 0
    //   110: pop
    //   111: goto -41 -> 70
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	QQMailAccount
    //   17	64	1	localEditor	SharedPreferences.Editor
    //   114	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	70	114	finally
    //   70	79	114	finally
    //   80	111	114	finally
    //   115	117	114	finally
  }
  
  /* Error */
  public void saveToLocalStorage()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 82	com/tencent/qqmail/account/model/QQMailAccount:mCookies	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokespecial 508	com/tencent/qqmail/account/model/QQMailAccount:getSerializableString	()Ljava/lang/String;
    //   11: astore_2
    //   12: aload_1
    //   13: monitorexit
    //   14: aload_0
    //   15: monitorenter
    //   16: invokestatic 457	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   19: ldc_w 258
    //   22: iconst_0
    //   23: invokevirtual 461	com/tencent/qqmail/QMApplicationContext:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   26: invokeinterface 498 1 0
    //   31: astore_3
    //   32: aload_0
    //   33: getfield 145	com/tencent/qqmail/account/model/QQMailAccount:mSid	Ljava/lang/String;
    //   36: ifnull +118 -> 154
    //   39: aload_0
    //   40: getfield 145	com/tencent/qqmail/account/model/QQMailAccount:mSid	Ljava/lang/String;
    //   43: ldc 73
    //   45: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifne +106 -> 154
    //   51: new 97	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   58: aload_0
    //   59: invokevirtual 267	com/tencent/qqmail/account/model/QQMailAccount:getId	()I
    //   62: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 14
    //   67: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore 4
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: ifnonnull +6 -> 84
    //   81: ldc 73
    //   83: astore_1
    //   84: aload_3
    //   85: aload 4
    //   87: aload_1
    //   88: invokestatic 485	com/tencent/qqmail/utilities/encryptionalgorithm/Aes:getIMEIKey	()Ljava/lang/String;
    //   91: invokestatic 315	com/tencent/qqmail/utilities/encryptionalgorithm/Aes:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: invokeinterface 502 3 0
    //   99: pop
    //   100: aload_3
    //   101: new 97	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   108: aload_0
    //   109: invokevirtual 267	com/tencent/qqmail/account/model/QQMailAccount:getId	()I
    //   112: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc 17
    //   117: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: new 474	java/util/Date
    //   126: dup
    //   127: invokespecial 475	java/util/Date:<init>	()V
    //   130: invokevirtual 478	java/util/Date:getTime	()J
    //   133: invokeinterface 512 4 0
    //   138: pop
    //   139: aload_3
    //   140: invokeinterface 505 1 0
    //   145: pop
    //   146: aload_0
    //   147: monitorexit
    //   148: return
    //   149: astore_2
    //   150: aload_1
    //   151: monitorexit
    //   152: aload_2
    //   153: athrow
    //   154: aload_3
    //   155: new 97	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   162: aload_0
    //   163: invokevirtual 267	com/tencent/qqmail/account/model/QQMailAccount:getId	()I
    //   166: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: ldc 14
    //   171: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: ldc 73
    //   179: invokeinterface 502 3 0
    //   184: pop
    //   185: aload_3
    //   186: new 97	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   193: aload_0
    //   194: invokevirtual 267	com/tencent/qqmail/account/model/QQMailAccount:getId	()I
    //   197: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc 17
    //   202: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: lconst_0
    //   209: invokeinterface 512 4 0
    //   214: pop
    //   215: goto -76 -> 139
    //   218: astore_1
    //   219: aload_0
    //   220: monitorexit
    //   221: aload_1
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	QQMailAccount
    //   4	147	1	localObject1	Object
    //   218	4	1	localObject2	Object
    //   11	67	2	str1	String
    //   149	4	2	localObject3	Object
    //   31	155	3	localEditor	SharedPreferences.Editor
    //   73	13	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   7	14	149	finally
    //   150	152	149	finally
    //   16	75	218	finally
    //   84	139	218	finally
    //   139	148	218	finally
    //   154	215	218	finally
    //   219	221	218	finally
  }
  
  public void saveUserLock(HashMap<String, Boolean> paramHashMap)
  {
    ValidateHelper.notNull(paramHashMap);
    this.folderLock.clear();
    this.folderLock.putAll(paramHashMap);
  }
  
  public void setAesKey(String paramString)
  {
    if (this.user != null) {
      this.user.setAesKey(paramString);
    }
  }
  
  public void setAesKeyCache(String paramString)
  {
    this.mAesKey = paramString;
  }
  
  public void setCookies(CopyOnWriteArrayList<Cookie> paramCopyOnWriteArrayList)
  {
    if (this.user != null) {
      this.user.setCookies(paramCopyOnWriteArrayList);
    }
  }
  
  public void setLoginUser(LoginUser paramLoginUser)
  {
    this.user = paramLoginUser;
  }
  
  public void setMasterUin(String paramString)
  {
    this.masterUin = paramString;
  }
  
  public void setRelpwd(String paramString)
  {
    this.relpwd = paramString;
  }
  
  public void setSid(String paramString)
  {
    if (this.user != null) {
      this.user.setSid(paramString);
    }
  }
  
  public void setSidAndCookies(String paramString, ArrayList<Cookie> paramArrayList)
  {
    ValidateHelper.notNullAndNotEmpty(paramString);
    ValidateHelper.notNull(paramArrayList);
    this.mSid = paramString;
    this.mCookies.clear();
    this.mCookies.addAll(paramArrayList);
    Iterator localIterator = this.mCookies.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!"curuin".equals(((Cookie)localIterator.next()).getName()));
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.mCookies.add(new BasicClientCookie("curuin", getUin()));
      }
      setCookies(new CopyOnWriteArrayList(paramArrayList));
      setSid(paramString);
      return;
    }
  }
  
  public void updateSaveSidTime()
  {
    long l = System.currentTimeMillis();
    SPManager.getEditor("user_info").putLong(getId() + "save_sid_time", l).apply();
    this.lastSaveSidTime = l;
  }
  
  public void wtAutoLogin(LoginCallback paramLoginCallback)
  {
    this.user.wtAutoLogin(paramLoginCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.QQMailAccount
 * JD-Core Version:    0.7.0.1
 */