import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.app.Foreground;

public class tyj
  implements Handler.Callback
{
  private static tyj a;
  public static int bDd = 0;
  public static ArrayList<String> oH = new ArrayList();
  public boolean aQJ = MagnifierSDK.a().a().Ot();
  private Handler bI = new Handler(ThreadManager.getSubThreadLooper(), this);
  private Vector<txh> n = new Vector();
  
  private tyj()
  {
    a(sxa.a());
  }
  
  public static tyj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new tyj();
      }
      return a;
    }
    finally {}
  }
  
  private void a(int paramInt, swx.a parama)
  {
    synchronized (this.n)
    {
      Iterator localIterator = this.n.iterator();
      if (localIterator.hasNext()) {
        ((txh)localIterator.next()).a(paramInt, parama);
      }
    }
  }
  
  private void bEW()
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    long l3 = (100 - MagnifierSDK.a().a().bDb) * Runtime.getRuntime().maxMemory() / 100L;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryReporter", 2, new Object[] { "ReportDump  calculateSharpMemory heapSize= ", Long.valueOf(l1 - l2) });
    }
    if (bDd == 0) {}
  }
  
  public void a(txh paramtxh)
  {
    synchronized (this.n)
    {
      this.n.add(paramtxh);
      return;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, swx paramswx, int paramInt)
  {
    swx.a locala = paramswx.a(paramInt);
    if ((locala != null) && (paramLong1 >= locala.bzP * paramLong2 / 100L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MemoryReporter", 2, "onNeedTrimMemory|maxHeap=" + paramLong2 / 1024L / 1024L + ",totalSize=" + paramLong1 / 1024L / 84L);
      }
      paramswx.delay = locala.delayTime;
      a(paramInt, locala);
      return true;
    }
    return false;
  }
  
  public void b(txh paramtxh)
  {
    synchronized (this.n)
    {
      this.n.remove(paramtxh);
      return;
    }
  }
  
  public void bEV()
  {
    bDd = 2;
    if (QLog.isColorLevel()) {
      QLog.d("MemoryReporter", 2, new Object[] { "ReportDump setDumpReported = ", Integer.valueOf(bDd) });
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (Foreground.sCountResume > 0) {}
    for (boolean bool = true;; bool = false) {
      switch (paramMessage.what)
      {
      default: 
        return true;
      }
    }
    bEW();
    sxa.a().vj(bool);
    this.bI.removeMessages(1);
    paramMessage = this.bI;
    if (bool) {}
    for (long l1 = 5000L;; l1 = 30000L)
    {
      paramMessage.sendEmptyMessageDelayed(1, l1);
      break;
    }
    l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().maxMemory();
    paramMessage = MagnifierSDK.a().a().a;
    sxa.a().bBI();
    int i;
    if (a(l1, l2, paramMessage, 1)) {
      i = paramMessage.delay * 1000;
    }
    for (;;)
    {
      this.bI.removeMessages(2);
      int j = i;
      if (!bool)
      {
        j = i;
        if (i >= 30000) {
          j = i * 2;
        }
      }
      this.bI.sendEmptyMessageDelayed(2, j);
      break;
      if (a(l1, l2, paramMessage, 2)) {
        i = paramMessage.delay * 1000;
      } else if (a(l1, l2, paramMessage, 3)) {
        i = paramMessage.delay * 1000;
      } else {
        i = 30000;
      }
    }
  }
  
  public void onLowMemory(long paramLong)
  {
    synchronized (this.n)
    {
      Iterator localIterator = this.n.iterator();
      if (localIterator.hasNext()) {
        ((txh)localIterator.next()).onLowMemory(paramLong);
      }
    }
  }
  
  public void startRecord()
  {
    if (MagnifierSDK.a().a().a.aNO) {
      this.bI.sendEmptyMessage(2);
    }
    if (this.aQJ) {
      this.bI.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyj
 * JD-Core Version:    0.7.0.1
 */