package com.tencent.qqmail.download;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.moai.downloader.interceptor.RequestInterceptor;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.qmimagecache.DiskLruCache;
import com.tencent.qqmail.qmimagecache.DiskLruCache.Editor;
import com.tencent.qqmail.qmimagecache.ImageCache;
import com.tencent.qqmail.qmimagecache.ImageCache.ImageCacheParams;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

public class ImageDownloadManager
{
  private static final String TAG = "ImageDownloadManager";
  private static ImageDownloadManager instance;
  private final ConcurrentHashMap<Long, DownloadInfo> downloadInfoMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<Long, ArrayList<ImageDownloadListener>> imageListenerMap = new ConcurrentHashMap();
  private ImageCache mImageCache;
  
  private ImageDownloadManager()
  {
    int i = ((ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity")).getMemoryClass();
    ImageCache.ImageCacheParams localImageCacheParams = new ImageCache.ImageCacheParams();
    localImageCacheParams.memCacheSize = (i * 1024 / 4);
    this.mImageCache = new ImageCache(localImageCacheParams);
    this.mImageCache.initDiskCache();
  }
  
  private boolean checkLocalBitmap(DownloadInfo paramDownloadInfo)
  {
    String str1 = paramDownloadInfo.getUrl();
    String str2 = StringExtention.hashKeyForDisk(str1);
    try
    {
      File localFile1 = new File(new URI(str1));
      File localFile2 = localFile1;
      if (localFile1 == null) {
        localFile2 = localFile1;
      }
      try
      {
        if (str1.startsWith("file:///")) {
          localFile2 = new File(str1.substring("file://".length()));
        }
        if (localFile2 != null) {
          if (localFile2.exists())
          {
            Threads.runInBackground(new ImageDownloadManager.9(this, localFile2, str2, paramDownloadInfo, str1));
          }
          else
          {
            QMLog.log(6, "ImageDownloadManager", "getLocalBitmap null");
            Threads.runOnMainThread(new ImageDownloadManager.10(this, paramDownloadInfo, str1));
          }
        }
      }
      catch (IllegalArgumentException paramDownloadInfo) {}
      return false;
      return true;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        Object localObject1 = null;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private void compress(String paramString, int paramInt, ImageDownloadListener paramImageDownloadListener)
  {
    ImageCompresser localImageCompresser = ImageCompresser.getInstance();
    File localFile = getThumbBitmapFromDiskCache(paramString);
    if ((localFile != null) && (localFile.exists()))
    {
      localImageCompresser.compressImage(paramString, localFile.getAbsolutePath(), "", paramInt, new ImageDownloadManager.7(this, localImageCompresser, paramString, paramInt, paramImageDownloadListener, localFile));
      return;
    }
    Threads.runOnMainThread(new ImageDownloadManager.8(this, paramImageDownloadListener, paramString));
  }
  
  private void downloadImage(DownloadInfo paramDownloadInfo)
  {
    Object localObject = paramDownloadInfo.getUrl();
    try
    {
      paramDownloadInfo.setFileName(this.mImageCache.getDiskLruCache().edit(StringExtention.hashKeyForDisk((String)localObject)).getFile(0, true).getName());
      localObject = new ArrayList();
      ((ArrayList)localObject).add("viewfile");
      DownloadUtil.paddingDownloadInfo(paramDownloadInfo, (ArrayList)localObject);
      if (isDownloadingUrl(paramDownloadInfo)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      DownloadTask localDownloadTask = initImageDownloadTask(paramDownloadInfo);
      paramDownloadInfo.setDownloadTask(localDownloadTask);
      localDownloadTask.start();
    }
  }
  
  private DownloadTaskListener getDownloadTaskListener(DownloadInfo paramDownloadInfo)
  {
    return new ImageDownloadManager.2(this, paramDownloadInfo);
  }
  
  private RequestInterceptor getRequestInterceptor(DownloadInfo paramDownloadInfo)
  {
    return new ImageDownloadManager.3(this, paramDownloadInfo);
  }
  
  private DownloadTask initImageDownloadTask(DownloadInfo paramDownloadInfo)
  {
    paramDownloadInfo.setDownloadType(2);
    DownloadTask localDownloadTask = new DownloadTask();
    localDownloadTask.setUrl(DownloadUtil.getRequestUrl(paramDownloadInfo));
    localDownloadTask.setFileName(paramDownloadInfo.getFileName());
    localDownloadTask.setFilePath(FileUtil.getThumbImageCacheDir() + localDownloadTask.getFileName());
    localDownloadTask.setSingleTaskDownload(true);
    localDownloadTask.setId(DownloadUtil.getDownloadTaskId(paramDownloadInfo.getKey()));
    localDownloadTask.setListener(getDownloadTaskListener(paramDownloadInfo));
    localDownloadTask.setRequestInterceptor(getRequestInterceptor(paramDownloadInfo));
    return localDownloadTask;
  }
  
  private boolean isDownloadingUrl(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (!StringExtention.isNullOrEmpty(paramDownloadInfo.getKey())))
    {
      long l = DownloadUtil.getDownloadTaskId(paramDownloadInfo.getKey());
      synchronized (this.imageListenerMap)
      {
        ArrayList localArrayList2 = (ArrayList)this.imageListenerMap.get(Long.valueOf(l));
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null)
        {
          localArrayList1 = new ArrayList();
          this.imageListenerMap.put(Long.valueOf(l), localArrayList1);
        }
        if (paramDownloadInfo.getImageDownloadListener() != null) {
          localArrayList1.add(paramDownloadInfo.getImageDownloadListener());
        }
        if (this.downloadInfoMap.containsKey(Long.valueOf(l))) {
          return true;
        }
      }
      paramDownloadInfo.setStatus(0);
      this.downloadInfoMap.put(Long.valueOf(l), paramDownloadInfo);
    }
    return false;
  }
  
  private static boolean isImageLruCacheUnInit()
  {
    return (instance.mImageCache.getDiskLruCache() == null) || (instance.mImageCache.getDiskLruCache().isClosed());
  }
  
  private static void reInitImageCache()
  {
    int i = ((ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity")).getMemoryClass();
    ImageCache.ImageCacheParams localImageCacheParams = new ImageCache.ImageCacheParams();
    localImageCacheParams.memCacheSize = (i * 1024 / 4);
    instance.mImageCache = new ImageCache(localImageCacheParams);
    instance.mImageCache.initDiskCache();
  }
  
  public static ImageDownloadManager shareInstance()
  {
    if (instance != null) {
      if (!isImageLruCacheUnInit())
      {
        File localFile = instance.mImageCache.getDiskCacheDir();
        if ((localFile != null) && (!localFile.exists())) {
          QMLog.log(5, "ImageDownloadManager", "System cache exception, close image cache and reload");
        }
      }
    }
    for (;;)
    {
      try
      {
        instance.mImageCache.getDiskLruCache().close();
        reInitImageCache();
        ImageCompresser.getInstance().clearCache();
        return instance;
      }
      catch (IOException localIOException)
      {
        instance.mImageCache.getDiskLruCache().Empty();
        continue;
      }
      reInitImageCache();
      continue;
      instance = new ImageDownloadManager();
    }
  }
  
  public void abort(String paramString)
  {
    paramString = (DownloadInfo)this.downloadInfoMap.get(Long.valueOf(DownloadUtil.getDownloadTaskId(paramString)));
    if (paramString != null)
    {
      paramString = paramString.getDownloadTask();
      if (paramString != null) {
        paramString.abort();
      }
    }
  }
  
  public void addImageDiskCache(String paramString, Bitmap paramBitmap)
  {
    if (this.mImageCache != null) {
      this.mImageCache.addBitmapToDiskCache(paramString, paramBitmap);
    }
  }
  
  public void addMemoryCache(String paramString, Bitmap paramBitmap)
  {
    if (this.mImageCache != null) {
      this.mImageCache.addBitmapToCache(paramString, paramBitmap);
    }
  }
  
  public void clearCache()
  {
    if (this.mImageCache != null) {
      this.mImageCache.clearCache();
    }
  }
  
  public void fetchCompressImage(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if (!DownloadUtil.validateDownloadInfo(paramDownloadInfo)) {
      return;
    }
    Object localObject = paramDownloadInfo.getUrl();
    String str1 = StringExtention.hashKeyForDisk((String)localObject);
    ImageCompresser localImageCompresser = ImageCompresser.getInstance();
    Bitmap localBitmap = localImageCompresser.getBitmapFromMemCache((String)localObject, paramInt);
    String str2 = localImageCompresser.getCompressPath((String)localObject, paramInt);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      Threads.runOnMainThread(new ImageDownloadManager.4(this, paramDownloadInfo, (String)localObject, localBitmap, str1));
      return;
    }
    if ((!StringUtils.isBlank(str2)) || (this.mImageCache.isExistInDiskWithKey(str1)))
    {
      Threads.runInBackground(new ImageDownloadManager.5(this, str2, localImageCompresser, (String)localObject, paramInt, paramDownloadInfo, str1));
      return;
    }
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).setUrl(paramDownloadInfo.getUrl());
    ((DownloadInfo)localObject).setKey(paramDownloadInfo.getKey());
    ((DownloadInfo)localObject).setSessionType(paramDownloadInfo.getSessionType());
    ((DownloadInfo)localObject).setAccountId(paramDownloadInfo.getAccountId());
    ((DownloadInfo)localObject).setCookies(paramDownloadInfo.getCookies());
    ((DownloadInfo)localObject).setImageDownloadListener(new ImageDownloadManager.6(this, paramInt, paramDownloadInfo));
    downloadImage((DownloadInfo)localObject);
  }
  
  public int fetchImage(DownloadInfo paramDownloadInfo)
  {
    if (!DownloadUtil.validateDownloadInfo(paramDownloadInfo)) {}
    do
    {
      return 0;
      String str1 = paramDownloadInfo.getUrl();
      String str2 = StringExtention.hashKeyForDisk(str1);
      if (this.mImageCache.isExistInDiskWithKey(str2))
      {
        Threads.runInBackground(new ImageDownloadManager.1(this, str2, str1, paramDownloadInfo));
        return 2;
      }
    } while (checkLocalBitmap(paramDownloadInfo));
    downloadImage(paramDownloadInfo);
    return 0;
  }
  
  public Bitmap getAvatarBitmapFromDisk(String paramString)
  {
    Object localObject = this.mImageCache.getBitmapFromMemCache(paramString);
    if (localObject != null) {}
    Bitmap localBitmap;
    do
    {
      do
      {
        return localObject;
        localObject = new File(paramString);
        if (!((File)localObject).exists()) {
          break;
        }
        localBitmap = ImageUtil.memSafeScaleImage(((File)localObject).getAbsolutePath(), 1, 1.0F);
        localObject = localBitmap;
      } while (localBitmap == null);
      localObject = localBitmap;
    } while (localBitmap.isRecycled());
    this.mImageCache.addBitmapToCache(paramString, localBitmap);
    return localBitmap;
    return null;
  }
  
  public Bitmap getBitmapFromMemCache(String paramString)
  {
    return this.mImageCache.getBitmapFromMemCache(paramString);
  }
  
  public String getFilePathFromImageCache(String paramString)
  {
    return this.mImageCache.getDiskCacheFilePath(paramString);
  }
  
  public void getImageBitmap(String paramString, ImageDownloadListener paramImageDownloadListener)
  {
    Threads.runInBackground(new ImageDownloadManager.11(this, paramString, paramImageDownloadListener));
  }
  
  public void getProtocolImageBitmap(String paramString, ImageDownloadListener paramImageDownloadListener)
  {
    Threads.runInBackground(new ImageDownloadManager.12(this, paramString, paramImageDownloadListener));
  }
  
  public File getThumbBitmapFromDiskCache(String paramString)
  {
    Object localObject = null;
    synchronized (this.mImageCache)
    {
      String str = StringExtention.hashKeyForDisk(paramString);
      DiskLruCache localDiskLruCache = this.mImageCache.getDiskLruCache();
      paramString = localObject;
      if (localDiskLruCache != null) {
        paramString = localDiskLruCache.getReadableFile(str);
      }
      return paramString;
    }
  }
  
  public Bitmap getThumbBitmapFromLocal(String paramString)
  {
    return getThumbBitmapFromLocalByKey(StringExtention.hashKeyForDisk(paramString));
  }
  
  public Bitmap getThumbBitmapFromLocalByKey(String paramString)
  {
    Bitmap localBitmap = this.mImageCache.getBitmapFromMemCache(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {}
    while (!this.mImageCache.isExistInDiskWithKey(paramString)) {
      return localBitmap;
    }
    localBitmap = this.mImageCache.getBitmapFromDiskCache(paramString);
    this.mImageCache.addBitmapToCache(paramString, localBitmap);
    return localBitmap;
  }
  
  public int isThumbBitmapExistLocal(String paramString)
  {
    return isThumbBitmapExistLocalWithKey(StringExtention.hashKeyForDisk(paramString));
  }
  
  public int isThumbBitmapExistLocalWithKey(String paramString)
  {
    if (this.mImageCache.getBitmapFromMemCache(paramString) != null) {
      return 1;
    }
    if (this.mImageCache.isExistInDiskWithKey(paramString)) {
      return 2;
    }
    return 0;
  }
  
  public void removeMemoryCache(String paramString)
  {
    if (this.mImageCache != null) {
      this.mImageCache.removeMemoryCache(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager
 * JD-Core Version:    0.7.0.1
 */