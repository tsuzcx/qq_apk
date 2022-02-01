package tv.danmaku.ijk.media.player;

import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.utils.DeviceUtil;

public abstract class AbstractMediaPlayer
  implements IMediaPlayer
{
  private IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
  private IMediaPlayer.OnCompletionListener mOnCompletionListener;
  private IMediaPlayer.OnErrorListener mOnErrorListener;
  private IMediaPlayer.OnInfoListener mOnInfoListener;
  protected IMediaPlayer.OnLoopStartListener mOnLoopStartListener;
  private IMediaPlayer.OnPreparedListener mOnPreparedListener;
  private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
  private IMediaPlayer.OnTimedTextListener mOnTimedTextListener;
  private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
  
  public int getScore()
  {
    return DeviceUtil.getBaseScore();
  }
  
  protected final void notifyOnBufferingUpdate(int paramInt)
  {
    IMediaPlayer.OnBufferingUpdateListener localOnBufferingUpdateListener = this.mOnBufferingUpdateListener;
    if (localOnBufferingUpdateListener != null) {
      localOnBufferingUpdateListener.onBufferingUpdate(this, paramInt);
    }
  }
  
  protected final void notifyOnCompletion()
  {
    IMediaPlayer.OnCompletionListener localOnCompletionListener = this.mOnCompletionListener;
    if (localOnCompletionListener != null) {
      localOnCompletionListener.onCompletion(this);
    }
  }
  
  protected final boolean notifyOnError(int paramInt1, int paramInt2)
  {
    IMediaPlayer.OnErrorListener localOnErrorListener = this.mOnErrorListener;
    return (localOnErrorListener != null) && (localOnErrorListener.onError(this, paramInt1, paramInt2));
  }
  
  protected final boolean notifyOnInfo(int paramInt1, int paramInt2)
  {
    IMediaPlayer.OnInfoListener localOnInfoListener = this.mOnInfoListener;
    return (localOnInfoListener != null) && (localOnInfoListener.onInfo(this, paramInt1, paramInt2));
  }
  
  protected final void notifyOnPrepared()
  {
    IMediaPlayer.OnPreparedListener localOnPreparedListener = this.mOnPreparedListener;
    if (localOnPreparedListener != null) {
      localOnPreparedListener.onPrepared(this);
    }
  }
  
  protected void notifyOnSeekComplete()
  {
    IMediaPlayer.OnSeekCompleteListener localOnSeekCompleteListener = this.mOnSeekCompleteListener;
    if (localOnSeekCompleteListener != null) {
      localOnSeekCompleteListener.onSeekComplete(this);
    }
  }
  
  protected final void notifyOnTimedText(IjkTimedText paramIjkTimedText)
  {
    IMediaPlayer.OnTimedTextListener localOnTimedTextListener = this.mOnTimedTextListener;
    if (localOnTimedTextListener != null) {
      localOnTimedTextListener.onTimedText(this, paramIjkTimedText);
    }
  }
  
  protected final void notifyOnVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMediaPlayer.OnVideoSizeChangedListener localOnVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
    if (localOnVideoSizeChangedListener != null) {
      localOnVideoSizeChangedListener.onVideoSizeChanged(this, paramInt1, paramInt2);
    }
  }
  
  public void resetListeners()
  {
    this.mOnPreparedListener = null;
    this.mOnBufferingUpdateListener = null;
    this.mOnCompletionListener = null;
    this.mOnSeekCompleteListener = null;
    this.mOnVideoSizeChangedListener = null;
    this.mOnErrorListener = null;
    this.mOnInfoListener = null;
    this.mOnTimedTextListener = null;
  }
  
  public void setDataSource(IMediaDataSource paramIMediaDataSource)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.mOnBufferingUpdateListener = paramOnBufferingUpdateListener;
  }
  
  public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  public final void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public final void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mOnInfoListener = paramOnInfoListener;
  }
  
  public final void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    this.mOnLoopStartListener = paramOnLoopStartListener;
  }
  
  public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public final void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener paramOnTimedTextListener)
  {
    this.mOnTimedTextListener = paramOnTimedTextListener;
  }
  
  public final void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.AbstractMediaPlayer
 * JD-Core Version:    0.7.0.1
 */