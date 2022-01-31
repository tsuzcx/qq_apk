package com.qzone.download.impl;

import android.text.TextUtils;
import com.qzone.download.DownloadResult;
import com.qzone.download.DownloadResult.Content;
import com.qzone.download.Downloader;
import com.qzone.download.DownloaderFactory;
import com.qzone.download.strategy.DownloadProcessStrategy;
import com.qzone.download.strategy.DownloadProcessStrategy.DownloadPool;
import com.qzone.download.strategy.KeepAliveStrategy;
import com.qzone.download.uinterface.IDownloadConfig;
import com.qzone.utils.StringUtil;
import com.qzone.utils.Utils;
import java.util.regex.Pattern;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public class ImageDownloaderInitializer
{
  private static final char CHAR_EQUALS = '=';
  private static final int IMAGE_URL_KP_ALLOWED = 1;
  public static final int IMAGE_URL_PT_QZONE_ALBUM = 0;
  private static final Pattern PATTERN_IMAGE_URL_KP = compileParameterInt("kp");
  private static final Pattern PATTERN_IMAGE_URL_PT = compileParameterInt("pt");
  private static final int PHOTO_DOWNLOAD_KEEP_ALIVE_DISABLE = 1;
  private static final int PHOTO_DOWNLOAD_KEEP_ALIVE_ENABLE = 0;
  private static final int PHOTO_DOWNLOAD_KEEP_ALIVE_IGNORE = 2;
  
  private static final Pattern compileParameterInt(String paramString)
  {
    return Pattern.compile("(#|&)" + paramString + '=' + "(\\d+)");
  }
  
  public static void initImageDownloader(Downloader paramDownloader)
  {
    if (paramDownloader == null) {
      return;
    }
    paramDownloader.setProcessStrategy(new DownloadProcessStrategy()
    {
      public DownloadProcessStrategy.DownloadPool getDownloadPool(String paramAnonymousString)
      {
        paramAnonymousString = Utils.getDomin(paramAnonymousString);
        if (ImageDownloaderInitializer.isMADomain(paramAnonymousString)) {
          return DownloadProcessStrategy.DownloadPool.SPECIFIC1;
        }
        KeepAliveStrategy localKeepAliveStrategy = DownloaderFactory.getKeepAliveStrategy();
        if ((localKeepAliveStrategy != null) && (localKeepAliveStrategy.supportKeepAlive(paramAnonymousString))) {
          return DownloadProcessStrategy.DownloadPool.SPECIFIC;
        }
        return DownloadProcessStrategy.DownloadPool.COMMON;
      }
      
      public boolean handleContentType(DownloadResult paramAnonymousDownloadResult, HttpResponse paramAnonymousHttpResponse)
      {
        paramAnonymousDownloadResult = paramAnonymousDownloadResult.getContent().type;
        if (TextUtils.isEmpty(paramAnonymousDownloadResult)) {}
        while (!StringUtil.startsWithIgnoreCase(paramAnonymousDownloadResult, "image")) {
          return false;
        }
        return true;
      }
      
      public void prepareRequest(String paramAnonymousString, HttpRequest paramAnonymousHttpRequest)
      {
        if ((paramAnonymousHttpRequest != null) && (paramAnonymousString != null) && (DownloaderFactory.getDownloadConfig() != null) && (ImageDownloaderInitializer.needCookie(paramAnonymousString))) {
          paramAnonymousHttpRequest.addHeader("Cookie", "uin=o" + DownloaderFactory.getDownloadConfig().getCurrentUin() + ";");
        }
      }
    });
  }
  
  private static boolean isMADomain(String paramString)
  {
    boolean bool1 = false;
    try
    {
      if ((!"m.qpic.cn".equalsIgnoreCase(paramString)) && (!"a1.qpic.cn".equalsIgnoreCase(paramString)) && (!"a2.qpic.cn".equalsIgnoreCase(paramString)) && (!"a3.qpic.cn".equalsIgnoreCase(paramString)))
      {
        boolean bool2 = "a4.qpic.cn".equalsIgnoreCase(paramString);
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static boolean needCookie(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = Utils.getDomin(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    } while ((!paramString.endsWith("photo.store.qq.com")) && (!paramString.endsWith("qpic.cn")));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.impl.ImageDownloaderInitializer
 * JD-Core Version:    0.7.0.1
 */