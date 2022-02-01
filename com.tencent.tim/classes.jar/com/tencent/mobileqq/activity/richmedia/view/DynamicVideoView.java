package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class DynamicVideoView
  extends FrameLayout
{
  private GLSurfaceView mGLSurfaceView;
  
  public DynamicVideoView(Context paramContext)
  {
    super(paramContext);
    dC(paramContext);
  }
  
  public DynamicVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    dC(paramContext);
  }
  
  public DynamicVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dC(paramContext);
  }
  
  private void dC(Context paramContext)
  {
    if (isInEditMode()) {
      return;
    }
    this.mGLSurfaceView = new GLSurfaceView(getContext());
    paramContext = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.mGLSurfaceView, paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.DynamicVideoView
 * JD-Core Version:    0.7.0.1
 */