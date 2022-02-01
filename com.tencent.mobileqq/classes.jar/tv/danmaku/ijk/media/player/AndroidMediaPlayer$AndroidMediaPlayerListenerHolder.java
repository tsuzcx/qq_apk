package tv.danmaku.ijk.media.player;

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
import java.lang.ref.WeakReference;

class AndroidMediaPlayer$AndroidMediaPlayerListenerHolder
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener
{
  public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;
  
  public AndroidMediaPlayer$AndroidMediaPlayerListenerHolder(AndroidMediaPlayer paramAndroidMediaPlayer)
  {
    this.mWeakMediaPlayer = new WeakReference(paramAndroidMediaPlayer);
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
    if (paramMediaPlayer != null)
    {
      if (AndroidMediaPlayer.access$000(paramMediaPlayer)) {
        return;
      }
      paramMediaPlayer.notifyOnBufferingUpdate(paramInt);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
    if (paramMediaPlayer != null)
    {
      if (AndroidMediaPlayer.access$000(paramMediaPlayer)) {
        return;
      }
      paramMediaPlayer.notifyOnCompletion();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
    if ((paramMediaPlayer != null) && (!AndroidMediaPlayer.access$000(paramMediaPlayer))) {
      return paramMediaPlayer.notifyOnError(paramInt1, paramInt2);
    }
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
    if ((paramMediaPlayer != null) && (!AndroidMediaPlayer.access$000(paramMediaPlayer))) {
      return paramMediaPlayer.notifyOnInfo(paramInt1, paramInt2);
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
    if (paramMediaPlayer != null)
    {
      if (AndroidMediaPlayer.access$000(paramMediaPlayer)) {
        return;
      }
      paramMediaPlayer.notifyOnPrepared();
    }
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
    if (paramMediaPlayer != null)
    {
      if (AndroidMediaPlayer.access$000(paramMediaPlayer)) {
        return;
      }
      paramMediaPlayer.notifyOnSeekComplete();
    }
  }
  
  public void onTimedText(MediaPlayer paramMediaPlayer, TimedText paramTimedText)
  {
    AndroidMediaPlayer localAndroidMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
    if (localAndroidMediaPlayer != null)
    {
      if (AndroidMediaPlayer.access$000(localAndroidMediaPlayer)) {
        return;
      }
      paramMediaPlayer = null;
      if (paramTimedText != null) {
        paramMediaPlayer = new IjkTimedText(paramTimedText.getBounds(), paramTimedText.getText());
      }
      localAndroidMediaPlayer.notifyOnTimedText(paramMediaPlayer);
    }
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
    if (paramMediaPlayer != null)
    {
      if (AndroidMediaPlayer.access$000(paramMediaPlayer)) {
        return;
      }
      paramMediaPlayer.notifyOnVideoSizeChanged(paramInt1, paramInt2, 1, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.AndroidMediaPlayer.AndroidMediaPlayerListenerHolder
 * JD-Core Version:    0.7.0.1
 */