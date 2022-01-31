import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;

public class uex
  extends uey
{
  private AudioPlayback a;
  
  public uex(ufc paramufc, boolean paramBoolean, int paramInt, ufa paramufa, AudioPlayback paramAudioPlayback)
  {
    super(paramufc, paramBoolean, paramInt, paramufa);
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
  
  public void a(uez paramuez, long paramLong)
  {
    this.a.a(paramuez.jdField_a_of_type_JavaNioByteBuffer, paramuez.jdField_a_of_type_Long);
    b(paramuez);
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
 * Qualified Name:     uex
 * JD-Core Version:    0.7.0.1
 */