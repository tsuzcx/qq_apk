package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import io.flutter.embedding.engine.FlutterJNI;

class FlutterView$SurfaceTextureRegistryEntry$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  FlutterView$SurfaceTextureRegistryEntry$1(FlutterView.SurfaceTextureRegistryEntry paramSurfaceTextureRegistryEntry) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((FlutterView.SurfaceTextureRegistryEntry.access$200(this.this$1)) || (FlutterView.access$100(this.this$1.this$0) == null)) {
      return;
    }
    FlutterView.access$100(this.this$1.this$0).getFlutterJNI().markTextureFrameAvailable(FlutterView.SurfaceTextureRegistryEntry.access$300(this.this$1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.FlutterView.SurfaceTextureRegistryEntry.1
 * JD-Core Version:    0.7.0.1
 */