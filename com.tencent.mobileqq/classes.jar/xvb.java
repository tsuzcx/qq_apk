import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;

public class xvb
  extends xvc
{
  private AudioPlayback a;
  
  public xvb(xvg paramxvg, boolean paramBoolean, int paramInt, xve paramxve, AudioPlayback paramAudioPlayback)
  {
    super(paramxvg, paramBoolean, paramInt, paramxve);
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
  
  public void a(xvd paramxvd, long paramLong)
  {
    this.a.a(paramxvd.jdField_a_of_type_JavaNioByteBuffer, paramxvd.jdField_a_of_type_Long);
    b(paramxvd);
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
 * Qualified Name:     xvb
 * JD-Core Version:    0.7.0.1
 */