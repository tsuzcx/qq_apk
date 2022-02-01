package com.tencent.weiyun.transmission.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.util.Printer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ThreadUtils
{
  private static final WeakHashMap<Looper, PrinterWrapper> sLooperPrinters = new WeakHashMap();
  private static Handler sMainHandler;
  private static Thread sMainThread = Looper.getMainLooper().getThread();
  
  static
  {
    sMainHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void addLooperPrinter(Looper paramLooper, Printer paramPrinter)
  {
    if (paramLooper == null) {
      throw new RuntimeException("null looper");
    }
    synchronized (sLooperPrinters)
    {
      PrinterWrapper localPrinterWrapper2 = (PrinterWrapper)sLooperPrinters.get(paramLooper);
      PrinterWrapper localPrinterWrapper1 = localPrinterWrapper2;
      if (localPrinterWrapper2 == null)
      {
        localPrinterWrapper1 = new PrinterWrapper();
        sLooperPrinters.put(paramLooper, localPrinterWrapper1);
        paramLooper.setMessageLogging(localPrinterWrapper1);
      }
      localPrinterWrapper1.add(paramPrinter);
      return;
    }
  }
  
  public static void addLooperPrinter(Printer paramPrinter)
  {
    addLooperPrinter(Looper.myLooper(), paramPrinter);
  }
  
  public static Handler getMainHandler()
  {
    return sMainHandler;
  }
  
  public static boolean isMainThread()
  {
    return sMainThread == Thread.currentThread();
  }
  
  public static void post(Runnable paramRunnable)
  {
    sMainHandler.post(paramRunnable);
  }
  
  public static void postDelayed(Runnable paramRunnable, long paramLong)
  {
    sMainHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public static void removeCallbacks(Runnable paramRunnable)
  {
    sMainHandler.removeCallbacks(paramRunnable);
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (isMainThread())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
  
  static final class PrinterWrapper
    implements Printer
  {
    private final AtomicBoolean mHasPendingPrinter = new AtomicBoolean(false);
    private final List<Printer> mPendingPrinters = new LinkedList();
    private final List<Printer> mWrappedPrinters = new ArrayList();
    
    public void add(Printer paramPrinter)
    {
      synchronized (this.mPendingPrinters)
      {
        this.mPendingPrinters.add(paramPrinter);
        this.mHasPendingPrinter.set(true);
        return;
      }
    }
    
    public void println(String paramString)
    {
      if (this.mHasPendingPrinter.getAndSet(false)) {}
      synchronized (this.mPendingPrinters)
      {
        this.mWrappedPrinters.addAll(this.mPendingPrinters);
        this.mPendingPrinters.clear();
        ??? = this.mWrappedPrinters.iterator();
        if (((Iterator)???).hasNext()) {
          ((Printer)((Iterator)???).next()).println(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.thread.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */