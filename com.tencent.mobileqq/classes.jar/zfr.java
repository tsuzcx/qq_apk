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
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zfr
  extends WebViewPlugin
{
  private long jdField_a_of_type_Long;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<WebView> jdField_a_of_type_JavaLangRefWeakReference;
  red jdField_a_of_type_Red = null;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public zfr()
  {
    this.mPluginNameSpace = "readInJoyWebRender";
  }
  
  private Boolean a(String paramString)
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      ors.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, "shouldOfflineIntercept", 0, System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return Boolean.valueOf(false);
    }
    bejw localbejw = bejv.a(this.jdField_b_of_type_JavaLangString);
    if ((localbejw != null) && (!TextUtils.isEmpty(localbejw.jdField_b_of_type_JavaLangString)))
    {
      this.mRuntime.a().loadDataWithBaseURL(paramString, localbejw.jdField_b_of_type_JavaLangString, "text/html", "utf-8", paramString);
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyWebRenderPlugin", 2, "native_render  shouldOfflineIntercept offline data with cache transUrl = " + this.jdField_b_of_type_JavaLangString);
      }
      ors.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, "shouldOfflineIntercept", 1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return Boolean.valueOf(true);
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyWebRenderPlugin", 2, "native_render  shouldOfflineIntercept offline data no cache transUrl = " + this.jdField_b_of_type_JavaLangString);
    }
    return Boolean.valueOf(false);
  }
  
  private String a(String paramString)
  {
    String str = "";
    Object localObject = str;
    if (this.jdField_a_of_type_Red != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("bundle_params_render_url", paramString);
      paramString = this.jdField_a_of_type_Red.a("CMD_GET_WEB_RENDER_DATA", (Bundle)localObject);
      localObject = str;
      if (paramString != null) {
        localObject = paramString.getString("VALUE_WEB_RENDER_DATA");
      }
    }
    return localObject;
  }
  
  private void a(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    paramMap = a(paramString1);
    if (!TextUtils.isEmpty(paramMap))
    {
      this.mRuntime.a().loadDataWithBaseURL(paramString1, paramMap, "text/html", "utf-8", paramString1);
      this.jdField_a_of_type_Boolean = true;
      a(false);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyWebRenderPlugin", 2, "native_render load renderHtmlData data cache on eventType : " + paramString2);
      }
      paramString1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (!this.jdField_a_of_type_Boolean) {
        break label145;
      }
    }
    label145:
    for (int i = 1;; i = 0)
    {
      ors.a(paramString1, true, paramString2, i, System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ReadInJoyWebRenderPlugin", 2, "native_render load renderHtmlData data cache renderResult is empty on eventType:" + paramString2);
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (this.mRuntime == null) {}
    do
    {
      do
      {
        return;
        localObject = this.mRuntime.a();
      } while (!(localObject instanceof FragmentActivity));
      localObject = a((FragmentActivity)localObject);
    } while ((localObject == null) || (((WebViewFragment)localObject).a == null));
    if (((WebViewFragment)localObject).a.a != null)
    {
      bejh localbejh = ((WebViewFragment)localObject).a;
      if (!paramBoolean) {}
      for (bool = true;; bool = false)
      {
        localbejh.d = bool;
        ((WebViewFragment)localObject).a.a.a(paramBoolean);
        return;
      }
    }
    Object localObject = ((WebViewFragment)localObject).a;
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((bejh)localObject).d = paramBoolean;
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
  
  public boolean a(String paramString)
  {
    if (!bkbq.o(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
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
    if (!a(paramString)) {}
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyWebRenderPlugin", 2, "native_render handleEvent type: " + paramLong + "; timeStamp: " + System.currentTimeMillis() + "; isRender: " + this.jdField_a_of_type_Boolean + "; url:" + paramString);
        }
        if (paramLong == 32L)
        {
          a(paramString, "KEY_EVENT_BEFORE_LOAD", paramMap);
          if ((!bkbq.p(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) && (!this.jdField_a_of_type_Boolean)) {
            return a(paramString).booleanValue();
          }
          return this.jdField_a_of_type_Boolean;
        }
      } while ((paramLong != 8589934593L) || (!bkbq.p(this.jdField_a_of_type_ComTencentCommonAppAppInterface)));
      a(paramString, "EVENT_LOAD_START", paramMap);
    } while (this.jdField_a_of_type_Boolean);
    return a(paramString).booleanValue();
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      this.jdField_b_of_type_Boolean = bkbq.o(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if (this.jdField_a_of_type_Red == null) {
      this.jdField_a_of_type_Red = red.a();
    }
    if ((this.mRuntime != null) && (this.jdField_b_of_type_Boolean))
    {
      Activity localActivity = this.mRuntime.a();
      if ((localActivity instanceof FragmentActivity))
      {
        Object localObject = a((FragmentActivity)localActivity);
        if (localObject != null)
        {
          localObject = ((WebViewFragment)localObject).b();
          String str = Uri.parse((String)localObject).getQueryParameter("_pbid");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
          {
            this.jdField_b_of_type_JavaLangString = nbv.a((String)localObject, "_bid=" + str);
            ThreadManager.post(new ReadInJoyWebRenderPlugin.1(this), 5, null, true);
          }
        }
      }
      this.jdField_a_of_type_Long = localActivity.getIntent().getLongExtra("bundle_param_click_time", System.currentTimeMillis());
      ors.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, "REPORT_EVENT_CREATE", 0, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Red != null) {
      this.jdField_a_of_type_Red = null;
    }
    super.onDestroy();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.mRuntime.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zfr
 * JD-Core Version:    0.7.0.1
 */