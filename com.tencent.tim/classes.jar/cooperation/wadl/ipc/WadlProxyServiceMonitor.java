package cooperation.wadl.ipc;

import android.os.Bundle;
import asbt;
import awoa;
import awof;
import com.tencent.qphone.base.util.QLog;

public class WadlProxyServiceMonitor
  implements awoa
{
  private static String TAG = "WadlProxyServiceMonitor";
  private awof jdField_a_of_type_Awof;
  private MonitorWorkingThread jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread;
  private long aBr = 10000L;
  private volatile boolean drc;
  private long lastReportTime;
  
  public WadlProxyServiceMonitor(awof paramawof)
  {
    this.jdField_a_of_type_Awof = paramawof;
  }
  
  private boolean NP()
  {
    return this.drc;
  }
  
  public boolean aNj()
  {
    return NP();
  }
  
  public boolean aNk()
  {
    if (this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread != null) {
      return this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.running;
    }
    return false;
  }
  
  public void eEy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        asbt.i(TAG, "##@stopMonitoring(), isAnyTaskActive:" + this.drc);
      }
      if (this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread != null) {
        this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.running = false;
      }
      this.drc = false;
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread = null;
      return;
    }
    finally {}
  }
  
  public void eEz()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          asbt.i(TAG, "##@startMonitoring()");
        }
        if (!aNk()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          asbt.i(TAG, "##@startMonitoring():Monitor is running");
        }
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      finally {}
      return;
      this.drc = true;
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread = new MonitorWorkingThread(null);
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.running = true;
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.setName("WadlProxyService.Monitor.Thread");
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.start();
    }
  }
  
  public void ep(Bundle paramBundle)
  {
    this.lastReportTime = System.currentTimeMillis();
    if (paramBundle == null) {}
    do
    {
      return;
      this.drc = paramBundle.getBoolean("WADL_UNFINISHED_RUNING_TASK_FLAG");
    } while (!QLog.isColorLevel());
    asbt.i(TAG, "##@onReportFromDownloadTask(), isAnyTaskActive:" + this.drc);
  }
  
  class MonitorWorkingThread
    extends Thread
  {
    public volatile boolean running = true;
    
    private MonitorWorkingThread() {}
    
    public void run()
    {
      try
      {
        while (this.running)
        {
          Thread.sleep(WadlProxyServiceMonitor.a(WadlProxyServiceMonitor.this));
          long l = System.currentTimeMillis();
          if ((WadlProxyServiceMonitor.b(WadlProxyServiceMonitor.this) != 0L) && (l - WadlProxyServiceMonitor.b(WadlProxyServiceMonitor.this) > 30000L) && (WadlProxyServiceMonitor.a(WadlProxyServiceMonitor.this)) && (WadlProxyServiceMonitor.a(WadlProxyServiceMonitor.this) != null))
          {
            if (QLog.isColorLevel()) {
              asbt.i(WadlProxyServiceMonitor.TAG, "##@<<<MonitorWorkingThread: check ipc service status...");
            }
            WadlProxyServiceMonitor.a(WadlProxyServiceMonitor.this).eEA();
          }
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceMonitor
 * JD-Core Version:    0.7.0.1
 */