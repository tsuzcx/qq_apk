package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;

public final class TPMediaDecoderList
{
  private static final String MEDIA_DECODER_INFO_KEY = "DecoderInfos_Key";
  private static String MEDIA_DECODER_VERSION = "2.20.0.1086.full";
  private static final String MEDIA_DECODER_VERSION_KEY = "Version_Key";
  private static final String TAG = "TPMediaDecoderList";
  private static TPMediaDecoderInfo[] sDecoderInfos = null;
  
  private static String buildCacheDecoderVersion()
  {
    return MEDIA_DECODER_VERSION + "_" + TPSystemInfo.getDeviceName() + "_" + TPSystemInfo.getProductBoard() + "_" + TPSystemInfo.getProductDevice() + "_" + TPSystemInfo.getApiLevel();
  }
  
  private static void cacheDecoderInfos(LocalCache paramLocalCache, TPMediaDecoderInfo[] paramArrayOfTPMediaDecoderInfo)
  {
    try
    {
      paramLocalCache.put("DecoderInfos_Key", paramArrayOfTPMediaDecoderInfo);
      return;
    }
    catch (Throwable paramLocalCache)
    {
      TPNativeLog.printLog(4, "TPMediaDecoderList", "cache decode infos failed");
    }
  }
  
  private static void cacheVersion(LocalCache paramLocalCache, String paramString)
  {
    try
    {
      paramLocalCache.put("Version_Key", paramString);
      return;
    }
    catch (Throwable paramLocalCache)
    {
      TPNativeLog.printLog(4, "TPMediaDecoderList", "cache version failed");
    }
  }
  
  private static TPMediaDecoderInfo[] getCachedDecoderInfos(LocalCache paramLocalCache)
  {
    try
    {
      paramLocalCache = (TPMediaDecoderInfo[])paramLocalCache.getAsObject("DecoderInfos_Key");
      return paramLocalCache;
    }
    catch (Throwable paramLocalCache)
    {
      TPNativeLog.printLog(4, "TPMediaDecoderList", "get decoder info failed");
    }
    return null;
  }
  
  private static String getCachedVersion(LocalCache paramLocalCache)
  {
    try
    {
      paramLocalCache = paramLocalCache.getAsString("Version_Key");
      TPNativeLog.printLog(2, "TPMediaDecoderList", "version:" + paramLocalCache);
      return paramLocalCache;
    }
    catch (Throwable paramLocalCache)
    {
      TPNativeLog.printLog(4, "TPMediaDecoderList", "get version failed");
    }
    return null;
  }
  
  private static final MediaCodecInfo[] getCodecInfos()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return new MediaCodecInfo[0];
    }
    Object localObject;
    if (Build.VERSION.SDK_INT < 21)
    {
      int j = MediaCodecList.getCodecCount();
      localObject = new ArrayList();
      int i = 0;
      while (i < j)
      {
        ((ArrayList)localObject).add(MediaCodecList.getCodecInfoAt(i));
        i += 1;
      }
      return (MediaCodecInfo[])((ArrayList)localObject).toArray(new MediaCodecInfo[((ArrayList)localObject).size()]);
    }
    try
    {
      localObject = new MediaCodecList(1).getCodecInfos();
      return localObject;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, "getCodecInfos MediaCodecList " + localException.getMessage());
    }
    return new MediaCodecInfo[0];
  }
  
  private static final TPMediaDecoderInfo[] getLocalCacheMediaCodecList(LocalCache paramLocalCache)
  {
    TPNativeLog.printLog(2, "getLocalCacheMediaCodecList");
    if (TextUtils.equals(getCachedVersion(paramLocalCache), buildCacheDecoderVersion()))
    {
      paramLocalCache = getCachedDecoderInfos(paramLocalCache);
      if (paramLocalCache != null)
      {
        TPNativeLog.printLog(2, "getCachedDecoderInfos length " + paramLocalCache.length);
        return paramLocalCache;
      }
    }
    return null;
  }
  
  private static final TPMediaDecoderInfo[] getSystemMediaCodecList()
  {
    TPNativeLog.printLog(2, "getSystemMediaCodecList");
    MediaCodecInfo[] arrayOfMediaCodecInfo = getCodecInfos();
    if (arrayOfMediaCodecInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfMediaCodecInfo.length;
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = arrayOfMediaCodecInfo[i];
      if (localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          String str = arrayOfString[j];
          TPMediaDecoderInfo localTPMediaDecoderInfo = new TPMediaDecoderInfo(str, localMediaCodecInfo.getName(), localMediaCodecInfo.getCapabilitiesForType(str));
          if (!localTPMediaDecoderInfo.isVideoSofwareDecoder())
          {
            TPNativeLog.printLog(2, "MediaCodecList codecName " + localMediaCodecInfo.getName() + "supportedType " + str);
            localArrayList.add(localTPMediaDecoderInfo);
          }
          j += 1;
        }
      }
    }
    return (TPMediaDecoderInfo[])localArrayList.toArray(new TPMediaDecoderInfo[localArrayList.size()]);
  }
  
  /* Error */
  public static final TPMediaDecoderInfo[] getTPMediaDecoderInfos(LocalCache paramLocalCache)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/tencent/thumbplayer/core/common/TPMediaDecoderList:sDecoderInfos	[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: invokestatic 216	com/tencent/thumbplayer/core/common/TPMediaDecoderList:initCodecList	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache;)[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   13: putstatic 21	com/tencent/thumbplayer/core/common/TPMediaDecoderList:sDecoderInfos	[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   16: getstatic 21	com/tencent/thumbplayer/core/common/TPMediaDecoderList:sDecoderInfos	[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   19: ifnonnull +13 -> 32
    //   22: iconst_0
    //   23: anewarray 195	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: areturn
    //   32: getstatic 21	com/tencent/thumbplayer/core/common/TPMediaDecoderList:sDecoderInfos	[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   35: getstatic 21	com/tencent/thumbplayer/core/common/TPMediaDecoderList:sDecoderInfos	[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   38: arraylength
    //   39: invokestatic 222	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   42: checkcast 93	[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   45: astore_0
    //   46: goto -19 -> 27
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramLocalCache	LocalCache
    // Exception table:
    //   from	to	target	type
    //   3	16	49	finally
    //   16	27	49	finally
    //   32	46	49	finally
  }
  
  private static final TPMediaDecoderInfo[] initCodecList(LocalCache paramLocalCache)
  {
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo2 = getLocalCacheMediaCodecList(paramLocalCache);
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo1 = arrayOfTPMediaDecoderInfo2;
    if (arrayOfTPMediaDecoderInfo2 == null)
    {
      arrayOfTPMediaDecoderInfo1 = getSystemMediaCodecList();
      storeLocalCacheMediaCodecList(paramLocalCache, arrayOfTPMediaDecoderInfo1);
    }
    return arrayOfTPMediaDecoderInfo1;
  }
  
  private static final void storeLocalCacheMediaCodecList(LocalCache paramLocalCache, TPMediaDecoderInfo[] paramArrayOfTPMediaDecoderInfo)
  {
    TPNativeLog.printLog(2, "storeLocalCacheMediaCodecList");
    cacheDecoderInfos(paramLocalCache, paramArrayOfTPMediaDecoderInfo);
    cacheVersion(paramLocalCache, buildCacheDecoderVersion());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPMediaDecoderList
 * JD-Core Version:    0.7.0.1
 */