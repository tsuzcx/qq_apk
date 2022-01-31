package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class LocalBilldDownloader
  extends AbsDownloader
{
  public static final String a = "billdthumb";
  public static final String b = "billdimg";
  private static final String c = "LocalBilldDownloader";
  Application a;
  
  public LocalBilldDownloader(Application paramApplication)
  {
    this.a = paramApplication;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = new File(AppConstants.aN);
    if (!paramURLDrawableHandler.exists()) {
      paramURLDrawableHandler.mkdirs();
    }
    Object localObject = paramDownloadParams.url.getPath();
    paramOutputStream = new File(paramURLDrawableHandler + "/" + (String)localObject);
    if ((!paramOutputStream.exists()) || (paramOutputStream.length() == 0L))
    {
      paramURLDrawableHandler = new File(paramURLDrawableHandler + "/" + (String)localObject + ".tmp");
      if (paramURLDrawableHandler.exists()) {
        paramURLDrawableHandler.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.i("LocalBilldDownloader", 2, "downloadImage isGIF !targetFile.exists(),url=" + paramDownloadParams.urlStr + ",drawableName=" + (String)localObject + ",targetFile=" + paramOutputStream.getAbsolutePath());
      }
      int i = this.a.getResources().getIdentifier((String)localObject, "raw", this.a.getPackageName());
      paramDownloadParams = this.a.getResources().openRawResource(i);
      localObject = new byte[4096];
      FileOutputStream localFileOutputStream = new FileOutputStream(paramURLDrawableHandler);
      while (paramDownloadParams.read((byte[])localObject) != -1)
      {
        localFileOutputStream.write((byte[])localObject);
        localFileOutputStream.flush();
      }
      localFileOutputStream.close();
      paramDownloadParams.close();
      paramURLDrawableHandler.renameTo(paramOutputStream);
    }
    return paramOutputStream;
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LocalBilldDownloader
 * JD-Core Version:    0.7.0.1
 */