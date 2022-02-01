import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.qg.video.videodecoder.MediaDecoder;
import com.tencent.qg.video.videodecoder.MediaDecoder.a;

public class asgv
  implements SurfaceTexture.OnFrameAvailableListener
{
  public asgv(MediaDecoder paramMediaDecoder, MediaDecoder.a parama) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.c.onFrameAvailable(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgv
 * JD-Core Version:    0.7.0.1
 */