import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.ReadInJoyWebRenderPlugin.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class svb
  extends WebViewPlugin
{
  private long DD;
  private String aHb;
  private boolean aNo;
  private boolean aNp;
  muw c = null;
  private AppInterface mApp;
  private String mUin;
  private WeakReference<WebView> mWebView;
  
  public svb()
  {
    this.mPluginNameSpace = "readInJoyWebRender";
  }
  
  private Boolean b(String paramString)
  {
    if (TextUtils.isEmpty(this.aHb))
    {
      kxm.a(this.mApp, true, "shouldOfflineIntercept", 0, System.currentTimeMillis() - this.DD);
      return Boolean.valueOf(false);
    }
    arcm.a locala = arcm.a(this.aHb);
    if ((locala != null) && (!TextUtils.isEmpty(locala.data)))
    {
      this.mRuntime.getWebView().loadDataWithBaseURL(paramString, locala.data, "text/html", "utf-8", paramString);
      this.aNo = true;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyWebRenderPlugin", 2, "native_render  shouldOfflineIntercept offline data with cache transUrl = " + this.aHb);
      }
      kxm.a(this.mApp, true, "shouldOfflineIntercept", 1, System.currentTimeMillis() - this.DD);
      return Boolean.valueOf(true);
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyWebRenderPlugin", 2, "native_render  shouldOfflineIntercept offline data no cache transUrl = " + this.aHb);
    }
    return Boolean.valueOf(false);
  }
  
  private void c(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    if (this.aNo) {
      return;
    }
    paramMap = gO(paramString1);
    if (!TextUtils.isEmpty(paramMap))
    {
      this.mRuntime.getWebView().loadDataWithBaseURL(paramString1, paramMap, "text/html", "utf-8", paramString1);
      this.aNo = true;
      vd(false);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyWebRenderPlugin", 2, "native_render load renderHtmlData data cache on eventType : " + paramString2);
      }
      paramString1 = this.mApp;
      if (!this.aNo) {
        break label145;
      }
    }
    label145:
    for (int i = 1;; i = 0)
    {
      kxm.a(paramString1, true, paramString2, i, System.currentTimeMillis() - this.DD);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ReadInJoyWebRenderPlugin", 2, "native_render load renderHtmlData data cache renderResult is empty on eventType:" + paramString2);
      break;
    }
  }
  
  private String gO(String paramString)
  {
    String str = "";
    Object localObject = str;
    if (this.c != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("bundle_params_render_url", paramString);
      paramString = this.c.b("CMD_GET_WEB_RENDER_DATA", (Bundle)localObject);
      localObject = str;
      if (paramString != null) {
        localObject = paramString.getString("VALUE_WEB_RENDER_DATA");
      }
    }
    return localObject;
  }
  
  private void vd(boolean paramBoolean)
  {
    boolean bool = true;
    if (this.mRuntime == null) {}
    do
    {
      do
      {
        return;
        localObject = this.mRuntime.getActivity();
      } while (!(localObject instanceof FragmentActivity));
      localObject = a((FragmentActivity)localObject);
    } while ((localObject == null) || (((WebViewFragment)localObject).a == null));
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
    Object localObject = ((WebViewFragment)localObject).a;
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((arcd)localObject).cYk = paramBoolean;
      return;
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
  
  public boolean gg(String paramString)
  {
    if (!awit.D(this.mApp)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyWebRenderPlugin", 2, "native_render shouldIntercept  getWebRenderConfig false");
      }
    }
    for (;;)
    {
      return false;
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          Object localObject1 = new URL(paramString);
          String str = ((URL)localObject1).getHost();
          localObject1 = ((URL)localObject1).getPath();
          Object localObject2 = Uri.parse(paramString);
          if ((localObject2 != null) && (((Uri)localObject2).isHierarchical()))
          {
            paramString = ((Uri)localObject2).getQueryParameter("_prenr");
            localObject2 = ((Uri)localObject2).getQueryParameter("_pbid");
            if (("kandian.qq.com".equalsIgnoreCase(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject1).endsWith(".html")))
            {
              boolean bool = "1".equals(paramString);
              if (bool) {
                return true;
              }
            }
          }
        }
        catch (MalformedURLException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (!gg(paramString)) {}
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyWebRenderPlugin", 2, "native_render handleEvent type: " + paramLong + "; timeStamp: " + System.currentTimeMillis() + "; isRender: " + this.aNo + "; url:" + paramString);
        }
        if (paramLong == 32L)
        {
          c(paramString, "KEY_EVENT_BEFORE_LOAD", paramMap);
          if ((!awit.E(this.mApp)) && (!this.aNo)) {
            return b(paramString).booleanValue();
          }
          return this.aNo;
        }
      } while ((paramLong != 8589934593L) || (!awit.E(this.mApp)));
      c(paramString, "EVENT_LOAD_START", paramMap);
    } while (this.aNo);
    return b(paramString).booleanValue();
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.mApp = this.mRuntime.a();
      this.mUin = this.mApp.getAccount();
      this.aNp = awit.D(this.mApp);
    }
    if (this.c == null) {
      this.c = muw.a();
    }
    if ((this.mRuntime != null) && (this.aNp))
    {
      Activity localActivity = this.mRuntime.getActivity();
      if ((localActivity instanceof FragmentActivity))
      {
        Object localObject = a((FragmentActivity)localActivity);
        if (localObject != null)
        {
          localObject = ((WebViewFragment)localObject).getCurrentUrl();
          String str = Uri.parse((String)localObject).getQueryParameter("_pbid");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
          {
            this.aHb = jpa.r((String)localObject, "_bid=" + str);
            ThreadManager.post(new ReadInJoyWebRenderPlugin.1(this), 5, null, true);
          }
        }
      }
      this.DD = localActivity.getIntent().getLongExtra("bundle_param_click_time", System.currentTimeMillis());
      kxm.a(this.mApp, true, "REPORT_EVENT_CREATE", 0, System.currentTimeMillis() - this.DD);
    }
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c = null;
    }
    super.onDestroy();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.mWebView = new WeakReference(this.mRuntime.getWebView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svb
 * JD-Core Version:    0.7.0.1
 */