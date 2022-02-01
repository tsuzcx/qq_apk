import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;

@TargetApi(14)
public class alzb
{
  public Surface surface;
  public SurfaceTexture surfaceTexture;
  public int textureId;
  
  public alzb(int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    this.textureId = paramInt;
    this.surfaceTexture = new SurfaceTexture(paramInt);
    this.surfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    this.surface = new Surface(this.surfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzb
 * JD-Core Version:    0.7.0.1
 */