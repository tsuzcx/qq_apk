import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

@TargetApi(14)
public class xvy
  implements xvo
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
  
  public void a(xvp paramxvp)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxvp == null) {}
    for (paramxvp = null;; paramxvp = new xwb(this, paramxvp))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramxvp);
      return;
    }
  }
  
  public void a(xvq paramxvq)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxvq == null) {}
    for (paramxvq = null;; paramxvq = new xwa(this, paramxvq))
    {
      localMediaPlayer.setOnCompletionListener(paramxvq);
      return;
    }
  }
  
  public void a(xvr paramxvr)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxvr == null) {}
    for (paramxvr = null;; paramxvr = new xwe(this, paramxvr))
    {
      localMediaPlayer.setOnErrorListener(paramxvr);
      return;
    }
  }
  
  public void a(xvs paramxvs)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxvs == null) {}
    for (paramxvs = null;; paramxvs = new xwf(this, paramxvs))
    {
      localMediaPlayer.setOnInfoListener(paramxvs);
      return;
    }
  }
  
  public void a(xvt paramxvt)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxvt == null) {}
    for (paramxvt = null;; paramxvt = new xvz(this, paramxvt))
    {
      localMediaPlayer.setOnPreparedListener(paramxvt);
      return;
    }
  }
  
  public void a(xvu paramxvu)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxvu == null) {}
    for (paramxvu = null;; paramxvu = new xwc(this, paramxvu))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramxvu);
      return;
    }
  }
  
  public void a(xvw paramxvw)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramxvw == null) {}
    for (paramxvw = null;; paramxvw = new xwd(this, paramxvw))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramxvw);
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
      bdkh.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvy
 * JD-Core Version:    0.7.0.1
 */