import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

@TargetApi(14)
public class xsd
  implements xrt
{
  MediaPlayer a = new MediaPlayer();
  
  public int a()
  {
    return this.a.getDuration();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a.setVolume(paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt)
  {
    this.a.seekTo(paramInt);
  }
  
  public void a(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.a.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void a(Surface paramSurface)
  {
    this.a.setSurface(paramSurface);
  }
  
  public void a(xru paramxru)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxru == null) {}
    for (paramxru = null;; paramxru = new xsg(this, paramxru))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramxru);
      return;
    }
  }
  
  public void a(xrv paramxrv)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxrv == null) {}
    for (paramxrv = null;; paramxrv = new xsf(this, paramxrv))
    {
      localMediaPlayer.setOnCompletionListener(paramxrv);
      return;
    }
  }
  
  public void a(xrw paramxrw)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxrw == null) {}
    for (paramxrw = null;; paramxrw = new xsj(this, paramxrw))
    {
      localMediaPlayer.setOnErrorListener(paramxrw);
      return;
    }
  }
  
  public void a(xrx paramxrx)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxrx == null) {}
    for (paramxrx = null;; paramxrx = new xsk(this, paramxrx))
    {
      localMediaPlayer.setOnInfoListener(paramxrx);
      return;
    }
  }
  
  public void a(xry paramxry)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxry == null) {}
    for (paramxry = null;; paramxry = new xse(this, paramxry))
    {
      localMediaPlayer.setOnPreparedListener(paramxry);
      return;
    }
  }
  
  public void a(xrz paramxrz)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxrz == null) {}
    for (paramxrz = null;; paramxrz = new xsh(this, paramxrz))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramxrz);
      return;
    }
  }
  
  public void a(xsb paramxsb)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxsb == null) {}
    for (paramxsb = null;; paramxsb = new xsi(this, paramxsb))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramxsb);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setLooping(paramBoolean);
  }
  
  public boolean a()
  {
    return this.a.isPlaying();
  }
  
  public int b()
  {
    return this.a.getCurrentPosition();
  }
  
  public void b()
  {
    this.a.prepareAsync();
  }
  
  public void b(int paramInt)
  {
    this.a.setAudioSessionId(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public int c()
  {
    return this.a.getVideoWidth();
  }
  
  public void c()
  {
    this.a.start();
  }
  
  public void c(int paramInt)
  {
    this.a.setAudioStreamType(paramInt);
  }
  
  public int d()
  {
    return this.a.getVideoHeight();
  }
  
  public void d()
  {
    this.a.pause();
  }
  
  public int e()
  {
    return this.a.getAudioSessionId();
  }
  
  public void e()
  {
    this.a.stop();
  }
  
  public void f()
  {
    this.a.release();
  }
  
  public void g()
  {
    try
    {
      this.a.reset();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      bcrp.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsd
 * JD-Core Version:    0.7.0.1
 */