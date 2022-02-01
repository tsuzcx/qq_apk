package com.tencent.qqmail.utilities.imageextention;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class QMImageLoader
{
  public static final String TAG = "QMImageLoader";
  private static final int THREAD_POOL_SIZE = 2;
  private static final long THREAD_SLEEP_MILLS = 50L;
  private static final AtomicInteger i = new AtomicInteger(0);
  private static QMImageLoader instance = new QMImageLoader();
  private QMImageCacher cacher;
  private boolean isThreadPoolRunning = false;
  private List<WorkerThread> threadPool = new ArrayList(2);
  private List<QMImageLoaderTask> waitingTasks = new LinkedList();
  
  private void addTask(String arg1, QMImageLoaderTask.LoadImageTaskCallback paramLoadImageTaskCallback)
  {
    paramLoadImageTaskCallback = new QMImageLoaderTask(???, paramLoadImageTaskCallback);
    synchronized (this.waitingTasks)
    {
      this.waitingTasks.add(paramLoadImageTaskCallback);
      this.waitingTasks.notifyAll();
      return;
    }
  }
  
  private void clearCache(boolean paramBoolean)
  {
    if (this.cacher != null)
    {
      if (paramBoolean) {
        this.cacher.clearAndSetNull();
      }
    }
    else {
      return;
    }
    this.cacher.clear();
  }
  
  private void finishTaskOnMainThread(QMImageLoaderTask paramQMImageLoaderTask, QMImageLoaderCallback paramQMImageLoaderCallback)
  {
    if (!this.isThreadPoolRunning) {}
    for (;;)
    {
      return;
      if (paramQMImageLoaderTask.isOOME)
      {
        clearCache(false);
        System.gc();
      }
      while (paramQMImageLoaderTask.state != QMImageLoaderTask.STATE_CANCELED)
      {
        paramQMImageLoaderCallback.handleFinishLoadingImage(paramQMImageLoaderTask);
        paramQMImageLoaderTask.recycle();
        return;
        this.cacher.addImage(paramQMImageLoaderTask.key, paramQMImageLoaderTask.result);
      }
    }
  }
  
  public static QMImageLoader getInstance()
  {
    return instance;
  }
  
  private void initLoader()
  {
    if (this.cacher == null) {
      this.cacher = new QMImageCacher();
    }
    startWorkers();
  }
  
  private void startWorkers()
  {
    if (this.isThreadPoolRunning) {}
    for (;;)
    {
      return;
      this.isThreadPoolRunning = true;
      int j = 0;
      while (j < 2)
      {
        WorkerThread localWorkerThread = new WorkerThread();
        this.threadPool.add(localWorkerThread);
        localWorkerThread.start();
        j += 1;
      }
    }
  }
  
  private void stopWorkers()
  {
    this.isThreadPoolRunning = false;
    ??? = this.threadPool.iterator();
    while (((Iterator)???).hasNext()) {
      ((WorkerThread)((Iterator)???).next()).stopWorker();
    }
    this.threadPool.clear();
    synchronized (this.waitingTasks)
    {
      this.waitingTasks.notifyAll();
      return;
    }
  }
  
  public void clearWaitingTasks(boolean paramBoolean)
  {
    synchronized (this.waitingTasks)
    {
      Iterator localIterator = this.waitingTasks.iterator();
      if (localIterator.hasNext()) {
        ((QMImageLoaderTask)localIterator.next()).cancel();
      }
    }
    this.waitingTasks.clear();
    if (paramBoolean) {
      System.gc();
    }
  }
  
  public Bitmap loadImage(String paramString, QMImageLoaderCallback paramQMImageLoaderCallback)
  {
    if (paramString == null) {}
    Bitmap localBitmap;
    do
    {
      return null;
      initLoader();
      localBitmap = this.cacher.getImage(paramString);
      if (localBitmap != null) {
        return localBitmap;
      }
    } while (paramQMImageLoaderCallback == null);
    addTask(paramString, new QMImageLoader.1(this, paramQMImageLoaderCallback));
    return localBitmap;
  }
  
  public Bitmap loadImageByKey(String paramString)
  {
    if (this.cacher == null) {
      return null;
    }
    return this.cacher.getImage(paramString);
  }
  
  public void recycle()
  {
    clearWaitingTasks(false);
    stopWorkers();
    clearCache(true);
    this.cacher = null;
    System.gc();
  }
  
  public static abstract interface QMImageLoaderCallback
  {
    public abstract void handleFinishLoadingImage(QMImageLoaderTask paramQMImageLoaderTask);
    
    public abstract void loadImageInBackground(QMImageLoaderTask paramQMImageLoaderTask);
  }
  
  class WorkerThread
    extends Thread
  {
    private boolean isThreadRunning;
    private QMImageLoaderTask runningTask;
    
    public WorkerThread()
    {
      setPriority(3);
      setName("QMImageLoader #" + QMImageLoader.i.getAndIncrement());
    }
    
    public void run()
    {
      this.isThreadRunning = true;
      if (this.isThreadRunning) {
        try
        {
          for (;;)
          {
            Thread.sleep(50L);
            synchronized (QMImageLoader.this.waitingTasks)
            {
              if (QMImageLoader.this.waitingTasks.size() == 0) {
                QMImageLoader.this.waitingTasks.wait();
              }
              if (QMImageLoader.this.waitingTasks.size() > 0) {
                this.runningTask = ((QMImageLoaderTask)QMImageLoader.this.waitingTasks.remove(0));
              }
              if ((this.runningTask != null) && (this.isThreadRunning)) {
                this.runningTask.run();
              }
              this.runningTask = null;
            }
          }
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          this.isThreadRunning = false;
        }
      }
    }
    
    public void stopWorker()
    {
      this.isThreadRunning = false;
      if (this.runningTask != null) {
        this.runningTask.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.QMImageLoader
 * JD-Core Version:    0.7.0.1
 */