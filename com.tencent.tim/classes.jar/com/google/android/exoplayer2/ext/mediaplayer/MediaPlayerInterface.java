package com.google.android.exoplayer2.ext.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface MediaPlayerInterface
{
  public static final int EXO_MEDIA_ERROR_EXTRA_CONN = -3;
  public static final int EXO_MEDIA_ERROR_EXTRA_NETWORK = -2;
  public static final int EXO_MEDIA_ERROR_EXTRA_UNKNOWN = -1;
  public static final int EXO_MEDIA_ERROR_LOADER = -4004;
  public static final int EXO_MEDIA_ERROR_RESPONSE_403 = -10;
  public static final int EXO_MEDIA_ERROR_RESPONSE_404 = -11;
  public static final int EXO_MEDIA_ERROR_RESPONSE_500 = -12;
  public static final int EXO_MEDIA_ERROR_RESPONSE_502 = -13;
  public static final int EXO_MEDIA_ERROR_RESPONSE_OTHER = -30;
  public static final int EXO_MEDIA_ERROR_WHAT_EXTRACTOR = -4001;
  public static final int EXO_MEDIA_ERROR_WHAT_IO = -4000;
  public static final int EXO_MEDIA_ERROR_WHAT_UNKNOWN = -4999;
  public static final int EXO_MEIDA_ERROR_ILLEGAL_STATE = -4002;
  public static final int EXO_MEIDA_ERROR_MEDIACODEC_DECODER_INIT = -4003;
  public static final int MEDIA_INFO_BUFFERING_END = 702;
  public static final int MEDIA_INFO_BUFFERING_START = 701;
  public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
  public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
  
  public abstract long getCurrentPosition();
  
  public abstract long getDuration();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isLooping();
  
  public abstract boolean isPlaying();
  
  public abstract void pause()
    throws IllegalStateException;
  
  public abstract void prepareAsync()
    throws IllegalStateException;
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(long paramLong)
    throws IllegalStateException;
  
  public abstract void setDataSource(Context paramContext, Uri paramUri)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setDataSource(Context paramContext, List<String> paramList)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setDataSource(List<VideoMeta> paramList)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setDisplay(SurfaceHolder paramSurfaceHolder);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setNextMediaPlayer(MediaPlayerInterface paramMediaPlayerInterface)
    throws UnsupportedOperationException;
  
  public abstract void setOnBufferingUpdateListener(OnBufferingUpdateListener paramOnBufferingUpdateListener);
  
  public abstract void setOnCompletionListener(OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnErrorListener(OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(OnInfoListener paramOnInfoListener);
  
  public abstract void setOnLoopStartListener(OnLoopStartListener paramOnLoopStartListener);
  
  public abstract void setOnPreparedListener(OnPreparedListener paramOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnVideoSizeChangedListener(OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract void setRate(float paramFloat);
  
  public abstract void setScreenOnWhilePlaying(boolean paramBoolean);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  @Deprecated
  public abstract void setWakeMode(Context paramContext, int paramInt);
  
  public abstract void start()
    throws IllegalStateException;
  
  public abstract void stop()
    throws IllegalStateException;
  
  public static abstract interface AudioEventListener
  {
    public abstract void onRenderAudioData(byte[] paramArrayOfByte, Format paramFormat);
  }
  
  public static abstract interface OnBufferingUpdateListener
  {
    public abstract void onBufferingUpdate(MediaPlayerInterface paramMediaPlayerInterface, int paramInt);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(MediaPlayerInterface paramMediaPlayerInterface);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(MediaPlayerInterface paramMediaPlayerInterface, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(MediaPlayerInterface paramMediaPlayerInterface, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnLoopStartListener
  {
    public abstract void onLoopStart(MediaPlayerInterface paramMediaPlayerInterface);
  }
  
  public static abstract interface OnPreparedListener
  {
    public abstract void onPrepared(MediaPlayerInterface paramMediaPlayerInterface);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(MediaPlayerInterface paramMediaPlayerInterface);
  }
  
  public static abstract interface OnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(MediaPlayerInterface paramMediaPlayerInterface, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
 * JD-Core Version:    0.7.0.1
 */