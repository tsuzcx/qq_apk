import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.qphone.base.util.QLog;

public class yol
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.e("cmgame_process.CmGameManager", 1, "[onReceive] intent null");
    }
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "[onReceive] action=", paramContext });
      }
      localApolloCmdChannel = CmGameUtil.a();
    } while ((localApolloCmdChannel == null) || (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) || (!"apolloGameWebMessage".equals(paramIntent.getStringExtra("event"))));
    localApolloCmdChannel.handleWebEvent(paramIntent.getStringExtra("data"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yol
 * JD-Core Version:    0.7.0.1
 */