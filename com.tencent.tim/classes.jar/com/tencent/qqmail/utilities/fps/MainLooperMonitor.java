package com.tencent.qqmail.utilities.fps;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Printer;
import com.tencent.qqmail.utilities.log.QMLog;

public class MainLooperMonitor
  implements Monitor
{
  private static final String BLOCK_TAG = "LooperMonitor_Block";
  private static final long DEFAULT_BLOCK_THREASHOLD = 200L;
  private static final String END_OF_DISPATCH = "<<<<< Finished to";
  private static final String START_OF_DISPATCH = ">>>>> Dispatching to";
  private static final String TAG = "LooperMonitor";
  private static volatile MainLooperMonitor instance;
  private long block_threadhold = 200L;
  private Handler handler;
  private HandlerThreadWrapper handlerThreadWrapper;
  private long loopendTimestamp = -1L;
  private long loopstartTimestamp = -1L;
  private Thread mainThread;
  private Printer monitorPrinter;
  private Runnable monitorRunnable;
  private boolean monitoring = false;
  private StackTraceElement[] stackTraceElements;
  
  private MainLooperMonitor()
  {
    Log.i("LooperMonitor", "availableProcessors = " + Runtime.getRuntime().availableProcessors());
    this.handlerThreadWrapper = new HandlerThreadWrapper("HandlerThreadWrapper");
    this.mainThread = Looper.getMainLooper().getThread();
    this.handler = this.handlerThreadWrapper.getHandler();
    this.monitorRunnable = new MainLooperMonitor.1(this);
    this.monitorPrinter = new MainLooperMonitor.2(this);
  }
  
  private void collectJavaStack()
  {
    this.stackTraceElements = this.mainThread.getStackTrace();
  }
  
  public static MainLooperMonitor getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MainLooperMonitor();
      }
      return instance;
    }
    finally {}
  }
  
  private boolean isBlock()
  {
    long l = this.loopendTimestamp - this.loopstartTimestamp;
    if (l > this.block_threadhold)
    {
      QMLog.log(4, "LooperMonitor_Block", "### Block time : " + l);
      return true;
    }
    return false;
  }
  
  public boolean isMonitoring()
  {
    return this.monitoring;
  }
  
  public void startMonitor()
  {
    this.monitoring = true;
    Looper.getMainLooper().setMessageLogging(this.monitorPrinter);
  }
  
  public void stopMonitor()
  {
    this.monitoring = false;
    Looper.getMainLooper().setMessageLogging(null);
  }
  
  static class HandlerThreadWrapper
  {
    private Handler handler;
    private HandlerThread handlerThread;
    
    public HandlerThreadWrapper(String paramString)
    {
      this.handlerThread = new HandlerThread(paramString);
      this.handlerThread.start();
      this.handler = new Handler(this.handlerThread.getLooper());
    }
    
    public Handler getHandler()
    {
      return this.handler;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.fps.MainLooperMonitor
 * JD-Core Version:    0.7.0.1
 */