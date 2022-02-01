package io.flutter.embedding.android;

import android.support.annotation.NonNull;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import io.flutter.Log;

class FlutterSurfaceView$1
  implements SurfaceHolder.Callback
{
  FlutterSurfaceView$1(FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void surfaceChanged(@NonNull SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.v("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
    if (FlutterSurfaceView.access$100(this.this$0)) {
      FlutterSurfaceView.access$300(this.this$0, paramInt2, paramInt3);
    }
  }
  
  public void surfaceCreated(@NonNull SurfaceHolder paramSurfaceHolder)
  {
    Log.v("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceCreated()");
    FlutterSurfaceView.access$002(this.this$0, true);
    if (FlutterSurfaceView.access$100(this.this$0)) {
      FlutterSurfaceView.access$200(this.this$0);
    }
  }
  
  public void surfaceDestroyed(@NonNull SurfaceHolder paramSurfaceHolder)
  {
    Log.v("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceDestroyed()");
    FlutterSurfaceView.access$002(this.this$0, false);
    if (FlutterSurfaceView.access$100(this.this$0)) {
      FlutterSurfaceView.access$400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */