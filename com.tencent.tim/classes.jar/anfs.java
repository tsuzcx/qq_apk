import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class anfs
{
  public static boolean R(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.r(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_short_filter_")) {
      return ankq.by(VideoEnvironment.getContext());
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return anfo.awC();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return anfz.awC();
    }
    if (paramString.startsWith("msf_quic_lib")) {
      return aqpc.co(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return anga.awC();
    }
    if (paramString.startsWith("new_qq_android_native_object_tracking_")) {
      return angs.awC();
    }
    return false;
  }
  
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    VideoEnvironment.k("ShortVideoResourceManager", "userCheckNeedDownload:APPID=" + AppSetting.getAppId() + " subVersion=" + "3.4.4" + " buildnum=" + "3058", null);
    String str;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      str = "new_qq_android_native_short_video_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 65)
        {
          VideoEnvironment.k("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInShortVideo=" + 65, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_filter_"))
    {
      str = "new_qq_android_native_short_filter_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 83606)
        {
          VideoEnvironment.k("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPendant=" + 83606, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_"))
    {
      str = "new_qq_android_native_art_filter_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 9)
        {
          VideoEnvironment.k("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInArt=" + 9, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_new_other_"))
    {
      str = "new_qq_android_native_short_new_other_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 1)
        {
          VideoEnvironment.k("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_"))
    {
      str = "new_qq_android_native_short_other_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 1)
        {
          VideoEnvironment.k("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else
    {
      if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        return aqpc.a(paramSVConfigItem);
      }
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_"))
      {
        str = "new_qq_android_native_portrait_filter_" + paramSVConfigItem.versionCode;
        if (paramSVConfigItem.name.equalsIgnoreCase(str))
        {
          if (paramSVConfigItem.versionCode < 9)
          {
            VideoEnvironment.k("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPortrait=" + 9, null);
            return -2;
          }
        }
        else {
          return -4;
        }
      }
      else
      {
        if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_")) {
          return angs.a(paramSVConfigItem);
        }
        if (paramSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_")) {
          return angh.a(paramSVConfigItem);
        }
      }
    }
    return 0;
  }
  
  public static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    boolean bool1 = true;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      boolean bool2 = VideoEnvironment.lv(paramSVConfigItem.versionCode);
      VideoEnvironment.k("ShortVideoResourceManager", "userCheckNeedDownload[Builtin Mode]:needDownload=" + bool2 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      bool1 = bool2;
      if (bool2) {
        bool1 = VideoEnvironment.q(paramAppInterface);
      }
    }
    for (;;)
    {
      VideoEnvironment.k("ShortVideoResourceManager", "userCheckNeedDownload:needDownload=" + bool1 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      return bool1;
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_filter_")) {
        bool1 = awD();
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
        bool1 = anfo.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
        bool1 = anfz.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        bool1 = aqpc.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        bool1 = anga.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_")) {
        bool1 = angs.a(paramAppInterface, paramSVConfigItem);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool1 = true;
    if (paramString1 == null) {}
    do
    {
      return false;
      if (paramString1.startsWith("new_qq_android_native_short_video_"))
      {
        bool1 = VideoEnvironment.s(paramQQAppInterface, paramString3, paramInt);
        if (bool1)
        {
          VideoEnvironment.a(false, paramQQAppInterface);
          return bool1;
        }
        VideoEnvironment.a(true, paramQQAppInterface);
        return bool1;
      }
      if (paramString1.startsWith("new_qq_android_native_short_filter_"))
      {
        boolean bool2 = anfi.bw(paramString2, paramString3);
        if (!bool2) {}
        for (;;)
        {
          anfi.PG(bool1);
          return bool2;
          bool1 = false;
        }
      }
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        return anfo.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_short_other_")) {
        return anfz.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("msf_quic_lib")) {
        return aqpc.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
        return anga.b(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        return angs.c(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
    } while (!paramString1.startsWith("new_qq_android_native_ptu_res_"));
    return angh.bz(paramString2, paramString3);
  }
  
  private static boolean awD()
  {
    boolean bool = imm.isBeautySupported();
    VideoEnvironment.k("ShortVideoResourceManager", "isArmV7aAndNeon:isNeon=" + bool + ",SDK_INT=" + Build.VERSION.SDK_INT, null);
    return (bool) && (Build.VERSION.SDK_INT >= 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfs
 * JD-Core Version:    0.7.0.1
 */