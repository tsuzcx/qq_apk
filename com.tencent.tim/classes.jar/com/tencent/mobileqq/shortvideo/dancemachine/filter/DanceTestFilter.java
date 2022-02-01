package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class DanceTestFilter
  extends DanceBaseFilter
{
  private GLImageView mImageViewAlpha;
  private GLImageView mImageViewRotate;
  private GLImageView mImageViewScale;
  private GLImageView mImageViewStart;
  private RotateAnimation mRotate;
  private ScaleAnimation mScale;
  private TranslateAnimation mTransform;
  private AlphaAnimation malpha;
  
  public DanceTestFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  public void onChangeCamera(int paramInt) {}
  
  public void onDrawFrame() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onSurfaceChange(int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreate() {}
  
  public void onSurfaceDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceTestFilter
 * JD-Core Version:    0.7.0.1
 */