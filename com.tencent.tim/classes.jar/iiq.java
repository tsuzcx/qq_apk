import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class iiq
{
  private boolean lm;
  private BroadcastReceiver mActionReceiver;
  private VideoAppInterface mApp;
  
  public iiq(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.mActionReceiver = new iiq.a(paramVideoAppInterface, null);
    this.lm = false;
  }
  
  public void register()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qav.notify.accept");
    localIntentFilter.addAction("com.tencent.qav.notify.refuse");
    localIntentFilter.addAction("tencent.video.q2v.ptusoDownloadRet");
    localIntentFilter.addAction("tencent.video.q2v.ptuLibpagDownloadRet");
    localIntentFilter.addAction("tencent.video.q2v.avReceivePushMsg");
    this.mApp.getApplication().registerReceiver(this.mActionReceiver, localIntentFilter);
    this.lm = true;
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "register");
    }
  }
  
  public void unRegister()
  {
    if (this.lm)
    {
      this.mApp.getApplication().unregisterReceiver(this.mActionReceiver);
      this.lm = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "unRegister");
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    private final WeakReference<VideoAppInterface> mRef;
    
    private a(VideoAppInterface paramVideoAppInterface)
    {
      this.mRef = new WeakReference(paramVideoAppInterface);
    }
    
    public void a(long paramLong1, VideoAppInterface paramVideoAppInterface, String paramString, int paramInt, long paramLong2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QAVNotifyActionMonitor", 2, "rejectMultiChat, session[" + paramString + "], relationType[" + paramInt + "], groupId[" + paramLong2 + "], seq[" + paramLong1 + "]");
      }
      TraeHelper.t(paramVideoAppInterface);
      VideoController.a().c(paramLong1, paramInt, paramLong2);
      paramVideoAppInterface = jko.a(paramVideoAppInterface);
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.cancelNotification(paramString);
      }
    }
    
    public void a(long paramLong, VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QAVNotifyActionMonitor", 2, "rejectDoubleChat, session[" + paramString1 + "], peerUin[" + paramString2 + "], isDoubleVideoMeeting[" + paramBoolean + "], seq[" + paramLong + "]");
      }
      TraeHelper.t(paramVideoAppInterface);
      VideoController localVideoController = VideoController.a();
      if (paramBoolean)
      {
        localVideoController.a(paramLong, paramString2, 1, true);
        long l = jji.B(paramString2);
        localVideoController.c(paramLong, 3, l);
        localVideoController.f(paramLong, l, 1);
      }
      for (;;)
      {
        paramVideoAppInterface = jko.a(paramVideoAppInterface);
        if (paramVideoAppInterface != null) {
          paramVideoAppInterface.cancelNotification(paramString1);
        }
        return;
        localVideoController.a(paramLong, paramString2, 1, false);
        localVideoController.O(paramString2, 248);
        localVideoController.ko(248);
        localVideoController.P(paramString2, 1);
      }
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {}
      label209:
      do
      {
        Object localObject;
        do
        {
          do
          {
            boolean bool;
            do
            {
              do
              {
                do
                {
                  return;
                  paramContext = paramIntent.getAction();
                  long l = jlc.a(paramIntent);
                  if (QLog.isColorLevel()) {
                    QLog.i("QAVNotifyActionMonitor", 2, "onReceive action[" + paramContext + "], seq[" + l + "]");
                  }
                  if ("com.tencent.qav.notify.refuse".equals(paramContext))
                  {
                    paramContext = paramIntent.getStringExtra("session_id");
                    paramIntent = igv.a().c(paramContext);
                    if (QLog.isColorLevel()) {
                      QLog.i("QAVNotifyActionMonitor", 2, "refuse call session[" + paramContext + "], info[" + paramIntent + "], seq[" + l + "]");
                    }
                    if (paramIntent != null)
                    {
                      localObject = (VideoAppInterface)this.mRef.get();
                      if (!igv.a(paramIntent)) {
                        break label209;
                      }
                      a(l, (VideoAppInterface)localObject, paramIntent.sessionId, paramIntent.peerUin, paramIntent.Qw);
                    }
                    for (;;)
                    {
                      anot.a(null, "dc00898", "", "", "0X800A2C7", "0X800A2C7", 0, 0, "", "", "", "");
                      return;
                      a(l, (VideoAppInterface)localObject, paramContext, paramIntent.relationType, paramIntent.ll);
                    }
                  }
                  if (!"tencent.video.q2v.ptusoDownloadRet".equals(paramContext)) {
                    break;
                  }
                  i = paramIntent.getIntExtra("packageIdx", 0);
                  bool = paramIntent.getBooleanExtra("isDownloaded", false);
                  j = paramIntent.getIntExtra("errorType", 0);
                  if (QLog.isColorLevel()) {
                    QLog.i("QAVNotifyActionMonitor", 2, "onAEResDownloadResult, package[" + i + ", isDownloaded[" + bool + ", errorType[" + j + "]");
                  }
                } while ((!bool) || (i != axcd.c.index));
                paramContext = VideoController.a().a();
              } while (paramContext == null);
              ikx.b(paramContext);
              ((ikt)paramContext.a(5)).kT(3);
              return;
              if (!"tencent.video.q2v.ptuLibpagDownloadRet".equals(paramContext)) {
                break;
              }
              i = paramIntent.getIntExtra("packageIdx", 0);
              bool = paramIntent.getBooleanExtra("isDownloaded", false);
              int j = paramIntent.getIntExtra("errorType", 0);
              if (QLog.isColorLevel()) {
                QLog.i("QAVNotifyActionMonitor", 2, "ACTION_PTU_LIBPAG_DOWNLOAD_RET onAEResDownloadResult, package[" + i + ", isDownloaded[" + bool + ", errorType[" + j + "]");
              }
            } while ((!bool) || (i != axcd.d.index));
            paramContext = VideoController.a().a();
          } while (paramContext == null);
          iop.g(paramContext);
          ((ikt)paramContext.a(5)).kT(3);
          return;
        } while (!"tencent.video.q2v.avReceivePushMsg".equals(paramContext));
        paramContext = paramIntent.getStringExtra("key");
        i = paramIntent.getIntExtra("msg_type", 0);
        paramIntent = paramIntent.getByteArrayExtra("msg_content");
        if (TextUtils.equals(paramContext, "avChatRoom"))
        {
          localObject = VideoController.a().a();
          if (localObject != null)
          {
            localObject = ((VideoAppInterface)localObject).a();
            if (localObject != null) {
              ((ilu)localObject).e(i, paramIntent);
            }
          }
        }
      } while (!QLog.isDevelopLevel());
      paramContext = new StringBuilder().append("ACTION_AV_RECEIVE_PUSH_MSG , key[").append(paramContext).append("], msgType[").append(i).append("], bytes[");
      if (paramIntent == null) {}
      for (int i = 0;; i = paramIntent.length)
      {
        QLog.i("ChatRoomMng", 4, i + "]");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iiq
 * JD-Core Version:    0.7.0.1
 */