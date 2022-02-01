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
    Object localObject1 = (IjkMediaPlayer)this.mWeakPlayer.get();
    if (localObject1 != null)
    {
      long l2 = IjkMediaPlayer.access$000((IjkMediaPlayer)localObject1);
      long l1 = 0L;
      if (l2 != 0L)
      {
        int i = paramMessage.what;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4)
                {
                  if (i != 5)
                  {
                    if (i != 99)
                    {
                      if (i != 100)
                      {
                        if (i != 200)
                        {
                          if (i != 10001)
                          {
                            localObject1 = IjkMediaPlayer.access$100();
                            localObject2 = new StringBuilder();
                            ((StringBuilder)localObject2).append("Unknown message type ");
                            ((StringBuilder)localObject2).append(paramMessage.what);
                            DebugLog.e((String)localObject1, ((StringBuilder)localObject2).toString());
                            return;
                          }
                          IjkMediaPlayer.access$502((IjkMediaPlayer)localObject1, paramMessage.arg1);
                          IjkMediaPlayer.access$602((IjkMediaPlayer)localObject1, paramMessage.arg2);
                          ((IjkMediaPlayer)localObject1).notifyOnVideoSizeChanged(IjkMediaPlayer.access$300((IjkMediaPlayer)localObject1), IjkMediaPlayer.access$400((IjkMediaPlayer)localObject1), IjkMediaPlayer.access$500((IjkMediaPlayer)localObject1), IjkMediaPlayer.access$600((IjkMediaPlayer)localObject1));
                          return;
                        }
                        i = paramMessage.arg1;
                        if (i != 3)
                        {
                          if (i != 10001)
                          {
                            localObject2 = IjkMediaPlayer.access$100();
                            localStringBuilder = new StringBuilder();
                            localStringBuilder.append("Info: MEDIA_INFO_UNKNOWN arg1=");
                            localStringBuilder.append(paramMessage.arg1);
                            localStringBuilder.append(", arg2=");
                            localStringBuilder.append(paramMessage.arg2);
                            DebugLog.i((String)localObject2, localStringBuilder.toString());
                          }
                          else
                          {
                            DebugLog.i(IjkMediaPlayer.access$100(), "Info: MEDIA_INFO_VIDEO_ROTATION_CHANGED");
                          }
                        }
                        else {
                          DebugLog.i(IjkMediaPlayer.access$100(), "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                        }
                        ((IjkMediaPlayer)localObject1).notifyOnInfo(paramMessage.arg1, paramMessage.arg2);
                        return;
                      }
                      Object localObject2 = IjkMediaPlayer.access$100();
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("Error (");
                      localStringBuilder.append(paramMessage.arg1);
                      localStringBuilder.append(",");
                      localStringBuilder.append(paramMessage.arg2);
                      localStringBuilder.append(")");
                      DebugLog.e((String)localObject2, localStringBuilder.toString());
                      if (!((IjkMediaPlayer)localObject1).notifyOnError(paramMessage.arg1, paramMessage.arg2)) {
                        ((IjkMediaPlayer)localObject1).notifyOnCompletion();
                      }
                      IjkMediaPlayer.access$200((IjkMediaPlayer)localObject1, false);
                      return;
                    }
                    if (paramMessage.obj == null)
                    {
                      ((IjkMediaPlayer)localObject1).notifyOnTimedText(null);
                      return;
                    }
                    ((IjkMediaPlayer)localObject1).notifyOnTimedText(new IjkTimedText(new Rect(0, 0, 1, 1), (String)paramMessage.obj));
                    return;
                  }
                  IjkMediaPlayer.access$302((IjkMediaPlayer)localObject1, paramMessage.arg1);
                  IjkMediaPlayer.access$402((IjkMediaPlayer)localObject1, paramMessage.arg2);
                  ((IjkMediaPlayer)localObject1).notifyOnVideoSizeChanged(IjkMediaPlayer.access$300((IjkMediaPlayer)localObject1), IjkMediaPlayer.access$400((IjkMediaPlayer)localObject1), IjkMediaPlayer.access$500((IjkMediaPlayer)localObject1), IjkMediaPlayer.access$600((IjkMediaPlayer)localObject1));
                  return;
                }
                ((IjkMediaPlayer)localObject1).notifyOnSeekComplete();
                return;
              }
              long l3 = paramMessage.arg1;
              l2 = l3;
              if (l3 < 0L) {
                l2 = 0L;
              }
              l3 = ((IjkMediaPlayer)localObject1).getDuration();
              if (l3 > 0L) {
                l1 = l2 * 100L / l3;
              }
              l2 = l1;
              if (l1 >= 100L) {
                l2 = 100L;
              }
              ((IjkMediaPlayer)localObject1).notifyOnBufferingUpdate((int)l2);
              return;
            }
            IjkMediaPlayer.access$200((IjkMediaPlayer)localObject1, false);
            ((IjkMediaPlayer)localObject1).notifyOnCompletion();
            return;
          }
          ((IjkMediaPlayer)localObject1).notifyOnPrepared();
        }
        return;
      }
    }
    DebugLog.w(IjkMediaPlayer.access$100(), "IjkMediaPlayer went away with unhandled events");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */