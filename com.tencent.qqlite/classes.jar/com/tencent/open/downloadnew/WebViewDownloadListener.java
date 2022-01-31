package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.smtt.sdk.WebView;
import ffx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewDownloadListener
  implements DownloadListener
{
  protected static WebViewDownloadListener a;
  public static final String a;
  protected Handler a;
  
  static
  {
    jdField_a_of_type_JavaLangString = WebViewDownloadListener.class.getName();
  }
  
  protected WebViewDownloadListener()
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static WebViewDownloadListener a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewWebViewDownloadListener == null) {
      jdField_a_of_type_ComTencentOpenDownloadnewWebViewDownloadListener = new WebViewDownloadListener();
    }
    return jdField_a_of_type_ComTencentOpenDownloadnewWebViewDownloadListener;
  }
  
  protected String a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("pro", paramInt2);
      localJSONObject.put("ismyapp", paramInt3);
      localJSONObject.put("errorMsg", paramString3);
      localJSONObject.put("errorCode", paramInt4);
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "getCallBackJsonObject >>> ", paramString1);
      }
    }
  }
  
  protected String a(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt);
      localJSONObject.put("pro", 0);
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "getCallBackJsonObject >>> ", paramString1);
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(paramDownloadInfo.a().toString());
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (paramDownloadInfo != null) {
      a(a(paramDownloadInfo.b, paramInt2, paramDownloadInfo.k, paramDownloadInfo.d, paramDownloadInfo.h, paramString, paramInt1));
    }
  }
  
  protected void a(String paramString)
  {
    JsCallbackManager localJsCallbackManager = JsCallbackManager.a();
    for (;;)
    {
      int i;
      try
      {
        int j = localJsCallbackManager.a().size();
        i = 0;
        if (i < j)
        {
          Object localObject = (IJsCallBack)localJsCallbackManager.a().get(i);
          WebView localWebView = ((IJsCallBack)localObject).getWebview();
          if (localWebView != null) {
            if (TextUtils.isEmpty(((IJsCallBack)localObject).getJsCallbackMethod()))
            {
              localObject = "javascript:QzoneApp.fire('loadProcess'," + paramString + ");void(0);";
              LogUtility.a(jdField_a_of_type_JavaLangString, "commonJsCallBack >>> " + (String)localObject);
              this.jdField_a_of_type_AndroidOsHandler.post(new ffx(this, localWebView, (String)localObject));
            }
            else
            {
              localObject = "javascript:" + ((IJsCallBack)localObject).getJsCallbackMethod() + "(" + paramString + ")";
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "doJsCallback >>> ", paramString);
      }
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(a(paramString1, 6, paramString2));
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(((DownloadInfo)paramList.next()).a());
      }
      a(localJSONArray.toString());
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(paramDownloadInfo.a().toString());
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(a(paramString1, 9, paramString2));
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(paramDownloadInfo.a().toString());
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    a(a(paramString1, 13, paramString2));
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(paramDownloadInfo.a().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.WebViewDownloadListener
 * JD-Core Version:    0.7.0.1
 */