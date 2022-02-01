package com.tencent.component.media.animwebp;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.GifRenderingExecutor;
import com.tencent.component.media.utils.ImageManagerLog;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class WebpDrawable
  extends Drawable
  implements Runnable
{
  private static final int DEFAULT_DELAY_MILLIS = 100;
  private static final int DEFAULT_INTRINSIC_HEIGHT = 480;
  private static final int DEFAULT_INTRINSIC_WIDTH = 270;
  private static final int DEFAULT_POLLING_TIME = 200;
  private static final String TAG = "AnimWebPDrawable";
  private Bitmap currentBitmap;
  private int delay;
  private AnimWebPInfo globalWebPInfo;
  private ScheduledThreadPoolExecutor mExecutor;
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  Runnable runnable = new WebpDrawable.2(this);
  private AtomicBoolean running = new AtomicBoolean(false);
  private AnimWebPNative webPNative;
  private byte[] webpFileBytes;
  private String webpFilePath;
  
  public WebpDrawable(String paramString)
  {
    this.webpFilePath = paramString;
    this.mExecutor = GifRenderingExecutor.getInstance();
  }
  
  public WebpDrawable(byte[] paramArrayOfByte)
  {
    this.webpFileBytes = paramArrayOfByte;
    this.mExecutor = GifRenderingExecutor.getInstance();
  }
  
  private void pause()
  {
    try
    {
      this.running.set(false);
      return;
    }
    finally {}
  }
  
  private void resume()
  {
    start();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if ((this.currentBitmap != null) && (!this.currentBitmap.isRecycled()))
    {
      paramCanvas.drawBitmap(this.currentBitmap, 0.0F, 0.0F, (Paint)null);
      if (this.running.get()) {
        this.mExecutor.schedule(this, this.delay, TimeUnit.MILLISECONDS);
      }
    }
  }
  
  public void finalize()
    throws Throwable
  {
    try
    {
      stop();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public Bitmap getCurrentBitmap()
  {
    return this.currentBitmap;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.globalWebPInfo != null) {
      return this.globalWebPInfo.getCanvasHeight();
    }
    return 480;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.globalWebPInfo != null) {
      return this.globalWebPInfo.getCanvasWidth();
    }
    return 270;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.running.get();
  }
  
  public void run()
  {
    try
    {
      if (this.webPNative == null)
      {
        if (this.webpFileBytes == null) {
          this.webpFileBytes = AnimWebPHelper.bytesFromFile(this.webpFilePath);
        }
        this.webPNative = new AnimWebPNative(this.webpFileBytes);
        this.globalWebPInfo = this.webPNative.initialize();
        if (this.globalWebPInfo == null)
        {
          ImageManagerLog.e("AnimWebPDrawable", "webp initialize error");
          return;
        }
        this.mainHandler.post(new WebpDrawable.1(this));
        this.currentBitmap = Bitmap.createBitmap(this.globalWebPInfo.getCanvasWidth(), this.globalWebPInfo.getCanvasHeight(), Bitmap.Config.ARGB_8888);
      }
      if ((!ImageManagerEnv.g().shouldPlayAnimWebp()) && (this.running.get()))
      {
        this.mExecutor.schedule(this, 200L, TimeUnit.MILLISECONDS);
        return;
      }
    }
    finally {}
    if (this.webPNative != null)
    {
      AnimWebPInfo localAnimWebPInfo = this.webPNative.nextFrame();
      if (localAnimWebPInfo == null) {
        break label245;
      }
      ByteBuffer localByteBuffer = this.webPNative.getCurrentFrameByteBuffer();
      localByteBuffer.position(0);
      localByteBuffer.limit(localAnimWebPInfo.getCanvasWidth() * localAnimWebPInfo.getCanvasHeight() * 4);
      this.currentBitmap.copyPixelsFromBuffer(localByteBuffer);
      this.delay = localAnimWebPInfo.getDurationMillis();
      if (this.delay == 0) {
        this.delay = 100;
      }
      this.mainHandler.post(this.runnable);
    }
    for (;;)
    {
      return;
      label245:
      ImageManagerLog.e("AnimWebPDrawable", "webp getNextFrame error");
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      start();
    }
    for (;;)
    {
      return super.setVisible(paramBoolean1, paramBoolean2);
      stop();
    }
  }
  
  public void start()
  {
    try
    {
      if (!this.running.get())
      {
        this.mExecutor.schedule(this, 0L, TimeUnit.MILLISECONDS);
        this.running.set(true);
      }
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      this.running.set(false);
      if (this.webPNative != null)
      {
        this.webPNative.release();
        this.webPNative = null;
      }
      if ((this.currentBitmap != null) && (!this.currentBitmap.isRecycled()))
      {
        this.currentBitmap.recycle();
        this.currentBitmap = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.animwebp.WebpDrawable
 * JD-Core Version:    0.7.0.1
 */