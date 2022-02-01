import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;

public class inf
{
  public static int a(imz paramimz)
  {
    if (paramimz == null) {}
    do
    {
      do
      {
        return 11;
        if (!TextUtils.isEmpty(paramimz.MD5_so)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QavGPDownloadManager", 4, String.format("getEnableFlag, %s", new Object[] { paramimz }));
      return 11;
      if (!paramimz.enable) {
        break;
      }
    } while (!b(paramimz));
    return 1;
    return 2;
  }
  
  public static boolean b(imz paramimz)
  {
    String str1 = paramimz.MD5_zip_so;
    paramimz = getSoDir() + paramimz.so_name + ".so";
    String str2 = getSP().getString("so_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (aqhq.fileExists(paramimz)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavGPDownloadManager", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramimz }));
    return false;
    return true;
  }
  
  static SharedPreferences getSP()
  {
    return EffectConfigBase.a(298, EffectConfigBase.Nk);
  }
  
  public static String getSoDir()
  {
    return AVSoUtils.getTxlibPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     inf
 * JD-Core Version:    0.7.0.1
 */