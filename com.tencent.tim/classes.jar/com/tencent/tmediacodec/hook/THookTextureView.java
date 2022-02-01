package com.tencent.tmediacodec.hook;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;

public class THookTextureView
  extends TextureView
{
  public static final String TAG = "THookTextureView";
  private static SurfaceTextureHookCallback hookCallback;
  private TextureView.SurfaceTextureListener mInnerSetListener = new THookTextureView.1(this);
  private TextureView.SurfaceTextureListener mOutSetListener;
  
  public THookTextureView(@Nullable Context paramContext)
  {
    this(paramContext, (AttributeSet)null, 0);
  }
  
  public THookTextureView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public THookTextureView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSurfaceTextureListener(null);
  }
  
  public static void setHookCallback(SurfaceTextureHookCallback paramSurfaceTextureHookCallback)
  {
    hookCallback = paramSurfaceTextureHookCallback;
  }
  
  public final void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    this.mOutSetListener = paramSurfaceTextureListener;
    super.setSurfaceTextureListener(this.mInnerSetListener);
  }
  
  public static abstract interface SurfaceTextureHookCallback
  {
    public abstract boolean onSurfaceTextureDestroyedCalled(@Nullable SurfaceTexture paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView
 * JD-Core Version:    0.7.0.1
 */