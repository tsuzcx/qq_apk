import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.1;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class avld
{
  public final String TAG = "QQIndividualityRemoteProxy";
  protected avkx a;
  protected HashSet<String> bS = new HashSet();
  public ConcurrentLinkedQueue<avld.a> c = new ConcurrentLinkedQueue();
  public final String cLI = "com.qqindividuality.ipc.QQIndividualityRemoteProxyService";
  protected boolean ch;
  protected WeakReference<AppRuntime> jc;
  private ServiceConnection mServiceConnection = new avle(this);
  
  public avld(AppRuntime paramAppRuntime)
  {
    this.jc = new WeakReference(paramAppRuntime);
    tu("qqindividuality_signature");
  }
  
  private boolean a(avld.a parama)
  {
    return this.c.add(parama);
  }
  
  private boolean connect()
  {
    if ((this.a == null) && (!this.ch) && (this.jc != null))
    {
      AppRuntime localAppRuntime = (AppRuntime)this.jc.get();
      if (localAppRuntime != null)
      {
        QQIndividualityPluginProxyService.a(localAppRuntime, this.mServiceConnection, "com.qqindividuality.ipc.QQIndividualityRemoteProxyService");
        this.ch = true;
        return true;
      }
    }
    return false;
  }
  
  private boolean disconnect()
  {
    if ((this.a != null) && (this.jc != null))
    {
      AppRuntime localAppRuntime = (AppRuntime)this.jc.get();
      if (localAppRuntime != null)
      {
        QQIndividualityPluginProxyService.e(localAppRuntime, this.mServiceConnection);
        this.a = null;
        this.ch = false;
      }
    }
    return true;
  }
  
  public void a(avld.a parama)
  {
    if ((this.a != null) && (parama != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QQIndividualityRemoteProxy.1(this, parama));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.a.c(parama.mCmd, parama.mData);
      return;
    }
    catch (RemoteException parama) {}
  }
  
  public boolean a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.bS.contains(paramString))
    {
      paramString = new avld.a(paramInt, paramBundle);
      if (this.a != null) {
        a(paramString);
      }
      for (;;)
      {
        return true;
        a(paramString);
        connect();
      }
    }
    return false;
  }
  
  public boolean tu(String paramString)
  {
    if (!this.bS.contains(paramString))
    {
      this.bS.add(paramString);
      return true;
    }
    return false;
  }
  
  public boolean tv(String paramString)
  {
    if (this.bS.contains(paramString))
    {
      this.bS.remove(paramString);
      if (this.bS.isEmpty()) {
        disconnect();
      }
    }
    return false;
  }
  
  public class a
  {
    public int mCmd;
    public Bundle mData;
    
    a(int paramInt, Bundle paramBundle)
    {
      this.mCmd = paramInt;
      this.mData = paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avld
 * JD-Core Version:    0.7.0.1
 */