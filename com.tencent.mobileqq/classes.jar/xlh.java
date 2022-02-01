import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;

public class xlh
  extends xli
{
  private AudioPlayback a;
  
  public xlh(xlm paramxlm, boolean paramBoolean, int paramInt, xlk paramxlk, AudioPlayback paramAudioPlayback)
  {
    super(paramxlm, paramBoolean, paramInt, paramxlk);
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
  
  public void a(xlj paramxlj, long paramLong)
  {
    this.a.a(paramxlj.jdField_a_of_type_JavaNioByteBuffer, paramxlj.jdField_a_of_type_Long);
    b(paramxlj);
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
 * Qualified Name:     xlh
 * JD-Core Version:    0.7.0.1
 */