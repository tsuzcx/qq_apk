package com.tencent.qqmail.utilities.qmnetwork;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.webkit.WebView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.http.HttpHost;

public class QMProxyUtil
{
  private static final String DEFAULT_PROXY_HOST = "gp.mail.qq.com";
  private static final String DEFAULT_PROXY_PASSWORD = "secondpassword@123";
  private static final int DEFAULT_PROXY_PORT = 443;
  private static final String DEFAULT_PROXY_USERNAME = "secondaccount";
  private static final String GMAIL_DOMAIN = "gmail.com";
  private static final String TAG = "QMProxyUtil";
  private static boolean sProxyEnable;
  private static String[] sSupportedServers = { "imap-mail.outlook.com", "imap.mail.me.com", "pop-mail.outlook.com", "smtp-mail.outlook.com", "smtp.mail.me.com" };
  
  private static Object getFieldValueSafely(Field paramField, Object paramObject)
    throws IllegalArgumentException, IllegalAccessException
  {
    boolean bool = paramField.isAccessible();
    paramField.setAccessible(true);
    paramObject = paramField.get(paramObject);
    paramField.setAccessible(bool);
    return paramObject;
  }
  
  public static QMProxy getGmailHttpProxy()
  {
    return getHttpProxy("gmail.com");
  }
  
  public static QMProxy getHttpProxy(String paramString)
  {
    Object localObject1 = QMSettingManager.sharedInstance().getSysConfig();
    if ((localObject1 != null) && (!((String)localObject1).equals("")) && (paramString != null)) {}
    for (;;)
    {
      try
      {
        localObject1 = (JSONObject)JSONReader.parse((String)localObject1);
        if ((localObject1 == null) || (!((JSONObject)localObject1).containsKey("webproxy"))) {
          break label363;
        }
        localObject1 = (JSONObject)((JSONObject)localObject1).get("webproxy");
        if ((!((JSONObject)localObject1).containsKey("isopen")) || (((JSONObject)localObject1).getIntValue("isopen") != 1) || (!((JSONObject)localObject1).containsKey("data"))) {
          break label363;
        }
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("data");
        i = 0;
        if (i >= localJSONArray.size()) {
          break label363;
        }
        localObject2 = (JSONObject)localJSONArray.get(i);
        if ((((JSONObject)localObject2).containsKey("domain")) && (((JSONObject)localObject2).containsKey("address")) && (((JSONObject)localObject2).containsKey("port")) && (((JSONObject)localObject2).containsKey("username")) && (((JSONObject)localObject2).containsKey("password")))
        {
          localObject1 = ((JSONObject)localObject2).getString("domain");
          str1 = ((JSONObject)localObject2).getString("address");
          str2 = ((JSONObject)localObject2).getString("port");
          str3 = ((JSONObject)localObject2).getString("username");
          localObject2 = ((JSONObject)localObject2).getString("password");
          if (((String)localObject1).equals(paramString)) {
            paramString = new QMProxy(2, str1, Integer.valueOf(str2).intValue());
          }
        }
      }
      catch (Exception localException1)
      {
        int i;
        Object localObject2;
        String str1;
        String str2;
        String str3;
        paramString = null;
      }
      try
      {
        paramString.setAuthentication(str3, (String)localObject2);
        QMLog.log(4, "QMProxyUtil", "webproxy domain:" + (String)localObject1 + " address:" + str1 + " port:" + str2);
        return paramString;
      }
      catch (Exception localException2)
      {
        break label296;
      }
      i += 1;
      continue;
      label296:
      QMLog.log(6, "QMProxyUtil", "webproxy parse error : " + localException1.getMessage());
      return paramString;
      QMLog.log(4, "QMProxyUtil", "use default proxy");
      paramString = new QMProxy(2, "gp.mail.qq.com", 443);
      paramString.setAuthentication("secondaccount", "secondpassword@123");
      return paramString;
    }
    label363:
    return null;
  }
  
  public static QMProxy getSock5HProxy(String paramString)
  {
    Object localObject2 = null;
    String str1 = null;
    String str2 = QMSettingManager.sharedInstance().getSysConfig();
    QMLog.log(4, "QMProxyUtil", "getSock5HProxy, domain: " + paramString + ", config: " + str2);
    Object localObject1 = str1;
    if (str2 != null)
    {
      localObject1 = str1;
      if (!str2.equals(""))
      {
        localObject1 = str1;
        if (paramString == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = (JSONObject)JSONReader.parse(str2);
        if ((localObject1 == null) || (!((JSONObject)localObject1).containsKey("proxy"))) {
          break label391;
        }
        localObject1 = (JSONObject)((JSONObject)localObject1).get("proxy");
        if ((!((JSONObject)localObject1).containsKey("isopen")) || (((JSONObject)localObject1).getIntValue("isopen") != 1) || (!((JSONObject)localObject1).containsKey("data"))) {
          break label391;
        }
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("data");
        i = 0;
        if (i >= localJSONArray.size()) {
          break label391;
        }
        localObject3 = (JSONObject)localJSONArray.get(i);
        if ((((JSONObject)localObject3).containsKey("domain")) && (((JSONObject)localObject3).containsKey("address")) && (((JSONObject)localObject3).containsKey("port")))
        {
          localObject1 = ((JSONObject)localObject3).getString("domain");
          str1 = ((JSONObject)localObject3).getString("address");
          str2 = ((JSONObject)localObject3).getString("port");
          l = QMApplicationContext.sharedInstance().getVid();
          localObject3 = ((JSONObject)localObject3).getString("password");
          if (((String)localObject1).equals(paramString)) {
            paramString = new QMProxy(5, str1, Integer.valueOf(str2).intValue());
          }
        }
      }
      catch (Exception localException1)
      {
        int i;
        Object localObject3;
        long l;
        paramString = localObject2;
        QMLog.log(6, "QMProxyUtil", "proxy parse error : " + localException1.getMessage());
        return paramString;
      }
      try
      {
        paramString.setAuthentication(String.valueOf(l), (String)localObject3);
        QMLog.log(4, "QMProxyUtil", "proxy domain:" + (String)localObject1 + " address:" + str1 + " port:" + str2);
        localObject1 = paramString;
        return localObject1;
      }
      catch (Exception localException2)
      {
        continue;
      }
      i += 1;
      continue;
      label391:
      paramString = null;
    }
  }
  
  public static void handleSchemaPush(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      sSupportedServers = paramString.split(";");
      paramString = sSupportedServers;
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if ("0".equals(localObject))
        {
          sProxyEnable = false;
          return;
        }
        if ("1".equals(localObject))
        {
          sProxyEnable = true;
          return;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isClosed()
  {
    Object localObject = QMSettingManager.sharedInstance().getSysConfig();
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      try
      {
        localObject = (JSONObject)((JSONObject)JSONReader.parse((String)localObject)).get("webproxy");
        if (((JSONObject)localObject).containsKey("isopen"))
        {
          int i = ((JSONObject)localObject).getIntValue("isopen");
          if (i == 1) {
            return false;
          }
        }
      }
      catch (Exception localException) {}
    }
    return true;
  }
  
  private static boolean isSupportedProxy(Profile paramProfile)
  {
    if (paramProfile == null) {
      return false;
    }
    String[] arrayOfString = sSupportedServers;
    int j = arrayOfString.length;
    int i = 0;
    boolean bool = false;
    String str;
    if (i < j)
    {
      str = arrayOfString[i];
      if ((str.equals(paramProfile.pop3Server)) || (str.equals(paramProfile.imapServer)) || (str.equals(paramProfile.activeSyncServer)) || (str.equals(paramProfile.exchangeServer)) || (str.equals(paramProfile.smtpServer)))
      {
        bool = true;
        label92:
        if (!bool) {
          break label152;
        }
      }
    }
    for (;;)
    {
      QMLog.log(4, "QMProxyUtil", "isSupportedProxy: " + bool + ", account: " + paramProfile.mailAddress + ", host: " + str);
      return bool;
      bool = false;
      break label92;
      label152:
      i += 1;
      break;
      str = null;
    }
  }
  
  public static void noNeedProxy(Profile paramProfile) {}
  
  public static boolean resetProxy(WebView paramWebView)
  {
    if (paramWebView != null) {
      try
      {
        if (Build.VERSION.SDK_INT <= 13) {
          return resetProxyUpToHC(paramWebView);
        }
        if (Build.VERSION.SDK_INT <= 15) {
          return resetProxyICS(paramWebView);
        }
        if (Build.VERSION.SDK_INT <= 18) {
          return resetProxyJB(paramWebView);
        }
        if (Build.VERSION.SDK_INT <= 19) {
          return resetProxyKK(paramWebView);
        }
        boolean bool = resetProxyLP(paramWebView);
        return bool;
      }
      catch (Exception paramWebView) {}
    }
    return false;
  }
  
  private static boolean resetProxyICS(WebView paramWebView)
  {
    QMLog.log(4, "QMProxyUtil", "reset proxy with 4.0 API.");
    try
    {
      Method localMethod = Class.forName("android.webkit.JWebCoreJavaBridge").getDeclaredMethod("updateProxy", new Class[] { Class.forName("android.net.ProxyProperties") });
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.WebView").getDeclaredField("mWebViewCore"), paramWebView);
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.WebViewCore").getDeclaredField("mBrowserFrame"), paramWebView);
      localMethod.invoke(getFieldValueSafely(Class.forName("android.webkit.BrowserFrame").getDeclaredField("sJavaBridge"), paramWebView), new Object[] { null });
      QMLog.log(4, "QMProxyUtil", "reset proxy with 4.0 API successful!");
      return true;
    }
    catch (Exception paramWebView)
    {
      QMLog.log(6, "QMProxyUtil", "failed to set HTTP proxy: " + paramWebView);
    }
    return false;
  }
  
  private static boolean resetProxyJB(WebView paramWebView)
  {
    QMLog.log(4, "QMProxyUtil", "reset proxy with 4.1 - 4.3 API.");
    try
    {
      paramWebView = Class.forName("android.webkit.WebViewClassic").getDeclaredMethod("fromWebView", new Class[] { Class.forName("android.webkit.WebView") }).invoke(null, new Object[] { paramWebView });
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.WebViewClassic").getDeclaredField("mWebViewCore"), paramWebView);
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.WebViewCore").getDeclaredField("mBrowserFrame"), paramWebView);
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.BrowserFrame").getDeclaredField("sJavaBridge"), paramWebView);
      Class.forName("android.webkit.JWebCoreJavaBridge").getDeclaredMethod("updateProxy", new Class[] { Class.forName("android.net.ProxyProperties") }).invoke(paramWebView, new Object[] { null });
      QMLog.log(4, "QMProxyUtil", "reset proxy with 4.1 - 4.3 API successful!");
      return true;
    }
    catch (Exception paramWebView)
    {
      QMLog.log(6, "QMProxyUtil", "reset proxy with >= 4.1 API failed with error: " + paramWebView.getMessage());
    }
    return false;
  }
  
  private static boolean resetProxyKK(WebView paramWebView)
  {
    QMLog.log(4, "QMProxyUtil", "reset proxy with  4.4 API.");
    paramWebView = paramWebView.getContext().getApplicationContext();
    Object localObject1 = System.getProperties();
    ((Properties)localObject1).remove("http.proxyHost");
    ((Properties)localObject1).remove("http.proxyPort");
    ((Properties)localObject1).remove("https.proxyHost");
    ((Properties)localObject1).remove("https.proxyPort");
    try
    {
      localObject1 = Class.forName("android.app.Application").getField("mLoadedApk");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(paramWebView);
      Object localObject2 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
      ((Field)localObject2).setAccessible(true);
      localObject1 = ((ArrayMap)((Field)localObject2).get(localObject1)).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((ArrayMap)((Iterator)localObject1).next()).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          Object localObject4 = localObject3.getClass();
          if (((Class)localObject4).getName().contains("ProxyChangeListener"))
          {
            localObject4 = ((Class)localObject4).getDeclaredMethod("onReceive", new Class[] { Context.class, Intent.class });
            Intent localIntent = new Intent("android.intent.action.PROXY_CHANGE");
            localIntent.putExtra("proxy", (Parcelable)null);
            ((Method)localObject4).invoke(localObject3, new Object[] { paramWebView, localIntent });
          }
        }
      }
      QMLog.log(4, "QMProxyUtil", "reset proxy with  4.4 API successful!");
    }
    catch (Exception paramWebView)
    {
      localObject1 = new StringWriter();
      paramWebView.printStackTrace(new PrintWriter((Writer)localObject1));
      localObject1 = ((StringWriter)localObject1).toString();
      QMLog.log(6, "QMProxyUtil", paramWebView.getMessage());
      QMLog.log(6, "QMProxyUtil", (String)localObject1);
      return false;
    }
    return true;
  }
  
  private static boolean resetProxyLP(WebView paramWebView)
  {
    QMLog.log(4, "QMProxyUtil", "reset proxy with >= 5.0 API.");
    Object localObject1 = System.getProperties();
    ((Properties)localObject1).remove("http.proxyHost");
    ((Properties)localObject1).remove("http.proxyPort");
    ((Properties)localObject1).remove("https.proxyHost");
    ((Properties)localObject1).remove("https.proxyPort");
    paramWebView = paramWebView.getContext().getApplicationContext();
    try
    {
      localObject1 = Class.forName("android.app.Application").getDeclaredField("mLoadedApk");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(paramWebView);
      Object localObject2 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
      ((Field)localObject2).setAccessible(true);
      localObject1 = ((ArrayMap)((Field)localObject2).get(localObject1)).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((ArrayMap)((Iterator)localObject1).next()).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          Class localClass = localObject3.getClass();
          if (localClass.getName().contains("ProxyChangeListener")) {
            localClass.getDeclaredMethod("onReceive", new Class[] { Context.class, Intent.class }).invoke(localObject3, new Object[] { paramWebView, new Intent("android.intent.action.PROXY_CHANGE") });
          }
        }
      }
      QMLog.log(4, "QMProxyUtil", "reset proxy with >= 5.0 API successful!");
    }
    catch (Exception paramWebView)
    {
      localObject1 = new StringWriter();
      paramWebView.printStackTrace(new PrintWriter((Writer)localObject1));
      localObject1 = ((StringWriter)localObject1).toString();
      QMLog.log(6, "QMProxyUtil", paramWebView.getMessage());
      QMLog.log(6, "QMProxyUtil", (String)localObject1);
      return false;
    }
    return false;
  }
  
  private static boolean resetProxyUpToHC(WebView paramWebView)
  {
    QMLog.log(4, "QMProxyUtil", "reset proxy with <= 3.2 API.");
    Object localObject1;
    try
    {
      localObject1 = Class.forName("android.webkit.Network");
      if (localObject1 == null)
      {
        QMLog.log(6, "QMProxyUtil", "failed to get class for android.webkit.Network");
        return false;
      }
      Method localMethod = ((Class)localObject1).getMethod("getInstance", new Class[] { Context.class });
      if (localMethod == null) {
        QMLog.log(6, "QMProxyUtil", "failed to get getInstance method");
      }
      paramWebView = localMethod.invoke(localObject1, new Object[] { paramWebView.getContext() });
      if (paramWebView == null)
      {
        QMLog.log(6, "QMProxyUtil", "error getting network: network is null");
        return false;
      }
    }
    catch (Exception paramWebView)
    {
      QMLog.log(6, "QMProxyUtil", "error getting network: " + paramWebView);
      return false;
    }
    try
    {
      localObject1 = getFieldValueSafely(((Class)localObject1).getDeclaredField("mRequestQueue"), paramWebView);
      if (localObject1 == null)
      {
        QMLog.log(6, "QMProxyUtil", "Request queue is null");
        return false;
      }
    }
    catch (Exception paramWebView)
    {
      QMLog.log(6, "QMProxyUtil", "error getting field value");
      return false;
    }
    try
    {
      paramWebView = Class.forName("android.net.http.RequestQueue").getDeclaredField("mProxyHost");
      bool = paramWebView.isAccessible();
    }
    catch (Exception paramWebView)
    {
      label202:
      QMLog.log(6, "QMProxyUtil", "error getting proxy host field");
      return false;
    }
    try
    {
      paramWebView.setAccessible(true);
      paramWebView.set(localObject1, null);
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMProxyUtil", "error setting proxy host");
      paramWebView.setAccessible(bool);
      break label202;
    }
    finally
    {
      paramWebView.setAccessible(bool);
    }
    QMLog.log(4, "QMProxyUtil", "reset proxy with <= 3.2 API successful!");
    return true;
  }
  
  public static boolean setProxy(WebView paramWebView, QMProxy paramQMProxy)
  {
    if ((paramWebView != null) && (paramQMProxy != null)) {
      try
      {
        String str = paramQMProxy.getProxyHost();
        int i = paramQMProxy.getProxyPort();
        if (Build.VERSION.SDK_INT <= 13) {
          return setProxyUpToHC(paramWebView, str, i);
        }
        if (Build.VERSION.SDK_INT <= 15) {
          return setProxyICS(paramWebView, str, i);
        }
        if (Build.VERSION.SDK_INT <= 18) {
          return setProxyJB(paramWebView, str, i);
        }
        if (Build.VERSION.SDK_INT <= 19) {
          return setProxyKK(paramWebView, str, i);
        }
        boolean bool = setProxyLP(paramWebView, str, i);
        return bool;
      }
      catch (Exception paramWebView) {}
    }
    return false;
  }
  
  private static boolean setProxyICS(WebView paramWebView, String paramString, int paramInt)
  {
    QMLog.log(4, "QMProxyUtil", "Setting proxy with 4.0 API.");
    try
    {
      Method localMethod = Class.forName("android.webkit.JWebCoreJavaBridge").getDeclaredMethod("updateProxy", new Class[] { Class.forName("android.net.ProxyProperties") });
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.WebView").getDeclaredField("mWebViewCore"), paramWebView);
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.WebViewCore").getDeclaredField("mBrowserFrame"), paramWebView);
      localMethod.invoke(getFieldValueSafely(Class.forName("android.webkit.BrowserFrame").getDeclaredField("sJavaBridge"), paramWebView), new Object[] { Class.forName("android.net.ProxyProperties").getConstructor(new Class[] { String.class, Integer.TYPE, String.class }).newInstance(new Object[] { paramString, Integer.valueOf(paramInt), null }) });
      QMLog.log(4, "QMProxyUtil", "Setting proxy with 4.0 API successful!");
      return true;
    }
    catch (Exception paramWebView)
    {
      QMLog.log(6, "QMProxyUtil", "failed to set HTTP proxy: " + paramWebView);
    }
    return false;
  }
  
  private static boolean setProxyJB(WebView paramWebView, String paramString, int paramInt)
  {
    QMLog.log(4, "QMProxyUtil", "Setting proxy with 4.1 - 4.3 API.");
    try
    {
      paramWebView = Class.forName("android.webkit.WebViewClassic").getDeclaredMethod("fromWebView", new Class[] { Class.forName("android.webkit.WebView") }).invoke(null, new Object[] { paramWebView });
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.WebViewClassic").getDeclaredField("mWebViewCore"), paramWebView);
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.WebViewCore").getDeclaredField("mBrowserFrame"), paramWebView);
      paramWebView = getFieldValueSafely(Class.forName("android.webkit.BrowserFrame").getDeclaredField("sJavaBridge"), paramWebView);
      Constructor localConstructor = Class.forName("android.net.ProxyProperties").getConstructor(new Class[] { String.class, Integer.TYPE, String.class });
      Class.forName("android.webkit.JWebCoreJavaBridge").getDeclaredMethod("updateProxy", new Class[] { Class.forName("android.net.ProxyProperties") }).invoke(paramWebView, new Object[] { localConstructor.newInstance(new Object[] { paramString, Integer.valueOf(paramInt), null }) });
      QMLog.log(4, "QMProxyUtil", "Setting proxy with 4.1 - 4.3 API successful!");
      return true;
    }
    catch (Exception paramWebView)
    {
      QMLog.log(6, "QMProxyUtil", "Setting proxy with >= 4.1 API failed with error: " + paramWebView.getMessage());
    }
    return false;
  }
  
  private static boolean setProxyKK(WebView paramWebView, String paramString, int paramInt)
  {
    QMLog.log(4, "QMProxyUtil", "Setting proxy with  4.4 API.");
    paramWebView = paramWebView.getContext().getApplicationContext();
    System.setProperty("http.proxyHost", paramString);
    System.setProperty("http.proxyPort", paramInt + "");
    System.setProperty("https.proxyHost", paramString);
    System.setProperty("https.proxyPort", paramInt + "");
    try
    {
      Object localObject1 = Class.forName("android.app.Application").getField("mLoadedApk");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(paramWebView);
      Object localObject2 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
      ((Field)localObject2).setAccessible(true);
      localObject1 = ((ArrayMap)((Field)localObject2).get(localObject1)).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((ArrayMap)((Iterator)localObject1).next()).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          Object localObject4 = localObject3.getClass();
          if (((Class)localObject4).getName().contains("ProxyChangeListener"))
          {
            localObject4 = ((Class)localObject4).getDeclaredMethod("onReceive", new Class[] { Context.class, Intent.class });
            Intent localIntent = new Intent("android.intent.action.PROXY_CHANGE");
            Constructor localConstructor = Class.forName("android.net.ProxyProperties").getConstructor(new Class[] { String.class, Integer.TYPE, String.class });
            localConstructor.setAccessible(true);
            localIntent.putExtra("proxy", (Parcelable)localConstructor.newInstance(new Object[] { paramString, Integer.valueOf(paramInt), null }));
            ((Method)localObject4).invoke(localObject3, new Object[] { paramWebView, localIntent });
          }
        }
      }
      QMLog.log(4, "QMProxyUtil", "Setting proxy with  4.4 API successful!");
    }
    catch (Exception paramWebView)
    {
      paramString = new StringWriter();
      paramWebView.printStackTrace(new PrintWriter(paramString));
      paramString = paramString.toString();
      QMLog.log(6, "QMProxyUtil", paramWebView.getMessage());
      QMLog.log(6, "QMProxyUtil", paramString);
      return false;
    }
    return true;
  }
  
  private static boolean setProxyLP(WebView paramWebView, String paramString, int paramInt)
  {
    QMLog.log(4, "QMProxyUtil", "Setting proxy with >= 5.0 API.");
    System.setProperty("http.proxyHost", paramString);
    System.setProperty("http.proxyPort", paramInt + "");
    System.setProperty("https.proxyHost", paramString);
    System.setProperty("https.proxyPort", paramInt + "");
    paramWebView = paramWebView.getContext().getApplicationContext();
    try
    {
      paramString = Class.forName("android.app.Application").getDeclaredField("mLoadedApk");
      paramString.setAccessible(true);
      paramString = paramString.get(paramWebView);
      Object localObject1 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
      ((Field)localObject1).setAccessible(true);
      paramString = ((ArrayMap)((Field)localObject1).get(paramString)).values().iterator();
      while (paramString.hasNext())
      {
        localObject1 = ((ArrayMap)paramString.next()).keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          Class localClass = localObject2.getClass();
          if (localClass.getName().contains("ProxyChangeListener")) {
            localClass.getDeclaredMethod("onReceive", new Class[] { Context.class, Intent.class }).invoke(localObject2, new Object[] { paramWebView, new Intent("android.intent.action.PROXY_CHANGE") });
          }
        }
      }
      QMLog.log(4, "QMProxyUtil", "Setting proxy with >= 5.0 API successful!");
    }
    catch (Exception paramWebView)
    {
      paramString = new StringWriter();
      paramWebView.printStackTrace(new PrintWriter(paramString));
      paramString = paramString.toString();
      QMLog.log(6, "QMProxyUtil", paramWebView.getMessage());
      QMLog.log(6, "QMProxyUtil", paramString);
      return false;
    }
    return false;
  }
  
  private static boolean setProxyUpToHC(WebView paramWebView, String paramString, int paramInt)
  {
    QMLog.log(4, "QMProxyUtil", "Setting proxy with <= 3.2 API.");
    paramString = new HttpHost(paramString, paramInt);
    Object localObject;
    try
    {
      localObject = Class.forName("android.webkit.Network");
      if (localObject == null)
      {
        QMLog.log(6, "QMProxyUtil", "failed to get class for android.webkit.Network");
        return false;
      }
      Method localMethod = ((Class)localObject).getMethod("getInstance", new Class[] { Context.class });
      if (localMethod == null) {
        QMLog.log(6, "QMProxyUtil", "failed to get getInstance method");
      }
      paramWebView = localMethod.invoke(localObject, new Object[] { paramWebView.getContext() });
      if (paramWebView == null)
      {
        QMLog.log(6, "QMProxyUtil", "error getting network: network is null");
        return false;
      }
    }
    catch (Exception paramWebView)
    {
      QMLog.log(6, "QMProxyUtil", "error getting network: " + paramWebView);
      return false;
    }
    try
    {
      localObject = getFieldValueSafely(((Class)localObject).getDeclaredField("mRequestQueue"), paramWebView);
      if (localObject == null)
      {
        QMLog.log(6, "QMProxyUtil", "Request queue is null");
        return false;
      }
    }
    catch (Exception paramWebView)
    {
      QMLog.log(6, "QMProxyUtil", "error getting field value");
      return false;
    }
    try
    {
      paramWebView = Class.forName("android.net.http.RequestQueue").getDeclaredField("mProxyHost");
      bool = paramWebView.isAccessible();
    }
    catch (Exception paramWebView)
    {
      label223:
      QMLog.log(6, "QMProxyUtil", "error getting proxy host field");
      return false;
    }
    try
    {
      paramWebView.setAccessible(true);
      paramWebView.set(localObject, paramString);
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "QMProxyUtil", "error setting proxy host");
      paramWebView.setAccessible(bool);
      break label223;
    }
    finally
    {
      paramWebView.setAccessible(bool);
    }
    QMLog.log(4, "QMProxyUtil", "Setting proxy with <= 3.2 API successful!");
    return true;
  }
  
  public static boolean trySocket5HProxy(Profile paramProfile)
  {
    Object localObject = new StringBuilder().append("trySocket5HProxy, profile: ");
    boolean bool;
    if (paramProfile != null)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(", usedProxy: ");
      if ((paramProfile == null) || (!paramProfile.usedProxy)) {
        break label77;
      }
      bool = true;
      label45:
      QMLog.log(4, "QMProxyUtil", bool);
      if ((paramProfile != null) && (!paramProfile.usedProxy)) {
        break label82;
      }
    }
    label77:
    label82:
    do
    {
      do
      {
        return false;
        bool = false;
        break;
        bool = false;
        break label45;
      } while ((!sProxyEnable) || (!isSupportedProxy(paramProfile)));
      localObject = getSock5HProxy("gmail.com");
    } while (localObject == null);
    paramProfile.proxyType = ((QMProxy)localObject).transferProfileProxyType();
    paramProfile.proxyUsername = ((QMProxy)localObject).getProxyUserName();
    paramProfile.proxyPassword = ((QMProxy)localObject).getProxyPassword();
    paramProfile.proxyServer = ((QMProxy)localObject).getProxyHost();
    paramProfile.proxyPort = ((QMProxy)localObject).getProxyPort();
    QMLog.log(4, "QMProxyUtil", "trySocket5HProxy, account: " + paramProfile.mailAddress + ", proxyType:" + paramProfile.proxyType + ", proxyUsername:" + paramProfile.proxyUsername + ", proxyPassword:" + paramProfile.proxyPassword + ", proxyServer:" + paramProfile.proxyServer + ", proxyPort:" + paramProfile.proxyPort);
    paramProfile.usedProxy = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil
 * JD-Core Version:    0.7.0.1
 */