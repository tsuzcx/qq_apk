package com.tencent.qqmail.qmimagecache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.watcher.CompressImageWatcher;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class ImageCompresser
{
  public static final int COMPRESS_MIN_SIZE = 100;
  public static final int COMPRESS_SIZE_TYPE_MIN = 3;
  public static final int COMPRESS_SIZE_TYPE_ORIGIN = 1;
  public static final int COMPRESS_SIZE_TYPE_SCREEN = 2;
  public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
  public static final int DEFAULT_COMPRESS_QUALITY = 70;
  private static long maxCompressingSize = 10485760L;
  private static ImageCompresser singleInstance;
  private long alreadyCompressingSize = 0L;
  private CompressCache compressCache = new CompressCache();
  private ArrayList<CompressRequest> requestList = new ArrayList();
  
  private void compress(CompressRequest paramCompressRequest)
  {
    if (!StringUtils.isBlank(paramCompressRequest.sourcePath)) {
      Threads.runInBackground(new ImageCompresser.1(this, paramCompressRequest));
    }
  }
  
  private Bitmap getBitmapWithMinSize(CompressRequest paramCompressRequest)
  {
    int i = 100;
    Object localObject1;
    int j;
    if (paramCompressRequest.sampleSizeType == 2)
    {
      localObject1 = new DisplayMetrics();
      ((WindowManager)QMApplicationContext.sharedInstance().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      j = ((DisplayMetrics)localObject1).widthPixels;
      i = ((DisplayMetrics)localObject1).heightPixels;
    }
    label242:
    for (;;)
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
      ((BitmapFactory.Options)localObject1).inDither = false;
      BitmapFactory.decodeFile(paramCompressRequest.sourcePath, (BitmapFactory.Options)localObject1);
      int k = ((BitmapFactory.Options)localObject1).outHeight;
      int m = ((BitmapFactory.Options)localObject1).outWidth;
      if (k / i > m / j) {}
      for (i = k / i;; i = m / j) {
        for (;;)
        {
          if (i > 1) {
            ((BitmapFactory.Options)localObject1).inSampleSize = i;
          }
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
          try
          {
            paramCompressRequest = new FileInputStream(new File(paramCompressRequest.sourcePath));
          }
          catch (FileNotFoundException paramCompressRequest)
          {
            return null;
          }
          try
          {
            localObject1 = BitmapFactory.decodeStream(paramCompressRequest, null, (BitmapFactory.Options)localObject1);
            try
            {
              paramCompressRequest.close();
              return localObject1;
            }
            catch (IOException paramCompressRequest)
            {
              paramCompressRequest.printStackTrace();
              return localObject1;
            }
            if (paramCompressRequest.sampleSizeType != 3) {
              break label242;
            }
            j = 100;
            break;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            System.gc();
            try
            {
              paramCompressRequest.close();
              return null;
            }
            catch (IOException paramCompressRequest)
            {
              paramCompressRequest.printStackTrace();
              return null;
            }
          }
          finally
          {
            try
            {
              paramCompressRequest.close();
              throw localObject2;
            }
            catch (IOException paramCompressRequest)
            {
              for (;;)
              {
                paramCompressRequest.printStackTrace();
              }
            }
            i = 0;
            j = 0;
          }
        }
      }
    }
  }
  
  private String getCompressKey(String paramString, int paramInt)
  {
    return StringExtention.hashKeyForDisk(paramString + "_compressSizeType_" + paramInt);
  }
  
  public static ImageCompresser getInstance()
  {
    try
    {
      initialize();
      ImageCompresser localImageCompresser = singleInstance;
      return localImageCompresser;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void initialize()
  {
    try
    {
      if (singleInstance == null) {
        singleInstance = new ImageCompresser();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void addBitmapToMemCache(String paramString, Bitmap paramBitmap, int paramInt)
  {
    paramString = getCompressKey(paramString, paramInt);
    this.compressCache.addBitmapToMemCache(paramString, paramBitmap);
  }
  
  public void clearCache()
  {
    this.compressCache.clearCache();
  }
  
  public void clearMemoryCache()
  {
    this.compressCache.clearMemoryCache();
  }
  
  public void compressImage(String paramString1, String arg2, String paramString3, int paramInt, CompressImageWatcher paramCompressImageWatcher)
  {
    paramString1 = new CompressRequest(paramString1, ???, paramString3, paramInt);
    paramString1.callback = paramCompressImageWatcher;
    synchronized (this.requestList)
    {
      this.requestList.add(paramString1);
      startCompress();
      return;
    }
  }
  
  public Bitmap getBitmapFromMemCache(String paramString, int paramInt)
  {
    paramString = getCompressKey(paramString, paramInt);
    return this.compressCache.getBitmapFromMemCache(paramString);
  }
  
  public String getCompressPath(String paramString, int paramInt)
  {
    paramString = getCompressKey(paramString, paramInt);
    return this.compressCache.getCompressImagePath(paramString);
  }
  
  public void release()
  {
    if (this.requestList != null)
    {
      this.requestList.clear();
      this.requestList = null;
    }
  }
  
  public void startCompress()
  {
    CompressRequest localCompressRequest;
    if (this.requestList.size() > 0)
    {
      localCompressRequest = null;
      synchronized (this.requestList)
      {
        if (this.requestList.size() > 0) {
          localCompressRequest = (CompressRequest)this.requestList.get(0);
        }
        if (localCompressRequest != null)
        {
          if (this.alreadyCompressingSize + localCompressRequest.size >= maxCompressingSize) {
            break label110;
          }
          this.alreadyCompressingSize += localCompressRequest.size;
        }
      }
    }
    label110:
    while (localObject2.callback == null) {
      synchronized (this.requestList)
      {
        this.requestList.remove(localCompressRequest);
        compress(localCompressRequest);
        return;
        localObject1 = finally;
        throw localObject1;
      }
    }
    localObject2.callback.onWait(localObject2.src);
  }
  
  public class CompressRequest
  {
    public CompressImageWatcher callback;
    public String destPath;
    public int sampleSizeType = 1;
    public long size;
    public String sourcePath;
    public String src;
    
    public CompressRequest(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      this.src = paramString1;
      this.sourcePath = paramString2;
      this.destPath = paramString3;
      this.sampleSizeType = paramInt;
      if (!StringUtils.isBlank(paramString2)) {
        this.size = FileUtil.getFileSize(paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.ImageCompresser
 * JD-Core Version:    0.7.0.1
 */