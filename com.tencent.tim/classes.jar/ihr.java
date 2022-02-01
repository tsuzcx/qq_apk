import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ihr
{
  private static String TAG = "AVServiceProxy";
  private boolean PF = true;
  protected ihr.a a;
  protected ity a;
  protected VideoAppInterface mApp;
  
  public ihr(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    QLog.d(TAG, 1, String.format("setAVServiceForegroud start=%s mAvService=%s", new Object[] { Boolean.valueOf(paramBoolean), this.jdField_a_of_type_Ity }));
    if (this.jdField_a_of_type_Ity != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Ity.b(paramBoolean, paramNotification);
        this.PF = paramBoolean;
        return;
      }
      catch (RemoteException paramNotification)
      {
        QLog.d(TAG, 1, "setAVServiceForegroud fail.", paramNotification);
        continue;
      }
      catch (Throwable paramNotification)
      {
        QLog.d(TAG, 1, "setAVServiceForegroud fail.", paramNotification);
        continue;
      }
      try
      {
        MobileQQ localMobileQQ = this.mApp.getApplication();
        Intent localIntent = new Intent(localMobileQQ, AVServiceForQQ.class);
        localIntent.putExtra("setForeground", true);
        localIntent.putExtra("foreground", paramBoolean);
        localIntent.putExtra("notification", paramNotification);
        localMobileQQ.startService(localIntent);
      }
      catch (Throwable paramNotification)
      {
        QLog.d(TAG, 1, "setAVServiceForegroud fail.", paramNotification);
      }
    }
  }
  
  public void amt()
  {
    Intent localIntent = new Intent(this.mApp.getApplication(), AVServiceForQQ.class);
    this.mApp.getApplication().stopService(localIntent);
    if (this.jdField_a_of_type_Ity != null) {}
    try
    {
      this.mApp.getApplication().unbindService(this.jdField_a_of_type_Ihr$a);
      return;
    }
    catch (Exception localException)
    {
      igd.aL(TAG, "unbindService msg = " + localException.getMessage());
    }
  }
  
  public void bindService()
  {
    Intent localIntent = new Intent(this.mApp.getApplication(), AVServiceForQQ.class);
    try
    {
      this.mApp.getApplication().startService(localIntent);
      this.jdField_a_of_type_Ihr$a = new ihr.a();
      this.mApp.getApplication().bindService(localIntent, this.jdField_a_of_type_Ihr$a, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        igd.aL(TAG, "bindService " + localThrowable.getMessage());
      }
    }
  }
  
  public boolean sI()
  {
    return this.PF;
  }
  
  class a
    implements ServiceConnection
  {
    a() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ihr.TAG, 2, "AVServiceForQQ onServiceConnected");
      }
      ihr.this.a = ity.a.a(paramIBinder);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ihr.TAG, 2, "AVServiceForQQ onServiceDisconnected");
      }
      ihr.this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihr
 * JD-Core Version:    0.7.0.1
 */