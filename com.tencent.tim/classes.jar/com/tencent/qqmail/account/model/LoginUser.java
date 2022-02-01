package com.tencent.qqmail.account.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.callback.LoginCallback;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.network.filter.BackOffFilter;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.cookieutils.CookieUtils;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager.SessionTask;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;
import com.tencent.qqmail.utilities.qmnetwork.qmuser.QMVerify;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.NetscapeDraftSpec;
import org.apache.http.message.BasicHeader;

public class LoginUser
{
  private static final String AESKEY = "aeskey";
  private static final String ALIAS_TYPE_FOXMAIL = "fox";
  private static final String ALIAS_TYPE_OTHER = "other";
  private static final String ALIAS_TYPE_QQ = "@qq.com";
  private static final String ALIAS_TYPE_VIP = "vip";
  public static final int APP_CODE_NO_ERROR = 0;
  private static final String DOMAIN = "domain";
  public static final String DOMAIN_FOXMAIL = "@foxmail.com";
  public static final String DOMAIN_QQ = "@qq.com";
  public static final String DOMAIN_VIP = "@vip.qq.com";
  private static final String ERRTYPE = "errtype";
  public static final int LOGIN_ERROR_A2_TIME_OUT = -63;
  public static final int LOGIN_ERROR_APP_CODE_ACCOUNT_FREEZE = -10035;
  public static final int LOGIN_ERROR_GMAIL_TOKEN_FAIL = 65;
  public static final int LOGIN_ERROR_GMAIL_USERINFO_FAIL = 66;
  public static final int LOGIN_ERROR_SKEY_ERROR = -64;
  public static final int LOGIN_ERROR_SKEY_TIME_OUT = -15;
  public static final int LOGIN_ERROR_STAMP_TIME_OUT = -62;
  public static final int LOGIN_ERROR_TYPE_ACCOUNT_DOMAIN_ERROR = 10001;
  public static final int LOGIN_ERROR_TYPE_ACCOUNT_NOT_EXIST = 10;
  public static final int LOGIN_ERROR_TYPE_ACCOUNT_REOPEN = 100;
  public static final int LOGIN_ERROR_TYPE_ACCOUNT_SUSPEND = 8;
  public static final int LOGIN_ERROR_TYPE_LOGINED_ACCOUNT = 11;
  public static final int LOGIN_ERROR_TYPE_NEED_PASSWORD = 7;
  public static final int LOGIN_ERROR_TYPE_NEED_SECOND_PASSWORD = 4;
  public static final int LOGIN_ERROR_TYPE_NEED_VERIFY_CODE = 3;
  public static final int LOGIN_ERROR_TYPE_NOT_RELATIVE = -56;
  public static final int LOGIN_ERROR_TYPE_NO_ERR = 0;
  public static final int LOGIN_ERROR_TYPE_PASSWORD_ERROR = 1;
  public static final int LOGIN_ERROR_TYPE_RELATIVE_SESSION_FAIL = -55;
  public static final int LOGIN_ERROR_TYPE_SECOND_PASSWORD_ERROR = 6;
  public static final int LOGIN_ERROR_TYPE_TEST_ERROR = -1001;
  public static final int LOGIN_ERROR_TYPE_UNKNOW = 10000;
  public static final int LOGIN_ERROR_TYPE_VERIFY_CODE_ERROR = 2;
  public static final int LOGIN_ERROR_TYPE_WTLOGIN_EXCHANGE_A2_ERROR = 17;
  public static final int LOGIN_ERROR_TYPE_WTLOGIN_NEED_PSW = 13;
  public static final int LOGIN_ERROR_TYPE_WTLOGIN_NEED_VERIFYCODE = 14;
  public static final int LOGIN_ERROR_TYPE_WTLOGIN_PSW_ERROR = 12;
  public static final int LOGIN_ERROR_TYPE_WTLOGIN_VERIFYCODE_ERROR = 15;
  public static final int LOGIN_STATUS_LOGINED = 2;
  public static final int LOGIN_STATUS_LOGINING = 1;
  public static final int LOGIN_STATUS_LOGIN_FAIL = 3;
  public static final int LOGIN_STATUS_READY = 4;
  public static final int LOGIN_STATUS_UNLOGIN = 0;
  public static final String OS = URLEncoder.encode(new StringBuilder().append("android:").append(Build.MANUFACTURER).append(":").append(Build.MODEL).append(":").append(Build.VERSION.SDK_INT).toString()) + "&channelid=" + ChannelDefine.getChannelId() + "&apv=" + AppConfig.getCodeVersion();
  private static final String OUTPUT_XHTML = "&error=app&f=xhtml";
  private static final String SID = "sid";
  private static final String TAG = "LoginUser";
  public static final int TYPE_AUTO_LOGIN = 4;
  public static final int TYPE_FIRST_LOGIN = 1;
  public static final int TYPE_RELATIVE_LOGIN = 5;
  public static final int TYPE_SECOND_LOGIN = 2;
  public static final int TYPE_UNINIT_LOGIN = -1;
  public static final int TYPE_VERIFY_LOGIN = 3;
  private static final String UIN = "uin";
  private static final String VERIFY = "verify";
  public static final int WTLOGIN_STATUS_LOGINING = 1;
  public static final int WTLOGIN_STATUS_LOGIN_FAIL = 3;
  public static final int WTLOGIN_STATUS_LOGIN_SUCCESS = 2;
  public static final int WTLOGIN_STATUS_UNLOGIN = 4;
  private int RETRY_AUTO_LOGIN_COUNT_MAX = 2;
  private final Account account;
  private String aesKey;
  private String autoLoginPwd;
  private boolean changingPwdWtlogin = false;
  private String currentEmail;
  private String currentEncryptedUin;
  private int currentLoginType = -1;
  private String currentRequestBody = null;
  private String currentUin;
  private String encryptedFolderPwd = null;
  private boolean hasDelayAutoLogin = false;
  private boolean isBindPhone = false;
  private boolean isBiz;
  private String lastLoginBody;
  private String lastSpCache;
  private QMVerify lastVerify = new QMVerify();
  private LoginData loginData;
  private int loginStatus = 0;
  private CopyOnWriteArrayList<Cookie> mCookies;
  private QMNetworkRequest mRequest = null;
  private String mSid;
  private String password;
  private String phoneNum = "";
  private int requestSequence = 0;
  private int retryAutoLoginStampTimeOutCounter = 0;
  private int retryAutoLoginWtloginCounter = 0;
  private String secondPassword;
  private long sessionTime = 3600000L;
  private int wtloginStatus = 4;
  
  public LoginUser(Account paramAccount)
  {
    this.account = paramAccount;
  }
  
  private void abortRequest(boolean paramBoolean)
  {
    QMNetworkRequest localQMNetworkRequest = null;
    try
    {
      if (this.mRequest != null)
      {
        localQMNetworkRequest = this.mRequest;
        this.mRequest = null;
      }
      if (localQMNetworkRequest != null) {
        localQMNetworkRequest.abort(paramBoolean);
      }
      return;
    }
    finally {}
  }
  
  private void clearAllRequests(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(2, "LoginUser", "clearAllRequests:" + this.currentEmail);
    ArrayList localArrayList;
    synchronized (((QQMailAccount)this.account).requestWaitingForSession)
    {
      localArrayList = new ArrayList(((QQMailAccount)this.account).requestWaitingForSession);
      ((QQMailAccount)this.account).requestWaitingForSession.clear();
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext())
      {
        NetworkManager.SessionTask localSessionTask = (NetworkManager.SessionTask)((Iterator)???).next();
        if ((localSessionTask != null) && (localSessionTask.oldCallback != null))
        {
          localSessionTask.oldCallback.handleError(localSessionTask.request, null, paramQMNetworkError);
          localSessionTask.oldCallback.handleComplete(localSessionTask.request, null, paramQMNetworkError);
        }
      }
    }
    localArrayList.clear();
  }
  
  private void clearAutoLoginPassword()
  {
    try
    {
      this.autoLoginPwd = "";
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void doAutoLogin(LoginCallback paramLoginCallback)
  {
    int j = 0;
    int i;
    QMNetworkRequest localQMNetworkRequest;
    for (;;)
    {
      try
      {
        if (this.loginStatus != 4)
        {
          i = this.loginStatus;
          if (i != 1) {}
        }
        else
        {
          return;
        }
        QMLog.log(4, "LoginUser", "autoLogin: " + this.currentUin + ", " + this.currentEmail + ",network connected:" + QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()));
        localObject1 = new StringBuilder();
        if (QMSettingManager.sharedInstance().isEnableHttpsDomain())
        {
          str1 = QMNetworkConfig.getCgiRequestHostHttps(this.account.getId());
          localQMNetworkRequest = new QMNetworkRequest(str1 + "/cgi-bin/" + "login", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
          if (this.autoLoginPwd == null)
          {
            QMLog.log(6, "LoginUser", "autoLoginPwd is null!!!!!");
            this.autoLoginPwd = "";
          }
          i = j;
          if (SharedPreferenceUtil.isWtlogin())
          {
            i = j;
            if (!this.account.isBizMail()) {
              i = 1;
            }
          }
          if (i == 0) {
            break label673;
          }
          str1 = QMWtLoginManager.getInstance().getA2(getCurrentUin());
          if ((str1 != null) && (!str1.equals(""))) {
            break;
          }
          QMLog.log(5, "LoginUser", "doAutoLogin. no a2 exist for " + this.account.getEmail() + ". trigger psw err.");
          AddAccountLocalLogUtil.timeLineAccountChange("SDK", "wtloginNoA2:" + this.account.getEmail());
          PasswordErrHandler.saveStateAndShowErr(this.account.getId(), -1);
          paramLoginCallback = QMApplicationContext.sharedInstance().getString(2131696284);
          clearAllRequests(new QMNetworkError(2, -10000, paramLoginCallback, paramLoginCallback));
        }
        else
        {
          str1 = QMNetworkConfig.getCgiRequestHost(this.account.getId());
        }
      }
      finally {}
    }
    Object localObject1 = new StringBuilder().append(SharedPreferenceUtil.getLoginSvrUtc()).append("\t").append(this.currentUin).append("\t").append(str1).append("\t");
    label412:
    label447:
    label464:
    String str2;
    if (this.account.getSecondPassword() == null)
    {
      str1 = "";
      localObject1 = RsaEncryption.encryptInBlock(str1);
      localObject2 = new StringBuilder();
      if (!RsaEncryption.isLoginUsedRsa()) {
        break label1063;
      }
      str1 = "rautologinpwd=";
      str1 = str1 + (String)localObject1;
      localObject2 = this.currentEmail;
      str2 = getAliasType(this.currentEmail);
      if (this.encryptedFolderPwd != null) {
        break label711;
      }
    }
    label673:
    label711:
    for (localObject1 = "";; localObject1 = this.encryptedFolderPwd)
    {
      str1 = String.format("uin=%s&aliastype=%s&pwd=&%s&fpwd=%s&t=login_json&vt=app&dnsstamp=2012010901&os=%s&error=app&f=xhtml", new Object[] { localObject2, str2, str1, localObject1, OS });
      if (i == 0) {
        break label891;
      }
      str1 = str1 + "&ltype=wtlogin";
      localObject1 = QMWtLoginManager.getInstance().getSkey(getCurrentUin());
      if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
        break label720;
      }
      QMLog.log(5, "LoginUser", "doAutoLogin. no skey exist for " + this.account.getEmail() + ". trigger psw err.");
      PasswordErrHandler.saveStateAndShowErr(this.account.getId(), -1);
      paramLoginCallback = QMApplicationContext.sharedInstance().getString(2131696284);
      clearAllRequests(new QMNetworkError(2, -10000, paramLoginCallback, paramLoginCallback));
      break;
      str1 = this.account.getSecondPassword();
      break label412;
      str1 = Aes.encode(this.autoLoginPwd, Aes.getServerKey());
      str1 = "autologinpwd=" + str1;
      break label464;
    }
    label720:
    Object localObject2 = new StringBuilder().append(str1);
    if (RsaEncryption.isLoginUsedRsa()) {}
    for (String str1 = "&rskey=";; str1 = "&skey=")
    {
      localObject2 = ((StringBuilder)localObject2).append(str1);
      if (RsaEncryption.isLoginUsedRsa()) {
        str1 = RsaEncryption.encryptInBlock((String)localObject1);
      }
      label767:
      for (str1 = str1;; str1 = str1 + "&emailname=" + this.account.getEmail())
      {
        localObject1 = "vt=app" + this.currentEmail + this.autoLoginPwd + this.encryptedFolderPwd;
        if ((this.currentLoginType == -1) || ((this.currentLoginType == 4) && (!((String)localObject1).equals(this.currentRequestBody)))) {
          break label927;
        }
        QMLog.log(4, "LoginUser", "autologin repeat: " + this.currentLoginType);
        break;
        str1 = Aes.encode((String)localObject1, Aes.getServerKey());
        break label767;
      }
      label891:
      QMLog.log(4, "LoginUser", "login : set loginstatus=LOGIN_STATUS_READY");
      label927:
      this.loginStatus = 4;
      localQMNetworkRequest.setRequestParams(str1);
      localQMNetworkRequest.setRequestCallback(generateCallback(this.currentEmail, new LoginUser.6(this, paramLoginCallback)));
      abortRequest(false);
      this.currentLoginType = 4;
      this.currentRequestBody = ((String)localObject1);
      this.lastLoginBody = str1;
      this.mRequest = localQMNetworkRequest;
      QMLog.log(4, "LoginUser", "autologin pwd hash:" + this.account.getId() + "," + AccountManager.shareInstance().getAccountList().getHashAccountPwd(this.account.getId()));
      QMHttpUtil.asyncSend(localQMNetworkRequest);
      break;
      label1063:
      str1 = "autologinpwd=";
      break label447;
    }
  }
  
  private QMCallback generateCallback(String paramString, Callback paramCallback)
  {
    int i = this.requestSequence + 1;
    this.requestSequence = i;
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new LoginUser.8(this, i));
    localQMCallback.setOnError(new LoginUser.9(this, i, paramCallback));
    localQMCallback.setOnSuccess(new LoginUser.10(this, i, paramCallback, paramString));
    return CGIManager.wrapCGICallback(localQMCallback);
  }
  
  private static String getAliasType(String paramString)
  {
    if ((!paramString.contains("@")) || (paramString.endsWith("@qq.com"))) {
      return "@qq.com";
    }
    if (paramString.endsWith("@vip.qq.com")) {
      return "vip";
    }
    if (paramString.endsWith("@foxmail.com")) {
      return "fox";
    }
    return "other";
  }
  
  private ArrayList<Cookie> getCookiesList(String paramString)
  {
    int i = new Random().nextInt(10000) + 1;
    String str = StringExtention.MD5With32Charactor(i + "qqmAILDNscHEck" + paramString).toLowerCase(Locale.getDefault()).substring(0, 8);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicClientCookie("appkey", str));
    localArrayList.add(new BasicClientCookie("k", "" + i));
    localArrayList.add(new BasicClientCookie("curuin", paramString));
    return localArrayList;
  }
  
  private QMNetworkError handleCGIFailError(QMNetworkError paramQMNetworkError)
  {
    if ((paramQMNetworkError instanceof QMCGIError))
    {
      QMCGIError localQMCGIError = (QMCGIError)paramQMNetworkError;
      int i = localQMCGIError.appCode;
      QMLog.log(4, "LoginUser", "handleCGIFailError: " + i + ", " + localQMCGIError.desp);
      if (i == -1001)
      {
        paramQMNetworkError = new QMLoginError(i, 0, 0, "", localQMCGIError.response);
        return paramQMNetworkError;
      }
      if ((i == -100) || (i == -103))
      {
        Object localObject2 = localQMCGIError.desp;
        i = ((String)localObject2).indexOf("?");
        Object localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(i);
        }
        localObject2 = StringExtention.getKeyValueDict((String)localObject1);
        if (((String)localObject1).contains("verify"))
        {
          String str1 = (String)((JSONObject)localObject2).get("verify");
          String str2 = (String)((JSONObject)localObject2).get("errtype");
          if ((str2 != null) && (!str2.equals(""))) {}
          for (i = Integer.parseInt(str2);; i = -1)
          {
            int j = i;
            if (i == 5) {
              j = 2;
            }
            switch (j)
            {
            }
            localObject1 = new QMLoginError(((QMCGIError)paramQMNetworkError).appCode, j, 0, (String)localObject1, localQMCGIError.response);
            paramQMNetworkError = (QMNetworkError)localObject1;
            if (str1 == null) {
              break;
            }
            paramQMNetworkError = (QMNetworkError)localObject1;
            if (!str1.equals("true")) {
              break;
            }
            this.lastVerify.parseWithDictionary((JSONObject)localObject2);
            return localObject1;
          }
        }
        return new QMLoginError(((QMCGIError)paramQMNetworkError).appCode, 1, 0, (String)localObject1, localQMCGIError.response);
      }
      if (i == -2040) {
        return new QMLoginError(localQMCGIError.appCode, 1, 0, localQMCGIError.desp, localQMCGIError.response);
      }
      if (i == -123) {
        return new QMLoginError(localQMCGIError.appCode, 1, 0, QMApplicationContext.sharedInstance().getString(2131689625), localQMCGIError.response);
      }
    }
    return paramQMNetworkError;
  }
  
  private QMNetworkError handleCGISuccessError(QMNetworkResponse paramQMNetworkResponse)
  {
    try
    {
      Object localObject3 = (JSONObject)paramQMNetworkResponse.getResponseJson();
      localObject1 = (String)((JSONObject)localObject3).get("errtype");
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        break label559;
      }
      j = Integer.parseInt((String)localObject1);
      if (j == 0) {
        return null;
      }
      str = (String)((JSONObject)localObject3).get("errmsg");
      localObject1 = (String)((JSONObject)localObject3).get("errtips");
      localObject3 = (String)((JSONObject)localObject3).get("app_code");
      if ((localObject3 == null) || (((String)localObject3).equals(""))) {
        break label554;
      }
      i = Integer.parseInt((String)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        QMLog.log(6, "LoginUser", "handleCGISuccessError exception:" + localException.toString());
        String str = QMApplicationContext.sharedInstance().getString(2131689751);
        int j = 10000;
        int i = 0;
        Object localObject2 = str;
        continue;
        localObject2 = new QMLoginError(i, j, 0, str, paramQMNetworkResponse, (String)localObject2);
        continue;
        clearAutoLoginPassword();
        continue;
        paramQMNetworkResponse.getResponseHeaders();
        if ((isBiz()) || (!SharedPreferenceUtil.isWtlogin()))
        {
          this.lastSpCache = new CookieUtils((List)paramQMNetworkResponse.getResponseHeaders().get("Set-Cookie")).getSpcache();
          ((QQMailAccount)this.account).getLoginUser().lastSpCache = this.lastSpCache;
          continue;
          long l1 = new Date().getTime() / 1000L;
          try
          {
            long l2 = ((JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString())).getLongValue("utctime");
            l1 = l2;
          }
          catch (Exception paramQMNetworkResponse)
          {
            for (;;)
            {
              QMLog.log(6, "LoginUser", "get svr utc err:" + paramQMNetworkResponse.toString());
            }
          }
          SharedPreferenceUtil.setLoginSvrUTC(l1);
          continue;
          label554:
          i = 0;
        }
      }
    }
    QMLog.log(6, "LoginUser", "handleCGISuccessError handle cgi login error, type:" + j + ", errMsg:" + str + ", tips:" + (String)localObject1 + ", appCode:" + i);
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      localObject1 = new QMLoginError(i, j, 0, str, paramQMNetworkResponse);
      switch (j)
      {
      case -64: 
      case -63: 
      case -15: 
      case 10000: 
      default: 
        return localObject1;
      }
    }
    label559:
    return null;
  }
  
  /* Error */
  private QMNetworkError handleCGISuccessUpdateLoginUser(String paramString, QMNetworkResponse paramQMNetworkResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new 9	com/tencent/qqmail/account/model/LoginUser$LoginData
    //   6: dup
    //   7: aload_1
    //   8: aload_2
    //   9: invokespecial 878	com/tencent/qqmail/account/model/LoginUser$LoginData:<init>	(Ljava/lang/String;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;)V
    //   12: putfield 337	com/tencent/qqmail/account/model/LoginUser:loginData	Lcom/tencent/qqmail/account/model/LoginUser$LoginData;
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 337	com/tencent/qqmail/account/model/LoginUser:loginData	Lcom/tencent/qqmail/account/model/LoginUser$LoginData;
    //   20: invokestatic 882	com/tencent/qqmail/account/model/LoginUser$LoginData:access$500	(Lcom/tencent/qqmail/account/model/LoginUser$LoginData;)Ljava/lang/String;
    //   23: invokevirtual 885	com/tencent/qqmail/account/model/LoginUser:setCurrentUin	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 337	com/tencent/qqmail/account/model/LoginUser:loginData	Lcom/tencent/qqmail/account/model/LoginUser$LoginData;
    //   31: invokestatic 888	com/tencent/qqmail/account/model/LoginUser$LoginData:access$600	(Lcom/tencent/qqmail/account/model/LoginUser$LoginData;)Ljava/lang/String;
    //   34: invokespecial 891	com/tencent/qqmail/account/model/LoginUser:setCurrentEncryptedUin	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 337	com/tencent/qqmail/account/model/LoginUser:loginData	Lcom/tencent/qqmail/account/model/LoginUser$LoginData;
    //   42: invokestatic 894	com/tencent/qqmail/account/model/LoginUser$LoginData:access$700	(Lcom/tencent/qqmail/account/model/LoginUser$LoginData;)Ljava/lang/String;
    //   45: aload_0
    //   46: getfield 337	com/tencent/qqmail/account/model/LoginUser:loginData	Lcom/tencent/qqmail/account/model/LoginUser$LoginData;
    //   49: invokestatic 898	com/tencent/qqmail/account/model/LoginUser$LoginData:access$800	(Lcom/tencent/qqmail/account/model/LoginUser$LoginData;)Ljava/util/ArrayList;
    //   52: invokespecial 902	com/tencent/qqmail/account/model/LoginUser:setSidAndCookies	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   55: aload_0
    //   56: invokespecial 905	com/tencent/qqmail/account/model/LoginUser:setSidUpdateTime	()V
    //   59: iconst_4
    //   60: ldc 112
    //   62: new 172	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 907
    //   72: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: getfield 337	com/tencent/qqmail/account/model/LoginUser:loginData	Lcom/tencent/qqmail/account/model/LoginUser$LoginData;
    //   79: invokestatic 894	com/tencent/qqmail/account/model/LoginUser$LoginData:access$700	(Lcom/tencent/qqmail/account/model/LoginUser$LoginData;)Ljava/lang/String;
    //   82: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 375	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 337	com/tencent/qqmail/account/model/LoginUser:loginData	Lcom/tencent/qqmail/account/model/LoginUser$LoginData;
    //   96: invokestatic 910	com/tencent/qqmail/account/model/LoginUser$LoginData:access$3200	(Lcom/tencent/qqmail/account/model/LoginUser$LoginData;)Ljava/lang/String;
    //   99: invokevirtual 913	com/tencent/qqmail/account/model/LoginUser:setAesKey	(Ljava/lang/String;)V
    //   102: aload_2
    //   103: invokevirtual 793	com/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse:getResponseJson	()Ljava/lang/Object;
    //   106: checkcast 770	com/alibaba/fastjson/JSONObject
    //   109: astore_2
    //   110: aload_2
    //   111: ldc_w 915
    //   114: invokevirtual 774	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: checkcast 503	java/lang/String
    //   120: astore 7
    //   122: ldc2_w 245
    //   125: lstore 5
    //   127: lload 5
    //   129: lstore_3
    //   130: aload 7
    //   132: ifnull +9 -> 141
    //   135: aload 7
    //   137: invokestatic 920	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   140: lstore_3
    //   141: aload_2
    //   142: ldc_w 922
    //   145: invokevirtual 774	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: checkcast 503	java/lang/String
    //   151: ldc_w 924
    //   154: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifeq +12 -> 169
    //   160: aload_0
    //   161: getfield 270	com/tencent/qqmail/account/model/LoginUser:account	Lcom/tencent/qqmail/account/model/Account;
    //   164: ldc 237
    //   166: invokevirtual 927	com/tencent/qqmail/account/model/Account:setEncryptedFolderPwd	(Ljava/lang/String;)V
    //   169: aload_0
    //   170: lload_3
    //   171: putfield 248	com/tencent/qqmail/account/model/LoginUser:sessionTime	J
    //   174: iconst_4
    //   175: ldc 112
    //   177: new 172	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 929
    //   187: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_1
    //   191: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 375	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   200: aload_0
    //   201: iconst_2
    //   202: putfield 231	com/tencent/qqmail/account/model/LoginUser:loginStatus	I
    //   205: aload_0
    //   206: monitorexit
    //   207: aconst_null
    //   208: areturn
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: bipush 6
    //   217: ldc 112
    //   219: new 172	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 931
    //   229: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_1
    //   233: invokevirtual 813	java/lang/Exception:toString	()Ljava/lang/String;
    //   236: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 375	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   245: new 749	com/tencent/qqmail/utilities/qmnetwork/login/QMLoginError
    //   248: dup
    //   249: iconst_0
    //   250: sipush 10000
    //   253: iconst_0
    //   254: invokestatic 438	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   257: ldc_w 814
    //   260: invokevirtual 534	com/tencent/qqmail/QMApplicationContext:getString	(I)Ljava/lang/String;
    //   263: invokespecial 934	com/tencent/qqmail/utilities/qmnetwork/login/QMLoginError:<init>	(IIILjava/lang/String;)V
    //   266: areturn
    //   267: astore 7
    //   269: lload 5
    //   271: lstore_3
    //   272: goto -131 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	LoginUser
    //   0	275	1	paramString	String
    //   0	275	2	paramQMNetworkResponse	QMNetworkResponse
    //   129	143	3	l1	long
    //   125	145	5	l2	long
    //   120	16	7	str	String
    //   267	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	122	209	finally
    //   135	141	209	finally
    //   141	169	209	finally
    //   169	207	209	finally
    //   210	212	209	finally
    //   0	2	214	java/lang/Exception
    //   212	214	214	java/lang/Exception
    //   135	141	267	java/lang/Exception
  }
  
  private void retryAutoLogin(boolean paramBoolean, String arg2, LoginCallback paramLoginCallback)
  {
    QMLog.log(4, "LoginUser", "retryAutoLogin account state: " + this.account.getAccountState() + "; " + this.account.getId() + "; " + paramBoolean);
    Object localObject2;
    Object localObject4;
    Object localObject3;
    if (this.account.getAccountState() == -1)
    {
      QMLog.log(6, "LoginUser", "password error, don't autoLogin!!!");
      localObject2 = new QMLoginError(0, 1, 0, String.format(QMApplicationContext.sharedInstance().getString(2131719643), new Object[] { this.account.getEmail() }));
      synchronized (((QQMailAccount)this.account).requestWaitingForSession)
      {
        localObject4 = ((QQMailAccount)this.account).requestWaitingForSession;
        localObject3 = new ArrayList((Collection)localObject4);
        ((ArrayList)localObject4).clear();
        localObject4 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          NetworkManager.SessionTask localSessionTask = (NetworkManager.SessionTask)((Iterator)localObject4).next();
          if ((localSessionTask != null) && (localSessionTask.oldCallback != null))
          {
            localSessionTask.oldCallback.handleError(localSessionTask.request, null, (QMNetworkError)localObject2);
            localSessionTask.oldCallback.handleComplete(localSessionTask.request, null, (QMNetworkError)localObject2);
          }
        }
      }
      ((ArrayList)localObject3).clear();
      triggerAccountLoginError(0L, (QMNetworkError)localObject2);
      AccountManager.shareInstance().triggerAccountStateChange(this.account.getId(), this.account.getAccountState(), ???);
      if (paramLoginCallback != null) {
        paramLoginCallback.loginFail();
      }
    }
    label690:
    do
    {
      long l;
      do
      {
        do
        {
          return;
          if (this.account.getAccountState() != -4) {
            break;
          }
          QMLog.log(6, "Login", "account suspend error, don't autoLogin");
          ??? = new QMLoginError(0, 8, 0, "account suspend. direct return.");
          synchronized (((QQMailAccount)this.account).requestWaitingForSession)
          {
            localObject3 = ((QQMailAccount)this.account).requestWaitingForSession;
            localObject2 = new ArrayList((Collection)localObject3);
            ((ArrayList)localObject3).clear();
            localObject3 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (NetworkManager.SessionTask)((Iterator)localObject3).next();
              if ((localObject4 != null) && (((NetworkManager.SessionTask)localObject4).oldCallback != null))
              {
                ((NetworkManager.SessionTask)localObject4).oldCallback.handleError(((NetworkManager.SessionTask)localObject4).request, null, (QMNetworkError)???);
                ((NetworkManager.SessionTask)localObject4).oldCallback.handleComplete(((NetworkManager.SessionTask)localObject4).request, null, (QMNetworkError)???);
              }
            }
          }
          ((ArrayList)localObject2).clear();
          triggerAccountLoginError(0L, (QMNetworkError)???);
          AccountManager.shareInstance().triggerAccountStateChange(this.account.getId(), this.account.getAccountState(), "");
        } while (paramLoginCallback == null);
        paramLoginCallback.loginFail();
        return;
        l = BackOffFilter.whenToRetryOrAbort(BackOffFilter.genLoginBussinesId(this.account.getId()), paramBoolean);
        if (l == 0L)
        {
          QMLog.log(4, "Login", "autoLogin immediately. network:" + QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()));
          doAutoLogin(paramLoginCallback);
          return;
        }
        if (l <= 0L) {
          break label690;
        }
        if (!this.hasDelayAutoLogin) {
          break;
        }
        QMLog.log(4, "Login", "wait " + l + " second to autoLogin!");
      } while (paramLoginCallback == null);
      paramLoginCallback.loginFail();
      return;
      this.hasDelayAutoLogin = true;
      QMLog.log(4, "Login", "start a timer and wait " + l + " second to autoLogin");
      ??? = new LoginUser.4(this, l, paramLoginCallback);
      new Timer(true).schedule(???, l * 1000L);
      return;
      QMLog.log(4, "Login", "login error and don't retry again!!!");
      triggerAccountLoginError(0L, new QMLoginError(0, 10000, 0, "autoLogin waiting so long time. do not try again."));
    } while (paramLoginCallback == null);
    paramLoginCallback.loginFail();
  }
  
  private void retryWtAutoLogin(QMNetworkError paramQMNetworkError, LoginCallback paramLoginCallback)
  {
    if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()))
    {
      clearAllRequests(paramQMNetworkError);
      QMLog.log(4, "LoginUser", "retryWtAutoLogin. no network return");
      return;
    }
    if (this.wtloginStatus == 1)
    {
      QMLog.log(4, "LoginUser", "retryWtAutoLogin. logining");
      return;
    }
    QMLog.log(4, "LoginUser", "retryWtAutoLogin,isBindPhone:" + this.isBindPhone + ",phoneNum:" + this.phoneNum + ",email:" + this.currentEmail);
    this.wtloginStatus = 1;
    paramQMNetworkError = new LoginUser.7(this, paramLoginCallback, paramQMNetworkError);
    QMWtLoginManager.getNewWtLoginTicket(this.currentUin, paramQMNetworkError);
  }
  
  private void saveUser()
  {
    this.account.setName(this.loginData.email.split("@")[0]);
    this.account.setEmail(this.loginData.email);
    Object localObject2 = StringExtention.MD5With32Charactor(this.secondPassword);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals("")) {
        localObject1 = ((String)localObject2).toLowerCase();
      }
    }
    this.account.setSecondPassword((String)localObject1);
    localObject1 = StringExtention.MD5With32Charactor(this.password);
    this.account.setQqPassword((String)localObject1);
    localObject2 = new StringBuilder().append(this.password).append("\t");
    if (this.secondPassword == null)
    {
      localObject1 = "";
      localObject1 = RsaEncryption.encrypt((String)localObject1);
      this.account.setPwd((String)localObject1);
      localObject1 = this.account;
      if (!isBiz()) {
        break label397;
      }
      i = 2;
      label155:
      ((Account)localObject1).setProtocol(i);
      this.account.setUin(this.loginData.uin);
      this.account.setEncryptedUin(this.loginData.encryptedUin);
      if (!this.account.isQQMail()) {
        break label402;
      }
    }
    label397:
    label402:
    for (int i = Account.generateId(this.account.getUin());; i = Account.generateId(this.account.getEmail()))
    {
      this.account.setId(i);
      QMSyncErrorManager.sharedInstance().removeUnAuthError(i);
      if (this.account.isQQMail())
      {
        localObject1 = (QQMailAccount)this.account;
        if ((this.loginData.sid != null) && (this.loginData.sid.length() > 0) && (this.loginData.cookies != null))
        {
          ((QQMailAccount)localObject1).setSidAndCookies(this.loginData.sid, this.loginData.cookies);
          ((QQMailAccount)localObject1).saveToLocalStorage();
          ((QQMailAccount)localObject1).updateSaveSidTime();
        }
      }
      this.account.setLogined();
      QMLog.log(4, "LoginUser", "new logined user:" + this.loginData.email + ". " + "loginData.isBiz:" + this.loginData.isBiz + ". uin:" + this.loginData.uin + ". aid:" + i);
      return;
      localObject1 = this.secondPassword;
      break;
      i = 1;
      break label155;
    }
  }
  
  private void setCurrentEncryptedUin(String paramString)
  {
    ValidateHelper.notNull(paramString);
    try
    {
      this.currentEncryptedUin = paramString;
      return;
    }
    finally {}
  }
  
  private void setSidAndCookies(String paramString, ArrayList<Cookie> paramArrayList)
  {
    int i = 1;
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (paramString.equals("")) || (paramArrayList == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("LoginUser setSidAndCookies err :");
      if (paramString == null)
      {
        bool1 = true;
        paramString = localStringBuilder.append(bool1).append(",");
        if (paramArrayList != null) {
          break label88;
        }
        bool1 = bool2;
        label66:
        QMLog.log(4, "LoginUser", bool1);
      }
    }
    label212:
    for (;;)
    {
      return;
      bool1 = false;
      break;
      label88:
      bool1 = false;
      break label66;
      this.mSid = paramString;
      if (this.mCookies == null)
      {
        this.mCookies = new CopyOnWriteArrayList();
        this.mCookies.addAll(paramArrayList);
        paramString = paramArrayList.iterator();
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
        } while (!"curuin".equals(((Cookie)paramString.next()).getName()));
      }
      for (;;)
      {
        if (i != 0) {
          break label212;
        }
        this.mCookies.add(new BasicClientCookie("curuin", this.currentUin));
        return;
        this.mCookies.clear();
        this.mCookies.addAll(paramArrayList);
        break;
        i = 0;
      }
    }
  }
  
  private void setSidUpdateTime()
  {
    ((QQMailAccount)this.account).updateSaveSidTime();
  }
  
  public static void stopPushAndKillProcess()
  {
    QMServiceManager.stopPushService();
    QMActivityManager.shareInstance().finishAllActivity();
    Process.killProcess(Process.myPid());
  }
  
  private void triggerAccountLoginError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "LoginUser", "triggerLoginError");
    LoginManager.shareInstance().triggerLoginError(this.account.getId(), paramLong, paramQMNetworkError, this.currentEmail, true, false, -1);
  }
  
  private void triggerAccountLoginSuccess(long paramLong, boolean paramBoolean)
  {
    QMLog.log(4, "LoginUser", "triggerLoginSuccess");
    LoginManager.shareInstance().triggerLoginSuccess(this.account.getId(), paramLong, paramBoolean);
  }
  
  private void triggerLoginUnknownError(long paramLong)
  {
    QMLog.log(4, "LoginUser", "triggerLoginUnknownError");
    triggerAccountLoginError(paramLong, new QMLoginError(0, 10000, 0, QMApplicationContext.sharedInstance().getString(2131689751)));
  }
  
  public void autoLogin(LoginCallback paramLoginCallback)
  {
    if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()))
    {
      QMLog.log(6, "LoginUser", "autoLogin. no network return.");
      clearAllRequests(new QMNetworkError(2, -10000, QMApplicationContext.sharedInstance().getString(2131695520), ""));
    }
    do
    {
      return;
      if ((SharedPreferenceUtil.isWtlogin()) || (!this.account.isQQMail()) || (this.account.isBizMail())) {
        break;
      }
    } while (this.changingPwdWtlogin);
    this.changingPwdWtlogin = true;
    QMLog.log(4, "LoginUser", "autoLogin go change md5");
    paramLoginCallback = new LoginUser.5(this, paramLoginCallback);
    QMPrivateProtocolManager.sharedInstance().changePwd4Wtlogin(this.account.getId(), paramLoginCallback);
    return;
    QMLog.log(4, "LoginUser", "retryAutoLogin log line 854");
    retryAutoLogin(false, "", paramLoginCallback);
  }
  
  public String getAesKey()
  {
    return this.aesKey;
  }
  
  public String getAutoLoginPwd()
  {
    return this.autoLoginPwd;
  }
  
  public ArrayList<Cookie> getCookies()
  {
    ArrayList localArrayList = getCookiesList(this.currentUin);
    if (this.mCookies != null)
    {
      Iterator localIterator = this.mCookies.iterator();
      while (localIterator.hasNext())
      {
        Cookie localCookie = (Cookie)localIterator.next();
        if ((!"appkey".equals(localCookie.getName())) && (!"k".equals(localCookie.getName())) && (!"curuin".equals(localCookie.getName()))) {
          localArrayList.add(localCookie);
        }
      }
    }
    return localArrayList;
  }
  
  public String getCurrentEmail()
  {
    return this.currentEmail;
  }
  
  public String getCurrentEncryptedUin()
  {
    return this.currentEncryptedUin;
  }
  
  public String getCurrentUin()
  {
    return this.currentUin;
  }
  
  public String getFolderPassword()
  {
    return this.encryptedFolderPwd;
  }
  
  public QMVerify getLastVerify()
  {
    return this.lastVerify;
  }
  
  public int getLoginStatus()
  {
    return this.loginStatus;
  }
  
  public String getSid()
  {
    return this.mSid;
  }
  
  public void isBindPhone(boolean paramBoolean)
  {
    this.isBindPhone = paramBoolean;
  }
  
  public boolean isBiz()
  {
    return this.isBiz;
  }
  
  public void login(long paramLong)
  {
    int j = 0;
    if ((this.loginStatus == 4) || (this.loginStatus == 1)) {
      return;
    }
    QMLog.log(4, "LoginUser", "login : set loginstatus=LOGIN_STATUS_READY");
    this.loginStatus = 4;
    Object localObject2 = new StringBuilder();
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
    QMNetworkRequest localQMNetworkRequest;
    int i;
    for (String str1 = QMNetworkConfig.getCgiRequestHostHttps(isBiz());; str2 = QMNetworkConfig.getCgiRequestHost(isBiz()))
    {
      localQMNetworkRequest = new QMNetworkRequest(str1 + "/cgi-bin/" + "login", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
      try
      {
        ValidateHelper.notNullAndNotEmpty(this.currentEmail);
        i = j;
        if (SharedPreferenceUtil.isWtlogin())
        {
          i = j;
          if (!this.isBiz) {
            i = 1;
          }
        }
        if (i == 0) {
          break label489;
        }
        str1 = QMWtLoginManager.getInstance().getA2(getCurrentUin());
        if ((str1 != null) && (!str1.equals(""))) {
          break;
        }
        QMLog.log(6, "LoginUser", "wtlogin a2 not exist:" + this.currentEmail);
        triggerLoginUnknownError(paramLong);
        return;
      }
      finally {}
    }
    localObject2 = SharedPreferenceUtil.getLoginSvrUtc() + "\t" + this.currentUin + "\t" + str2 + "\t";
    Object localObject3 = new StringBuilder();
    label315:
    label489:
    StringBuilder localStringBuilder;
    if (RsaEncryption.isLoginUsedRsa())
    {
      str2 = "rpwd=";
      localObject3 = ((StringBuilder)localObject3).append(str2);
      if (RsaEncryption.isLoginUsedRsa())
      {
        str2 = RsaEncryption.encryptInBlock((String)localObject2);
        localObject2 = str2;
        if (!this.isBindPhone) {
          break label520;
        }
      }
      label520:
      for (str2 = this.currentUin + "@qq.com";; str2 = this.currentEmail)
      {
        str2 = String.format("uin=%s&aliastype=%s&%s&t=login_json&dnsstamp=2012010901&os=%s&error=app&f=xhtml", new Object[] { str2, getAliasType(this.currentEmail), localObject2, OS });
        if (i == 0) {
          break label717;
        }
        str2 = str2 + "&ltype=wtlogin";
        localObject3 = QMWtLoginManager.getInstance().getSkey(getCurrentUin());
        if ((localObject3 != null) && (!((String)localObject3).equals(""))) {
          break label529;
        }
        QMLog.log(6, "LoginUser", "wtlogin skey not exist:" + this.currentEmail);
        triggerLoginUnknownError(paramLong);
        return;
        str2 = Aes.encode((String)localObject2, Aes.getServerKey());
        break;
        localObject2 = "pwd=" + RsaEncryption.encryptPwdBeforeSend(this.password);
        break label315;
      }
      label529:
      QMLog.log(4, "LoginUser", "wtlogin skey:" + (String)localObject3);
      localStringBuilder = new StringBuilder().append(str2);
      if (!RsaEncryption.isLoginUsedRsa()) {
        break label937;
      }
    }
    label912:
    label920:
    label937:
    for (String str2 = "&rskey=";; str2 = "&skey=")
    {
      localStringBuilder = localStringBuilder.append(str2);
      if (RsaEncryption.isLoginUsedRsa())
      {
        str2 = RsaEncryption.encryptInBlock((String)localObject3);
        str2 = str2;
        label615:
        localStringBuilder = new StringBuilder();
        if (!this.isBindPhone) {
          break label743;
        }
      }
      label717:
      label743:
      for (localObject3 = this.currentUin + "@qq.com";; localObject3 = this.currentEmail)
      {
        localObject3 = (String)localObject3 + (String)localObject2;
        if ((this.currentLoginType != 1) || (!((String)localObject3).equals(this.currentRequestBody))) {
          break label752;
        }
        QMLog.log(4, "LoginUser", "login repeat");
        return;
        str2 = Aes.encode((String)localObject3, Aes.getServerKey());
        break;
        str2 = str2 + "&ltype=normal";
        break label615;
      }
      label752:
      localObject2 = str2;
      if (this.isBindPhone)
      {
        str2 = str2 + "&bindphone=true";
        localObject2 = new StringBuilder().append(str2);
        if (!RsaEncryption.isLoginUsedRsa()) {
          break label912;
        }
        str2 = "&rphoneNum=";
        localObject2 = ((StringBuilder)localObject2).append(str2);
        if (!RsaEncryption.isLoginUsedRsa()) {
          break label920;
        }
      }
      for (str2 = RsaEncryption.encryptInBlock(this.phoneNum);; str2 = this.phoneNum)
      {
        localObject2 = str2;
        localQMNetworkRequest.setRequestParams((String)localObject2);
        localQMNetworkRequest.setRequestCallback(generateCallback(this.currentEmail, new LoginUser.1(this, paramLong)));
        abortRequest(false);
        this.currentLoginType = 1;
        this.currentRequestBody = ((String)localObject3);
        this.lastLoginBody = ((String)localObject2);
        this.mRequest = localQMNetworkRequest;
        QMHttpUtil.asyncSend(localQMNetworkRequest);
        return;
        str2 = "&phoneNum=";
        break;
      }
      str2 = "pwd=";
      break;
    }
  }
  
  public void loginWithSecondPassword(long paramLong)
  {
    int i = 1;
    QMLog.log(4, "LoginUser", "loginWithSecondPassword:" + this.currentEmail);
    Object localObject2 = new StringBuilder();
    String str1;
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain())
    {
      str1 = QMNetworkConfig.getCgiRequestHostHttps(this.account.getId());
      localObject2 = new QMNetworkRequest(str1 + "/cgi-bin/" + "login", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
    }
    String str3;
    for (;;)
    {
      try
      {
        ValidateHelper.notNullAndNotEmpty(this.currentEmail);
        ValidateHelper.notNullAndNotEmpty(this.secondPassword);
        long l;
        if ((SharedPreferenceUtil.isWtlogin()) && (!isBiz()))
        {
          if (i == 0) {
            ValidateHelper.notNullAndNotEmpty(this.lastSpCache);
          }
          str1 = StringExtention.MD5With32Charactor(this.secondPassword).toLowerCase();
          l = SharedPreferenceUtil.getLoginSvrUtc();
          if (i == 0) {
            break label457;
          }
          str3 = QMWtLoginManager.getInstance().getA2(getCurrentUin());
          if ((str3 != null) && (!str3.equals(""))) {
            continue;
          }
          triggerLoginUnknownError(paramLong);
          return;
          str1 = QMNetworkConfig.getCgiRequestHost(this.account.getId());
          break;
        }
        i = 0;
        continue;
        str3 = RsaEncryption.encryptInBlock(l + "\t" + this.currentUin + "\t" + str3 + "\t" + str1);
        localStringBuilder = new StringBuilder();
        if (RsaEncryption.isLoginUsedRsa())
        {
          str1 = "rpwd=";
          str1 = str1 + str3;
          str1 = String.format("uin=%s&aliastype=%s&%s&t=login_json&dnsstamp=2012010901&os=%s&spcache=%s&error=app&f=xhtml", new Object[] { this.currentEmail, getAliasType(this.currentEmail), str1, OS, this.lastSpCache });
          if (i == 0) {
            break label622;
          }
          str1 = str1 + "&ltype=wtlogin";
          str3 = QMWtLoginManager.getInstance().getSkey(getCurrentUin());
          if ((str3 != null) && (!str3.equals(""))) {
            break label492;
          }
          QMLog.log(6, "LoginUser", "wtlogin skey not exist:" + this.currentEmail);
          triggerLoginUnknownError(paramLong);
          return;
        }
      }
      finally {}
      str2 = "pwd=";
      continue;
      label457:
      str2 = RsaEncryption.encryptPwdBeforeSend(this.secondPassword);
      str2 = "pwd=" + str2;
    }
    label492:
    StringBuilder localStringBuilder = new StringBuilder().append(str2);
    if (RsaEncryption.isLoginUsedRsa()) {}
    for (String str2 = "&rskey=";; str2 = "&skey=")
    {
      localStringBuilder = localStringBuilder.append(str2);
      if (RsaEncryption.isLoginUsedRsa()) {
        str2 = RsaEncryption.encryptInBlock(str3);
      }
      label622:
      for (str2 = str2;; str2 = str2 + "&ltype=normal")
      {
        str3 = this.currentEmail + this.secondPassword;
        if ((this.currentLoginType != 2) || (!str3.equals(this.currentRequestBody))) {
          break label648;
        }
        QMLog.log(4, "LoginUser", "seclogin repeat");
        return;
        str2 = Aes.encode(str3, Aes.getServerKey());
        break;
      }
      label648:
      ((QMNetworkRequest)localObject2).setRequestParams(str2);
      ((QMNetworkRequest)localObject2).setRequestCallback(generateCallback(this.currentEmail, new LoginUser.2(this, paramLong)));
      abortRequest(false);
      this.currentLoginType = 2;
      this.currentRequestBody = str3;
      this.lastLoginBody = str2;
      this.mRequest = ((QMNetworkRequest)localObject2);
      QMHttpUtil.asyncSend((QMNetworkRequest)localObject2);
      return;
    }
  }
  
  public void loginWithVerify(long paramLong, String paramString)
  {
    QMLog.log(4, "LoginUser", "loginWithVerify:" + this.currentEmail);
    ValidateHelper.notNullAndNotEmpty(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {
      localObject = QMNetworkConfig.getCgiRequestHostHttps(this.account.getId());
    }
    for (;;)
    {
      localObject = new QMNetworkRequest((String)localObject + "/cgi-bin/" + "login", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
      try
      {
        ValidateHelper.notNullAndNotEmpty(this.lastLoginBody);
        paramString = String.format("%s&verifycode=%s&vid=%s&vuin=%s&vurl=%s&authtype=%s", new Object[] { this.lastLoginBody, paramString, this.lastVerify.getVid(), this.lastVerify.getVuin(), this.lastVerify.getVurl(), this.lastVerify.getAuthtype() });
        if ((this.currentLoginType == 3) && (paramString.equals(this.currentRequestBody)))
        {
          QMLog.log(4, "LoginUser", "verifylogin repeat");
          return;
          localObject = QMNetworkConfig.getCgiRequestHost(this.account.getId());
          continue;
        }
        ((QMNetworkRequest)localObject).setRequestParams(paramString);
        ((QMNetworkRequest)localObject).setRequestCallback(generateCallback(this.currentEmail, new LoginUser.3(this, paramLong)));
        abortRequest(false);
        this.currentLoginType = 3;
        this.currentRequestBody = paramString;
        this.mRequest = ((QMNetworkRequest)localObject);
        QMHttpUtil.asyncSend((QMNetworkRequest)localObject);
        return;
      }
      finally {}
    }
  }
  
  public void setAesKey(String paramString)
  {
    this.aesKey = paramString;
  }
  
  public void setAutoLoginPwd(String paramString)
  {
    this.autoLoginPwd = paramString;
  }
  
  public void setBiz(boolean paramBoolean)
  {
    this.isBiz = paramBoolean;
  }
  
  public void setCookies(CopyOnWriteArrayList<Cookie> paramCopyOnWriteArrayList)
  {
    if (this.mCookies == null)
    {
      this.mCookies = new CopyOnWriteArrayList();
      this.mCookies.addAll(paramCopyOnWriteArrayList);
    }
    while (this.mCookies == paramCopyOnWriteArrayList) {
      return;
    }
    this.mCookies.clear();
    this.mCookies.addAll(paramCopyOnWriteArrayList);
  }
  
  public void setCurrentEmail(String paramString)
  {
    ValidateHelper.notNullAndNotEmpty(paramString);
    if (paramString.equals(this.currentEmail)) {
      return;
    }
    try
    {
      this.currentEmail = paramString;
      this.currentUin = null;
      this.password = null;
      this.lastSpCache = null;
      this.secondPassword = null;
      this.lastVerify = new QMVerify();
      return;
    }
    finally {}
  }
  
  public void setCurrentUin(String paramString)
  {
    ValidateHelper.notNullAndNotEmpty(paramString);
    try
    {
      this.currentUin = paramString;
      return;
    }
    finally {}
  }
  
  public void setEncryptedFolderPwd(String paramString)
  {
    this.encryptedFolderPwd = paramString;
  }
  
  public void setLogined()
  {
    this.loginStatus = 2;
  }
  
  public void setPassword(String paramString)
  {
    try
    {
      this.password = paramString;
      return;
    }
    finally {}
  }
  
  public void setPhoneNum(String paramString)
  {
    this.phoneNum = paramString;
  }
  
  public void setSecondPassword(String paramString)
  {
    try
    {
      this.secondPassword = paramString;
      return;
    }
    finally {}
  }
  
  public void setSid(String paramString)
  {
    this.mSid = paramString;
  }
  
  public void wtAutoLogin(LoginCallback paramLoginCallback)
  {
    retryWtAutoLogin(new QMNetworkError(4, -10000), paramLoginCallback);
  }
  
  abstract class Callback
  {
    private Callback() {}
    
    public void onAbort() {}
    
    public abstract void onError(QMNetworkError paramQMNetworkError);
    
    public abstract void onSuccess(String paramString);
  }
  
  public static class LoginData
  {
    private String aesKey;
    private ArrayList<Cookie> cookies;
    private String email;
    private String encryptedUin;
    private boolean isBiz;
    private String sid;
    private String uin;
    
    public LoginData(String paramString, QMNetworkResponse paramQMNetworkResponse)
    {
      this.email = paramString;
      if (paramQMNetworkResponse == null) {
        QMLog.log(4, "LoginUser", "LoginData. response null");
      }
      do
      {
        return;
        paramString = (JSONObject)paramQMNetworkResponse.getResponseJson();
        if (paramString == null)
        {
          QMLog.log(4, "LoginUser", "LoginData. json null:" + paramQMNetworkResponse.getResponseString());
          return;
        }
        QMLog.log(2, "LoginUser", "LoginData. json:" + paramString);
        this.uin = ((String)paramString.get("uin"));
        ValidateHelper.notNullAndNotEmpty(this.uin);
        this.sid = ((String)paramString.get("sid"));
        ValidateHelper.notNullAndNotEmpty(this.sid);
        this.aesKey = ((String)paramString.get("aeskey"));
        ValidateHelper.notNullAndNotEmpty(this.aesKey);
        this.isBiz = "bizmail".equals(paramString.get("product"));
        paramString = (String)paramString.get("encryptedUin");
        if (paramString != null) {}
        for (;;)
        {
          this.encryptedUin = paramString;
          this.cookies = new ArrayList();
          if (paramQMNetworkResponse.getResponseHeaders() != null) {
            break;
          }
          QMLog.log(4, "LoginUser", "LoginedData. response headers null");
          return;
          paramString = this.uin;
        }
        localObject1 = (List)paramQMNetworkResponse.getResponseHeaders().get("Set-Cookie");
        paramString = new NetscapeDraftSpec();
        paramQMNetworkResponse = new CookieOrigin("mail.qq.com", 80, "/", false);
      } while (localObject1 == null);
      Object localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        try
        {
          localObject2 = paramString.parse(new BasicHeader("Set-Cookie", (String)localObject2), paramQMNetworkResponse).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Cookie localCookie = (Cookie)((Iterator)localObject2).next();
            this.cookies.add(localCookie);
          }
        }
        catch (MalformedCookieException localMalformedCookieException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser
 * JD-Core Version:    0.7.0.1
 */