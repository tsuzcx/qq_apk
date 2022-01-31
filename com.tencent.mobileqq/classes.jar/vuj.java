import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

@TargetApi(14)
public class vuj
  implements vtz
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
  
  public void a(vua paramvua)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvua == null) {}
    for (paramvua = null;; paramvua = new vum(this, paramvua))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramvua);
      return;
    }
  }
  
  public void a(vub paramvub)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvub == null) {}
    for (paramvub = null;; paramvub = new vul(this, paramvub))
    {
      localMediaPlayer.setOnCompletionListener(paramvub);
      return;
    }
  }
  
  public void a(vuc paramvuc)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvuc == null) {}
    for (paramvuc = null;; paramvuc = new vup(this, paramvuc))
    {
      localMediaPlayer.setOnErrorListener(paramvuc);
      return;
    }
  }
  
  public void a(vud paramvud)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvud == null) {}
    for (paramvud = null;; paramvud = new vuq(this, paramvud))
    {
      localMediaPlayer.setOnInfoListener(paramvud);
      return;
    }
  }
  
  public void a(vue paramvue)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvue == null) {}
    for (paramvue = null;; paramvue = new vuk(this, paramvue))
    {
      localMediaPlayer.setOnPreparedListener(paramvue);
      return;
    }
  }
  
  public void a(vuf paramvuf)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvuf == null) {}
    for (paramvuf = null;; paramvuf = new vun(this, paramvuf))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramvuf);
      return;
    }
  }
  
  public void a(vuh paramvuh)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramvuh == null) {}
    for (paramvuh = null;; paramvuh = new vuo(this, paramvuh))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramvuh);
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
      azlf.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vuj
 * JD-Core Version:    0.7.0.1
 */