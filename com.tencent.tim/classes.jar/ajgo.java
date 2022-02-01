import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajgo
{
  private static ajgo a;
  private AtomicBoolean dt = new AtomicBoolean(false);
  private Executor p;
  
  private ajgo()
  {
    if (this.p == null)
    {
      int i = Runtime.getRuntime().availableProcessors();
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.corePoolsize = i;
      localThreadPoolParams.maxPooolSize = i;
      localThreadPoolParams.priority = 5;
      localThreadPoolParams.poolThreadName = "msgbackup_Tranport_Executor";
      this.p = ThreadManager.newFreeThreadPool(localThreadPoolParams);
    }
  }
  
  public static ajgo a()
  {
    try
    {
      if (a == null) {
        a = new ajgo();
      }
      ajgo localajgo = a;
      return localajgo;
    }
    finally {}
  }
  
  public void dxo()
  {
    ajgv.b("MsgBackupMsgBackupTransportExecutor", "msgbackup destroy-------------> destroyed = " + this.dt.get(), new Object[0]);
    if (this.dt.get()) {
      return;
    }
    this.dt.set(true);
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (this.p == null) {
      ajgv.b("MsgBackupMsgBackupTransportExecutor", "thread pool is destroyed!", new Object[0]);
    }
    this.p.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgo
 * JD-Core Version:    0.7.0.1
 */