import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qappcenter.QAppCenterPluginProxyService;
import cooperation.qappcenter.remote.RecvMsg;
import cooperation.qappcenter.remote.RemoteServiceProxy.2;
import cooperation.qappcenter.remote.RemoteServiceProxy.3;
import cooperation.qappcenter.remote.SendMsg;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class avgx
{
  protected static ConcurrentHashMap<String, avgx> jY = new ConcurrentHashMap();
  private avgu a;
  public volatile avgv a;
  protected ServiceConnection conn = new avgy(this);
  protected volatile long lastStartSerivceTime = -1L;
  private String mUin;
  protected Object sendLock = new Object();
  public ConcurrentLinkedQueue<SendMsg> sendMsgQueue = new ConcurrentLinkedQueue();
  private String serviceName;
  
  public avgx(String paramString1, String paramString2)
  {
    this.serviceName = paramString1;
    this.mUin = paramString2;
  }
  
  public static avgx a(String paramString)
  {
    try
    {
      if (jY.get(paramString) == null) {
        jY.put(paramString, new avgx(null, paramString));
      }
      paramString = (avgx)jY.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public RecvMsg a(SendMsg paramSendMsg, String paramString)
  {
    paramSendMsg = new RecvMsg(paramSendMsg.getRequestId(), paramSendMsg.getServiceCmd());
    paramSendMsg.setBusinessFail(1002, paramString);
    return paramSendMsg;
  }
  
  public void a(SendMsg paramSendMsg)
  {
    try
    {
      synchronized (this.sendLock)
      {
        if (isConnected())
        {
          b(paramSendMsg);
          return;
        }
        c(paramSendMsg);
        startBaseServiceConn();
      }
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      c(paramSendMsg);
      return;
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_Avgv == null)
      {
        c(paramSendMsg);
        return;
      }
      localException.printStackTrace();
    }
  }
  
  public void a(SendMsg paramSendMsg, RecvMsg paramRecvMsg)
  {
    try
    {
      if (paramSendMsg.a() != null)
      {
        paramSendMsg.a().a(paramRecvMsg);
        return;
      }
      if (this.jdField_a_of_type_Avgu != null)
      {
        this.jdField_a_of_type_Avgu.a(paramRecvMsg);
        return;
      }
    }
    catch (RemoteException paramSendMsg)
    {
      paramSendMsg.printStackTrace();
    }
  }
  
  public void b(SendMsg paramSendMsg)
    throws RemoteException
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new RemoteServiceProxy.3(this, paramSendMsg), 10, null, false);
      return;
    }
    this.jdField_a_of_type_Avgv.a(paramSendMsg);
  }
  
  protected void c(SendMsg paramSendMsg)
  {
    this.sendMsgQueue.add(paramSendMsg);
  }
  
  protected boolean isConnected()
  {
    return this.jdField_a_of_type_Avgv != null;
  }
  
  protected void onBaseServiceConnected()
  {
    RemoteServiceProxy.2 local2 = new RemoteServiceProxy.2(this);
    local2.setName("handleWaitSendProxyMsgThread");
    local2.start();
  }
  
  void startBaseService()
  {
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), QAppCenterPluginProxyService.class);
      avfw.d locald = new avfw.d(1);
      locald.mPluginID = "qappcenter_plugin.apk";
      locald.mPluginName = acfp.m(2131713881);
      locald.mUin = this.mUin;
      if (TextUtils.isEmpty(this.serviceName)) {}
      for (locald.cKu = "com.tencent.plugin.qappcenter.remote.RemoteService";; locald.cKu = this.serviceName)
      {
        locald.mIntent = localIntent;
        locald.mServiceConnection = this.conn;
        avfw.c(BaseApplicationImpl.getApplication(), locald);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RemoteServiceProxy", 2, " start service finish");
        return;
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
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RemoteServiceProxy", 2, "wait start " + this.serviceName + " service result, skiped...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgx
 * JD-Core Version:    0.7.0.1
 */