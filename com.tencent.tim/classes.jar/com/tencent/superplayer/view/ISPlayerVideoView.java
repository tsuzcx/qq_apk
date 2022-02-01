package com.tencent.superplayer.view;

import android.view.Surface;
import android.view.View;

public abstract interface ISPlayerVideoView
{
  public abstract void addViewCallBack(IVideoViewCallBack paramIVideoViewCallBack);
  
  public abstract void changeSurfaceObject(SPlayerVideoView.SurfaceObject paramSurfaceObject);
  
  public abstract boolean disableViewCallback();
  
  public abstract boolean enableViewCallback();
  
  public abstract String getLogTag();
  
  public abstract View getRenderView();
  
  public abstract int getRenderViewHeight();
  
  public abstract int getRenderViewWidth();
  
  public abstract Surface getSurface();
  
  public abstract boolean isSurfaceReady();
  
  public abstract boolean isTextureView();
  
  public abstract void removeViewCallBack(IVideoViewCallBack paramIVideoViewCallBack);
  
  public abstract void setDegree(int paramInt);
  
  public abstract void setFixedSize(int paramInt1, int paramInt2);
  
  public abstract void setScaleParam(float paramFloat);
  
  public abstract void setXYaxis(int paramInt);
  
  public static abstract interface IVideoViewCallBack
  {
    public abstract void onSurfaceChanged(Object paramObject);
    
    public abstract void onSurfaceCreated(Object paramObject);
    
    public abstract void onSurfaceDestroy(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.ISPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */