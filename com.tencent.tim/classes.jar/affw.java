import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.qphone.base.util.QLog;

public class affw
  implements ServiceConnection
{
  public affw(Client paramClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.a.mIsBound = true;
      this.a.mService = new Messenger(paramIBinder);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.Client", 2, "ServiceConnection Attached.");
      }
      afjy.a().cre();
      paramComponentName = Message.obtain(null, 1);
      paramComponentName.replyTo = this.a.mMessenger;
      this.a.mService.send(paramComponentName);
      return;
    }
    catch (Exception paramComponentName)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.emoji.web.Client", 2, paramComponentName.getMessage());
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.mService = null;
    this.a.onDisconnectWithService();
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.Client", 2, "Disconnected.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affw
 * JD-Core Version:    0.7.0.1
 */