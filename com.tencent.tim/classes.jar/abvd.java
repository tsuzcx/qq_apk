import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebDataHandler.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class abvd
{
  private static abvd a;
  private static boolean bFR;
  private abuy c = new abuy(this);
  private final LRULinkedHashMap<String, abvd.b> o = new LRULinkedHashMap(128);
  
  private abvd()
  {
    bFR = BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).getBoolean("sp_key_disable_thunder_cache", false);
  }
  
  public static boolean Zl()
  {
    return a != null;
  }
  
  private abvc a(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView == null) {
      return null;
    }
    paramCustomWebView = paramCustomWebView.getPluginEngine();
    if (paramCustomWebView != null)
    {
      paramCustomWebView = paramCustomWebView.b("apollo");
      if ((paramCustomWebView != null) && ((paramCustomWebView instanceof ApolloJsPlugin))) {
        return ((ApolloJsPlugin)paramCustomWebView).getIntercepter();
      }
    }
    return null;
  }
  
  public static abvd a()
  {
    try
    {
      if (a == null) {
        a = new abvd();
      }
      abvd localabvd = a;
      return localabvd;
    }
    finally {}
  }
  
  public static void cFF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "apollo_client initInAsyncThread isInstanceCreated():" + Zl());
    }
    if (!Zl()) {
      ThreadManager.postImmediately(new ApolloWebDataHandler.1(), null, true);
    }
  }
  
  private String iR(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      if (this.c == null) {
        return "";
      }
      str = this.c.iP(paramString);
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloWebDataHandler", 2, "getMD5FromDb pageId:" + paramString + " md5:" + str);
    return str;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, AppInterface paramAppInterface, abve paramabve)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.c == null)) {}
    for (;;)
    {
      return;
      if (!aqiw.isNetworkAvailable(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "preLoadSSOCmd false, NetworkUtil.isNetworkAvailable:false");
        }
      }
      else
      {
        this.c.h(paramAppInterface);
        Object localObject1 = this.c.c(paramString1);
        if ((localObject1 == null) || (((Set)localObject1).isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " cmds is null or empty");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " print all task:" + this.o);
          }
          localObject1 = ((Set)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (String)((Iterator)localObject1).next();
            String str = abuy.aG(paramString1, (String)localObject2);
            abvd.b localb = (abvd.b)this.o.get(str);
            if ((localb != null) && (localb.isValid((String)localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " mPreloadSSOCmds.has WebSSOTask:" + localb);
              }
            }
            else
            {
              this.o.remove(str);
              localb = new abvd.b(paramabve, str, (String)localObject2);
              this.o.put(str, localb);
              localObject2 = this.c.a(paramString2, paramString1, (String)localObject2, paramAppInterface);
              if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " create new WebSSOTask, requestJson" + localObject2);
              }
              if (localObject2 != null) {
                localb.a(paramContext, paramString2, (JSONObject)localObject2, paramAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, AppInterface paramAppInterface, WebViewPlugin paramWebViewPlugin)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramWebViewPlugin == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, url=" + paramString1 + " plugin:" + paramWebViewPlugin + " app:" + paramAppInterface + " requestStr:" + paramString2);
      }
      return false;
    }
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, NetworkUtil.isNetworkAvailable:false");
      }
      return false;
    }
    if ((paramWebViewPlugin.mRuntime == null) || (paramWebViewPlugin.mRuntime.getWebView() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, plugin.mRuntime.getWebView() is null");
      }
      return false;
    }
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, mSSOConfig is null");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        String str3 = a().iQ(paramString1);
        if (TextUtils.isEmpty(str3))
        {
          if (!QLog.isColorLevel()) {
            break label730;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, url is:" + paramString1 + " no need preload");
          break label730;
        }
        abvc localabvc = a(paramWebViewPlugin.mRuntime.getWebView());
        if (localabvc == null)
        {
          if (!QLog.isColorLevel()) {
            break label732;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, apolloSession is null");
          break label732;
        }
        JSONObject localJSONObject = new JSONObject(paramString2);
        String str1 = localJSONObject.getString("callback");
        if (TextUtils.isEmpty(str1)) {
          return false;
        }
        String str2 = localJSONObject.getString("cmd");
        if (!this.c.ap(str3, str2))
        {
          if (!QLog.isColorLevel()) {
            break label734;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, apolloClientId:" + str3 + " cmd:" + str2 + ",mSSOConfig.isValidCmd:false");
          break label734;
        }
        str3 = abuy.aG(str3, str2);
        paramString2 = (abvd.b)this.o.get(str3);
        if (paramString2 != null)
        {
          if (abvd.b.a(paramString2))
          {
            if (paramString2.isValid(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, webSSOTask.isValid true, mResultJson=" + paramString2);
              }
              if (abvd.b.a(paramString2) != null)
              {
                abvd.b.a(paramString2).OF = System.currentTimeMillis();
                abvd.b.a(paramString2).OG = System.currentTimeMillis();
              }
              paramWebViewPlugin.callJs(str1, new String[] { abvd.b.a(paramString2).toString() });
              this.o.remove(str3);
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, webSSOTask.isValid false,webSSOTask:" + paramString2);
            }
            i = 1;
            this.o.remove(str3);
            if (i == 0) {
              break label736;
            }
            if (localabvc != null)
            {
              paramString2 = localabvc.a();
              paramString2.OF = System.currentTimeMillis();
              paramString2 = new abvd.b(paramString2, str3, str2);
              paramString2.a(new abvd.a(this, str1, paramWebViewPlugin));
              if (paramWebViewPlugin.mRuntime != null) {
                paramString2.a(paramWebViewPlugin.mRuntime.getActivity(), paramString1, localJSONObject, paramAppInterface);
              }
              this.o.put(str3, paramString2);
              break label736;
            }
          }
          else
          {
            if (abvd.b.a(paramString2) != null) {
              abvd.b.a(paramString2).OF = System.currentTimeMillis();
            }
            paramString2.a(new abvd.a(this, str1, paramWebViewPlugin));
            if (!QLog.isColorLevel()) {
              break label724;
            }
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, has webSSOTask = true, but webSSOTask.mReceivedSSO:false, wait notify!");
            i = 0;
            continue;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label738;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, has webSSOTask = false,create webSSOTask!");
          break label738;
        }
        paramString2 = new abve();
        continue;
        i = 0;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
      label724:
      continue;
      label730:
      return false;
      label732:
      return false;
      label734:
      return false;
      label736:
      return true;
      label738:
      int i = 1;
    }
  }
  
  public List<abuy.a> aj(String paramString)
  {
    if (this.c != null) {
      return this.c.aj(paramString);
    }
    return null;
  }
  
  public boolean aq(String paramString1, String paramString2)
  {
    if (bFR) {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "verifyCache, sDisableCache:" + bFR);
      }
    }
    String str;
    do
    {
      do
      {
        return false;
      } while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
      str = abuj.getMD5(paramString2);
      paramString1 = iR(paramString1);
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(str)) && (str.toUpperCase().equals(paramString1.toUpperCase()))) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloWebDataHandler", 2, "verifyMd5 false:" + paramString1 + " contentMd5:" + str + ",configMd5:" + paramString1 + " html.length:" + paramString2.length());
    return false;
  }
  
  public boolean ar(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    int i = paramString1.indexOf("?");
    String str = paramString1;
    if (i != -1) {
      str = paramString1.substring(0, i);
    }
    abuj.writeFile(abuj.getFilePath(abuj.getFileName(str)), paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "saveHtml url:" + str + " html.length:" + paramString2.length());
    }
    return true;
  }
  
  public void cFG()
  {
    bFR = true;
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).edit().putBoolean("sp_key_disable_thunder_cache", true).commit();
  }
  
  public void cFH()
  {
    bFR = false;
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).edit().putBoolean("sp_key_disable_thunder_cache", false).commit();
  }
  
  public WebResourceResponse e(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    if (this.c == null) {
      return null;
    }
    if ((paramString1.contains("http://cmshow.qq.com/get_thunder_data?cmd=")) || (paramString1.contains("https://cmshow.qq.com/get_thunder_data?cmd=")))
    {
      Object localObject = "http://cmshow.qq.com/get_thunder_data?cmd=";
      if (paramString1.contains("https://cmshow.qq.com/get_thunder_data?cmd=")) {
        localObject = "https://cmshow.qq.com/get_thunder_data?cmd=";
      }
      paramString1 = paramString1.substring(((String)localObject).length());
      if (!this.c.ap(paramString2, paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource false, apolloClientId:" + paramString2 + " cmd:" + paramString1 + ",mSSOConfig.isValidCmd:false");
        }
        return null;
      }
      paramString2 = abuy.aG(paramString2, paramString1);
      localObject = (abvd.b)this.o.get(paramString2);
      if (localObject != null) {
        if (abvd.b.a((abvd.b)localObject))
        {
          if (((abvd.b)localObject).isValid(paramString1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, webSSOTask.isValid true, webSSOTask=" + localObject);
            }
            if (abvd.b.a((abvd.b)localObject) != null)
            {
              abvd.b.a((abvd.b)localObject).OF = System.currentTimeMillis();
              abvd.b.a((abvd.b)localObject).OG = System.currentTimeMillis();
            }
            paramString1 = new WebResourceResponse("text/plain", "utf-8", abuj.toInputStream(abvd.b.a((abvd.b)localObject).toString()));
            this.o.remove(paramString2);
            return paramString1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, webSSOTask.isValid false,webSSOTask:" + localObject);
          }
          this.o.remove(paramString2);
        }
      }
      for (;;)
      {
        return new WebResourceResponse("text/plain", "utf-8", new abvf(null, null, null));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, has webSSOTask = false");
        }
      }
    }
    return null;
  }
  
  public String iQ(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getQueryParameter("thunder_id");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("apollo_client_ApolloWebDataHandler", 2, paramString.getMessage());
    }
    return null;
  }
  
  public boolean jF(String paramString)
  {
    if (ApolloUtil.Zz()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "isApolloClientId, ApolloUtil.isApolloProxyEnable() return");
    }
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "isApolloClientId, apolloClientId:" + paramString);
      }
    } while (this.c == null);
    return this.c.jD(paramString);
  }
  
  public boolean jG(String paramString)
  {
    return (paramString.contains("http://cmshow.qq.com/get_thunder_data?cmd=")) || (paramString.contains("https://cmshow.qq.com/get_thunder_data?cmd="));
  }
  
  static class a
  {
    public WeakReference<WebViewPlugin> fQ;
    public String mCallBackId;
    private WeakReference<abvd> z;
    
    public a(abvd paramabvd, String paramString, WebViewPlugin paramWebViewPlugin)
    {
      this.z = new WeakReference(paramabvd);
      this.mCallBackId = paramString;
      this.fQ = new WeakReference(paramWebViewPlugin);
    }
    
    public void a(abvd.b paramb, abve paramabve)
    {
      abvd localabvd = (abvd)this.z.get();
      WebViewPlugin localWebViewPlugin;
      if ((localabvd != null) && (paramb != null))
      {
        localWebViewPlugin = (WebViewPlugin)this.fQ.get();
        if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.mCallBackId)))
        {
          if (paramabve != null) {
            paramabve.OG = System.currentTimeMillis();
          }
          if (abvd.b.a(paramb) == null) {
            break label175;
          }
          localWebViewPlugin.callJs(this.mCallBackId, new String[] { abvd.b.a(paramb).toString() });
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + abvd.b.a(paramb));
        }
        if (abvd.a(localabvd) != null)
        {
          abvd.a(localabvd).remove(abvd.b.a(paramb));
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + abvd.b.a(paramb));
          }
        }
        return;
        label175:
        localWebViewPlugin.callJs(this.mCallBackId, new String[] { "" });
      }
    }
  }
  
  static class b
    implements BusinessObserver
  {
    private long OC;
    private abve a;
    private JSONObject av;
    private boolean bFS;
    private final String bib;
    private boolean mIsSuccess;
    private final String uP;
    private final List<abvd.a> wF;
    
    public b(abve paramabve, String paramString1, String paramString2)
    {
      this.bib = paramString2;
      this.uP = paramString1;
      this.wF = new ArrayList();
      this.a = paramabve;
    }
    
    public JSONObject a(boolean paramBoolean, Bundle paramBundle)
    {
      if (paramBundle == null) {
        return null;
      }
      JSONObject localJSONObject;
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          if (!paramBoolean) {
            break label323;
          }
          Object localObject = paramBundle.getByteArray("extra_data");
          if (localObject == null) {
            break;
          }
          paramBundle = new WebSSOAgent.UniSsoServerRsp();
          paramBundle.mergeFrom((byte[])localObject);
          localJSONObject.put("ssoRet", 0);
          if (paramBundle.ret.has())
          {
            long l = paramBundle.ret.get();
            localJSONObject.put("businessRet", l);
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, ret, biz ret code=" + l);
            }
            if (paramBundle.errmsg.has())
            {
              localObject = paramBundle.errmsg.get();
              localJSONObject.put("msg", localObject);
              if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, ret, errmsg=" + (String)localObject);
              }
              if (!paramBundle.rspdata.has()) {
                break label473;
              }
              paramBundle = paramBundle.rspdata.get();
              localJSONObject.put("data", paramBundle);
              if (!QLog.isColorLevel()) {
                break label473;
              }
              QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, ret, rspData=" + paramBundle);
              break label473;
            }
          }
          else
          {
            localJSONObject.put("businessRet", 0);
            continue;
          }
          localJSONObject.put("msg", "SSO发送成功");
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return null;
        }
      }
      this.mIsSuccess = false;
      if (QLog.isColorLevel()) {
        QLog.w("apollo_client_ApolloWebDataHandler", 2, "uniAgent, onReceive, ret success but no data");
      }
      localJSONObject.put("ssoRet", 255);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", "SSO返回数据包为空");
      break label473;
      label323:
      int i = paramBundle.getInt("extra_result_code");
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, msfResultCode=" + i);
      }
      if (i == 1001)
      {
        localJSONObject.put("ssoRet", 201);
        localJSONObject.put("businessRet", 0);
        localJSONObject.put("msg", acfp.m(2131702729));
      }
      for (;;)
      {
        localJSONObject.put("ssoRet", 202);
        localJSONObject.put("businessRet", 0);
        localJSONObject.put("msg", acfp.m(2131702726));
        label473:
        do
        {
          localJSONObject.put("ssoRet", 255);
          localJSONObject.put("businessRet", 0);
          localJSONObject.put("msg", acfp.m(2131702730));
          return localJSONObject;
          if (i == 1002) {
            break;
          }
        } while (i != 1013);
      }
    }
    
    public void a(abvd.a parama)
    {
      if (parama != null) {
        this.wF.add(parama);
      }
    }
    
    public void a(Context paramContext, String paramString, JSONObject paramJSONObject, AppInterface paramAppInterface)
    {
      if ((paramJSONObject == null) || (paramContext == null) || (paramAppInterface == null)) {}
      try
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "sendRequest, requestJsonObj:" + paramJSONObject + " context:" + paramContext + " app:" + paramAppInterface);
        return;
      }
      catch (Exception paramContext)
      {
        Object localObject;
        long l;
        paramContext.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "sendRequest, currentUrl:" + paramString + " requestJsonObj:requestJsonObj");
      }
      if ((paramJSONObject.optInt("needCookie") == 1) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = SwiftBrowserCookieMonster.pZ(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (((String)localObject).indexOf(',') != -1) {
            ((String)localObject).replace(',', ';');
          }
          paramJSONObject.put("Cookie", localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "Get cookie:" + jqo.b((String)localObject, new String[0]) + " from " + jqo.filterKeyForLog(paramString, new String[0]));
        }
      }
      localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      paramString = new WebSSOAgent.UniSsoServerReq();
      paramString.comm.set((MessageMicro)localObject);
      paramJSONObject.remove("callback");
      paramJSONObject.remove("cmd");
      paramJSONObject.remove("needCookie");
      paramJSONObject.remove("timeout");
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
      paramJSONObject.put("option", localObject);
      paramString.reqdata.set(paramJSONObject.toString());
      paramContext = new NewIntent(paramContext, ailu.class);
      paramContext.putExtra("extra_cmd", this.bib);
      paramContext.putExtra("extra_data", paramString.toByteArray());
      paramContext.putExtra("extra_timeout", -1L);
      paramContext.setObserver(this);
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, req, send request to msf");
      }
      paramAppInterface.startServlet(paramContext);
      if (this.a != null)
      {
        paramContext = this.a;
        l = System.currentTimeMillis();
        this.OC = l;
        paramContext.OD = l;
        return;
      }
    }
    
    public void cFI()
    {
      if (this.bFS)
      {
        Iterator localIterator = this.wF.iterator();
        while (localIterator.hasNext()) {
          ((abvd.a)localIterator.next()).a(this, this.a);
        }
        this.wF.clear();
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "notifySSORsp, mReceivedSSO:" + this.bFS);
      }
    }
    
    public boolean isValid(String paramString)
    {
      return (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.bib)) && (System.currentTimeMillis() - this.OC < 10000L) && (this.mIsSuccess) && (((this.bFS) && (this.av != null)) || (!this.bFS));
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      try
      {
        this.mIsSuccess = paramBoolean;
        this.av = a(paramBoolean, paramBundle);
        this.bFS = true;
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebSSOTask, onReceive, isSuccess: " + paramBoolean + " mResultJson:" + this.av);
        }
        cFI();
        if (this.a != null) {
          this.a.OE = System.currentTimeMillis();
        }
        return;
      }
      catch (Exception paramBundle)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("apollo_client_ApolloWebDataHandler", 2, "uniAgent, onReceive, Exception: " + paramBundle.getMessage());
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSSOCmd:").append(this.bib).append(" mPreloadTS:").append(this.OC).append(" mIsSuccess:").append(this.mIsSuccess).append(" mReceivedSSO:").append(this.bFS).append(" mResultJson:").append(this.av);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvd
 * JD-Core Version:    0.7.0.1
 */