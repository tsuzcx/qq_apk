import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.mail.MailPluginRemoteManager.1;
import cooperation.mailplugin.ipc.IMailRemoteInterface;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class augt
{
  private static augt jdField_a_of_type_Augt;
  private IMailRemoteInterface jdField_a_of_type_CooperationMailpluginIpcIMailRemoteInterface;
  public ConcurrentLinkedQueue<augt.a> c = new ConcurrentLinkedQueue();
  private boolean ch;
  private ServiceConnection mServiceConnection = new augu(this);
  
  public static augt a()
  {
    if (jdField_a_of_type_Augt == null) {
      jdField_a_of_type_Augt = new augt();
    }
    return jdField_a_of_type_Augt;
  }
  
  private void a(augt.a parama)
  {
    QLog.d("MailPluginRemoteManager", 2, "remoteCall");
    if ((this.jdField_a_of_type_CooperationMailpluginIpcIMailRemoteInterface != null) && (parama != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() == localLooper.getThread()) {
        ThreadManager.excute(new MailPluginRemoteManager.1(this, parama), 16, null, true);
      }
    }
    else
    {
      return;
    }
    try
    {
      QLog.d("MailPluginRemoteManager", 2, "transfer | cmd = " + parama.mCmd + ", data = " + parama.mData);
      this.jdField_a_of_type_CooperationMailpluginIpcIMailRemoteInterface.transfer(parama.mCmd, parama.mData);
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
    }
  }
  
  private boolean a(augt.a parama)
  {
    return this.c.add(parama);
  }
  
  private boolean o(AppRuntime paramAppRuntime)
  {
    QLog.d("MailPluginRemoteManager", 2, "connect");
    if ((this.jdField_a_of_type_CooperationMailpluginIpcIMailRemoteInterface == null) && (!this.ch))
    {
      QLog.d("MailPluginRemoteManager", 2, "do connect");
      a(paramAppRuntime, this.mServiceConnection);
      this.ch = true;
      return true;
    }
    return false;
  }
  
  public void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.tencent.tim", "com.tencent.androidqqmail.tim.MailPluginService"));
    paramAppRuntime.getApplication().bindService(localIntent, paramServiceConnection, 1);
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle)
  {
    QLog.d("MailPluginRemoteManager", 2, "call | cmd = " + paramString + ", data = " + paramBundle);
    paramString = new augt.a(paramString, paramBundle);
    if (this.jdField_a_of_type_CooperationMailpluginIpcIMailRemoteInterface != null) {
      a(paramString);
    }
    for (;;)
    {
      return true;
      a(paramString);
      o(paramAppRuntime);
    }
  }
  
  public class a
  {
    public String mCmd;
    public Bundle mData;
    
    a(String paramString, Bundle paramBundle)
    {
      this.mCmd = paramString;
      this.mData = paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augt
 * JD-Core Version:    0.7.0.1
 */