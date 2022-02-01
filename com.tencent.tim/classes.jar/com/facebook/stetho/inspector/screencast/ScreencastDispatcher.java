package com.facebook.stetho.inspector.screencast;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.elements.android.ActivityTracker;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.module.Page.ScreencastFrameEvent;
import com.facebook.stetho.inspector.protocol.module.Page.ScreencastFrameEventMetadata;
import com.facebook.stetho.inspector.protocol.module.Page.StartScreencastRequest;
import java.io.ByteArrayOutputStream;

public final class ScreencastDispatcher
{
  private static final long FRAME_DELAY = 200L;
  private final ActivityTracker mActivityTracker = ActivityTracker.get();
  private Handler mBackgroundHandler;
  private Bitmap mBitmap;
  private final BitmapFetchRunnable mBitmapFetchRunnable = new BitmapFetchRunnable(null);
  private Canvas mCanvas;
  private Page.ScreencastFrameEvent mEvent = new Page.ScreencastFrameEvent();
  private final EventDispatchRunnable mEventDispatchRunnable = new EventDispatchRunnable(null);
  private HandlerThread mHandlerThread;
  private boolean mIsRunning;
  private final Handler mMainHandler = new Handler(Looper.getMainLooper());
  private Page.ScreencastFrameEventMetadata mMetadata = new Page.ScreencastFrameEventMetadata();
  private JsonRpcPeer mPeer;
  private Page.StartScreencastRequest mRequest;
  private ByteArrayOutputStream mStream;
  private final RectF mTempDst = new RectF();
  private final RectF mTempSrc = new RectF();
  
  public void startScreencast(JsonRpcPeer paramJsonRpcPeer, Page.StartScreencastRequest paramStartScreencastRequest)
  {
    LogUtil.d("Starting screencast");
    this.mRequest = paramStartScreencastRequest;
    this.mHandlerThread = new HandlerThread("Screencast Thread");
    this.mHandlerThread.start();
    this.mPeer = paramJsonRpcPeer;
    this.mIsRunning = true;
    this.mStream = new ByteArrayOutputStream();
    this.mBackgroundHandler = new Handler(this.mHandlerThread.getLooper());
    this.mMainHandler.postDelayed(this.mBitmapFetchRunnable, 200L);
  }
  
  public void stopScreencast()
  {
    LogUtil.d("Stopping screencast");
    this.mBackgroundHandler.post(new CancellationRunnable(null));
  }
  
  class BitmapFetchRunnable
    implements Runnable
  {
    private BitmapFetchRunnable() {}
    
    private void updateScreenBitmap()
    {
      if (!ScreencastDispatcher.this.mIsRunning) {}
      do
      {
        return;
        localObject = ScreencastDispatcher.this.mActivityTracker.tryGetTopActivity();
      } while (localObject == null);
      Object localObject = ((Activity)localObject).getWindow().getDecorView();
      try
      {
        if (ScreencastDispatcher.this.mBitmap == null)
        {
          int i = ((View)localObject).getWidth();
          int j = ((View)localObject).getHeight();
          float f = Math.min(ScreencastDispatcher.this.mRequest.maxWidth / i, ScreencastDispatcher.this.mRequest.maxHeight / j);
          int k = (int)(i * f);
          int m = (int)(f * j);
          ScreencastDispatcher.access$802(ScreencastDispatcher.this, Bitmap.createBitmap(k, m, Bitmap.Config.RGB_565));
          ScreencastDispatcher.access$1002(ScreencastDispatcher.this, new Canvas(ScreencastDispatcher.this.mBitmap));
          Matrix localMatrix = new Matrix();
          ScreencastDispatcher.this.mTempSrc.set(0.0F, 0.0F, i, j);
          ScreencastDispatcher.this.mTempDst.set(0.0F, 0.0F, k, m);
          localMatrix.setRectToRect(ScreencastDispatcher.this.mTempSrc, ScreencastDispatcher.this.mTempDst, Matrix.ScaleToFit.CENTER);
          ScreencastDispatcher.this.mCanvas.setMatrix(localMatrix);
        }
        ((View)localObject).draw(ScreencastDispatcher.this.mCanvas);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        LogUtil.w("Out of memory trying to allocate screencast Bitmap.");
      }
    }
    
    public void run()
    {
      updateScreenBitmap();
      ScreencastDispatcher.this.mBackgroundHandler.post(ScreencastDispatcher.EventDispatchRunnable.access$400(ScreencastDispatcher.this.mEventDispatchRunnable, this));
    }
  }
  
  class CancellationRunnable
    implements Runnable
  {
    private CancellationRunnable() {}
    
    public void run()
    {
      ScreencastDispatcher.this.mHandlerThread.interrupt();
      ScreencastDispatcher.this.mMainHandler.removeCallbacks(ScreencastDispatcher.this.mBitmapFetchRunnable);
      ScreencastDispatcher.this.mBackgroundHandler.removeCallbacks(ScreencastDispatcher.this.mEventDispatchRunnable);
      ScreencastDispatcher.access$602(ScreencastDispatcher.this, false);
      ScreencastDispatcher.access$1802(ScreencastDispatcher.this, null);
      ScreencastDispatcher.access$802(ScreencastDispatcher.this, null);
      ScreencastDispatcher.access$1002(ScreencastDispatcher.this, null);
      ScreencastDispatcher.access$1302(ScreencastDispatcher.this, null);
    }
  }
  
  class EventDispatchRunnable
    implements Runnable
  {
    private Runnable mEndAction;
    
    private EventDispatchRunnable() {}
    
    private EventDispatchRunnable withEndAction(Runnable paramRunnable)
    {
      this.mEndAction = paramRunnable;
      return this;
    }
    
    public void run()
    {
      if ((!ScreencastDispatcher.this.mIsRunning) || (ScreencastDispatcher.this.mBitmap == null)) {
        return;
      }
      int i = ScreencastDispatcher.this.mBitmap.getWidth();
      int j = ScreencastDispatcher.this.mBitmap.getHeight();
      ScreencastDispatcher.this.mStream.reset();
      Base64OutputStream localBase64OutputStream = new Base64OutputStream(ScreencastDispatcher.this.mStream, 0);
      Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.valueOf(ScreencastDispatcher.this.mRequest.format.toUpperCase());
      ScreencastDispatcher.this.mBitmap.compress(localCompressFormat, ScreencastDispatcher.this.mRequest.quality, localBase64OutputStream);
      ScreencastDispatcher.this.mEvent.data = ScreencastDispatcher.this.mStream.toString();
      ScreencastDispatcher.this.mMetadata.pageScaleFactor = 1;
      ScreencastDispatcher.this.mMetadata.deviceWidth = i;
      ScreencastDispatcher.this.mMetadata.deviceHeight = j;
      ScreencastDispatcher.this.mEvent.metadata = ScreencastDispatcher.this.mMetadata;
      ScreencastDispatcher.this.mPeer.invokeMethod("Page.screencastFrame", ScreencastDispatcher.this.mEvent, null);
      ScreencastDispatcher.this.mMainHandler.postDelayed(this.mEndAction, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.screencast.ScreencastDispatcher
 * JD-Core Version:    0.7.0.1
 */