package com.tencent.image;

import android.view.View;

public abstract interface URLDrawableDownListener
{
  public abstract void onLoadCancelled(View paramView, URLDrawable paramURLDrawable);
  
  public abstract void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable);
  
  public abstract void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException);
  
  public abstract void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt);
  
  public abstract void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable);
  
  public static class Adapter
    implements URLDrawableDownListener
  {
    public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
    
    public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
    
    public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
    
    public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.URLDrawableDownListener
 * JD-Core Version:    0.7.0.1
 */