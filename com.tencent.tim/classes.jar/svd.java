import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.Pair;
import java.util.HashMap;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class svd
  extends WebViewPlugin
{
  private CookieManager a;
  public HashMap<String, Long> gb = new HashMap();
  public HashMap<String, Long> gc = new HashMap();
  public HashMap<String, Long> gd = new HashMap();
  HashMap<String, Pair<Long, Integer>> ge = new HashMap();
  HashMap<String, Integer> gf = new HashMap();
  NewIntent h;
  protected Activity mActivity;
  private Client.b mOnRemoteResp = new sve(this);
  int maxSize = 204800;
  int minDuration = 5;
  long preTime = 0L;
  
  public svd()
  {
    this.mPluginNameSpace = "sso";
  }
  
  private void bF(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSOTimeout. cmd=" + paramString);
    }
    abim localabim = abim.a();
    if (localabim.jo(paramString)) {
      localabim.j(paramString, null, -1001, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSOTimeout. cmd is not in white list");
  }
  
  private void bG(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSOSuccessCost. cmd=" + paramString + " ssoCost=" + paramInt);
    }
    abim localabim = abim.a();
    if (localabim.jo(paramString)) {
      localabim.j(paramString, null, 1000, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSORetCodeNonZero. cmd is not in white list");
  }
  
  private void cW(String paramString1, String paramString2)
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
        String str1 = localJSONObject.getString("cmd");
        paramString2 = localJSONObject.getString("callback");
        if (localJSONObject.has("timeout"))
        {
          l1 = localJSONObject.getLong("timeout");
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, cmd=" + str1 + ", callbackId=" + paramString2 + ",timeout = " + l1);
          }
          if (TextUtils.isEmpty(paramString2))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no callbackId");
            return;
          }
          if (TextUtils.isEmpty(str1))
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 255);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", acfp.m(2131714762));
            super.callJs(paramString2, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no cmd");
            return;
          }
          if (!aqiw.isNetworkAvailable(this.mActivity))
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 103);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", "MSF未连接");
            super.callJs(paramString2, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: network unavailable");
            return;
          }
          long l2 = 10240L;
          if (this.gc.containsKey(str1)) {
            l2 = ((Long)this.gc.get(str1)).longValue();
          }
          if (l2 > 0L)
          {
            long l3 = localJSONObject.toString().getBytes().length;
            if (l3 > l2)
            {
              paramString1 = new JSONObject();
              paramString1.put("ssoRet", 101);
              paramString1.put("businessRet", 0);
              paramString1.put("msg", acfp.m(2131714770));
              super.callJs(paramString2, new String[] { paramString1.toString() });
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: pkg size exceeded, dataLength=" + l3 + ", maxPkgSize=" + l2);
              return;
            }
          }
          l2 = System.currentTimeMillis() / 1000L;
          if (this.ge.containsKey(str1))
          {
            localObject = (Pair)this.ge.get(str1);
            if (!this.gf.containsKey(str1)) {
              break label1484;
            }
            i = ((Integer)this.gf.get(str1)).intValue();
            if (((Long)((Pair)localObject).first).longValue() != l2)
            {
              this.ge.put(str1, new Pair(Long.valueOf(l2), Integer.valueOf(0)));
              if (localJSONObject.has("needCookie"))
              {
                i = localJSONObject.getInt("needCookie");
                if (QLog.isColorLevel()) {
                  QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, needCookie=" + i);
                }
                if (i == 1)
                {
                  localObject = this.mRuntime.getWebView();
                  if (localObject != null)
                  {
                    localObject = ((CustomWebView)localObject).getUrl();
                    if (!TextUtils.isEmpty((CharSequence)localObject))
                    {
                      if (this.a == null)
                      {
                        this.a = CookieManager.getInstance();
                        this.a.setAcceptCookie(true);
                      }
                      String str2 = this.a.getCookie((String)localObject);
                      if (!TextUtils.isEmpty(str2))
                      {
                        if (str2.indexOf(',') != -1) {
                          str2.replace(',', ';');
                        }
                        localJSONObject.put("Cookie", str2);
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("SSOWebviewPlugin", 2, "Get cookie:" + jqo.b(str2, new String[0]) + " from " + jqo.filterKeyForLog((String)localObject, new String[0]));
                      }
                    }
                  }
                }
              }
              if ((this.mRuntime.getWebView() == null) || (!abvd.a().a(this.mRuntime.getWebView().getUrl(), paramString1, this.mRuntime.a(), this))) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SSOWebviewPlugin", 2, "apollo_client_ApolloWebDataHandler uniAgent, req, cmd=" + str1 + " doInterceptApolloCmd:true");
              return;
            }
            if (((Integer)((Pair)localObject).second).intValue() + 1 <= i)
            {
              this.ge.put(str1, new Pair(Long.valueOf(l2), Integer.valueOf(((Integer)((Pair)localObject).second).intValue() + 1)));
              continue;
            }
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 102);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", acfp.m(2131714759));
            super.callJs(paramString2, new String[] { paramString1.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: requests too frequently, cmd: " + str1 + ", freq: " + i);
            return;
          }
          this.ge.put(str1, new Pair(Long.valueOf(l2), Integer.valueOf(0)));
          continue;
          Object localObject = new WebSSOAgent.UniSsoServerReqComm();
          ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
          ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
          ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
          paramString1 = new WebSSOAgent.UniSsoServerReq();
          paramString1.comm.set((MessageMicro)localObject);
          localJSONObject.remove("callback");
          localJSONObject.remove("cmd");
          localJSONObject.remove("needCookie");
          localJSONObject.remove("timeout");
          localObject = new JSONObject();
          ((JSONObject)localObject).put("fingerprint", Build.FINGERPRINT);
          ((JSONObject)localObject).put("model", Build.MODEL);
          ((JSONObject)localObject).put("manufacturer", Build.MANUFACTURER);
          ((JSONObject)localObject).put("brand", Build.BRAND);
          ((JSONObject)localObject).put("device", Build.DEVICE);
          ((JSONObject)localObject).put("product", Build.PRODUCT);
          ((JSONObject)localObject).put("id", Build.ID);
          ((JSONObject)localObject).put("level", Build.VERSION.SDK_INT);
          ((JSONObject)localObject).put("cpu_abi", Build.CPU_ABI);
          ((JSONObject)localObject).put("cpu_abi2", Build.CPU_ABI2);
          localJSONObject.put("option", localObject);
          paramString1.reqdata.set(localJSONObject.toString());
          localObject = new NewIntent(this.mRuntime.getActivity().getApplicationContext(), ailu.class);
          ((NewIntent)localObject).putExtra("extra_cmd", str1);
          ((NewIntent)localObject).putExtra("extra_data", paramString1.toByteArray());
          ((NewIntent)localObject).putExtra("extra_callbackid", paramString2);
          ((NewIntent)localObject).putExtra("extra_timeout", l1);
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, cmd=" + str1 + ", reqData=" + localJSONObject.toString());
          }
          ((NewIntent)localObject).setObserver(new svf(this, System.currentTimeMillis(), str1));
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, send request to msf");
          }
          this.mRuntime.a().startServlet((NewIntent)localObject);
          return;
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
      label1484:
      int i = 10;
    }
  }
  
  private void cX(String paramString1, String paramString2) {}
  
  private void h(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSORetCodeNonZero. cmd=" + paramString + " ssoErrorCode=" + paramLong);
    }
    abim localabim = abim.a();
    if (localabim.jo(paramString)) {
      localabim.j(paramString, null, -1002, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SSOWebviewPlugin_apollo_store_stability_", 2, "reportSSORetCodeNonZero. cmd is not in white list");
  }
  
  protected void cv(String paramString1, String paramString2)
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
        cX(str3, str2);
        str1 = paramString1.getString("callback");
        if (this.preTime == 0L) {
          break label202;
        }
        if (System.currentTimeMillis() - this.preTime >= this.minDuration * 1000) {
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
    if (str2.getBytes().length > this.maxSize)
    {
      paramString1 = new JSONObject();
      paramString1.put("cret", 2);
      callJs(str1, new String[] { paramString1.toString() });
      return;
      label202:
      this.preTime = System.currentTimeMillis();
    }
    int i = arrayOfString.length;
    paramString1 = "";
    i -= 1;
    for (;;)
    {
      if (i >= 0)
      {
        paramString2 = paramString1 + arrayOfString[i];
        paramString1 = paramString2;
        if (i != 0) {
          paramString1 = paramString2 + "_";
        }
      }
      else
      {
        paramString2 = new NewIntent(this.mRuntime.getActivity().getApplicationContext(), jnl.class);
        paramString2.putExtra("cmd", "MQUpdateSvc_" + paramString1 + ".web." + str3);
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.type.set(0);
        paramString1.data.set(str2);
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new svg(this, str1, str3));
        this.mRuntime.a().startServlet(paramString2);
        return;
      }
      i -= 1;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
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
        cv(paramVarArgs[0], this.mRuntime.getWebView().getUrl());
        return true;
        if (!"uniAgent".equals(paramString3)) {
          break;
        }
      } while (paramVarArgs.length <= 0);
      ailu.abF = System.currentTimeMillis();
      cW(paramVarArgs[0], paramString1);
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
          paramJsBridgeListener = affz.a("ipc_cmd_certified_account_web_plugin_follow", null, this.mOnRemoteResp.key, paramString2);
          afjy.a().cq(paramJsBridgeListener);
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
  
  public void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.getActivity();
    afjy.a().a(this.mOnRemoteResp);
  }
  
  public void onDestroy()
  {
    if (this.h != null) {
      this.h.setObserver(null);
    }
    this.a = null;
    if (this.gb != null)
    {
      this.gb.clear();
      this.gb = null;
    }
    if (this.gc != null)
    {
      this.gc.clear();
      this.gc = null;
    }
    if (this.gd != null)
    {
      this.gd.clear();
      this.gd = null;
    }
    if (this.ge != null) {
      this.ge.clear();
    }
    if (this.gf != null) {
      this.gf.clear();
    }
    afjy.a().b(this.mOnRemoteResp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svd
 * JD-Core Version:    0.7.0.1
 */