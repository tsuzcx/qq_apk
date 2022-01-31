import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

@TargetApi(14)
public class vys
  implements vyi
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
  
  public void a(vyj paramvyj)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvyj == null) {}
    for (paramvyj = null;; paramvyj = new vyv(this, paramvyj))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramvyj);
      return;
    }
  }
  
  public void a(vyk paramvyk)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvyk == null) {}
    for (paramvyk = null;; paramvyk = new vyu(this, paramvyk))
    {
      localMediaPlayer.setOnCompletionListener(paramvyk);
      return;
    }
  }
  
  public void a(vyl paramvyl)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvyl == null) {}
    for (paramvyl = null;; paramvyl = new vyy(this, paramvyl))
    {
      localMediaPlayer.setOnErrorListener(paramvyl);
      return;
    }
  }
  
  public void a(vym paramvym)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvym == null) {}
    for (paramvym = null;; paramvym = new vyz(this, paramvym))
    {
      localMediaPlayer.setOnInfoListener(paramvym);
      return;
    }
  }
  
  public void a(vyn paramvyn)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvyn == null) {}
    for (paramvyn = null;; paramvyn = new vyt(this, paramvyn))
    {
      localMediaPlayer.setOnPreparedListener(paramvyn);
      return;
    }
  }
  
  public void a(vyo paramvyo)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvyo == null) {}
    for (paramvyo = null;; paramvyo = new vyw(this, paramvyo))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramvyo);
      return;
    }
  }
  
  public void a(vyq paramvyq)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvyq == null) {}
    for (paramvyq = null;; paramvyq = new vyx(this, paramvyq))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramvyq);
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
      azpo.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vys
 * JD-Core Version:    0.7.0.1
 */