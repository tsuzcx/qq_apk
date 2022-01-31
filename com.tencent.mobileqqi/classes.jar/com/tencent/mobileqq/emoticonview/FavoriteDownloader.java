package com.tencent.mobileqq.emoticonview;

import android.app.Application;
import com.tencent.mobileqq.activity.photo.LocalPhotoInfo;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FavoriteDownloader
  extends AlbumThumbDownloader
{
  public static final String a = "favorite";
  public static final String b = "FavoriteDownloader";
  
  public FavoriteDownloader(Application paramApplication)
  {
    super(paramApplication);
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      LocalPhotoInfo localLocalPhotoInfo = new LocalPhotoInfo();
      localLocalPhotoInfo.a = paramString;
      paramString = new File(paramString);
      if (paramString.exists()) {
        localLocalPhotoInfo.b = paramString.lastModified();
      }
      localLocalPhotoInfo.f = paramInt1;
      localLocalPhotoInfo.g = paramInt2;
      paramString = new URL("favorite", null, LocalPhotoInfo.a(localLocalPhotoInfo));
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteDownloader", 2, "<--generateURL output: urlString =" + paramString.toString());
      }
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteDownloader
 * JD-Core Version:    0.7.0.1
 */