import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.util.Pair;
import java.io.File;

public class adkz
{
  public static volatile ISPlayerPreDownloader c;
  
  public static void a(Context paramContext, ArVideoResourceInfo paramArVideoResourceInfo)
  {
    boolean bool = true;
    if ((paramArVideoResourceInfo == null) || (TextUtils.isEmpty(paramArVideoResourceInfo.videoUrl)) || (paramArVideoResourceInfo.videoType != 4)) {
      return;
    }
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AROnlineVideoUtil", 2, "preload for multi, isWifi=" + bool);
      }
      if (!bool) {
        break;
      }
      if (c == null) {
        c = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getApplication(), 108);
      }
      if (TextUtils.isEmpty(paramArVideoResourceInfo.videoUrl)) {
        break;
      }
      paramContext = paramArVideoResourceInfo.videoUrl;
      String str = jQ(paramContext);
      bool = isCached(str);
      if (QLog.isColorLevel()) {
        QLog.d("AROnlineVideoUtil", 2, "preload for multi, url=" + paramContext + ", videoPath=" + str + ", isCached=" + bool);
      }
      paramContext = SuperPlayerFactory.createVideoInfoForUrl(paramContext, 101, arwv.toMD5(paramContext));
      if (paramArVideoResourceInfo.videoSize <= 4L) {
        break;
      }
      c.startPreDownload(paramContext, paramArVideoResourceInfo.videoSize / 4L);
      return;
      bool = false;
    }
  }
  
  public static Pair<Long, String> c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AROnlineVideoUtil", 2, "parseFileSize, str=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = paramString.split("\\|");
      if ((paramString == null) || (paramString.length != 2)) {
        continue;
      }
      try
      {
        l = Long.parseLong(paramString[0]);
        if (l == -1L) {
          continue;
        }
        return new Pair(Long.valueOf(l), paramString[1]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
          long l = -1L;
        }
      }
    }
  }
  
  private static boolean isCached(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
  
  public static String jQ(String paramString)
  {
    try
    {
      paramString = arwv.toMD5(paramString);
      paramString = sG() + paramString;
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("AROnlineVideoUtil", 2, "getStorageDir, Exception");
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  private static String sG()
  {
    if (aqfo.isExistSDCard()) {
      return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "iar" + File.separator);
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "iar" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkz
 * JD-Core Version:    0.7.0.1
 */