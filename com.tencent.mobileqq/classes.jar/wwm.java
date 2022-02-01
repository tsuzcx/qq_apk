import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;

public class wwm
  extends wwn
{
  private AudioPlayback a;
  
  public wwm(wwr paramwwr, boolean paramBoolean, int paramInt, wwp paramwwp, AudioPlayback paramAudioPlayback)
  {
    super(paramwwr, paramBoolean, paramInt, paramwwp);
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
  
  public void a(wwo paramwwo, long paramLong)
  {
    this.a.a(paramwwo.jdField_a_of_type_JavaNioByteBuffer, paramwwo.jdField_a_of_type_Long);
    b(paramwwo);
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
 * Qualified Name:     wwm
 * JD-Core Version:    0.7.0.1
 */