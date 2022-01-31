package com.tencent.av.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import bhz;
import bia;
import java.lang.ref.WeakReference;

public class QQGlView
  extends GLSurfaceView
{
  static String jdField_a_of_type_JavaLangString = "QQGlView";
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public boolean b = false;
  public boolean c = true;
  public boolean d = false;
  public int g = 1;
  
  public QQGlView(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode()) {
      return;
    }
    this.g = QQGlRender.getGLVersion(paramContext);
    Log.d(jdField_a_of_type_JavaLangString, "opengl version = " + this.g);
    a(false, 0, 0);
  }
  
  public QQGlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    this.g = QQGlRender.getGLVersion(paramContext);
    a(false, 0, 0);
    Log.d(jdField_a_of_type_JavaLangString, "opengl version == " + this.g);
  }
  
  public float a()
  {
    return 0.0F;
  }
  
  public int a()
  {
    return 320;
  }
  
  public QQGlRender a()
  {
    return (QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setWaitViewResetGestureState(false);
      ((QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get()).requestRender();
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    getHolder().addCallback(this);
    if (this.g == 2)
    {
      setEGLContextFactory(new bia());
      setEGLConfigChooser(new bhz(5, 6, 5, 0, 0, 0));
    }
    Log.d(jdField_a_of_type_JavaLangString, "init Video GLView");
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public float b()
  {
    return 0.0F;
  }
  
  public int b()
  {
    return 240;
  }
  
  public float c()
  {
    return 1.0F;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return false;
  }
  
  public void e()
  {
    this.b = true;
    super.requestRender();
  }
  
  public void onPause()
  {
    Log.d(jdField_a_of_type_JavaLangString, "onPause");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    Log.d(jdField_a_of_type_JavaLangString, "onResume");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onResume();
    }
    super.onResume();
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get()).mSetMode = false;
    }
  }
  
  public void setMeasuredDimensionex(int paramInt1, int paramInt2)
  {
    super.setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setRenderer(QQGlRender paramQQGlRender)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQGlRender);
    super.setRenderer(paramQQGlRender);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Log.d(jdField_a_of_type_JavaLangString, "surfaceCreated");
    super.surfaceCreated(paramSurfaceHolder);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get()).surfaceCreated(paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Log.d(jdField_a_of_type_JavaLangString, "surfaceDestroyed");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onSurfaceDestroyed();
    }
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.QQGlView
 * JD-Core Version:    0.7.0.1
 */