import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.oskplayer.player.OskExoMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnLoopStartListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnVideoSizeChangedListener;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

public class asvx
  implements ReliableVideoPlayer
{
  private OskExoMediaPlayer b = new OskExoMediaPlayer();
  
  public int getAudioSessionId()
  {
    return this.b.getAudioSessionId();
  }
  
  public long getCurrentPosition()
  {
    return this.b.getCurrentPosition();
  }
  
  public String getDataSource()
  {
    return this.b.getDataSource();
  }
  
  public long getDuration()
  {
    return this.b.getDuration();
  }
  
  public int getScore()
  {
    return this.b.getScore();
  }
  
  public int getVideoHeight()
  {
    return this.b.getVideoHeight();
  }
  
  public int getVideoSarDen()
  {
    return this.b.getVideoSarDen();
  }
  
  public int getVideoSarNum()
  {
    return this.b.getVideoSarNum();
  }
  
  public int getVideoWidth()
  {
    return this.b.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    return this.b.isLooping();
  }
  
  public boolean isPlayable()
  {
    return this.b.isPlayable();
  }
  
  public boolean isPlaying()
  {
    return this.b.isPlaying();
  }
  
  public void pause()
    throws Exception
  {
    this.b.pause();
  }
  
  public void prepareAsync()
    throws IllegalStateException
  {
    this.b.prepareAsync();
  }
  
  public void release()
  {
    this.b.release();
  }
  
  public void reset()
  {
    this.b.reset();
  }
  
  public void seekTo(long paramLong)
    throws IllegalStateException
  {
    this.b.seekTo(paramLong);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.b.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException
  {
    this.b.setDataSource(paramContext, paramUri);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException
  {
    this.b.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
    throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException
  {
    this.b.setDataSource(paramFileDescriptor);
  }
  
  public void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException
  {
    this.b.setDataSource(paramString);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.b.setDisplay(paramSurfaceHolder);
  }
  
  public void setKeepInBackground(boolean paramBoolean)
  {
    this.b.setKeepInBackground(paramBoolean);
  }
  
  public void setLogEnabled(boolean paramBoolean)
  {
    this.b.setLogEnabled(paramBoolean);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.b.setLooping(paramBoolean);
  }
  
  public void setNextMediaPlayer(ReliableVideoPlayer paramReliableVideoPlayer)
    throws UnsupportedOperationException
  {
    if ((paramReliableVideoPlayer instanceof asvx)) {
      this.b.setNextMediaPlayer(((asvx)paramReliableVideoPlayer).b);
    }
  }
  
  public void setOnBufferingUpdateListener(ReliableVideoPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.b.setOnBufferingUpdateListener(new aswb(this, paramOnBufferingUpdateListener));
  }
  
  public void setOnCompletionListener(ReliableVideoPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.b.setOnCompletionListener(new aswa(this, paramOnCompletionListener));
  }
  
  public void setOnErrorListener(ReliableVideoPlayer.OnErrorListener paramOnErrorListener)
  {
    this.b.setOnErrorListener(new aswe(this, paramOnErrorListener));
  }
  
  public void setOnInfoListener(ReliableVideoPlayer.OnInfoListener paramOnInfoListener)
  {
    this.b.setOnInfoListener(new aswf(this, paramOnInfoListener));
  }
  
  public void setOnLoopStartListener(ReliableVideoPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    this.b.setOnLoopStartListener(new asvy(this, paramOnLoopStartListener));
  }
  
  public void setOnPreparedListener(ReliableVideoPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.b.setOnPreparedListener(new asvz(this, paramOnPreparedListener));
  }
  
  public void setOnSeekCompleteListener(ReliableVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.b.setOnSeekCompleteListener(new aswc(this, paramOnSeekCompleteListener));
  }
  
  public void setOnVideoSizeChangedListener(ReliableVideoPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.b.setOnVideoSizeChangedListener(new aswd(this, paramOnVideoSizeChangedListener));
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.b.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.b.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.b.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.b.setWakeMode(paramContext, paramInt);
  }
  
  public void start()
    throws Exception
  {
    this.b.start();
  }
  
  public void stop()
    throws IllegalStateException
  {
    this.b.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvx
 * JD-Core Version:    0.7.0.1
 */