import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

@TargetApi(14)
public class xme
  implements xlu
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
  
  public void a(xlv paramxlv)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxlv == null) {}
    for (paramxlv = null;; paramxlv = new xmh(this, paramxlv))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramxlv);
      return;
    }
  }
  
  public void a(xlw paramxlw)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxlw == null) {}
    for (paramxlw = null;; paramxlw = new xmg(this, paramxlw))
    {
      localMediaPlayer.setOnCompletionListener(paramxlw);
      return;
    }
  }
  
  public void a(xlx paramxlx)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxlx == null) {}
    for (paramxlx = null;; paramxlx = new xmk(this, paramxlx))
    {
      localMediaPlayer.setOnErrorListener(paramxlx);
      return;
    }
  }
  
  public void a(xly paramxly)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxly == null) {}
    for (paramxly = null;; paramxly = new xml(this, paramxly))
    {
      localMediaPlayer.setOnInfoListener(paramxly);
      return;
    }
  }
  
  public void a(xlz paramxlz)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxlz == null) {}
    for (paramxlz = null;; paramxlz = new xmf(this, paramxlz))
    {
      localMediaPlayer.setOnPreparedListener(paramxlz);
      return;
    }
  }
  
  public void a(xma paramxma)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxma == null) {}
    for (paramxma = null;; paramxma = new xmi(this, paramxma))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramxma);
      return;
    }
  }
  
  public void a(xmc paramxmc)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxmc == null) {}
    for (paramxmc = null;; paramxmc = new xmj(this, paramxmc))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramxmc);
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
      bdjw.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xme
 * JD-Core Version:    0.7.0.1
 */