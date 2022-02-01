import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.io.File;

public class angs
{
  private static String cdD = "Xiaomi;Redmi 4X;23|LGE;Nexus 5X;27|HUAWEI;CAM-UL00;23";
  
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    if (paramSVConfigItem.versionCode >= 1) {}
    for (int i = 0;; i = -4)
    {
      VideoEnvironment.k("ShortVideoTrackingResourceMgr", "[checkResourceLowLimitVersion]limitVer=1 downVer=" + paramSVConfigItem.versionCode + " errCode=" + i, null);
      return i;
    }
  }
  
  static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    return ankq.ayd();
  }
  
  static boolean awC()
  {
    return anla.ayl();
  }
  
  static boolean c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    label349:
    for (;;)
    {
      try
      {
        paramQQAppInterface = zI();
        paramQQAppInterface = paramQQAppInterface + paramString1 + File.separator;
        File localFile = new File(paramQQAppInterface);
        if (localFile.exists())
        {
          if ((zH().equals(paramString1)) && (anfi.by(paramQQAppInterface, "tracking_config_file")))
          {
            VideoEnvironment.k("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:[checkUnzipFileListSizeIsOK]success=true", null);
            return bool1;
          }
          aqhq.cn(paramQQAppInterface);
          VideoEnvironment.k("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:[deleteDirectory|already exists]unzipPath=" + paramQQAppInterface, null);
        }
        bool1 = localFile.mkdirs();
        VideoEnvironment.k("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:[exists]mkOK=" + bool1, null);
        try
        {
          aqhq.W(paramString2, paramQQAppInterface, false);
          boolean bool3 = anfi.by(paramQQAppInterface, "tracking_config_file");
          VideoEnvironment.k("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK success=" + bool3, null);
          bool1 = bool2;
          if (bool3)
          {
            bool1 = pb(paramString1);
            VideoEnvironment.k("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK saveOK=" + bool1, null);
            if (bool1) {
              break label349;
            }
            bool1 = pb(paramString1);
            VideoEnvironment.k("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK[two]saveOK=" + bool1, null);
            if (bool1) {
              break label349;
            }
            VideoEnvironment.k("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
            bool1 = pb("Tracking000_0");
            VideoEnvironment.k("ShortVideoTrackingResourceMgr", "uncompressTrackingZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + bool1 + ",signature=" + paramString1, null);
            bool1 = bool2;
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          bool1 = bool2;
          continue;
        }
        bool1 = false;
      }
      finally {}
    }
  }
  
  private static boolean pb(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("tracking_short_video_mgr_sp", 4).edit();
    localEditor.putString("tracking_sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.k("ShortVideoTrackingResourceMgr", "storeNewPendantUnzipPath commitValue=" + bool + ",pathName=" + paramString, null);
    return bool;
  }
  
  public static String zH()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("tracking_short_video_mgr_sp", 4).getString("tracking_sv_md5_version_soname_key", "Tracking000_0");
    boolean bool = anfi.aj(str, 1);
    VideoEnvironment.k("ShortVideoTrackingResourceMgr", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "Tracking000_0";
  }
  
  public static String zI()
  {
    String str = ankq.aK(VideoEnvironment.getContext());
    return str + "tracking_res_cache" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angs
 * JD-Core Version:    0.7.0.1
 */