package com.tencent.qqmail.utilities.qmnetwork;

import android.text.TextUtils;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.LoginUser;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class CGIRequest
  extends QMNetworkRequest
{
  private static final String TAG = "CGIRequest";
  public final int accountId;
  private boolean useWebSid = false;
  private boolean withoutSession = false;
  
  public CGIRequest(int paramInt, String paramString)
  {
    this(paramInt, paramString, QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET, 15000, 15000);
  }
  
  public CGIRequest(int paramInt, String paramString, QMNetworkRequest.QMHttpMethod paramQMHttpMethod)
  {
    this(paramInt, paramString, paramQMHttpMethod, 15000, 15000);
  }
  
  public CGIRequest(int paramInt1, String paramString, QMNetworkRequest.QMHttpMethod paramQMHttpMethod, int paramInt2, int paramInt3)
  {
    super(paramString, paramQMHttpMethod, paramInt2, paramInt3, true);
    this.accountId = paramInt1;
  }
  
  public CGIRequest(int paramInt, String paramString, boolean paramBoolean)
  {
    this(paramInt, paramString);
    this.useWebSid = paramBoolean;
  }
  
  public CGIRequest(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramInt, paramString);
    this.useWebSid = paramBoolean1;
    this.withoutSession = paramBoolean2;
  }
  
  private String getSid()
  {
    Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    if ((localObject1 instanceof QQMailAccount))
    {
      Object localObject2 = (QQMailAccount)localObject1;
      localObject1 = ((QQMailAccount)localObject2).getSid();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QMLog.log(5, "CGIRequest", "sid is null, try to restore");
        ((QQMailAccount)localObject2).restoreAesKey();
        ((QQMailAccount)localObject2).restoreSidAndCookies();
        localObject1 = ((QQMailAccount)localObject2).getSid();
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          if (!this.useWebSid)
          {
            localObject2 = localObject1;
            if (!isJsonRequest(this)) {}
          }
          else
          {
            int i = ((String)localObject1).indexOf(',');
            localObject2 = localObject1;
            if (i > 0) {
              localObject2 = ((String)localObject1).substring(0, i);
            }
          }
        }
        return localObject2;
      }
    }
    return "";
  }
  
  private boolean isJsonRequest(QMNetworkRequest paramQMNetworkRequest)
  {
    return paramQMNetworkRequest.getRequestUrlString().contains("/cgi-bin/viewcompress");
  }
  
  private String systemInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&error=app");
    if ((getRequestUrlString().contains("/cgi-bin/ftnExs_download?")) && (getRequestUrlString().contains("t=ftnExs_Key")))
    {
      localStringBuilder.append("&apv=");
      localStringBuilder.append(AppConfig.getCodeVersion());
      if (!getRequestUrlString().contains("/cgi-bin/mobile_syn")) {
        break label124;
      }
      localStringBuilder.append("&os=").append(LoginUser.OS);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (getRequestUrlString().contains("/cgi-bin/bottle_list")) {
        break;
      }
      if (isJsonRequest(this))
      {
        localStringBuilder.append("&f=json");
        break;
      }
      localStringBuilder.append("&f=xhtml");
      break;
      label124:
      localStringBuilder.append("&os=android");
    }
  }
  
  public QMNetworkRequest.BodyData getBodyData()
  {
    QMNetworkRequest.BodyData localBodyData = super.getBodyData();
    if (((this.httpMethod == QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST) || (this.httpMethod == QMNetworkRequest.QMHttpMethod.QMHttpMethod_MULTIPART)) && (this.canAddSession))
    {
      if ((localBodyData == null) || (localBodyData.size() == 0)) {
        return new QMNetworkRequest.ParamsBodyData(this, "sid=" + getSid() + systemInfo());
      }
      return new QMNetworkRequest.ParamsBodyData(this, localBodyData.toString() + "&sid=" + getSid() + systemInfo());
    }
    return localBodyData;
  }
  
  public ArrayList<Cookie> getRequestCookies()
  {
    ArrayList localArrayList = super.getRequestCookies();
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (this.canAddSession)
    {
      localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
      localObject1 = localArrayList;
      if (localObject2 != null)
      {
        localObject1 = localArrayList;
        if ((localObject2 instanceof QQMailAccount))
        {
          localObject2 = (QQMailAccount)localObject2;
          ValidateHelper.notNull(localObject2);
          if (localArrayList == null) {
            break label212;
          }
          localArrayList = new ArrayList(localArrayList);
          if (((QQMailAccount)localObject2).getCookies() != null) {
            localArrayList.addAll(((QQMailAccount)localObject2).getCookies());
          }
          localObject3 = getRequestUrlString();
          QMLog.log(4, "CGIRequest", "request url:" + (String)localObject3 + ", withoutSession: " + this.withoutSession);
          localObject1 = localArrayList;
          if (!StringExtention.isNullOrEmpty((String)localObject3))
          {
            localObject1 = localArrayList;
            if (this.withoutSession)
            {
              if ((!SharedPreferenceUtil.isWtlogin()) || (((QQMailAccount)localObject2).isBizMail())) {
                break label405;
              }
              localObject1 = QMWtLoginManager.getInstance().getA2(((QQMailAccount)localObject2).getUin());
              if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
                break label223;
              }
              QMLog.log(6, "CGIRequest", "wtlogin a2 not exist:" + ((QQMailAccount)localObject2).getEmail());
              localObject1 = localArrayList;
            }
          }
        }
      }
    }
    for (;;)
    {
      return localObject1;
      label212:
      localArrayList = new ArrayList();
      break;
      label223:
      QMLog.log(4, "CGIRequest", "add cookie akey wtlogin. uin:" + ((QQMailAccount)localObject2).getUin() + ", a2:" + (String)localObject1);
      localObject3 = new StringBuilder().append(SharedPreferenceUtil.getLoginSvrUtc()).append("\t").append(((QQMailAccount)localObject2).getUin()).append("\t").append((String)localObject1).append("\t");
      if (((QQMailAccount)localObject2).getSecondPassword() == null)
      {
        localObject1 = "";
        label314:
        localObject1 = (String)localObject1;
        if (!RsaEncryption.isLoginUsedRsa()) {
          break label380;
        }
        localArrayList.add(new BasicClientCookie("rakey", RsaEncryption.encryptInBlock((String)localObject1)));
      }
      for (;;)
      {
        localArrayList.add(new BasicClientCookie("ltype", "wtlogin"));
        localObject1 = localArrayList;
        break;
        localObject1 = ((QQMailAccount)localObject2).getSecondPassword();
        break label314;
        label380:
        localArrayList.add(new BasicClientCookie("akey", Aes.encode((String)localObject1, Aes.getServerKey())));
      }
      label405:
      if (RsaEncryption.isLoginUsedRsa())
      {
        localArrayList.add(new BasicClientCookie("rakey", RsaEncryption.encryptInBlock(((QQMailAccount)localObject2).getAutologinKey())));
        localObject1 = localArrayList;
      }
      else
      {
        localArrayList.add(new BasicClientCookie("akey", Aes.encode(((QQMailAccount)localObject2).getAutologinKey(), Aes.getServerKey())));
        localObject1 = localArrayList;
        continue;
        localObject1 = localArrayList;
      }
    }
  }
  
  public boolean isWithoutSession()
  {
    return this.withoutSession;
  }
  
  public String prepareURL()
  {
    char c = '?';
    String str = super.prepareURL();
    if ((this.httpMethod == QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET) && (this.canAddSession))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      if (str.indexOf('?') >= 0) {
        c = '&';
      }
      localStringBuilder = localStringBuilder.append(c).append("sid=").append(getSid());
      if (this.useWebSid) {}
      for (str = "";; str = systemInfo()) {
        return str;
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.CGIRequest
 * JD-Core Version:    0.7.0.1
 */