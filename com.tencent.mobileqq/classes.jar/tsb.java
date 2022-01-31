import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;

public class tsb
  extends tsc
{
  private AudioPlayback a;
  
  public tsb(tsg paramtsg, boolean paramBoolean, int paramInt, tse paramtse, AudioPlayback paramAudioPlayback)
  {
    super(paramtsg, paramBoolean, paramInt, paramtse);
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
  
  public void a(tsd paramtsd, long paramLong)
  {
    this.a.a(paramtsd.jdField_a_of_type_JavaNioByteBuffer, paramtsd.jdField_a_of_type_Long);
    b(paramtsd);
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
 * Qualified Name:     tsb
 * JD-Core Version:    0.7.0.1
 */