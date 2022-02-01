import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.so.DownloadInfo;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class iwi
{
  public static int a(DownloadInfo paramDownloadInfo)
  {
    int i = 1;
    if (paramDownloadInfo == null) {}
    do
    {
      return 11;
      if (!TextUtils.isEmpty(paramDownloadInfo.MD5_so_wxvoiceembedqqegg)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QavSo", 4, String.format("getEnableFlag, %s", new Object[] { paramDownloadInfo }));
    return 11;
    if (paramDownloadInfo.enable) {
      if ((c(paramDownloadInfo)) && (b(paramDownloadInfo))) {}
    }
    for (i = 11;; i = 2) {
      return i;
    }
  }
  
  public static boolean b(DownloadInfo paramDownloadInfo)
  {
    String str1 = paramDownloadInfo.MD5_zip_model;
    paramDownloadInfo = getModelDir() + paramDownloadInfo.filename_model_wxvoiceembed;
    String str2 = DownloadInfo.getSP().getString("model_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase(str1)))
    {
      QLog.i("QavSo", 1, String.format("isModelReady, spMd5[%s], zipMd5[%s]", new Object[] { str2, str1 }));
      return false;
    }
    if (!aqhq.fileExists(paramDownloadInfo))
    {
      QLog.i("QavSo", 1, String.format("isModelReady, file no exist, fileName[%s]", new Object[] { paramDownloadInfo }));
      return false;
    }
    return true;
  }
  
  public static boolean c(DownloadInfo paramDownloadInfo)
  {
    String str1 = paramDownloadInfo.MD5_zip_so;
    paramDownloadInfo = getSoDir() + paramDownloadInfo.filename_so_wxvoiceembedqqegg;
    String str2 = DownloadInfo.getSP().getString("so_zip_md5", null);
    if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase(str1)))
    {
      QLog.i("QavSo", 1, String.format("isSoReady, spMd5[%s], zipMd5[%s]", new Object[] { str2, str1 }));
      return false;
    }
    if (!aqhq.fileExists(paramDownloadInfo))
    {
      QLog.i("QavSo", 1, String.format("isSoReady, file no exist, fileNameSoWxVoiceEmbedQQEgg[%s]", new Object[] { paramDownloadInfo }));
      return false;
    }
    return true;
  }
  
  public static String dx(String paramString)
  {
    return "795";
  }
  
  public static String getModelDir()
  {
    return getSoDir();
  }
  
  public static String getSoDir()
  {
    return AVSoUtils.getTxlibPath() + "qavso" + dx("") + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwi
 * JD-Core Version:    0.7.0.1
 */