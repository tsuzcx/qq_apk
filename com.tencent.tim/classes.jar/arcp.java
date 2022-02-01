import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class arcp
{
  public static Bundle a(WebViewFragment paramWebViewFragment, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    Object localObject = Uri.parse(paramWebViewFragment.mUrl);
    paramIntent = localBundle;
    if (localObject != null)
    {
      localObject = ((Uri)localObject).getHost();
      paramIntent = localBundle;
      if (Build.VERSION.SDK_INT >= 19) {
        if (!ocp.eA((String)localObject))
        {
          paramIntent = localBundle;
          if (!"buluo.qq.com".equalsIgnoreCase((String)localObject)) {}
        }
        else
        {
          paramWebViewFragment.j.evaluateJavascript("document.querySelector(\"meta[itemprop='name']\").getAttribute('content')", new arcq(paramWebViewFragment));
          paramIntent = null;
        }
      }
    }
    return paramIntent;
  }
  
  public static boolean aGj()
  {
    return BaseApplication.getContext().getSharedPreferences("webview_report_config", 0).getBoolean("hide_back_text", false);
  }
  
  public static boolean aGk()
  {
    int i = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[14].intValue();
    QLog.d("SwiftWebViewUtils", 1, "isSupportPreRend: " + i);
    return i == 1;
  }
  
  public static WebResourceResponse b()
  {
    WebResourceResponse localWebResourceResponse = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
    Map localMap = localWebResourceResponse.getResponseHeaders();
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("cache-control", "must-revalidate，no-store");
    localWebResourceResponse.setResponseHeaders((Map)localObject);
    return localWebResourceResponse;
  }
  
  public static String b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    String str1;
    String str2;
    label62:
    int j;
    int k;
    label106:
    Object localObject;
    switch (jqc.getNetWorkType())
    {
    case 0: 
    default: 
      str1 = "";
      str2 = "";
      if (WebpSoLoader.aCe())
      {
        str2 = " WebP/0.3.1";
        if (!TextUtils.isEmpty(str2)) {
          arcp.a.cYR = true;
        }
        arcp.a.cYS = paramBoolean;
        j = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
        k = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
        if (!anlm.ayn()) {
          break label335;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = paramString1;
        if (paramString1 == null) {
          localObject = "";
        }
        localObject = localStringBuilder.append((String)localObject).append(" ").append(avpw.getQUA());
        if (!TextUtils.isEmpty(paramString2)) {
          break label340;
        }
      }
      break;
    }
    label335:
    label340:
    for (paramString1 = "";; paramString1 = " " + paramString2)
    {
      return paramString1 + " QQ/" + "3.4.4" + "." + "3058" + str1 + str2 + " Pixel/" + j + " StatusBarHeight/" + k + " SimpleUISwitch/" + i + " QQTheme/1015712";
      str1 = " NetType/UNKNOWN";
      break;
      str1 = " NetType/WIFI";
      break;
      str1 = " NetType/2G";
      break;
      str1 = " NetType/3G";
      break;
      str1 = " NetType/4G";
      break;
      localObject = WebpSoLoader.getDecoderVersion();
      if (paramBoolean)
      {
        str2 = " WebP/0.3.0";
        break label62;
      }
      if (localObject == null) {
        break label62;
      }
      str2 = String.format(" WebP/%d.%d.%d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(localObject[2]) });
      break label62;
      i = 0;
      break label106;
    }
  }
  
  public static void b(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (paramWebView.getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("address", paramString);
      paramWebView.getX5WebViewExtension().invokeMiscMethod("setHttpSystemProxy", localBundle);
    }
  }
  
  public static boolean b(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    boolean bool1 = false;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = bool1;
    if (localObject != null)
    {
      if (!((AppRuntime)localObject).isLogin()) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    String str = paramJSONObject.optString("platformId", "");
    if ((!"0".equals(str)) && (!"2".equals(str)))
    {
      QLog.e("SwiftWebViewUtils", 1, "not support Android! " + paramJSONObject.toString());
      return false;
    }
    label127:
    int j;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(paramJSONObject.optString("business", ""))))
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (paramJSONObject.has("minVersion"))
        {
          paramString = paramJSONObject.optString("minVersion");
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString))
          {
            bool1 = bool2;
            if (!aqqj.bW(paramString, "3.4.4.3058")) {
              bool1 = false;
            }
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramJSONObject.has("maxVersion"))
        {
          paramString = paramJSONObject.optString("maxVersion");
          bool2 = bool1;
          if (!TextUtils.isEmpty(paramString))
          {
            bool2 = bool1;
            if (!aqqj.bW("3.4.4.3058", paramString)) {
              bool2 = false;
            }
          }
        }
      }
      bool1 = bool2;
      if (!bool2) {
        break label503;
      }
      paramString = ((AppRuntime)localObject).getAccount();
      int m = paramJSONObject.optInt("startIndex");
      int k = paramJSONObject.optInt("endIndex");
      if (m < k) {
        break label506;
      }
      j = paramString.length();
      if ((j < m) || (j < k)) {
        break label506;
      }
      m = j - m;
      k = j - k;
      if ((m >= j) || (k >= j) || (m > k)) {
        break label506;
      }
      long l1 = Long.parseLong(paramString.substring(m, k + 1));
      long l2 = paramJSONObject.optLong("min");
      long l3 = paramJSONObject.optLong("max");
      if ((l1 < l2) || (l1 > l3)) {
        break label506;
      }
    }
    label429:
    label503:
    label506:
    for (bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2)
      {
        localObject = paramJSONObject.optString("uinWhiteList");
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(";");
          j = localObject.length;
          bool1 = bool2;
          if (i < j) {
            if (paramString.equals(localObject[i])) {
              bool1 = true;
            }
          }
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        QLog.e("SwiftWebViewUtils", 1, "Config is not valid: " + paramJSONObject);
        return bool1;
        bool2 = false;
        break label127;
        i += 1;
        break label429;
      }
    }
  }
  
  public static void dW(Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("banner_webViewUrl");
    } while (str.contains("minAIOFromMsgList"));
    paramIntent.putExtra("banner_webViewUrl", str + "&minAIOFromMsgList=1");
  }
  
  public static String e(Intent paramIntent)
  {
    Object localObject = "";
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("url");
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        paramIntent = paramIntent.getStringExtra("key_params_qq");
        localObject = paramIntent;
        if (paramIntent == null) {
          localObject = "";
        }
      }
    }
    return localObject;
  }
  
  public static void ehu()
  {
    int j = 0;
    if ((arcp.a.Di.size() != 0) && (arcp.a.eey != -1)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), aqpi.e.cuN);
      if (((File)localObject1).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SwiftWebViewUtils", 2, "no WebviewCrashReport.json exists!");
    return;
    for (;;)
    {
      int i;
      String[] arrayOfString;
      try
      {
        localObject1 = aqhq.readFileContent((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = new JSONObject((String)localObject1);
        if ((!((JSONObject)localObject1).has("group_domain")) || (!((JSONObject)localObject1).has("group_strategy"))) {
          break label520;
        }
        Object localObject2 = ((JSONObject)localObject1).getString("group_domain");
        localObject1 = ((JSONObject)localObject1).getString("group_strategy");
        if (QLog.isColorLevel()) {
          QLog.i("SwiftWebViewUtils", 2, "cdnCacheConfig, domain: " + (String)localObject2 + ", strategys: " + (String)localObject1);
        }
        localObject2 = ((String)localObject2).replace("[", "").replace("]", "").replace("\"", "").split(",");
        if (localObject2.length > 0)
        {
          arcp.a.Di.clear();
          k = localObject2.length;
          i = 0;
          if (i < k)
          {
            arrayOfString = localObject2[i];
            arcp.a.Di.add(arrayOfString.trim());
            i += 1;
            continue;
          }
        }
        int k = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
        localObject1 = ((String)localObject1).substring(1, ((String)localObject1).length() - 1).split("\\],\\[");
        if (localObject1.length <= 0) {
          break;
        }
        arcp.a.eey = -1;
        int m = localObject1.length;
        i = j;
        if (i >= m) {
          break;
        }
        localObject2 = localObject1[i].replace("[", "").replace("]", "").replace("\"", "");
        arrayOfString = ((String)localObject2).split(",");
        if (QLog.isColorLevel()) {
          QLog.i("SwiftWebViewUtils", 2, "stragegy: " + (String)localObject2);
        }
        if (arrayOfString.length != 3) {
          break label502;
        }
        j = Integer.parseInt(arrayOfString[0].trim());
        int n = Integer.parseInt(arrayOfString[1].trim());
        if ((k < j) || (k > n)) {
          break label536;
        }
        i = Integer.parseInt(arrayOfString[2]);
        arcp.a.eey = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SwiftWebViewUtils", 2, "hit stragegy, target cdn size: " + i + ", stragegy: " + (String)localObject2);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SwiftWebViewUtils", 2, "", localException);
      return;
      label502:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SwiftWebViewUtils", 2, Arrays.toString(arrayOfString));
      return;
      label520:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("SwiftWebViewUtils", 2, "no cdnCacheConfig!");
      return;
      label536:
      i += 1;
    }
  }
  
  public static void ehv()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("x5_proxy_setting", 4);
    arcp.b.proxy = localSharedPreferences.getString("http_proxy_address", "");
    arcp.b.cYT = localSharedPreferences.contains("need_set_proxy");
    localSharedPreferences.edit().remove("need_set_proxy").apply();
  }
  
  public static String getSchemeFromUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(":");
      if (i > 0) {
        return paramString.substring(0, i).toLowerCase();
      }
    }
    return "";
  }
  
  public static String qb(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("url:");
    if ((paramString != null) && (paramString.length() > 512)) {
      localStringBuilder.append(paramString.substring(0, 512));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(paramString);
    }
  }
  
  public static String qc(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("Dalvik/");
    localStringBuilder.append(System.getProperty("java.vm.version"));
    localStringBuilder.append(" (Linux; U; Android ");
    String str = Build.VERSION.RELEASE;
    if (str.length() > 0) {}
    for (;;)
    {
      localStringBuilder.append(str);
      if ("REL".equals(Build.VERSION.CODENAME))
      {
        str = Build.MODEL;
        if (str.length() > 0)
        {
          localStringBuilder.append("; ");
          localStringBuilder.append(str);
        }
      }
      str = Build.ID;
      if (str.length() > 0)
      {
        localStringBuilder.append(" Build/");
        localStringBuilder.append(str);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      str = "1.0";
    }
  }
  
  public static String qd(String paramString)
  {
    int i = 50;
    int k;
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      k = paramString.indexOf(":");
      if (k > 0)
      {
        j = (paramString + "?#").indexOf("?");
        if (j <= 50) {
          break label81;
        }
      }
    }
    for (;;)
    {
      if ((k + 3 < paramString.length()) && (i >= 0)) {
        return paramString.substring(k + 3, i);
      }
      return "";
      label81:
      i = j;
    }
  }
  
  public static boolean rU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = Uri.parse(paramString);
      } while (!paramString.isHierarchical());
      paramString = paramString.getQueryParameter("_tbs_xv");
    } while ((TextUtils.isEmpty(paramString)) || (1L != (Long.parseLong(paramString) & 1L)));
    return true;
  }
  
  public static Bundle v()
  {
    if ((arcp.a.cYR) || (arcp.a.cYS))
    {
      StringBuilder localStringBuilder = new StringBuilder("_tcvassp_0_=");
      if ((arcp.a.eey != -1) && (arcp.a.Di.size() != 0))
      {
        localStringBuilder.append(arcp.a.eey);
        if (arcp.a.cYS) {}
        for (Object localObject = "shp";; localObject = "webp")
        {
          localStringBuilder.append((String)localObject);
          localObject = new Bundle();
          ((Bundle)localObject).putString("argument", localStringBuilder.toString());
          ((Bundle)localObject).putStringArrayList("domains", arcp.a.Di);
          if (QLog.isColorLevel())
          {
            QLog.i("SwiftWebViewUtils", 2, "getCDNExtensionData, arg: " + localStringBuilder.toString());
            QLog.i("SwiftWebViewUtils", 2, "getCDNExtensionData, domainList: " + TextUtils.join(", ", arcp.a.Di));
          }
          return localObject;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("SwiftWebViewUtils", 2, "CdnCacheConfig did not parse!!!");
      }
    }
    return null;
  }
  
  public static class a
  {
    public static ArrayList<String> Di = new ArrayList();
    public static boolean cYR;
    public static boolean cYS;
    public static int eey = -1;
  }
  
  public static class b
  {
    public static boolean cYT;
    public static String proxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcp
 * JD-Core Version:    0.7.0.1
 */