package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.text.TextUtils;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoadFaceItemManager
  implements LoadItemManager
{
  private final String dataPath;
  private final FaceItem item;
  private final Map<String, Bitmap> mCache;
  private AsyncTask<Void, Integer, Boolean> mFaceImageTask;
  private final Map<FaceOffUtil.FEATURE_TYPE, Bitmap> mGrayCache;
  private AsyncTask<Void, Integer, Boolean> mGrayImageTask;
  private AsyncTask<Void, Integer, Boolean> mGrayImageTask2;
  private AsyncTask<Void, Integer, Boolean> mGrayImageTask3;
  private AsyncTask<Void, Integer, Boolean> mGrayImageTask4;
  private AsyncTask<Void, Integer, Boolean> mImageTask;
  private final int sampleSize;
  
  public LoadFaceItemManager(Map<String, Bitmap> paramMap, Map<FaceOffUtil.FEATURE_TYPE, Bitmap> paramMap1, String paramString, FaceItem paramFaceItem, int paramInt)
  {
    this.dataPath = paramString;
    this.item = paramFaceItem;
    this.mCache = paramMap;
    this.mGrayCache = paramMap1;
    this.sampleSize = paramInt;
  }
  
  public void clear()
  {
    if (this.mImageTask != null) {
      this.mImageTask.cancel(true);
    }
    if (this.mGrayImageTask != null) {
      this.mGrayImageTask.cancel(true);
    }
    if (this.mGrayImageTask2 != null) {
      this.mGrayImageTask2.cancel(true);
    }
    if (this.mGrayImageTask3 != null) {
      this.mGrayImageTask3.cancel(true);
    }
    if (this.mGrayImageTask4 != null) {
      this.mGrayImageTask4.cancel(true);
    }
    if (this.mFaceImageTask != null) {
      this.mFaceImageTask.cancel(true);
    }
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(int paramInt)
  {
    return null;
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(int paramInt)
  {
    return null;
  }
  
  public int loadImage(int paramInt1, int paramInt2)
  {
    return -1;
  }
  
  public int loadImage(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    return -1;
  }
  
  public Bitmap loadImage(int paramInt)
  {
    String str = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + paramInt + ".png";
    return (Bitmap)this.mCache.get(str);
  }
  
  public Bitmap loadImage(String paramString)
  {
    paramString = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + paramString;
    return (Bitmap)this.mCache.get(paramString);
  }
  
  public void prepareImages()
  {
    this.mGrayImageTask = new LoadGrayImageTask(this.mGrayCache, this.item.featureType, this.sampleSize);
    if (this.mGrayImageTask.getStatus() != AsyncTask.Status.RUNNING) {
      this.mGrayImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    this.mGrayImageTask2 = new LoadGrayImageTask(this.mGrayCache, FaceOffUtil.FEATURE_TYPE.MASK, this.sampleSize);
    if (this.mGrayImageTask2.getStatus() != AsyncTask.Status.RUNNING) {
      this.mGrayImageTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    this.mGrayImageTask3 = new LoadGrayImageTask(this.mGrayCache, FaceOffUtil.FEATURE_TYPE.NOSE_MASK, this.sampleSize);
    if (this.mGrayImageTask3.getStatus() != AsyncTask.Status.RUNNING) {
      this.mGrayImageTask3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    this.mGrayImageTask4 = new LoadGrayImageTask(this.mGrayCache, FaceOffUtil.FEATURE_TYPE.LIPS_MASK, this.sampleSize);
    if (this.mGrayImageTask4.getStatus() != AsyncTask.Status.RUNNING) {
      this.mGrayImageTask4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.item.lipsStyleMask)) {
      localArrayList.add(this.item.lipsStyleMask);
    }
    if (TextUtils.isEmpty(this.item.id))
    {
      localArrayList.add(this.item.faceExchangeImage);
      if (this.item.blendMode == 14) {
        localArrayList.add(this.item.irisImage);
      }
      this.mFaceImageTask = new LoadImageTask(this.mCache, localArrayList, this.dataPath, VideoMaterialUtil.getMaterialId(this.dataPath), this.sampleSize);
      this.mFaceImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
    }
    int i = 0;
    while (i < this.item.frames)
    {
      localArrayList.add(this.item.id + "_" + i + ".png");
      i += 1;
    }
    this.mImageTask = new LoadImageTask(this.mCache, localArrayList, this.dataPath + File.separator + this.item.id, VideoMaterialUtil.getMaterialId(this.dataPath), this.sampleSize);
    this.mImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadFaceItemManager
 * JD-Core Version:    0.7.0.1
 */