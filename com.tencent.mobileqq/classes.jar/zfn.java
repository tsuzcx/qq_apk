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

public class zfn
  extends WebViewPlugin
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private String jdField_b_of_type_JavaLangString = "";
  
  public zfn()
  {
    this.mPluginNameSpace = "QzoneData";
  }
  
  private static long a(begz parambegz)
  {
    if (parambegz == null) {
      return 0L;
    }
    try
    {
      long l = parambegz.a().getIntent().getLongExtra("preAct_time", 0L);
      return l;
    }
    catch (Exception parambegz)
    {
      QLog.w("QzoneWebViewOfflinePlugin", 2, "can not get click time", parambegz);
    }
    return 0L;
  }
  
  private Object a(String paramString)
  {
    CustomWebView localCustomWebView = null;
    Object localObject;
    if (this.mRuntime != null)
    {
      localObject = this.mRuntime.a();
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
        localCustomWebView = this.mRuntime.a();
      }
      return bjyd.a(localAppInterface, localCustomWebView, paramString, (String)localObject);
      localObject = null;
      break;
      localObject = null;
      break label27;
      localObject = null;
      break label38;
    }
  }
  
  private String a()
  {
    String str = null;
    if (this.mRuntime != null) {}
    for (CustomWebView localCustomWebView = this.mRuntime.a();; localCustomWebView = null)
    {
      if (localCustomWebView != null) {
        str = localCustomWebView.getUrl();
      }
      return str;
    }
  }
  
  public static String a(String paramString)
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
  
  public static String a(JSONObject paramJSONObject)
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
        break label96;
      }
    }
    catch (Exception paramJSONObject)
    {
      return null;
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    label96:
    return localStringBuilder.toString();
  }
  
  private void a(bekq parambekq, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (parambekq == null) {
      return;
    }
    QLog.i("QzoneWebViewOfflinePlugin", 1, "state is " + parambekq);
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        switch (parambekq.jdField_a_of_type_Int)
        {
        case 1: 
          if (!TextUtils.isEmpty(parambekq.jdField_b_of_type_JavaLangString)) {
            localJSONObject.put("url", parambekq.jdField_b_of_type_JavaLangString);
          }
          localJSONObject.put("code", parambekq.jdField_c_of_type_Int);
          if (!TextUtils.isEmpty(parambekq.f)) {
            localJSONObject.put("msg", parambekq.f);
          }
          localJSONObject.put("dataIsBase64", parambekq.jdField_a_of_type_Boolean);
          if (TextUtils.isEmpty(parambekq.d)) {
            break label392;
          }
          if (!parambekq.jdField_a_of_type_Boolean) {
            break label383;
          }
          str = bdfr.encodeToString(parambekq.d.getBytes(), 0);
          localJSONObject.put("data", str);
          if (parambekq.jdField_b_of_type_Int > 0) {
            localJSONObject.put("httpStatusCode", parambekq.jdField_b_of_type_Int);
          }
          if (!TextUtils.isEmpty(parambekq.jdField_c_of_type_JavaLangString)) {
            localJSONObject.put("header", new JSONObject(parambekq.jdField_c_of_type_JavaLangString));
          }
          if (parambekq.jdField_a_of_type_JavaLangObject != null) {
            localJSONObject.put("userinfo", parambekq.jdField_a_of_type_JavaLangObject);
          }
          callJs(paramString, new String[] { localJSONObject.toString() });
          long l1 = System.currentTimeMillis();
          long l2 = parambekq.jdField_a_of_type_Long;
          QLog.i("QzoneWebViewOfflinePlugin", 1, "wnscgi@ status=" + parambekq.jdField_a_of_type_Int + ",total cost " + (l1 - l2) + " ms");
          return;
        }
      }
      catch (Exception parambekq)
      {
        parambekq.printStackTrace();
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
      String str = parambekq.d;
      continue;
      label392:
      localJSONObject.put("data", "");
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
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
  
  private void a(String... paramVarArgs)
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
        for (paramVarArgs = this.mRuntime.a(); QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(paramVarArgs, str1, str2, str3, i, new zfp(this, str2, str3, str4)); paramVarArgs = null)
        {
          a(true, str2, str3, str4);
          return;
        }
        return;
      }
      catch (Throwable paramVarArgs) {}
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return TextUtils.equals(a(paramString1), a(paramString2));
  }
  
  private static void b(String paramString, long paramLong, begz parambegz)
  {
    int i;
    long l;
    try
    {
      if (1 != QzoneConfig.getInstance().getConfig("QZoneSetting", "SmallGameHtmlLoadMtaReportEnable", 1)) {
        break label348;
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
    label205:
    String str1;
    if ((!TextUtils.isEmpty(paramString)) && (parambegz != null) && ((8589934594L == paramLong) || (8589934593L == paramLong)) && (paramString.equals(QzoneConfig.getInstance().getConfig("H5Url", "GameBar", "https://h5.qzone.qq.com/h5plus/homeV2/index/alpha?_proxy=1&_wv=3&via=qqnavigation.2017"))))
    {
      l = a(parambegz);
      if (l <= 0L)
      {
        QLog.w("QzoneWebViewOfflinePlugin", 1, "preAct_time is invalid, url = " + paramString);
        return;
      }
      l = System.currentTimeMillis() - l;
      localBaseApplication = BaseApplicationImpl.getContext();
      boolean bool = NetworkState.isWifiConn();
      if (QzoneOfflineCacheHelper.getSmallGameLastCacheTime(parambegz.a().getLongAccountUin()) <= 0L) {
        break label367;
      }
      i = 1;
      int j = Calendar.getInstance().get(11);
      localProperties = new Properties();
      localProperties.put("hour", String.valueOf(j));
      if (8589934594L != paramLong) {
        break label373;
      }
      paramString = "finish";
      if (!bool) {
        break label380;
      }
      str1 = "wifi";
    }
    for (;;)
    {
      label218:
      str1 = String.format("qzone_game_%s_%s_%s", new Object[] { paramString, str1, str2 });
      azqh.a(localBaseApplication).reportTimeKVEvent(str1, localProperties, (int)l);
      if (8589934594L == paramLong) {}
      for (paramString = alud.a(2131713014);; paramString = alud.a(2131713015))
      {
        QLog.i("QzoneWebViewOfflinePlugin", 2, paramString + l + "ms,mta key=" + str1);
        if (8589934594L != paramLong) {
          break;
        }
        QzoneOfflineCacheHelper.updataSmallGameLastCacheFinishTime(parambegz.a().getLongAccountUin(), System.currentTimeMillis());
        return;
      }
      while (i == 0)
      {
        return;
        label348:
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label388;
        }
        str2 = "cache";
        break label218;
        label367:
        i = 0;
        break;
        label373:
        paramString = "start";
        break label205;
        label380:
        str1 = "mobile";
      }
      label388:
      String str2 = "nocache";
    }
  }
  
  private void b(String... paramVarArgs)
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
  
  private void c(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1))
    {
      QLog.d("QzoneWebViewOfflinePlugin", 1, "QzoneData.handleWnsCgi args is empty");
      return;
    }
    bekp localbekp = new bekp();
    Object localObject2;
    try
    {
      localObject2 = new JSONObject(paramVarArgs[0]);
      localbekp.f = ((JSONObject)localObject2).optString("callback");
      localbekp.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("url");
      if (TextUtils.isEmpty(localbekp.jdField_a_of_type_JavaLangString)) {
        throw new Exception("url is empty!!!");
      }
    }
    catch (Exception localException)
    {
      QLog.w("QzoneWebViewOfflinePlugin", 1, "wnscgi error,args is " + paramVarArgs[0], localException);
      paramVarArgs = new bekq();
      paramVarArgs.jdField_b_of_type_JavaLangString = localbekp.jdField_a_of_type_JavaLangString;
      paramVarArgs.jdField_a_of_type_Int = 3;
      paramVarArgs.jdField_c_of_type_Int = 101;
      paramVarArgs.f = localException.getMessage();
      paramVarArgs.e = localbekp.f;
      a(paramVarArgs, localbekp.f);
      return;
    }
    if (!a(a(), localbekp.jdField_a_of_type_JavaLangString))
    {
      localObject1 = a(a());
      localObject2 = a(localbekp.jdField_a_of_type_JavaLangString);
      throw new Exception("not support for cross-domain request!!! current host=" + (String)localObject1 + ",req host=" + (String)localObject2);
    }
    localbekp.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("method");
    if ((!"GET".equalsIgnoreCase(localbekp.jdField_b_of_type_JavaLangString)) && (!"POST".equalsIgnoreCase(localbekp.jdField_b_of_type_JavaLangString))) {
      throw new Exception("no such method support!!!");
    }
    Object localObject1 = ((JSONObject)localObject2).opt("body");
    if ((localObject1 instanceof JSONObject)) {
      localbekp.e = "application/x-www-form-urlencoded";
    }
    for (localbekp.d = a((JSONObject)localObject1);; localbekp.d = localObject1.toString())
    {
      localObject1 = ((JSONObject)localObject2).opt("header");
      if ((localObject1 == null) || ((localObject1 instanceof JSONObject))) {
        break;
      }
      throw new Exception("header format error!!!");
      localbekp.e = null;
    }
    if (localObject1 != null) {}
    for (localObject1 = localObject1.toString();; localObject1 = null)
    {
      localbekp.jdField_c_of_type_JavaLangString = ((String)localObject1);
      localbekp.jdField_a_of_type_Boolean = ((JSONObject)localObject2).optBoolean("dataNeedBase64", false);
      localbekp.jdField_a_of_type_Int = ((int)(((JSONObject)localObject2).optDouble("timeout", 0.0D) * 1000.0D));
      localbekp.jdField_a_of_type_JavaLangObject = ((JSONObject)localObject2).opt("userinfo");
      if (this.jdField_b_of_type_AndroidOsHandler == null) {
        this.jdField_b_of_type_AndroidOsHandler = new zfq(this, Looper.getMainLooper());
      }
      if (beko.a().a(localbekp, this.jdField_b_of_type_AndroidOsHandler)) {
        break;
      }
      paramVarArgs = new bekq();
      paramVarArgs.jdField_b_of_type_JavaLangString = localbekp.jdField_a_of_type_JavaLangString;
      paramVarArgs.jdField_a_of_type_Int = 1;
      paramVarArgs.jdField_c_of_type_Int = 101;
      paramVarArgs.f = "send req fail!";
      a(paramVarArgs, localbekp.f);
      return;
    }
  }
  
  protected void a(bekq parambekq)
  {
    a(parambekq, parambekq.e);
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L)
    {
      if (this.mRuntime != null)
      {
        bjyd.a = new WeakReference(this.mRuntime.a());
        bjyd.b = new WeakReference(this.mRuntime.a());
      }
      return a(paramString);
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
        b(paramVarArgs);
        return true;
      }
      if ("wnsCgi".equalsIgnoreCase(paramString3))
      {
        c(paramVarArgs);
        return true;
      }
      if ("PreDownloadZip".equalsIgnoreCase(paramString3))
      {
        a(paramVarArgs);
        return true;
      }
    } while ((!"offlineHttpProxy".equals(paramString3)) || (paramVarArgs.length != 1));
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      if ((paramJsBridgeListener.has("proxyUrl")) && (paramJsBridgeListener.has("isCheckCache")))
      {
        this.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("proxyUrl");
        boolean bool = paramJsBridgeListener.getBoolean("isCheckCache");
        this.jdField_b_of_type_JavaLangString = paramJsBridgeListener.getString("callback");
        if ((bool) && (!TextUtils.isEmpty(belc.d(this.jdField_a_of_type_JavaLangString))))
        {
          if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            break label281;
          }
          callJs(this.jdField_b_of_type_JavaLangString + "({\"code\":0});");
          break label281;
        }
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new zfo(this, Looper.getMainLooper());
        }
        WebSoService.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsHandler);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zfn
 * JD-Core Version:    0.7.0.1
 */