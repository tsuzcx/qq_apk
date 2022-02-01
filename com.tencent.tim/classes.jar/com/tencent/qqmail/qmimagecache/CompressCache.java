package com.tencent.qqmail.qmimagecache;

import android.graphics.Bitmap;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.util.HashMap;

public class CompressCache
{
  private static final int DEFAULT_DISK_CACHE_SIZE = 314572800;
  public static final int DISK_CACHE_INDEX = 0;
  private static final String TAG = "CompressCache";
  private HashMap<String, Boolean> compressingHashMap = new HashMap();
  private ImageCache mImageCache = null;
  
  public CompressCache()
  {
    ImageCache.ImageCacheParams localImageCacheParams = generateImageCacheParams();
    if (localImageCacheParams == null)
    {
      this.mImageCache = null;
      return;
    }
    this.mImageCache = new ImageCache(localImageCacheParams);
  }
  
  private ImageCache.ImageCacheParams generateImageCacheParams()
  {
    Object localObject = FileUtil.getCompressCacheDir();
    if (localObject == null) {
      return null;
    }
    localObject = new ImageCache.ImageCacheParams(new File((String)localObject));
    ((ImageCache.ImageCacheParams)localObject).memoryCacheEnabled = true;
    ((ImageCache.ImageCacheParams)localObject).diskCacheEnabled = true;
    ((ImageCache.ImageCacheParams)localObject).initDiskCacheOnCreate = true;
    ((ImageCache.ImageCacheParams)localObject).diskCacheSize = 314572800;
    ((ImageCache.ImageCacheParams)localObject).compressFormat = ImageCompresser.DEFAULT_COMPRESS_FORMAT;
    ((ImageCache.ImageCacheParams)localObject).compressQuality = 70;
    return localObject;
  }
  
  public void addBitmapToMemCache(String paramString, Bitmap paramBitmap)
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
  
  public void clearMemoryCache()
  {
    if (this.mImageCache != null) {
      this.mImageCache.clearMemoryCache();
    }
  }
  
  public void compressImage(String paramString, Bitmap paramBitmap)
  {
    if ((this.mImageCache != null) && ((this.compressingHashMap.get(paramString) == null) || (!((Boolean)this.compressingHashMap.get(paramString)).booleanValue())))
    {
      this.compressingHashMap.put(paramString, Boolean.valueOf(true));
      this.mImageCache.addBitmapToDiskCache(StringExtention.hashKeyForDisk(paramString), paramBitmap);
      this.compressingHashMap.put(paramString, Boolean.valueOf(false));
    }
  }
  
  public Bitmap getBitmapFromMemCache(String paramString)
  {
    if (this.mImageCache != null) {
      return this.mImageCache.getBitmapFromMemCache(paramString);
    }
    return null;
  }
  
  public String getCompressImagePath(String paramString)
  {
    if (this.mImageCache != null) {
      return this.mImageCache.getDiskCacheFilePath(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.CompressCache
 * JD-Core Version:    0.7.0.1
 */