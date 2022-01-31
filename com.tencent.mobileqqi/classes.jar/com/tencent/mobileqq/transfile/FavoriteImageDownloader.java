package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class FavoriteImageDownloader
  extends AbstractImageDownloader
{
  public static final String e = "favimage";
  
  public FavoriteImageDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("favimage", paramBaseApplicationImpl);
  }
  
  public FavoriteImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  public static File a(URL paramURL)
  {
    paramURL = a(paramURL, new String[] { null });
    if (paramURL == null) {
      return null;
    }
    return new File(paramURL);
  }
  
  private static String a(URL paramURL, String[] paramArrayOfString)
  {
    Object localObject = paramURL.getFile();
    if (((String)localObject).startsWith("file/")) {
      paramURL = ((String)localObject).substring("file/".length());
    }
    do
    {
      do
      {
        return paramURL;
        if (((String)localObject).startsWith("file://")) {
          return ((String)localObject).substring(7);
        }
        paramURL = (URL)localObject;
      } while (!((String)localObject).startsWith("http"));
      paramURL = (URL)localObject;
      if (((String)localObject).startsWith("http/")) {
        paramURL = ((String)localObject).substring("http/".length());
      }
      localObject = paramURL.split("\\|");
    } while (localObject.length < 2);
    paramArrayOfString[0] = localObject[0];
    return localObject[1];
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int j = 1;
    paramOutputStream = new String[1];
    paramOutputStream[0] = null;
    String str1 = a(paramDownloadParams.url, paramOutputStream);
    int i;
    Object localObject;
    if (paramOutputStream[0] != null)
    {
      if (new File(str1).exists()) {
        break label404;
      }
      i = 1;
      if (i != 0) {
        break label491;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    }
    try
    {
      BitmapFactory.decodeFile(str1, (BitmapFactory.Options)localObject);
      i = ((BitmapFactory.Options)localObject).outHeight;
      int k = ((BitmapFactory.Options)localObject).outWidth;
      if (k + i != 0) {
        break label410;
      }
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label100:
        String str3;
        i = j;
      }
    }
    j = i;
    if (i != 0) {
      new File(str1).delete();
    }
    label404:
    label410:
    label491:
    for (j = i;; j = i)
    {
      String str2;
      if ((j != 0) && (NetworkUtil.f(this.a.getApplicationContext())))
      {
        localObject = paramDownloadParams.url;
        str2 = paramDownloadParams.urlStr;
        paramDownloadParams.url = new URL(paramOutputStream[0]);
        paramDownloadParams.urlStr = paramOutputStream[0];
        if (QLog.isDevelopLevel()) {
          QLog.d("qqfav", 4, "favimage download: " + paramOutputStream[0] + " -> " + str1);
        }
        str3 = str1 + ".tmp";
        paramOutputStream = new File(str3);
        if (paramOutputStream.exists()) {
          paramOutputStream.delete();
        }
        paramURLDrawableHandler.publishProgress(0);
      }
      try
      {
        paramOutputStream = new FileOutputStream(str3);
      }
      catch (Exception paramOutputStream)
      {
        for (;;)
        {
          File localFile;
          paramOutputStream = null;
          if (paramOutputStream != null) {
            paramOutputStream.close();
          }
          new File(str3).delete();
        }
        paramOutputStream.delete();
        throw new IOException("File not Found. url: " + paramDownloadParams.url);
      }
      try
      {
        new HttpDownloader().a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        paramOutputStream.close();
        paramURLDrawableHandler = new File(str3);
        localFile = new File(str1);
        if (!paramURLDrawableHandler.renameTo(localFile))
        {
          FileUtils.a(paramURLDrawableHandler, localFile);
          paramURLDrawableHandler.delete();
        }
        QfavReport.a(this.a.waitAppRuntime(null), false, new File(str1).length());
        paramDownloadParams.url = ((URL)localObject);
        paramDownloadParams.urlStr = str2;
        paramOutputStream = new File(str1);
        if ((!paramOutputStream.exists()) || (paramOutputStream.length() <= 0L)) {
          continue;
        }
        return paramOutputStream;
      }
      catch (Exception paramURLDrawableHandler)
      {
        continue;
      }
      i = 0;
      break;
      i = 0;
      break label100;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      paramDownloadParams = super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
      return paramDownloadParams;
    }
    catch (Exception paramDownloadParams)
    {
      if ((paramFile != null) && (QLog.isColorLevel())) {
        QLog.e("FavoriteImageDownloader", 2, "decodeFile|Execption,cacheFile=" + paramFile.getAbsolutePath() + ",filelength=" + paramFile.length());
      }
      throw paramDownloadParams;
    }
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FavoriteImageDownloader
 * JD-Core Version:    0.7.0.1
 */