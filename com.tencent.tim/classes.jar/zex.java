import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class zex
  extends BroadcastReceiver
{
  public zex(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 1;
    paramContext = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramContext)) || (!TextUtils.equals(paramContext, "mqq.intent.action.DEVLOCK_ROAM"))) {}
    do
    {
      do
      {
        return;
        if (this.this$0.getActivity() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.history.C2CAllFragment", 2, "OpenDevLockReceiver get activity is null");
      return;
    } while (this.this$0.aR == null);
    this.this$0.getActivity().getApplicationContext().unregisterReceiver(this.this$0.aR);
    this.this$0.aR = null;
    boolean bool = paramIntent.getBooleanExtra("auth_dev_open", false);
    int k = paramIntent.getIntExtra("auth_dev_open_cb_reason", 0);
    paramIntent = paramIntent.getByteArrayExtra("devlock_roam_sig");
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder().append("openDevLock callback isOpen: ").append(bool).append(", reason: ").append(k).append(", da2 length: ");
      if (paramIntent == null)
      {
        i = 0;
        QLog.d("Q.history.C2CAllFragment", 2, i);
      }
    }
    else
    {
      QQAppInterface localQQAppInterface = this.this$0.mApp;
      String str = k + "";
      if (!bool) {
        break label301;
      }
      paramContext = "true";
      label211:
      VipUtils.a(localQQAppInterface, "chat_history", "LockSet", "opendev_amount", 1, 0, new String[] { str, "0", paramContext });
      paramContext = this.this$0.mUIHandler.obtainMessage(29);
      if (!bool) {
        break label307;
      }
    }
    label301:
    label307:
    for (int i = j;; i = 0)
    {
      paramContext.arg1 = i;
      paramContext.arg2 = k;
      paramContext.obj = paramIntent;
      this.this$0.mUIHandler.sendMessageDelayed(paramContext, 500L);
      return;
      i = paramIntent.length;
      break;
      paramContext = "false";
      break label211;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zex
 * JD-Core Version:    0.7.0.1
 */