package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gameplay.ARNativeBridge;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARGLSurfaceView.SurfaceStateListener;
import com.tencent.qphone.base.util.QLog;
import igd;
import ili.b;
import izo;

public class GamePlayView
  extends FrameLayout
  implements ili.b
{
  private ARNativeBridge jdField_a_of_type_ComTencentAvGameplayARNativeBridge;
  ARGLSurfaceView.SurfaceStateListener jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView$SurfaceStateListener = new izo(this);
  private ARGLSurfaceView jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView;
  private Activity mActivity;
  protected VideoAppInterface mApp;
  private long oA;
  
  public GamePlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, Activity paramActivity, String paramString, int paramInt)
  {
    this.mApp = paramVideoAppInterface;
    igd.aJ("ARZimuTask_GamePlayView", "init strResPath = " + paramString + "  |  code = " + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView = ((ARGLSurfaceView)findViewById(2131368070));
    this.mActivity = paramActivity;
    this.jdField_a_of_type_ComTencentAvGameplayARNativeBridge = new ARNativeBridge();
    this.jdField_a_of_type_ComTencentAvGameplayARNativeBridge.native_updateResourcePath(paramString);
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.getHolder().setFormat(-3);
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.init(paramActivity, paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.setZOrderMediaOverlay(true);
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.setSurfaceStateListener(this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView$SurfaceStateListener);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new GamePlayView.3(this, paramArrayOfByte, paramInt1, paramInt2, paramBoolean));
  }
  
  public void c(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new GamePlayView.2(this, paramFloat1, paramFloat2, paramBoolean));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void doOnPause()
  {
    QLog.d("ARZimuTask_GamePlayView", 2, "onPause");
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.onPause();
  }
  
  public void doOnResume()
  {
    QLog.d("ARZimuTask_GamePlayView", 2, "onResume");
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.onResume();
  }
  
  public void io(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new GamePlayView.5(this, paramBoolean));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    doOnResume();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    doOnPause();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setDrawParticle(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new GamePlayView.4(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GamePlayView
 * JD-Core Version:    0.7.0.1
 */