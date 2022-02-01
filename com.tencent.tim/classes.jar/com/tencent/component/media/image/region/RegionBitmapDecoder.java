package com.tencent.component.media.image.region;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class RegionBitmapDecoder
{
  private static final int MSG_UPDATE_DECODE_REGION = 1;
  private static final String TAG = "RegionBitmapDecoder";
  private WeakReference<OnUpdateCallback> mCallback;
  private long mCurrentTime;
  private HashMap<Rect, DrawData> mDataList = new HashMap();
  private Object mDataLock = new Object();
  private Matrix mExifMatrix;
  private RegionBitmapBlockHelper mHelper;
  private String mImagePath;
  private int mOrgImageWidth;
  private int mOrgimageHeight;
  private BitmapRegionDecoder mRegionDecoder;
  private int mRotation = -1;
  private Rect mTmp = new Rect();
  private WorkHandler mWorkHandler;
  
  public RegionBitmapDecoder(String paramString)
  {
    if (this.mWorkHandler == null) {
      this.mWorkHandler = new WorkHandler(ImageManagerEnv.g().getFileThreadLooper());
    }
    this.mImagePath = paramString;
  }
  
  private void caclShowArea(RegionDrawableData paramRegionDrawableData)
  {
    int k = 0;
    Rect localRect = new Rect(paramRegionDrawableData.mShowArea);
    int i = localRect.width();
    int j = localRect.height();
    int m = ImageManagerEnv.g().getScreenWidth();
    int i1 = ImageManagerEnv.g().getScreenHeight();
    if ((j <= i1) && (i >= m))
    {
      k = Math.abs(localRect.left);
      f = this.mOrgImageWidth;
      j = (int)(k / i * f + 0.5F);
      f = this.mOrgImageWidth;
      k = (int)((k + m) / i * f + 0.5F);
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = k;
      if (k > this.mOrgImageWidth) {
        j = this.mOrgImageWidth;
      }
      paramRegionDrawableData.mShowArea.set(i, 0, j, this.mOrgimageHeight);
      return;
    }
    int n = Math.abs(localRect.left);
    int i2 = Math.abs(localRect.top);
    j = (int)(this.mOrgImageWidth * (n / i) + 0.5F);
    n = (int)(this.mOrgImageWidth * ((m + n) / i) + 0.5F);
    m = (int)(this.mOrgImageWidth * (i2 / i) + 0.5F);
    float f = this.mOrgImageWidth;
    i1 = (int)((i1 + i2) / i * f + 0.5F);
    i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if (n > this.mOrgImageWidth) {
      j = this.mOrgImageWidth;
    }
    if (m < 0) {}
    for (;;)
    {
      if (i1 > this.mOrgimageHeight) {}
      for (m = this.mOrgimageHeight;; m = i1)
      {
        paramRegionDrawableData.mShowArea.set(i, k, j, m);
        return;
      }
      k = m;
    }
  }
  
  private void decode(DrawData paramDrawData, int paramInt)
  {
    if ((this.mRegionDecoder == null) || (this.mRegionDecoder.isRecycled()))
    {
      ImageManagerLog.i("RegionBitmapDecoder", "decode with RegionDecode null or recycle ");
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    this.mTmp.set(paramDrawData.mOrgRect);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramInt;
    long l2;
    try
    {
      paramDrawData.mBitmap = this.mRegionDecoder.decodeRegion(this.mTmp, localOptions);
      Bitmap localBitmap1 = paramDrawData.mBitmap;
      paramDrawData.mDecodeSample = localOptions.inSampleSize;
      if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
      {
        paramDrawData = (OnUpdateCallback)this.mCallback.get();
        if (paramDrawData != null) {
          paramDrawData.regionRefreshed();
        }
      }
      if (localBitmap1 == null)
      {
        ImageManagerLog.e("RegionBitmapDecoder", "Decode region failure bitmap = null with temp = " + this.mTmp);
        return;
      }
      l2 = SystemClock.uptimeMillis();
      paramDrawData = new StringBuilder();
      paramDrawData.append("piece decode cost " + (l2 - l1) + ", sample " + localOptions.inSampleSize + " temp = " + this.mTmp + " blockSize = " + this.mTmp.width());
      ImageManagerLog.i("RegionBitmapDecoder", paramDrawData.toString());
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      paramDrawData.mBitmap = null;
      Object localObject1 = new StringBuilder("IllegalArgumentException: ");
      if (this.mRegionDecoder != null) {
        ((StringBuilder)localObject1).append(this.mRegionDecoder.getWidth() + " x " + this.mRegionDecoder.getHeight() + " current Rect = " + this.mTmp);
      }
      ImageManagerLog.e("RegionDrawable", ((StringBuilder)localObject1).toString());
      localObject1 = paramDrawData.mBitmap;
      paramDrawData.mDecodeSample = localOptions.inSampleSize;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        paramDrawData = (OnUpdateCallback)this.mCallback.get();
        if (paramDrawData != null) {
          paramDrawData.regionRefreshed();
        }
      }
      if (localObject1 == null)
      {
        ImageManagerLog.e("RegionBitmapDecoder", "Decode region failure bitmap = null with temp = " + this.mTmp);
        return;
      }
      l2 = SystemClock.uptimeMillis();
      paramDrawData = new StringBuilder();
      paramDrawData.append("piece decode cost " + (l2 - l1) + ", sample " + localOptions.inSampleSize + " temp = " + this.mTmp + " blockSize = " + this.mTmp.width());
      ImageManagerLog.i("RegionBitmapDecoder", paramDrawData.toString());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ImageManagerLog.e("RegionDrawable", "decodeRegion OOM decode down");
      localOptions.inSampleSize <<= 1;
      if (this.mRegionDecoder != null) {
        paramDrawData.mBitmap = this.mRegionDecoder.decodeRegion(this.mTmp, localOptions);
      }
      Bitmap localBitmap2 = paramDrawData.mBitmap;
      paramDrawData.mDecodeSample = localOptions.inSampleSize;
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
      {
        paramDrawData = (OnUpdateCallback)this.mCallback.get();
        if (paramDrawData != null) {
          paramDrawData.regionRefreshed();
        }
      }
      if (localBitmap2 == null)
      {
        ImageManagerLog.e("RegionBitmapDecoder", "Decode region failure bitmap = null with temp = " + this.mTmp);
        return;
      }
      l2 = SystemClock.uptimeMillis();
      paramDrawData = new StringBuilder();
      paramDrawData.append("piece decode cost " + (l2 - l1) + ", sample " + localOptions.inSampleSize + " temp = " + this.mTmp + " blockSize = " + this.mTmp.width());
      ImageManagerLog.i("RegionBitmapDecoder", paramDrawData.toString());
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramDrawData.mBitmap = null;
      Object localObject2 = new StringBuilder("RuntimeException : ");
      if (this.mRegionDecoder != null) {
        ((StringBuilder)localObject2).append(this.mRegionDecoder.getWidth() + " x " + this.mRegionDecoder.getHeight() + " current Rect = " + this.mTmp);
      }
      ImageManagerLog.e("RegionBitmapDecoder", ((StringBuilder)localObject2).toString());
      localObject2 = paramDrawData.mBitmap;
      paramDrawData.mDecodeSample = localOptions.inSampleSize;
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        paramDrawData = (OnUpdateCallback)this.mCallback.get();
        if (paramDrawData != null) {
          paramDrawData.regionRefreshed();
        }
      }
      if (localObject2 == null)
      {
        ImageManagerLog.e("RegionBitmapDecoder", "Decode region failure bitmap = null with temp = " + this.mTmp);
        return;
      }
      l2 = SystemClock.uptimeMillis();
      paramDrawData = new StringBuilder();
      paramDrawData.append("piece decode cost " + (l2 - l1) + ", sample " + localOptions.inSampleSize + " temp = " + this.mTmp + " blockSize = " + this.mTmp.width());
      ImageManagerLog.i("RegionBitmapDecoder", paramDrawData.toString());
      return;
    }
    finally
    {
      Bitmap localBitmap3 = paramDrawData.mBitmap;
      paramDrawData.mDecodeSample = localOptions.inSampleSize;
      if ((localBitmap3 != null) && (!localBitmap3.isRecycled()))
      {
        paramDrawData = (OnUpdateCallback)this.mCallback.get();
        if (paramDrawData != null) {
          paramDrawData.regionRefreshed();
        }
      }
      if (localBitmap3 != null) {
        break label1088;
      }
    }
    ImageManagerLog.e("RegionBitmapDecoder", "Decode region failure bitmap = null with temp = " + this.mTmp);
    for (;;)
    {
      throw localObject3;
      label1088:
      l2 = SystemClock.uptimeMillis();
      paramDrawData = new StringBuilder();
      paramDrawData.append("piece decode cost " + (l2 - l1) + ", sample " + localOptions.inSampleSize + " temp = " + this.mTmp + " blockSize = " + this.mTmp.width());
      ImageManagerLog.i("RegionBitmapDecoder", paramDrawData.toString());
    }
  }
  
  private void initRegionDecoder()
  {
    if ((this.mRegionDecoder == null) || (this.mRegionDecoder.isRecycled())) {
      if (TextUtils.isEmpty(this.mImagePath)) {
        throw new RuntimeException("Image path is null");
      }
    }
    try
    {
      this.mRegionDecoder = BitmapRegionDecoder.newInstance(this.mImagePath, true);
      if (this.mRegionDecoder != null)
      {
        this.mOrgImageWidth = this.mRegionDecoder.getWidth();
        this.mOrgimageHeight = this.mRegionDecoder.getHeight();
        processImageSize();
        ImageManagerLog.i("RegionBitmapDecoder", "origin image size " + this.mRegionDecoder.getWidth() + "x" + this.mRegionDecoder.getHeight() + " mRotation = " + this.mRotation);
      }
      if (this.mRegionDecoder == null) {
        ImageManagerLog.e("RegionBitmapDecoder", "BitmapRegionDecoder object is null");
      }
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        localFileNotFoundException.printStackTrace();
        ImageManagerLog.e("RegionBitmapDecoder", "Init BitmapRegionDecoder failure FileNotFoundException");
        try
        {
          this.mRegionDecoder = BitmapRegionDecoder.newInstance(Uri.parse(this.mImagePath).getPath(), true);
        }
        catch (Exception localException1)
        {
          ImageManagerLog.e("RegionBitmapDecoder", "Init BitmapRegionDecoder failure exception");
          this.mRegionDecoder = null;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
        ImageManagerLog.e("RegionBitmapDecoder", "Init BitmapRegionDecoder failure exception , is SharpP = " + SharpPUtils.isSharpP(new File(this.mImagePath)));
        this.mRegionDecoder = null;
      }
    }
  }
  
  private void processImageSize()
  {
    if ((this.mOrgImageWidth == 0) || (this.mOrgimageHeight == 0) || (TextUtils.isEmpty(this.mImagePath))) {
      return;
    }
    if (this.mRotation == -1) {
      this.mRotation = RegionImageUtil.getRotation(this.mImagePath);
    }
    int i;
    if (((this.mRotation > 45) && (this.mRotation < 135)) || ((this.mRotation > 225) && (this.mRotation < 315)))
    {
      j = 1;
      if (j != 0) {
        break label119;
      }
      i = this.mOrgImageWidth;
      label94:
      if (j != 0) {
        break label127;
      }
    }
    label119:
    label127:
    for (int j = this.mOrgimageHeight;; j = this.mOrgImageWidth)
    {
      this.mOrgImageWidth = i;
      this.mOrgimageHeight = j;
      return;
      j = 0;
      break;
      i = this.mOrgimageHeight;
      break label94;
    }
  }
  
  private void recycleRegionBitmap()
  {
    Iterator localIterator = this.mDataList.entrySet().iterator();
    while (localIterator.hasNext())
    {
      DrawData localDrawData = (DrawData)((Map.Entry)localIterator.next()).getValue();
      if ((localDrawData != null) && (localDrawData.mBitmap != null))
      {
        localDrawData.mBitmap.recycle();
        localDrawData.mBitmap = null;
      }
    }
    this.mDataList.clear();
  }
  
  private Rect rotateRect(Rect paramRect)
  {
    if ((this.mOrgImageWidth == 0) || (this.mOrgimageHeight == 0)) {
      return paramRect;
    }
    if (this.mRotation == -1) {
      this.mRotation = RegionImageUtil.getRotation(this.mImagePath);
    }
    ImageManagerLog.w("RegionBitmapDecoder", "rotateRect mRotation = " + this.mRotation);
    if (this.mExifMatrix == null)
    {
      this.mExifMatrix = new Matrix();
      switch (this.mRotation)
      {
      default: 
        ImageManagerLog.e("RegionBitmapDecoder", "rotateRect mRotation = " + this.mRotation);
      }
    }
    while (this.mExifMatrix != null)
    {
      RectF localRectF = new RectF(paramRect);
      this.mExifMatrix.mapRect(localRectF);
      localRectF.round(paramRect);
      return paramRect;
      this.mExifMatrix.postRotate(-90.0F);
      this.mExifMatrix.postTranslate(0.0F, this.mOrgImageWidth);
      continue;
      this.mExifMatrix.postRotate(180.0F);
      this.mExifMatrix.postTranslate(this.mOrgImageWidth, this.mOrgimageHeight);
      continue;
      this.mExifMatrix.postRotate(90.0F);
      this.mExifMatrix.postTranslate(this.mOrgimageHeight, 0.0F);
    }
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    synchronized (this.mDataLock)
    {
      if ((this.mDataList != null) && (!this.mDataList.isEmpty()))
      {
        Iterator localIterator = this.mDataList.entrySet().iterator();
        while (localIterator.hasNext())
        {
          DrawData localDrawData = (DrawData)((Map.Entry)localIterator.next()).getValue();
          if ((localDrawData.mBitmap != null) && (!localDrawData.mBitmap.isRecycled())) {
            paramCanvas.drawBitmap(localDrawData.mBitmap, null, localDrawData.mOrgRect, paramPaint);
          }
        }
      }
    }
  }
  
  public void recycle()
  {
    synchronized (this.mDataLock)
    {
      if ((this.mRegionDecoder != null) && (!this.mRegionDecoder.isRecycled()))
      {
        ImageManagerLog.i("RegionBitmapDecoder", "mRegionDecoder recycle");
        this.mRegionDecoder.recycle();
        this.mRegionDecoder = null;
      }
      recycleRegionBitmap();
      return;
    }
  }
  
  public void setOnUpdateCallback(OnUpdateCallback paramOnUpdateCallback)
  {
    this.mCallback = new WeakReference(paramOnUpdateCallback);
  }
  
  public void updateRegionBitmap(RegionDrawableData paramRegionDrawableData)
  {
    if (paramRegionDrawableData == null) {
      return;
    }
    if (this.mWorkHandler.hasMessages(1)) {
      this.mWorkHandler.removeMessages(1);
    }
    this.mCurrentTime = System.currentTimeMillis();
    paramRegionDrawableData.mTaskTime = this.mCurrentTime;
    this.mWorkHandler.sendMessage(this.mWorkHandler.obtainMessage(1, paramRegionDrawableData));
  }
  
  public static class DrawData
  {
    public Bitmap mBitmap;
    public int mDecodeSample;
    public Rect mOrgRect;
    public Rect mShowRect;
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      return ((DrawData)paramObject).mShowRect.equals(this.mShowRect);
    }
  }
  
  public static abstract interface OnUpdateCallback
  {
    public abstract void regionRefreshed();
  }
  
  final class WorkHandler
    extends Handler
  {
    public WorkHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      int n;
      long l1;
      Object localObject1;
      do
      {
        do
        {
          do
          {
            return;
            RegionBitmapDecoder.this.initRegionDecoder();
            if ((RegionBitmapDecoder.this.mRegionDecoder == null) || (RegionBitmapDecoder.this.mOrgImageWidth == 0) || (RegionBitmapDecoder.this.mOrgimageHeight == 0))
            {
              paramMessage = new StringBuilder().append(" initRegionDecoder:  mRegionDecoder = null ? :  ");
              if (RegionBitmapDecoder.this.mRegionDecoder == null) {}
              for (boolean bool = true;; bool = false)
              {
                ImageManagerLog.i("RegionBitmapDecoder", bool + " mOrgImageWidth = " + RegionBitmapDecoder.this.mOrgImageWidth + " orgImageHeight = " + RegionBitmapDecoder.this.mOrgimageHeight);
                return;
              }
            }
          } while (!RegionDrawableData.class.isInstance(paramMessage.obj));
          paramMessage = (RegionDrawableData)paramMessage.obj;
          n = paramMessage.calcSample();
        } while (n == 0);
        RegionBitmapDecoder.this.caclShowArea(paramMessage);
        if (RegionBitmapDecoder.this.mHelper == null) {
          RegionBitmapDecoder.access$502(RegionBitmapDecoder.this, new RegionBitmapBlockHelper(new Rect(0, 0, RegionBitmapDecoder.this.mOrgImageWidth, RegionBitmapDecoder.this.mOrgimageHeight)));
        }
        l1 = SystemClock.uptimeMillis();
        localObject1 = new Rect(paramMessage.mShowArea);
        ??? = RegionBitmapDecoder.this.mHelper.getDrawDatas((Rect)localObject1, n);
        localObject1 = new HashMap();
      } while (??? == null);
      ??? = ((LinkedList)???).iterator();
      int j = 0;
      int k = 0;
      if (((Iterator)???).hasNext())
      {
        RegionBitmapDecoder.DrawData localDrawData1 = (RegionBitmapDecoder.DrawData)((Iterator)???).next();
        RegionBitmapDecoder.DrawData localDrawData2 = (RegionBitmapDecoder.DrawData)RegionBitmapDecoder.this.mDataList.get(localDrawData1.mShowRect);
        if (localDrawData2 == null)
        {
          localDrawData1.mOrgRect = RegionBitmapDecoder.this.rotateRect(new Rect(localDrawData1.mShowRect));
          ((HashMap)localObject1).put(localDrawData1.mShowRect, localDrawData1);
        }
        for (i = k + 1;; i = k)
        {
          k = i;
          break;
          ((HashMap)localObject1).put(localDrawData2.mShowRect, localDrawData2);
          j += 1;
        }
      }
      long l2 = SystemClock.uptimeMillis();
      for (;;)
      {
        synchronized (RegionBitmapDecoder.this.mDataLock)
        {
          RegionBitmapDecoder.access$602(RegionBitmapDecoder.this, (HashMap)localObject1);
          long l3 = SystemClock.uptimeMillis();
          m = 0;
          i = 0;
          try
          {
            localObject1 = RegionBitmapDecoder.this.mDataList.entrySet().iterator();
            m = i;
            if (((Iterator)localObject1).hasNext())
            {
              m = i;
              ??? = (RegionBitmapDecoder.DrawData)((Map.Entry)((Iterator)localObject1).next()).getValue();
              m = i;
              if (n == ((RegionBitmapDecoder.DrawData)???).mDecodeSample)
              {
                m = i;
                if (((RegionBitmapDecoder.DrawData)???).mBitmap != null)
                {
                  m = i;
                  if (((RegionBitmapDecoder.DrawData)???).mOrgRect != null)
                  {
                    m = i;
                    if (!((RegionBitmapDecoder.DrawData)???).mOrgRect.isEmpty()) {
                      continue;
                    }
                  }
                }
              }
              m = i;
              if (RegionBitmapDecoder.this.mCurrentTime == paramMessage.mTaskTime) {
                break label725;
              }
              m = i;
              ImageManagerLog.i("RegionBitmapDecoder", "stop decode ");
            }
          }
          catch (Exception paramMessage)
          {
            i = m;
            paramMessage.printStackTrace();
            continue;
          }
          if (SystemClock.uptimeMillis() - l3 == 0L) {
            break;
          }
          ImageManagerLog.i("RegionBitmapDecoder", "选取有效块:cost " + (l2 - l1));
          ImageManagerLog.i("RegionBitmapDecoder", "解析有效块:cost " + (SystemClock.uptimeMillis() - l3));
          ImageManagerLog.i("RegionBitmapDecoder", "分块：" + RegionBitmapDecoder.this.mDataList.size());
          ImageManagerLog.i("RegionBitmapDecoder", "invalidSize：" + k + " reUseSize :" + j + " refreshDecodeSize: " + i);
          return;
        }
        label725:
        m = i;
        RegionBitmapDecoder.this.decode((RegionBitmapDecoder.DrawData)???, n);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */