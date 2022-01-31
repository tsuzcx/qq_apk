import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletFullWindowActivity.QWalletFullWindowFragment;

public class xgg
  extends BroadcastReceiver
{
  public xgg(QWalletFullWindowActivity.QWalletFullWindowFragment paramQWalletFullWindowFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      if ("action_close_camera".equals(paramIntent.getAction()))
      {
        QWalletFullWindowActivity.QWalletFullWindowFragment.a(this.a).finish();
        return;
      }
    } while ((!"cn.abel.action.broadcast".equals(paramIntent.getAction())) || (paramIntent.getBooleanExtra("isOpen", false)));
    QWalletFullWindowActivity.QWalletFullWindowFragment.b(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgg
 * JD-Core Version:    0.7.0.1
 */