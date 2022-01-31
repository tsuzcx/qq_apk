package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

class ht
  extends BroadcastReceiver
{
  private ht(de paramde) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    eh.e("SharkTcpControler", "[tcp_control][shark_conf]doOnRecv()");
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getPackage();
    if ((paramContext == null) || (paramIntent == null) || (!paramIntent.equals(bc.n().getPackageName()))) {
      eh.e("SharkTcpControler", "[tcp_control][shark_conf]TcpControlReceiver.onReceive(), null action or from other pkg, ignore");
    }
    do
    {
      return;
      if (paramContext.equals("action_keep_alive_cycle"))
      {
        de.e(this.a).sendEmptyMessage(3);
        return;
      }
    } while (!paramContext.equals("action_keep_alive_close"));
    de.e(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ht
 * JD-Core Version:    0.7.0.1
 */