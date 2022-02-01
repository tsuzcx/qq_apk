package com.tencent.mobileqq.mini.out.nativePlugins;

import aafv;
import acfp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import aqmr;
import avoy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayPlugin
  implements NativePlugin
{
  public static final String PLUGIN_NAME = "openTenpayView";
  public static final String PLUGIN_NAME_QWALLETBRIDGE = "qWalletBridge";
  public static final String TAG = "TenpayPlugin";
  private AppInterface app;
  private NativePlugin.JSContext jsContext;
  private QWalletPayJsPluginResultReceiver mRecevicer;
  private TenpayRecevicer payRecevicer;
  
  private static JSONObject filterUinByNickName(JSONObject paramJSONObject)
    throws Exception
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject != null)
    {
      localJSONObject = paramJSONObject.optJSONObject("send_object");
      String str = localJSONObject.optString("lucky_uin");
      localJSONObject.remove("lucky_uin");
      if (!aqmr.isEmpty(str)) {
        localJSONObject.put("lucky_name", aafv.ie(str));
      }
      paramJSONObject.remove("send_object");
      paramJSONObject.put("send_object", localJSONObject);
      return paramJSONObject;
    }
    return localJSONObject;
  }
  
  private void getHbDetail(AppInterface paramAppInterface, String paramString, QWalletPayJsPluginResultReceiver paramQWalletPayJsPluginResultReceiver)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("extra_data", paramString);
      localBundle.putString("callbackSn", "0");
      paramString = new Bundle();
      paramString.putInt("PayInvokerId", 22);
      Parcel localParcel = Parcel.obtain();
      paramQWalletPayJsPluginResultReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      paramQWalletPayJsPluginResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramString.putParcelable("_qwallet_payresult_receiver", paramQWalletPayJsPluginResultReceiver);
      paramString.putBundle("_qwallet_payparams_data", localBundle);
      paramString.putString("_qwallet_payparams_tag", "redgiftH5CommonDetail");
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, paramAppInterface, paramString);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  private void getHbDetailInfo(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    String str1 = paramJSONObject.optString("listid");
    String str2 = paramJSONObject.optString("uin");
    String str3 = paramJSONObject.optString("offset");
    String str4 = paramJSONObject.optString("limit");
    if ((!TextUtils.isEmpty(str2)) && (str2.equals(this.app.getCurrentAccountUin())) && (!TextUtils.isEmpty(str1)))
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("listid", str1);
      paramJSONObject.put("uin", str2);
      paramJSONObject.put("offset", str3);
      paramJSONObject.put("limit", str4);
      paramJSONObject.put("viewTag", paramString);
      getHbDetail(this.app, paramJSONObject.toString(), this.mRecevicer);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TenpayPlugin", 2, "notifyViewUpdate extstr = " + paramJSONObject);
    }
    handJsError("-1001", "params error");
  }
  
  private void getHbResult(JSONObject paramJSONObject)
    throws Exception
  {
    String str1 = paramJSONObject.optString("listid");
    String str2 = paramJSONObject.optString("uin");
    if ((!aqmr.isEmpty(str2)) && (str2.equals(this.app.getCurrentAccountUin())) && (!aqmr.isEmpty(str1)))
    {
      Object localObject = avoy.a().rM(str1);
      paramJSONObject = (JSONObject)localObject;
      if (aqmr.isEmpty((String)localObject)) {
        paramJSONObject = SharedPreferencesProxyManager.getInstance().getProxy("common_h5_hb_info" + str2, 0).getString(str1, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TenpayPlugin", 2, "getHbResult dataStr: " + paramJSONObject);
      }
      paramJSONObject = new JSONObject(paramJSONObject);
      if (paramJSONObject.has("detail_data"))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retcode", 0);
        ((JSONObject)localObject).put("retmsg", "ok");
        ((JSONObject)localObject).put("detail_data", paramJSONObject.optJSONObject("detail_data"));
        this.jsContext.evaluateCallback(true, (JSONObject)localObject, "");
        return;
      }
      if (paramJSONObject.has("exception_data"))
      {
        this.jsContext.evaluateCallback(true, paramJSONObject.optJSONObject("exception_data"), "");
        return;
      }
      handJsError("-1001", "params error, detail_data is empty");
      return;
    }
    handJsError("-1001", "params error,listid is empty or is not current user");
  }
  
  private String getPreCode(String paramString)
  {
    String str = "";
    if (paramString.contains("pre_code="))
    {
      str = paramString.substring(paramString.indexOf("pre_code="));
      paramString = str;
      if (str.contains("&")) {
        paramString = str.substring(0, str.indexOf("&"));
      }
      str = paramString;
      if (paramString.contains("=")) {
        str = paramString.split("=")[1];
      }
    }
    return str;
  }
  
  private void grapH5CommonHb(JSONObject paramJSONObject)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TenpayPlugin", 2, "grapH5CommonHb params: " + paramJSONObject);
      }
      String str1 = paramJSONObject.optString("listid");
      String str2 = paramJSONObject.optString("uin");
      if ((!aqmr.isEmpty(str2)) && (str2.equals(this.app.getCurrentAccountUin())) && (!aqmr.isEmpty(str1)))
      {
        String str3 = paramJSONObject.optString("feedsid");
        String str4 = paramJSONObject.optString("token");
        String str5 = str1 + "_" + getPreCode(str4);
        if (QLog.isColorLevel()) {
          QLog.i("TenpayPlugin", 2, "cache key: " + str5);
        }
        avoy localavoy = avoy.a();
        str1 = localavoy.rM(str5);
        paramJSONObject = str1;
        if (aqmr.isEmpty(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TenpayPlugin", 2, "get cache from disk");
          }
          paramJSONObject = localavoy.a(str2, str5, SharedPreferencesProxyManager.getInstance().getProxy("qb_tenpay_h5_common_hb_" + str2, 0));
        }
        if (QLog.isColorLevel()) {
          QLog.d("TenpayPlugin", 2, "paramForGarpH5CommonHb:" + paramJSONObject);
        }
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramJSONObject = new JSONObject(paramJSONObject);
          paramJSONObject.put("feedsid", str3);
          paramJSONObject.put("uin", str2);
          paramJSONObject.put("token", str4);
          paramJSONObject.put("viewTag", "grapH5CommonHb");
          getGrapH5CommonHbResult(this.app, paramJSONObject.toString(), this.mRecevicer);
          return;
        }
        handJsError("-1001", "params error");
        return;
      }
    }
    catch (Throwable paramJSONObject)
    {
      handJsError("-1001", paramJSONObject.getLocalizedMessage());
      return;
    }
    handJsError("-1001", "params error");
  }
  
  private void handJsError(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TenpayPlugin", 2, "handJsError: " + paramString2);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retcode", paramString1);
      localJSONObject.put("retmsg", paramString2);
      this.jsContext.evaluateCallback(false, localJSONObject, paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean qWalletBridge(String paramString)
  {
    JSONObject localJSONObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("TenpayPlugin", 2, "[qWalletBridge] paramStr: " + paramString);
      }
      localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.optString("action");
      localJSONObject = localJSONObject.optJSONObject("params");
      if ("graphb".equals(paramString)) {
        grapH5CommonHb(localJSONObject);
      } else if ("getHbResult".equals(paramString)) {
        getHbResult(localJSONObject);
      }
    }
    catch (Exception paramString)
    {
      handJsError("-1001", "params exception: " + paramString.getLocalizedMessage());
    }
    boolean bool = "refreshHbDetail".equals(paramString);
    if (bool) {
      try
      {
        getHbDetailInfo(localJSONObject, "redgiftH5CommonDetail");
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    } else {
      handJsError("-1001", "params exception: no match action");
    }
    return true;
  }
  
  public void getGrapH5CommonHbResult(AppInterface paramAppInterface, String paramString, QWalletPayJsPluginResultReceiver paramQWalletPayJsPluginResultReceiver)
    throws Throwable
  {
    if (paramAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_data", paramString);
    localBundle.putString("callbackSn", "0");
    paramString = new Bundle();
    paramString.putInt("PayInvokerId", 22);
    Parcel localParcel = Parcel.obtain();
    paramQWalletPayJsPluginResultReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramQWalletPayJsPluginResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    paramString.putParcelable("_qwallet_payresult_receiver", paramQWalletPayJsPluginResultReceiver);
    paramString.putBundle("_qwallet_payparams_data", localBundle);
    paramString.putString("_qwallet_payparams_tag", "grapH5CommonHb");
    QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, paramAppInterface, paramString);
  }
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    this.jsContext = paramJSContext;
    if (this.jsContext != null) {
      try
      {
        this.app = ((BaseActivity)this.jsContext.getActivity()).getAppInterface();
        if (QLog.isColorLevel()) {
          QLog.w("TenpayPlugin", 2, paramJSONObject.toString());
        }
        paramJSContext = paramJSONObject.optString("api_name");
        if (paramJSContext.equals("openTenpayView"))
        {
          this.payRecevicer = new TenpayRecevicer(new Handler(Looper.getMainLooper()));
          QLog.e("TenpayPlugin", 1, "param: " + paramJSONObject.toString());
          paramJSContext = new Bundle();
          paramJSContext.putString("json", paramJSONObject.getString("data"));
          paramJSContext.putString("callbackSn", "0");
          paramJSContext.putInt("payparmas_paytype", 1);
          if (!PayBridgeActivity.a(this.jsContext.getActivity(), 5, paramJSContext, this.payRecevicer)) {
            this.jsContext.evaluateCallback(false, null, acfp.m(2131715241));
          }
        }
        else if (paramJSContext.equals("qWalletBridge"))
        {
          this.mRecevicer = new QWalletPayJsPluginResultReceiver(this.jsContext, new Handler(Looper.getMainLooper()), this.app);
          qWalletBridge(paramJSONObject.optString("data"));
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        this.jsContext.evaluateCallback(false, null, acfp.m(2131715240));
      }
    }
  }
  
  public static class QWalletPayJsPluginResultReceiver
    extends ResultReceiver
  {
    private AppInterface mApp;
    protected NativePlugin.JSContext mJsPlugin;
    
    public QWalletPayJsPluginResultReceiver(NativePlugin.JSContext paramJSContext, Handler paramHandler, AppInterface paramAppInterface)
    {
      super();
      this.mJsPlugin = paramJSContext;
      this.mApp = paramAppInterface;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("TenpayPlugin", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
      }
      if ((this.mJsPlugin == null) || (paramBundle == null)) {
        return;
      }
      if (paramInt == 0) {
        try
        {
          localObject = paramBundle.getString("grapH5CommonHbResult");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramBundle = new JSONObject((String)localObject);
            localObject = TenpayPlugin.filterUinByNickName(paramBundle.optJSONObject("detail"));
            paramBundle.remove("detail");
            paramBundle.put("detail_data", localObject);
          }
          for (;;)
          {
            this.mJsPlugin.evaluateCallback(true, paramBundle, "");
            return;
            localObject = new JSONObject();
            paramBundle = paramBundle.getString("detail");
            if (!TextUtils.isEmpty(paramBundle))
            {
              paramBundle = TenpayPlugin.filterUinByNickName(new JSONObject(paramBundle));
              paramBundle.remove("retcode");
              paramBundle.remove("retmsg");
              ((JSONObject)localObject).put("detail_data", paramBundle);
            }
            ((JSONObject)localObject).put("retcode", 0);
            ((JSONObject)localObject).put("retmsg", "ok");
            paramBundle = (Bundle)localObject;
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            paramBundle.printStackTrace();
            paramBundle = null;
          }
        }
      }
      Object localObject = new JSONObject();
      for (;;)
      {
        try
        {
          paramBundle = paramBundle.getString("retmsg");
          if (TextUtils.isEmpty(paramBundle)) {
            break label277;
          }
          ((JSONObject)localObject).put("retmsg", new JSONObject(paramBundle).optString("err_msg"));
          ((JSONObject)localObject).put("retcode", paramInt);
          paramBundle = (Bundle)localObject;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          paramBundle = (Bundle)localObject;
        }
        break;
        label277:
        ((JSONObject)localObject).put("retmsg", "error when grap hb");
      }
    }
  }
  
  final class TenpayRecevicer
    extends ResultReceiver
  {
    TenpayRecevicer(Handler paramHandler)
    {
      super();
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      QLog.d("TenpayPlugin", 2, "onReceiveResult resultCode = " + paramInt + " resultData = " + paramBundle);
      if (paramInt != 0)
      {
        TenpayPlugin.this.jsContext.evaluateCallback(false, null, "error unkown!");
        return;
      }
      paramBundle = paramBundle.getString("result");
      for (;;)
      {
        try
        {
          QLog.d("TenpayPlugin", 2, "json: " + paramBundle);
          paramBundle = new JSONObject(paramBundle);
          paramInt = paramBundle.optInt("resultCode", -1);
          String str = paramBundle.optString("retmsg");
          NativePlugin.JSContext localJSContext = TenpayPlugin.this.jsContext;
          if (paramInt == 0)
          {
            bool = true;
            localJSContext.evaluateCallback(bool, paramBundle, str);
            return;
          }
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          TenpayPlugin.this.jsContext.evaluateCallback(false, null, "error unkown!");
          return;
        }
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin
 * JD-Core Version:    0.7.0.1
 */