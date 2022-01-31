import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;
import com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy.2;
import java.util.Queue;

public class vsx
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private Queue<Message> jdField_a_of_type_JavaUtilQueue;
  private vsz jdField_a_of_type_Vsz;
  private vtb jdField_a_of_type_Vtb;
  private int jdField_b_of_type_Int;
  private final Messenger jdField_b_of_type_AndroidOsMessenger;
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 2: 
      return "CONNECTED";
    case 1: 
      return "CONNECTING";
    case 0: 
      return "DISCONNECTED";
    }
    return "DISCONNECTING";
  }
  
  private static void b()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("should invoke at main thread");
    }
  }
  
  public void a()
  {
    Messenger localMessenger = this.jdField_a_of_type_AndroidOsMessenger;
    if (localMessenger != null) {
      for (;;)
      {
        Message localMessage = (Message)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localMessage == null) {
          break;
        }
        if (localMessage.replyTo == null) {
          localMessage.replyTo = this.jdField_b_of_type_AndroidOsMessenger;
        }
        try
        {
          vsu.b("RMWServiceProxy", "client.flush : " + vsv.a(localMessage));
          localMessenger.send(localMessage);
        }
        catch (RemoteException localRemoteException)
        {
          vsu.a("RMWServiceProxy", "sendMessageToService error", new Object[] { localRemoteException });
        }
      }
    }
    vsu.b("RMWServiceProxy", "can not flushMessageQueue, service state invalid : " + a(this.jdField_a_of_type_Int));
  }
  
  protected void a(ComponentName paramComponentName)
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Int = 0;
    vsu.b("RMWServiceProxy", "onServiceDisconnected " + a(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Vtb.notifyObservers(new vta(this.jdField_a_of_type_Int));
    if (this.jdField_a_of_type_Vsz != null)
    {
      this.jdField_a_of_type_Vsz.a();
      this.jdField_a_of_type_Vsz = null;
    }
  }
  
  protected void a(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramIBinder.linkToDeath(new vsy(this, paramComponentName), 0);
      this.jdField_a_of_type_AndroidOsMessenger = new Messenger(paramIBinder);
      this.jdField_a_of_type_Int = 2;
      vsu.b("RMWServiceProxy", "onServiceConnected " + a(this.jdField_a_of_type_Int));
      a();
      this.jdField_a_of_type_Vtb.notifyObservers(new vta(this.jdField_a_of_type_Int));
      return;
    }
    catch (RemoteException paramComponentName)
    {
      vsu.c("RMWServiceProxy", "linkToDeath failed : " + paramComponentName);
      new Handler(Looper.getMainLooper()).postDelayed(new RMWServiceProxy.2(this), 1000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    vsu.a("RMWServiceProxy", "setup, current state = " + a(this.jdField_a_of_type_Int) + ", force = " + paramBoolean);
    b();
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      vsu.c("RMWServiceProxy", "setup but without context, give up");
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Int = 5;
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      this.jdField_b_of_type_Int -= 1;
      vsu.c("RMWServiceProxy", "setup again because of remote died, retry count left = " + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Int = 1;
      vsu.a("RMWServiceProxy", "connecting ... " + a(this.jdField_a_of_type_Int));
      if (this.jdField_a_of_type_Vsz == null) {
        this.jdField_a_of_type_Vsz = new vsz(this);
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RMWService.class);
      this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_Vsz, 1);
      return;
    }
    vsu.c("RMWServiceProxy", "give up setup again");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsx
 * JD-Core Version:    0.7.0.1
 */