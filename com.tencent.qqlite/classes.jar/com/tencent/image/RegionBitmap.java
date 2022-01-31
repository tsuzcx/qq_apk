package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.lang.ref.WeakReference;

public final class RegionBitmap
{
  private static final int MSG_INSTANCE_REGION_DECODER = 0;
  private static final int MSG_RECYCLE_REGION_BITMAP = 2;
  private static final int MSG_UPDATE_DECODE_REGION = 1;
  private static final String TAG = "RegionBitmap";
  private static HandlerThread mWorkThread = new HandlerThread("Region-Update-Task");
  private Bitmap mBitmap;
  private WeakReference<OnUpdateCallback> mCallback;
  private Rect mDecodeRect = new Rect();
  private String mImagePath;
  private volatile boolean mIsRecycled;
  private BitmapRegionDecoder mRegionDecoder;
  private WorkHandler mWorkHandler;
  
  static
  {
    mWorkThread.start();
  }
  
  public RegionBitmap(String paramString)
  {
    if (this.mImagePath != paramString)
    {
      if ((this.mImagePath != null) && (this.mWorkHandler != null)) {
        this.mWorkHandler.sendEmptyMessage(0);
      }
      this.mImagePath = paramString;
    }
  }
  
  private Bitmap getBitmap()
  {
    if ((this.mBitmap != null) && (this.mBitmap.isRecycled())) {
      return null;
    }
    return this.mBitmap;
  }
  
  private void updateDecodeRect(Rect paramRect, int paramInt1, int paramInt2)
  {
    float f = paramInt1 / paramInt2;
    paramInt1 = (int)(paramRect.left * f);
    paramInt2 = (int)(paramRect.top * f);
    int i = (int)(paramRect.right * f);
    int j = (int)(paramRect.bottom * f);
    this.mDecodeRect.set(paramInt1, paramInt2, i, j);
  }
  
  void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    if (getBitmap() != null) {
      paramCanvas.drawBitmap(this.mBitmap, null, paramRect, paramPaint);
    }
  }
  
  public boolean isRecycle()
  {
    return this.mIsRecycled;
  }
  
  public void recycle()
  {
    if (this.mIsRecycled) {
      return;
    }
    this.mIsRecycled = true;
    this.mWorkHandler.sendEmptyMessage(2);
  }
  
  void recycleRegionBitmap()
  {
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled())) {
      return;
    }
    this.mBitmap.recycle();
    this.mBitmap = null;
  }
  
  public void setOnUpdateCallback(OnUpdateCallback paramOnUpdateCallback)
  {
    this.mCallback = new WeakReference(paramOnUpdateCallback);
  }
  
  public void updateRegionBitmap(Rect paramRect, int paramInt1, int paramInt2, float paramFloat)
  {
    if (isRecycle()) {}
    do
    {
      return;
      if (this.mWorkHandler == null)
      {
        this.mWorkHandler = new WorkHandler(mWorkThread.getLooper());
        this.mWorkHandler.sendEmptyMessage(0);
      }
    } while (this.mWorkHandler.hasMessages(1));
    paramRect = new RegionData(paramFloat, paramInt1, paramInt2, paramRect);
    this.mWorkHandler.obtainMessage(1, paramRect);
    this.mWorkHandler.sendMessage(this.mWorkHandler.obtainMessage(1, paramRect));
  }
  
  public static abstract interface OnUpdateCallback
  {
    public abstract void regionRefreshed(Rect paramRect);
  }
  
  class RegionData
  {
    float mScale;
    int mSourceDensity;
    int mTargetDensity;
    Rect mUpdateRect = new Rect();
    
    public RegionData(float paramFloat, int paramInt1, int paramInt2, Rect paramRect)
    {
      this.mScale = paramFloat;
      this.mTargetDensity = paramInt2;
      this.mSourceDensity = paramInt1;
      this.mUpdateRect.set(paramRect);
    }
  }
  
  final class WorkHandler
    extends Handler
  {
    public WorkHandler() {}
    
    public WorkHandler(Looper paramLooper)
    {
      super();
    }
    
    private int scaleToSample(float paramFloat)
    {
      int j = (int)(1.0F / paramFloat);
      int i = j;
      if (j > 64) {
        i = 64;
      }
      j = 1048576;
      for (;;)
      {
        if (j == 0) {
          j = 1;
        }
        int k;
        do
        {
          return j;
          k = i & j;
          if (k == 0) {
            break;
          }
          j = k;
        } while ((i - 1 & i) == 0);
        return k << 1;
        j >>= 1;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 0: 
      case 1: 
        do
        {
          do
          {
            do
            {
              return;
              if (RegionBitmap.this.mRegionDecoder != null) {
                RegionBitmap.this.mRegionDecoder.recycle();
              }
              if (TextUtils.isEmpty(RegionBitmap.this.mImagePath)) {
                throw new RuntimeException("Image path is null");
              }
              try
              {
                RegionBitmap.this.mRegionDecoder = BitmapRegionDecoder.newInstance(RegionBitmap.this.mImagePath, false);
                return;
              }
              catch (IOException paramMessage) {}
            } while (!QLog.isColorLevel());
            QLog.e("RegionBitmap", 2, "Init BitmapRegionDecoder failure", paramMessage);
            return;
            if (RegionBitmap.this.mRegionDecoder != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("RegionBitmap", 2, "BitmapRegionDecoder object is null");
          return;
        } while (!RegionBitmap.RegionData.class.isInstance(paramMessage.obj));
        paramMessage = (RegionBitmap.RegionData)paramMessage.obj;
        if (paramMessage.mScale == 0.0F) {}
        for (int i = 1;; i = scaleToSample(paramMessage.mScale))
        {
          RegionBitmap.this.updateDecodeRect(paramMessage.mUpdateRect, paramMessage.mSourceDensity, paramMessage.mTargetDensity);
          long l1 = SystemClock.uptimeMillis();
          Object localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
          ((BitmapFactory.Options)localObject).inDensity = 160;
          ((BitmapFactory.Options)localObject).inTargetDensity = 160;
          ((BitmapFactory.Options)localObject).inScreenDensity = 160;
          ((BitmapFactory.Options)localObject).inPurgeable = true;
          ((BitmapFactory.Options)localObject).inInputShareable = true;
          ((BitmapFactory.Options)localObject).inSampleSize = i;
          Bitmap localBitmap = RegionBitmap.this.mBitmap;
          RegionBitmap.this.mBitmap = RegionBitmap.this.mRegionDecoder.decodeRegion(RegionBitmap.this.mDecodeRect, (BitmapFactory.Options)localObject);
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
          if (RegionBitmap.this.mCallback != null)
          {
            localObject = (RegionBitmap.OnUpdateCallback)RegionBitmap.this.mCallback.get();
            if (localObject != null) {
              ((RegionBitmap.OnUpdateCallback)localObject).regionRefreshed(paramMessage.mUpdateRect);
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          long l2 = SystemClock.uptimeMillis();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cost " + (l2 - l1) + ", sample " + i + "\n");
          ((StringBuilder)localObject).append("origin size " + RegionBitmap.this.mRegionDecoder.getWidth() + ", " + RegionBitmap.this.mRegionDecoder.getHeight() + "\n");
          ((StringBuilder)localObject).append("update size " + paramMessage.mUpdateRect + "\n");
          ((StringBuilder)localObject).append("decode size " + RegionBitmap.this.mDecodeRect + "\n");
          QLog.i("RegionDrawable", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      RegionBitmap.this.recycleRegionBitmap();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.image.RegionBitmap
 * JD-Core Version:    0.7.0.1
 */