import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

@TargetApi(14)
public class aniw
  extends PreviewContext
  implements TextureView.SurfaceTextureListener, anim.d
{
  public aniw(anim paramanim, int paramInt1, int paramInt2)
  {
    super(paramanim, paramInt1, paramInt2);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    getPreviewFrame(paramArrayOfByte, paramCamera);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mCamera.dQj();
    this.mCamera.bb(0, paramInt1, paramInt2);
    this.mCamera.a(paramSurfaceTexture, null, this, true);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mCamera != null)
    {
      this.mCamera.dQk();
      this.mCamera.PR(true);
      if (this.mActivtiyDestory) {
        this.mCamera = null;
      }
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aniw
 * JD-Core Version:    0.7.0.1
 */