import android.content.ServiceConnection;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkPluginProxyService;
import cooperation.qlink.QlinkServiceProxy.2;
import cooperation.qlink.SendMsg;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class avhs
{
  private volatile avhb a;
  private boolean dnc;
  private Object ga = new Object();
  private volatile long lastStartSerivceTime = -1L;
  private AppRuntime mApp;
  private ServiceConnection mServiceConnection = new avht(this);
  private ConcurrentLinkedQueue<SendMsg> sendMsgQueue = new ConcurrentLinkedQueue();
  
  public avhs(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  private void g(SendMsg paramSendMsg)
  {
    this.sendMsgQueue.add(paramSendMsg);
  }
  
  private void h(SendMsg paramSendMsg)
    throws RemoteException
  {
    this.a.a(paramSendMsg);
  }
  
  private boolean isConnected()
  {
    return this.a != null;
  }
  
  private void onBaseServiceConnected()
  {
    QlinkServiceProxy.2 local2 = new QlinkServiceProxy.2(this);
    local2.setName("handleWaitSendProxyMsgThread");
    local2.start();
  }
  
  /* Error */
  public void a(SendMsg paramSendMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	avhs:ga	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokespecial 96	avhs:isConnected	()Z
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 61	avhs:h	(Lcooperation/qlink/SendMsg;)V
    //   19: aload_2
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 65	avhs:dnc	Z
    //   26: ifeq +23 -> 49
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 98	avhs:g	(Lcooperation/qlink/SendMsg;)V
    //   34: goto -15 -> 19
    //   37: astore_3
    //   38: aload_2
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    //   42: astore_2
    //   43: aload_0
    //   44: aload_1
    //   45: invokespecial 98	avhs:g	(Lcooperation/qlink/SendMsg;)V
    //   48: return
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 65	avhs:dnc	Z
    //   54: aload_0
    //   55: aload_1
    //   56: invokespecial 98	avhs:g	(Lcooperation/qlink/SendMsg;)V
    //   59: aload_0
    //   60: invokevirtual 101	avhs:startBaseServiceConn	()V
    //   63: goto -44 -> 19
    //   66: astore_2
    //   67: aload_0
    //   68: getfield 49	avhs:a	Lavhb;
    //   71: ifnonnull +9 -> 80
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 98	avhs:g	(Lcooperation/qlink/SendMsg;)V
    //   79: return
    //   80: aload_2
    //   81: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   84: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	avhs
    //   0	85	1	paramSendMsg	SendMsg
    //   42	1	2	localDeadObjectException	android.os.DeadObjectException
    //   66	15	2	localException	java.lang.Exception
    //   37	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	37	finally
    //   19	21	37	finally
    //   22	34	37	finally
    //   38	40	37	finally
    //   49	63	37	finally
    //   0	7	42	android/os/DeadObjectException
    //   40	42	42	android/os/DeadObjectException
    //   0	7	66	java/lang/Exception
    //   40	42	66	java/lang/Exception
  }
  
  public void startBaseServiceConn()
  {
    long l = System.currentTimeMillis();
    if ((this.lastStartSerivceTime == -1L) || (l - this.lastStartSerivceTime > 10000L))
    {
      this.lastStartSerivceTime = l;
      QlinkPluginProxyService.c(this.mApp, this.mServiceConnection);
      return;
    }
    QLog.d("QlinkServiceProxy", 1, "wait start qlink service result, skiped...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avhs
 * JD-Core Version:    0.7.0.1
 */