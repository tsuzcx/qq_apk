package com.tencent.open.appcommon.js;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpInterface
  extends BaseInterface
{
  protected static final String LOG_TAG = "HttpInterface";
  protected ArrayList asyncTaskList;
  protected Handler mHandler = new WebviewHandler();
  protected WeakReference mWebViewRef;
  protected WebView webView;
  
  public HttpInterface(Activity paramActivity, WebView paramWebView)
  {
    this.webView = paramWebView;
    this.mWebViewRef = new WeakReference(paramWebView);
    this.asyncTaskList = new ArrayList();
  }
  
  @TargetApi(11)
  protected void aSyncTaskExecute(HttpCgiAsyncTask paramHttpCgiAsyncTask, Bundle paramBundle)
  {
    Executor localExecutor = obtainMultiExecutor();
    if (localExecutor != null)
    {
      paramHttpCgiAsyncTask.executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    paramHttpCgiAsyncTask.execute(new Bundle[] { paramBundle });
  }
  
  public void clearWebViewCache()
  {
    try
    {
      if (this.webView != null) {
        this.webView.clearCache(true);
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a("HttpInterface", "clearWebViewCache>>>", localException);
    }
  }
  
  public void destroy()
  {
    int j = this.asyncTaskList.size();
    int i = 0;
    while (i < j)
    {
      AsyncTask localAsyncTask = (AsyncTask)this.asyncTaskList.get(i);
      if ((localAsyncTask != null) && (!localAsyncTask.isCancelled()))
      {
        LogUtility.c("HttpInterface", "cancel AsyncTask when onDestory");
        localAsyncTask.cancel(true);
        if ((localAsyncTask instanceof HttpCgiAsyncTask)) {
          ((HttpCgiAsyncTask)localAsyncTask).b();
        }
      }
      i += 1;
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
  }
  
  public String getInterfaceName()
  {
    return "qzone_http";
  }
  
  public void httpRequest(String paramString)
  {
    boolean bool = true;
    if (!hasRight())
    {
      LogUtility.c("HttpInterface", ">>httpReauest has not right>>");
      return;
    }
    LogUtility.c("HttpInterface", "httpRequest >>> " + paramString.toString());
    try
    {
      localJSONObject = new JSONObject(paramString);
      localObject1 = localJSONObject.optString("guid");
      str1 = localJSONObject.optString("url");
      str2 = localJSONObject.optString("method");
      str3 = localJSONObject.optString("oncomplate");
      str4 = localJSONObject.optString("onerror");
      if (localJSONObject.optInt("supportetag", 1) != 1) {
        break label328;
      }
      i = 1;
    }
    catch (JSONException paramString)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      int i;
      for (;;)
      {
        JSONObject localJSONObject;
        Iterator localIterator;
        LogUtility.c("HttpInterface", "httpRequest JSONException", paramString);
        return;
        i = 0;
        continue;
        bool = false;
      }
      if (i == 0) {
        break label360;
      }
      paramString.putString("needhttpcache", "");
      LogUtility.c("HttpInterface", "use supportEtag");
      LogUtility.c("HttpInterface", "execute asyncTask url >>> " + str1 + " methodName " + str2);
      Object localObject1 = new HttpCgiAsyncTask(str1, str2, new HttpInterface.JsHttpCallback(this, (WebView)this.mWebViewRef.get(), (String)localObject1, str3, str4, bool));
      aSyncTaskExecute((HttpCgiAsyncTask)localObject1, paramString);
      this.asyncTaskList.add(localObject1);
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("HttpInterface", "httpRequest Exception", paramString);
    }
    if (localJSONObject.optInt("from_h5", 0) == 1)
    {
      paramString = new Bundle();
      paramString.putBoolean("from_h5", bool);
      paramString.putString("platform", CommonDataAdapter.a().g());
      paramString.putString("keystr", CommonDataAdapter.a().a());
      paramString.putString("uin", String.valueOf(CommonDataAdapter.a().a()));
      paramString.putString("resolution", MobileInfoUtil.e());
      paramString.putString("keytype", "256");
      if (!str2.equals("POST")) {
        break label338;
      }
      localJSONObject = localJSONObject.optJSONObject("params");
      if (localJSONObject == null) {
        break label360;
      }
      localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str5 = localIterator.next().toString();
        Object localObject2 = localJSONObject.get(str5);
        LogUtility.c("HttpInterface", "key = " + str5 + " value = " + localObject2.toString());
        if (!TextUtils.isEmpty(str5)) {
          paramString.putString(str5, localObject2.toString());
        }
      }
    }
    label328:
    label338:
    label360:
    return;
  }
  
  @TargetApi(11)
  protected Executor obtainMultiExecutor()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return ThreadManager.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.HttpInterface
 * JD-Core Version:    0.7.0.1
 */