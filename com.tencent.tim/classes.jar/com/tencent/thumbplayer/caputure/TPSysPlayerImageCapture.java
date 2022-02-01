package com.tencent.thumbplayer.caputure;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.FileDescriptor;
import java.util.HashMap;

public class TPSysPlayerImageCapture
{
  private static final int EV_CAP_IMAGE = 1;
  private static final int EV_STOP_CAP_IMAGE = 2;
  private static final String TAG = "TPSysPlayerImageCapture";
  private static TPSysPlayerImageCapture gInstance = null;
  private int mBaseID = 0;
  private EventHandler mCapHandler = null;
  private HandlerThread mHandlerThread = null;
  private MediaMetadataRetriever mRetriever = null;
  
  private TPSysPlayerImageCapture()
  {
    try
    {
      this.mHandlerThread = new HandlerThread("TP-SysImgCap");
      this.mHandlerThread.start();
      this.mCapHandler = new EventHandler(this.mHandlerThread.getLooper());
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPSysPlayerImageCapture", localThrowable);
      this.mCapHandler = new EventHandler(Looper.getMainLooper());
    }
  }
  
  public static TPSysPlayerImageCapture GetImageCaptureInstance()
  {
    try
    {
      if (gInstance == null) {
        gInstance = new TPSysPlayerImageCapture();
      }
      TPSysPlayerImageCapture localTPSysPlayerImageCapture = gInstance;
      return localTPSysPlayerImageCapture;
    }
    finally {}
  }
  
  private void doRealCaptureImage(CaptureMsg paramCaptureMsg)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 14) {
          throw new Exception("os version not support");
        }
      }
      catch (Exception localException)
      {
        TPLogUtil.e("TPSysPlayerImageCapture", localException);
        TPLogUtil.e("TPSysPlayerImageCapture", "doRealCaptureImage, Exception: " + localException.toString());
        paramCaptureMsg.lis.onCaptureFailed(paramCaptureMsg.id, 1000001);
        return;
        long l1 = System.currentTimeMillis();
        if (this.mRetriever != null)
        {
          this.mRetriever.release();
          this.mRetriever = null;
        }
        this.mRetriever = new MediaMetadataRetriever();
        if (Build.VERSION.SDK_INT >= 14)
        {
          if (paramCaptureMsg.fileDescriptor != null) {
            this.mRetriever.setDataSource(paramCaptureMsg.fileDescriptor);
          }
        }
        else
        {
          Bitmap localBitmap = this.mRetriever.getFrameAtTime(paramCaptureMsg.positionMs * 1000L, 2);
          long l2 = System.currentTimeMillis();
          if (localBitmap == null) {
            break label272;
          }
          paramCaptureMsg.lis.onCaptureSucceed(paramCaptureMsg.id, paramCaptureMsg.positionMs, paramCaptureMsg.width, paramCaptureMsg.height, localBitmap, l2 - l1);
          return;
        }
        this.mRetriever.setDataSource(paramCaptureMsg.url, new HashMap());
        continue;
      }
      finally
      {
        if (this.mRetriever != null)
        {
          this.mRetriever.release();
          this.mRetriever = null;
        }
      }
      label272:
      paramCaptureMsg.lis.onCaptureFailed(paramCaptureMsg.id, 1000001);
    }
  }
  
  public int captureImageWithPosition(String paramString, FileDescriptor paramFileDescriptor, long paramLong, int paramInt1, int paramInt2, CaptureMediaImageListener paramCaptureMediaImageListener)
  {
    TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + paramLong + ", width: " + paramInt1 + ", height: " + paramInt2);
    this.mBaseID += 1;
    if ((!TextUtils.isEmpty(Build.MODEL)) && (Build.MODEL.equals("Lenovo+K900")))
    {
      TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
      return -1;
    }
    CaptureMsg localCaptureMsg = new CaptureMsg(null);
    CaptureMsg.access$102(localCaptureMsg, this.mBaseID);
    CaptureMsg.access$202(localCaptureMsg, paramFileDescriptor);
    CaptureMsg.access$302(localCaptureMsg, paramString);
    CaptureMsg.access$402(localCaptureMsg, paramLong);
    CaptureMsg.access$502(localCaptureMsg, paramInt1);
    CaptureMsg.access$602(localCaptureMsg, paramInt2);
    localCaptureMsg.lis = paramCaptureMediaImageListener;
    paramString = new Message();
    paramString.what = 1;
    paramString.obj = localCaptureMsg;
    if (!this.mCapHandler.sendMessage(paramString)) {
      TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
    }
    return this.mBaseID;
  }
  
  public static abstract interface CaptureMediaImageListener
  {
    public abstract void onCaptureFailed(int paramInt1, int paramInt2);
    
    public abstract void onCaptureSucceed(int paramInt1, long paramLong1, int paramInt2, int paramInt3, Bitmap paramBitmap, long paramLong2);
  }
  
  static class CaptureMsg
  {
    private FileDescriptor fileDescriptor;
    private int height;
    private int id;
    protected TPSysPlayerImageCapture.CaptureMediaImageListener lis;
    private long positionMs;
    private String url;
    private int width;
  }
  
  class EventHandler
    extends Handler
  {
    public EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
      }
      do
      {
        return;
        TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
        paramMessage = (TPSysPlayerImageCapture.CaptureMsg)paramMessage.obj;
        TPSysPlayerImageCapture.this.doRealCaptureImage(paramMessage);
        return;
        TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
      } while (TPSysPlayerImageCapture.this.mRetriever == null);
      TPSysPlayerImageCapture.this.mRetriever.release();
      TPSysPlayerImageCapture.access$802(TPSysPlayerImageCapture.this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.caputure.TPSysPlayerImageCapture
 * JD-Core Version:    0.7.0.1
 */