import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;
import java.io.IOException;

public class qlu
  extends qlv
{
  private AudioPlayback a;
  
  public qlu(qlx paramqlx, boolean paramBoolean, int paramInt, qlv.b paramb, AudioPlayback paramAudioPlayback)
    throws IOException
  {
    super(paramqlx, paramBoolean, paramInt, paramb);
    this.a = paramAudioPlayback;
    boY();
  }
  
  protected boolean JV()
  {
    if (!JX()) {
      return this.a.dM() < 200000L;
    }
    return super.JV();
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    super.a(paramMediaCodec, paramMediaFormat);
    this.a.a(paramMediaFormat);
  }
  
  public void a(qlv.a parama, long paramLong)
  {
    this.a.a(parama.data, parama.presentationTimeUs);
    b(parama);
  }
  
  protected void b(MediaFormat paramMediaFormat)
  {
    this.a.a(paramMediaFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlu
 * JD-Core Version:    0.7.0.1
 */