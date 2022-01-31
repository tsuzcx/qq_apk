package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class ChatBackgroundSettingActivity$ChatBgPicDownloader
  extends AbstractImageDownloader
{
  public static final String a = "chatbg_pro";
  public static final String b = "chatbg_id";
  
  public ChatBackgroundSettingActivity$ChatBgPicDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(ChatBackgroundSettingActivity.a, paramBaseApplicationImpl);
  }
  
  public ChatBackgroundSettingActivity$ChatBgPicDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = paramDownloadParams.url;
    paramDownloadParams = paramDownloadParams.getHeader("chatbg_id").getValue();
    if ((paramDownloadParams != null) && (!"".equals(paramDownloadParams)))
    {
      paramDownloadParams = new File(AppConstants.ba + paramDownloadParams + ".png");
      if (!paramDownloadParams.getParentFile().exists()) {
        new File(AppConstants.ba).mkdir();
      }
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
      DownloaderFactory.a(new DownloadTask(paramOutputStream.getPath(), paramDownloadParams), (AppInterface)this.a.a());
      return paramDownloadParams;
    }
    return null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatBackgroundSettingActivity.ChatBgPicDownloader
 * JD-Core Version:    0.7.0.1
 */