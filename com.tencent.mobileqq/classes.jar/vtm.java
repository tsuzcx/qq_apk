import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback;

public class vtm
  extends vtn
{
  private AudioPlayback a;
  
  public vtm(vtr paramvtr, boolean paramBoolean, int paramInt, vtp paramvtp, AudioPlayback paramAudioPlayback)
  {
    super(paramvtr, paramBoolean, paramInt, paramvtp);
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
  
  public void a(vto paramvto, long paramLong)
  {
    this.a.a(paramvto.jdField_a_of_type_JavaNioByteBuffer, paramvto.jdField_a_of_type_Long);
    b(paramvto);
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
 * Qualified Name:     vtm
 * JD-Core Version:    0.7.0.1
 */