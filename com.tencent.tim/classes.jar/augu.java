import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.mail.MailPluginRemoteManager.2.1;
import cooperation.mailplugin.ipc.IMailRemoteInterface.Stub;

public class augu
  implements ServiceConnection
{
  augu(augt paramaugt) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.d("MailPluginRemoteManager", 2, "ServiceConnection onServiceConnected");
    augt.a(this.this$0, IMailRemoteInterface.Stub.asInterface(paramIBinder));
    if (augt.a(this.this$0) != null) {
      ThreadManager.post(new MailPluginRemoteManager.2.1(this), 5, null, true);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.d("MailPluginRemoteManager", 2, "ServiceConnection onServiceDisconnected");
    augt.a(this.this$0, null);
    augt.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augu
 * JD-Core Version:    0.7.0.1
 */