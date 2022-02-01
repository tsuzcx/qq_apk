package com.tencent.mobileqq.activity.richmedia.view;

import aasx;
import aavg;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import anij;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.a;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

public class CameraGLSurfaceView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer, Handler.Callback
{
  public aavg a;
  a jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView$a;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  private AtomicInteger aO = new AtomicInteger(0);
  private AtomicInteger aP = new AtomicInteger(0);
  private boolean bAe;
  private boolean bAf;
  private boolean bAg;
  private volatile boolean bAh;
  public boolean bAi;
  private String bet;
  private boolean bzN;
  private boolean bzQ;
  private int ckW = 270;
  private int mDstHeight;
  private int mDstWidth;
  private HandlerThread mGlThreadMsg;
  private Handler mHandler;
  private int mHeight;
  private int mPreviewHeight;
  private int mPreviewWidth;
  private int mVideoFormat;
  private int mWidth;
  private int orientation = 90;
  
  public CameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    cza();
  }
  
  public CameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cza();
  }
  
  public static void GLLogMsg(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraGLSurfaceView", 2, paramString);
    }
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, GL10 paramGL10)
    throws OutOfMemoryError
  {
    int[] arrayOfInt1 = new int[paramInt3 * paramInt4];
    int[] arrayOfInt2 = new int[paramInt3 * paramInt4];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    for (;;)
    {
      try
      {
        paramGL10.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
        paramInt1 = 0;
      }
      catch (GLException paramGL10)
      {
        int i;
        return null;
      }
      if (paramInt2 < paramInt3)
      {
        i = arrayOfInt1[(paramInt1 * paramInt3 + paramInt2)];
        arrayOfInt2[((paramInt4 - paramInt1 - 1) * paramInt3 + paramInt2)] = (i & 0xFF00FF00 | i << 16 & 0xFF0000 | i >> 16 & 0xFF);
        paramInt2 += 1;
      }
      else
      {
        paramInt1 += 1;
        while (paramInt1 >= paramInt4) {
          return Bitmap.createBitmap(arrayOfInt2, paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
        }
        paramInt2 = 0;
      }
    }
  }
  
  public static native ByteBuffer allocate(int paramInt1, int paramInt2);
  
  private void cza()
  {
    setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    super.setRenderer(this);
    super.setRenderMode(0);
    super.getHolder().setFormat(1);
    this.bAe = true;
    this.bAf = false;
    this.bAh = false;
    this.bzN = false;
    this.mGlThreadMsg = null;
    this.mHandler = null;
    this.jdField_a_of_type_Aavg = new aavg();
  }
  
  private void czb()
  {
    this.jdField_a_of_type_Aavg.arF = 0;
    this.bAf = false;
  }
  
  private void czc()
  {
    this.aP.set(1);
    this.bAg = this.jdField_a_of_type_Aavg.a(this.bAg, this.mWidth, this.mHeight, this.jdField_a_of_type_Aavg.n, this.jdField_a_of_type_Aavg.o, this.jdField_a_of_type_Aavg.p);
    int i = GLES20.glGetError();
    if (i != 0) {
      GLLogMsg("glDrawFrame:err=" + i);
    }
    this.aP.set(0);
  }
  
  public static native int getBitmap(Bitmap paramBitmap, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt);
  
  public static native void initTotalBufferSize(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int processVideoFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, boolean paramBoolean2);
  
  private void releaseMsgThread()
  {
    if (this.mGlThreadMsg != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = null;
      }
      this.mHandler.removeCallbacksAndMessages(null);
      this.mGlThreadMsg.quit();
      this.mGlThreadMsg = null;
      this.mHandler = null;
    }
  }
  
  public static native int writeVideoFrame(int paramInt1, int paramInt2, AVIOStruct paramAVIOStruct);
  
  private int zi()
  {
    if (this.aP.getAndAdd(0) != 0)
    {
      GLLogMsg("beginRenderFileCacheData: lost frame");
      return -1;
    }
    if (this.jdField_a_of_type_Aavg.n != null)
    {
      this.jdField_a_of_type_Aavg.n.position(0);
      this.jdField_a_of_type_Aavg.o.position(0);
      this.jdField_a_of_type_Aavg.p.position(0);
      return 0;
    }
    GLLogMsg("handleMessage:beginRenderFileCacheData:panelY=" + this.jdField_a_of_type_Aavg.n);
    return -2;
  }
  
  public void createMsgThread()
  {
    if (this.mGlThreadMsg == null)
    {
      this.mGlThreadMsg = new HandlerThread("glProcess");
      this.mGlThreadMsg.start();
      this.mHandler = new Handler(this.mGlThreadMsg.getLooper(), this);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.mHandler;
      }
      this.aP.set(0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    byte[] arrayOfByte = null;
    int i;
    if (paramMessage.what == -16716526)
    {
      i = this.aO.get();
      if (i != 0) {
        GLLogMsg("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + i);
      }
    }
    label343:
    do
    {
      do
      {
        do
        {
          return true;
        } while (paramMessage.obj == null);
        if (paramMessage.arg1 == 0) {
          arrayOfByte = (byte[])paramMessage.obj;
        }
        for (;;)
        {
          i = this.jdField_a_of_type_Aavg.a(this.mVideoFormat, this.mWidth, this.mHeight, this.mPreviewWidth, this.mPreviewHeight, this.ckW, arrayOfByte);
          if ((paramMessage.arg2 == 1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.addUserBufferRecycle(arrayOfByte);
          }
          if (i != 0) {
            break label343;
          }
          requestRender();
          long l = SystemClock.elapsedRealtime();
          GLLogMsg("handleMessage:requestRender  renderTime=" + l);
          if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
            ThreadManager.getUIHandler().post(new CameraGLSurfaceView.2(this));
          }
          if (paramMessage.arg1 != 1) {
            break;
          }
          try
          {
            paramMessage = ((PreviewContext.a)paramMessage.obj).b;
            if (l != 0L)
            {
              GLLogMsg("handleMessage:writeVideoFrame  renderTime=" + l + " oldtime=" + paramMessage.vFrameTime + " diff=" + (l - paramMessage.vFrameTime));
              paramMessage.vFrameTime = l;
            }
            i = writeVideoFrame(this.mWidth, this.mHeight, paramMessage);
          }
          catch (UnsatisfiedLinkError paramMessage)
          {
            for (;;)
            {
              i = -15;
            }
          }
          GLLogMsg("handleMessage:writeVideoFrame  error=" + i);
          return true;
          if (paramMessage.arg1 == 1) {
            arrayOfByte = ((PreviewContext.a)paramMessage.obj).data;
          }
        }
        GLLogMsg("handleMessage:byteBufferProcessFrame  error=" + i);
        return true;
      } while (paramMessage.what != -16716525);
      i = this.aO.get();
      if (i != 1)
      {
        GLLogMsg("handleMessage:[RenderModeCheck-Preview] mode=" + i);
        return true;
      }
    } while (zi() != 0);
    requestRender();
    return true;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.bAh) && (this.bAe) && (this.bAf))
    {
      czc();
      if ((this.bzQ) && (this.bet != null))
      {
        paramGL10 = a(0, 0, getWidth(), getHeight(), paramGL10);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView$a.J(paramGL10);
        }
        this.bzQ = false;
        this.bet = null;
      }
    }
  }
  
  public void onPause()
  {
    if (this.bzN)
    {
      super.onPause();
      this.bzN = false;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    createMsgThread();
    this.bzN = true;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.bAi) {
      this.jdField_a_of_type_Aavg.bAm = true;
    }
    if (!this.jdField_a_of_type_Aavg.aT(getContext())) {
      this.bAe = false;
    }
    this.bAf = true;
    this.bAg = false;
  }
  
  public void setCaptureListener(a parama)
  {
    queueEvent(new CameraGLSurfaceView.1(this, parama));
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, aasx paramaasx)
  {
    this.mPreviewWidth = paramInt1;
    this.mPreviewHeight = paramInt2;
    this.mWidth = paramaasx.cjG;
    this.mHeight = paramaasx.cjH;
    this.mDstWidth = paramaasx.cjI;
    this.mDstHeight = paramaasx.cjJ;
    if (this.mWidth % 2 != 0) {
      this.mWidth -= 1;
    }
    if (this.mHeight % 2 != 0) {
      this.mHeight -= 1;
    }
    if (this.mDstWidth % 2 != 0) {
      this.mDstWidth -= 1;
    }
    if (this.mDstHeight % 2 != 0) {
      this.mDstHeight -= 1;
    }
    this.mVideoFormat = anij.a().getPreviewFormat();
    paramInt1 = anij.a().JE();
    if (paramInt1 <= 0) {
      this.ckW = 270;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraGLSurfaceView", 2, "setPreviewSize:mVideoClipDegree=" + this.ckW);
      }
      aavg.initSuccess = false;
      try
      {
        initTotalBufferSize(this.mPreviewWidth, this.mPreviewHeight, this.mVideoFormat);
        aavg.initSuccess = true;
        this.jdField_a_of_type_Aavg.gx(this.mWidth, this.mHeight);
        this.jdField_a_of_type_Aavg.bAo = false;
        this.bAh = true;
        return;
        this.ckW = paramInt1;
      }
      catch (UnsatisfiedLinkError paramaasx)
      {
        for (;;)
        {
          aavg.initSuccess = false;
        }
      }
    }
  }
  
  public void setVideoContext(PreviewContext paramPreviewContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.mHandler;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mPTVRealBeauty = true;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    czb();
    releaseMsgThread();
  }
  
  public static abstract interface a
  {
    public abstract void J(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */