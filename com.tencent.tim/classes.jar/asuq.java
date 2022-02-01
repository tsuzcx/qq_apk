import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.oskplayer.player.OskExoMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnLoopStartListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnVideoSizeChangedListener;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IMediaPlayer.InternalOperationException;

public class asuq
  implements IMediaPlayer
{
  OskExoMediaPlayer a = new OskExoMediaPlayer();
  
  public long getCurrentPosition()
  {
    return this.a.getCurrentPosition();
  }
  
  public long getDuration()
  {
    return this.a.getDuration();
  }
  
  public int getVideoHeight()
  {
    return this.a.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.a.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    return this.a.isLooping();
  }
  
  public boolean isPlaying()
  {
    return this.a.isPlaying();
  }
  
  public void pause()
    throws IllegalStateException
  {
    try
    {
      this.a.pause();
      return;
    }
    catch (IMediaPlayer.InternalOperationException localInternalOperationException)
    {
      throw new IllegalStateException(localInternalOperationException);
    }
  }
  
  public void prepareAsync()
    throws IllegalStateException
  {
    this.a.prepareAsync();
  }
  
  public void release()
  {
    this.a.release();
  }
  
  public void reset()
  {
    this.a.reset();
  }
  
  public void seekTo(long paramLong)
    throws IllegalStateException
  {
    this.a.seekTo(paramLong);
  }
  
  public void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException
  {
    this.a.setDataSource(paramString);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.a.setDisplay(paramSurfaceHolder);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.a.setLooping(paramBoolean);
  }
  
  public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.a.setOnBufferingUpdateListener(new asut(this, paramOnBufferingUpdateListener));
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.a.setOnCompletionListener(new asus(this, paramOnCompletionListener));
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.a.setOnErrorListener(new asuw(this, paramOnErrorListener));
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.a.setOnInfoListener(new asux(this, paramOnInfoListener));
  }
  
  public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    this.a.setOnLoopStartListener(new asuy(this, paramOnLoopStartListener));
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.a.setOnPreparedListener(new asur(this, paramOnPreparedListener));
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.a.setOnSeekCompleteListener(new asuu(this, paramOnSeekCompleteListener));
  }
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.a.setOnVideoSizeChangedListener(new asuv(this, paramOnVideoSizeChangedListener));
  }
  
  public void setRate(float paramFloat)
  {
    this.a.setRate(paramFloat);
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.a.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.a.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.a.setVolume(paramFloat1, paramFloat2);
  }
  
  public void start()
    throws IllegalStateException
  {
    try
    {
      this.a.start();
      return;
    }
    catch (IMediaPlayer.InternalOperationException localInternalOperationException)
    {
      throw new IllegalStateException(localInternalOperationException);
    }
  }
  
  public void stop()
    throws IllegalStateException
  {
    this.a.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asuq
 * JD-Core Version:    0.7.0.1
 */