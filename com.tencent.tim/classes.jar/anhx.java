import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anhx
{
  public static int a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    label132:
    label135:
    for (;;)
    {
      return 11;
      if (TextUtils.isEmpty(paramDownloadInfo.MD5_so))
      {
        if (QLog.isDevelopLevel())
        {
          QLog.d("QavGesture", 4, String.format("getEnableFlag, %s", new Object[] { paramDownloadInfo }));
          return 11;
        }
      }
      else
      {
        int i;
        int j;
        if (paramDownloadInfo.enable) {
          if ((!e(paramDownloadInfo)) || (!d(paramDownloadInfo)))
          {
            i = 11;
            if (!paramDownloadInfo.gameEnable) {
              break label132;
            }
            if ((e(paramDownloadInfo)) && (c(paramDownloadInfo))) {
              break label127;
            }
            j = 11;
          }
        }
        for (;;)
        {
          if ((j == 11) || (i == 11)) {
            break label135;
          }
          if ((j != 2) || (i != 2)) {
            break label137;
          }
          return 2;
          i = 1;
          break;
          i = 2;
          break;
          label127:
          j = 1;
          continue;
          j = 2;
        }
      }
    }
    label137:
    return 1;
  }
  
  public static boolean b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    while ((TextUtils.isEmpty(paramDownloadInfo.url_zip_gamemodel)) || (TextUtils.isEmpty(paramDownloadInfo.MD5_zip_gamemodel)) || (TextUtils.isEmpty(paramDownloadInfo.gamemodel_fullname))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(DownloadInfo paramDownloadInfo)
  {
    String str1 = paramDownloadInfo.MD5_zip_gamemodel;
    paramDownloadInfo = getGameModelPath() + paramDownloadInfo.gamemodel_fullname;
    String str2 = DownloadInfo.getSP().getString("gamemodel_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("isGameModelReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (aqhq.fileExists(paramDownloadInfo)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGesture", 4, String.format("isGameModelReady, file no exist,  fileName[%s]", new Object[] { paramDownloadInfo }));
    return false;
    return true;
  }
  
  public static boolean d(DownloadInfo paramDownloadInfo)
  {
    String str1 = paramDownloadInfo.MD5_zip_model;
    paramDownloadInfo = getModelPath() + paramDownloadInfo.model_fullname;
    String str2 = DownloadInfo.getSP().getString("model_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("isModelReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (aqhq.fileExists(paramDownloadInfo)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGesture", 4, String.format("isModelReady, file no exist,  fileName[%s]", new Object[] { paramDownloadInfo }));
    return false;
    return true;
  }
  
  public static boolean e(DownloadInfo paramDownloadInfo)
  {
    String str1 = paramDownloadInfo.MD5_zip_so;
    paramDownloadInfo = getSoDir() + paramDownloadInfo.so_fullname;
    String str2 = DownloadInfo.getSP().getString("so_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (aqhq.fileExists(paramDownloadInfo)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGesture", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramDownloadInfo }));
    return false;
    return true;
  }
  
  public static String getGameModelPath()
  {
    return getSoDir() + "gamemodel" + File.separator;
  }
  
  public static String getModelPath()
  {
    return getSoDir() + "model" + File.separator;
  }
  
  public static String getSoDir()
  {
    return AVSoUtils.getTxlibPath() + "so763" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhx
 * JD-Core Version:    0.7.0.1
 */