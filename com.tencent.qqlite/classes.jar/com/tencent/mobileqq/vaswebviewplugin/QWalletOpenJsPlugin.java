package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class QWalletOpenJsPlugin
  extends VasWebviewJsPlugin
{
  private static final byte REQUET_CODE_OPEN_PAY_PAY = 50;
  private static final String TAG = "QWalletOpenJsPlugin";
  private final String API_OPENID = "open_userinfo_getOpenId";
  private final String API_PAY = "open_pay_pay";
  private final String API_TOKEN = "open_runtime_getOpenToken";
  private boolean mIsUsed = false;
  private int mOpenIdCallbackSn;
  private int mPayCallbackSn;
  private int mTokenCallbackSn;
  
  private String comboApiName(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  private boolean doGetOpenId(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (!WebIPCOperator.getInstance().isServiceClientBinded()) {
      doGetOpenIdCallback(-1, "ipc error", null, null);
    }
    for (;;)
    {
      return true;
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "qwalletOpenOpenid");
      localBundle.putString("appId", paramString1);
      localBundle.putString("nonce", paramString2);
      localBundle.putLong("timeStamp", paramLong);
      localBundle.putString("sig", paramString3);
      localBundle.putString("sigType", paramString4);
      WebIPCOperator.getInstance().sendServiceIpcReqWithoutTimeout(localBundle);
    }
  }
  
  private void doGetOpenIdCallback(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("{ \"retCode\":" + paramInt + ", \"retMsg\":\"" + paramString1 + "\"");
    if (paramInt == 0) {
      localStringBuilder.append(", \"openId\":\"" + paramString2 + "\"," + " \"openKey\":\"" + paramString3 + "\"");
    }
    localStringBuilder.append(" }");
    onCallback(this.mOpenIdCallbackSn, localStringBuilder.toString());
  }
  
  private boolean doGetToken(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (!WebIPCOperator.getInstance().isServiceClientBinded()) {
      doGetTokenCallback(-1, "ipc error", "");
    }
    for (;;)
    {
      return true;
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "qwalletOpenToken");
      localBundle.putString("appId", paramString1);
      localBundle.putString("nonce", paramString2);
      localBundle.putLong("timeStamp", paramLong);
      localBundle.putString("sig", paramString3);
      localBundle.putString("sigType", paramString4);
      localBundle.putString("domain", getDomain());
      WebIPCOperator.getInstance().sendServiceIpcReqWithoutTimeout(localBundle);
    }
  }
  
  private void doGetTokenCallback(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = "{ \"retCode\":" + paramInt + ", \"retMsg\":\"" + paramString1 + "\" , \"openToken\":\"" + paramString2 + "\" }";
    if (QLog.isDevelopLevel()) {
      QLog.i("QWalletOpenJsPlugin", 4, paramString1);
    }
    onCallback(this.mTokenCallbackSn, paramString1);
  }
  
  private void doPayCallback(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("{ \"retCode\":" + paramInt2 + ", \"retMsg\":\"" + paramString + "\"");
    if ((paramInt2 == 0) && (paramBundle != null))
    {
      paramString = paramBundle.getString("payChannelType");
      localStringBuilder.append(", \"payChannelType\":\"" + paramString + "\",");
      localStringBuilder.append(" \"transactionId\":\"" + paramBundle.getString("transactionId") + "\",");
      localStringBuilder.append(" \"payTime\":\"" + paramBundle.getString("payTime") + "\",");
      localStringBuilder.append(" \"totalFee\":\"" + paramBundle.getString("totalFee") + "\",");
      localStringBuilder.append(" \"callbackUrl\":\"" + paramBundle.getString("callbackUrl") + "\",");
      localStringBuilder.append(" \"spData\":\"" + paramBundle.getString("spData") + "\"");
    }
    localStringBuilder.append(" }");
    if (QLog.isDevelopLevel()) {
      QLog.i("QWalletOpenJsPlugin", 4, localStringBuilder.toString());
    }
    onCallback(paramInt1, localStringBuilder.toString());
  }
  
  private String generateOpenToken()
  {
    String str = String.valueOf(new Random(System.currentTimeMillis()).nextInt());
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(str.getBytes());
      localObject = SecUtil.a(((MessageDigest)localObject).digest());
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return str;
  }
  
  private String getDomain()
  {
    try
    {
      String str = Uri.parse(this.mRuntime.a().getUrl()).getHost();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private void onCallback(int paramInt, String paramString)
  {
    paramString = "'" + paramString.toString().replace("\\", "\\\\").replace("'", "\\'") + "'";
    callJs("window.JsBridge&&JsBridge.callback(" + paramInt + ",{'r':0,'result':" + paramString + "});");
  }
  
  protected long getPluginBusiness()
  {
    return 0L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs.length <= 0)) {}
    do
    {
      return false;
      paramJsBridgeListener = comboApiName(paramString2, paramString3);
      if (("open_runtime_getOpenToken".equals(paramJsBridgeListener)) || ("open_pay_pay".equals(paramJsBridgeListener)) || ("open_userinfo_getOpenId".equals(paramJsBridgeListener))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QWalletOpenJsPlugin", 2, "can not handle method:" + paramString3);
    return false;
    QQToast.a(this.mRuntime.a().getApplicationContext(), 2131364486, 0).a();
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (!this.mIsUsed) {}
    do
    {
      return;
      switch (paramByte)
      {
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("QWalletOpenJsPlugin", 4, "onActivityResult " + paramByte);
    return;
    if (paramIntent == null)
    {
      doPayCallback(this.mPayCallbackSn, -1, "", null);
      return;
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      doPayCallback(this.mPayCallbackSn, -1, "", null);
      return;
    }
    int i = paramIntent.getInt("retCode");
    String str1 = paramIntent.getString("retMsg");
    String str2 = paramIntent.getString("callbackSn");
    if (!TextUtils.isEmpty(str2)) {}
    for (paramByte = Integer.valueOf(str2).intValue();; paramByte = -1)
    {
      paramInt = paramByte;
      if (paramByte == -1) {
        paramInt = this.mPayCallbackSn;
      }
      doPayCallback(paramInt, i, str1, paramIntent);
      return;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    WebIPCOperator.getInstance().unRegisterObserver(this.mOnRemoteResp);
    this.mIsUsed = false;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletOpenJsPlugin
 * JD-Core Version:    0.7.0.1
 */