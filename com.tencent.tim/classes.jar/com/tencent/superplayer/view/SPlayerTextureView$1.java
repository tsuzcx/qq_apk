package com.tencent.superplayer.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.superplayer.utils.LogUtil;

class SPlayerTextureView$1
  implements TextureView.SurfaceTextureListener
{
  SPlayerTextureView$1(SPlayerTextureView paramSPlayerTextureView) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    LogUtil.i(SPlayerTextureView.access$000(this.this$0), "SPlayerTextureView = " + System.identityHashCode(this.this$0) + ", onSurfaceTextureAvailable() surface = " + paramSurfaceTexture.toString() + " width = " + paramInt1 + ", height=" + paramInt2);
    if (SPlayerTextureView.access$100(this.this$0) != null) {
      SPlayerTextureView.access$100(this.this$0).onViewCreated(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    String str2 = SPlayerTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder().append("SPlayerTextureView = ").append(System.identityHashCode(this.this$0)).append(", onSurfaceTextureDestroyed() surface = ");
    if (paramSurfaceTexture != null) {}
    for (String str1 = paramSurfaceTexture.toString();; str1 = "null")
    {
      LogUtil.i(str2, str1);
      if ((SPlayerTextureView.access$100(this.this$0) != null) && (!SPlayerTextureView.access$100(this.this$0).onViewDestroyed(paramSurfaceTexture))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    LogUtil.i(SPlayerTextureView.access$000(this.this$0), "SPlayerTextureView = " + System.identityHashCode(this.this$0) + ", onSurfaceTextureSizeChanged() surface = " + paramSurfaceTexture.toString() + " width = " + paramInt1 + ", height=" + paramInt2);
    if (SPlayerTextureView.access$100(this.this$0) != null) {
      SPlayerTextureView.access$100(this.this$0).onViewChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (SPlayerTextureView.access$100(this.this$0) != null) {
      SPlayerTextureView.access$100(this.this$0).onViewChanged(paramSurfaceTexture, this.this$0.getWidth(), this.this$0.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerTextureView.1
 * JD-Core Version:    0.7.0.1
 */