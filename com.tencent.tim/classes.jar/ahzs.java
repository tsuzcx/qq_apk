import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class ahzs
  extends ProtocolDownloader.Adapter
{
  public static final String bMy = acbn.SDCARD_PATH + "hotvideo/preview/";
  
  public static Drawable a(Context paramContext, HotVideoData paramHotVideoData)
  {
    Object localObject2 = null;
    Object localObject1;
    if (Build.VERSION.SDK_INT < 17) {
      localObject1 = new ColorDrawable(Color.parseColor("#7f000000"));
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return localObject1;
                localObject1 = localObject2;
              } while (paramHotVideoData == null);
              localObject1 = localObject2;
            } while (paramHotVideoData.url == null);
            localObject1 = localObject2;
          } while (paramHotVideoData.md5 == null);
          localObject1 = localObject2;
        } while (paramContext == null);
        localObject1 = localObject2;
      } while (!f(paramHotVideoData.md5).exists());
      localObject1 = Utils.Crc64String(paramHotVideoData.md5);
      localObject1 = bMy + (String)localObject1;
      try
      {
        localObject1 = BitmapFactory.decodeFile((String)localObject1);
        paramHotVideoData = (HotVideoData)localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
          QLog.e("HotPicManager.HotVideoPreviewDownloader", 1, "decodeFile hotVideo thum Bitmap OOM. hotVideo name is " + paramHotVideoData.name);
          paramHotVideoData = null;
        }
      }
      localObject1 = localObject2;
    } while (paramHotVideoData == null);
    paramHotVideoData = ahzu.a(paramHotVideoData, 10.0F, paramContext);
    return new BitmapDrawable(paramContext.getResources(), paramHotVideoData);
  }
  
  public static String a(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {
      return null;
    }
    return bMy + paramHotVideoData.md5 + ".jpg";
  }
  
  public static URL a(HotVideoData paramHotVideoData)
  {
    paramHotVideoData = a(paramHotVideoData);
    try
    {
      paramHotVideoData = new URL("hot_video_preview", "", paramHotVideoData);
      return paramHotVideoData;
    }
    catch (MalformedURLException paramHotVideoData)
    {
      paramHotVideoData.printStackTrace();
    }
    return null;
  }
  
  private void a(File paramFile, HotVideoData paramHotVideoData, URLDrawableHandler paramURLDrawableHandler)
  {
    File localFile = paramFile;
    if (paramFile == null) {
      localFile = f(paramHotVideoData.md5);
    }
    paramFile = new File(bMy);
    if (!paramFile.exists()) {
      paramFile.mkdir();
    }
    SystemClock.uptimeMillis();
    paramFile = new aquz(paramHotVideoData.url.replaceFirst("https", "http"), localFile);
    paramFile.cWw = true;
    paramFile.retryCount = 2;
    int i = aqva.a(paramFile, null, null);
    if (i == 0)
    {
      paramFile = alab.getFileMD5String(localFile.getAbsolutePath());
      if (!paramHotVideoData.md5.equalsIgnoreCase(paramFile))
      {
        localFile.delete();
        a("onFileDownloadFailed .md5.equalsIgnoreCase is false videoData.md5 is :" + paramHotVideoData.md5 + " fileMD5 is " + paramFile, paramHotVideoData);
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadFailed(paramHotVideoData.picIndex);
        }
        paramHotVideoData.onFileDownloadFailed(paramHotVideoData.picIndex);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.HotVideoPreviewDownloader", 2, "onFileDownloadSucceed download:" + paramHotVideoData.picIndex + localFile.getAbsolutePath());
      }
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadSucceed(paramHotVideoData.picIndex);
      }
      paramHotVideoData.onFileDownloadSucceed(paramHotVideoData.picIndex);
      a("DownloadFile: onFileDownloadSucceed End", paramHotVideoData);
      return;
    }
    if (paramURLDrawableHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.HotVideoPreviewDownloader", 2, "onFileDownloadFailed:" + paramHotVideoData.picIndex + " " + i);
      }
      paramURLDrawableHandler.onFileDownloadFailed(paramHotVideoData.picIndex);
    }
    paramHotVideoData.onFileDownloadFailed(paramHotVideoData.picIndex);
    a("DownloadFile: onFileDownloadFailed End", paramHotVideoData);
  }
  
  private static void a(String paramString, HotVideoData paramHotVideoData)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = Calendar.getInstance();
      localObject = "" + " Time is :" + ((Calendar)localObject).get(11) + ":" + ((Calendar)localObject).get(12) + ":" + ((Calendar)localObject).get(13) + ":" + ((Calendar)localObject).get(14);
      localObject = (String)localObject + " " + paramString;
      paramString = (String)localObject;
      if (paramHotVideoData != null)
      {
        paramString = (String)localObject + " PicIndex is " + paramHotVideoData.picIndex;
        paramString = paramString + " Name is " + paramHotVideoData.name;
      }
      QLog.d("HotPicManager.HotVideoPreviewDownloader", 2, paramString);
    }
  }
  
  public static boolean b(HotVideoData paramHotVideoData)
  {
    if ((paramHotVideoData == null) || (paramHotVideoData.md5 == null)) {}
    do
    {
      return false;
      paramHotVideoData = f(paramHotVideoData.md5);
    } while ((paramHotVideoData == null) || (!paramHotVideoData.exists()));
    return true;
  }
  
  public static File f(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = new File(bMy + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramDownloadParams = (HotVideoData)paramDownloadParams.mExtraInfo;
    paramURLDrawableHandler = alab.getFileMD5String(paramFile.getAbsolutePath());
    if (paramDownloadParams.md5.equalsIgnoreCase(paramURLDrawableHandler)) {
      try
      {
        paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
        return paramFile;
      }
      catch (OutOfMemoryError paramFile)
      {
        paramFile.printStackTrace();
        QLog.e("HotPicManager.HotVideoPreviewDownloader", 1, "Override decodeFile hotVideo thum Bitmap OOM. HotVideo name is " + paramDownloadParams.name);
        return null;
      }
    }
    return null;
  }
  
  @TargetApi(9)
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramDownloadParams = (HotVideoData)paramDownloadParams.mExtraInfo;
    paramDownloadParams.onFileDownloadStarted();
    File localFile = f(paramDownloadParams.md5);
    if (localFile.exists())
    {
      paramDownloadParams.onFileDownloadSucceed(paramDownloadParams.picIndex);
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.picIndex);
      }
      return localFile;
    }
    if ((aqft.cC()) && (aqft.hE() < 20971520L)) {
      throw new IOException("SD card free space is " + aqft.hE());
    }
    if (paramDownloadParams.url.isEmpty())
    {
      paramDownloadParams.GetPreviewURLAsync((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0, "0", new ahzt(this, paramDownloadParams, localFile, paramURLDrawableHandler));
      return localFile;
    }
    a(localFile, paramDownloadParams, paramURLDrawableHandler);
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzs
 * JD-Core Version:    0.7.0.1
 */