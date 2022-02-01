package com.tencent.qqlive.tvkplayer.playerwrapper.player.tools;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class TVKCodecUtils
{
  public static final int CAP_AUDIO_AAC = 4;
  public static final int CAP_AUDIO_DDP = 8;
  public static final int CAP_COMMON_NULL = 0;
  public static final int CAP_VIDEO_AVC = 1;
  public static final int CAP_VIDEO_HEVC = 2;
  private static final int HDR10_CODEC_CAP_NOT_SUPPORT = 0;
  private static final int HDR10_CODEC_CAP_SUPPORT = 1;
  private static final int HDR10_CODEC_CAP_UNKNOWN = -1;
  public static final String TAG = "MediaPlayerMgr[TVKCodecUtils.java]";
  private static HashMap<String, Integer> mCodecCap;
  private static int mHDR10CodecSupport;
  private static String mHDRVideoLevelKey;
  protected static ArrayList<String> mHWCodecCapList = new ArrayList();
  protected static int mHWVideoAVCLevel;
  protected static int mHWVideoAVCMaxCap;
  protected static int mHWVideoAVCProfile;
  protected static int mHWVideoHEVCLevel;
  protected static int mHWVideoHEVCMaxCap;
  protected static int mHWVideoHEVCProfile;
  private static String mHWVideoLevelKey;
  private static String mHWconfigKey;
  private static int mIsInBlackListForHardwareDec;
  private static boolean mIsInitDone;
  private static int mPlayerHevcLevel;
  protected static ArrayList<String> mSoftCodecCapList = new ArrayList();
  private static String mSoftconfigKey;
  private static int sDolbyLevel;
  private static boolean sIsDDPInit;
  private static boolean sIsDDPSup;
  private static boolean sIsDDSInit;
  private static boolean sIsDDSSup;
  
  static
  {
    mHWVideoAVCMaxCap = 0;
    mHWVideoAVCLevel = 0;
    mHWVideoAVCProfile = 0;
    mHWVideoHEVCMaxCap = 0;
    mHWVideoHEVCLevel = 0;
    mHWVideoHEVCProfile = 0;
    mCodecCap = null;
    mIsInitDone = false;
    mPlayerHevcLevel = -1;
    mIsInBlackListForHardwareDec = -1;
    sIsDDPInit = false;
    sIsDDPSup = false;
    sIsDDSInit = false;
    sIsDDSSup = false;
    sDolbyLevel = -1;
    mHDR10CodecSupport = -1;
    mHWconfigKey = "Config_HW_Capability_V4";
    mSoftconfigKey = "Config_Soft_Capability_V4";
    mHWVideoLevelKey = "Config_HW_Level_V4";
    mHDRVideoLevelKey = "Config_HDR_Codec_Level";
    mCodecCap = new HashMap();
    mCodecCap.put("NX511J", Integer.valueOf(7));
    mCodecCap.put("Hi3798MV100", Integer.valueOf(7));
    mCodecCap.put("长虹智能电视", Integer.valueOf(7));
    mCodecCap.put("Android TV on Tcl 901", Integer.valueOf(7));
    mCodecCap.put("xt880b", Integer.valueOf(7));
    acquireCodecParamsSync();
  }
  
  /* Error */
  public static void acquireCodecParamsAsync()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 77	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mIsInitDone	Z
    //   6: ifeq +14 -> 20
    //   9: ldc 23
    //   11: ldc 140
    //   13: invokestatic 146	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: ldc 23
    //   22: ldc 148
    //   24: invokestatic 146	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: new 150	java/lang/Thread
    //   30: dup
    //   31: new 152	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils$1
    //   34: dup
    //   35: invokespecial 153	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils$1:<init>	()V
    //   38: invokespecial 156	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   41: astore_0
    //   42: aload_0
    //   43: ldc 158
    //   45: invokevirtual 162	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: invokevirtual 165	java/lang/Thread:start	()V
    //   52: goto -36 -> 16
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	8	0	localThread	java.lang.Thread
    //   55	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	55	finally
    //   20	52	55	finally
  }
  
  public static void acquireCodecParamsSync()
  {
    try
    {
      if (mIsInitDone) {
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "codec params already init , return directly !");
      }
      for (;;)
      {
        return;
        if (!((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_cache_hwlevel.getValue()).booleanValue()) {
          break;
        }
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "acquire codec params from share preference");
        ArrayList localArrayList;
        if ((mHWCodecCapList == null) || (mHWCodecCapList.size() == 0))
        {
          localArrayList = getConfig_V2(mHWconfigKey);
          if (localArrayList != null) {
            mHWCodecCapList = localArrayList;
          }
        }
        if ((mSoftCodecCapList == null) || (mSoftCodecCapList.size() == 0))
        {
          localArrayList = getConfig_V2(mSoftconfigKey);
          if (localArrayList != null) {
            mSoftCodecCapList = localArrayList;
          }
        }
        if ((mHWCodecCapList == null) || (mSoftCodecCapList == null) || (mHWCodecCapList.size() <= 0) || (mSoftCodecCapList.size() <= 0) || (!dealHwLevel())) {
          break;
        }
        mIsInitDone = true;
      }
      j = 0;
    }
    finally {}
    int j;
    int i = 0;
    for (;;)
    {
      int k;
      int n;
      int i1;
      int m;
      try
      {
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "acquire codec params from settings");
        Object localObject2 = Class.forName("android.media.MediaCodecList");
        Object localObject6 = ((Class)localObject2).getDeclaredMethod("getCodecCount", new Class[0]);
        localObject2 = ((Class)localObject2).getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        Object localObject4 = Class.forName("android.media.MediaCodecInfo");
        Method localMethod1 = ((Class)localObject4).getDeclaredMethod("getSupportedTypes", new Class[0]);
        Method localMethod2 = ((Class)localObject4).getDeclaredMethod("getName", new Class[0]);
        Method localMethod3 = ((Class)localObject4).getDeclaredMethod("isEncoder", new Class[0]);
        localObject4 = ((Class)localObject4).getDeclaredMethod("getCapabilitiesForType", new Class[] { String.class });
        Field localField1 = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getDeclaredField("profileLevels");
        Object localObject5 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        Field localField2 = ((Class)localObject5).getDeclaredField("level");
        localObject5 = ((Class)localObject5).getDeclaredField("profile");
        int i2 = ((Integer)((Method)localObject6).invoke(null, new Object[0])).intValue();
        k = 0;
        if (k < i2)
        {
          localObject6 = ((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(k) });
          if (((Boolean)localMethod3.invoke(localObject6, new Object[0])).booleanValue())
          {
            n = j;
            i1 = i;
            break label1138;
          }
          String str = ((String)localMethod2.invoke(localObject6, new Object[0])).toLowerCase();
          String[] arrayOfString = (String[])localMethod1.invoke(localObject6, new Object[0]);
          int i3 = arrayOfString.length;
          m = 0;
          n = j;
          i1 = i;
          if (m >= i3) {
            break label1138;
          }
          Object localObject7 = arrayOfString[m];
          if ((str.contains(".google.")) || (str.contains(".sw.")) || (str.contains(".GOOGLE.")) || (str.contains(".SW.")))
          {
            mSoftCodecCapList.add(localObject7);
            break label1151;
          }
          mHWCodecCapList.add(localObject7);
          if ((!mHWCodecCapList.contains("video/avc")) || (j != 0)) {
            break label1135;
          }
          localObject7 = (Object[])localField1.get(((Method)localObject4).invoke(localObject6, new Object[] { "video/avc" }));
          n = localObject7.length;
          j = 0;
          Object localObject8;
          int i4;
          int i5;
          if (j < n)
          {
            localObject8 = localObject7[j];
            i1 = ((Integer)localField2.get(localObject8)).intValue();
            i4 = ((Integer)((Field)localObject5).get(localObject8)).intValue();
            i5 = maxLumaSamplesForAVCProfileLevel(i4, i1);
            if (i5 < mHWVideoAVCMaxCap) {
              break label1158;
            }
            mHWVideoAVCMaxCap = i5;
            mHWVideoAVCProfile = i4;
            mHWVideoAVCLevel = i1;
            break label1158;
          }
          TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "profile:" + mHWVideoAVCProfile + ",level:" + mHWVideoAVCLevel + " mHWVideoMaxCap:" + mHWVideoAVCMaxCap);
          j = 1;
          if ((mHWCodecCapList.contains("video/hevc")) && (i == 0))
          {
            localObject7 = (Object[])localField1.get(((Method)localObject4).invoke(localObject6, new Object[] { "video/hevc" }));
            n = localObject7.length;
            i = 0;
            if (i < n)
            {
              localObject8 = localObject7[i];
              i1 = ((Integer)localField2.get(localObject8)).intValue();
              i4 = ((Integer)((Field)localObject5).get(localObject8)).intValue();
              i5 = maxLumaSamplesForHEVCProfileLevel(i4, i1);
              if (i5 < mHWVideoHEVCMaxCap) {
                break label1165;
              }
              mHWVideoHEVCMaxCap = i5;
              mHWVideoHEVCProfile = i4;
              mHWVideoHEVCLevel = i1;
              break label1165;
            }
            TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "profile:" + mHWVideoHEVCProfile + ",level:" + mHWVideoHEVCLevel + " mHWVideoMaxCap:" + mHWVideoHEVCMaxCap);
            i = 1;
            break label1151;
          }
        }
        else
        {
          if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_cache_hwlevel.getValue()).booleanValue())
          {
            cacheConfig_V2(mHWconfigKey, mHWCodecCapList);
            cacheConfig_V2(mSoftconfigKey, mSoftCodecCapList);
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("mHWVideoAVCMaxCap", String.valueOf(mHWVideoAVCMaxCap));
            ((HashMap)localObject2).put("mHWVideoAVCMaxCap", String.valueOf(mHWVideoAVCMaxCap));
            ((HashMap)localObject2).put("mHWVideoAVCLevel", String.valueOf(mHWVideoAVCLevel));
            ((HashMap)localObject2).put("mHWVideoAVCProfile", String.valueOf(mHWVideoAVCProfile));
            ((HashMap)localObject2).put("mHWVideoHEVCMaxCap", String.valueOf(mHWVideoHEVCMaxCap));
            ((HashMap)localObject2).put("mHWVideoHEVCLevel", String.valueOf(mHWVideoHEVCLevel));
            ((HashMap)localObject2).put("mHWVideoHEVCProfile", String.valueOf(mHWVideoHEVCProfile));
            cacheConfigWithMap(mHWVideoLevelKey, (HashMap)localObject2);
          }
          mIsInitDone = true;
          break;
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", localInvocationTargetException);
        mIsInitDone = true;
        break;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", localNoSuchMethodException);
        mIsInitDone = true;
        break;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", localIllegalAccessException);
        mIsInitDone = true;
        break;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", localNoSuchFieldException);
        mIsInitDone = true;
        break;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", localClassNotFoundException);
        mIsInitDone = true;
        break;
      }
      finally
      {
        mIsInitDone = true;
      }
      break label1151;
      label1135:
      continue;
      label1138:
      k += 1;
      j = n;
      i = i1;
      continue;
      label1151:
      m += 1;
      continue;
      label1158:
      j += 1;
      continue;
      label1165:
      i += 1;
    }
  }
  
  private static void cacheConfigWithMap(String paramString, HashMap<String, String> paramHashMap)
  {
    if (TVideoMgr.getApplicationContext() != null) {}
    try
    {
      LocalCache localLocalCache = LocalCache.get(TVideoMgr.getApplicationContext());
      if (localLocalCache != null) {
        localLocalCache.put(paramString, paramHashMap);
      }
      return;
    }
    catch (Throwable paramHashMap)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", "cache " + paramString + "failed");
    }
  }
  
  private static void cacheConfig_V2(String paramString, ArrayList<String> paramArrayList)
  {
    if (TVideoMgr.getApplicationContext() != null) {}
    try
    {
      LocalCache localLocalCache = LocalCache.get(TVideoMgr.getApplicationContext());
      if (localLocalCache != null) {
        localLocalCache.put(paramString, paramArrayList);
      }
      return;
    }
    catch (Throwable paramArrayList)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", "cache " + paramString + "failed");
    }
  }
  
  private static boolean dealHwLevel()
  {
    HashMap localHashMap = getConfigWithMap(mHWVideoLevelKey);
    if (localHashMap != null) {}
    try
    {
      if (localHashMap.size() > 0)
      {
        mHWVideoAVCMaxCap = TVKUtils.optInt((String)localHashMap.get("mHWVideoAVCMaxCap"), 0);
        mHWVideoAVCLevel = TVKUtils.optInt((String)localHashMap.get("mHWVideoAVCLevel"), 0);
        mHWVideoAVCProfile = TVKUtils.optInt((String)localHashMap.get("mHWVideoAVCProfile"), 0);
        mHWVideoHEVCMaxCap = TVKUtils.optInt((String)localHashMap.get("mHWVideoHEVCMaxCap"), 0);
        mHWVideoHEVCProfile = TVKUtils.optInt((String)localHashMap.get("mHWVideoHEVCProfile"), 0);
        mHWVideoHEVCLevel = TVKUtils.optInt((String)localHashMap.get("mHWVideoHEVCLevel"), 0);
      }
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "mHWVideoAVCMaxCap=" + mHWVideoAVCMaxCap + "mHWVideoAVCLevel=" + mHWVideoAVCLevel + "mHWVideoAVCProfile=" + mHWVideoAVCProfile + "mHWVideoHEVCMaxCap=" + mHWVideoHEVCMaxCap + "mHWVideoHEVCProfile=" + mHWVideoHEVCProfile + "mHWVideoHEVCLevel=" + mHWVideoHEVCLevel);
      return true;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  private static HashMap<String, String> getConfigWithMap(String paramString)
  {
    if (TVideoMgr.getApplicationContext() != null) {
      try
      {
        Object localObject = LocalCache.get(TVideoMgr.getApplicationContext());
        if (localObject != null)
        {
          localObject = (HashMap)((LocalCache)localObject).getAsObject(paramString);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", "get " + paramString + "failed");
      }
    }
    return null;
  }
  
  private static ArrayList<String> getConfig_V2(String paramString)
  {
    if (TVideoMgr.getApplicationContext() != null) {
      try
      {
        Object localObject = LocalCache.get(TVideoMgr.getApplicationContext());
        if (localObject != null)
        {
          localObject = (ArrayList)((LocalCache)localObject).getAsObject(paramString);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", "get " + paramString + "failed");
      }
    }
    return null;
  }
  
  public static int getDefinitionLevel(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (paramString.equals("uhd")) {
      return 28;
    }
    if (paramString.equals("fhd")) {
      return 26;
    }
    if (paramString.equals("shd")) {
      return 21;
    }
    if ((paramString.equals("hd")) || (paramString.equals("mp4"))) {
      return 16;
    }
    if (paramString.equals("sd")) {
      return 11;
    }
    if (paramString.equals("msd")) {
      return 6;
    }
    return 1;
  }
  
  public static int getDefnLevelByWidthHeight(int paramInt1, int paramInt2)
  {
    int i = 33;
    if (paramInt1 * paramInt2 < 129600) {
      i = 1;
    }
    do
    {
      return i;
      if (paramInt1 * paramInt2 < 407040) {
        return 11;
      }
      if (paramInt1 * paramInt2 < 921600) {
        return 16;
      }
      if (paramInt1 * paramInt2 < 2073600) {
        return 21;
      }
      if (paramInt1 * paramInt2 < 8294400) {
        return 28;
      }
    } while (paramInt1 * paramInt2 >= 33177600);
    return 33;
  }
  
  public static int getDolbyLevel()
  {
    if (sDolbyLevel == -1) {
      initInvariableParams();
    }
    return sDolbyLevel;
  }
  
  private static int getHdrCodecLevel()
  {
    int k = 0;
    int j = 0;
    int i = k;
    try
    {
      LocalCache localLocalCache = LocalCache.get(TVideoMgr.getApplicationContext());
      if (localLocalCache != null)
      {
        i = k;
        String str = localLocalCache.getAsString(mHDRVideoLevelKey);
        i = k;
        if (!TextUtils.isEmpty(str))
        {
          i = k;
          j = TVKUtils.optInt(str, 0);
          i = j;
          TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "hdrlevel  cache  " + j);
          return j;
        }
      }
      i = k;
      if (hdrCodecCapabilitiesDetect()) {
        j = 1;
      }
      i = j;
      if (localLocalCache != null)
      {
        i = j;
        localLocalCache.put(mHDRVideoLevelKey, String.valueOf(j));
        return j;
      }
    }
    catch (Throwable localThrowable)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", "cache failed");
    }
    return i;
  }
  
  public static int getHevcHWDecLevel()
  {
    int i;
    if (mHWVideoHEVCMaxCap < 129600) {
      i = 1;
    }
    while (((Boolean)TVKMediaPlayerConfig.PlayerConfig.mediacodec_support_hardwared.getValue()).booleanValue())
    {
      return 28;
      if (mHWVideoHEVCMaxCap < 407040) {
        i = 11;
      } else if (mHWVideoHEVCMaxCap < 921600) {
        i = 16;
      } else if (mHWVideoHEVCMaxCap < 2073600) {
        i = 21;
      } else if (mHWVideoHEVCMaxCap < 8294400) {
        i = 28;
      } else if (mHWVideoHEVCMaxCap < 33177600) {
        i = 33;
      } else {
        i = 33;
      }
    }
    return i;
  }
  
  private static int getHevcLvByCoresAndFreq()
  {
    if (TVKVcSystemInfo.getNumCores() >= 8) {
      if (TVKVcSystemInfo.getMaxCpuFreq() / 1000L < 1200L) {}
    }
    do
    {
      do
      {
        return 21;
        return 16;
        if (TVKVcSystemInfo.getNumCores() < 6) {
          break;
        }
      } while (TVKVcSystemInfo.getMaxCpuFreq() / 1000L >= 1400L);
      return 16;
      if (TVKVcSystemInfo.getNumCores() < 4) {
        break;
      }
    } while (TVKVcSystemInfo.getMaxCpuFreq() / 1000L >= 1600L);
    return 16;
    return 6;
  }
  
  public static int getHevcMaxDecCap()
  {
    return mHWVideoHEVCMaxCap;
  }
  
  public static int getSoftCodecHevcLevel()
  {
    String str = TVKVcSystemInfo.getCpuHarewareName();
    int i = TVKVcSystemInfo.getCpuHWProducter(str);
    int j = TVKVcSystemInfo.getCpuHWProductIndex(str);
    TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "[getSoftCodecHevcLevel], numCores = " + TVKVcSystemInfo.getNumCores() + ", totalMem = " + TVKVcSystemInfo.getTotalMem(TVideoMgr.getApplicationContext()));
    TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "[getSoftCodecHevcLevel], hd_hevc_least_cores = " + TVKMediaPlayerConfig.PlayerConfig.hd_hevc_least_cores.getValue() + ", hd_hevc_least_mem = " + TVKMediaPlayerConfig.PlayerConfig.hd_hevc_least_mem.getValue());
    TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "[getSoftCodecHevcLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TVKVcSystemInfo.getMaxCpuFreq() + " mCpuHWProductIdx=" + j);
    if (-1 != mPlayerHevcLevel) {
      return mPlayerHevcLevel;
    }
    mPlayerHevcLevel = 0;
    if (-1 == i) {
      mPlayerHevcLevel = getHevcLvByCoresAndFreq();
    }
    for (;;)
    {
      return mPlayerHevcLevel;
      switch (i)
      {
      default: 
        break;
      case 0: 
        if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.shd_hevc_qualcomm_index.getValue()).intValue()) {
          mPlayerHevcLevel = 21;
        } else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hd_hevc_qualcomm_index.getValue()).intValue()) {
          mPlayerHevcLevel = 16;
        } else {
          mPlayerHevcLevel = getHevcLvByCoresAndFreq();
        }
        break;
      case 1: 
        if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.shd_hevc_mtk_index.getValue()).intValue()) {
          mPlayerHevcLevel = 21;
        } else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hd_hevc_mtk_index.getValue()).intValue()) {
          mPlayerHevcLevel = 16;
        } else {
          mPlayerHevcLevel = getHevcLvByCoresAndFreq();
        }
        break;
      case 2: 
        if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.shd_hevc_hisi_index.getValue()).intValue()) {
          mPlayerHevcLevel = 21;
        } else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hd_hevc_hisi_index.getValue()).intValue()) {
          mPlayerHevcLevel = 16;
        } else {
          mPlayerHevcLevel = getHevcLvByCoresAndFreq();
        }
        break;
      case 3: 
        if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.shd_hevc_sumsing_index.getValue()).intValue()) {
          mPlayerHevcLevel = 21;
        } else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hd_hevc_sumsing_index.getValue()).intValue()) {
          mPlayerHevcLevel = 16;
        } else {
          mPlayerHevcLevel = getHevcLvByCoresAndFreq();
        }
        break;
      }
    }
  }
  
  private static boolean hdrCodecCapabilitiesDetect()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    label175:
    for (;;)
    {
      try
      {
        int m = MediaCodecList.getCodecCount();
        int i = 0;
        if (i < m)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if (localMediaCodecInfo.isEncoder()) {
            break label175;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int n = arrayOfString.length;
          int j = 0;
          if (j >= n) {
            break label175;
          }
          if (arrayOfString[j].equalsIgnoreCase("video/hevc"))
          {
            MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels;
            int i1 = arrayOfCodecProfileLevel.length;
            int k = 0;
            if (k < i1)
            {
              if (arrayOfCodecProfileLevel[k].profile == 4096)
              {
                TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isHDR10CodecSupport support HDR10");
                return true;
              }
              k += 1;
              continue;
            }
          }
          j += 1;
          continue;
        }
        i += 1;
      }
      catch (Throwable localThrowable)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", "isHDR10CodecSupport " + localThrowable.toString());
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isHDR10CodecSupport not support");
        return false;
      }
    }
  }
  
  private static void initInvariableParams()
  {
    boolean bool1 = isDDPlusSupported_V2(TVideoMgr.getApplicationContext());
    boolean bool2 = isDolbyDSSupported();
    if ((!bool2) && (!bool1)) {
      sDolbyLevel = 0;
    }
    do
    {
      return;
      if ((bool1) && (!bool2))
      {
        sDolbyLevel = 1;
        return;
      }
      if ((!bool1) && (bool2))
      {
        sDolbyLevel = 10;
        return;
      }
    } while ((!bool2) || (!bool1));
    sDolbyLevel = 11;
  }
  
  public static boolean isBlackListForHardwareDec(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (mIsInBlackListForHardwareDec != -1)
    {
      if (mIsInBlackListForHardwareDec == 0) {}
      for (;;)
      {
        return bool;
        bool = true;
      }
    }
    mIsInBlackListForHardwareDec = 0;
    do
    {
      try
      {
        paramContext = TVKVcSystemInfo.getDeviceIMEI(paramContext);
        if ((!TextUtils.isEmpty(paramContext)) && ((paramContext.equals("862374021679556")) || (paramContext.equals("352107063035304")) || (paramContext.equals("359950061442003")) || (paramContext.equals("352514063538981")) || (paramContext.equals("864052022167536")) || (paramContext.equals("864821021284769")) || (paramContext.equals("863738029867885")) || (paramContext.equals("359950063519113")) || (paramContext.equals("353360060459642")) || (paramContext.equals("354765050577808"))))
        {
          TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isBlackListForHardwareDec, deviceIMEI: " + paramContext);
          mIsInBlackListForHardwareDec = 1;
          return true;
        }
      }
      catch (Exception paramContext)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", "isBlackListForHardwareDec exception");
        return false;
      }
      paramContext = Build.MODEL;
      if ((!TextUtils.isEmpty(paramContext)) && ((paramContext.equals("SM-J7008")) || (paramContext.equals("SM-J5008")) || (paramContext.equals("TCL i806")) || (paramContext.equals("NX511J")) || (paramContext.equals("vivo Y11i T")) || (paramContext.equals("长虹智能电视")) || (paramContext.equals("MI 1S")) || (paramContext.equals("SP9832A")) || (paramContext.equals("SP9830A")) || (paramContext.equals("VOTO GT17")) || (paramContext.equals("EVA-AL10"))))
      {
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isBlackListForHardwareDec, deviceName: " + paramContext);
        mIsInBlackListForHardwareDec = 1;
        return true;
      }
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals("video/hevc")) || (Build.VERSION.SDK_INT < 14) || (TextUtils.isEmpty(paramContext)) || ((!"PRO 7 Plus".equals(paramContext)) && (!"PRO 7-H".equals(paramContext)) && (!"PRO+7+Plus".equals(paramContext))));
    mIsInBlackListForHardwareDec = 1;
    return true;
  }
  
  public static boolean isBlackListForHdr10()
  {
    try
    {
      if (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_black_list.getValue()))
      {
        String str1 = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_black_list.getValue();
        String[] arrayOfString = str1.split(",");
        String str2 = Build.MODEL;
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "hdr10 黑名单：" + str1);
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = str2.equalsIgnoreCase(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isBlackListForHdr10：" + localException.toString());
    }
  }
  
  public static boolean isBlackListForHdr10Enhance()
  {
    try
    {
      if (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_black_list.getValue()))
      {
        String str1 = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_black_list.getValue();
        String[] arrayOfString = str1.split(",");
        String str2 = Build.MODEL;
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "hdr10 黑名单：" + str1);
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = str2.equalsIgnoreCase(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isBlackListForHdr10：" + localException.toString());
    }
  }
  
  public static boolean isBlackListForVidHdr10Enhance(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_vid_black_list.getValue())))
      {
        String str = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_vid_black_list.getValue();
        String[] arrayOfString = str.split(",");
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "hdr10 vid：" + str);
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = paramString.equalsIgnoreCase(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isBlackListForHdr10：" + paramString.toString());
    }
  }
  
  public static boolean isCodecSupported(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.mediacodec_support_hardwared.getValue()).booleanValue()) {}
    for (;;)
    {
      return true;
      try
      {
        Object localObject = Build.MODEL;
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (mCodecCap != null) && (mCodecCap.containsKey(localObject)))
        {
          localObject = (Integer)mCodecCap.get(localObject);
          if (TextUtils.equals(paramString, "video/avc"))
          {
            if ((((Integer)localObject).intValue() & 0x1) == 0) {
              break label488;
            }
            paramBoolean = true;
          }
          else
          {
            if (TextUtils.equals(paramString, "video/hevc"))
            {
              if ((((Integer)localObject).intValue() & 0x2) != 0) {
                continue;
              }
              return false;
            }
            if (TextUtils.equals(paramString, "audio/mp4a-latm"))
            {
              if ((((Integer)localObject).intValue() & 0x4) != 0) {
                continue;
              }
              return false;
            }
            if ((!TextUtils.equals(paramString, "audio/eac3")) && (!TextUtils.equals(paramString, "audio/ec3"))) {
              break label493;
            }
            if ((((Integer)localObject).intValue() & 0x8) != 0) {
              continue;
            }
            return false;
          }
        }
        else
        {
          if (!mIsInitDone)
          {
            acquireCodecParamsAsync();
            return false;
          }
          if (!paramBoolean)
          {
            if ((mHWCodecCapList.contains(paramString)) || (mSoftCodecCapList.contains(paramString))) {
              continue;
            }
            break label493;
          }
          if (!mHWCodecCapList.contains(paramString)) {
            break label493;
          }
          if (paramString.equalsIgnoreCase("video/avc")) {
            if (mHWVideoAVCMaxCap >= paramInt1 * paramInt2)
            {
              TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "h264 profile:" + mHWVideoAVCProfile + ",level:" + mHWVideoAVCLevel + " support " + paramInt1 + "x" + paramInt2);
              return true;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", paramString);
        break label493;
        TVKLogUtil.w("MediaPlayerMgr[TVKCodecUtils.java]", "isCodecExists true ,but HWVideoAVCMaxCap " + mHWVideoAVCMaxCap + " is not support " + paramInt1 + "x" + paramInt2);
        break label493;
        if (paramString.equalsIgnoreCase("video/hevc"))
        {
          if ((mHWVideoHEVCMaxCap > 0) && (mHWVideoHEVCMaxCap >= paramInt1 * paramInt2))
          {
            TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "hevc profile:" + mHWVideoHEVCProfile + ",level:" + mHWVideoHEVCLevel + " support " + paramInt1 + "x" + paramInt2);
            return true;
          }
          TVKLogUtil.w("MediaPlayerMgr[TVKCodecUtils.java]", "isCodecExists true ,but mHWVideoHEVCMaxCap " + mHWVideoHEVCMaxCap + " is not support " + paramInt1 + "x" + paramInt2);
          break label493;
          for (;;)
          {
            return paramBoolean;
            label488:
            paramBoolean = false;
          }
        }
      }
    }
    label493:
    return false;
  }
  
  public static boolean isDDPlusSupported(Context paramContext)
  {
    if (sIsDDPInit) {
      return sIsDDPSup;
    }
    if (isBlackListForHardwareDec(paramContext, null))
    {
      sIsDDPInit = true;
      sIsDDPSup = false;
      return sIsDDPSup;
    }
    for (;;)
    {
      try
      {
        paramContext = Class.forName("android.media.MediaCodecList");
        localObject1 = paramContext.getDeclaredMethod("getCodecCount", new Class[0]);
        paramContext = paramContext.getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        localMethod = Class.forName("android.media.MediaCodecInfo").getDeclaredMethod("getSupportedTypes", new Class[0]);
        int k = ((Integer)((Method)localObject1).invoke(null, new Object[0])).intValue();
        i = 0;
        bool1 = false;
        bool2 = bool1;
        if (i < k)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
        }
      }
      catch (Exception paramContext)
      {
        Object localObject1;
        Method localMethod;
        int i;
        int m;
        int j;
        Object localObject2;
        bool2 = false;
        sIsDDPSup = bool2;
        sIsDDPInit = true;
        return sIsDDPSup;
      }
      try
      {
        localObject1 = (String[])localMethod.invoke(paramContext.invoke(null, new Object[] { Integer.valueOf(i) }), new Object[0]);
        m = localObject1.length;
        j = 0;
        if (j >= m) {
          break label241;
        }
        localObject2 = localObject1[j];
        if (!localObject2.equals("audio/eac3"))
        {
          bool2 = localObject2.equals("audio/ec3");
          if (!bool2) {
            continue;
          }
        }
        bool1 = true;
      }
      catch (Exception paramContext)
      {
        bool2 = bool1;
        continue;
        continue;
      }
      i += 1;
      continue;
      j += 1;
    }
  }
  
  public static boolean isDDPlusSupported_V2(Context paramContext)
  {
    boolean bool1 = false;
    if (isBlackListForHardwareDec(paramContext, null))
    {
      sIsDDPSup = false;
      return sIsDDPSup;
    }
    try
    {
      boolean bool2 = isSupportDDPlus();
      bool1 = bool2;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    sIsDDPSup = bool1;
    return sIsDDPSup;
  }
  
  public static boolean isDolbyDSSupported()
  {
    if (sIsDDSInit)
    {
      if (sIsDDSSup) {
        TVKLogUtil.i("MediaPlayerMgr", "dds ha suported " + sIsDDSSup);
      }
      return sIsDDSSup;
    }
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      localObject1 = (String)((Class)localObject1).getMethod("get", new Class[] { String.class }).invoke(localObject1, new Object[] { "dolby.ds.state" });
      if ((localObject1 == null) || ((localObject1 != null) && (((String)localObject1).trim().equals(""))))
      {
        bool = false;
        sIsDDSSup = bool;
        sIsDDSInit = true;
        if (sIsDDSSup) {
          TVKLogUtil.i("MediaPlayerMgr", "dds ha suported " + sIsDDSSup);
        }
        return sIsDDSSup;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", localException);
        Object localObject2 = null;
        continue;
        boolean bool = true;
      }
    }
  }
  
  public static boolean isHDR10CodecSupport()
  {
    if (mHDR10CodecSupport == -1) {
      mHDR10CodecSupport = getHdrCodecLevel();
    }
    if (mHDR10CodecSupport == 0) {}
    while (mHDR10CodecSupport != 1) {
      return false;
    }
    return true;
  }
  
  public static boolean isSupportDDPlus()
  {
    if ((mHWCodecCapList != null) && (mHWCodecCapList.size() > 0) && ((mHWCodecCapList.contains("audio/eac3")) || (mHWCodecCapList.contains("audio/ec3")))) {}
    while ((mSoftCodecCapList != null) && (mSoftCodecCapList.size() > 0) && ((mSoftCodecCapList.contains("audio/eac3")) || (mSoftCodecCapList.contains("audio/ec3")))) {
      return true;
    }
    return false;
  }
  
  public static boolean isWhiteListForHdr10()
  {
    try
    {
      if (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_white_list.getValue()))
      {
        String str1 = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_white_list.getValue();
        String[] arrayOfString = str1.split(",");
        String str2 = Build.MODEL;
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "hdr10 白名单：" + str1);
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = str2.equalsIgnoreCase(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isWhiteListForHdr10：" + localException.toString());
    }
  }
  
  public static boolean isWhiteListForHdr10Enhance()
  {
    try
    {
      if (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_white_list.getValue()))
      {
        String str1 = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_white_list.getValue();
        String[] arrayOfString = str1.split(",");
        String str2 = Build.MODEL;
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "hdr10 白名单：" + str1);
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = str2.equalsIgnoreCase(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isWhiteListForHdr10：" + localException.toString());
    }
  }
  
  private static int maxLumaSamplesForAVCProfileLevel(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        i = ((Integer)localClass.getField("AVCLevel1").get(null)).intValue();
        j = ((Integer)localClass.getField("AVCLevel1b").get(null)).intValue();
        k = ((Integer)localClass.getField("AVCLevel11").get(null)).intValue();
        m = ((Integer)localClass.getField("AVCLevel12").get(null)).intValue();
        n = ((Integer)localClass.getField("AVCLevel13").get(null)).intValue();
        i1 = ((Integer)localClass.getField("AVCLevel2").get(null)).intValue();
        i2 = ((Integer)localClass.getField("AVCLevel21").get(null)).intValue();
        i3 = ((Integer)localClass.getField("AVCLevel22").get(null)).intValue();
        i4 = ((Integer)localClass.getField("AVCLevel3").get(null)).intValue();
        i5 = ((Integer)localClass.getField("AVCLevel31").get(null)).intValue();
        i6 = ((Integer)localClass.getField("AVCLevel32").get(null)).intValue();
        i7 = ((Integer)localClass.getField("AVCLevel4").get(null)).intValue();
        i8 = ((Integer)localClass.getField("AVCLevel41").get(null)).intValue();
        i9 = ((Integer)localClass.getField("AVCLevel42").get(null)).intValue();
        i10 = ((Integer)localClass.getField("AVCLevel5").get(null)).intValue();
        i11 = ((Integer)localClass.getField("AVCLevel51").get(null)).intValue();
        if (paramInt2 != i) {
          continue;
        }
        i = 25344;
      }
      catch (Exception localException)
      {
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "failed to get maxLumaSamples");
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", localException);
        int i = 414720;
        continue;
      }
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "MaxLumaSamples : profile :" + paramInt1 + " , level :" + paramInt2 + " , maxSample : " + i);
      return i;
      if (paramInt2 == j)
      {
        i = 25344;
      }
      else if (paramInt2 == k)
      {
        i = 101376;
      }
      else if (paramInt2 == m)
      {
        i = 101376;
      }
      else if (paramInt2 == n)
      {
        i = 101376;
      }
      else if (paramInt2 == i1)
      {
        i = 101376;
      }
      else if (paramInt2 == i2)
      {
        i = 202752;
      }
      else if (paramInt2 == i3)
      {
        i = 414720;
      }
      else if (paramInt2 == i4)
      {
        i = 414720;
      }
      else if (paramInt2 == i5)
      {
        i = 921600;
      }
      else if (paramInt2 == i6)
      {
        i = 1310720;
      }
      else if (paramInt2 == i7)
      {
        i = 2097152;
      }
      else if (paramInt2 == i8)
      {
        i = 2097152;
      }
      else if (paramInt2 == i9)
      {
        i = 2228224;
      }
      else if (paramInt2 == i10)
      {
        i = 5652480;
      }
      else
      {
        if (paramInt2 < i11) {
          continue;
        }
        i = 9437184;
      }
    }
  }
  
  private static int maxLumaSamplesForHEVCProfileLevel(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        i = ((Integer)localClass.getField("HEVCHighTierLevel1").get(null)).intValue();
        j = ((Integer)localClass.getField("HEVCHighTierLevel2").get(null)).intValue();
        k = ((Integer)localClass.getField("HEVCHighTierLevel21").get(null)).intValue();
        m = ((Integer)localClass.getField("HEVCHighTierLevel3").get(null)).intValue();
        n = ((Integer)localClass.getField("HEVCHighTierLevel31").get(null)).intValue();
        i1 = ((Integer)localClass.getField("HEVCHighTierLevel4").get(null)).intValue();
        i2 = ((Integer)localClass.getField("HEVCHighTierLevel41").get(null)).intValue();
        i3 = ((Integer)localClass.getField("HEVCHighTierLevel5").get(null)).intValue();
        i4 = ((Integer)localClass.getField("HEVCHighTierLevel51").get(null)).intValue();
        i5 = ((Integer)localClass.getField("HEVCHighTierLevel52").get(null)).intValue();
        i6 = ((Integer)localClass.getField("HEVCHighTierLevel6").get(null)).intValue();
        i7 = ((Integer)localClass.getField("HEVCHighTierLevel61").get(null)).intValue();
        i8 = ((Integer)localClass.getField("HEVCHighTierLevel62").get(null)).intValue();
        int i9 = ((Integer)localClass.getField("HEVCMainTierLevel1").get(null)).intValue();
        i10 = ((Integer)localClass.getField("HEVCMainTierLevel2").get(null)).intValue();
        i11 = ((Integer)localClass.getField("HEVCMainTierLevel21").get(null)).intValue();
        i12 = ((Integer)localClass.getField("HEVCMainTierLevel3").get(null)).intValue();
        i13 = ((Integer)localClass.getField("HEVCMainTierLevel31").get(null)).intValue();
        i14 = ((Integer)localClass.getField("HEVCMainTierLevel4").get(null)).intValue();
        i15 = ((Integer)localClass.getField("HEVCMainTierLevel41").get(null)).intValue();
        i16 = ((Integer)localClass.getField("HEVCMainTierLevel5").get(null)).intValue();
        i17 = ((Integer)localClass.getField("HEVCMainTierLevel51").get(null)).intValue();
        i18 = ((Integer)localClass.getField("HEVCMainTierLevel52").get(null)).intValue();
        i19 = ((Integer)localClass.getField("HEVCMainTierLevel6").get(null)).intValue();
        i20 = ((Integer)localClass.getField("HEVCMainTierLevel61").get(null)).intValue();
        i21 = ((Integer)localClass.getField("HEVCMainTierLevel62").get(null)).intValue();
        if ((paramInt2 != i) && (paramInt2 != i9)) {
          continue;
        }
        i = 36864;
      }
      catch (Exception localException)
      {
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "failed to get maxLumaSamples");
        TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", localException);
        int i = 552960;
        continue;
      }
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "HEVC MaxLumaSamples : profile :" + paramInt1 + " , level :" + paramInt2 + " , maxSample : " + i);
      return i;
      if ((paramInt2 == j) || (paramInt2 == i10))
      {
        i = 122880;
      }
      else if ((paramInt2 == k) || (paramInt2 == i11))
      {
        i = 245760;
      }
      else if ((paramInt2 == m) || (paramInt2 == i12))
      {
        i = 552960;
      }
      else if ((paramInt2 == n) || (paramInt2 == i13))
      {
        i = 983040;
      }
      else if ((paramInt2 == i1) || (paramInt2 == i14))
      {
        i = 2228224;
      }
      else if ((paramInt2 == i2) || (paramInt2 == i15))
      {
        i = 2228224;
      }
      else if ((paramInt2 == i3) || (paramInt2 == i16))
      {
        i = 8912896;
      }
      else if ((paramInt2 == i4) || (paramInt2 == i17))
      {
        i = 8912896;
      }
      else if ((paramInt2 == i5) || (paramInt2 == i18))
      {
        i = 8912896;
      }
      else if ((paramInt2 == i6) || (paramInt2 == i19))
      {
        i = 35651584;
      }
      else if ((paramInt2 >= i7) || (paramInt2 == i20))
      {
        i = 35651584;
      }
      else
      {
        if ((paramInt2 < i8) && (paramInt2 != i21)) {
          continue;
        }
        i = 35651584;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.playerwrapper.player.tools.TVKCodecUtils
 * JD-Core Version:    0.7.0.1
 */