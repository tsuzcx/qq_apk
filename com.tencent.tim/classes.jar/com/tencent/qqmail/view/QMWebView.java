package com.tencent.qqmail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.utilities.WebviewUtilities;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class QMWebView
  extends SmoothScrollableWebView
{
  private static final int LOAD_WEB_TYPE_LOADDATAWITHBASEURL = 3;
  private static final int LOAD_WEB_TYPE_LOADURL = 1;
  private static final int LOAD_WEB_TYPE_LOADURLWITHATTRS = 2;
  private static final String QQ_COM_REGEX = "http(s?)://.*\\.qq.com/.*";
  private static final String TAG = "QMWebView";
  private static Pattern p = Pattern.compile("http(s?)://.*\\.qq.com/.*");
  private int accountId;
  private Map<String, String> additionalHttpHeaders;
  boolean attachedToWindow = true;
  private boolean autoAuth = false;
  private String baseUrl;
  private String data;
  private String encoding;
  private String historyUrl;
  boolean isDestroyed = false;
  private int load_web_type;
  private String mimeType;
  private String url;
  
  public QMWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void appendAkeyToCookie(String paramString, int paramInt)
  {
    QMLog.log(4, "QMWebView", "appendAkey:" + paramInt);
    String str2 = WebviewUtilities.getCookies(paramString);
    Cookie localCookie = getNullableAkeyCookie(paramInt);
    String str1 = str2;
    if (localCookie != null)
    {
      str1 = localCookie.getName() + "=" + localCookie.getValue() + ";";
      str1 = str2 + ";" + str1;
    }
    Log.d("mason", "QMWebView. appendAkeyToCookie. cookieString:" + str1);
    if ((str1 != null) && (!str1.equals(""))) {
      WebviewUtilities.setCookies(paramString, str1.split(";"));
    }
  }
  
  private boolean filterUrl(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Log.d("mason", paramString);
    Matcher localMatcher = p.matcher(paramString);
    if ((localMatcher != null) && (localMatcher.find()))
    {
      Log.d("mason", "is qq com:" + paramString);
      return true;
    }
    Log.i("mason", "is not qq com:" + paramString);
    return false;
  }
  
  private Cookie getNullableAkeyCookie(int paramInt)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localObject != null) && ((localObject instanceof QQMailAccount)))
    {
      if (RsaEncryption.isLoginUsedRsa())
      {
        if ((SharedPreferenceUtil.isWtlogin()) && (!((Account)localObject).isBizMail()))
        {
          StringBuilder localStringBuilder = new StringBuilder().append(SharedPreferenceUtil.getLoginSvrUtc()).append("\t").append(((Account)localObject).getUin()).append("\t").append(QMWtLoginManager.getInstance().getA2(((Account)localObject).getUin())).append("\t");
          if (((Account)localObject).getSecondPassword() == null) {}
          for (localObject = "";; localObject = ((Account)localObject).getSecondPassword()) {
            return new BasicClientCookie("rakey", RsaEncryption.encryptInBlock((String)localObject));
          }
        }
        return new BasicClientCookie("rakey", RsaEncryption.encryptInBlock(((QQMailAccount)localObject).getAutologinKey()));
      }
      localObject = ((QQMailAccount)localObject).getAutologinKey();
      if ((localObject != null) && (!((String)localObject).equals(""))) {
        return new BasicClientCookie("akey", Aes.encode((String)localObject, Aes.getServerKey()));
      }
    }
    return null;
  }
  
  private void handleAutoAuth()
  {
    if (this.autoAuth)
    {
      if ((this.load_web_type != 1) && (this.load_web_type != 2)) {
        break label47;
      }
      if (filterUrl(this.url)) {
        appendAkeyToCookie(this.url, this.accountId);
      }
    }
    label47:
    while ((this.load_web_type != 3) || (!filterUrl(this.baseUrl))) {
      return;
    }
    appendAkeyToCookie(this.baseUrl, this.accountId);
  }
  
  public void destroy()
  {
    this.isDestroyed = true;
    if (!this.attachedToWindow) {
      postDelayed(new QMWebView.1(this), 1000L);
    }
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public Map<String, String> getAdditionalHttpHeaders()
  {
    return this.additionalHttpHeaders;
  }
  
  public String getLoadBaseUrl()
  {
    return this.baseUrl;
  }
  
  public String getLoadData()
  {
    return this.data;
  }
  
  public String getLoadEncoding()
  {
    return this.encoding;
  }
  
  public String getLoadHistoryUrl()
  {
    return this.historyUrl;
  }
  
  public String getLoadMimeType()
  {
    return this.mimeType;
  }
  
  public String getLoadUrl()
  {
    return this.url;
  }
  
  public int getLoadWebType()
  {
    return this.load_web_type;
  }
  
  public boolean isAutoAuth()
  {
    return this.autoAuth;
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Log.i("mason", "loadDataWithBaseURL");
    this.baseUrl = paramString1;
    this.data = paramString2;
    this.mimeType = paramString3;
    this.encoding = paramString4;
    this.historyUrl = paramString5;
    this.load_web_type = 3;
    handleAutoAuth();
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    this.url = paramString;
    this.load_web_type = 1;
    handleAutoAuth();
    try
    {
      super.loadUrl(paramString, this.additionalHttpHeaders);
      return;
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "QMWebView", "super.loadurl() failed", paramString);
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    QMLog.log(4, "QMWebView", "loadurlattrs:" + paramString);
    this.url = paramString;
    this.additionalHttpHeaders = paramMap;
    this.load_web_type = 2;
    handleAutoAuth();
    try
    {
      super.loadUrl(paramString, paramMap);
      return;
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "QMWebView", "super.loadurl() failed", paramString);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.attachedToWindow = false;
    if (this.isDestroyed) {
      postDelayed(new QMWebView.2(this), 1000L);
    }
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAutoAuth(boolean paramBoolean)
  {
    this.autoAuth = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMWebView
 * JD-Core Version:    0.7.0.1
 */