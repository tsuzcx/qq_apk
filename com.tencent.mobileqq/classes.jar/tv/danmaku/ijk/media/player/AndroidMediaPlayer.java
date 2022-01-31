package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.AndroidTrackInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public class AndroidMediaPlayer
  extends AbstractMediaPlayer
{
  private static MediaInfo sMediaInfo;
  private String mDataSource;
  private final Object mInitLock = new Object();
  private final AndroidMediaPlayer.AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
  private final MediaPlayer mInternalMediaPlayer;
  private volatile boolean mIsReleased;
  private MediaDataSource mMediaDataSource;
  
  public AndroidMediaPlayer()
  {
    synchronized (this.mInitLock)
    {
      this.mInternalMediaPlayer = new MediaPlayer();
      this.mInternalMediaPlayer.setAudioStreamType(3);
      this.mInternalListenerAdapter = new AndroidMediaPlayer.AndroidMediaPlayerListenerHolder(this);
      attachInternalListeners();
      return;
    }
  }
  
  private void attachInternalListeners()
  {
    this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
    this.mInternalMediaPlayer.setOnTimedTextListener(this.mInternalListenerAdapter);
  }
  
  private void releaseMediaDataSource()
  {
    if (this.mMediaDataSource != null) {}
    try
    {
      this.mMediaDataSource.close();
      this.mMediaDataSource = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public int getAudioSessionId()
  {
    return this.mInternalMediaPlayer.getAudioSessionId();
  }
  
  public long getCurrentPosition()
  {
    try
    {
      int i = this.mInternalMediaPlayer.getCurrentPosition();
      return i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      DebugLog.printStackTrace(localIllegalStateException);
    }
    return 0L;
  }
  
  public String getDataSource()
  {
    return this.mDataSource;
  }
  
  public long getDuration()
  {
    try
    {
      int i = this.mInternalMediaPlayer.getDuration();
      return i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      DebugLog.printStackTrace(localIllegalStateException);
    }
    return 0L;
  }
  
  public MediaPlayer getInternalMediaPlayer()
  {
    return this.mInternalMediaPlayer;
  }
  
  public MediaInfo getMediaInfo()
  {
    if (sMediaInfo == null)
    {
      MediaInfo localMediaInfo = new MediaInfo();
      localMediaInfo.mVideoDecoder = "android";
      localMediaInfo.mVideoDecoderImpl = "HW";
      localMediaInfo.mAudioDecoder = "android";
      localMediaInfo.mAudioDecoderImpl = "HW";
      sMediaInfo = localMediaInfo;
    }
    return sMediaInfo;
  }
  
  public ITrackInfo[] getTrackInfo()
  {
    return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
  }
  
  public int getVideoHeight()
  {
    return this.mInternalMediaPlayer.getVideoHeight();
  }
  
  public int getVideoSarDen()
  {
    return 1;
  }
  
  public int getVideoSarNum()
  {
    return 1;
  }
  
  public int getVideoWidth()
  {
    return this.mInternalMediaPlayer.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    return this.mInternalMediaPlayer.isLooping();
  }
  
  public boolean isPlayable()
  {
    return true;
  }
  
  public boolean isPlaying()
  {
    try
    {
      boolean bool = this.mInternalMediaPlayer.isPlaying();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      DebugLog.printStackTrace(localIllegalStateException);
    }
    return false;
  }
  
  public void pause()
  {
    this.mInternalMediaPlayer.pause();
  }
  
  public void prepareAsync()
  {
    this.mInternalMediaPlayer.prepareAsync();
  }
  
  public void release()
  {
    this.mIsReleased = true;
    this.mInternalMediaPlayer.release();
    releaseMediaDataSource();
    resetListeners();
  }
  
  public void reset()
  {
    try
    {
      this.mInternalMediaPlayer.reset();
      releaseMediaDataSource();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        DebugLog.printStackTrace(localIllegalStateException);
      }
    }
  }
  
  public void seekTo(long paramLong)
  {
    this.mInternalMediaPlayer.seekTo((int)paramLong);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.mInternalMediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri);
  }
  
  @TargetApi(14)
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    this.mInternalMediaPlayer.setDataSource(paramFileDescriptor);
  }
  
  public void setDataSource(String paramString)
  {
    this.mDataSource = paramString;
    Uri localUri = Uri.parse(paramString);
    String str = localUri.getScheme();
    if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase("file")))
    {
      this.mInternalMediaPlayer.setDataSource(localUri.getPath());
      return;
    }
    this.mInternalMediaPlayer.setDataSource(paramString);
  }
  
  @TargetApi(23)
  public void setDataSource(IMediaDataSource paramIMediaDataSource)
  {
    releaseMediaDataSource();
    this.mMediaDataSource = new AndroidMediaPlayer.MediaDataSourceProxy(paramIMediaDataSource);
    this.mInternalMediaPlayer.setDataSource(this.mMediaDataSource);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    synchronized (this.mInitLock)
    {
      if (!this.mIsReleased) {
        this.mInternalMediaPlayer.setDisplay(paramSurfaceHolder);
      }
      return;
    }
  }
  
  public void setKeepInBackground(boolean paramBoolean) {}
  
  public void setLogEnabled(boolean paramBoolean) {}
  
  public void setLooping(boolean paramBoolean)
  {
    this.mInternalMediaPlayer.setLooping(paramBoolean);
  }
  
  public void setNextMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    if (!SUPPORT_NEXT_MEDIA) {
      throw new UnsupportedOperationException("setNextMediaPlayer is not supported");
    }
    if ((paramIMediaPlayer instanceof AndroidMediaPlayer))
    {
      paramIMediaPlayer = (AndroidMediaPlayer)paramIMediaPlayer;
      this.mInternalMediaPlayer.setNextMediaPlayer(paramIMediaPlayer.getInternalMediaPlayer());
      return;
    }
    throw new UnsupportedOperationException("setNextMediaPlayer is not supported for type " + paramIMediaPlayer);
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.mInternalMediaPlayer.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSeekParameters(SeekParameters paramSeekParameters)
  {
    DebugLog.w("AndroidMediaPlayer", "setSeekParameters is not supported");
  }
  
  @TargetApi(14)
  public void setSurface(Surface paramSurface)
  {
    this.mInternalMediaPlayer.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.mInternalMediaPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.mInternalMediaPlayer.setWakeMode(paramContext, paramInt);
  }
  
  public void start()
  {
    this.mInternalMediaPlayer.start();
  }
  
  public void stop()
  {
    this.mInternalMediaPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.AndroidMediaPlayer
 * JD-Core Version:    0.7.0.1
 */