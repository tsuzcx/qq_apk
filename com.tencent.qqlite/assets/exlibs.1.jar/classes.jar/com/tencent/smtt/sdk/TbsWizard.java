package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

class TbsWizard
{
  private static final String TAG = "TbsWizard";
  static final String WEBCOREPROXY_CLASSNAME = "com.tencent.tbs.tbsshell.WebCoreProxy";
  private Throwable loadFailureDetails = null;
  private Context mCallerAppContext = null;
  private String[] mDexFileList = null;
  private DexLoader mDexLoader = null;
  private String mDexOptPath = "TbsDexOpt";
  private Context mHostContext = null;
  private String mtbsInstallLocation = null;
  
  public TbsWizard(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString)
    throws Exception
  {
    TbsLog.i("TbsWizard", "construction start...");
    if ((paramContext1 == null) || (paramContext2 == null) || (TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      throw new Exception("TbsWizard paramter error:-1");
    }
    this.mCallerAppContext = paramContext1.getApplicationContext();
    this.mHostContext = paramContext2;
    this.mtbsInstallLocation = paramString1;
    this.mDexFileList = paramArrayOfString;
    this.mDexOptPath = paramString2;
    this.mDexLoader = new DexLoader(this.mCallerAppContext, this.mDexFileList, paramString2);
    libwebp.loadWepLibraryIfNeed(paramContext2, this.mtbsInstallLocation);
    int i = init(paramContext1);
    if (i < 0) {
      throw new Exception("TbsWizard init error:" + i, this.loadFailureDetails);
    }
    TbsLog.i("TbsWizard", "construction end...");
  }
  
  private int init(Context paramContext)
  {
    Object localObject1 = this.mDexLoader;
    Object localObject2 = Integer.TYPE;
    Object localObject3 = this.mHostContext;
    Object localObject4 = this.mDexLoader;
    String str1 = this.mtbsInstallLocation;
    String str2 = this.mDexOptPath;
    String str3 = QbSdk.getTbsCoreVersionString();
    localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "2.0.0.1044", Integer.valueOf(36001), str3 });
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      setSdkVersionNameInTbsShell();
      setSdkVersionInTbsShell();
      localObject1 = this.mDexLoader;
      localObject2 = this.mHostContext;
      localObject3 = this.mDexLoader;
      localObject4 = this.mtbsInstallLocation;
      str1 = this.mDexOptPath;
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, str1 });
    }
    int i;
    if (localObject1 == null) {
      i = -3;
    }
    while (i < 0)
    {
      paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof Throwable))) {
        this.loadFailureDetails = ((Throwable)paramContext);
      }
      return i;
      if ((localObject1 instanceof Integer)) {
        i = ((Integer)localObject1).intValue();
      } else {
        i = -4;
      }
    }
    this.loadFailureDetails = null;
    return i;
  }
  
  private void setSdkVersionInTbsShell()
  {
    this.mDexLoader.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(36001));
  }
  
  private void setSdkVersionNameInTbsShell()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "2.0.0.1044" });
  }
  
  public Object cacheDisabled()
  {
    return this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
  }
  
  public void clearAllX5Cache(Context paramContext, boolean paramBoolean)
  {
    Log.e("desktop", " tbsWizard clearAllX5Cache");
    if (paramBoolean)
    {
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[] { Context.class }, new Object[] { paramContext });
      return;
    }
    try
    {
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[] { Context.class, Boolean.TYPE }, new Object[] { paramContext, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
      this.mDexLoader.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
      this.mDexLoader.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
      paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
      if (paramContext != null) {
        this.mDexLoader.invokeMethod(paramContext, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
      }
      paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
      if (paramContext != null) {
        this.mDexLoader.invokeMethod(paramContext, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
      }
      this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }
  }
  
  public void closeIconDB()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
  }
  
  public boolean cookieManager_acceptCookie()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public boolean cookieManager_hasCookies()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public void cookieManager_removeAllCookie()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
  }
  
  public IX5DateSorter createDateSorter(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return null;
    }
    return (IX5DateSorter)paramContext;
  }
  
  public IX5WebChromeClient createDefaultX5WebChromeClient()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (IX5WebChromeClient)localObject;
  }
  
  public IX5WebViewClientExtension createDefaultX5WebChromeClientExtension()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (IX5WebViewClientExtension)localObject;
  }
  
  public IX5WebViewClient createDefaultX5WebViewClient()
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (IX5WebViewClient)localObject;
  }
  
  public Object createGameHostBridgeFakeActivity(Activity paramActivity)
  {
    Object localObject = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createGameHostBridgeFakeActivity", new Class[] { Activity.class }, new Object[] { paramActivity });
    paramActivity = localObject;
    if (localObject == null) {
      paramActivity = null;
    }
    return paramActivity;
  }
  
  public IX5WebViewBase createSDKWebview(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return null;
    }
    return (IX5WebViewBase)paramContext;
  }
  
  public DexLoader dexLoader()
  {
    return this.mDexLoader;
  }
  
  public void geolocationPermissionsAllow(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void geolocationPermissionsClear(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void geolocationPermissionsClearAll()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
  }
  
  public void geolocationPermissionsGetAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
  }
  
  public void geolocationPermissionsGetOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public Object getCachFileBaseDir()
  {
    return this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
  }
  
  public InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[] { String.class, Boolean.TYPE }, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramString == null) {
      return null;
    }
    return (InputStream)paramString;
  }
  
  public String getCookie(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public String getCrashExtraMessage()
  {
    String str = null;
    Object localObject1 = this.mDexLoader.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
    Object localObject2 = this.mDexLoader.invokeStaticMethod("com.tencent.mtt.video.internal.media.WonderPlayer", "getVersion", null, new Object[0]);
    if (localObject1 != null) {
      if (localObject2 == null) {
        break label115;
      }
    }
    label115:
    for (str = String.valueOf(localObject1) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion + " WonderPlayVersion=" + String.valueOf(localObject2);; str = String.valueOf(localObject1) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion)
    {
      localObject1 = str;
      if (str == null) {
        localObject1 = "X5 core get nothing...";
      }
      return localObject1;
    }
  }
  
  public Bitmap getIconForPageUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (Bitmap)paramString;
  }
  
  public String mimeTypeMapGetExtensionFromMimeType(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public String mimeTypeMapGetFileExtensionFromUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public String mimeTypeMapGetMimeTypeFromExtension(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public boolean mimeTypeMapHasExtension(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean mimeTypeMapHasMimeType(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public void openIconDB(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public Uri[] parseFileChooserResult(int paramInt, Intent paramIntent)
  {
    paramIntent = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[] { Integer.TYPE, Intent.class }, new Object[] { Integer.valueOf(paramInt), paramIntent });
    if (paramIntent == null) {
      return null;
    }
    return (Uri[])paramIntent;
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void removeAllIcons()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
  }
  
  public void requestIconForPageUrl(String paramString, IconListener paramIconListener)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[] { String.class, IconListener.class }, new Object[] { paramString, paramIconListener });
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public int startMiniQB(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    if (paramString2 == null)
    {
      paramString2 = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString1, paramMap });
      paramMap = paramString2;
      if (paramString2 == null) {
        paramMap = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      }
      if (paramMap != null) {}
    }
    do
    {
      return -3;
      return ((Integer)paramMap).intValue();
      paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 });
    } while (paramContext == null);
    return ((Integer)paramContext).intValue();
  }
  
  public String urlUtilComposeSearchUrl(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null) {
      return null;
    }
    return (String)paramString1;
  }
  
  public byte[] urlUtilDecode(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[] { String.class }, new Object[] { paramArrayOfByte });
    if (paramArrayOfByte == null) {
      return null;
    }
    return (byte[])paramArrayOfByte;
  }
  
  public String urlUtilGuessFileName(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null) {
      return null;
    }
    return (String)paramString1;
  }
  
  public String urlUtilGuessUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public boolean urlUtilIsAboutUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsAssetUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsContentUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsCookielessProxyUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsDataUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsFileUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsHttpUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsHttpsUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsJavaScriptUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsNetworkUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean urlUtilIsValidUrl(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public String urlUtilStripAnchor(String paramString)
  {
    paramString = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public void webStorageDeleteAllData()
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
  }
  
  public void webStorageDeleteOrigin(String paramString)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void webStorageGetOrigins(ValueCallback<Map> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void webStorageGetQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
  }
  
  public void webStorageGetUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
  }
  
  public void webStorageSetQuotaForOrigin(String paramString, long paramLong)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[] { String.class, Long.TYPE }, new Object[] { paramString, Long.valueOf(paramLong) });
  }
  
  public void webViewDatabaseClearFormData(Context paramContext)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public void webViewDatabaseClearHttpAuthUsernamePassword(Context paramContext)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public void webViewDatabaseClearUsernamePassword(Context paramContext)
  {
    this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public boolean webViewDatabaseHasFormData(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public boolean webViewDatabaseHasHttpAuthUsernamePassword(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public boolean webViewDatabaseHasUsernamePassword(Context paramContext)
  {
    paramContext = this.mDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsWizard
 * JD-Core Version:    0.7.0.1
 */