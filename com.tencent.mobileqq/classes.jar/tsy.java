import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

@TargetApi(14)
public class tsy
  implements tso
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
  
  public void a(tsp paramtsp)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramtsp == null) {}
    for (paramtsp = null;; paramtsp = new ttb(this, paramtsp))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramtsp);
      return;
    }
  }
  
  public void a(tsq paramtsq)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramtsq == null) {}
    for (paramtsq = null;; paramtsq = new tta(this, paramtsq))
    {
      localMediaPlayer.setOnCompletionListener(paramtsq);
      return;
    }
  }
  
  public void a(tsr paramtsr)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramtsr == null) {}
    for (paramtsr = null;; paramtsr = new tte(this, paramtsr))
    {
      localMediaPlayer.setOnErrorListener(paramtsr);
      return;
    }
  }
  
  public void a(tss paramtss)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramtss == null) {}
    for (paramtss = null;; paramtss = new ttf(this, paramtss))
    {
      localMediaPlayer.setOnInfoListener(paramtss);
      return;
    }
  }
  
  public void a(tst paramtst)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramtst == null) {}
    for (paramtst = null;; paramtst = new tsz(this, paramtst))
    {
      localMediaPlayer.setOnPreparedListener(paramtst);
      return;
    }
  }
  
  public void a(tsu paramtsu)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramtsu == null) {}
    for (paramtsu = null;; paramtsu = new ttc(this, paramtsu))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramtsu);
      return;
    }
  }
  
  public void a(tsw paramtsw)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramtsw == null) {}
    for (paramtsw = null;; paramtsw = new ttd(this, paramtsw))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramtsw);
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
      awpu.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsy
 * JD-Core Version:    0.7.0.1
 */