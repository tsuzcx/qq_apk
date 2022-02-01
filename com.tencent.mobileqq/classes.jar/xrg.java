import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;

public class xrg
  extends xrh
{
  private AudioPlayback a;
  
  public xrg(xrl paramxrl, boolean paramBoolean, int paramInt, xrj paramxrj, AudioPlayback paramAudioPlayback)
  {
    super(paramxrl, paramBoolean, paramInt, paramxrj);
    this.a = paramAudioPlayback;
    a();
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    super.a(paramMediaCodec, paramMediaFormat);
    this.a.a(paramMediaFormat);
  }
  
  protected void a(MediaFormat paramMediaFormat)
  {
    this.a.a(paramMediaFormat);
  }
  
  public void a(xri paramxri, long paramLong)
  {
    this.a.a(paramxri.jdField_a_of_type_JavaNioByteBuffer, paramxri.jdField_a_of_type_Long);
    b(paramxri);
  }
  
  protected boolean a()
  {
    if (!c()) {
      return this.a.a() < 200000L;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrg
 * JD-Core Version:    0.7.0.1
 */