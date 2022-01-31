package com.tencent.biz.webviewplugin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import box;
import boy;
import boz;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.Pair;
import java.util.HashMap;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class SSOWebviewPlugin
  extends WebViewPlugin
{
  public static final String a = "SSOWebviewPlugin";
  public static final boolean a = false;
  public static final long b = 1000L;
  public static final String b = "sso";
  public static final int c = 0;
  public static final long c = 10240L;
  public static final String c = "ssoRet";
  public static final int d = 101;
  public static final String d = "businessRet";
  public static final int e = 102;
  public static final String e = "msg";
  public static final int f = 103;
  public static final String f = "data";
  public static final int g = 201;
  public static final int h = 202;
  public static final int i = 255;
  static final int j = 10;
  public int a;
  long jdField_a_of_type_Long = 0L;
  protected Activity a;
  private Client.onRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new box(this);
  private CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  public HashMap a;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  public int b;
  public HashMap b;
  public HashMap c = new HashMap();
  HashMap d = new HashMap();
  public HashMap e = new HashMap();
  
  public SSOWebviewPlugin()
  {
    this.jdField_a_of_type_Int = 5;
    this.jdField_b_of_type_Int = 204800;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.mPluginNameSpace = "sso";
  }
  
  private void a(String paramString, int paramInt) {}
  
  private void a(String paramString, long paramLong, int paramInt) {}
  
  private void b(String paramString, int paramInt) {}
  
  @SuppressLint({"NewApi"})
  private void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    while (this.mRuntime == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SSOWebviewPlugin", 2, "uniAgent, jsonStr=" + paramString1 + ", url=" + paramString2);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        paramString2 = localJSONObject.getString("cmd");
        paramString1 = localJSONObject.getString("callback");
        if (localJSONObject.has("timeout"))
        {
          l1 = localJSONObject.getLong("timeout");
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, cmd=" + paramString2 + ", callbackId=" + paramString1 + ",timeout = " + l1);
          }
          if (TextUtils.isEmpty(paramString1))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no callbackId");
            return;
          }
          if (TextUtils.isEmpty(paramString2))
          {
            paramString2 = new JSONObject();
            paramString2.put("ssoRet", 255);
            paramString2.put("businessRet", 0);
            paramString2.put("msg", "缺少命令字参数");
            super.callJs(paramString1, new String[] { paramString2.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no cmd");
            return;
          }
          if (!NetworkUtil.f(this.jdField_a_of_type_AndroidAppActivity))
          {
            paramString2 = new JSONObject();
            paramString2.put("ssoRet", 103);
            paramString2.put("businessRet", 0);
            paramString2.put("msg", "MSF未连接");
            super.callJs(paramString1, new String[] { paramString2.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: network unavailable");
            return;
          }
          long l2 = 10240L;
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString2)) {
            l2 = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString2)).longValue();
          }
          if (l2 > 0L)
          {
            long l3 = localJSONObject.toString().getBytes().length;
            if (l3 > l2)
            {
              paramString2 = new JSONObject();
              paramString2.put("ssoRet", 101);
              paramString2.put("businessRet", 0);
              paramString2.put("msg", "请求数据过大");
              super.callJs(paramString1, new String[] { paramString2.toString() });
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: pkg size exceeded, dataLength=" + l3 + ", maxPkgSize=" + l2);
              return;
            }
          }
          l2 = System.currentTimeMillis() / 1000L;
          if (this.d.containsKey(paramString2))
          {
            Object localObject1 = (Pair)this.d.get(paramString2);
            if (!this.e.containsKey(paramString2)) {
              break label1345;
            }
            k = ((Integer)this.e.get(paramString2)).intValue();
            if (((Long)((Pair)localObject1).first).longValue() != l2)
            {
              this.d.put(paramString2, new Pair(Long.valueOf(l2), Integer.valueOf(0)));
              if (localJSONObject.has("needCookie"))
              {
                k = localJSONObject.getInt("needCookie");
                if (QLog.isColorLevel()) {
                  QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, needCookie=" + k);
                }
                if (k == 1)
                {
                  localObject1 = (CustomWebView)this.mRuntime.a();
                  if (localObject1 != null)
                  {
                    localObject1 = ((CustomWebView)localObject1).getUrl();
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
                      {
                        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
                        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
                      }
                      localObject1 = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie((String)localObject1);
                      if (!TextUtils.isEmpty((CharSequence)localObject1))
                      {
                        if (((String)localObject1).indexOf(',') != -1) {
                          ((String)localObject1).replace(',', ';');
                        }
                        localJSONObject.put("Cookie", localObject1);
                      }
                    }
                  }
                }
              }
              if (this.mRuntime.a() != null) {
                break;
              }
              Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
              ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
              ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
              ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("6.0.2");
              localObject1 = new WebSSOAgent.UniSsoServerReq();
              ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
              localJSONObject.remove("callback");
              localJSONObject.remove("cmd");
              localJSONObject.remove("needCookie");
              localJSONObject.remove("timeout");
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("fingerprint", Build.FINGERPRINT);
              ((JSONObject)localObject2).put("model", Build.MODEL);
              ((JSONObject)localObject2).put("manufacturer", Build.MANUFACTURER);
              ((JSONObject)localObject2).put("brand", Build.BRAND);
              ((JSONObject)localObject2).put("device", Build.DEVICE);
              ((JSONObject)localObject2).put("product", Build.PRODUCT);
              ((JSONObject)localObject2).put("id", Build.ID);
              ((JSONObject)localObject2).put("level", Build.VERSION.SDK_INT);
              ((JSONObject)localObject2).put("cpu_abi", Build.CPU_ABI);
              ((JSONObject)localObject2).put("cpu_abi2", Build.CPU_ABI2);
              localJSONObject.put("option", localObject2);
              ((WebSSOAgent.UniSsoServerReq)localObject1).reqdata.set(localJSONObject.toString());
              localObject2 = new NewIntent(this.mRuntime.a().getApplicationContext(), WebSSOAgentServlet.class);
              ((NewIntent)localObject2).putExtra("extra_cmd", paramString2);
              ((NewIntent)localObject2).putExtra("extra_data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
              ((NewIntent)localObject2).putExtra("extra_callbackid", paramString1);
              ((NewIntent)localObject2).putExtra("extra_timeout", l1);
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, cmd=" + paramString2 + ", reqData=" + localJSONObject.toString());
              }
              ((NewIntent)localObject2).setObserver(new boy(this, System.currentTimeMillis(), paramString2));
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, send request to msf");
              }
              this.mRuntime.a().startServlet((NewIntent)localObject2);
              return;
            }
            if (((Integer)((Pair)localObject1).second).intValue() + 1 <= k)
            {
              this.d.put(paramString2, new Pair(Long.valueOf(l2), Integer.valueOf(((Integer)((Pair)localObject1).second).intValue() + 1)));
              continue;
            }
            localJSONObject = new JSONObject();
            localJSONObject.put("ssoRet", 102);
            localJSONObject.put("businessRet", 0);
            localJSONObject.put("msg", "请求过于频繁");
            super.callJs(paramString1, new String[] { localJSONObject.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: requests too frequently, cmd: " + paramString2 + ", freq: " + k);
            return;
          }
          this.d.put(paramString2, new Pair(Long.valueOf(l2), Integer.valueOf(0)));
          continue;
        }
      }
      catch (JSONException paramString1)
      {
        return;
        long l1 = -1L;
        continue;
      }
      catch (NullPointerException paramString1)
      {
        return;
      }
      label1345:
      int k = 10;
    }
  }
  
  private void c(String paramString1, String paramString2) {}
  
  protected void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    String[] arrayOfString;
    String str2;
    String str3;
    String str1;
    do
    {
      return;
      try
      {
        arrayOfString = Uri.parse(paramString2).getHost().split("\\.");
        paramString1 = new JSONObject(paramString1);
        str2 = paramString1.getString("data");
        str3 = paramString1.getString("cmd");
        c(str3, str2);
        str1 = paramString1.getString("callback");
        if (this.jdField_a_of_type_Long == 0L) {
          break label201;
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= this.jdField_a_of_type_Int * 1000) {
          break;
        }
        paramString1 = new JSONObject();
        paramString1.put("cret", 1);
        callJs(str1, new String[] { paramString1.toString() });
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("SSOWebviewPlugin", 2, "send request error!");
    return;
    if (str2.getBytes().length > this.jdField_b_of_type_Int)
    {
      paramString1 = new JSONObject();
      paramString1.put("cret", 2);
      callJs(str1, new String[] { paramString1.toString() });
      return;
      label201:
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    int k = arrayOfString.length;
    paramString1 = "";
    k -= 1;
    for (;;)
    {
      if (k >= 0)
      {
        paramString2 = paramString1 + arrayOfString[k];
        paramString1 = paramString2;
        if (k != 0) {
          paramString1 = paramString2 + "_";
        }
      }
      else
      {
        paramString2 = new NewIntent(this.mRuntime.a().getApplicationContext(), ProtoServlet.class);
        paramString2.putExtra("cmd", "MQUpdateSvc_" + paramString1 + ".web." + str3);
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.type.set(0);
        paramString1.data.set(str2);
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new boz(this, str1));
        this.mRuntime.a().startServlet(paramString2);
        return;
      }
      k -= 1;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = true;
    if (!"sso".equals(paramString2)) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (!"sendRequest".equals(paramString3)) {
            break;
          }
        } while (paramVarArgs.length <= 0);
        a(paramVarArgs[0], this.mRuntime.a().getUrl());
        return true;
        if (!"uniAgent".equals(paramString3)) {
          break;
        }
      } while (paramVarArgs.length <= 0);
      WebSSOAgentServlet.jdField_a_of_type_Long = System.currentTimeMillis();
      b(paramVarArgs[0], paramString1);
      return true;
    } while ((!"PublicFollow".equals(paramString3)) || (paramVarArgs.length <= 0));
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1.optInt("follow") == 1)
        {
          paramJsBridgeListener = paramString1.optString("uin");
          paramString1 = paramString1.getString("callback");
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "sso.PublicFollow isFollow: " + bool + "  uin: " + paramJsBridgeListener);
          }
          paramString2 = new Bundle();
          paramString2.putBoolean("isFollow", bool);
          paramString2.putString("uin", paramJsBridgeListener);
          paramString2.putString("callback", paramString1);
          paramJsBridgeListener = DataFactory.makeIPCRequestPacket("ipc_cmd_certified_account_web_plugin_follow", null, this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, paramString2);
          WebIPCOperator.getInstance().sendServiceIpcReq(paramJsBridgeListener);
          return false;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("SSOWebviewPlugin", 2, "sso.PublicFollow failed! " + QLog.getStackTraceString(paramJsBridgeListener));
        return false;
      }
      bool = false;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    WebIPCOperator.getInstance().registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_ComTencentSmttSdkCookieManager = null;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_b_of_type_JavaUtilHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      this.jdField_b_of_type_JavaUtilHashMap = null;
    }
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
    if (this.d != null) {
      this.d.clear();
    }
    if (this.e != null) {
      this.e.clear();
    }
    WebIPCOperator.getInstance().unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SSOWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */