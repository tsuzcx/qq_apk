import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

@TargetApi(14)
public class ufu
  implements ufk
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
  
  public void a(ufl paramufl)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufl == null) {}
    for (paramufl = null;; paramufl = new ufx(this, paramufl))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramufl);
      return;
    }
  }
  
  public void a(ufm paramufm)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufm == null) {}
    for (paramufm = null;; paramufm = new ufw(this, paramufm))
    {
      localMediaPlayer.setOnCompletionListener(paramufm);
      return;
    }
  }
  
  public void a(ufn paramufn)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufn == null) {}
    for (paramufn = null;; paramufn = new uga(this, paramufn))
    {
      localMediaPlayer.setOnErrorListener(paramufn);
      return;
    }
  }
  
  public void a(ufo paramufo)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufo == null) {}
    for (paramufo = null;; paramufo = new ugb(this, paramufo))
    {
      localMediaPlayer.setOnInfoListener(paramufo);
      return;
    }
  }
  
  public void a(ufp paramufp)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufp == null) {}
    for (paramufp = null;; paramufp = new ufv(this, paramufp))
    {
      localMediaPlayer.setOnPreparedListener(paramufp);
      return;
    }
  }
  
  public void a(ufq paramufq)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufq == null) {}
    for (paramufq = null;; paramufq = new ufy(this, paramufq))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramufq);
      return;
    }
  }
  
  public void a(ufs paramufs)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufs == null) {}
    for (paramufs = null;; paramufs = new ufz(this, paramufs))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramufs);
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
      axps.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufu
 * JD-Core Version:    0.7.0.1
 */