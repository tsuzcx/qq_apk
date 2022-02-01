import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZoneConnectProcessor.1;
import cooperation.qzone.plugin.QZonePatchService;
import java.util.LinkedList;

public class avxt
{
  private static avxt a;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private volatile boolean mProcessing;
  private LinkedList<avxt.a> mQueue = new LinkedList();
  
  public static avxt a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avxt();
      }
      return a;
    }
    finally {}
  }
  
  private void a(avxt.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInner, " + parama + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = avxt.a.a(parama).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, parama, 1);
        return;
      }
      catch (SecurityException parama) {}
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "processInner", parama);
  }
  
  private void a(avxt.a parama, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInnerDelay. " + paramInt + ", " + parama);
    }
    this.mHandler.postDelayed(new QZoneConnectProcessor.1(this, parama), paramInt);
  }
  
  public void process(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new avxt.a(paramServiceConnection, ???, paramInt);
    if (this.mProcessing)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "queue");
      }
      synchronized (this.mQueue)
      {
        this.mQueue.offer(paramServiceConnection);
        return;
      }
    }
    this.mProcessing = true;
    a(paramServiceConnection);
  }
  
  public class a
    implements ServiceConnection
  {
    private Context mContext;
    private ServiceConnection mWrappedConnection;
    
    public a(ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
    {
      this.mWrappedConnection = paramServiceConnection;
      this.mContext = paramContext;
    }
    
    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      do
      {
        try
        {
          this.mContext.getApplicationContext().unbindService(this);
          if (QLog.isColorLevel()) {
            QLog.i("QZonePluginManger", 2, "onServiceConnected, " + this);
          }
          this.mWrappedConnection.onServiceConnected(???, paramIBinder);
        }
        catch (Exception localException)
        {
          synchronized (avxt.a(avxt.this))
          {
            do
            {
              paramIBinder = (a)avxt.a(avxt.this).poll();
              if (paramIBinder == null) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("QZonePluginManger", 2, "continue process");
              }
              avxt.a(avxt.this, paramIBinder, 300);
              return;
              localException = localException;
            } while (!QLog.isColorLevel());
            QLog.i("QZonePluginManger", 2, "unbindService, " + this);
          }
        }
        avxt.a(avxt.this, false);
      } while (!QLog.isColorLevel());
      QLog.i("QZonePluginManger", 2, "queue empty");
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "onServiceDisconnected, " + this);
      }
      this.mWrappedConnection.onServiceDisconnected(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxt
 * JD-Core Version:    0.7.0.1
 */