package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AccountNotMatchException;
import org.apache.http.Header;

public class AvatarPendantDownloader
  extends AbsDownloader
{
  private static final int jdField_a_of_type_Int = 3;
  public static final String a = "AvatarPendantDownloader";
  public static final String b = "protocol_pendant_image";
  public static final String c = "url_host_pendant_image_aio_static";
  public static final String d = "url_host_pendant_image_aio_dynamic";
  public static final String e = "url_host_pendant_image_market_static";
  public static final String f = "url_host_pendant_image_market_dynamic";
  public static final String g = "pendant_thumbnail";
  public static final String h = "url_host_pendant_image_crop_portrait";
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  
  public AvatarPendantDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int i = 1;
    if ((paramDownloadParams == null) || (paramDownloadParams.url == null)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantDownloader", 2, "downloadImage, local file: " + paramDownloadParams.url.getFile() + ", pendantId: " + paramDownloadParams.tag);
    }
    long l = ((Long)paramDownloadParams.tag).longValue();
    paramOutputStream = paramDownloadParams.url.getHost();
    if ("url_host_pendant_image_aio_static".equals(paramOutputStream))
    {
      paramOutputStream = paramDownloadParams.getHeader("my_uin");
      if (paramOutputStream == null) {
        break label255;
      }
    }
    label255:
    for (paramOutputStream = paramOutputStream.getValue();; paramOutputStream = null)
    {
      if (paramOutputStream == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AvatarPendantDownloader", 2, "downloadImage, uin is null");
        }
        return null;
        if ("url_host_pendant_image_aio_dynamic".equals(paramOutputStream))
        {
          i = 2;
          break;
        }
        if ("url_host_pendant_image_market_static".equals(paramOutputStream))
        {
          i = 3;
          break;
        }
        if ("url_host_pendant_image_market_dynamic".equals(paramOutputStream))
        {
          i = 4;
          break;
        }
        if ("pendant_thumbnail".equals(paramOutputStream))
        {
          i = 5;
          break;
        }
        if (!"url_host_pendant_image_crop_portrait".equals(paramOutputStream)) {
          break;
        }
        i = 7;
        break;
      }
      try
      {
        paramOutputStream = (QQAppInterface)this.a.getAppRuntime(paramOutputStream);
        if (paramOutputStream == null) {
          return null;
        }
      }
      catch (AccountNotMatchException paramOutputStream)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AvatarPendantDownloader", 2, "downloadImage, app is null");
          }
          paramOutputStream = null;
        }
      }
      return AvatarPendantUtil.a(paramOutputStream, l, i);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramFile == null) {
      return null;
    }
    paramDownloadParams.url.getHost();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AvatarPendantDownloader
 * JD-Core Version:    0.7.0.1
 */