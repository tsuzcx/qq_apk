package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class MediaPlayerProxy
  implements IMediaPlayer
{
  protected final IMediaPlayer mBackEndMediaPlayer;
  private volatile boolean mIsReleased;
  
  public MediaPlayerProxy(IMediaPlayer paramIMediaPlayer)
  {
    this.mBackEndMediaPlayer = paramIMediaPlayer;
  }
  
  public int getAudioSessionId()
  {
    return this.mBackEndMediaPlayer.getAudioSessionId();
  }
  
  public long getCurrentPosition()
  {
    return this.mBackEndMediaPlayer.getCurrentPosition();
  }
  
  public String getDataSource()
  {
    return this.mBackEndMediaPlayer.getDataSource();
  }
  
  public long getDuration()
  {
    return this.mBackEndMediaPlayer.getDuration();
  }
  
  public IMediaPlayer getInternalMediaPlayer()
  {
    return this.mBackEndMediaPlayer;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.mBackEndMediaPlayer.getMediaInfo();
  }
  
  public int getScore()
  {
    return this.mBackEndMediaPlayer.getScore();
  }
  
  public ITrackInfo[] getTrackInfo()
  {
    return this.mBackEndMediaPlayer.getTrackInfo();
  }
  
  public int getVideoHeight()
  {
    return this.mBackEndMediaPlayer.getVideoHeight();
  }
  
  public int getVideoSarDen()
  {
    return this.mBackEndMediaPlayer.getVideoSarDen();
  }
  
  public int getVideoSarNum()
  {
    return this.mBackEndMediaPlayer.getVideoSarNum();
  }
  
  public int getVideoWidth()
  {
    return this.mBackEndMediaPlayer.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    return this.mBackEndMediaPlayer.isLooping();
  }
  
  public boolean isPlayable()
  {
    return false;
  }
  
  public boolean isPlaying()
  {
    return this.mBackEndMediaPlayer.isPlaying();
  }
  
  public void pause()
    throws IllegalStateException, IMediaPlayer.InternalOperationException
  {
    this.mBackEndMediaPlayer.pause();
  }
  
  public void prepareAsync()
    throws IllegalStateException
  {
    this.mBackEndMediaPlayer.prepareAsync();
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	tv/danmaku/ijk/media/player/MediaPlayerProxy:mIsReleased	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 17	tv/danmaku/ijk/media/player/MediaPlayerProxy:mBackEndMediaPlayer	Ltv/danmaku/ijk/media/player/IMediaPlayer;
    //   18: invokeinterface 82 1 0
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 80	tv/danmaku/ijk/media/player/MediaPlayerProxy:mIsReleased	Z
    //   28: goto -17 -> 11
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	MediaPlayerProxy
    //   6	2	1	bool	boolean
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   14	28	31	finally
  }
  
  public void reset()
  {
    this.mBackEndMediaPlayer.reset();
  }
  
  public void seekTo(long paramLong)
    throws IllegalStateException
  {
    this.mBackEndMediaPlayer.seekTo(paramLong);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.mBackEndMediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mBackEndMediaPlayer.setDataSource(paramContext, paramUri);
  }
  
  @TargetApi(14)
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mBackEndMediaPlayer.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    this.mBackEndMediaPlayer.setDataSource(paramFileDescriptor);
  }
  
  public void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mBackEndMediaPlayer.setDataSource(paramString);
  }
  
  public void setDataSource(IMediaDataSource paramIMediaDataSource)
  {
    this.mBackEndMediaPlayer.setDataSource(paramIMediaDataSource);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.mBackEndMediaPlayer.setDisplay(paramSurfaceHolder);
  }
  
  public void setKeepInBackground(boolean paramBoolean)
  {
    this.mBackEndMediaPlayer.setKeepInBackground(paramBoolean);
  }
  
  public void setLogEnabled(boolean paramBoolean) {}
  
  public void setLooping(boolean paramBoolean)
  {
    this.mBackEndMediaPlayer.setLooping(paramBoolean);
  }
  
  public void setNextMediaPlayer(IMediaPlayer paramIMediaPlayer)
    throws UnsupportedOperationException
  {
    this.mBackEndMediaPlayer.setNextMediaPlayer(paramIMediaPlayer);
  }
  
  public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    if (paramOnBufferingUpdateListener != null)
    {
      this.mBackEndMediaPlayer.setOnBufferingUpdateListener(new MediaPlayerProxy.4(this, paramOnBufferingUpdateListener));
      return;
    }
    this.mBackEndMediaPlayer.setOnBufferingUpdateListener(null);
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (paramOnCompletionListener != null)
    {
      this.mBackEndMediaPlayer.setOnCompletionListener(new MediaPlayerProxy.3(this, paramOnCompletionListener));
      return;
    }
    this.mBackEndMediaPlayer.setOnCompletionListener(null);
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    if (paramOnErrorListener != null)
    {
      this.mBackEndMediaPlayer.setOnErrorListener(new MediaPlayerProxy.7(this, paramOnErrorListener));
      return;
    }
    this.mBackEndMediaPlayer.setOnErrorListener(null);
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    if (paramOnInfoListener != null)
    {
      this.mBackEndMediaPlayer.setOnInfoListener(new MediaPlayerProxy.8(this, paramOnInfoListener));
      return;
    }
    this.mBackEndMediaPlayer.setOnInfoListener(null);
  }
  
  public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    if (paramOnLoopStartListener != null)
    {
      this.mBackEndMediaPlayer.setOnLoopStartListener(new MediaPlayerProxy.2(this, paramOnLoopStartListener));
      return;
    }
    this.mBackEndMediaPlayer.setOnPreparedListener(null);
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    if (paramOnPreparedListener != null)
    {
      this.mBackEndMediaPlayer.setOnPreparedListener(new MediaPlayerProxy.1(this, paramOnPreparedListener));
      return;
    }
    this.mBackEndMediaPlayer.setOnPreparedListener(null);
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    if (paramOnSeekCompleteListener != null)
    {
      this.mBackEndMediaPlayer.setOnSeekCompleteListener(new MediaPlayerProxy.5(this, paramOnSeekCompleteListener));
      return;
    }
    this.mBackEndMediaPlayer.setOnSeekCompleteListener(null);
  }
  
  public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener paramOnTimedTextListener)
  {
    if (paramOnTimedTextListener != null)
    {
      this.mBackEndMediaPlayer.setOnTimedTextListener(new MediaPlayerProxy.9(this, paramOnTimedTextListener));
      return;
    }
    this.mBackEndMediaPlayer.setOnTimedTextListener(null);
  }
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    if (paramOnVideoSizeChangedListener != null)
    {
      this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayerProxy.6(this, paramOnVideoSizeChangedListener));
      return;
    }
    this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(null);
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.mBackEndMediaPlayer.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSeekParameters(SeekParameters paramSeekParameters)
  {
    this.mBackEndMediaPlayer.setSeekParameters(paramSeekParameters);
  }
  
  @TargetApi(14)
  public void setSurface(Surface paramSurface)
  {
    this.mBackEndMediaPlayer.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.mBackEndMediaPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.mBackEndMediaPlayer.setWakeMode(paramContext, paramInt);
  }
  
  public void start()
    throws IllegalStateException, IMediaPlayer.InternalOperationException
  {
    this.mBackEndMediaPlayer.start();
  }
  
  public void stop()
    throws IllegalStateException
  {
    this.mBackEndMediaPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.MediaPlayerProxy
 * JD-Core Version:    0.7.0.1
 */