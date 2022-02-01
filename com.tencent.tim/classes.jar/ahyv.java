import android.os.SystemClock;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ahyv
  extends ProtocolDownloader.Adapter
{
  public static final String bMr = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "hotpic/");
  
  public static File f(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = new File(bMr + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static URL getURL(String paramString)
  {
    try
    {
      paramString = new URL("hot_pic", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean hW(String paramString)
  {
    return f(paramString).exists();
  }
  
  protected int a(String paramString, File paramFile)
  {
    paramString = new aquz(paramString.replaceFirst("https", "http"), paramFile);
    paramString.akN = 20000;
    paramString.cWw = true;
    paramString.retryCount = 2;
    return aqva.a(paramString, null, null);
  }
  
  protected String a(HotPicData paramHotPicData)
  {
    return paramHotPicData.url;
  }
  
  protected void a(int paramInt, HotPicData paramHotPicData)
  {
    if ((paramHotPicData instanceof EmotionSearchItem)) {
      ajdg.fe(String.valueOf(paramInt), 7);
    }
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    try
    {
      paramDownloadParams = a((HotPicData)paramDownloadParams.mExtraInfo);
      return hW(paramDownloadParams);
    }
    catch (Exception paramDownloadParams)
    {
      paramDownloadParams.printStackTrace();
    }
    return false;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramDownloadParams = (HotPicData)paramDownloadParams.mExtraInfo;
    String str = a(paramDownloadParams);
    int i = 0;
    if ((paramDownloadParams instanceof HotPicSendData)) {
      i = 1;
    }
    File localFile = f(str);
    if (localFile.exists())
    {
      if ((i == 0) && (paramURLDrawableHandler != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager.HotPicDownLoader", 2, "onFileDownloadSucceed:" + paramDownloadParams.picIndex);
        }
        paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.picIndex);
      }
      return localFile;
    }
    localFile.getParentFile().mkdirs();
    if ((aqft.cC()) && (aqft.hE() < 20971520L)) {
      throw new IOException("SD card free space is " + aqft.hE());
    }
    Object localObject = new File(bMr);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    SystemClock.uptimeMillis();
    int j = a(str, localFile);
    a(j, paramDownloadParams);
    if (j == 0)
    {
      str = alab.getFileMD5String(localFile.getAbsolutePath());
      localObject = paramDownloadParams.md5;
      if ((!paramDownloadParams.md5.equalsIgnoreCase(str)) && (QLog.isColorLevel())) {
        QLog.d("HotPicManager.HotPicDownLoader", 2, "md5 match fail: " + (String)localObject + " " + str);
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager.HotPicDownLoader", 2, "onFileDownloadSucceed download:" + paramDownloadParams.picIndex + localFile.getAbsolutePath());
        }
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.picIndex);
        }
      }
      return localFile;
    }
    if (paramURLDrawableHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.HotPicDownLoader", 2, "onFileDownloadFailed:" + paramDownloadParams.picIndex + " " + j);
      }
      paramURLDrawableHandler.onFileDownloadFailed(paramDownloadParams.picIndex);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyv
 * JD-Core Version:    0.7.0.1
 */