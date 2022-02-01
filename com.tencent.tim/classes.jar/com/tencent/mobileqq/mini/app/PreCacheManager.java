package com.tencent.mobileqq.mini.app;

import NS_COMM.COMM.Entry;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class PreCacheManager
{
  public static final String CACHE_TYPE_PERIODIC = "periodic";
  public static final String CACHE_TYPE_PRE = "pre";
  public static final String CACHE_TYPE_STATIC = "static";
  private static final String TAG = "miniapp-start_PreCacheManager";
  private static PreCacheManager instance;
  private static byte[] lock = new byte[0];
  private int PRECACHE_CONTENT_SIZE = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_precache_size_limit", 262144);
  private long PRECACHE_PERIOD_MILLIS = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_precache_period_millis", 43200000L);
  private int PRECACHE_RESOURCE_MAX_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_precache_resource_maxsize", 3);
  
  private void doFetchPreCacheData(MiniAppConfig paramMiniAppConfig, String paramString, OnCacheListener paramOnCacheListener)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {}
    label11:
    String str2;
    int i;
    PreCacheInfo localPreCacheInfo;
    Object localObject1;
    do
    {
      int j;
      do
      {
        do
        {
          Iterator localIterator;
          do
          {
            return;
            break label11;
            while ((paramMiniAppConfig.config.preCacheList == null) || (paramMiniAppConfig.config.preCacheList.size() <= 0)) {}
            j = getCacheType(paramString);
            str2 = "[" + paramString + " Cache]";
            i = 1;
            localIterator = paramMiniAppConfig.config.preCacheList.iterator();
          } while (!localIterator.hasNext());
          localPreCacheInfo = (PreCacheInfo)localIterator.next();
        } while (i <= 0);
      } while ((localPreCacheInfo == null) || (localPreCacheInfo.cacheType != j));
      localObject1 = getPreFetchAppCacheData(paramMiniAppConfig, paramString);
      if (localObject1 == null) {
        break;
      }
      QLog.i("miniapp-start_PreCacheManager", 1, str2 + " last PreCache url:" + ((PreCacheDescData)localObject1).url + " timestamp:" + ((PreCacheDescData)localObject1).timeStamp);
      if ((!"periodic".equals(paramString)) || (!localPreCacheInfo.getDataUrl.equals(((PreCacheDescData)localObject1).url)) || (System.currentTimeMillis() - ((PreCacheDescData)localObject1).timeStamp >= this.PRECACHE_PERIOD_MILLIS)) {
        break;
      }
      QLog.i("miniapp-start_PreCacheManager", 1, str2 + " last PreCache is still in validity period.");
    } while (paramOnCacheListener == null);
    paramOnCacheListener.onCacheUpdated(true, false);
    return;
    String str1;
    if ("pre".equals(paramString))
    {
      str1 = paramMiniAppConfig.launchParam.entryPath;
      localObject1 = "";
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      if (((String)localObject2).contains("?")) {
        localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf("?") + 1);
      }
    }
    for (;;)
    {
      try
      {
        str1 = URLEncoder.encode((String)localObject2, "UTF-8");
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject2 = URLEncoder.encode((String)localObject1, "UTF-8");
          localObject1 = localObject2;
          localObject2 = str1;
          localObject1 = "appid=" + paramMiniAppConfig.config.appId + "&timestamp=" + System.currentTimeMillis() + "&path=" + (String)localObject2 + "&query=" + (String)localObject1 + "&scene=" + paramMiniAppConfig.launchParam.scene;
          localObject2 = getBackgroundFetchToken(paramMiniAppConfig);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label496;
          }
          MiniAppCmdUtil.getInstance().getLoginCode(paramMiniAppConfig.config.appId, new PreCacheManager.2(this, str2, paramMiniAppConfig, localPreCacheInfo, paramString, (String)localObject1, paramOnCacheListener));
          i -= 1;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localObject2 = localThrowable1;
            Object localObject3 = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
      }
      QLog.e("miniapp-start_PreCacheManager", 1, localThrowable1, new Object[0]);
      continue;
      label496:
      doRequestPreCacheData(paramMiniAppConfig, localPreCacheInfo, paramString, (String)localObject1 + "&token=" + (String)localObject2, paramOnCacheListener);
      continue;
      if ("periodic".equals(paramString))
      {
        localObject1 = getBackgroundFetchToken(paramMiniAppConfig);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.e("miniapp-start_PreCacheManager", 1, str2 + "token is null!");
          return;
        }
        doRequestPreCacheData(paramMiniAppConfig, localPreCacheInfo, paramString, "appid=" + paramMiniAppConfig.config.appId + "&token=" + (String)localObject1 + "&timestamp=" + System.currentTimeMillis(), paramOnCacheListener);
      }
    }
  }
  
  private void doRequestPreCacheData(MiniAppConfig paramMiniAppConfig, PreCacheInfo paramPreCacheInfo, String paramString1, String paramString2, OnCacheListener paramOnCacheListener)
  {
    String str2 = "[" + paramString1 + " Cache]";
    String str3 = paramPreCacheInfo.getDataUrl;
    int i = str3.indexOf("?");
    if (i >= 0) {}
    for (String str1 = str3.substring(0, i) + paramString2 + str3.substring(i + 1);; str1 = str3 + "?" + paramString2)
    {
      QLog.i("miniapp-start_PreCacheManager", 1, str2 + "doRequestPreCacheData requestUrl:" + str1 + " useProxy:" + paramPreCacheInfo.useProxy + " query:" + paramString2);
      if (paramPreCacheInfo.useProxy <= 0) {
        break;
      }
      MiniAppCmdUtil.getInstance().getContentAccelerate(paramMiniAppConfig.config.appId, str1, 1, null, new PreCacheManager.3(this, str2, paramString1, paramMiniAppConfig, str3, paramOnCacheListener));
      return;
    }
    paramPreCacheInfo = new PreCacheDescData();
    paramPreCacheInfo.appid = paramMiniAppConfig.config.appId;
    paramPreCacheInfo.url = str3;
    paramPreCacheInfo.scene = paramMiniAppConfig.launchParam.scene;
    paramPreCacheInfo.path = paramMiniAppConfig.launchParam.entryPath;
    MiniAppFileManager.getInstance();
    paramString2 = MiniAppFileManager.getPreCacheFilePath(paramMiniAppConfig.config.appId, paramString1, paramPreCacheInfo.getCacheKey());
    MiniappDownloadUtil.getInstance().download(str1, paramString2, false, new PreCacheManager.4(this, str2, paramOnCacheListener, paramPreCacheInfo, paramString2, paramMiniAppConfig, paramString1), Downloader.DownloadMode.StrictMode, null);
  }
  
  public static PreCacheManager g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new PreCacheManager();
      }
      return instance;
    }
  }
  
  public static int getCacheType(String paramString)
  {
    if ("pre".equals(paramString)) {
      return 1;
    }
    if ("periodic".equals(paramString)) {
      return 2;
    }
    return 0;
  }
  
  public void doFetchPreResourceIfNeed(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      break label11;
    }
    label11:
    label231:
    for (;;)
    {
      return;
      if ((paramMiniAppConfig.config.resourcePreCacheInfo != null) && (paramMiniAppConfig.config.resourcePreCacheInfo.size() > 0))
      {
        int i = this.PRECACHE_RESOURCE_MAX_COUNT;
        Iterator localIterator = paramMiniAppConfig.config.resourcePreCacheInfo.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label231;
          }
          ResourcePreCacheInfo localResourcePreCacheInfo = (ResourcePreCacheInfo)localIterator.next();
          if (i <= 0) {
            break;
          }
          if ((localResourcePreCacheInfo != null) && (!TextUtils.isEmpty(localResourcePreCacheInfo.getDataUrl)))
          {
            i -= 1;
            QLog.i("miniapp-start_PreCacheManager", 1, "[Resource Cache] fetch PreCache url:" + localResourcePreCacheInfo.getDataUrl + " maxCount:" + this.PRECACHE_RESOURCE_MAX_COUNT);
            String str = getResourcePreCachePath(paramMiniAppConfig.config.appId, localResourcePreCacheInfo.getDataUrl);
            if (new File(str).exists()) {
              QLog.i("miniapp-start_PreCacheManager", 1, "[Resource Cache] PreCache already exist. path=" + str);
            } else {
              MiniappDownloadUtil.getInstance().download(localResourcePreCacheInfo.getDataUrl, str, false, new PreCacheManager.6(this, str), Downloader.DownloadMode.StrictMode, null);
            }
          }
        }
      }
    }
  }
  
  public void fetchPeriodicCacheIfNeed(MiniAppConfig paramMiniAppConfig, OnCacheListener paramOnCacheListener)
  {
    if (paramMiniAppConfig == null) {
      return;
    }
    doFetchPreCacheData(paramMiniAppConfig, "periodic", paramOnCacheListener);
  }
  
  public void fetchPreCacheData(MiniAppConfig paramMiniAppConfig)
  {
    ThreadManager.excute(new PreCacheManager.1(this, paramMiniAppConfig), 16, null, false);
  }
  
  public void fetchPreResourceIfNeed(MiniAppConfig paramMiniAppConfig)
  {
    ThreadManager.excute(new PreCacheManager.5(this, paramMiniAppConfig), 16, null, false);
  }
  
  public String getBackgroundFetchToken(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {
      return null;
    }
    return StorageUtil.getPreference().getString(paramMiniAppConfig.config.appId + "_precache_token", null);
  }
  
  /* Error */
  public PreCacheDescData getPreFetchAppCacheData(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_1
    //   6: aload_1
    //   7: areturn
    //   8: new 12	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData
    //   11: dup
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial 403	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Ljava/lang/String;)V
    //   17: astore 5
    //   19: invokestatic 307	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   22: pop
    //   23: aload_1
    //   24: getfield 95	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   27: getfield 226	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   30: aload_2
    //   31: new 113	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   38: aload 5
    //   40: invokevirtual 310	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:getCacheKey	()Ljava/lang/String;
    //   43: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 405
    //   49: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 314	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getPreCacheFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_1
    //   59: ldc 12
    //   61: aload_1
    //   62: invokestatic 411	com/tencent/mobileqq/mini/util/ParcelableUtil:readParcelableFromFile	(Ljava/lang/Class;Ljava/lang/String;)Landroid/os/Parcelable;
    //   65: checkcast 12	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData
    //   68: astore_2
    //   69: aload_2
    //   70: ifnull +173 -> 243
    //   73: aload_2
    //   74: getfield 414	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   77: ifnull +166 -> 243
    //   80: new 356	java/io/File
    //   83: dup
    //   84: aload_2
    //   85: getfield 414	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   88: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 362	java/io/File:exists	()Z
    //   96: istore 4
    //   98: iload 4
    //   100: ifne +45 -> 145
    //   103: iconst_0
    //   104: ifeq +11 -> 115
    //   107: new 416	java/lang/NullPointerException
    //   110: dup
    //   111: invokespecial 417	java/lang/NullPointerException:<init>	()V
    //   114: athrow
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: ldc 26
    //   120: iconst_1
    //   121: ldc 200
    //   123: aload_1
    //   124: invokestatic 420	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload 5
    //   129: astore_2
    //   130: goto -61 -> 69
    //   133: astore_1
    //   134: ldc 26
    //   136: ldc 200
    //   138: aload_1
    //   139: invokestatic 425	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   142: goto -27 -> 115
    //   145: new 427	java/io/FileInputStream
    //   148: dup
    //   149: aload_1
    //   150: invokespecial 430	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   153: astore 5
    //   155: aload 5
    //   157: astore_1
    //   158: aload 5
    //   160: invokevirtual 433	java/io/FileInputStream:available	()I
    //   163: istore_3
    //   164: aload 5
    //   166: astore_1
    //   167: iload_3
    //   168: newarray byte
    //   170: astore 6
    //   172: aload 5
    //   174: astore_1
    //   175: aload 5
    //   177: aload 6
    //   179: iconst_0
    //   180: iload_3
    //   181: invokevirtual 437	java/io/FileInputStream:read	([BII)I
    //   184: pop
    //   185: aload 5
    //   187: astore_1
    //   188: aload_2
    //   189: aload 6
    //   191: putfield 440	com/tencent/mobileqq/mini/app/PreCacheManager$PreCacheDescData:data	[B
    //   194: aload_2
    //   195: astore_1
    //   196: aload 5
    //   198: ifnull -192 -> 6
    //   201: aload 5
    //   203: invokevirtual 443	java/io/FileInputStream:close	()V
    //   206: aload_2
    //   207: areturn
    //   208: astore_1
    //   209: ldc 26
    //   211: ldc 200
    //   213: aload_1
    //   214: invokestatic 425	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_2
    //   218: areturn
    //   219: astore 6
    //   221: aconst_null
    //   222: astore_2
    //   223: aload_2
    //   224: astore_1
    //   225: ldc 26
    //   227: iconst_1
    //   228: ldc 200
    //   230: aload 6
    //   232: invokestatic 445	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   235: aload_2
    //   236: ifnull +7 -> 243
    //   239: aload_2
    //   240: invokevirtual 443	java/io/FileInputStream:close	()V
    //   243: aconst_null
    //   244: areturn
    //   245: astore_1
    //   246: ldc 26
    //   248: ldc 200
    //   250: aload_1
    //   251: invokestatic 425	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   254: goto -11 -> 243
    //   257: astore_2
    //   258: aconst_null
    //   259: astore_1
    //   260: aload_1
    //   261: ifnull +7 -> 268
    //   264: aload_1
    //   265: invokevirtual 443	java/io/FileInputStream:close	()V
    //   268: aload_2
    //   269: athrow
    //   270: astore_1
    //   271: ldc 26
    //   273: ldc 200
    //   275: aload_1
    //   276: invokestatic 425	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: goto -11 -> 268
    //   282: astore_2
    //   283: goto -23 -> 260
    //   286: astore 6
    //   288: aload 5
    //   290: astore_2
    //   291: goto -68 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	PreCacheManager
    //   0	294	1	paramMiniAppConfig	MiniAppConfig
    //   0	294	2	paramString	String
    //   163	18	3	i	int
    //   96	3	4	bool	boolean
    //   17	272	5	localObject	Object
    //   170	20	6	arrayOfByte	byte[]
    //   219	12	6	localThrowable1	Throwable
    //   286	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   59	69	117	java/lang/Throwable
    //   107	115	133	java/lang/Throwable
    //   201	206	208	java/lang/Throwable
    //   80	98	219	java/lang/Throwable
    //   145	155	219	java/lang/Throwable
    //   239	243	245	java/lang/Throwable
    //   80	98	257	finally
    //   145	155	257	finally
    //   264	268	270	java/lang/Throwable
    //   158	164	282	finally
    //   167	172	282	finally
    //   175	185	282	finally
    //   188	194	282	finally
    //   225	235	282	finally
    //   158	164	286	java/lang/Throwable
    //   167	172	286	java/lang/Throwable
    //   175	185	286	java/lang/Throwable
    //   188	194	286	java/lang/Throwable
  }
  
  public String getResourcePreCachePath(String paramString1, String paramString2)
  {
    MiniAppFileManager.getInstance();
    return MiniAppFileManager.getPreCacheFilePath(paramString1, "static", "" + paramString2.hashCode());
  }
  
  public void notifyPeriodicCacheUpdated(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {}
    AppBrandRuntime localAppBrandRuntime;
    do
    {
      return;
      QLog.i("miniapp-start_PreCacheManager", 1, "[periodic Cache] notify PeriodicCacheUpdated");
      localAppBrandRuntime = AppBrandRuntimeContainer.g().getCurrentAppBrandRuntime();
    } while ((localAppBrandRuntime == null) || (localAppBrandRuntime.getApkgInfo() == null) || (localAppBrandRuntime.getApkgInfo().appConfig == null) || (!localAppBrandRuntime.getApkgInfo().appConfig.config.appId.equals(paramMiniAppConfig.config.appId)));
    localAppBrandRuntime.evaluateServiceSubcribeJS("onBackgroundFetchData", new JSONObject().toString());
  }
  
  public void setBackgroundFetchToken(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if ((paramMiniAppConfig == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    StorageUtil.getPreference().edit().putString(paramMiniAppConfig.config.appId + "_precache_token", paramString).apply();
  }
  
  public static class ContentAccelerateRsp
    implements Parcelable
  {
    public static final Parcelable.Creator<ContentAccelerateRsp> CREATOR = new PreCacheManager.ContentAccelerateRsp.1();
    public byte[] cacheData;
    public int httpReturnCode;
    public List<COMM.Entry> rspHeaders;
    
    public ContentAccelerateRsp() {}
    
    protected ContentAccelerateRsp(Parcel paramParcel)
    {
      this.rspHeaders = new ArrayList();
      paramParcel.readList(this.rspHeaders, COMM.Entry.class.getClassLoader());
      this.cacheData = paramParcel.createByteArray();
      this.httpReturnCode = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeList(this.rspHeaders);
      paramParcel.writeByteArray(this.cacheData);
      paramParcel.writeInt(this.httpReturnCode);
    }
  }
  
  public static abstract interface OnCacheListener
  {
    public abstract void onCacheUpdated(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  public static class PreCacheDescData
    implements Parcelable
  {
    public static final Parcelable.Creator<PreCacheDescData> CREATOR = new PreCacheManager.PreCacheDescData.1();
    public String appid;
    public String cacheKey;
    public byte[] data;
    public String filePath;
    public String path;
    public int scene;
    public long timeStamp;
    public String url;
    
    public PreCacheDescData() {}
    
    protected PreCacheDescData(Parcel paramParcel)
    {
      this.appid = paramParcel.readString();
      this.url = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.path = paramParcel.readString();
      this.timeStamp = paramParcel.readLong();
      this.filePath = paramParcel.readString();
    }
    
    public PreCacheDescData(MiniAppConfig paramMiniAppConfig, String paramString)
    {
      this.appid = paramMiniAppConfig.config.appId;
      this.scene = paramMiniAppConfig.launchParam.scene;
      this.path = paramMiniAppConfig.launchParam.entryPath;
      int i = PreCacheManager.getCacheType(paramString);
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.preCacheList != null))
      {
        paramMiniAppConfig = paramMiniAppConfig.config.preCacheList.iterator();
        while (paramMiniAppConfig.hasNext())
        {
          paramString = (PreCacheInfo)paramMiniAppConfig.next();
          if ((paramString != null) && (paramString.cacheType == i)) {
            this.url = paramString.getDataUrl;
          }
        }
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getCacheKey()
    {
      if (TextUtils.isEmpty(this.cacheKey))
      {
        String str = this.appid + "_" + this.url + "_" + this.scene + "_" + this.path;
        this.cacheKey = ("" + str.hashCode());
      }
      return this.cacheKey;
    }
    
    public String getQuery()
    {
      if (TextUtils.isEmpty(this.path)) {
        return "";
      }
      if (this.path.contains("?")) {
        return this.path.substring(this.path.indexOf("?") + 1);
      }
      return "";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.appid);
      paramParcel.writeString(this.url);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.path);
      paramParcel.writeLong(this.timeStamp);
      paramParcel.writeString(this.filePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager
 * JD-Core Version:    0.7.0.1
 */