import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class etp
  extends BroadcastReceiver
{
  public etp(VoipDialInterface paramVoipDialInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = BaseApplication.getContext();
    BaseApplication.getContext();
    paramIntent = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = paramIntent.getNetworkInfo(0);
    paramIntent = paramIntent.getNetworkInfo(1);
    if ((!paramContext.isConnected()) && (!paramIntent.isConnected()))
    {
      QLog.d(VoipDialInterface.a, 4, "VOIP_ Receive Unconnect");
      paramContext = VoipDialInterface.a();
      if (paramContext != null) {
        paramContext.a();
      }
      return;
    }
    QLog.d(VoipDialInterface.a, 4, "VOIP_ Receive Connected");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     etp
 * JD-Core Version:    0.7.0.1
 */