package com.tencent.mobileqq.transfile;

import android.app.Application;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.RegionalThumbDecoder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class RegionalThumbDownloader
  extends ProtocolDownloader.Adapter
{
  public RegionalThumbDownloader(Application paramApplication) {}
  
  public static URL a(String paramString, int paramInt1, int paramInt2)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.a = paramString;
    paramString = new File(paramString);
    if (paramString.exists()) {
      localLocalMediaInfo.d = paramString.lastModified();
    }
    localLocalMediaInfo.f = paramInt1;
    localLocalMediaInfo.g = paramInt2;
    try
    {
      paramString = new URL("regionalthumb", null, LocalMediaInfo.a(localLocalMediaInfo));
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new RegionalThumbDecoder().a(paramDownloadParams.url);
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    boolean bool2 = false;
    paramDownloadParams = LocalMediaInfo.a(paramDownloadParams.url);
    boolean bool1 = bool2;
    if (paramDownloadParams != null)
    {
      bool1 = bool2;
      if (new File(paramDownloadParams.a).exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = LocalMediaInfo.a(paramDownloadParams.url);
    if (paramDownloadParams != null)
    {
      paramDownloadParams = new File(paramDownloadParams.a);
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RegionalThumbDownloader
 * JD-Core Version:    0.7.0.1
 */