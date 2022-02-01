package com.tencent.superplayer.view;

public abstract interface ISPlayerViewBase
{
  public abstract boolean setDegree(int paramInt);
  
  public abstract void setScaleParam(float paramFloat);
  
  public abstract void setVideoViewTagId(String paramString);
  
  public abstract void setVideoWidthAndHeight(int paramInt1, int paramInt2);
  
  public abstract void setViewCallBack(ViewCreateCallBack paramViewCreateCallBack);
  
  public abstract void setXYaxis(int paramInt);
  
  public static abstract interface ViewCreateCallBack
  {
    public abstract void onViewChanged(Object paramObject, int paramInt1, int paramInt2);
    
    public abstract void onViewCreated(Object paramObject, int paramInt1, int paramInt2);
    
    public abstract boolean onViewDestroyed(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.ISPlayerViewBase
 * JD-Core Version:    0.7.0.1
 */