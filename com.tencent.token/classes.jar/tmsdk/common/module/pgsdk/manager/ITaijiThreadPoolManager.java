package tmsdk.common.module.pgsdk.manager;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.List;

public abstract interface ITaijiThreadPoolManager
{
  public abstract void addCostTimeTask(Runnable paramRunnable, String paramString);
  
  public abstract void addTask(int paramInt, Runnable paramRunnable, String paramString);
  
  public abstract void addTask(Runnable paramRunnable, String paramString);
  
  public abstract void addUrgentTask(Runnable paramRunnable, String paramString);
  
  public abstract void addUrgentWeakTask(Runnable paramRunnable, String paramString, Object paramObject);
  
  public abstract void addWeakTask(int paramInt, Runnable paramRunnable, String paramString, Object paramObject);
  
  public abstract void addWeakTask(Runnable paramRunnable, String paramString, Object paramObject);
  
  public abstract boolean containsTask(Runnable paramRunnable);
  
  public abstract boolean containsTaskOfCaller(long paramLong);
  
  public abstract Looper getHandlerThreadLooper(String paramString);
  
  public abstract List getRunningTasks();
  
  public abstract void interruptTask(Runnable paramRunnable);
  
  public abstract boolean isTaskAwaiting(Runnable paramRunnable);
  
  public abstract boolean isTaskRunning(Runnable paramRunnable);
  
  public abstract HandlerThread newFreeHandlerThread(String paramString);
  
  public abstract HandlerThread newFreeHandlerThread(String paramString, int paramInt);
  
  public abstract Thread newFreeThread(Runnable paramRunnable, String paramString);
  
  public abstract boolean removeTask(Runnable paramRunnable);
  
  public abstract void removeWeakTask(Runnable paramRunnable);
  
  public abstract void removeWeakTaskOfObject(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager
 * JD-Core Version:    0.7.0.1
 */