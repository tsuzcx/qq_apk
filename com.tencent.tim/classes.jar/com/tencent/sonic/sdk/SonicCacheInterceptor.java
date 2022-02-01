package com.tencent.sonic.sdk;

import android.text.TextUtils;
import java.io.File;

public abstract class SonicCacheInterceptor
{
  public static final String TAG = "SonicSdk_SonicCacheInterceptor";
  private final SonicCacheInterceptor nextInterceptor;
  
  public SonicCacheInterceptor(SonicCacheInterceptor paramSonicCacheInterceptor)
  {
    this.nextInterceptor = paramSonicCacheInterceptor;
  }
  
  static String getSonicCacheData(SonicSession paramSonicSession)
  {
    SonicCacheInterceptor localSonicCacheInterceptor = paramSonicSession.config.cacheInterceptor;
    Object localObject;
    if (localSonicCacheInterceptor == null) {
      localObject = SonicCacheInterceptorDefaultImpl.getCacheData(paramSonicSession);
    }
    label45:
    for (;;)
    {
      return localObject;
      String str;
      for (localObject = null;; localObject = str)
      {
        if (localSonicCacheInterceptor == null) {
          break label45;
        }
        str = localSonicCacheInterceptor.getCacheData(paramSonicSession);
        localObject = str;
        if (str != null) {
          break;
        }
        localSonicCacheInterceptor = localSonicCacheInterceptor.next();
      }
    }
  }
  
  public abstract String getCacheData(SonicSession paramSonicSession);
  
  public SonicCacheInterceptor next()
  {
    return this.nextInterceptor;
  }
  
  static class SonicCacheInterceptorDefaultImpl
  {
    public static final String TAG = "SonicSdk_DefaultSonicCacheInterceptor";
    
    public static String getCacheData(SonicSession paramSonicSession)
    {
      boolean bool2 = true;
      Object localObject;
      if (paramSonicSession == null)
      {
        SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, "getCache is null");
        localObject = null;
        return localObject;
      }
      SonicDataHelper.SessionData localSessionData = SonicDataHelper.getSessionData(paramSonicSession.id);
      String str = "";
      boolean bool1;
      if ((TextUtils.isEmpty(localSessionData.eTag)) || (TextUtils.isEmpty(localSessionData.htmlSha1)))
      {
        SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, "session(" + paramSonicSession.sId + ") runSonicFlow : session data is empty.");
        bool1 = bool2;
      }
      for (;;)
      {
        localObject = str;
        if (!bool1) {
          break;
        }
        long l = System.currentTimeMillis();
        SonicUtils.removeSessionCache(paramSonicSession.id);
        localSessionData.reset();
        SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, "session(" + paramSonicSession.sId + ") runSonicFlow:verify error so remove session cache, cost " + (System.currentTimeMillis() - l) + "ms.");
        return str;
        SonicDataHelper.updateSonicCacheHitCount(paramSonicSession.id);
        localObject = new File(SonicFileUtils.getSonicHtmlPath(paramSonicSession.id));
        str = SonicFileUtils.readFile((File)localObject);
        bool1 = TextUtils.isEmpty(str);
        if (bool1)
        {
          SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 6, "session(" + paramSonicSession.sId + ") runSonicFlow error:cache data is null.");
        }
        else if (SonicEngine.getInstance().getConfig().VERIFY_CACHE_FILE_WITH_SHA1)
        {
          if (!SonicFileUtils.verifyData(str, localSessionData.htmlSha1))
          {
            str = "";
            SonicEngine.getInstance().getRuntime().notifyError(paramSonicSession.sessionClient, paramSonicSession.srcUrl, -1001);
            SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 6, "session(" + paramSonicSession.sId + ") runSonicFlow error:verify html cache with sha1 fail.");
            bool1 = bool2;
          }
          else
          {
            SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, "session(" + paramSonicSession.sId + ") runSonicFlow verify html cache with sha1 success.");
          }
        }
        else if (localSessionData.htmlSize != ((File)localObject).length())
        {
          str = "";
          SonicEngine.getInstance().getRuntime().notifyError(paramSonicSession.sessionClient, paramSonicSession.srcUrl, -1001);
          SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 6, "session(" + paramSonicSession.sId + ") runSonicFlow error:verify html cache with size fail.");
          bool1 = bool2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicCacheInterceptor
 * JD-Core Version:    0.7.0.1
 */