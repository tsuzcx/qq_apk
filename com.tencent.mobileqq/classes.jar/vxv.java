import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;

public class vxv
  extends vxw
{
  private AudioPlayback a;
  
  public vxv(vya paramvya, boolean paramBoolean, int paramInt, vxy paramvxy, AudioPlayback paramAudioPlayback)
  {
    super(paramvya, paramBoolean, paramInt, paramvxy);
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
  
  public void a(vxx paramvxx, long paramLong)
  {
    this.a.a(paramvxx.jdField_a_of_type_JavaNioByteBuffer, paramvxx.jdField_a_of_type_Long);
    b(paramvxx);
  }
  
  protected boolean a()
  {
    if (!c()) {
      return this.a.a() < 200000L;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxv
 * JD-Core Version:    0.7.0.1
 */