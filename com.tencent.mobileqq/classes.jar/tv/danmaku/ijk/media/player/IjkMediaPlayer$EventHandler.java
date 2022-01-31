package tv.danmaku.ijk.media.player;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

class IjkMediaPlayer$EventHandler
  extends Handler
{
  private final WeakReference<IjkMediaPlayer> mWeakPlayer;
  
  public IjkMediaPlayer$EventHandler(IjkMediaPlayer paramIjkMediaPlayer, Looper paramLooper)
  {
    super(paramLooper);
    this.mWeakPlayer = new WeakReference(paramIjkMediaPlayer);
  }
  
  public void handleMessage(Message paramMessage)
  {
    IjkMediaPlayer localIjkMediaPlayer = (IjkMediaPlayer)this.mWeakPlayer.get();
    if ((localIjkMediaPlayer == null) || (IjkMediaPlayer.access$000(localIjkMediaPlayer) == 0L))
    {
      DebugLog.w(IjkMediaPlayer.access$100(), "IjkMediaPlayer went away with unhandled events");
      return;
    }
    long l2;
    switch (paramMessage.what)
    {
    case 0: 
    default: 
      DebugLog.e(IjkMediaPlayer.access$100(), "Unknown message type " + paramMessage.what);
      return;
    case 1: 
      localIjkMediaPlayer.notifyOnPrepared();
      return;
    case 2: 
      IjkMediaPlayer.access$200(localIjkMediaPlayer, false);
      localIjkMediaPlayer.notifyOnCompletion();
      return;
    case 3: 
      l2 = paramMessage.arg1;
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      l2 = localIjkMediaPlayer.getDuration();
      if (l2 <= 0L) {
        break;
      }
    }
    for (long l1 = l1 * 100L / l2;; l1 = 0L)
    {
      l2 = l1;
      if (l1 >= 100L) {
        l2 = 100L;
      }
      localIjkMediaPlayer.notifyOnBufferingUpdate((int)l2);
      return;
      localIjkMediaPlayer.notifyOnSeekComplete();
      return;
      IjkMediaPlayer.access$302(localIjkMediaPlayer, paramMessage.arg1);
      IjkMediaPlayer.access$402(localIjkMediaPlayer, paramMessage.arg2);
      localIjkMediaPlayer.notifyOnVideoSizeChanged(IjkMediaPlayer.access$300(localIjkMediaPlayer), IjkMediaPlayer.access$400(localIjkMediaPlayer), IjkMediaPlayer.access$500(localIjkMediaPlayer), IjkMediaPlayer.access$600(localIjkMediaPlayer));
      return;
      DebugLog.e(IjkMediaPlayer.access$100(), "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
      if (!localIjkMediaPlayer.notifyOnError(paramMessage.arg1, paramMessage.arg2)) {
        localIjkMediaPlayer.notifyOnCompletion();
      }
      IjkMediaPlayer.access$200(localIjkMediaPlayer, false);
      return;
      switch (paramMessage.arg1)
      {
      default: 
        DebugLog.i(IjkMediaPlayer.access$100(), "Info: MEDIA_INFO_UNKNOWN arg1=" + paramMessage.arg1 + ", arg2=" + paramMessage.arg2);
      }
      for (;;)
      {
        localIjkMediaPlayer.notifyOnInfo(paramMessage.arg1, paramMessage.arg2);
        return;
        DebugLog.i(IjkMediaPlayer.access$100(), "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
        continue;
        DebugLog.i(IjkMediaPlayer.access$100(), "Info: MEDIA_INFO_VIDEO_ROTATION_CHANGED");
      }
      if (paramMessage.obj == null)
      {
        localIjkMediaPlayer.notifyOnTimedText(null);
        return;
      }
      localIjkMediaPlayer.notifyOnTimedText(new IjkTimedText(new Rect(0, 0, 1, 1), (String)paramMessage.obj));
      return;
      IjkMediaPlayer.access$502(localIjkMediaPlayer, paramMessage.arg1);
      IjkMediaPlayer.access$602(localIjkMediaPlayer, paramMessage.arg2);
      localIjkMediaPlayer.notifyOnVideoSizeChanged(IjkMediaPlayer.access$300(localIjkMediaPlayer), IjkMediaPlayer.access$400(localIjkMediaPlayer), IjkMediaPlayer.access$500(localIjkMediaPlayer), IjkMediaPlayer.access$600(localIjkMediaPlayer));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */