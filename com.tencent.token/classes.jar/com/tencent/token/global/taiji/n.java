package com.tencent.token.global.taiji;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.List;
import tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager;
import tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager.TaskInfo;

public class n
  implements ITaijiThreadPoolManager
{
  private c a = new c();
  
  public static n a()
  {
    return a.a();
  }
  
  public void addCostTimeTask(Runnable paramRunnable, String paramString)
  {
    this.a.c(paramRunnable, paramString, 0L);
  }
  
  public void addTask(int paramInt, Runnable paramRunnable, String paramString)
  {
    this.a.a(paramInt, paramRunnable, paramString, 0L);
  }
  
  public void addTask(Runnable paramRunnable, String paramString)
  {
    this.a.a(paramRunnable, paramString, 0L);
  }
  
  public void addUrgentTask(Runnable paramRunnable, String paramString)
  {
    this.a.b(paramRunnable, paramString, 0L);
  }
  
  public void addUrgentWeakTask(Runnable paramRunnable, String paramString, Object paramObject)
  {
    this.a.b(paramRunnable, paramString, 0L, paramObject);
  }
  
  public void addWeakTask(int paramInt, Runnable paramRunnable, String paramString, Object paramObject)
  {
    this.a.a(paramInt, paramRunnable, paramString, 0L, paramObject);
  }
  
  public void addWeakTask(Runnable paramRunnable, String paramString, Object paramObject)
  {
    this.a.a(paramRunnable, paramString, 0L, paramObject);
  }
  
  public boolean containsTask(Runnable paramRunnable)
  {
    return this.a.e(paramRunnable);
  }
  
  public boolean containsTaskOfCaller(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public Looper getHandlerThreadLooper(String paramString)
  {
    return this.a.c(0L);
  }
  
  public List<ITaijiThreadPoolManager.TaskInfo> getRunningTasks()
  {
    return null;
  }
  
  public void interruptTask(Runnable paramRunnable)
  {
    this.a.b(paramRunnable);
  }
  
  public boolean isTaskAwaiting(Runnable paramRunnable)
  {
    return this.a.d(paramRunnable);
  }
  
  public boolean isTaskRunning(Runnable paramRunnable)
  {
    return this.a.c(paramRunnable);
  }
  
  public HandlerThread newFreeHandlerThread(String paramString)
  {
    return this.a.a(paramString, 0, 0L);
  }
  
  public HandlerThread newFreeHandlerThread(String paramString, int paramInt)
  {
    return this.a.a(paramString, paramInt, 0L);
  }
  
  public Thread newFreeThread(Runnable paramRunnable, String paramString)
  {
    return this.a.d(paramRunnable, paramString, 0L);
  }
  
  public boolean removeTask(Runnable paramRunnable)
  {
    return this.a.a(paramRunnable);
  }
  
  public void removeWeakTask(Runnable paramRunnable)
  {
    this.a.b(paramRunnable);
  }
  
  public void removeWeakTaskOfObject(Object paramObject)
  {
    this.a.a(paramObject);
  }
  
  private static class a
  {
    private static final n a = new n(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.n
 * JD-Core Version:    0.7.0.1
 */