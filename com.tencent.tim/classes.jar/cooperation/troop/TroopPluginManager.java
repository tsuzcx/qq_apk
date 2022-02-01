package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import avfw;
import awjm;
import awjn;
import awjo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.manager.Manager;

public class TroopPluginManager
  implements Manager
{
  public static final String TAG = TroopPluginManager.class.getName();
  public ConcurrentLinkedQueue<String> V = new ConcurrentLinkedQueue();
  Handler mHandler = new awjm(this, Looper.getMainLooper());
  protected WeakReference<QQAppInterface> n;
  
  public TroopPluginManager(QQAppInterface paramQQAppInterface)
  {
    this.n = new WeakReference(paramQQAppInterface);
  }
  
  public boolean a(String paramString, a parama)
  {
    ThreadManager.post(new TroopPluginManager.1(this, paramString, parama), 8, null, true);
    return false;
  }
  
  public void onDestroy()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null)
    {
      localPluginCommunicationHandler.unregister("troop.troopmemcard.get_app_interface_data");
      localPluginCommunicationHandler.unregister("troop.manage.get_app_interface_data");
    }
    this.mHandler.removeMessages(1001);
    if (this.n != null) {
      this.n.clear();
    }
  }
  
  public class InstallRunable
    implements Runnable
  {
    public TroopPluginManager.a b;
    public Handler mHandler = new awjn(this, Looper.getMainLooper());
    public String mPluginId;
    
    public InstallRunable(TroopPluginManager.a parama, String paramString)
    {
      this.b = parama;
      this.mPluginId = paramString;
    }
    
    public void run()
    {
      Object localObject = (QQAppInterface)TroopPluginManager.this.n.get();
      if (localObject == null) {}
      do
      {
        return;
        localObject = (avfw)((QQAppInterface)localObject).getManager(27);
      } while (localObject == null);
      ((avfw)localObject).a(this.mPluginId, false, new awjo(this));
    }
  }
  
  public static abstract interface a
  {
    public abstract void onInstallFinish(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager
 * JD-Core Version:    0.7.0.1
 */