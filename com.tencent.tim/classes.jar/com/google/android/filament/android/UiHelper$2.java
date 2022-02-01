package com.google.android.filament.android;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;

class UiHelper$2
  implements TextureView.SurfaceTextureListener
{
  UiHelper$2(UiHelper paramUiHelper) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if ((Build.VERSION.SDK_INT >= 15) && (UiHelper.access$300(this.this$0) > 0) && (UiHelper.access$400(this.this$0) > 0)) {
      paramSurfaceTexture.setDefaultBufferSize(UiHelper.access$300(this.this$0), UiHelper.access$400(this.this$0));
    }
    paramSurfaceTexture = new Surface(paramSurfaceTexture);
    ((UiHelper.TextureViewHandler)UiHelper.access$500(this.this$0)).setSurface(paramSurfaceTexture);
    UiHelper.access$100(this.this$0, paramSurfaceTexture);
    UiHelper.access$000(this.this$0).onResized(paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    UiHelper.access$200(this.this$0);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    UiHelper.access$000(this.this$0).onResized(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.android.UiHelper.2
 * JD-Core Version:    0.7.0.1
 */