package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.proxy.ProxyWebChromeClient;
import com.tencent.smtt.export.external.proxy.ProxyWebViewClient;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class WebViewWizardBase
{
  private DexLoader mDexLoader = null;
  protected boolean mIsDynamicMode = false;
  protected boolean mX5Used = true;
  
  public void HTML5NotificationPresenter_exitCleanUp()
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.HTML5NotificationPresenter", "exitCleanUp", null, new Object[0]);
  }
  
  public void ScaleManager_destroy()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.ScaleManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.ScaleManager", "destroy", null, new Object[0]);
  }
  
  public void SmttPermanentPermissions_clearAllPermanentPermission()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
  }
  
  public void SmttResource_UpdateContext(Context paramContext)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.SmttResource", "updateContext", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public void appendDomain(URL paramURL)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.SMTTCookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.SMTTCookieManager", "appendDomain", new Class[] { URL.class }, new Object[] { paramURL });
  }
  
  public Object base64Decode(String paramString, int paramInt)
  {
    if (!this.mX5Used) {
      return null;
    }
    return invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.AlgorithmIdentifier.Base64", "decode", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public Object base64Encode(byte[] paramArrayOfByte)
  {
    if (!this.mX5Used) {
      return null;
    }
    return invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.AlgorithmIdentifier.Base64", "encode", new Class[] { [B.class }, new Object[] { paramArrayOfByte });
  }
  
  public Object cacheDisabled()
  {
    if (!this.mX5Used) {
      return null;
    }
    return invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CacheManager", "cacheDisabled", new Class[0], new Object[0]);
  }
  
  public void clearCache()
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
  }
  
  public void clearChromiumCookie(Context paramContext)
  {
    if (!this.mX5Used) {}
    do
    {
      return;
      invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieSyncManager", "createInstance", new Class[] { Context.class }, new Object[] { paramContext });
      Object localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.ChromiumCookieManager", "getChromiumInstance", null, new Object[0]);
      if (localObject != null)
      {
        invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.ChromiumCookieManager", "removeAllCookie", null, new Object[0]);
        invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.ChromiumCookieManager", "removeExpiredCookie", null, new Object[0]);
      }
      paramContext = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebViewDatabase", "getInstance", new Class[] { Context.class }, new Object[] { paramContext });
    } while (paramContext == null);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.WebViewDatabase", "clearFormData", null, new Object[0]);
  }
  
  public void clearCookie(Context paramContext)
  {
    if (!this.mX5Used) {}
    do
    {
      return;
      invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieSyncManager", "createInstance", new Class[] { Context.class }, new Object[] { paramContext });
      Object localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieManager", "getInstance", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(false) });
      if (localObject != null)
      {
        invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieManager", "removeAllCookie", null, new Object[0]);
        invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieManager", "removeExpiredCookie", null, new Object[0]);
      }
      paramContext = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebViewDatabase", "getInstance", new Class[] { Context.class }, new Object[] { paramContext });
    } while (paramContext == null);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.WebViewDatabase", "clearFormData", null, new Object[0]);
  }
  
  public void clearDns()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      if (((Boolean)invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.export.internal.utils.ChromiumUtil", "getIsUseChromium", null, new Object[0])).booleanValue())
      {
        invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CacheManager", "clearDns", null, new Object[0]);
        return;
      }
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
  }
  
  public void clearFormData(Context paramContext)
  {
    if (!this.mX5Used) {}
    do
    {
      return;
      paramContext = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebViewDatabase", "getInstance", new Class[] { Context.class }, new Object[] { paramContext });
    } while (paramContext == null);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.WebViewDatabase", "clearFormData", null, new Object[0]);
  }
  
  public void clearPasswords(Context paramContext)
  {
    if (!this.mX5Used) {}
    do
    {
      return;
      paramContext = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebViewDatabase", "getInstance", new Class[] { Context.class }, new Object[] { paramContext });
    } while (paramContext == null);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.WebViewDatabase", "clearUsernamePassword", null, new Object[0]);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.WebViewDatabase", "clearHttpAuthUsernamePassword", null, new Object[0]);
  }
  
  public void closeIconDB()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebIconDatabase", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.WebIconDatabase", "close", null, new Object[0]);
  }
  
  public boolean cookieManager_acceptCookie()
  {
    if (!this.mX5Used) {
      return false;
    }
    Object localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieManager", "getInstance", null, new Object[0]);
    if (localObject != null)
    {
      localObject = invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieManager", "acceptCookie", null, new Object[0]);
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return false;
  }
  
  public boolean cookieManager_hasCookies()
  {
    if (!this.mX5Used) {
      return false;
    }
    Object localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieManager", "getInstance", null, new Object[0]);
    if (localObject != null)
    {
      localObject = invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieManager", "hasCookies", null, new Object[0]);
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return false;
  }
  
  public void cookieManager_removeAllCookie()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieManager", "removeAllCookie", null, new Object[0]);
  }
  
  public void cookieManager_removeExpiredCookie()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieManager", "removeExpiredCookie", null, new Object[0]);
  }
  
  public void cookieManager_removeSessionCookie()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieManager", "removeSessionCookie", null, new Object[0]);
  }
  
  public void cookieManager_setAcceptCookie(boolean paramBoolean)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieManager", "setAcceptCookie", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void cookieManager_setCookie(String paramString1, String paramString2)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieManager", "setCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
  }
  
  public void cookieSyncManager_Sync()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieSyncManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieSyncManager", "sync", null, new Object[0]);
  }
  
  public void cookieSyncManager_startSync()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieSyncManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieSyncManager", "startSync", null, new Object[0]);
  }
  
  public void cookieSyncManager_stopSync()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieSyncManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.CookieSyncManager", "stopSync", null, new Object[0]);
  }
  
  public IX5WebViewBase createSDKWebview(Context paramContext)
  {
    if (this.mX5Used)
    {
      Class localClass = Boolean.TYPE;
      return (IX5WebViewBase)newInstance(this.mIsDynamicMode, "com.tencent.smtt.webkit.adapter.X5WebViewAdapter", new Class[] { Context.class, localClass }, new Object[] { paramContext, Boolean.valueOf(false) });
    }
    return null;
  }
  
  public IX5WebChromeClient createWebChromeClient(ProxyWebChromeClient paramProxyWebChromeClient)
  {
    if (this.mX5Used) {
      paramProxyWebChromeClient.setWebChromeClient((IX5WebChromeClient)newInstance(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebChromeClient"));
    }
    return paramProxyWebChromeClient;
  }
  
  public IX5WebViewClient createWebViewClient(ProxyWebViewClient paramProxyWebViewClient)
  {
    if (this.mX5Used) {
      paramProxyWebViewClient.setWebViewClient((IX5WebViewClient)newInstance(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebViewClient"));
    }
    return paramProxyWebViewClient;
  }
  
  public Object getCachFileBaseDir()
  {
    if (!this.mX5Used) {
      return null;
    }
    return invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CacheManager", "getCacheFileBaseDir", new Class[0], new Object[0]);
  }
  
  public Object getCacheFile(String paramString, Map<String, String> paramMap)
  {
    if (!this.mX5Used) {
      return null;
    }
    return invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CacheManager", "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, paramMap });
  }
  
  public String getCookie(String paramString)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return null;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.SMTTCookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    return (String)invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.SMTTCookieManager", "getCookie", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public String getCookie(String paramString, boolean paramBoolean)
  {
    if (!this.mX5Used) {
      return null;
    }
    Object localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.SMTTCookieManager", "getInstance", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    if (localObject != null) {
      return (String)invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.SMTTCookieManager", "getCookie", new Class[] { String.class }, new Object[] { paramString });
    }
    return null;
  }
  
  public Object getCrashExtraMessage()
  {
    if (!this.mX5Used)
    {
      Log.e("pb", "WebViewWizard.getCrashExtraMessage(), but mX5Used is false");
      return new String();
    }
    return invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
  }
  
  public Bitmap getIconForPageUrl(String paramString)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return null;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebIconDatabase", "getInstance", null, new Object[0]);
    } while (localObject == null);
    return (Bitmap)invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.WebIconDatabase", "getIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public Object getInputStream(String paramString)
  {
    if (!this.mX5Used) {
      return null;
    }
    paramString = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CacheManager", "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, null });
    if (paramString != null) {
      return invokeMethod(this.mIsDynamicMode, paramString, "com.tencent.smtt.webkit.CacheManager$CacheResult", "getInputStream", null, new Object[0]);
    }
    return null;
  }
  
  public Object getLocalPath(String paramString)
  {
    if (!this.mX5Used) {
      return null;
    }
    paramString = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CacheManager", "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, null });
    if (paramString != null) {
      return invokeMethod(this.mIsDynamicMode, paramString, "com.tencent.smtt.webkit.CacheManager$CacheResult", "getLocalPath", null, new Object[0]);
    }
    return null;
  }
  
  public String getPluginDownloadURL(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (!this.mX5Used) {
      return null;
    }
    paramContext = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.PluginManager", "getInstance", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext != null) {
      return (String)invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.PluginManager", "getPluginDownloadURL", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    }
    return null;
  }
  
  public String getQCookie(String paramString)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return null;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.SMTTCookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    return (String)invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.SMTTCookieManager", "getQCookie", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public Object getStaticField(boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      if (this.mDexLoader != null) {
        localObject = this.mDexLoader.getStaticField(paramString1, paramString2);
      }
      return localObject;
    }
    try
    {
      localObject = Class.forName(paramString1).getField(paramString2);
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' get field '" + paramString2 + "' failed", localException);
    }
    return null;
  }
  
  public void initChromiumCookieModule(Context paramContext)
  {
    if (!this.mX5Used) {}
    do
    {
      return;
      invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieSyncManager", "createInstance", new Class[] { Context.class }, new Object[] { paramContext });
      paramContext = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.ChromiumCookieManager", "getChromiumInstance", null, new Object[0]);
    } while (paramContext == null);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.ChromiumCookieManager", "removeExpiredCookie", null, new Object[0]);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.ChromiumCookieManager", "removeSessionCookie", null, new Object[0]);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.ChromiumCookieManager", "preInitCookieStore", null, new Object[0]);
  }
  
  public void initCookieModule(Context paramContext)
  {
    if (!this.mX5Used) {}
    do
    {
      return;
      invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieSyncManager", "createInstance", new Class[] { Context.class }, new Object[] { paramContext });
      paramContext = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieManager", "getInstance", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(false) });
    } while (paramContext == null);
    Boolean localBoolean = (Boolean)invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.export.internal.utils.ChromiumUtil", "isChromiumBuiltIn", null, new Object[0]);
    if ((localBoolean.booleanValue()) && (localBoolean.booleanValue()))
    {
      invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.ChromiumCookieManager", "preInitCookieStore", null, new Object[0]);
      return;
    }
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.CookieManager", "removeExpiredCookie", null, new Object[0]);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.CookieManager", "removeSessionCookie", null, new Object[0]);
  }
  
  public void initCookieSyncManager(Context paramContext)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.CookieSyncManager", "createInstance", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public Object invokeMethod(boolean paramBoolean, Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      if (this.mDexLoader != null) {
        localObject = this.mDexLoader.invokeMethod(paramObject, paramString1, paramString2, paramArrayOfClass, paramVarArgs);
      }
      return localObject;
    }
    try
    {
      paramArrayOfClass = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramObject = paramArrayOfClass.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' invoke method '" + paramString2 + "' failed", paramObject);
    }
    return null;
  }
  
  public Object invokeStaticMethod(boolean paramBoolean, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      if (this.mDexLoader != null) {
        localObject = this.mDexLoader.invokeStaticMethod(paramString1, paramString2, paramArrayOfClass, paramVarArgs);
      }
      return localObject;
    }
    try
    {
      paramArrayOfClass = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.invoke(null, paramVarArgs);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' invoke static method '" + paramString2 + "' failed", paramArrayOfClass);
    }
    return null;
  }
  
  public boolean isAllowQHead()
  {
    if (!this.mX5Used) {
      return false;
    }
    return ((Boolean)getStaticField(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebSettings", "isAllowQHead")).booleanValue();
  }
  
  public boolean isDynamicMode()
  {
    return this.mIsDynamicMode;
  }
  
  public boolean isUploadingWebCoreLog2Server()
  {
    if (!this.mX5Used) {
      return true;
    }
    return ((Boolean)invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttLog", "isUploadingLog", null, new Object[0])).booleanValue();
  }
  
  public boolean isWritingWebCoreLogToFile()
  {
    if (!this.mX5Used) {
      return true;
    }
    return ((Boolean)invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttLog", "isLogWritten2File", null, new Object[0])).booleanValue();
  }
  
  public boolean isX5ShowMemValueEnabled()
  {
    if (!this.mX5Used) {
      return false;
    }
    return ((Boolean)getStaticField(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebSettings", "isX5ShowMemValueEnabled")).booleanValue();
  }
  
  public void liveLog(String paramString)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttLog", "liveLog", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public Class<?> loadClass(boolean paramBoolean, String paramString)
  {
    Class localClass = null;
    if (paramBoolean)
    {
      if (this.mDexLoader != null) {
        localClass = this.mDexLoader.loadClass(paramString);
      }
      return localClass;
    }
    try
    {
      localClass = Class.forName(paramString);
      return localClass;
    }
    catch (Exception localException)
    {
      Log.e(getClass().getSimpleName(), "loadClass '" + paramString + "' failed", localException);
    }
    return null;
  }
  
  public Object newInstance(boolean paramBoolean, String paramString)
  {
    Object localObject = null;
    if (paramBoolean) {
      if (this.mDexLoader != null) {
        localObject = this.mDexLoader.newInstance(paramString);
      }
    }
    for (;;)
    {
      return localObject;
      try
      {
        Class localClass = Class.forName(paramString);
        if (localClass != null)
        {
          localObject = localClass.newInstance();
          return localObject;
        }
      }
      catch (Exception localException)
      {
        Log.e(getClass().getSimpleName(), "create '" + paramString + "' instance failed", localException);
      }
    }
    return null;
  }
  
  public Object newInstance(boolean paramBoolean, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    Object localObject = null;
    if (paramBoolean) {
      if (this.mDexLoader != null) {
        localObject = this.mDexLoader.newInstance(paramString, paramArrayOfClass, paramVarArgs);
      }
    }
    for (;;)
    {
      return localObject;
      try
      {
        Class localClass = Class.forName(paramString);
        if (localClass != null)
        {
          paramArrayOfClass = localClass.getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
          return paramArrayOfClass;
        }
      }
      catch (Exception paramArrayOfClass)
      {
        Log.e(getClass().getSimpleName(), "create '" + paramString + "' instance failed", paramArrayOfClass);
      }
    }
    return null;
  }
  
  public void openIconDB(String paramString)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.WebIconDatabase", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.WebIconDatabase", "open", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void preConnect(boolean paramBoolean, String paramString)
  {
    if (!this.mX5Used) {}
    do
    {
      return;
      Boolean localBoolean1 = (Boolean)invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.export.internal.utils.ChromiumUtil", "isChromiumBuiltIn", null, new Object[0]);
      Boolean localBoolean2 = (Boolean)invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.export.internal.utils.ChromiumUtil", "getIsUseChromium", null, new Object[0]);
      if ((!localBoolean1.booleanValue()) || (!localBoolean2.booleanValue())) {
        break;
      }
    } while (paramString == null);
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.export.internal.utils.JniUtil", "setPreConnect", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(1) });
    return;
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.net.http.NetworkInterfaces", "preConnect", new Class[] { Boolean.TYPE, String.class }, new Object[] { Boolean.valueOf(paramBoolean), paramString });
  }
  
  public void refreshPlugins(Context paramContext, boolean paramBoolean)
  {
    if (!this.mX5Used) {}
    do
    {
      return;
      paramContext = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.PluginManager", "getInstance", new Class[] { Context.class }, new Object[] { paramContext });
    } while (paramContext == null);
    invokeMethod(this.mIsDynamicMode, paramContext, "com.tencent.smtt.webkit.PluginManager", "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void resumeActiveH5VideoProxy()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.h5video.H5VideoHolder", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.h5video.H5VideoHolder", "resumeActiveH5VideoProxy", null, new Object[0]);
  }
  
  public void setAllowQHead(boolean paramBoolean)
  {
    if (!this.mX5Used) {
      return;
    }
    setStaticBooleanField("com.tencent.smtt.webkit.WebSettings", "isAllowQHead", paramBoolean);
  }
  
  public void setContextHolderDevelopMode(boolean paramBoolean)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.ContextHolder", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.ContextHolder", "setSdkDevelopMode", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public boolean setContextHolderParams(Context paramContext, String paramString)
  {
    if (!this.mX5Used) {
      return false;
    }
    Object localObject;
    if ((this.mIsDynamicMode) && (!TextUtils.isEmpty(paramString)))
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Context.class;
      arrayOfClass[1] = String.class;
      localObject = new Object[2];
      localObject[0] = paramContext;
      localObject[1] = paramString;
      paramString = arrayOfClass;
    }
    for (paramContext = (Context)localObject;; paramContext = (Context)localObject)
    {
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.ContextHolder", "getInstance", null, new Object[0]);
      if (localObject == null) {
        break;
      }
      return ((Boolean)invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.ContextHolder", "setContext", paramString, paramContext)).booleanValue();
      paramString = new Class[1];
      paramString[0] = Context.class;
      localObject = new Object[1];
      localObject[0] = paramContext;
    }
  }
  
  public void setCookie(URL paramURL, Map<String, List<String>> paramMap)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.SMTTCookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.SMTTCookieManager", "setCookie", new Class[] { URL.class, Map.class }, new Object[] { paramURL, paramMap });
  }
  
  public void setDexLoader(Context paramContext, String paramString1, String paramString2)
  {
    if ((this.mX5Used) && (this.mIsDynamicMode) && (this.mDexLoader == null)) {
      this.mDexLoader = new DexLoader(paramContext, paramString1, paramString2);
    }
  }
  
  public void setDexLoader(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    if ((this.mX5Used) && (this.mIsDynamicMode) && (this.mDexLoader == null)) {
      this.mDexLoader = new DexLoader(paramContext, paramArrayOfString, paramString);
    }
  }
  
  public void setGUID(String paramString)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.net.http.JNISmttService", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.net.http.JNISmttService", "setGUID", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void setLocalSmttService(Object paramObject)
  {
    if (!this.mX5Used) {}
    for (;;)
    {
      return;
      try
      {
        Class localClass = Class.forName("com.tencent.smtt.service.SmttService");
        Object localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.service.SmttServiceProxy", "getInstance", null, new Object[0]);
        if (localObject != null)
        {
          invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.service.SmttServiceProxy", "setLocalSmttService", new Class[] { localClass }, new Object[] { paramObject });
          return;
        }
      }
      catch (ClassNotFoundException paramObject)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public void setNetworkOnLine(boolean paramBoolean)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.JWebCoreJavaBridge", "setNetworkOnLine", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setQCookie(String paramString1, String paramString2)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.SMTTCookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.SMTTCookieManager", "setQCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
  }
  
  public void setSdkVersion(int paramInt)
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.ContextHolder", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.ContextHolder", "setSdkVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void setStaticBooleanField(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      Field localField = loadClass(true, paramString1).getField(paramString2);
      localField.setAccessible(true);
      localField.setBoolean(null, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' set field '" + paramString2 + "' failed", localException);
    }
  }
  
  public void setStaticIntField(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      Field localField = loadClass(true, paramString1).getField(paramString2);
      localField.setAccessible(true);
      localField.setInt(null, paramInt);
      return;
    }
    catch (Exception localException)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' set field '" + paramString2 + "' failed", localException);
    }
  }
  
  public void setWebCoreLogWrite2FileFlag(boolean paramBoolean)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttLog", "setLogWrite2FileFlag", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setWizardMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mX5Used = paramBoolean1;
    this.mIsDynamicMode = paramBoolean2;
  }
  
  public void setX5ShowMemValueEnabled(boolean paramBoolean)
  {
    if (!this.mX5Used) {
      return;
    }
    setStaticBooleanField("com.tencent.smtt.webkit.WebSettings", "isX5ShowMemValueEnabled", paramBoolean);
  }
  
  public void stopActiveH5VideoProxy()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.h5video.H5VideoHolder", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.h5video.H5VideoHolder", "stopActiveH5VideoProxy", null, new Object[0]);
  }
  
  public void syncImmediately()
  {
    if (!this.mX5Used) {}
    Object localObject;
    do
    {
      return;
      localObject = invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.webkit.SMTTCookieManager", "getInstance", null, new Object[0]);
    } while (localObject == null);
    invokeMethod(this.mIsDynamicMode, localObject, "com.tencent.smtt.webkit.SMTTCookieManager", "syncImmediately", null, new Object[0]);
  }
  
  public void traceBegin(int paramInt)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttTraceEvent", "begin", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void traceBegin(int paramInt, String paramString)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttTraceEvent", "begin", new Class[] { Integer.TYPE, String.class }, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void traceBegin(int paramInt, String paramString1, String paramString2)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttTraceEvent", "begin", new Class[] { Integer.TYPE, String.class, String.class }, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  public void traceEnd(int paramInt)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttTraceEvent", "end", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void traceEnd(int paramInt, String paramString)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttTraceEvent", "end", new Class[] { Integer.TYPE, String.class }, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void traceEnd(int paramInt, String paramString1, String paramString2)
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttTraceEvent", "end", new Class[] { Integer.TYPE, String.class, String.class }, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  public void uploadWebCoreLog2Server()
  {
    if (!this.mX5Used) {
      return;
    }
    invokeStaticMethod(this.mIsDynamicMode, "com.tencent.smtt.util.MttLog", "uploadLogFilesToServer", null, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.WebViewWizardBase
 * JD-Core Version:    0.7.0.1
 */