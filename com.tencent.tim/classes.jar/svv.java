import android.app.Activity;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class svv
  extends WebViewPlugin
{
  private static int bzv = -1;
  private svv.a jdField_a_of_type_Svv$a = new svv.a();
  private svv.b jdField_a_of_type_Svv$b;
  public String aHv = "";
  public String aHw = "";
  private boolean aNA;
  private boolean aNz;
  private Handler bC = new svw(this, Looper.getMainLooper());
  boolean[] n = new boolean[1];
  
  public svv()
  {
    this.mPluginNameSpace = "WebSo";
  }
  
  public static int a(WebView paramWebView)
  {
    if ((bzv < 0) && (paramWebView != null))
    {
      bzv = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "tbsCoreVersion= " + bzv);
      }
    }
    return bzv;
  }
  
  public static void a(CustomWebView paramCustomWebView, String paramString1, String paramString2)
  {
    ardk.Wo("setdata");
    if (TextUtils.isEmpty(paramString1)) {
      QLog.w("WebSoPlugin", 1, "setWebViewData webview url is Empty!");
    }
    if (a(paramCustomWebView))
    {
      paramCustomWebView.setTag(2131375013, paramString2);
      paramCustomWebView.setTag(2131375014, Long.valueOf(System.currentTimeMillis()));
      paramCustomWebView.loadUrl(paramString1);
      return;
    }
    paramCustomWebView.loadDataWithBaseURL(paramString1, paramString2, "text/html", "utf-8", paramString1);
  }
  
  public static boolean a(WebView paramWebView)
  {
    return (a(paramWebView) >= 43001) || (Build.VERSION.SDK_INT >= 23);
  }
  
  private boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    this.aNA = false;
    this.n[0] = false;
    this.jdField_a_of_type_Svv$a.bBo();
    if ((paramLong != 32L) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (this.mRuntime == null);
          paramMap = this.mRuntime.getActivity();
        } while ((paramMap == null) || (paramMap.isFinishing()) || (paramMap.getIntent() == null));
        paramMap = this.mRuntime.getWebView();
      } while (paramMap == null);
      paramMap = paramMap.getUrl();
      if ((!TextUtils.isEmpty(paramMap)) && (!"about:blank".equals(paramMap)))
      {
        QLog.e("WebSoPlugin", 1, "now onHandleEventBeforeLoaded current url is not null! so return! " + jqo.b(paramMap, new String[0]));
        return false;
      }
      tS(paramString);
    } while ((!ardk.rX(paramString)) || (ardk.sa(paramString)));
    WebSoService.a().a(paramString, this.bC, this.n);
    vd(false);
    return true;
  }
  
  private void bd(Bundle paramBundle)
  {
    if (this.mRuntime != null) {}
    for (CustomWebView localCustomWebView = this.mRuntime.getWebView();; localCustomWebView = null)
    {
      if (localCustomWebView == null) {}
      String str3;
      do
      {
        return;
        str3 = localCustomWebView.getUrl();
      } while (paramBundle == null);
      String str2 = paramBundle.getString("url");
      int j = paramBundle.getInt("req_state", 0);
      int k = paramBundle.getInt("result_code", 0);
      boolean bool2 = paramBundle.getBoolean("is_local_data");
      String str1 = paramBundle.getString("wns_proxy_http_data");
      boolean bool3 = TextUtils.isEmpty(str1);
      if ((TextUtils.isEmpty(str3)) || ("about:blank".equals(str3))) {}
      boolean bool4;
      WebSoService.WebSoState.WebSo3 localWebSo3;
      for (int i = 1;; i = 0)
      {
        bool4 = paramBundle.getBoolean("key_wns_cache_hit", false);
        localWebSo3 = (WebSoService.WebSoState.WebSo3)paramBundle.getParcelable("key_webso_3");
        if (k != 10503) {
          break;
        }
        QLog.e("WebSoPlugin", 1, "QZoneWebViewPlugin onReceive 503, now it reload url! " + jqo.b(str2, new String[0]));
        localCustomWebView.loadUrlOriginal(str2);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("QZoneWebViewPlugin onReceive  htmlBody(");
      if (!bool3) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("WebSoPlugin", 1, bool1 + ") currentUrl(" + str3 + ") cache hit(" + bool4 + ") hasLoadCache(" + this.aNA + ") load Url: " + jqo.b(str2, new String[0]) + ",silent_mode:" + paramBundle.getBoolean("is_silent_mode", false) + ",isLocalData:" + bool2);
        if ((localWebSo3 == null) || (!localWebSo3.valid)) {
          break;
        }
        this.jdField_a_of_type_Svv$a.a(this, localWebSo3);
        return;
      }
      this.jdField_a_of_type_Svv$a.bBo();
      if ((!bool3) && (Build.VERSION.SDK_INT >= 17))
      {
        if (!bool2) {
          break label489;
        }
        if (this.jdField_a_of_type_Svv$b == null)
        {
          this.jdField_a_of_type_Svv$b = new svv.b(localCustomWebView);
          localCustomWebView.addJavascriptInterface(this.jdField_a_of_type_Svv$b, "_webso");
          if (QLog.isColorLevel()) {
            QLog.d("WebSoPlugin", 1, "js method : " + Arrays.toString(this.jdField_a_of_type_Svv$b.getClass().getDeclaredMethods()));
          }
        }
      }
      label434:
      if ((!this.aNA) && (!bool3) && (i != 0))
      {
        if (j == 2) {}
        this.aNA = true;
        this.n[0] = true;
        if (bool2) {}
        for (paramBundle = ardk.cc(str2, str1);; paramBundle = ardk.ce(str2, str1))
        {
          a(localCustomWebView, str2, paramBundle);
          return;
          label489:
          if (!paramBundle.getBoolean("is_silent_mode", false)) {
            break label434;
          }
          QLog.d("WebSoPlugin", 1, "静默加载html");
          if (this.jdField_a_of_type_Svv$b == null) {
            break;
          }
          this.jdField_a_of_type_Svv$b.tT(str1);
          return;
        }
      }
      if (bool4)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WebSoPlugin", 2, "webso return 304, so hit local cache!");
        }
        if (this.jdField_a_of_type_Svv$b != null) {
          this.jdField_a_of_type_Svv$b.tT("{\"code\":0,\"data\":null}");
        }
        this.aHw = "304";
        yS(304);
        return;
      }
      if (this.aNA)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WebSoPlugin", 1, "webso success load local data, now load new data ! " + this.aNA);
        }
        this.aNz = true;
      }
      if ((bool3) && (i != 0))
      {
        localCustomWebView.loadUrl(str2);
        vd(true);
        return;
      }
      if ((!bool3) && (i != 0))
      {
        if (bool2) {}
        for (paramBundle = ardk.cc(str2, str1);; paramBundle = ardk.ce(str2, str1))
        {
          a(localCustomWebView, str2, paramBundle);
          return;
        }
      }
      if ((!bool3) && (i == 0)) {
        if (paramBundle.getBoolean("need_force_refresh", false)) {
          if (bool2) {
            break label778;
          }
        }
      }
      label778:
      for (paramBundle = ardk.ce(str2, str1);; paramBundle = str1)
      {
        a(localCustomWebView, str2, paramBundle);
        return;
        if (!paramBundle.getBoolean("need_local_refresh", false)) {
          break;
        }
        this.aHw = paramBundle.getString("key_html_changed_data");
        yS(200);
        return;
        this.aNz = false;
        return;
      }
    }
  }
  
  private void vd(boolean paramBoolean)
  {
    boolean bool = true;
    if (this.mRuntime == null) {
      return;
    }
    Object localObject = this.mRuntime.getActivity();
    if ((localObject instanceof FragmentActivity))
    {
      localObject = a((FragmentActivity)localObject);
      if ((localObject != null) && (((WebViewFragment)localObject).a != null))
      {
        if (((WebViewFragment)localObject).a.mProgressBarController != null)
        {
          arcd localarcd = ((WebViewFragment)localObject).a;
          if (!paramBoolean) {}
          for (bool = true;; bool = false)
          {
            localarcd.cYk = bool;
            ((WebViewFragment)localObject).a.mProgressBarController.xW(paramBoolean);
            return;
          }
        }
        localObject = ((WebViewFragment)localObject).a;
        if (!paramBoolean) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          ((arcd)localObject).cYk = paramBoolean;
          return;
        }
      }
      ve(paramBoolean);
      return;
    }
    ve(paramBoolean);
  }
  
  private void ve(boolean paramBoolean)
  {
    if ((this.mRuntime == null) || (this.mRuntime.getWebView() == null) || (this.mRuntime.getWebView().getRootView() == null) || (this.mRuntime.getWebView().getRootView().findViewById(2131382187) == null)) {}
    View localView;
    do
    {
      return;
      localView = this.mRuntime.getWebView().getRootView().findViewById(2131382187).findViewById(2131373669);
    } while (localView == null);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void yS(int paramInt)
  {
    if (TextUtils.isEmpty(this.aHv)) {}
    JSONObject localJSONObject1;
    CustomWebView localCustomWebView;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(this.aHw));
      localJSONObject1 = new JSONObject();
      localCustomWebView = null;
      if (this.mRuntime != null) {
        localCustomWebView = this.mRuntime.getWebView();
      }
    } while (localCustomWebView == null);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.aHw = "";
      return;
      JSONObject localJSONObject2;
      long l;
      try
      {
        localJSONObject2 = new JSONObject(this.aHw);
        l = System.currentTimeMillis() - localJSONObject2.optLong("local_refresh_time", 0L);
        if (l <= 30000L) {
          break label206;
        }
        if (QLog.isColorLevel()) {
          QLog.w("WebSoPlugin", 1, "receive js call too late, " + l / 1000.0D + "s");
        }
        this.aHw = "";
        this.aHv = "";
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("WebSoPlugin", 1, localException, new Object[] { "dispatchDiffData to website error!" });
      }
      continue;
      label206:
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "receive js call in time: " + l / 1000.0D + "s");
      }
      if (l > 0L) {
        localJSONObject1.put("local_refresh_time", l);
      }
      localJSONObject2.remove("local_refresh_time");
      localJSONObject1.put("result", localJSONObject2.toString());
      localJSONObject1.put("code", 200);
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "now call localRefresh data: , " + localJSONObject1.toString());
      }
      localException.callJs(this.aHv, new String[] { localJSONObject1.toString() });
      continue;
      localJSONObject1.put("code", 304);
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "now call localRefresh data: , " + localJSONObject1.toString());
      }
      localException.callJs(this.aHv, new String[] { localJSONObject1.toString() });
    }
  }
  
  public WebViewFragment a(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity = paramFragmentActivity.getFragments();
      if ((paramFragmentActivity != null) && (paramFragmentActivity.size() > 0))
      {
        paramFragmentActivity = paramFragmentActivity.iterator();
        while (paramFragmentActivity.hasNext())
        {
          Fragment localFragment = (Fragment)paramFragmentActivity.next();
          if ((localFragment instanceof WebViewFragment)) {
            return (WebViewFragment)localFragment;
          }
        }
      }
    }
    return null;
  }
  
  public void b(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (Build.VERSION.SDK_INT > 10)) {
      paramCustomWebView.setLayerType(1, null);
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 32L)
    {
      ardk.Wo("KEY_EVENT_BEFORE_LOAD");
      return a(paramString, paramLong, paramMap);
    }
    if (paramLong == 8589934594L)
    {
      ardk.Wo("EVENT_LOAD_FINISH");
      if ((TextUtils.isEmpty(paramString)) || ("about:bank".equals(paramString))) {
        return false;
      }
      if (!ardk.rX(paramString)) {
        return false;
      }
      CustomWebView localCustomWebView = this.mRuntime.getWebView();
      if (localCustomWebView == null) {
        return false;
      }
      paramString = localCustomWebView.copyBackForwardList();
      if ((paramString == null) || (paramString.getSize() == 0))
      {
        if (this.aNz)
        {
          if (localCustomWebView != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("WebSoPlugin", 2, "now clear webview history!");
            }
            localCustomWebView.clearHistory();
          }
          this.aNz = false;
        }
        return false;
      }
      int i;
      if (QLog.isColorLevel())
      {
        i = paramString.getSize() - 1;
        while (i >= 0)
        {
          paramMap = paramString.getItemAtIndex(i);
          if (paramMap != null) {
            QLog.i("WebSoPlugin", 2, " EVENT_LOAD_FINISH --- history: " + i + " " + paramMap.getUrl());
          }
          i -= 1;
        }
      }
      if (paramString.getSize() >= 2)
      {
        String str1 = "";
        String str2 = "";
        i = paramString.getSize() - 1;
        WebHistoryItem localWebHistoryItem1 = paramString.getItemAtIndex(i);
        WebHistoryItem localWebHistoryItem2 = paramString.getItemAtIndex(i - 1);
        paramMap = str2;
        paramString = str1;
        if (localWebHistoryItem1 != null)
        {
          paramMap = str2;
          paramString = str1;
          if (localWebHistoryItem2 != null)
          {
            paramString = localWebHistoryItem1.getUrl();
            paramMap = localWebHistoryItem2.getUrl();
          }
        }
        if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("WebSoPlugin", 2, "current url equals with precious url, need clear history!");
          }
          this.aNz = true;
        }
      }
      if (this.aNz)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WebSoPlugin", 2, "now clear webview history!");
        }
        localCustomWebView.clearHistory();
        this.aNz = false;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (paramLong != 8589934601L);
          ardk.Wo("EVENT_GO_BACK");
          if ((TextUtils.isEmpty(paramString)) || ("about:bank".equals(paramString))) {
            return false;
          }
          if (!ardk.rX(paramString)) {
            return false;
          }
          paramString = this.mRuntime.getWebView();
          if (paramString == null) {
            return false;
          }
          paramString = paramString.copyBackForwardList();
          if (paramString == null) {
            return false;
          }
        } while (paramString.getSize() != 2);
        paramMap = paramString.getItemAtIndex(paramString.getSize() - 1).getUrl();
      } while (!paramString.getItemAtIndex(paramString.getSize() - 2).getUrl().equals(paramMap));
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "current url equals with precious url, need close activity!");
      }
    } while (this.mRuntime.getActivity() == null);
    this.mRuntime.getActivity().finish();
    return true;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && ("WebSo".equals(paramString2)))
    {
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {}
      label226:
      do
      {
        for (;;)
        {
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("WebSoPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
          }
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (TextUtils.isEmpty(paramJsBridgeListener))
          {
            QLog.e("WebSoPlugin", 1, "callback id is null, so return");
            return true;
          }
          if (!"getWebsoDiffData".equals(paramString3)) {
            break label226;
          }
          if (QLog.isColorLevel()) {
            QLog.d("WebSoPlugin", 2, "WebSo get webso js api, data: " + Arrays.toString(paramVarArgs));
          }
          if ((this.mRuntime.getWebView() != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
              if (!TextUtils.isEmpty(paramJsBridgeListener))
              {
                this.aHv = paramJsBridgeListener;
                if (!TextUtils.isEmpty(this.aHw)) {
                  if (this.aHw.equals("304"))
                  {
                    yS(304);
                    return true;
                  }
                }
              }
            }
            catch (Exception paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              return true;
            }
          }
        }
        yS(200);
        return true;
        if ("getData".equals(paramString3))
        {
          ardk.Wo("js call getData");
          this.jdField_a_of_type_Svv$a.a(this, paramJsBridgeListener);
          return true;
        }
        if ("updateWebsoCache".equals(paramString3)) {}
        try
        {
          ardk.Wo("js call updateWebsoCache");
          if (this.jdField_a_of_type_Svv$a.a() != null)
          {
            if (this.mRuntime != null) {
              this.mRuntime.getWebView().loadUrl("javascript:window._webso.catchHtml(document.getElementsByTagName('html')[0].outerHTML);");
            }
            paramString1 = new JSONObject();
            paramString1.put("result", 1);
            super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            return true;
          }
          ardk.Wo("return : webso == null");
          return true;
        }
        catch (Exception paramJsBridgeListener) {}
        if ("updateScreenshot".equals(paramString3)) {
          try
          {
            ardk.Wo("js call updateScreenshot");
            if (this.mRuntime != null)
            {
              paramString1 = this.mRuntime.getWebView();
              paramString2 = paramString1.getUrl();
              if (ardk.rX(paramString2)) {
                WebSoService.t(paramString1, paramString2);
              }
            }
            paramString1 = new JSONObject();
            paramString1.put("result", 1);
            super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            return true;
          }
        }
      } while (!"hideScreenshot".equals(paramString3));
      try
      {
        ardk.Wo("js call hideScreenshot");
        if (this.mRuntime != null) {
          WebSoService.f(this.mRuntime.getWebView());
        }
        paramString1 = new JSONObject();
        paramString1.put("result", 1);
        super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        return true;
      }
    }
    return false;
    return true;
  }
  
  void tS(String paramString)
  {
    ThreadManager.post(new WebSoPlugin.2(this, paramString), 5, null, false);
  }
  
  static class a
  {
    private WebSoService.WebSoState.WebSo3 a;
    private String aHx;
    
    private void a(svv paramsvv, String paramString, WebSoService.WebSoState.WebSo3 paramWebSo3)
    {
      if ((paramWebSo3 != null) && (!TextUtils.isEmpty(paramString))) {
        ardk.Wo("callJs");
      }
      try
      {
        paramsvv.callJs(paramString, new String[] { this.a.CL() });
        this.aHx = null;
        return;
      }
      catch (Exception paramsvv)
      {
        for (;;)
        {
          paramsvv.printStackTrace();
        }
      }
    }
    
    public WebSoService.WebSoState.WebSo3 a()
    {
      return this.a;
    }
    
    public void a(svv paramsvv, WebSoService.WebSoState.WebSo3 paramWebSo3)
    {
      ardk.Wo("setUpWebso3");
      this.a = paramWebSo3;
      a(paramsvv, this.aHx, this.a);
    }
    
    public void a(svv paramsvv, String paramString)
    {
      ardk.Wo("registerGetData");
      this.aHx = paramString;
      a(paramsvv, this.aHx, this.a);
    }
    
    public void bBo()
    {
      ardk.Wo("clearJsCallback");
      this.aHx = null;
      this.a = null;
    }
  }
  
  public class b
  {
    public volatile String aHy;
    public volatile boolean aNB;
    private CustomWebView webView;
    
    public b(CustomWebView paramCustomWebView)
    {
      this.webView = paramCustomWebView;
    }
    
    private void Gr()
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj doCallback body: " + this.aHy);
      }
      if (TextUtils.isEmpty(this.aHy)) {}
      while (this.webView == null) {
        return;
      }
      this.webView.callJs("window._websoPageData=" + this.aHy + "; if(window.silentCallback) {window.silentCallback(" + this.aHy + " );}");
      this.aHy = null;
    }
    
    @JavascriptInterface
    public void catchHtml(String paramString)
    {
      paramString = ardk.ql(paramString);
      ardk.Wo("catchHtml");
      WebSoService.WebSoState.WebSo3 localWebSo3 = svv.a(svv.this).a();
      if (localWebSo3 != null)
      {
        WebSoService.a(paramString, localWebSo3.eTag, localWebSo3.czZ, Uri.parse(localWebSo3.uri));
        return;
      }
      ardk.Wo("return webSo3 == null");
    }
    
    @JavascriptInterface
    public void didDOMContentLoaded()
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj didDOMContentLoaded.");
      }
      this.aNB = true;
      Gr();
    }
    
    @JavascriptInterface
    public void didEventFiredWithParams(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj didEventFiredWithParams, envent: " + paramString1 + " param: " + paramString2);
      }
    }
    
    public void tT(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj onDataLoaded: " + paramString);
      }
      this.aHy = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        Gr();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svv
 * JD-Core Version:    0.7.0.1
 */