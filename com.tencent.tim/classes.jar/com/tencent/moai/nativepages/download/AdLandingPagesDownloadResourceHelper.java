package com.tencent.moai.nativepages.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.moai.nativepages.NativePageManager;
import com.tencent.moai.nativepages.util.MD5Util;
import com.tencent.moai.nativepages.util.StringUtil;
import java.io.File;

public class AdLandingPagesDownloadResourceHelper
{
  private static final String TAG = "AdLandingPagesDownloadResourceHelper";
  
  public static void downloadImgForAdLandingPages(String paramString, Callback paramCallback)
  {
    if (StringUtil.isNullOrNil(paramString))
    {
      paramCallback.onDownloadError();
      return;
    }
    String str = getPathForImg(paramString);
    new AdLandingPageDownloadFileTask(str, new AdLandingPagesDownloadResourceHelper.1(paramCallback, str)).execute(new String[] { paramString });
  }
  
  public static void downloadSightForAdLandingPages(String paramString, Callback paramCallback)
  {
    if (StringUtil.isNullOrNil(paramString))
    {
      paramCallback.onDownloadError();
      return;
    }
    String str = getPathForVideo(paramString);
    new AdLandingPageDownloadFileTask(str, new AdLandingPagesDownloadResourceHelper.2(paramCallback, str)).execute(new String[] { paramString });
  }
  
  public static void downloadStreamVideoForAdLandingPages(String paramString, StreamVideoDownloadCallback paramStreamVideoDownloadCallback)
  {
    if (StringUtil.isNullOrNil(paramString))
    {
      paramStreamVideoDownloadCallback.onFail("");
      return;
    }
    new AdLandingPageDownloadVideoTask(getPathForVideo(paramString), new AdLandingPagesDownloadResourceHelper.3(paramStreamVideoDownloadCallback)).execute(new String[] { paramString });
  }
  
  public static Bitmap getCachedImg(String paramString)
  {
    if (StringUtil.isNullOrNil(paramString)) {}
    do
    {
      return null;
      paramString = getPathForImg(paramString);
    } while ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()));
    return BitmapFactory.decodeFile(paramString);
  }
  
  public static String getPathForImg(String paramString)
  {
    paramString = MD5Util.getMD5String(paramString);
    return NativePageManager.getInstance().getBaseCachePath() + "/" + paramString;
  }
  
  public static String getPathForVideo(String paramString)
  {
    paramString = MD5Util.getMD5String(paramString);
    return NativePageManager.getInstance().getBaseCachePath() + "/" + paramString;
  }
  
  public static abstract interface Callback
  {
    public abstract void onDownloadError();
    
    public abstract void onDownloaded(String paramString);
    
    public abstract void onStartDownload();
  }
  
  public static abstract interface StreamVideoDownloadCallback
  {
    public abstract void onFail(String paramString);
    
    public abstract void onFinish(String paramString);
    
    public abstract void onProgress(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper
 * JD-Core Version:    0.7.0.1
 */