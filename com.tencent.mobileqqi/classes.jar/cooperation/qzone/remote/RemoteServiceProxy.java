package cooperation.qzone.remote;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import idd;
import ide;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoteServiceProxy
{
  private static final String tag = "RemoteServiceProxy";
  private Class clazz;
  protected ServiceConnection conn = new idd(this);
  protected volatile long lastStartSerivceTime = -1L;
  private IActionListener mActionListener;
  protected Object sendLock = new Object();
  public ConcurrentLinkedQueue sendMsgQueue = new ConcurrentLinkedQueue();
  public volatile IServiceHandler serviceHandler;
  private String serviceName;
  
  public RemoteServiceProxy(String paramString, Class paramClass)
  {
    this.serviceName = paramString;
    this.clazz = paramClass;
  }
  
  private Intent getServiceIntent()
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), this.clazz);
    localIntent.putExtra("pluginsdk_launchService", this.serviceName);
    String str = QzonePluginProxyActivity.a();
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.putExtra("pluginsdk_pluginName", "个人空间");
    localIntent.putExtra("pluginsdk_pluginLocation", str);
    return localIntent;
  }
  
  protected void addMsgToSendQueue(SendMsg paramSendMsg)
  {
    this.sendMsgQueue.add(paramSendMsg);
  }
  
  boolean bindBaseService()
  {
    try
    {
      Intent localIntent = getServiceIntent();
      bool = BaseApplication.getContext().bindService(localIntent, this.conn, 1);
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("RemoteServiceProxy", 2, " bind " + this.serviceName + " service finished " + bool);
        }
        return bool;
      }
      catch (Exception localException2)
      {
        boolean bool;
        break label66;
      }
      localException1 = localException1;
      bool = false;
    }
    label66:
    return bool;
  }
  
  public RecvMsg createWaiteRespTimeout(SendMsg paramSendMsg, String paramString)
  {
    paramSendMsg = new RecvMsg(paramSendMsg.getRequestId(), paramSendMsg.getServiceCmd());
    paramSendMsg.setBusinessFail(1002, paramString);
    return paramSendMsg;
  }
  
  protected boolean isConnected()
  {
    return this.serviceHandler != null;
  }
  
  public void onBaseServiceConnected()
  {
    ide localide = new ide(this);
    localide.setName("handleWaitSendProxyMsgThread");
    localide.start();
  }
  
  public void sendFailedRespToApp(SendMsg paramSendMsg, RecvMsg paramRecvMsg)
  {
    try
    {
      paramSendMsg.getActionListener().onRecvFromMsg(paramRecvMsg);
      return;
    }
    catch (RemoteException paramSendMsg)
    {
      paramSendMsg.printStackTrace();
    }
  }
  
  public void sendMsg(SendMsg paramSendMsg)
  {
    try
    {
      synchronized (this.sendLock)
      {
        if (isConnected())
        {
          sendMsgToService(paramSendMsg);
          return;
        }
        addMsgToSendQueue(paramSendMsg);
        startBaseServiceConn();
      }
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      addMsgToSendQueue(paramSendMsg);
      return;
    }
    catch (Exception localException)
    {
      if (this.serviceHandler == null)
      {
        addMsgToSendQueue(paramSendMsg);
        return;
      }
      localException.printStackTrace();
    }
  }
  
  public void sendMsgToService(SendMsg paramSendMsg)
  {
    this.serviceHandler.sendMsg(paramSendMsg);
  }
  
  public void setActionListener(IActionListener paramIActionListener)
  {
    this.mActionListener = paramIActionListener;
  }
  
  void startBaseService()
  {
    try
    {
      Intent localIntent = getServiceIntent();
      BaseApplication.getContext().startService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("RemoteServiceProxy", 2, " start service finish");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startBaseServiceConn()
  {
    long l = System.currentTimeMillis();
    if ((this.lastStartSerivceTime == -1L) || (l - this.lastStartSerivceTime > 1000L))
    {
      this.lastStartSerivceTime = l;
      startBaseService();
      bindBaseService();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RemoteServiceProxy", 2, "wait start " + this.serviceName + " service result, skiped...");
  }
  
  public boolean stopBaseService()
  {
    try
    {
      unbindBaseService();
      Intent localIntent = getServiceIntent();
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("RemoteServiceProxy", 2, " stopService " + this.serviceName + " service finished " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void unbindBaseService()
  {
    try
    {
      BaseApplication.getContext().unbindService(this.conn);
      this.serviceHandler = null;
      if (QLog.isColorLevel()) {
        QLog.d("RemoteServiceProxy", 2, " unbindService service finished");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.remote.RemoteServiceProxy
 * JD-Core Version:    0.7.0.1
 */