package com.tencent.qqmini.sdk.launcher.core.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

public abstract interface ReliableVideoPlayer
{
  public static final int MEDIA_ERROR_IO = -1004;
  public static final int MEDIA_ERROR_MALFORMED = -1007;
  public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
  public static final int MEDIA_ERROR_SERVER_DIED = 100;
  public static final int MEDIA_ERROR_TIMED_OUT = -110;
  public static final int MEDIA_ERROR_UNKNOWN = 1;
  public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
  public static final int MEDIA_INFO_AUDIO_DECODED_START = 10003;
  public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
  public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
  public static final int MEDIA_INFO_BUFFERING_END = 702;
  public static final int MEDIA_INFO_BUFFERING_START = 701;
  public static final int MEDIA_INFO_COMPONENT_OPEN = 10007;
  public static final int MEDIA_INFO_FIND_STREAM_INFO = 10006;
  public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
  public static final int MEDIA_INFO_METADATA_UPDATE = 802;
  public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
  public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
  public static final int MEDIA_INFO_OPEN_INPUT = 10005;
  public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
  public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
  public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
  public static final int MEDIA_INFO_UNKNOWN = 1;
  public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
  public static final int MEDIA_INFO_VIDEO_DECODED_START = 10004;
  public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
  public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
  public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
  public static final int PLAY_MODE_AUDIO = 2;
  public static final int PLAY_MODE_VIDEO = 1;
  public static final boolean SUPPORT_NEXT_MEDIA;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 23)) {}
    for (boolean bool = true;; bool = false)
    {
      SUPPORT_NEXT_MEDIA = bool;
      return;
    }
  }
  
  public abstract int getAudioSessionId();
  
  public abstract long getCurrentPosition();
  
  public abstract String getDataSource();
  
  public abstract long getDuration();
  
  public abstract int getScore();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoSarDen();
  
  public abstract int getVideoSarNum();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isLooping();
  
  @Deprecated
  public abstract boolean isPlayable();
  
  public abstract boolean isPlaying();
  
  public abstract void pause()
    throws IllegalStateException, Exception;
  
  public abstract void prepareAsync()
    throws IllegalStateException;
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(long paramLong)
    throws IllegalStateException;
  
  public abstract void setAudioStreamType(int paramInt);
  
  public abstract void setDataSource(Context paramContext, Uri paramUri)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException;
  
  @TargetApi(14)
  public abstract void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException;
  
  public abstract void setDataSource(FileDescriptor paramFileDescriptor)
    throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException;
  
  public abstract void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException;
  
  public abstract void setDisplay(SurfaceHolder paramSurfaceHolder);
  
  @Deprecated
  public abstract void setKeepInBackground(boolean paramBoolean);
  
  @Deprecated
  public abstract void setLogEnabled(boolean paramBoolean);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setNextMediaPlayer(ReliableVideoPlayer paramReliableVideoPlayer)
    throws UnsupportedOperationException;
  
  public abstract void setOnBufferingUpdateListener(OnBufferingUpdateListener paramOnBufferingUpdateListener);
  
  public abstract void setOnCompletionListener(OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnErrorListener(OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(OnInfoListener paramOnInfoListener);
  
  public abstract void setOnLoopStartListener(OnLoopStartListener paramOnLoopStartListener);
  
  public abstract void setOnPreparedListener(OnPreparedListener paramOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnVideoSizeChangedListener(OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract void setScreenOnWhilePlaying(boolean paramBoolean);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  @Deprecated
  public abstract void setWakeMode(Context paramContext, int paramInt);
  
  public abstract void start()
    throws IllegalStateException, Exception;
  
  public abstract void stop()
    throws IllegalStateException;
  
  public static abstract interface OnBufferingUpdateListener
  {
    public abstract void onBufferingUpdate(ReliableVideoPlayer paramReliableVideoPlayer, int paramInt);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(ReliableVideoPlayer paramReliableVideoPlayer);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(ReliableVideoPlayer paramReliableVideoPlayer, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(ReliableVideoPlayer paramReliableVideoPlayer, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnLoopStartListener
  {
    public abstract void onLoopStart(ReliableVideoPlayer paramReliableVideoPlayer);
  }
  
  public static abstract interface OnPreparedListener
  {
    public abstract void onPrepared(ReliableVideoPlayer paramReliableVideoPlayer);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(ReliableVideoPlayer paramReliableVideoPlayer);
  }
  
  public static abstract interface OnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(ReliableVideoPlayer paramReliableVideoPlayer, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer
 * JD-Core Version:    0.7.0.1
 */