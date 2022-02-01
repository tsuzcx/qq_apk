import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin.4;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class sux
  extends WebViewPlugin
{
  private Handler bA;
  private Handler bB;
  private String callback = "";
  private String proxyUrl;
  
  public sux()
  {
    this.mPluginNameSpace = "QzoneData";
  }
  
  public static boolean T(String paramString1, String paramString2)
  {
    return TextUtils.equals(getUrlHost(paramString1), getUrlHost(paramString2));
  }
  
  private static long a(WebViewPlugin.a parama)
  {
    if (parama == null) {
      return 0L;
    }
    try
    {
      long l = parama.getActivity().getIntent().getLongExtra("preAct_time", 0L);
      return l;
    }
    catch (Exception parama)
    {
      QLog.w("QzoneWebViewOfflinePlugin", 2, "can not get click time", parama);
    }
    return 0L;
  }
  
  private void a(arcz.b paramb, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramb == null) {
      return;
    }
    QLog.i("QzoneWebViewOfflinePlugin", 1, "state is " + paramb);
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        switch (paramb.reqState)
        {
        case 1: 
          if (!TextUtils.isEmpty(paramb.currentUrl)) {
            localJSONObject.put("url", paramb.currentUrl);
          }
          localJSONObject.put("code", paramb.resultCode);
          if (!TextUtils.isEmpty(paramb.errorMsg)) {
            localJSONObject.put("msg", paramb.errorMsg);
          }
          localJSONObject.put("dataIsBase64", paramb.cZc);
          if (TextUtils.isEmpty(paramb.czO)) {
            break label392;
          }
          if (!paramb.cZc) {
            break label383;
          }
          str = aqgo.encodeToString(paramb.czO.getBytes(), 0);
          localJSONObject.put("data", str);
          if (paramb.eeH > 0) {
            localJSONObject.put("httpStatusCode", paramb.eeH);
          }
          if (!TextUtils.isEmpty(paramb.header)) {
            localJSONObject.put("header", new JSONObject(paramb.header));
          }
          if (paramb.fF != null) {
            localJSONObject.put("userinfo", paramb.fF);
          }
          callJs(paramString, new String[] { localJSONObject.toString() });
          long l1 = System.currentTimeMillis();
          long l2 = paramb.startTime;
          QLog.i("QzoneWebViewOfflinePlugin", 1, "wnscgi@ status=" + paramb.reqState + ",total cost " + (l1 - l2) + " ms");
          return;
        }
      }
      catch (Exception paramb)
      {
        paramb.printStackTrace();
        return;
      }
      localJSONObject.put("status", 2);
      continue;
      localJSONObject.put("status", 4);
      continue;
      localJSONObject.put("status", 1);
      continue;
      localJSONObject.put("status", 100);
      continue;
      label383:
      String str = paramb.czO;
      continue;
      label392:
      localJSONObject.put("data", "");
    }
  }
  
  private static void a(String paramString, long paramLong, WebViewPlugin.a parama)
  {
    int i;
    long l;
    try
    {
      if (1 != QzoneConfig.getInstance().getConfig("QZoneSetting", "SmallGameHtmlLoadMtaReportEnable", 1)) {
        break label341;
      }
      i = 1;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneWebViewOfflinePlugin", 1, "reportMta error", paramString);
      return;
    }
    BaseApplication localBaseApplication;
    Properties localProperties;
    label198:
    String str1;
    if ((!TextUtils.isEmpty(paramString)) && (parama != null) && ((8589934594L == paramLong) || (8589934593L == paramLong)) && (paramString.equals(QzoneConfig.getInstance().getConfig("H5Url", "GameBar", "https://h5.qzone.qq.com/h5plus/homeV2/index/alpha?_proxy=1&_wv=3&via=qqnavigation.2017"))))
    {
      l = a(parama);
      if (l <= 0L)
      {
        QLog.w("QzoneWebViewOfflinePlugin", 1, "preAct_time is invalid, url = " + paramString);
        return;
      }
      l = System.currentTimeMillis() - l;
      localBaseApplication = BaseApplicationImpl.getContext();
      boolean bool = NetworkState.isWifiConn();
      if (QzoneOfflineCacheHelper.getSmallGameLastCacheTime(parama.a().getLongAccountUin()) <= 0L) {
        break label360;
      }
      i = 1;
      int j = Calendar.getInstance().get(11);
      localProperties = new Properties();
      localProperties.put("hour", String.valueOf(j));
      if (8589934594L != paramLong) {
        break label366;
      }
      paramString = "finish";
      if (!bool) {
        break label373;
      }
      str1 = "wifi";
    }
    for (;;)
    {
      label211:
      str1 = String.format("qzone_game_%s_%s_%s", new Object[] { paramString, str1, str2 });
      anol.a(localBaseApplication).reportTimeKVEvent(str1, localProperties, (int)l);
      if (8589934594L == paramLong) {}
      for (paramString = acfp.m(2131713545);; paramString = acfp.m(2131713546))
      {
        QLog.i("QzoneWebViewOfflinePlugin", 2, paramString + l + "ms,mta key=" + str1);
        if (8589934594L != paramLong) {
          break;
        }
        QzoneOfflineCacheHelper.updataSmallGameLastCacheFinishTime(parama.a().getLongAccountUin(), System.currentTimeMillis());
        return;
      }
      while (i == 0)
      {
        return;
        label341:
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label381;
        }
        str2 = "cache";
        break label211;
        label360:
        i = 0;
        break;
        label366:
        paramString = "start";
        break label198;
        label373:
        str1 = "mobile";
      }
      label381:
      String str2 = "nocache";
    }
  }
  
  private void e(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean)
      {
        paramString1 = QzoneZipCacheHelper.getFolderFileNameList(paramString1, paramString2);
        paramString2 = new JSONArray();
        if (paramString1 != null)
        {
          int j = paramString1.length;
          while (i < j)
          {
            paramString2.put(paramString1[i]);
            i += 1;
          }
        }
        localJSONObject.put("imageNameList", paramString2);
      }
      callJs(paramString3, new String[] { localJSONObject.toString() });
      if (QLog.isColorLevel()) {
        QLog.i("QzoneWebViewOfflinePlugin", 2, "QzoneData.offlineResourceIsCached callback :" + localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  private String getCurrentUrl()
  {
    String str = null;
    if (this.mRuntime != null) {}
    for (CustomWebView localCustomWebView = this.mRuntime.getWebView();; localCustomWebView = null)
    {
      if (localCustomWebView != null) {
        str = localCustomWebView.getUrl();
      }
      return str;
    }
  }
  
  public static String getUrlHost(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = new URL(paramString).getHost().toLowerCase();
        return paramString;
      }
      catch (Throwable paramString) {}
    }
    return null;
  }
  
  private Object m(String paramString)
  {
    CustomWebView localCustomWebView = null;
    Object localObject;
    if (this.mRuntime != null)
    {
      localObject = this.mRuntime.getActivity();
      if (localObject == null) {
        break label83;
      }
      localObject = ((Activity)localObject).getIntent();
      label27:
      if (localObject == null) {
        break label88;
      }
      localObject = ((Intent)localObject).getStringExtra("url");
      label38:
      if (this.mRuntime == null) {
        break label93;
      }
    }
    label83:
    label88:
    label93:
    for (AppInterface localAppInterface = this.mRuntime.a();; localAppInterface = null)
    {
      if (this.mRuntime != null) {
        localCustomWebView = this.mRuntime.getWebView();
      }
      return awfu.a(localAppInterface, localCustomWebView, paramString, (String)localObject);
      localObject = null;
      break;
      localObject = null;
      break label27;
      localObject = null;
      break label38;
    }
  }
  
  public static String o(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.getString(str1);
        localStringBuilder.append(URLEncoder.encode(str1, "UTF-8")).append("=").append(URLEncoder.encode(str2, "UTF-8"));
        localStringBuilder.append("&");
      }
      if (localStringBuilder.length() <= 0) {
        break label100;
      }
    }
    catch (Exception paramJSONObject)
    {
      return null;
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    label100:
    return localStringBuilder.toString();
  }
  
  private void u(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      QLog.d("QzoneWebViewOfflinePlugin", 1, "QzoneData.offlineResourceIsCached args is empty");
    }
    for (;;)
    {
      return;
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        String str1 = paramVarArgs.optString("zipurl");
        String str2 = paramVarArgs.optString("business");
        if (QzoneZipCacheHelper.isDangerousLocalPath(str2))
        {
          QLog.w("QzoneWebViewOfflinePlugin", 1, "handlePreDownloadZip business 参数错误。");
          return;
        }
        String str3 = paramVarArgs.optString("dir");
        if (QzoneZipCacheHelper.isDangerousLocalPath(str3))
        {
          QLog.w("QzoneWebViewOfflinePlugin", 1, "handlePreDownloadZip dir 参数错误。");
          return;
        }
        int i = paramVarArgs.getInt("count");
        String str4 = paramVarArgs.optString("callback");
        if ((str1 == null) || (str1.length() == 0))
        {
          QLog.w("QzoneWebViewOfflinePlugin", 1, "QzoneData.ResourceIsCached url is empty");
          return;
        }
        if ((str4 == null) || (str4.length() == 0))
        {
          QLog.w("QzoneWebViewOfflinePlugin", 1, "QzoneData.ResourceIsCached callback is empty");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QzoneWebViewOfflinePlugin", 2, "QzoneData.ResourceIsCached url: " + str1 + ",dir " + str3 + ",callback: " + str4);
        }
        if (this.mRuntime != null) {}
        for (paramVarArgs = this.mRuntime.a(); QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(paramVarArgs, str1, str2, str3, i, new suz(this, str2, str3, str4)); paramVarArgs = null)
        {
          e(true, str2, str3, str4);
          return;
        }
        return;
      }
      catch (Throwable paramVarArgs) {}
    }
  }
  
  private void x(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1))
    {
      QLog.d("QzoneWebViewOfflinePlugin", 1, "QzoneData.offlineResourceIsCached args is empty");
      return;
    }
    Object localObject;
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      paramVarArgs = ((JSONObject)localObject).optString("url");
      localObject = ((JSONObject)localObject).optString("callback");
      if ((paramVarArgs == null) || (paramVarArgs.length() == 0))
      {
        QLog.w("QzoneWebViewOfflinePlugin", 1, "QzoneData.offlineResourceIsCached url is empty");
        return;
      }
    }
    catch (Throwable paramVarArgs)
    {
      QLog.e("QzoneWebViewOfflinePlugin", 1, paramVarArgs, new Object[0]);
      return;
    }
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      QLog.w("QzoneWebViewOfflinePlugin", 1, "QzoneData.offlineResourceIsCached callback is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QzoneWebViewOfflinePlugin", 2, "QzoneData.offlineResourceIsCached url: " + paramVarArgs + ",callback: " + (String)localObject);
    }
    boolean bool = QzoneOfflineCacheHelper.checkFileIfExist(paramVarArgs);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("url", paramVarArgs);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      localJSONObject.put("hasData", i);
      callJs((String)localObject, new String[] { localJSONObject.toString() });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QzoneWebViewOfflinePlugin", 2, "QzoneData.offlineResourceIsCached callback :" + localJSONObject.toString());
      return;
    }
  }
  
  private void y(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1))
    {
      QLog.d("QzoneWebViewOfflinePlugin", 1, "QzoneData.handleWnsCgi args is empty");
      return;
    }
    arcz.a locala = new arcz.a();
    Object localObject2;
    try
    {
      localObject2 = new JSONObject(paramVarArgs[0]);
      locala.callback = ((JSONObject)localObject2).optString("callback");
      locala.url = ((JSONObject)localObject2).optString("url");
      if (TextUtils.isEmpty(locala.url)) {
        throw new Exception("url is empty!!!");
      }
    }
    catch (Exception localException)
    {
      QLog.w("QzoneWebViewOfflinePlugin", 1, "wnscgi error,args is " + paramVarArgs[0], localException);
      paramVarArgs = new arcz.b();
      paramVarArgs.currentUrl = locala.url;
      paramVarArgs.reqState = 3;
      paramVarArgs.resultCode = 101;
      paramVarArgs.errorMsg = localException.getMessage();
      paramVarArgs.czP = locala.callback;
      a(paramVarArgs, locala.callback);
      return;
    }
    if (!T(getCurrentUrl(), locala.url))
    {
      localObject1 = getUrlHost(getCurrentUrl());
      localObject2 = getUrlHost(locala.url);
      throw new Exception("not support for cross-domain request!!! current host=" + (String)localObject1 + ",req host=" + (String)localObject2);
    }
    locala.method = ((JSONObject)localObject2).optString("method");
    if ((!"GET".equalsIgnoreCase(locala.method)) && (!"POST".equalsIgnoreCase(locala.method))) {
      throw new Exception("no such method support!!!");
    }
    Object localObject1 = ((JSONObject)localObject2).opt("body");
    if ((localObject1 instanceof JSONObject)) {
      locala.contentType = "application/x-www-form-urlencoded";
    }
    for (locala.body = o((JSONObject)localObject1);; locala.body = localObject1.toString())
    {
      localObject1 = ((JSONObject)localObject2).opt("header");
      if ((localObject1 == null) || ((localObject1 instanceof JSONObject))) {
        break;
      }
      throw new Exception("header format error!!!");
      locala.contentType = null;
    }
    if (localObject1 != null) {}
    for (localObject1 = localObject1.toString();; localObject1 = null)
    {
      locala.jsonHeader = ((String)localObject1);
      locala.cZb = ((JSONObject)localObject2).optBoolean("dataNeedBase64", false);
      locala.timeout = ((int)(((JSONObject)localObject2).optDouble("timeout", 0.0D) * 1000.0D));
      locala.fF = ((JSONObject)localObject2).opt("userinfo");
      if (this.bB == null) {
        this.bB = new sva(this, Looper.getMainLooper());
      }
      if (arcz.a().a(locala, this.bB)) {
        break;
      }
      paramVarArgs = new arcz.b();
      paramVarArgs.currentUrl = locala.url;
      paramVarArgs.reqState = 1;
      paramVarArgs.resultCode = 101;
      paramVarArgs.errorMsg = "send req fail!";
      a(paramVarArgs, locala.callback);
      return;
    }
  }
  
  protected void a(arcz.b paramb)
  {
    a(paramb, paramb.czP);
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L)
    {
      if (this.mRuntime != null)
      {
        awfu.mWebView = new WeakReference(this.mRuntime.getWebView());
        awfu.mActivity = new WeakReference(this.mRuntime.getActivity());
      }
      return m(paramString);
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((8589934594L == paramLong) || (8589934593L == paramLong)) {
      QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QzoneWebViewOfflinePlugin.4(this, paramString, paramLong));
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"QzoneData".equals(paramString2)) {}
    do
    {
      return false;
      if ("offlineResourceIsCached".equalsIgnoreCase(paramString3))
      {
        x(paramVarArgs);
        return true;
      }
      if ("wnsCgi".equalsIgnoreCase(paramString3))
      {
        y(paramVarArgs);
        return true;
      }
      if ("PreDownloadZip".equalsIgnoreCase(paramString3))
      {
        u(paramVarArgs);
        return true;
      }
    } while ((!"offlineHttpProxy".equals(paramString3)) || (paramVarArgs.length != 1));
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      if ((paramJsBridgeListener.has("proxyUrl")) && (paramJsBridgeListener.has("isCheckCache")))
      {
        this.proxyUrl = paramJsBridgeListener.optString("proxyUrl");
        boolean bool = paramJsBridgeListener.getBoolean("isCheckCache");
        this.callback = paramJsBridgeListener.getString("callback");
        if ((bool) && (!TextUtils.isEmpty(ardk.qi(this.proxyUrl))))
        {
          if (TextUtils.isEmpty(this.callback)) {
            break label281;
          }
          callJs(this.callback + "({\"code\":0});");
          break label281;
        }
        if (this.bA == null) {
          this.bA = new suy(this, Looper.getMainLooper());
        }
        WebSoService.a().startWebSoRequestWithCheck(this.proxyUrl, this.bA);
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneWebViewOfflinePlugin", 2, "exception =" + paramJsBridgeListener);
        }
      }
    }
    return true;
    label281:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sux
 * JD-Core Version:    0.7.0.1
 */