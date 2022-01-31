package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.utils.ReflectionUtils;
import java.io.File;

public final class CacheManager
{
  @Deprecated
  public static boolean cacheDisabled()
  {
    boolean bool = false;
    Object localObject = SDKEngine.getInstance(false);
    if ((localObject != null) && (((SDKEngine)localObject).isX5Core())) {
      bool = ((Boolean)((SDKEngine)localObject).wizard().cacheDisabled()).booleanValue();
    }
    do
    {
      return bool;
      localObject = ReflectionUtils.invokeStatic("android.webkit.CacheManager", "cacheDisabled");
    } while (localObject == null);
    return ((Boolean)localObject).booleanValue();
  }
  
  @Deprecated
  public static File getCacheFileBaseDir()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return (File)localSDKEngine.wizard().getCachFileBaseDir();
    }
    return (File)ReflectionUtils.invokeStatic("android.webkit.CacheManager", "getCacheFileBaseDir");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.CacheManager
 * JD-Core Version:    0.7.0.1
 */