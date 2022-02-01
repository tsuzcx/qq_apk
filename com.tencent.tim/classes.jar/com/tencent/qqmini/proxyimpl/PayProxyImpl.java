package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.mini.app.AppLoaderManager;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.PayResponse;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy=PayProxy.class)
public class PayProxyImpl
  extends PayProxy
{
  private String TAG = "PayProxyImpl";
  
  public Bundle midasPay(Activity paramActivity, String paramString, PayProxy.IPayResultCallBack paramIPayResultCallBack, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      QLog.d(this.TAG, 1, "goMidasPay error, params is null");
      paramActivity = new Bundle();
      paramActivity.putInt("retCode", -1);
      return paramActivity;
    }
    int i = paramBundle.getInt("payparmas_request_code", 0);
    if (i == 0)
    {
      QLog.d(this.TAG, 1, "goMidasPay error, requestSource is empty");
      paramActivity = new Bundle();
      paramActivity.putInt("retCode", -1);
      return paramActivity;
    }
    QLog.d(this.TAG, 1, "goMidasPay requestSource = " + i);
    return PayBridgeActivity.newPay(AppLoaderManager.sMiniAppInterface, paramActivity, new PayProxyImpl.1(this, new Handler(Looper.getMainLooper()), paramIPayResultCallBack), i, paramBundle);
  }
  
  class PayResultRecevicer
    extends ResultReceiver
  {
    PayProxy.IPayResultCallBack jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyPayProxy$IPayResultCallBack;
    
    public PayResultRecevicer(Handler paramHandler, PayProxy.IPayResultCallBack paramIPayResultCallBack)
    {
      super();
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyPayProxy$IPayResultCallBack = paramIPayResultCallBack;
    }
    
    private void handlePayResult(int paramInt, Bundle paramBundle, String paramString)
    {
      localPayResponse = new PayProxy.PayResponse(PayProxyImpl.this);
      paramString = paramBundle.getString("result");
      String str = paramBundle.getString("callbackSn");
      j = -1;
      int i = j;
      if ((TextUtils.isEmpty(str)) || (JSONUtil.isJson(str))) {}
      for (;;)
      {
        try
        {
          i = new JSONObject(str).optInt("seq", -1);
          QLog.d(PayProxyImpl.a(PayProxyImpl.this), 2, "onReceiveResult seq = " + i + " callbackSn=" + str + " result = " + paramString);
          JSONObject localJSONObject1 = new JSONObject();
          try
          {
            JSONObject localJSONObject2 = new JSONObject(paramString);
            j = -1;
            paramString = "";
            paramBundle = null;
            if (localJSONObject2 != null)
            {
              j = localJSONObject2.optInt("resultCode", -1);
              paramString = localJSONObject2.optString("resultMsg", "");
              paramBundle = localJSONObject2.optJSONObject("data");
            }
            QLog.d(PayProxyImpl.a(PayProxyImpl.this), 1, "onReceiveResult seq = " + i + " callbackSn=" + str + " ret = " + j);
            localJSONObject1.put("resultCode", j);
            localPayResponse.setResultMsg(paramString);
            if (j != 0) {
              break label381;
            }
            localPayResponse.setResultCode(0);
            localPayResponse.setPayState(0);
            if ((paramInt == 9) && (paramBundle != null)) {
              localJSONObject1.put("data", paramBundle);
            }
            localPayResponse.setExtendInfo(localJSONObject1.toString());
            localPayResponse.setPayChannel(localJSONObject2.optInt("payChannel", -1));
          }
          catch (Throwable paramBundle)
          {
            for (;;)
            {
              QLog.e(PayProxyImpl.a(PayProxyImpl.this), 1, paramBundle, new Object[0]);
              localPayResponse.setResultCode(-1);
              localPayResponse.setPayState(2);
              continue;
              localPayResponse.setResultCode(j);
              localPayResponse.setPayState(2);
            }
          }
          if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyPayProxy$IPayResultCallBack != null) {
            this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyPayProxy$IPayResultCallBack.onPayCallBack(localPayResponse);
          }
          return;
        }
        catch (JSONException paramBundle)
        {
          QLog.e(PayProxyImpl.a(PayProxyImpl.this), 1, paramBundle, new Object[0]);
          i = j;
          continue;
        }
        try
        {
          i = Integer.parseInt(str);
        }
        catch (NumberFormatException paramBundle)
        {
          QLog.e(PayProxyImpl.a(PayProxyImpl.this), 1, paramBundle, new Object[0]);
          i = j;
        }
        continue;
        label381:
        if (j != -1) {
          break;
        }
        localPayResponse.setResultCode(-1);
        localPayResponse.setPayState(2);
        localPayResponse.setResultMsg(paramString);
      }
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      QLog.d(PayProxyImpl.a(PayProxyImpl.this), 2, "onReceiveResult resultCode = " + paramInt + " resultData = " + paramBundle);
      switch (paramInt)
      {
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        return;
      case 6: 
        handlePayResult(paramInt, paramBundle, "requestMidasPayment");
        return;
      case 9: 
        handlePayResult(paramInt, paramBundle, "requestPayment");
        return;
      case 7: 
        handlePayResult(paramInt, paramBundle, "requestMidasGoodsPay");
        return;
      }
      handlePayResult(paramInt, paramBundle, "requestMidasMonthCardPay");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PayProxyImpl
 * JD-Core Version:    0.7.0.1
 */