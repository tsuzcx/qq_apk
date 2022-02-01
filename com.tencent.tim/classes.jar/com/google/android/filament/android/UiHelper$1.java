package com.google.android.filament.android;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class UiHelper$1
  implements SurfaceHolder.Callback
{
  UiHelper$1(UiHelper paramUiHelper) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    UiHelper.access$000(this.this$0).onResized(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    UiHelper.access$100(this.this$0, paramSurfaceHolder.getSurface());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    UiHelper.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.android.UiHelper.1
 * JD-Core Version:    0.7.0.1
 */