import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class iia
{
  public static String TAG = "AccountReceiver";
  boolean PH = false;
  iia.a a;
  VideoAppInterface mApp;
  
  public iia(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.a = new iia.a(paramVideoAppInterface);
  }
  
  public void amw()
  {
    if (this.PH)
    {
      this.mApp.getApplication().unregisterReceiver(this.a);
      this.PH = false;
    }
  }
  
  public void amx()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "regist QQ Account Receiver, Declare permissions");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.mApp.getApplication().getPackageName());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("tencent.video.q2v.membersChange");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    if (this.mApp.getApplication().registerReceiver(this.a, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null) != null) {
      this.PH = true;
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    public static String TAG = "AccountReceiver";
    VideoAppInterface mApp;
    
    public a(VideoAppInterface paramVideoAppInterface)
    {
      this.mApp = paramVideoAppInterface;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
      long l;
      int i;
      boolean bool;
      int j;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                try
                {
                  paramContext = this.mApp.b();
                  if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "recv account broadcast: " + paramIntent.getAction());
                  }
                  if (!paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_KICKED")) {
                    break;
                  }
                  this.mApp.kH(1001);
                  if (paramContext != null) {
                    paramContext.alW();
                  }
                  Process.killProcess(Process.myPid());
                  return;
                }
                catch (RuntimeException paramContext) {}
              } while (!QLog.isColorLevel());
              QLog.e(TAG, 2, "RuntimeException", paramContext);
              return;
              if (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))
              {
                this.mApp.kH(1003);
                if (paramContext != null) {
                  paramContext.alW();
                }
                Process.killProcess(Process.myPid());
                return;
              }
              if (paramIntent.getAction().equals("mqq.intent.action.LOGOUT"))
              {
                this.mApp.kH(1002);
                if (paramContext != null) {
                  paramContext.alW();
                }
                Process.killProcess(Process.myPid());
                return;
              }
              if (paramIntent.getAction().equals("mqq.intent.action.EXIT_" + this.mApp.getApp().getPackageName()))
              {
                this.mApp.kH(1005);
                if (paramContext != null) {
                  paramContext.alW();
                }
                Process.killProcess(Process.myPid());
                return;
              }
              if (!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) {
                break;
              }
            } while (paramContext == null);
            if (paramContext.OB) {
              paramContext.b(paramContext.alr, paramContext.kJ, 74);
            }
            if (QLog.isColorLevel()) {
              QLog.e(TAG, 2, "ACTION_ACCOUNT_CHANGED, video process exit!");
            }
            this.mApp.kH(1004);
            paramContext.alW();
            Process.killProcess(Process.myPid());
            return;
          } while (!"tencent.video.q2v.membersChange".equals(paramIntent.getAction()));
          l = paramIntent.getLongExtra("relationId", -1L);
          i = paramIntent.getIntExtra("relationType", 0);
          if (l != -1L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(TAG, 2, "can not get the right value");
        return;
        bool = paramIntent.getBooleanExtra("Exit", false);
        j = paramIntent.getIntExtra("avtype", 0);
        this.mApp.l(new Object[] { Integer.valueOf(79), Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(j) });
      } while ((!bool) || (j == 2));
      paramContext.o(i, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iia
 * JD-Core Version:    0.7.0.1
 */