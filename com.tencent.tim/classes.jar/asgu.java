import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;

@TargetApi(16)
public class asgu
  extends asgt
{
  private Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  public int mTextureId;
  
  public asgu(asgt.b paramb, asgt.a parama, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    super(paramb, parama);
    this.mTextureId = paramInt;
    this.mSurfaceTexture = new SurfaceTexture(paramInt);
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.mSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
  }
  
  protected String DQ()
  {
    return "Q.qqstory.mediadecoderMediaCodecVideoRender";
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    boolean bool = true;
    int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((paramBufferInfo.flags & 0x4) != 0)
      {
        ram.d("Q.qqstory.mediadecoderMediaCodecVideoRender", "output EOS");
        this.der = true;
      }
      if (paramBufferInfo.size == 0) {
        break;
      }
    }
    for (;;)
    {
      paramMediaCodec.releaseOutputBuffer(i, bool);
      ram.d("Q.qqstory.mediadecoderMediaCodecVideoRender", "dequeueOutputBuffer render");
      return;
      ram.d("Q.qqstory.mediadecoderMediaCodecVideoRender", "INFO_OUTPUT_BUFFERS_CHANGED");
      this.mOutputBuffers = paramMediaCodec.getOutputBuffers();
      return;
      ram.d("Q.qqstory.mediadecoderMediaCodecVideoRender", "New format " + this.mMediaCodec.getOutputFormat());
      return;
      ram.d("Q.qqstory.mediadecoderMediaCodecVideoRender", "dequeueOutputBuffer timed out!");
      return;
      bool = false;
    }
  }
  
  protected void a(asgt.a parama, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, this.mSurface, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgu
 * JD-Core Version:    0.7.0.1
 */