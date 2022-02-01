package com.tencent.mobileqq.richmedia.mediacodec.encoder;

import amac;
import amad;
import ambe;
import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class EglHandlerThread
  extends HandlerThread
{
  private amac jdField_b_of_type_Amac;
  private amad jdField_b_of_type_Amad;
  private Handler handler;
  private boolean initSuccess;
  private EGLContext sharedContext;
  
  public EglHandlerThread(String paramString, EGLContext paramEGLContext)
  {
    super(paramString);
    this.sharedContext = paramEGLContext;
  }
  
  private void release()
  {
    if (getLooper().getThread() != Thread.currentThread()) {
      QLog.e("EglHandlerThread", 2, "release should be called in origin thread " + getThreadId());
    }
    do
    {
      do
      {
        return;
      } while (!this.initSuccess);
      if (this.jdField_b_of_type_Amad != null)
      {
        this.jdField_b_of_type_Amad.releaseEglSurface();
        this.jdField_b_of_type_Amad = null;
      }
    } while (this.jdField_b_of_type_Amac == null);
    this.jdField_b_of_type_Amac.release();
    this.jdField_b_of_type_Amac = null;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public boolean isInitSuccess()
  {
    return this.initSuccess;
  }
  
  protected void onLooperPrepared()
  {
    try
    {
      super.onLooperPrepared();
      this.handler = new Handler(getLooper());
      this.jdField_b_of_type_Amac = new amac(this.sharedContext, 1);
      this.jdField_b_of_type_Amad = new amad(this.jdField_b_of_type_Amac);
      this.jdField_b_of_type_Amad.createOffscreenSurface(64, 64);
      this.jdField_b_of_type_Amad.makeCurrent();
      this.initSuccess = true;
      return;
    }
    catch (Exception localException)
    {
      this.initSuccess = false;
      QLog.e("EglHandlerThread", 2, localException, new Object[0]);
      ambe.j(localException);
    }
  }
  
  public boolean quit()
  {
    if (getLooper().getThread() != Thread.currentThread())
    {
      QLog.e("EglHandlerThread", 2, "quit should be called in origin thread " + getThreadId());
      this.handler.post(new EglHandlerThread.1(this));
      return false;
    }
    boolean bool = super.quit();
    release();
    return bool;
  }
  
  public boolean quitSafely()
  {
    this.handler.post(new EglHandlerThread.2(this));
    return super.quitSafely();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread
 * JD-Core Version:    0.7.0.1
 */