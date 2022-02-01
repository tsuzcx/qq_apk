package com.tencent.open.appcommon.js;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import aroi;
import aruv;
import aruw;
import arwt;
import arxh;
import arxh.a;
import arxr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpInterface
  extends BaseInterface
{
  public static final String PLUGIN_NAMESPACE = "qzone_http";
  private static final String TAG = "HttpInterface";
  protected ArrayList<AsyncTask<Bundle, Void, HashMap<String, Object>>> asyncTaskList;
  protected Handler mHandler = new aruw();
  protected WeakReference<WebView> mWebViewRef;
  protected WebView webView;
  
  public HttpInterface(Activity paramActivity, WebView paramWebView)
  {
    this.webView = paramWebView;
    this.mWebViewRef = new WeakReference(paramWebView);
    this.asyncTaskList = new ArrayList();
  }
  
  @TargetApi(11)
  protected void aSyncTaskExecute(arxh paramarxh, Bundle paramBundle)
  {
    Executor localExecutor = obtainMultiExecutor();
    if (localExecutor != null)
    {
      paramarxh.executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    paramarxh.execute(new Bundle[] { paramBundle });
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
      arwt.d("HttpInterface", "clearWebViewCache>>>", localException);
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
        arwt.d("HttpInterface", "cancel AsyncTask when onDestory");
        localAsyncTask.cancel(true);
        if ((localAsyncTask instanceof arxh)) {
          ((arxh)localAsyncTask).clearCallback();
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
      arwt.d("HttpInterface", ">>httpReauest has not right>>");
      return;
    }
    arwt.d("HttpInterface", "httpRequest >>> " + paramString.toString());
    try
    {
      localJSONObject = new JSONObject(paramString);
      localObject1 = localJSONObject.optString("guid");
      str1 = localJSONObject.optString("url");
      str2 = localJSONObject.optString("method");
      str3 = localJSONObject.optString("oncomplate");
      str4 = localJSONObject.optString("onerror");
      if (localJSONObject.optInt("supportetag", 1) != 1) {
        break label329;
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
        arwt.e("HttpInterface", "httpRequest JSONException", paramString);
        return;
        i = 0;
        continue;
        bool = false;
      }
      if (i == 0) {
        break label361;
      }
      paramString.putString("needhttpcache", "");
      arwt.d("HttpInterface", "use supportEtag");
      arwt.d("HttpInterface", "execute asyncTask url >>> " + str1 + " methodName " + str2);
      Object localObject1 = new arxh(str1, str2, new a((WebView)this.mWebViewRef.get(), (String)localObject1, str3, str4, bool));
      aSyncTaskExecute((arxh)localObject1, paramString);
      this.asyncTaskList.add(localObject1);
      return;
    }
    catch (Exception paramString)
    {
      arwt.e("HttpInterface", "httpRequest Exception", paramString);
    }
    if (localJSONObject.optInt("from_h5", 0) == 1)
    {
      paramString = new Bundle();
      paramString.putBoolean("from_h5", bool);
      paramString.putString("platform", aroi.a().getPlatform());
      paramString.putString("keystr", aroi.a().getSkey());
      paramString.putString("uin", String.valueOf(aroi.a().getUin()));
      paramString.putString("resolution", arxr.getResolution());
      paramString.putString("keytype", "256");
      if (!str2.equals("POST")) {
        break label339;
      }
      localJSONObject = localJSONObject.optJSONObject("params");
      if (localJSONObject == null) {
        break label361;
      }
      localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str5 = localIterator.next().toString();
        Object localObject2 = localJSONObject.get(str5);
        arwt.d("HttpInterface", "key = " + str5 + " value = " + localObject2.toString());
        if (!TextUtils.isEmpty(str5)) {
          paramString.putString(str5, localObject2.toString());
        }
      }
    }
    label329:
    label339:
    label361:
    return;
  }
  
  @TargetApi(11)
  protected Executor obtainMultiExecutor()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return ThreadManager.getNetExcutor();
    }
    return null;
  }
  
  public class a
    implements arxh.a
  {
    protected final String cCA;
    protected final String cCz;
    protected final boolean dde;
    protected final String guid;
    protected final WebView webView;
    
    public a(WebView paramWebView, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      this.webView = paramWebView;
      this.cCA = paramString3;
      this.cCz = paramString2;
      this.guid = paramString1;
      this.dde = paramBoolean;
    }
    
    public void ai(JSONObject paramJSONObject)
    {
      if ((!HttpInterface.this.hasRight()) || (HttpInterface.this.mHandler == null)) {
        return;
      }
      JSONObject localJSONObject = paramJSONObject;
      if (paramJSONObject == null) {
        localJSONObject = new JSONObject();
      }
      Message localMessage = HttpInterface.this.mHandler.obtainMessage(0);
      localaruv = new aruv();
      localaruv.webView = this.webView;
      localMessage.obj = localaruv;
      localMessage.arg1 = 0;
      for (;;)
      {
        try
        {
          if (!this.dde) {
            continue;
          }
          localJSONObject.put("guid", this.guid);
          paramJSONObject = localJSONObject.toString();
          arwt.v("HttpInterface", "onResult >>> " + paramJSONObject);
          if (!TextUtils.isEmpty(this.cCz)) {
            continue;
          }
          localaruv.cCD = ("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpSuccess'," + paramJSONObject + ");}void(0);");
        }
        catch (JSONException paramJSONObject)
        {
          if (!TextUtils.isEmpty(this.cCA)) {
            continue;
          }
          localaruv.cCD = ("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.guid + "\"});}void(0);");
          continue;
          localaruv.cCD = ("javascript:" + this.cCA + "({\"guid\":\"" + this.guid + "\",\"err\":\"json format error\"});void(0);");
          continue;
        }
        HttpInterface.this.mHandler.sendMessage(localMessage);
        return;
        paramJSONObject = new JSONObject();
        paramJSONObject.put("guid", this.guid);
        paramJSONObject.put("content", localJSONObject.toString());
        paramJSONObject = paramJSONObject.toString();
        continue;
        localaruv.cCD = ("javascript:" + this.cCz + "(" + paramJSONObject + ");void(0);");
      }
    }
    
    public void onException(Exception paramException)
    {
      if ((!HttpInterface.this.hasRight()) || (HttpInterface.this.mHandler == null)) {
        return;
      }
      arwt.d("HttpInterface", "onException >>> ");
      paramException = HttpInterface.this.mHandler.obtainMessage(0);
      aruv localaruv = new aruv();
      localaruv.webView = this.webView;
      paramException.obj = localaruv;
      paramException.arg1 = 0;
      if (TextUtils.isEmpty(this.cCA)) {}
      for (localaruv.cCD = ("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.guid + "\"});}void(0);");; localaruv.cCD = ("javascript:" + this.cCA + "({\"guid\":\"" + this.guid + "\",\"err\":\"\"});void(0);"))
      {
        HttpInterface.this.mHandler.sendMessage(paramException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.HttpInterface
 * JD-Core Version:    0.7.0.1
 */