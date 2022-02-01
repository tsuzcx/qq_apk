import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

public class awom
{
  private static volatile awom a;
  private String bcr;
  private boolean bvf;
  private Object cb = new Object();
  private boolean ch;
  
  public static awom a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awom();
      }
      return a;
    }
    finally {}
  }
  
  private void connect()
  {
    this.ch = true;
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "begin connect:");
    }
    QIPCClientHelper.getInstance().getClient().addListener(new awon(this));
    long l = System.currentTimeMillis();
    QIPCClientHelper.getInstance().getClient().connect(new awoo(this, l));
  }
  
  public void ctN()
  {
    if ((!this.bvf) && (!this.ch)) {
      connect();
    }
    if (!this.bvf) {
      synchronized (this.cb)
      {
        boolean bool = this.bvf;
        if (!bool) {}
        try
        {
          this.cb.wait(500L);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awom
 * JD-Core Version:    0.7.0.1
 */