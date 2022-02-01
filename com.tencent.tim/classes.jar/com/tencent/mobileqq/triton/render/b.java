package com.tencent.mobileqq.triton.render;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.mobileqq.triton.touch.TouchEventManager;

public class b
  extends SurfaceView
  implements SurfaceHolder.Callback2
{
  private RenderContext a;
  private TouchEventManager b;
  
  public b(Context paramContext, RenderContext paramRenderContext, TouchEventManager paramTouchEventManager)
  {
    super(paramContext);
    this.b = paramTouchEventManager;
    this.a = paramRenderContext;
    getHolder().addCallback(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.b.a(paramMotionEvent);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.b(paramSurfaceHolder.getSurface());
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.a.a(paramSurfaceHolder.getSurface());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.a.a();
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.b
 * JD-Core Version:    0.7.0.1
 */