import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoPtuResManager.1;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class angh
{
  public static boolean cFq;
  
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    int i = 0;
    String str = "new_qq_android_native_ptu_res_" + paramSVConfigItem.versionCode;
    if (paramSVConfigItem.name.equalsIgnoreCase(str))
    {
      if (paramSVConfigItem.versionCode < 83604)
      {
        i = -2;
        VideoEnvironment.k("ShortVideoPtuResManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPendant=" + 83604, null);
      }
      return i;
    }
    return -4;
  }
  
  private static String aI(Context paramContext)
  {
    String str = aJ(paramContext);
    if (str != null) {}
    for (paramContext = str;; paramContext = "null")
    {
      VideoEnvironment.k("ShortVideoPtuResManager", "getPtuResPath:pathLog = " + paramContext, null);
      return str;
    }
  }
  
  private static String aJ(Context paramContext)
  {
    paramContext = zA();
    if (paramContext.equals("Ptu000_0"))
    {
      VideoEnvironment.k("ShortVideoPtuResManager", "getPtuResPath:pathVersion=Pendant000_0", null);
      return null;
    }
    return zB() + File.separator + paramContext + File.separator;
  }
  
  private static boolean aj(String paramString, int paramInt)
  {
    boolean bool2 = false;
    String str = paramString.trim();
    VideoEnvironment.k("ShortVideoPtuResManager", "checkSignatureVersionIsOK signature=" + paramString, null);
    paramString = angr.a(str);
    int i = paramString.Jm();
    VideoEnvironment.k("ShortVideoPtuResManager", "checkSignatureVersionIsOK errCode=" + i + ",trimSignature=" + str, null);
    boolean bool1 = bool2;
    if (i == 0)
    {
      paramString = paramString.getVersion().trim();
      VideoEnvironment.k("ShortVideoPtuResManager", "checkSignatureVersionIsOK versionValid=" + paramString, null);
      i = Integer.parseInt(paramString);
      VideoEnvironment.k("ShortVideoPtuResManager", "checkSignatureVersionIsOK version=" + i + ",limitVersion=" + paramInt, null);
      bool1 = bool2;
      if (i >= paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean awF()
  {
    return ankq.axZ();
  }
  
  public static int ay(Context paramContext)
  {
    int i = 0;
    if (awF()) {
      if (!by(paramContext)) {
        break label50;
      }
    }
    label50:
    for (i = 1;; i = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPtuResManager", 2, "getPtuResState " + i);
      }
      return i;
    }
  }
  
  private static boolean bx(String paramString1, String paramString2)
  {
    return anfi.by(paramString1, paramString2);
  }
  
  public static boolean by(Context paramContext)
  {
    paramContext = aI(paramContext);
    if (paramContext == null)
    {
      VideoEnvironment.k("ShortVideoPtuResManager", "isFilterSoExist:getPtuResPath soRootPath = null", null);
      return false;
    }
    if (!new File(paramContext).exists())
    {
      VideoEnvironment.k("ShortVideoPtuResManager", "isFilterSoExist:getPtuResPath soRootPath=" + paramContext + ",exists=false", null);
      return false;
    }
    return true;
  }
  
  public static boolean bz(String paramString1, String paramString2)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    bool1 = true;
    for (;;)
    {
      try
      {
        String str = zB();
        str = str + File.separator + paramString1 + File.separator;
        File localFile = new File(str);
        if (localFile.exists())
        {
          if ((zA().equals(paramString1)) && (bx(str, "ptu_config_file")))
          {
            VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:[checkUnzipFileListSizeIsOK]success=true", null);
            bool1 = false;
            return bool1;
          }
          aqhq.cn(str);
          VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:[deleteDirectory|already exists]unzipPath=" + str, null);
        }
        boolean bool4 = localFile.mkdirs();
        VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:[exists]mkOK=" + bool4, null);
        if (!localFile.exists())
        {
          VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:unzipFile.exists=false[error]", null);
          continue;
        }
        try
        {
          aqhq.W(paramString2, str, false);
          bool1 = bx(str, "ptu_config_file");
          VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK success=" + bool1, null);
          if (!bool1) {
            break label434;
          }
          bool1 = anfi.oT(str);
          VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:copyResFileToFinalDir copyOK=" + bool1, null);
          if (!bool1) {
            break;
          }
          bool4 = oY(paramString1);
          VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK saveOK=" + bool4, null);
          bool1 = bool3;
          if (!bool4)
          {
            bool4 = oY(paramString1);
            VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK[two]saveOK=" + bool4, null);
            bool1 = bool3;
            if (!bool4)
            {
              VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
              bool1 = oY("ptu_config_file");
              VideoEnvironment.k("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + bool1 + ",signature=" + paramString1, null);
              bool1 = true;
            }
          }
          dPm();
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            continue;
            bool1 = true;
            continue;
            bool1 = true;
          }
        }
      }
      finally {}
      bool2 = bool1;
      bool1 = bool2;
      if (bool2)
      {
        aqhq.cn(str);
        bool1 = bool2;
      }
    }
  }
  
  private static void dPm()
  {
    ThreadManager.excute(new ShortVideoPtuResManager.1(), 64, null, false);
  }
  
  private static boolean oY(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptu_short_video_mgr_sp", 4).edit();
    localEditor.putString("ptu_short_video_so_name_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.k("ShortVideoPtuResManager", "storeNewPendantUnzipPath commitValue=" + bool + ",pathName=" + paramString, null);
    return bool;
  }
  
  private static String zA()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("ptu_short_video_mgr_sp", 4).getString("ptu_short_video_so_name_key", "Ptu000_0");
    boolean bool = aj(str, 83604);
    VideoEnvironment.k("ShortVideoPtuResManager", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "Ptu000_0";
  }
  
  public static String zB()
  {
    return ankq.aK(VideoEnvironment.getContext()) + "ptu_res";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angh
 * JD-Core Version:    0.7.0.1
 */