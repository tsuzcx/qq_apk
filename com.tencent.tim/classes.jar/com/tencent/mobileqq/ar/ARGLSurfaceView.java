package com.tencent.mobileqq.ar;

import adar;
import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class ARGLSurfaceView
  extends GLSurfaceView
{
  private a jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$a;
  private b jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$b;
  
  public ARGLSurfaceView(Context paramContext, SurfaceHolder.Callback paramCallback, a parama)
  {
    super(paramContext);
    QLog.i("AREngine_ARGLSurfaceView", 1, "create ARGLSurfaceView. context = " + paramContext + ", holderCallback = " + paramCallback + ", surfaceViewCallback = " + parama);
    setEGLContextFactory(new adar(this));
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    if (paramCallback != null) {
      getHolder().addCallback(paramCallback);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$a = parama;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$a.a(paramMotionEvent, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), getWidth(), getHeight());
    }
    super.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void setOnEglContextDestoryListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView$b = paramb;
  }
  
  @Deprecated
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    super.setRenderer(paramRenderer);
  }
  
  public static abstract interface a
  {
    public abstract void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  }
  
  public static abstract interface b
  {
    public abstract void cPz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */