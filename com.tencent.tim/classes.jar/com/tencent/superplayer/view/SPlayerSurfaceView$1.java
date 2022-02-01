package com.tencent.superplayer.view;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class SPlayerSurfaceView$1
  implements SurfaceHolder.Callback
{
  SPlayerSurfaceView$1(SPlayerSurfaceView paramSPlayerSurfaceView) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SPlayerSurfaceView.access$000(this.this$0) != null) {
      SPlayerSurfaceView.access$000(this.this$0).onViewChanged(paramSurfaceHolder, this.this$0.getWidth(), this.this$0.getHeight());
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (SPlayerSurfaceView.access$000(this.this$0) != null) {
      SPlayerSurfaceView.access$000(this.this$0).onViewCreated(paramSurfaceHolder, this.this$0.getWidth(), this.this$0.getHeight());
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (SPlayerSurfaceView.access$000(this.this$0) != null) {
      SPlayerSurfaceView.access$000(this.this$0).onViewDestroyed(paramSurfaceHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */