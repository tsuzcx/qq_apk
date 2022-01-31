import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;

public class ueu
  extends uev
{
  private AudioPlayback a;
  
  public ueu(uez paramuez, boolean paramBoolean, int paramInt, uex paramuex, AudioPlayback paramAudioPlayback)
  {
    super(paramuez, paramBoolean, paramInt, paramuex);
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
  
  public void a(uew paramuew, long paramLong)
  {
    this.a.a(paramuew.jdField_a_of_type_JavaNioByteBuffer, paramuew.jdField_a_of_type_Long);
    b(paramuew);
  }
  
  protected boolean a()
  {
    if (!c()) {
      return this.a.a() < 200000L;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ueu
 * JD-Core Version:    0.7.0.1
 */