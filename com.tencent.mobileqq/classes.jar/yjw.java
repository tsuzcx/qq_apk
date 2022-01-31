import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class yjw
  extends BroadcastReceiver
{
  protected WeakReference a;
  
  public yjw(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.e("ApolloGameManager", 1, "[onReceive] intent null");
    }
    String str;
    do
    {
      return;
      str = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "[onReceive] action=", str + ", app: " + this.a.get() });
      }
      paramContext = (QQAppInterface)this.a.get();
    } while ((paramContext == null) || (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(str)) || (!"apolloGameWebMessage".equals(paramIntent.getStringExtra("event"))));
    paramIntent = paramIntent.getStringExtra("data");
    ApolloCmdChannel.getChannel(paramContext).handleWebEvent(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yjw
 * JD-Core Version:    0.7.0.1
 */