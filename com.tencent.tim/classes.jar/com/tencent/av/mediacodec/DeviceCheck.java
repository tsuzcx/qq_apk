package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import ijc;
import ioc;
import ioc.b;
import ioe;
import java.util.List;

@SuppressLint({"NewApi"})
public class DeviceCheck
  implements Runnable
{
  static boolean checkDecoderSupportColorFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  static boolean checkEncoderSupportColorFormat(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean forceSyncAPI()
  {
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean isAVCDecSupportColorformats()
  {
    boolean bool2 = false;
    List localList = ioc.getDecoderInfos(ioc.AVC_CODEC_MIME);
    int i = 0;
    boolean bool1 = bool2;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    if (i < localList.size())
    {
      localCodecCapabilities = ioc.getCodecCapabilities((MediaCodecInfo)localList.get(i), ioc.AVC_CODEC_MIME);
      if ((localCodecCapabilities != null) && (localCodecCapabilities.colorFormats != null)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (checkDecoderSupportColorFormat(localCodecCapabilities.colorFormats[j]))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
    }
  }
  
  public static boolean isAVCDecWhitelistDevices()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 4")) && (Build.PRODUCT.equalsIgnoreCase("occam")) && (Build.VERSION.SDK_INT >= 21)) {
      bool1 = isAVCDecSupportColorformats();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 5")) && (Build.PRODUCT.equalsIgnoreCase("hammerhead"))) {
              return isAVCDecSupportColorformats();
            }
            if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500")) && (Build.VERSION.SDK_INT > 18)) {
              return isAVCDecSupportColorformats();
            }
            if ((!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (!Build.MODEL.equalsIgnoreCase("MI 3"))) {
              break;
            }
            bool1 = bool2;
          } while (Build.PRODUCT.equalsIgnoreCase("pisces"));
          if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("LG-D802"))) {
            return isAVCDecSupportColorformats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("MX4 Pro"))) {
            return isAVCDecSupportColorformats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("M353")) && (Build.PRODUCT.equalsIgnoreCase("meizu_mx3"))) {
            return isAVCDecSupportColorformats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("m1 note")) && (Build.PRODUCT.equalsIgnoreCase("m1 note"))) {
            return isAVCDecSupportColorformats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9005")) && (Build.VERSION.SDK_INT > 18)) {
            return true;
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9006V")) && (Build.VERSION.SDK_INT > 18)) {
            return isAVCDecSupportColorformats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("smartisan")) && (Build.MODEL.equalsIgnoreCase("SM705")) && (Build.PRODUCT.equalsIgnoreCase("msm8974sfo_lte"))) {
            return isAVCDecSupportColorformats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
            return isAVCDecSupportColorformats();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("HM 1SC")) && (Build.PRODUCT.equalsIgnoreCase("armani"))) {
            return isAVCDecSupportColorformats();
          }
          bool1 = bool2;
        } while (!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"));
        bool1 = bool2;
      } while (!Build.MODEL.equalsIgnoreCase("HM NOTE 1TD"));
      bool1 = bool2;
    } while (!Build.PRODUCT.equalsIgnoreCase("Icsh92_wet_tdd"));
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean isAVCEncSupportColorformats()
  {
    boolean bool2 = false;
    List localList = ioc.getEndoderInfos(ioc.AVC_CODEC_MIME);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      int j;
      if (i < localList.size())
      {
        localCodecCapabilities = ioc.getCodecCapabilities((MediaCodecInfo)localList.get(i), ioc.AVC_CODEC_MIME);
        if (localCodecCapabilities != null) {
          j = 0;
        }
      }
      else
      {
        while (j < localCodecCapabilities.colorFormats.length)
        {
          if (checkEncoderSupportColorFormat(localCodecCapabilities.colorFormats[j]))
          {
            bool1 = true;
            return bool1;
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  public static boolean isAVCEncWhitelistDevices()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return false;
      if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
        return isAVCEncSupportColorformats();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
        return isAVCEncSupportColorformats();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI NOTE LTE")) && (Build.PRODUCT.equalsIgnoreCase("virgo"))) {
        return isAVCEncSupportColorformats();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("asus")) && (Build.MODEL.equalsIgnoreCase("ASUS_Z00ADA")) && (Build.PRODUCT.equalsIgnoreCase("CN_Z00A"))) {
        return isAVCEncSupportColorformats();
      }
    } while ((!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (!Build.MODEL.equalsIgnoreCase("MI 4W")) || (!Build.PRODUCT.equalsIgnoreCase("cancro_wc_lte")));
    return isAVCEncSupportColorformats();
  }
  
  public static boolean isSupportAsyncAPI()
  {
    if (forceSyncAPI()) {}
    ioe localioe;
    ioc.b localb1;
    ioc.b localb2;
    do
    {
      do
      {
        return false;
      } while (Build.VERSION.SDK_INT < 21);
      localioe = new ioe(ijc.a(BaseApplicationImpl.getContext()));
      localb1 = localioe.d();
      localb2 = localioe.c();
    } while ((localb1 == null) || (!localb1.Tx) || (!localioe.isEnableAsyncApi(2)) || (localb2 == null) || (!localb2.Tx) || (!localioe.isEnableAsyncApi(1)));
    if (QLog.isColorLevel()) {
      QLog.d("DeviceCheck", 2, "SUPPORT Async API");
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean uA()
  {
    List localList = ioc.getEndoderInfos(ioc.OM);
    int i = 0;
    for (;;)
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      if (i < localList.size())
      {
        localCodecCapabilities = ioc.getCodecCapabilities((MediaCodecInfo)localList.get(i), ioc.OM);
        if (localCodecCapabilities != null) {}
      }
      else
      {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (checkEncoderSupportColorFormat(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean uz()
  {
    List localList = ioc.getDecoderInfos(ioc.OM);
    int i = 0;
    for (;;)
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      if (i < localList.size())
      {
        localCodecCapabilities = ioc.getCodecCapabilities((MediaCodecInfo)localList.get(i), ioc.OM);
        if ((localCodecCapabilities != null) && (localCodecCapabilities.colorFormats != null)) {}
      }
      else
      {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (checkDecoderSupportColorFormat(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.mediacodec.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */