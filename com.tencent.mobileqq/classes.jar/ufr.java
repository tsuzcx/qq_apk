import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

@TargetApi(14)
public class ufr
  implements ufh
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
  
  public void a(ufi paramufi)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufi == null) {}
    for (paramufi = null;; paramufi = new ufu(this, paramufi))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramufi);
      return;
    }
  }
  
  public void a(ufj paramufj)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufj == null) {}
    for (paramufj = null;; paramufj = new uft(this, paramufj))
    {
      localMediaPlayer.setOnCompletionListener(paramufj);
      return;
    }
  }
  
  public void a(ufk paramufk)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufk == null) {}
    for (paramufk = null;; paramufk = new ufx(this, paramufk))
    {
      localMediaPlayer.setOnErrorListener(paramufk);
      return;
    }
  }
  
  public void a(ufl paramufl)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufl == null) {}
    for (paramufl = null;; paramufl = new ufy(this, paramufl))
    {
      localMediaPlayer.setOnInfoListener(paramufl);
      return;
    }
  }
  
  public void a(ufm paramufm)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufm == null) {}
    for (paramufm = null;; paramufm = new ufs(this, paramufm))
    {
      localMediaPlayer.setOnPreparedListener(paramufm);
      return;
    }
  }
  
  public void a(ufn paramufn)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufn == null) {}
    for (paramufn = null;; paramufn = new ufv(this, paramufn))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramufn);
      return;
    }
  }
  
  public void a(ufp paramufp)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramufp == null) {}
    for (paramufp = null;; paramufp = new ufw(this, paramufp))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramufp);
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
      axpu.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufr
 * JD-Core Version:    0.7.0.1
 */