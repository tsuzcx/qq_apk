package com.tencent.tmediacodec.util;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class TUtils
{
  @NonNull
  public static final String CSD_0 = "csd-0";
  @NonNull
  public static final String CSD_1 = "csd-1";
  @NonNull
  public static final String CSD_2 = "csd-2";
  @NonNull
  public static final String[] CSD_INDEX_ARRAY = { "csd-0", "csd-1", "csd-2" };
  @NonNull
  public static final String TAG = "TUtils";
  private static boolean deviceNeedsSetOutputSurfaceWorkaround;
  private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
  private static Set<String> sBlackDevices = new HashSet();
  
  static
  {
    sBlackDevices.add("1601");
    sBlackDevices.add("1713");
    sBlackDevices.add("1714");
    sBlackDevices.add("A10-70F");
    sBlackDevices.add("A10-70L");
    sBlackDevices.add("A1601");
    sBlackDevices.add("A2016a40");
    sBlackDevices.add("A7000-a");
    sBlackDevices.add("A7000plus");
    sBlackDevices.add("A7010a48");
    sBlackDevices.add("A7020a48");
    sBlackDevices.add("AquaPowerM");
    sBlackDevices.add("ASUS_X00AD_2");
    sBlackDevices.add("Aura_Note_2");
    sBlackDevices.add("BLACK-1X");
    sBlackDevices.add("BRAVIA_ATV2");
    sBlackDevices.add("BRAVIA_ATV3_4K");
    sBlackDevices.add("C1");
    sBlackDevices.add("ComioS1");
    sBlackDevices.add("CP8676_I02");
    sBlackDevices.add("CPH1609");
    sBlackDevices.add("CPY83_I00");
    sBlackDevices.add("cv1");
    sBlackDevices.add("cv3");
    sBlackDevices.add("deb");
    sBlackDevices.add("E5643");
    sBlackDevices.add("ELUGA_A3_Pro");
    sBlackDevices.add("ELUGA_Note");
    sBlackDevices.add("ELUGA_Prim");
    sBlackDevices.add("ELUGA_Ray_X");
    sBlackDevices.add("EverStar_S");
    sBlackDevices.add("F3111");
    sBlackDevices.add("F3113");
    sBlackDevices.add("F3116");
    sBlackDevices.add("F3211");
    sBlackDevices.add("F3213");
    sBlackDevices.add("F3215");
    sBlackDevices.add("F3311");
    sBlackDevices.add("flo");
    sBlackDevices.add("fugu");
    sBlackDevices.add("GiONEE_CBL7513");
    sBlackDevices.add("GiONEE_GBL7319");
    sBlackDevices.add("GIONEE_GBL7360");
    sBlackDevices.add("GIONEE_SWW1609");
    sBlackDevices.add("GIONEE_SWW1627");
    sBlackDevices.add("GIONEE_SWW1631");
    sBlackDevices.add("GIONEE_WBL5708");
    sBlackDevices.add("GIONEE_WBL7365");
    sBlackDevices.add("GIONEE_WBL7519");
    sBlackDevices.add("griffin");
    sBlackDevices.add("htc_e56ml_dtul");
    sBlackDevices.add("hwALE-H");
    sBlackDevices.add("HWBLN-H");
    sBlackDevices.add("HWCAM-H");
    sBlackDevices.add("HWVNS-H");
    sBlackDevices.add("HWWAS-H");
    sBlackDevices.add("i9031");
    sBlackDevices.add("iball8735_9806");
    sBlackDevices.add("Infinix-X572");
    sBlackDevices.add("iris60");
    sBlackDevices.add("itel_S41");
    sBlackDevices.add("j2xlteins");
    sBlackDevices.add("JGZ");
    sBlackDevices.add("K50a40");
    sBlackDevices.add("kate");
    sBlackDevices.add("l5460");
    sBlackDevices.add("le_x6");
    sBlackDevices.add("LS-5017");
    sBlackDevices.add("M5c");
    sBlackDevices.add("manning");
    sBlackDevices.add("marino_f");
    sBlackDevices.add("MEIZU_M5");
    sBlackDevices.add("mh");
    sBlackDevices.add("mido");
    sBlackDevices.add("c");
    sBlackDevices.add("namath");
    sBlackDevices.add("nicklaus_f");
    sBlackDevices.add("NX541J");
    sBlackDevices.add("NX573J");
    sBlackDevices.add("OnePlus5T");
    sBlackDevices.add("p212");
    sBlackDevices.add("P681");
    sBlackDevices.add("P85");
    sBlackDevices.add("panell_d");
    sBlackDevices.add("panell_dl");
    sBlackDevices.add("panell_ds");
    sBlackDevices.add("panell_dt");
    sBlackDevices.add("PB2-670M");
    sBlackDevices.add("PGN528");
    sBlackDevices.add("PGN610");
    sBlackDevices.add("PGN611");
    sBlackDevices.add("Phantom6");
    sBlackDevices.add("Pixi4-7_3G");
    sBlackDevices.add("Pixi5-10_4G");
    sBlackDevices.add("PLE");
    sBlackDevices.add("PRO7S");
    sBlackDevices.add("Q350");
    sBlackDevices.add("Q4260");
    sBlackDevices.add("Q427");
    sBlackDevices.add("Q4310");
    sBlackDevices.add("Q5");
    sBlackDevices.add("QM16XE_U");
    sBlackDevices.add("QX1");
    sBlackDevices.add("santoni");
    sBlackDevices.add("Slate_Pro");
    sBlackDevices.add("SVP-DTV15");
    sBlackDevices.add("s905x018");
    sBlackDevices.add("taido_row");
    sBlackDevices.add("TB3-730F");
    sBlackDevices.add("TB3-730X");
    sBlackDevices.add("TB3-850F");
    sBlackDevices.add("TB3-850M");
    sBlackDevices.add("tcl_eu");
    sBlackDevices.add("V1");
    sBlackDevices.add("V23GB");
    sBlackDevices.add("V5");
    sBlackDevices.add("vernee_M5");
    sBlackDevices.add("watson");
    sBlackDevices.add("whyred");
    sBlackDevices.add("woods_f");
    sBlackDevices.add("woods_fn");
    sBlackDevices.add("X3_HK");
    sBlackDevices.add("XE2X");
    sBlackDevices.add("XT1663");
    sBlackDevices.add("Z12_PRO");
    sBlackDevices.add("Z80");
  }
  
  public static int ceilDivide(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 1) / paramInt2;
  }
  
  public static boolean codecNeedsSetOutputSurfaceWorkaround()
  {
    for (;;)
    {
      try
      {
        if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround)
        {
          if ("dangal".equals(Build.DEVICE))
          {
            deviceNeedsSetOutputSurfaceWorkaround = true;
            if (LogUtils.isLogEnable()) {
              LogUtils.d("TUtils", "deviceNeedsSetOutputSurfaceWorkaround:" + deviceNeedsSetOutputSurfaceWorkaround);
            }
            evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
          }
        }
        else {
          return deviceNeedsSetOutputSurfaceWorkaround;
        }
        if ((Build.VERSION.SDK_INT <= 27) && ("HWEML".equals(Build.DEVICE)))
        {
          deviceNeedsSetOutputSurfaceWorkaround = true;
          continue;
        }
        if (Build.VERSION.SDK_INT >= 27) {
          continue;
        }
      }
      finally {}
      if (sBlackDevices.contains(Build.DEVICE)) {
        deviceNeedsSetOutputSurfaceWorkaround = true;
      }
      String str = Build.MODEL;
      int i = -1;
      switch (str.hashCode())
      {
      case 2006354: 
        deviceNeedsSetOutputSurfaceWorkaround = true;
        continue;
        if (str.equals("AFTA")) {
          i = 0;
        }
        break;
      case 2006367: 
        if (str.equals("AFTN")) {
          i = 1;
        }
        break;
      case -594534941: 
        boolean bool = str.equals("JSN-L21");
        if (bool) {
          i = 2;
        }
        break;
      default: 
        switch (i)
        {
        }
        break;
      }
    }
  }
  
  @NonNull
  public static String getCodeName(@NonNull MediaCodec paramMediaCodec)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramMediaCodec.getName();
    }
    return "unknow-low-api-18";
  }
  
  public static int getCodecMaxInputSize(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    return getCodecMaxInputSize(paramString, paramInt1, paramInt2, false);
  }
  
  public static int getCodecMaxInputSize(@NonNull String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 2;
    if ((paramInt1 == -1) || (paramInt2 == -1)) {
      return -1;
    }
    label76:
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return -1;
        if (!paramString.equals("video/3gpp")) {
          break label76;
        }
        i = 0;
        continue;
        if (!paramString.equals("video/mp4v-es")) {
          break label76;
        }
        i = 1;
        continue;
        if (!paramString.equals("video/avc")) {
          break label76;
        }
        i = 2;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp8")) {
          break label76;
        }
        i = 3;
        continue;
        if (!paramString.equals("video/hevc")) {
          break label76;
        }
        i = 4;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp9")) {
          break label76;
        }
        i = 5;
      }
    }
    paramInt1 *= paramInt2;
    paramInt2 = j;
    for (;;)
    {
      return paramInt1 * 3 / (paramInt2 * 2);
      if (("BRAVIA 4K 2015".equals(Build.MODEL)) || (("Amazon".equals(Build.MANUFACTURER)) && (("KFSOWI".equals(Build.MODEL)) || (("AFTS".equals(Build.MODEL)) && (paramBoolean))))) {
        return -1;
      }
      paramInt1 = ceilDivide(paramInt1, 16) * ceilDivide(paramInt2, 16) * 16 * 16;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = 4;
    }
  }
  
  @NonNull
  public static ArrayList<byte[]> getCsdBuffers(@NonNull MediaFormat paramMediaFormat)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < CSD_INDEX_ARRAY.length)
    {
      ByteBuffer localByteBuffer = paramMediaFormat.getByteBuffer(CSD_INDEX_ARRAY[i]);
      if (localByteBuffer != null) {
        localArrayList.add(localByteBuffer.array());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static int getMaxInputSize(@NonNull ReuseCodecWrapper paramReuseCodecWrapper, @NonNull FormatWrapper paramFormatWrapper)
  {
    if (paramFormatWrapper.maxInputSize != -1)
    {
      int i = 0;
      int j = 0;
      while (i < paramFormatWrapper.initializationData.size())
      {
        j += ((byte[])paramFormatWrapper.initializationData.get(i)).length;
        i += 1;
      }
      return paramFormatWrapper.maxInputSize + j;
    }
    return getCodecMaxInputSize(paramFormatWrapper.sampleMimeType, paramFormatWrapper.width, paramFormatWrapper.height, paramReuseCodecWrapper.secure);
  }
  
  @NonNull
  public static String getSurfaceTextureName(@NonNull Surface paramSurface)
  {
    try
    {
      Field localField = ReflectUtils.getField(Surface.class, "mName");
      localField.setAccessible(true);
      paramSurface = String.valueOf(localField.get(paramSurface));
      return paramSurface;
    }
    catch (Throwable paramSurface)
    {
      LogUtils.e("TUtils", "getSurfaceTextureName failed", paramSurface);
    }
    return "";
  }
  
  public static boolean isAdaptive(@NonNull MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Build.VERSION.SDK_INT >= 19) && (isAdaptiveV19(paramCodecCapabilities));
  }
  
  @TargetApi(19)
  private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("adaptive-playback");
  }
  
  public static boolean isSecure(@NonNull MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Build.VERSION.SDK_INT >= 21) && (isSecureV21(paramCodecCapabilities));
  }
  
  @TargetApi(21)
  private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }
  
  public static boolean isVideo(@NonNull MediaFormat paramMediaFormat)
  {
    return isVideo(paramMediaFormat.getString("mime"));
  }
  
  public static boolean isVideo(@NonNull String paramString)
  {
    return paramString.contains("video");
  }
  
  public static void setCsdBuffers(@NonNull MediaFormat paramMediaFormat, @NonNull List paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      paramMediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[])paramList.get(i)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.util.TUtils
 * JD-Core Version:    0.7.0.1
 */