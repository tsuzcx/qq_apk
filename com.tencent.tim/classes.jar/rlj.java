import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;
import com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy.2;
import java.util.Queue;

public class rlj
{
  private rlj.a jdField_a_of_type_Rlj$a;
  private rlm jdField_a_of_type_Rlm;
  private int btc;
  private int btd;
  private Context context;
  private Messenger f;
  private final Messenger g;
  private Queue<Message> w;
  
  private static void checkThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("should invoke at main thread");
    }
  }
  
  public static String stateToString(int paramInt)
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
  
  public void bvl()
  {
    Messenger localMessenger = this.f;
    if (localMessenger != null) {
      for (;;)
      {
        Message localMessage = (Message)this.w.poll();
        if (localMessage == null) {
          break;
        }
        if (localMessage.replyTo == null) {
          localMessage.replyTo = this.g;
        }
        try
        {
          rlg.d("RMWServiceProxy", "client.flush : " + rlh.a(localMessage));
          localMessenger.send(localMessage);
        }
        catch (RemoteException localRemoteException)
        {
          rlg.i("RMWServiceProxy", "sendMessageToService error", new Object[] { localRemoteException });
        }
      }
    }
    rlg.d("RMWServiceProxy", "can not flushMessageQueue, service state invalid : " + stateToString(this.btc));
  }
  
  protected void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramIBinder.linkToDeath(new rlk(this, paramComponentName), 0);
      this.f = new Messenger(paramIBinder);
      this.btc = 2;
      rlg.d("RMWServiceProxy", "onServiceConnected " + stateToString(this.btc));
      bvl();
      this.jdField_a_of_type_Rlm.notifyObservers(new rll(this.btc));
      return;
    }
    catch (RemoteException paramComponentName)
    {
      rlg.i("RMWServiceProxy", "linkToDeath failed : " + paramComponentName);
      new Handler(Looper.getMainLooper()).postDelayed(new RMWServiceProxy.2(this), 1000L);
    }
  }
  
  protected void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.f = null;
    this.btc = 0;
    rlg.d("RMWServiceProxy", "onServiceDisconnected " + stateToString(this.btc));
    this.jdField_a_of_type_Rlm.notifyObservers(new rll(this.btc));
    if (this.jdField_a_of_type_Rlj$a != null)
    {
      this.jdField_a_of_type_Rlj$a.tearDown();
      this.jdField_a_of_type_Rlj$a = null;
    }
  }
  
  public void tT(boolean paramBoolean)
  {
    rlg.v("RMWServiceProxy", "setup, current state = " + stateToString(this.btc) + ", force = " + paramBoolean);
    checkThread();
    if (this.context == null)
    {
      rlg.i("RMWServiceProxy", "setup but without context, give up");
      return;
    }
    switch (this.btc)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    if (paramBoolean) {
      this.btd = 5;
    }
    if (this.btd > 0)
    {
      this.btd -= 1;
      rlg.i("RMWServiceProxy", "setup again because of remote died, retry count left = " + this.btd);
      this.btc = 1;
      rlg.v("RMWServiceProxy", "connecting ... " + stateToString(this.btc));
      if (this.jdField_a_of_type_Rlj$a == null) {
        this.jdField_a_of_type_Rlj$a = new rlj.a(this);
      }
      Intent localIntent = new Intent(this.context, RMWService.class);
      this.context.bindService(localIntent, this.jdField_a_of_type_Rlj$a, 1);
      return;
    }
    rlg.i("RMWServiceProxy", "give up setup again");
  }
  
  static class a
    implements ServiceConnection
  {
    private rlj a;
    
    public a(rlj paramrlj)
    {
      this.a = paramrlj;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      rlj localrlj = this.a;
      if (localrlj != null) {
        localrlj.onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      rlj localrlj = this.a;
      if (localrlj != null) {
        localrlj.onServiceDisconnected(paramComponentName);
      }
    }
    
    public void tearDown()
    {
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlj
 * JD-Core Version:    0.7.0.1
 */