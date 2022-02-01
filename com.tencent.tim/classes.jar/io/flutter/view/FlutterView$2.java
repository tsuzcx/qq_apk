package io.flutter.view;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import io.flutter.embedding.engine.FlutterJNI;

class FlutterView$2
  implements SurfaceHolder.Callback
{
  FlutterView$2(FlutterView paramFlutterView) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.assertAttached();
    FlutterView.access$100(this.this$0).getFlutterJNI().onSurfaceChanged(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.this$0.assertAttached();
    FlutterView.access$100(this.this$0).getFlutterJNI().onSurfaceCreated(paramSurfaceHolder.getSurface());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.this$0.assertAttached();
    FlutterView.access$100(this.this$0).getFlutterJNI().onSurfaceDestroyed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.FlutterView.2
 * JD-Core Version:    0.7.0.1
 */