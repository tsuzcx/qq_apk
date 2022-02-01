package com.tencent.mobileqq.apollo.game;

import abln;
import android.os.Bundle;
import android.os.Process;
import aqgz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ApolloGameStateMachine
  extends Observable
{
  public static a a;
  private static ApolloGameStateMachine a;
  public static AtomicBoolean cm = new AtomicBoolean();
  public static final HashMap<Integer, List<Integer>> ip = new ApolloGameStateMachine.3();
  private final Object cj = new Object();
  private ConcurrentHashMap<Integer, StateTask> dt = new ConcurrentHashMap();
  private Observer e = new abln(this);
  private Runnable fx = new ApolloGameStateMachine.1(this);
  private AtomicInteger mCurrentState = new AtomicInteger(0);
  private final Object mLock = new Object();
  private AtomicLong y = new AtomicLong();
  
  public static ApolloGameStateMachine a()
  {
    if (a == null) {}
    for (;;)
    {
      try {}catch (Throwable localThrowable)
      {
        QLog.e("ApolloGameStateMachine", 1, localThrowable, new Object[0]);
        continue;
      }
      try
      {
        if (a == null)
        {
          a = new ApolloGameStateMachine();
          a.cCL();
          if ((a != null) && (a.e != null)) {
            a.addObserver(a.e);
          }
        }
        return a;
      }
      finally {}
    }
  }
  
  public static void cCM()
  {
    if (a != null)
    {
      a.deleteObservers();
      a.destory();
      a = null;
    }
  }
  
  private void exec()
  {
    if (this.dt != null)
    {
      int i = getCurrentState();
      StateTask localStateTask = (StateTask)this.dt.get(Integer.valueOf(i));
      if (localStateTask != null) {
        synchronized (this.cj)
        {
          ThreadManager.post(localStateTask, 5, null, true);
          return;
        }
      }
    }
  }
  
  protected void cCL()
  {
    d(1, new ApolloGameStateMachine.4(this));
    d(5, new ApolloGameStateMachine.5(this));
    d(6, new ApolloGameStateMachine.6(this));
  }
  
  public void d(int paramInt, Runnable paramRunnable)
  {
    if ((this.dt != null) && (paramRunnable != null))
    {
      if ((paramRunnable instanceof StateTask))
      {
        this.dt.put(Integer.valueOf(paramInt), (StateTask)paramRunnable);
        return;
      }
      this.dt.put(Integer.valueOf(paramInt), new StateTask(paramInt, paramRunnable, this));
      return;
    }
    QLog.e("ApolloGameStateMachine", 1, "[setTask] taskList is null rebuild");
    this.dt = new ConcurrentHashMap();
  }
  
  public void destory()
  {
    try
    {
      if (this.fx != null)
      {
        ThreadManager.removeJobFromThreadPool(this.fx, 16);
        this.fx = null;
      }
      if (this.dt != null) {
        this.dt.clear();
      }
      this.e = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameStateMachine", 1, localThrowable, new Object[] { "[destory]" });
    }
  }
  
  public int fY(int paramInt)
  {
    return n(paramInt, "DEFAULT");
  }
  
  public int getCurrentState()
  {
    return this.mCurrentState.get();
  }
  
  public int n(int paramInt, String paramString)
  {
    ??? = (List)ip.get(Integer.valueOf(this.mCurrentState.get()));
    if ((??? != null) && (((List)???).contains(Integer.valueOf(paramInt)))) {
      synchronized (this.cj)
      {
        setChanged();
        Bundle localBundle = new Bundle();
        localBundle.putString("TYPE", "GAME_STATE");
        localBundle.putLong("START_TIME_KEY", this.y.get());
        localBundle.putLong("END_TIME_KEY", System.currentTimeMillis());
        this.y.set(System.currentTimeMillis());
        localBundle.putInt("FROM", this.mCurrentState.get());
        localBundle.putInt("TO", paramInt);
        localBundle.putString("MESSAGE", paramString);
        notifyObservers(localBundle);
        this.mCurrentState.set(paramInt);
        exec();
        return -1;
      }
    }
    QLog.e("ApolloGameStateMachine", 1, "[changeToState] ill");
    return this.mCurrentState.get();
  }
  
  public void reset()
  {
    a();
    synchronized (this.mLock)
    {
      if (this.dt != null)
      {
        this.dt.clear();
        this.mCurrentState.set(0);
        cCL();
        return;
      }
      this.dt = new ConcurrentHashMap();
    }
  }
  
  public static class StateTask
    implements Runnable
  {
    private WeakReference<ApolloGameStateMachine> fA;
    public Runnable mTask;
    public int startState;
    
    public StateTask(int paramInt, Runnable paramRunnable, ApolloGameStateMachine paramApolloGameStateMachine)
    {
      this.startState = paramInt;
      this.mTask = paramRunnable;
      this.fA = new WeakReference(paramApolloGameStateMachine);
    }
    
    public void cCN() {}
    
    public void run()
    {
      if (this.mTask != null)
      {
        this.mTask.run();
        cCN();
      }
    }
  }
  
  public static class a
  {
    public static final long NO = aqgz.getCpuFrequency();
    public static final String bgR;
    public static final String bgS;
    public static final int cpJ;
    public static final String mOsVersion = ;
    public long NP = aqgz.L(Process.myPid());
    public long NQ = aqgz.hH();
    
    static
    {
      bgR = aqgz.getModel();
      bgS = aqgz.getCpuType();
      cpJ = aqgz.getCpuNumber();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine
 * JD-Core Version:    0.7.0.1
 */