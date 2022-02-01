package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnTimedTextListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.TimedText;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
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
  private final AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
  private final MediaPlayer mInternalMediaPlayer;
  private volatile boolean mIsReleased;
  private MediaDataSource mMediaDataSource;
  
  public AndroidMediaPlayer()
  {
    synchronized (this.mInitLock)
    {
      this.mInternalMediaPlayer = new MediaPlayer();
      this.mInternalMediaPlayer.setAudioStreamType(3);
      this.mInternalListenerAdapter = new AndroidMediaPlayerListenerHolder(this);
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
    throws IllegalStateException
  {
    this.mInternalMediaPlayer.pause();
  }
  
  public void prepareAsync()
    throws IllegalStateException
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
    throws IllegalStateException
  {
    this.mInternalMediaPlayer.seekTo((int)paramLong);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.mInternalMediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri);
  }
  
  @TargetApi(14)
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
    throws IOException, IllegalArgumentException, IllegalStateException
  {
    this.mInternalMediaPlayer.setDataSource(paramFileDescriptor);
  }
  
  public void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
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
    this.mMediaDataSource = new MediaDataSourceProxy(paramIMediaDataSource);
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
    throws UnsupportedOperationException
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
    throws IllegalStateException
  {
    this.mInternalMediaPlayer.start();
  }
  
  public void stop()
    throws IllegalStateException
  {
    this.mInternalMediaPlayer.stop();
  }
  
  static class AndroidMediaPlayerListenerHolder
    implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener
  {
    public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;
    
    public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer paramAndroidMediaPlayer)
    {
      this.mWeakMediaPlayer = new WeakReference(paramAndroidMediaPlayer);
    }
    
    public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
    {
      paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
      if ((paramMediaPlayer == null) || (paramMediaPlayer.mIsReleased)) {
        return;
      }
      paramMediaPlayer.notifyOnBufferingUpdate(paramInt);
    }
    
    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
      if ((paramMediaPlayer == null) || (paramMediaPlayer.mIsReleased)) {
        return;
      }
      paramMediaPlayer.notifyOnCompletion();
    }
    
    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
      if ((paramMediaPlayer == null) || (paramMediaPlayer.mIsReleased)) {
        return false;
      }
      return paramMediaPlayer.notifyOnError(paramInt1, paramInt2);
    }
    
    public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
      if ((paramMediaPlayer == null) || (paramMediaPlayer.mIsReleased)) {
        return false;
      }
      return paramMediaPlayer.notifyOnInfo(paramInt1, paramInt2);
    }
    
    public void onPrepared(MediaPlayer paramMediaPlayer)
    {
      paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
      if ((paramMediaPlayer == null) || (paramMediaPlayer.mIsReleased)) {
        return;
      }
      paramMediaPlayer.notifyOnPrepared();
    }
    
    public void onSeekComplete(MediaPlayer paramMediaPlayer)
    {
      paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
      if ((paramMediaPlayer == null) || (paramMediaPlayer.mIsReleased)) {
        return;
      }
      paramMediaPlayer.notifyOnSeekComplete();
    }
    
    public void onTimedText(MediaPlayer paramMediaPlayer, TimedText paramTimedText)
    {
      AndroidMediaPlayer localAndroidMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
      if ((localAndroidMediaPlayer == null) || (localAndroidMediaPlayer.mIsReleased)) {
        return;
      }
      paramMediaPlayer = null;
      if (paramTimedText != null) {
        paramMediaPlayer = new IjkTimedText(paramTimedText.getBounds(), paramTimedText.getText());
      }
      localAndroidMediaPlayer.notifyOnTimedText(paramMediaPlayer);
    }
    
    public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
      if ((paramMediaPlayer == null) || (paramMediaPlayer.mIsReleased)) {
        return;
      }
      paramMediaPlayer.notifyOnVideoSizeChanged(paramInt1, paramInt2, 1, 1);
    }
  }
  
  @TargetApi(23)
  static class MediaDataSourceProxy
    extends MediaDataSource
  {
    private final IMediaDataSource mMediaDataSource;
    
    public MediaDataSourceProxy(IMediaDataSource paramIMediaDataSource)
    {
      this.mMediaDataSource = paramIMediaDataSource;
    }
    
    public void close()
      throws IOException
    {
      this.mMediaDataSource.close();
    }
    
    public long getSize()
      throws IOException
    {
      return this.mMediaDataSource.getSize();
    }
    
    public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      return this.mMediaDataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.AndroidMediaPlayer
 * JD-Core Version:    0.7.0.1
 */