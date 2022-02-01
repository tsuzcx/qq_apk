import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.io.File;

class anfz
{
  static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    return false;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    paramQQAppInterface = zx();
    paramQQAppInterface = paramQQAppInterface + paramString1 + File.separator;
    File localFile = new File(paramQQAppInterface);
    if (localFile.exists()) {
      if ((zw().equals(paramString1)) && (anfi.by(paramQQAppInterface, "other_res_config_file"))) {
        VideoEnvironment.k("ShortVideoOtherResourceMgr", "uncompressPendantZip:[checkUnzipFileListSizeIsOK]success=true", null);
      }
    }
    for (;;)
    {
      return false;
      aqhq.cn(paramQQAppInterface);
      VideoEnvironment.k("ShortVideoOtherResourceMgr", "uncompressPendantZip:[deleteDirectory|already exists]unzipPath=" + paramQQAppInterface, null);
      boolean bool = localFile.mkdirs();
      VideoEnvironment.k("ShortVideoOtherResourceMgr", "uncompressPendantZip:[exists]mkOK=" + bool, null);
      try
      {
        aqhq.W(paramString2, paramQQAppInterface, false);
        bool = anfi.by(paramQQAppInterface, "other_res_config_file");
        VideoEnvironment.k("ShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK success=" + bool, null);
        if (bool)
        {
          bool = oW(paramString1);
          VideoEnvironment.k("ShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK saveOK=" + bool, null);
          if (bool) {
            continue;
          }
          bool = oW(paramString1);
          VideoEnvironment.k("ShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two]saveOK=" + bool, null);
          return false;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return true;
      }
    }
    return true;
  }
  
  static boolean awC()
  {
    return true;
  }
  
  private static boolean oW(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("other_res_short_video_mgr_sp", 4).edit();
    localEditor.putString("other_res_sv_md5_version_soname_key", paramString);
    return localEditor.commit();
  }
  
  public static String zw()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("other_res_short_video_mgr_sp", 4).getString("other_res_sv_md5_version_soname_key", "other_res000_0");
    boolean bool = anfi.aj(str, 1);
    VideoEnvironment.k("ShortVideoOtherResourceMgr", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "other_res000_0";
  }
  
  public static String zx()
  {
    String str = ankq.aK(VideoEnvironment.getContext());
    return str + "other_res_cache" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfz
 * JD-Core Version:    0.7.0.1
 */