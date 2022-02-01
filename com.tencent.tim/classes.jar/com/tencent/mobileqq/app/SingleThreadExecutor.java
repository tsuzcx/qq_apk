package com.tencent.mobileqq.app;

import acmo;
import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public class SingleThreadExecutor
  extends acmo
{
  private final Object lock = new Object();
  @GuardedBy("lock")
  private final Queue<Runnable> queue = new LinkedList();
  @GuardedBy("lock")
  private boolean running;
  
  public SingleThreadExecutor(int paramInt)
  {
    super(paramInt);
  }
  
  public void execute(@NonNull Runnable arg1)
  {
    Task localTask = new Task(???, null);
    synchronized (this.lock)
    {
      if (!this.running)
      {
        this.running = true;
        super.execute(localTask);
        return;
      }
      this.queue.offer(localTask);
    }
  }
  
  class Task
    implements Runnable
  {
    final Runnable fM;
    
    private Task(Runnable paramRunnable)
    {
      this.fM = paramRunnable;
    }
    
    public void run()
    {
      this.fM.run();
      synchronized (SingleThreadExecutor.a(SingleThreadExecutor.this))
      {
        Runnable localRunnable = (Runnable)SingleThreadExecutor.a(SingleThreadExecutor.this).poll();
        if (localRunnable == null) {
          SingleThreadExecutor.a(SingleThreadExecutor.this, false);
        }
        if (localRunnable != null) {
          SingleThreadExecutor.a(SingleThreadExecutor.this, localRunnable);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.SingleThreadExecutor
 * JD-Core Version:    0.7.0.1
 */