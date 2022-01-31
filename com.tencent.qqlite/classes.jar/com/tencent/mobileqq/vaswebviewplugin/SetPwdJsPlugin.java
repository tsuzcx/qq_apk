package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.Arrays;

public class SetPwdJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String NAMESPACE = "SetPwdJsInterface";
  private static final String tag = "Q.login.SetPwdJsPlugin";
  protected QQBrowserActivity activity = null;
  private QQProgressDialog progressDialog = null;
  
  private void getA2(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("getA2", "", this.mOnRemoteResp.key, localBundle), true, false);
  }
  
  private void hideProgressDialog()
  {
    if (this.activity == null) {
      return;
    }
    this.activity.runOnUiThread(new SetPwdJsPlugin.3(this));
  }
  
  private void setHasSetPwd()
  {
    sendRemoteReq(DataFactory.makeIPCRequestPacket("setHasSetPwd", "", this.mOnRemoteResp.key, new Bundle()), true, false);
  }
  
  private void showProgressDialog()
  {
    this.mRuntime.a().runOnUiThread(new SetPwdJsPlugin.2(this));
  }
  
  protected long getPluginBusiness()
  {
    return 2147516416L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("SetPwdJsInterface".equalsIgnoreCase(paramString2)) {
      return call(paramString3, Arrays.asList(paramVarArgs));
    }
    return false;
  }
  
  public void isNotNet()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.login.SetPwdJsPlugin", 2, "SetPwdJsPlugin isNotNet ");
    }
    new Handler(this.activity.getMainLooper()).post(new SetPwdJsPlugin.1(this));
  }
  
  public void onBindedToClient()
  {
    if (this.activity == null) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = this.activity.getIntent();
    } while ((localIntent.getLongExtra("business", 0L) & 0x8000) == 0L);
    getA2(localIntent.getStringExtra("uin"));
    hideProgressDialog();
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() instanceof QQBrowserActivity)) {
      this.activity = ((QQBrowserActivity)this.mRuntime.a());
    }
    if ((this.activity != null) && ((this.activity.getIntent().getLongExtra("business", 0L) & 0x8000) != 0L)) {
      ((TextView)this.activity.findViewById(2131296901)).setBackgroundDrawable(this.activity.getResources().getDrawable(2130839292));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    hideProgressDialog();
  }
  
  public void onLoadIsSetPsw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.login.SetPwdJsPlugin", 2, "SetPwdJsPlugin onLoadIsSetPsw isSet =" + paramString);
    }
    if ((paramString != null) && (paramString.equals("1"))) {
      setHasSetPwd();
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    String str1;
    if (paramBundle != null)
    {
      str1 = paramBundle.getString("cmd");
      if (!TextUtils.isEmpty(str1)) {
        break label33;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.login.SetPwdJsPlugin", 2, "cmd is empty.");
      }
    }
    label33:
    String str2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramBundle = paramBundle.getBundle("response");
            if (QLog.isColorLevel()) {
              QLog.i("Q.login.SetPwdJsPlugin", 2, "response:" + str1);
            }
          } while (!str1.equalsIgnoreCase("getA2"));
          paramBundle = paramBundle.getString("A2");
          if (!TextUtils.isEmpty(paramBundle)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.login.SetPwdJsPlugin", 2, "a2 is empty.");
        return;
        str1 = this.activity.getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.login.SetPwdJsPlugin", 2, "url is empty.");
      return;
      str2 = Util.c(str1);
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.login.SetPwdJsPlugin", 2, "domain is empty.");
    return;
    CookieSyncManager.createInstance(this.mRuntime.a().getContext());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    localCookieManager.setCookie(str1, String.format("A2=%1$s; domain=%2$s; path=/", new Object[] { paramBundle, str2 }));
    CookieSyncManager.getInstance().sync();
  }
  
  public void onTimeOut()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.login.SetPwdJsPlugin", 2, "SetPwdJsPlugin onTimeOut");
    }
    hideProgressDialog();
  }
  
  public void onWebMakeSureBack()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.login.SetPwdJsPlugin", 2, "SetPwdJsPlugin onWebMakeSureBack");
    }
    showProgressDialog();
  }
  
  public void onWebMakeSureFinishBack(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.login.SetPwdJsPlugin", 2, "SetPwdJsPlugin onWebMakeSureFinishBack isSuccess =" + paramString);
    }
    if ((paramString != null) && (paramString.equals("1"))) {
      setHasSetPwd();
    }
    hideProgressDialog();
  }
  
  public void pushMobileReturn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.login.SetPwdJsPlugin", 2, "SetPwdJsPlugin pushMobileReturn");
    }
    this.activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SetPwdJsPlugin
 * JD-Core Version:    0.7.0.1
 */