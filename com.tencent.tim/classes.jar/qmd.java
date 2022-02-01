import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.util.Map;

@TargetApi(14)
public class qmd
  implements qmc
{
  MediaPlayer mMediaPlayer = new MediaPlayer();
  
  public void a(qmc.a parama)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (parama == null) {}
    for (parama = null;; parama = new qmg(this, parama))
    {
      localMediaPlayer.setOnBufferingUpdateListener(parama);
      return;
    }
  }
  
  public void a(qmc.h paramh)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (paramh == null) {}
    for (paramh = null;; paramh = new qmi(this, paramh))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramh);
      return;
    }
  }
  
  public int getAudioSessionId()
  {
    return this.mMediaPlayer.getAudioSessionId();
  }
  
  public int getCurrentPosition()
  {
    return this.mMediaPlayer.getCurrentPosition();
  }
  
  public int getDuration()
  {
    return this.mMediaPlayer.getDuration();
  }
  
  public int getVideoHeight()
  {
    return this.mMediaPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.mMediaPlayer.getVideoWidth();
  }
  
  public boolean isPlaying()
  {
    return this.mMediaPlayer.isPlaying();
  }
  
  public void pause()
    throws IllegalStateException
  {
    this.mMediaPlayer.pause();
  }
  
  public void prepareAsync()
    throws IllegalStateException
  {
    this.mMediaPlayer.prepareAsync();
  }
  
  public void release()
  {
    this.mMediaPlayer.release();
  }
  
  public void reset()
  {
    try
    {
      this.mMediaPlayer.reset();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      annt.e(localIllegalStateException);
    }
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    this.mMediaPlayer.seekTo(paramInt);
  }
  
  public void setAudioSessionId(int paramInt)
    throws IllegalArgumentException, IllegalStateException
  {
    this.mMediaPlayer.setAudioSessionId(paramInt);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.mMediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mMediaPlayer.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.mMediaPlayer.setLooping(paramBoolean);
  }
  
  public void setOnCompletionListener(qmc.b paramb)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (paramb == null) {}
    for (paramb = null;; paramb = new qmf(this, paramb))
    {
      localMediaPlayer.setOnCompletionListener(paramb);
      return;
    }
  }
  
  public void setOnErrorListener(qmc.c paramc)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (paramc == null) {}
    for (paramc = null;; paramc = new qmj(this, paramc))
    {
      localMediaPlayer.setOnErrorListener(paramc);
      return;
    }
  }
  
  public void setOnInfoListener(qmc.d paramd)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (paramd == null) {}
    for (paramd = null;; paramd = new qmk(this, paramd))
    {
      localMediaPlayer.setOnInfoListener(paramd);
      return;
    }
  }
  
  public void setOnPreparedListener(qmc.e parame)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (parame == null) {}
    for (parame = null;; parame = new qme(this, parame))
    {
      localMediaPlayer.setOnPreparedListener(parame);
      return;
    }
  }
  
  public void setOnSeekCompleteListener(qmc.f paramf)
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (paramf == null) {}
    for (paramf = null;; paramf = new qmh(this, paramf))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramf);
      return;
    }
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.mMediaPlayer.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mMediaPlayer.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.mMediaPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void start()
    throws IllegalStateException
  {
    this.mMediaPlayer.start();
  }
  
  public void stop()
    throws IllegalStateException
  {
    this.mMediaPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmd
 * JD-Core Version:    0.7.0.1
 */