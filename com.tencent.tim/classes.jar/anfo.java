import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.ShortVideoArtResourceMgr.1;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anfo
{
  static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    if (!ankq.ayb()) {
      return false;
    }
    int i = anjn.JJ();
    QmcfManager.getInstance().setCurrFrameType(i);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoArtResourceMgr", 2, String.format("supportFrameType[%s]", new Object[] { Integer.valueOf(i) }));
    }
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      QmcfManager.getInstance().setQmcfMobileNotSupport(anjn.cen);
      return false;
      paramSVConfigItem.armv7a_url = paramSVConfigItem.extend1;
      paramSVConfigItem.armv7a_md5 = paramSVConfigItem.extend2;
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    paramQQAppInterface = zv();
    paramQQAppInterface = paramQQAppInterface + paramString1 + File.separator;
    File localFile = new File(paramQQAppInterface);
    if (localFile.exists())
    {
      if ((zu().equals(paramString1)) && (anfi.by(paramQQAppInterface, "artfilter_config_file")))
      {
        VideoEnvironment.k("ShortVideoArtResourceMgr", "uncompressPendantZip:[checkConfigFileListIsOK]success=true", null);
        return false;
      }
      aqhq.cn(paramQQAppInterface);
      VideoEnvironment.k("ShortVideoArtResourceMgr", "uncompressPendantZip:[deleteDirectory|already exists]unzipPath=" + paramQQAppInterface, null);
    }
    boolean bool1 = localFile.mkdirs();
    VideoEnvironment.k("ShortVideoArtResourceMgr", "uncompressPendantZip:[exists]mkOK=" + bool1, null);
    try
    {
      aqhq.W(paramString2, paramQQAppInterface, false);
      bool1 = anfi.by(paramQQAppInterface, "artfilter_config_file");
      VideoEnvironment.k("ShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK success=" + bool1, null);
      if (bool1)
      {
        boolean bool3 = oV(paramString1);
        VideoEnvironment.k("ShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK saveOK=" + bool3, null);
        bool1 = bool2;
        if (!bool3)
        {
          bool3 = oV(paramString1);
          VideoEnvironment.k("ShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK[two]saveOK=" + bool3, null);
          bool1 = bool2;
          if (!bool3)
          {
            VideoEnvironment.k("ShortVideoArtResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
            bool1 = oV("artfilter000_0");
            VideoEnvironment.k("ShortVideoArtResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + bool1 + ",signature=" + paramString1, null);
            bool1 = true;
          }
        }
        dPj();
        return bool1;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return true;
    }
    return true;
  }
  
  static boolean awC()
  {
    return ankq.bz(VideoEnvironment.getContext());
  }
  
  private static void dPj()
  {
    ThreadManager.post(new ShortVideoArtResourceMgr.1(), 5, null, false);
  }
  
  private static boolean oV(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("QmcfConfig", 4).edit();
    localEditor.putString("art_res_sv_md5_version_soname_key", paramString);
    return localEditor.commit();
  }
  
  public static String zu()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("QmcfConfig", 4).getString("art_res_sv_md5_version_soname_key", "artfilter000_0");
    boolean bool = anfi.aj(str, 9);
    VideoEnvironment.k("ShortVideoArtResourceMgr", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "artfilter000_0";
  }
  
  public static String zv()
  {
    String str = ankq.aK(VideoEnvironment.getContext());
    return str + "art_res_cache" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfo
 * JD-Core Version:    0.7.0.1
 */