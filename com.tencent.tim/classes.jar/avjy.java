import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class avjy
{
  protected avjx a;
  public ConcurrentLinkedQueue<avjy.a> c;
  protected boolean ch;
  
  private void a(avjy.a parama)
  {
    if ((this.a != null) && (parama != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, parama));
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
  
  public class a
  {
    public int mCmd;
    public Bundle mData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjy
 * JD-Core Version:    0.7.0.1
 */