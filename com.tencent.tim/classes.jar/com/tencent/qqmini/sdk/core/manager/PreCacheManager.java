package com.tencent.qqmini.sdk.core.manager;

import NS_COMM.COMM.Entry;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PreCacheInfo;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PreCacheManager
{
  public static final String CACHE_TYPE_PERIODIC = "periodic";
  public static final String CACHE_TYPE_PRE = "pre";
  public static final String CACHE_TYPE_STATIC = "static";
  private static final String TAG = "minisdk-start_PreCacheManager";
  private static PreCacheManager instance;
  private static byte[] lock = new byte[0];
  private int PRECACHE_CONTENT_SIZE = WnsConfig.getConfig("qqminiapp", "mini_app_precache_size_limit", 262144);
  private long PRECACHE_PERIOD_MILLIS = WnsConfig.getConfig("qqminiapp", "mini_app_precache_period_millis", 43200000L);
  private int PRECACHE_RESOURCE_MAX_COUNT = WnsConfig.getConfig("qqminiapp", "mini_app_precache_resource_maxsize", 3);
  
  private void doFetchPreCacheData(MiniAppInfo paramMiniAppInfo, String paramString, OnCacheListener paramOnCacheListener)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    String str2;
    int i;
    PreCacheInfo localPreCacheInfo;
    Object localObject1;
    do
    {
      int j;
      do
      {
        Iterator localIterator;
        do
        {
          do
          {
            QMLog.i("minisdk-start_PreCacheManager", "doFetchPreCacheData last PreCache url:");
          } while ((paramMiniAppInfo.preCacheList == null) || (paramMiniAppInfo.preCacheList.size() <= 0));
          j = getCacheType(paramString);
          str2 = "[" + paramString + " Cache]";
          i = 1;
          localIterator = paramMiniAppInfo.preCacheList.iterator();
        } while (!localIterator.hasNext());
        localPreCacheInfo = (PreCacheInfo)localIterator.next();
      } while (i <= 0);
      if ((localPreCacheInfo == null) || (localPreCacheInfo.cacheType != j)) {
        break;
      }
      localObject1 = getPreFetchAppCacheData(paramMiniAppInfo, paramString);
      if (localObject1 == null) {
        break label254;
      }
      QMLog.i("minisdk-start_PreCacheManager", str2 + " last PreCache url:" + ((PreCacheDescData)localObject1).url + " timestamp:" + ((PreCacheDescData)localObject1).timeStamp);
      if ((!"periodic".equals(paramString)) || (!localPreCacheInfo.getDataUrl.equals(((PreCacheDescData)localObject1).url)) || (System.currentTimeMillis() - ((PreCacheDescData)localObject1).timeStamp >= this.PRECACHE_PERIOD_MILLIS)) {
        break label254;
      }
      QMLog.i("minisdk-start_PreCacheManager", str2 + " last PreCache is still in validity period.");
    } while (paramOnCacheListener == null);
    paramOnCacheListener.onCacheUpdated(true, false);
    return;
    label254:
    String str1;
    if ("pre".equals(paramString))
    {
      str1 = paramMiniAppInfo.launchParam.entryPath;
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
          localObject1 = "appid=" + paramMiniAppInfo.appId + "&timestamp=" + System.currentTimeMillis() + "&path=" + (String)localObject2 + "&query=" + (String)localObject1 + "&scene=" + paramMiniAppInfo.launchParam.scene;
          localObject2 = getBackgroundFetchToken(paramMiniAppInfo);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label483;
          }
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).login(paramMiniAppInfo.appId, new PreCacheManager.2(this, str2, paramMiniAppInfo, localPreCacheInfo, paramString, (String)localObject1, paramOnCacheListener));
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
      QMLog.e("minisdk-start_PreCacheManager", "", localThrowable1);
      continue;
      label483:
      doRequestPreCacheData(paramMiniAppInfo, localPreCacheInfo, paramString, (String)localObject1 + "&token=" + (String)localObject2, paramOnCacheListener);
      continue;
      if ("periodic".equals(paramString))
      {
        localObject1 = getBackgroundFetchToken(paramMiniAppInfo);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QMLog.e("minisdk-start_PreCacheManager", str2 + "token is null!");
          return;
        }
        doRequestPreCacheData(paramMiniAppInfo, localPreCacheInfo, paramString, "appid=" + paramMiniAppInfo.appId + "&token=" + (String)localObject1 + "&timestamp=" + System.currentTimeMillis(), paramOnCacheListener);
      }
    }
  }
  
  private void doRequestPreCacheData(MiniAppInfo paramMiniAppInfo, PreCacheInfo paramPreCacheInfo, String paramString1, String paramString2, OnCacheListener paramOnCacheListener)
  {
    String str2 = "[" + paramString1 + " Cache]";
    String str3 = paramPreCacheInfo.getDataUrl;
    int i = str3.indexOf("?");
    if (i >= 0) {}
    for (String str1 = str3.substring(0, i) + paramString2 + str3.substring(i + 1);; str1 = str3 + "?" + paramString2)
    {
      QMLog.i("minisdk-start_PreCacheManager", str2 + "doRequestPreCacheData requestUrl:" + str1 + " useProxy:" + paramPreCacheInfo.useProxy + " query:" + paramString2);
      if (paramPreCacheInfo.useProxy <= 0) {
        break;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getContentAccelerate(paramMiniAppInfo.appId, str1, 1, null, new PreCacheManager.3(this, str2, paramString1, paramMiniAppInfo, str3, paramOnCacheListener));
      return;
    }
    paramPreCacheInfo = new PreCacheDescData();
    paramPreCacheInfo.appid = paramMiniAppInfo.appId;
    paramPreCacheInfo.url = str3;
    paramPreCacheInfo.scene = paramMiniAppInfo.launchParam.scene;
    paramPreCacheInfo.path = paramMiniAppInfo.launchParam.entryPath;
    paramString2 = MiniAppFileManager.getPreCacheFilePath(paramMiniAppInfo.appId, paramString1, paramPreCacheInfo.getCacheKey(paramString1));
    new DownloaderProxyDefault().download(str1, null, paramString2, 20, new PreCacheManager.4(this, str2, str1, paramOnCacheListener, paramPreCacheInfo, paramString2, paramMiniAppInfo, paramString1));
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
  
  public void doFetchPreResourceIfNeed(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      break label4;
    }
    label4:
    label222:
    for (;;)
    {
      return;
      if ((paramMiniAppInfo.resourcePreCacheInfo != null) && (paramMiniAppInfo.resourcePreCacheInfo.size() > 0))
      {
        int i = this.PRECACHE_RESOURCE_MAX_COUNT;
        Iterator localIterator = paramMiniAppInfo.resourcePreCacheInfo.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label222;
          }
          Object localObject = (ResourcePreCacheInfo)localIterator.next();
          if (i <= 0) {
            break;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((ResourcePreCacheInfo)localObject).getDataUrl)))
          {
            i -= 1;
            QMLog.i("minisdk-start_PreCacheManager", "[Resource Cache] fetch PreCache url:" + ((ResourcePreCacheInfo)localObject).getDataUrl + " maxCount:" + this.PRECACHE_RESOURCE_MAX_COUNT);
            String str = getResourcePreCachePath(paramMiniAppInfo.appId, ((ResourcePreCacheInfo)localObject).getDataUrl);
            if (new File(str).exists())
            {
              QMLog.i("minisdk-start_PreCacheManager", "[Resource Cache] PreCache already exist. path=" + str);
            }
            else
            {
              DownloaderProxyDefault localDownloaderProxyDefault = new DownloaderProxyDefault();
              localObject = ((ResourcePreCacheInfo)localObject).getDataUrl;
              localDownloaderProxyDefault.download((String)localObject, null, str, 20, new PreCacheManager.6(this, (String)localObject, str));
            }
          }
        }
      }
    }
  }
  
  public void fetchPeriodicCacheIfNeed(MiniAppInfo paramMiniAppInfo, OnCacheListener paramOnCacheListener)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    doFetchPreCacheData(paramMiniAppInfo, "periodic", paramOnCacheListener);
  }
  
  public void fetchPreCacheData(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.executeOnDiskIOThreadPool(new PreCacheManager.1(this, paramMiniAppInfo));
  }
  
  public void fetchPreResourceIfNeed(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.executeOnDiskIOThreadPool(new PreCacheManager.5(this, paramMiniAppInfo));
  }
  
  public String getBackgroundFetchToken(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    return StorageUtil.getPreference().getString(paramMiniAppInfo.appId + "_precache_token", null);
  }
  
  /* Error */
  public PreCacheDescData getPreFetchAppCacheData(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_1
    //   6: aload_1
    //   7: areturn
    //   8: new 12	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData
    //   11: dup
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial 390	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:<init>	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload_1
    //   20: getfield 218	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   23: aload_2
    //   24: new 111	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   31: aload 5
    //   33: aload_2
    //   34: invokevirtual 301	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:getCacheKey	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 392
    //   43: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 307	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getPreCacheFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_1
    //   53: ldc 12
    //   55: aload_1
    //   56: invokestatic 398	com/tencent/qqmini/sdk/core/utils/ParcelableUtil:readParcelableFromFile	(Ljava/lang/Class;Ljava/lang/String;)Landroid/os/Parcelable;
    //   59: checkcast 12	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +171 -> 235
    //   67: aload_2
    //   68: getfield 401	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   71: ifnull +164 -> 235
    //   74: new 343	java/io/File
    //   77: dup
    //   78: aload_2
    //   79: getfield 401	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:filePath	Ljava/lang/String;
    //   82: invokespecial 346	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 349	java/io/File:exists	()Z
    //   90: istore 4
    //   92: iload 4
    //   94: ifne +44 -> 138
    //   97: iconst_0
    //   98: ifeq +11 -> 109
    //   101: new 403	java/lang/NullPointerException
    //   104: dup
    //   105: invokespecial 404	java/lang/NullPointerException:<init>	()V
    //   108: athrow
    //   109: aconst_null
    //   110: areturn
    //   111: astore_1
    //   112: ldc 26
    //   114: ldc 192
    //   116: aload_1
    //   117: invokestatic 406	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload 5
    //   122: astore_2
    //   123: goto -60 -> 63
    //   126: astore_1
    //   127: ldc 26
    //   129: ldc 192
    //   131: aload_1
    //   132: invokestatic 262	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: goto -26 -> 109
    //   138: new 408	java/io/FileInputStream
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 411	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   146: astore 5
    //   148: aload 5
    //   150: astore_1
    //   151: aload 5
    //   153: invokevirtual 414	java/io/FileInputStream:available	()I
    //   156: istore_3
    //   157: aload 5
    //   159: astore_1
    //   160: iload_3
    //   161: newarray byte
    //   163: astore 6
    //   165: aload 5
    //   167: astore_1
    //   168: aload 5
    //   170: aload 6
    //   172: iconst_0
    //   173: iload_3
    //   174: invokevirtual 418	java/io/FileInputStream:read	([BII)I
    //   177: pop
    //   178: aload 5
    //   180: astore_1
    //   181: aload_2
    //   182: aload 6
    //   184: putfield 421	com/tencent/qqmini/sdk/core/manager/PreCacheManager$PreCacheDescData:data	[B
    //   187: aload_2
    //   188: astore_1
    //   189: aload 5
    //   191: ifnull -185 -> 6
    //   194: aload 5
    //   196: invokevirtual 424	java/io/FileInputStream:close	()V
    //   199: aload_2
    //   200: areturn
    //   201: astore_1
    //   202: ldc 26
    //   204: ldc 192
    //   206: aload_1
    //   207: invokestatic 262	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_2
    //   211: areturn
    //   212: astore 6
    //   214: aconst_null
    //   215: astore_2
    //   216: aload_2
    //   217: astore_1
    //   218: ldc 26
    //   220: ldc 192
    //   222: aload 6
    //   224: invokestatic 262	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_2
    //   228: ifnull +7 -> 235
    //   231: aload_2
    //   232: invokevirtual 424	java/io/FileInputStream:close	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: ldc 26
    //   240: ldc 192
    //   242: aload_1
    //   243: invokestatic 262	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: goto -11 -> 235
    //   249: astore_2
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 424	java/io/FileInputStream:close	()V
    //   260: aload_2
    //   261: athrow
    //   262: astore_1
    //   263: ldc 26
    //   265: ldc 192
    //   267: aload_1
    //   268: invokestatic 262	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: goto -11 -> 260
    //   274: astore_2
    //   275: goto -23 -> 252
    //   278: astore 6
    //   280: aload 5
    //   282: astore_2
    //   283: goto -67 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	PreCacheManager
    //   0	286	1	paramMiniAppInfo	MiniAppInfo
    //   0	286	2	paramString	String
    //   156	18	3	i	int
    //   90	3	4	bool	boolean
    //   17	264	5	localObject	Object
    //   163	20	6	arrayOfByte	byte[]
    //   212	11	6	localThrowable1	Throwable
    //   278	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	63	111	java/lang/Throwable
    //   101	109	126	java/lang/Throwable
    //   194	199	201	java/lang/Throwable
    //   74	92	212	java/lang/Throwable
    //   138	148	212	java/lang/Throwable
    //   231	235	237	java/lang/Throwable
    //   74	92	249	finally
    //   138	148	249	finally
    //   256	260	262	java/lang/Throwable
    //   151	157	274	finally
    //   160	165	274	finally
    //   168	178	274	finally
    //   181	187	274	finally
    //   218	227	274	finally
    //   151	157	278	java/lang/Throwable
    //   160	165	278	java/lang/Throwable
    //   168	178	278	java/lang/Throwable
    //   181	187	278	java/lang/Throwable
  }
  
  public String getResourcePreCachePath(String paramString1, String paramString2)
  {
    return MiniAppFileManager.getPreCacheFilePath(paramString1, "static", "" + paramString2.hashCode());
  }
  
  public void notifyPeriodicCacheUpdated(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    QMLog.i("minisdk-start_PreCacheManager", "[periodic Cache] notify PeriodicCacheUpdated");
  }
  
  public void setBackgroundFetchToken(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    StorageUtil.getPreference().edit().putString(paramMiniAppInfo.appId + "_precache_token", paramString).apply();
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
    
    public PreCacheDescData(MiniAppInfo paramMiniAppInfo, String paramString)
    {
      this.appid = paramMiniAppInfo.appId;
      this.scene = paramMiniAppInfo.launchParam.scene;
      this.path = paramMiniAppInfo.launchParam.entryPath;
      int i = PreCacheManager.getCacheType(paramString);
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.preCacheList != null))
      {
        paramMiniAppInfo = paramMiniAppInfo.preCacheList.iterator();
        while (paramMiniAppInfo.hasNext())
        {
          paramString = (PreCacheInfo)paramMiniAppInfo.next();
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
    
    public String getCacheKey(String paramString)
    {
      if ("periodic".equals(paramString))
      {
        paramString = this.appid + "_" + this.url;
        return "" + paramString.hashCode();
      }
      if (TextUtils.isEmpty(this.cacheKey))
      {
        paramString = this.appid + "_" + this.url + "_" + this.scene + "_" + this.path;
        this.cacheKey = ("" + paramString.hashCode());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager
 * JD-Core Version:    0.7.0.1
 */