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
  public IMediaPlayer.OnLoopStartListener mOnLoopStartListener;
  private IMediaPlayer.OnPreparedListener mOnPreparedListener;
  private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
  private IMediaPlayer.OnTimedTextListener mOnTimedTextListener;
  private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
  
  public int getScore()
  {
    return DeviceUtil.getBaseScore();
  }
  
  public final void notifyOnBufferingUpdate(int paramInt)
  {
    if (this.mOnBufferingUpdateListener != null) {
      this.mOnBufferingUpdateListener.onBufferingUpdate(this, paramInt);
    }
  }
  
  public final void notifyOnCompletion()
  {
    if (this.mOnCompletionListener != null) {
      this.mOnCompletionListener.onCompletion(this);
    }
  }
  
  public final boolean notifyOnError(int paramInt1, int paramInt2)
  {
    return (this.mOnErrorListener != null) && (this.mOnErrorListener.onError(this, paramInt1, paramInt2));
  }
  
  public final boolean notifyOnInfo(int paramInt1, int paramInt2)
  {
    return (this.mOnInfoListener != null) && (this.mOnInfoListener.onInfo(this, paramInt1, paramInt2));
  }
  
  public final void notifyOnPrepared()
  {
    if (this.mOnPreparedListener != null) {
      this.mOnPreparedListener.onPrepared(this);
    }
  }
  
  protected void notifyOnSeekComplete()
  {
    if (this.mOnSeekCompleteListener != null) {
      this.mOnSeekCompleteListener.onSeekComplete(this);
    }
  }
  
  protected final void notifyOnTimedText(IjkTimedText paramIjkTimedText)
  {
    if (this.mOnTimedTextListener != null) {
      this.mOnTimedTextListener.onTimedText(this, paramIjkTimedText);
    }
  }
  
  public final void notifyOnVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mOnVideoSizeChangedListener != null) {
      this.mOnVideoSizeChangedListener.onVideoSizeChanged(this, paramInt1, paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.AbstractMediaPlayer
 * JD-Core Version:    0.7.0.1
 */