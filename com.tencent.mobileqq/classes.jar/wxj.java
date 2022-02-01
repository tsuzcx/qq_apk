import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

@TargetApi(14)
public class wxj
  implements wwz
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
  
  public void a(wxa paramwxa)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramwxa == null) {}
    for (paramwxa = null;; paramwxa = new wxm(this, paramwxa))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramwxa);
      return;
    }
  }
  
  public void a(wxb paramwxb)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramwxb == null) {}
    for (paramwxb = null;; paramwxb = new wxl(this, paramwxb))
    {
      localMediaPlayer.setOnCompletionListener(paramwxb);
      return;
    }
  }
  
  public void a(wxc paramwxc)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramwxc == null) {}
    for (paramwxc = null;; paramwxc = new wxp(this, paramwxc))
    {
      localMediaPlayer.setOnErrorListener(paramwxc);
      return;
    }
  }
  
  public void a(wxd paramwxd)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramwxd == null) {}
    for (paramwxd = null;; paramwxd = new wxq(this, paramwxd))
    {
      localMediaPlayer.setOnInfoListener(paramwxd);
      return;
    }
  }
  
  public void a(wxe paramwxe)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramwxe == null) {}
    for (paramwxe = null;; paramwxe = new wxk(this, paramwxe))
    {
      localMediaPlayer.setOnPreparedListener(paramwxe);
      return;
    }
  }
  
  public void a(wxf paramwxf)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramwxf == null) {}
    for (paramwxf = null;; paramwxf = new wxn(this, paramwxf))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramwxf);
      return;
    }
  }
  
  public void a(wxh paramwxh)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramwxh == null) {}
    for (paramwxh = null;; paramwxh = new wxo(this, paramwxh))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramwxh);
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
      bcdb.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxj
 * JD-Core Version:    0.7.0.1
 */