import android.graphics.SurfaceTexture;
import com.tencent.qg.video.videodecoder.MediaDecoder.a;

class asgq
  implements MediaDecoder.a
{
  asgq(asgp paramasgp) {}
  
  public void fp(long paramLong)
  {
    if (asgp.a(this.a) == 0)
    {
      asgr.aP(this.a.hashCode(), "[Player] on video decode first frame");
      asgp.a(this.a, 1);
    }
  }
  
  public void onDecodeCancel()
  {
    ram.w("DefaultMediaPlayer", "decoder -> onDecodeCancel");
    asgp.a(this.a);
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    ram.w("DefaultMediaPlayer", "decoder -> onDecodeError :%d , %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
  }
  
  public void onDecodeFinish()
  {
    ram.w("DefaultMediaPlayer", "decoder -> onDecodeFinish");
    asgp.a(this.a);
  }
  
  public void onDecodeRepeat()
  {
    ram.w("DefaultMediaPlayer", "decoder -> onDecodeRepeat");
    asgp.a(this.a);
    asgp.b(this.a);
  }
  
  public void onDecodeSeekTo(long paramLong)
  {
    ram.w("DefaultMediaPlayer", "decoder -> onDecodeSeekTo :%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void onDecodeStart()
  {
    ram.d("DefaultMediaPlayer", "decoder -> onDecodeStart");
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    asgp.a(this.a, paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgq
 * JD-Core Version:    0.7.0.1
 */