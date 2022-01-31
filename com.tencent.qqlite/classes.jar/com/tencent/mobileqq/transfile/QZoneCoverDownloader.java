package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.ImageFilePathUtil;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class QZoneCoverDownloader
  extends AbsDownloader
{
  protected static final String a = "qzone_cover";
  public static final String b = "qzone_cover";
  public static final String c = "original";
  public static final String d = "thumb";
  public static final String e = "other";
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qzone_cover", 2, "downloadImage|config.urlStr = " + paramDownloadParams.urlStr);
    }
    paramOutputStream = paramDownloadParams.url.getFile();
    paramDownloadParams = paramDownloadParams.url.getHost();
    if (QLog.isColorLevel()) {
      QLog.i("qzone_cover", 2, "downloadImage|host = " + paramDownloadParams + ", url = " + paramOutputStream);
    }
    paramOutputStream = a(paramOutputStream);
    if (TextUtils.isEmpty(paramOutputStream)) {
      throw new RuntimeException("downloadImage|url is null");
    }
    paramOutputStream = ImageFilePathUtil.a(BaseApplication.getContext(), paramOutputStream);
    if (QLog.isColorLevel())
    {
      QLog.i("qzone_cover", 2, "downloadImage|path = " + paramOutputStream);
      if (!FileUtils.b(paramOutputStream)) {
        break label210;
      }
      QLog.i("qzone_cover", 2, "downloadImage|file exist and not empty");
    }
    for (;;)
    {
      paramDownloadParams = new File(paramOutputStream);
      if (paramDownloadParams.exists()) {
        break;
      }
      throw new RuntimeException("downloadImage|file not exist, path = " + paramOutputStream);
      label210:
      QLog.i("qzone_cover", 2, "downloadImage|file not exist or empty!!");
    }
    return paramDownloadParams;
  }
  
  protected String a(String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.indexOf("http", 0);
      if ((i <= 0) || (i >= paramString.length())) {}
    }
    for (String str = paramString.substring(i);; str = paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("qzone_cover", 2, "dealUrl|in: " + paramString + ", out: " + str);
      }
      return str;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qzone_cover", 2, "decodeFile() url = " + paramDownloadParams.url + ", path = " + paramFile.getAbsolutePath());
    }
    try
    {
      paramFile = super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      QLog.i("qzone_cover", 2, "decodeFile() exception: " + paramFile.toString());
      paramFile.printStackTrace();
      throw paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QZoneCoverDownloader
 * JD-Core Version:    0.7.0.1
 */