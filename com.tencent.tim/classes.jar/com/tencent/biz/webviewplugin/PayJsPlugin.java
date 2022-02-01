package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import anot;
import aqzd;
import avfw;
import avfw.d;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.net.URL;
import java.net.URLEncoder;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class PayJsPlugin
  extends aqzd
{
  protected Bundle R;
  protected MyResultRecevicer a;
  private final String aGL = "pay";
  private final String aGM = "openTenpayView";
  private final String aGN = "openService";
  private final String aGO = "buyGoods";
  private final String aGP = "rechargeGameCurrency";
  private final String aGQ = "rechargeQb";
  private final String aGR = "preparePay";
  private final String aGS = "subscribeMonthCardPay";
  private final String aGT = "getQBRecord";
  private final String aGU = "closeFullWindow";
  private final String aGV = "launchWechatPaySign";
  Activity activity;
  AppInterface app;
  private boolean isLoading;
  protected long mReceiveRequestTime;
  public long mReportSeq;
  
  private void tP(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("url");
      Intent localIntent = new Intent("cn.abel.action.broadcast");
      if (!TextUtils.isEmpty(paramString))
      {
        bool = true;
        localIntent.putExtra("isOpen", bool);
        BaseApplicationImpl.sApplication.sendBroadcast(localIntent);
        if (!TextUtils.isEmpty(paramString))
        {
          localIntent = new Intent(this.activity, QQBrowserActivity.class);
          localIntent.putExtra("url", paramString);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          this.activity.startActivity(localIntent);
          if (QWalletHelper.sFullWindowActivitySource == 1) {
            anot.a(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "index.layila.intopage", 0, 0, "", "", "", "");
          }
          if (QWalletHelper.sFullWndCurType != QWalletHelper.FULL_WND_TYPE_NORMAL) {
            break label183;
          }
          VACDReportUtil.a(QWalletHelper.sFullWndCurID + "", "qqwallet", "screenReport", null, null, 0, null);
        }
      }
    }
    catch (Exception paramString)
    {
      label183:
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
          continue;
          boolean bool = false;
        }
      } while (QWalletHelper.sFullWndCurType != QWalletHelper.FULL_WND_TYPE_PULL);
      VACDReportUtil.a(QWalletHelper.sFullWndCurID + "", "qqwallet", "pullReport", null, null, 0, null);
    }
  }
  
  private void tQ(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 16);
    String str = this.app.getCurrentAccountUin();
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = "")
    {
      localBundle.putString("uin", str);
      localBundle.putString("skey", (String)localObject);
      localBundle.putString("reqData", paramString);
      if (this.a != null)
      {
        paramString = Parcel.obtain();
        this.a.writeToParcel(paramString, 0);
        paramString.setDataPosition(0);
        localObject = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString);
        paramString.recycle();
        localBundle.putParcelable("_qwallet_payresult_receiver", (Parcelable)localObject);
      }
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, this.app, localBundle);
      return;
    }
  }
  
  protected void a(int paramInt, String paramString, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject2 = this.mRuntime.getWebView();
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = ((CustomWebView)localObject2).getUrl();
    }
    localObject2 = localObject1;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = URLEncoder.encode((String)localObject1, "utf-8");
      }
      paramJsBridgeListener = String.valueOf(paramJsBridgeListener.hX());
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("payparmas_callback_sn", paramJsBridgeListener);
      ((Bundle)localObject1).putString("payparmas_json", paramString);
      ((Bundle)localObject1).putInt("payparmas_paytype", 1);
      ((Bundle)localObject1).putLong("payparmas_h5_start", this.mReceiveRequestTime);
      ((Bundle)localObject1).putLong("vacreport_key_seq", this.mReportSeq);
      ((Bundle)localObject1).putString("payparmas_h5_url", (String)localObject2);
      this.R = PayBridgeActivity.newPay(this.app, this.activity, this.a, paramInt, (Bundle)localObject1);
      if (this.R.getInt("retCode", -1) != 0)
      {
        paramString = this.R.getString("retJson");
        if (paramString != null) {
          callJs(paramJsBridgeListener, new String[] { paramString });
        }
        VACDReportUtil.endReport(this.mReportSeq, "parseurl", null, 668801, paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject2 = localObject1;
        }
      }
    }
  }
  
  protected void a(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "openTenpayView requet params json=" + paramString);
    }
    CustomWebView localCustomWebView = this.mRuntime.getWebView();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localCustomWebView != null) {}
    try
    {
      localObject1 = new URL(localCustomWebView.getUrl()).getHost();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("json", paramString);
      ((Bundle)localObject2).putString("callbackSn", String.valueOf(paramJsBridgeListener.hX()));
      ((Bundle)localObject2).putInt("payparmas_paytype", 1);
      ((Bundle)localObject2).putLong("payparmas_h5_start", this.mReceiveRequestTime);
      ((Bundle)localObject2).putString("h5_common_redpacket_domain", (String)localObject1);
      PayBridgeActivity.a(this.activity, 5, (Bundle)localObject2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject1 = localObject2;
        }
      }
    }
  }
  
  protected void b(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet params json=" + paramString);
    }
    Object localObject2;
    Object localObject1;
    if (!this.isLoading)
    {
      this.isLoading = true;
      localObject2 = this.mRuntime.getWebView();
      localObject1 = "";
      if (localObject2 != null) {
        localObject1 = ((CustomWebView)localObject2).getUrl();
      }
      localObject2 = localObject1;
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = URLEncoder.encode((String)localObject1, "utf-8");
      }
      localObject1 = QWalletHelper.getAppInfoFromHistory();
      String str = String.valueOf(paramJsBridgeListener.hX());
      try
      {
        paramJsBridgeListener = new Bundle();
        paramJsBridgeListener.putString("json", paramString);
        paramJsBridgeListener.putString("callbackSn", str);
        paramJsBridgeListener.putLong("vacreport_key_seq", this.mReportSeq);
        paramJsBridgeListener.putString("payparmas_h5_url", (String)localObject2);
        paramJsBridgeListener.putString("payparmas_url_appinfo", (String)localObject1);
        paramJsBridgeListener.putString("payparmas_callback_sn", str);
        paramJsBridgeListener.putInt("payparmas_paytype", 1);
        if (this.a != null)
        {
          paramString = Parcel.obtain();
          this.a.writeToParcel(paramString, 0);
          paramString.setDataPosition(0);
          localObject1 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString);
          paramString.recycle();
          paramJsBridgeListener.putParcelable("_qwallet_payresult_receiver", (Parcelable)localObject1);
        }
        PayBridgeActivity.a(this.activity, 9, paramJsBridgeListener);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      this.isLoading = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject2 = localObject1;
        }
      }
    }
  }
  
  protected void bAQ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet preparePay");
    }
    if ((this.mRuntime == null) || (this.mRuntime.getActivity() == null)) {}
    while (QWalletHelper.isQWalletProcessExist(this.mRuntime.getActivity())) {
      return;
    }
    Intent localIntent = new Intent("cooperation.qwallet.QWALLET_PRELOAD");
    QQAppInterface localQQAppInterface = QWalletHelper.getAppInterface();
    if (localQQAppInterface != null)
    {
      localObject = (TicketManager)localQQAppInterface.getManager(2);
      if (localObject == null) {
        break label157;
      }
    }
    label157:
    for (Object localObject = ((TicketManager)localObject).getSkey(localQQAppInterface.getCurrentAccountUin());; localObject = null)
    {
      localIntent.putExtra("uin", localQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("qqskey", (String)localObject);
      localObject = new avfw.d(0);
      ((avfw.d)localObject).mPluginID = "qwallet_plugin.apk";
      ((avfw.d)localObject).mPluginName = "Wallet";
      ((avfw.d)localObject).cKu = "com.qwallet.receiver.QWallPreloadReceiver";
      ((avfw.d)localObject).mIntent = localIntent;
      avfw.b(this.mRuntime.getActivity(), (avfw.d)localObject);
      return;
    }
  }
  
  protected void c(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet params json=" + paramString);
    }
    Object localObject;
    String str;
    if (!this.isLoading)
    {
      this.isLoading = true;
      localObject = this.mRuntime.getWebView();
      str = "";
      if (localObject != null) {
        str = ((CustomWebView)localObject).getUrl();
      }
      localObject = str;
    }
    try
    {
      if (!TextUtils.isEmpty(str)) {
        localObject = URLEncoder.encode(str, "utf-8");
      }
      str = QWalletHelper.getAppInfoFromHistory();
      paramJsBridgeListener = String.valueOf(paramJsBridgeListener.hX());
      Bundle localBundle = new Bundle();
      localBundle.putString("payparmas_callback_sn", paramJsBridgeListener);
      localBundle.putString("payparmas_json", paramString);
      localBundle.putInt("payparmas_paytype", 1);
      localBundle.putLong("payparmas_h5_start", this.mReceiveRequestTime);
      localBundle.putString("payparmas_url_appinfo", str);
      localBundle.putLong("vacreport_key_seq", this.mReportSeq);
      localBundle.putString("payparmas_h5_url", (String)localObject);
      this.R = PayBridgeActivity.newPay(this.app, this.activity, this.a, 9, localBundle);
      if (this.R.getInt("retCode", -1) != 0)
      {
        paramString = this.R.getString("retJson");
        if (paramString != null) {
          callJs(paramJsBridgeListener, new String[] { paramString });
        }
        VACDReportUtil.endReport(this.mReportSeq, "parseurl", null, 668801, paramString);
      }
      this.isLoading = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject = str;
        }
      }
    }
  }
  
  protected void cU(String paramString1, String paramString2)
  {
    super.callJs("javascript:window.JsBridge&&JsBridge.callback('" + paramString1 + "',{'r':0,'result':" + paramString2 + "});");
  }
  
  protected String gN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if ("pay".equals(paramString)) {
        return "pay-h5";
      }
      if ("openService".equals(paramString)) {
        return "openService";
      }
      if ("buyGoods".equals(paramString)) {
        return "buyGoods";
      }
      if ("rechargeGameCurrency".equals(paramString)) {
        return "rechargeGameCurrency";
      }
      if ("rechargeQb".equals(paramString)) {
        return "rechargeQb";
      }
      if ("subscribeMonthCardPay".equals(paramString)) {
        return "monthCardPay";
      }
    } while (!"launchWechatPaySign".equals(paramString));
    return "wechatPaySign";
  }
  
  public String getNameSpace()
  {
    return "pay";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!getNameSpace().equals(paramString2)) {
      return false;
    }
    paramString1 = gN(paramString3);
    if (paramString1 != null) {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", paramString1, "payinvoke", null, 0, null);
    }
    paramString2 = "";
    paramString1 = paramString2;
    if (paramVarArgs != null)
    {
      paramString1 = paramString2;
      if (paramVarArgs.length > 0)
      {
        paramString1 = paramString2;
        if (!TextUtils.isEmpty(paramVarArgs[0])) {
          paramString1 = paramVarArgs[0];
        }
      }
    }
    this.mReceiveRequestTime = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + this.mReceiveRequestTime + " PayJsPlugin.handleJsRequest params:" + paramString1);
    }
    if ((paramString1 != null) && ("pay".equals(paramString3))) {
      if ((this.app != null) && (!this.app.isLogin())) {
        b(paramString1, paramJsBridgeListener);
      }
    }
    for (;;)
    {
      return true;
      c(paramString1, paramJsBridgeListener);
      continue;
      if ((paramString1 != null) && ("openTenpayView".equals(paramString3)))
      {
        a(paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("openService".equals(paramString3)))
      {
        a(4, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("buyGoods".equals(paramString3)))
      {
        a(7, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("rechargeGameCurrency".equals(paramString3)))
      {
        a(6, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("rechargeQb".equals(paramString3)))
      {
        a(8, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("subscribeMonthCardPay".equals(paramString3)))
      {
        a(14, paramString1, paramJsBridgeListener);
      }
      else if ((paramString1 != null) && ("launchWechatPaySign".equals(paramString3)))
      {
        a(17, paramString1, paramJsBridgeListener);
      }
      else if ("preparePay".equals(paramString3))
      {
        bAQ();
      }
      else if ((paramString1 != null) && ("getQBRecord".equals(paramString3)))
      {
        tQ(paramString1);
      }
      else
      {
        if (!"closeFullWindow".equals(paramString3)) {
          break;
        }
        tP(paramString1);
      }
    }
  }
  
  public void onCreate()
  {
    this.activity = this.mRuntime.getActivity();
    this.app = this.mRuntime.a();
    this.a = new MyResultRecevicer(this, new Handler());
  }
  
  public static class MyResultRecevicer
    extends ResultReceiver
  {
    protected PayJsPlugin a;
    
    public MyResultRecevicer(PayJsPlugin paramPayJsPlugin, Handler paramHandler)
    {
      super();
      this.a = paramPayJsPlugin;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      if (QLog.isColorLevel())
      {
        QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "MyResultRecevicer receive = " + this);
        QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
      }
      if ((this.a == null) || (paramBundle == null)) {}
      String str1;
      do
      {
        String str2;
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "js callback...");
            }
            switch (paramInt)
            {
            case 5: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 15: 
            default: 
              return;
            case 4: 
            case 6: 
            case 7: 
            case 8: 
            case 14: 
            case 17: 
              str1 = paramBundle.getString("callbackSn");
              paramBundle = paramBundle.getString("result");
            }
          } while ((this.a.mRuntime == null) || (this.a.mRuntime.getWebView() == null) || (str1 == null) || (paramBundle == null));
          this.a.mRuntime.getWebView().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + str1 + "',{'r':0,'result':" + paramBundle + "});");
          return;
          str1 = paramBundle.getString("callbackSn");
          str2 = paramBundle.getString("result");
          paramBundle.getBoolean("isChoosePubAcc", false);
          paramBundle.getString("pubAcc");
        } while ((this.a.mRuntime == null) || (this.a.mRuntime.getWebView() == null) || (str1 == null) || (str2 == null));
        this.a.mRuntime.getWebView().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + str1 + "',{'r':0,'result':" + str2 + "});");
        return;
        str1 = paramBundle.getString("callback");
        paramBundle = paramBundle.getString("retData");
      } while ((this.a.mRuntime == null) || (this.a.mRuntime.getWebView() == null) || (str1 == null) || (paramBundle == null));
      this.a.cU(str1, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */