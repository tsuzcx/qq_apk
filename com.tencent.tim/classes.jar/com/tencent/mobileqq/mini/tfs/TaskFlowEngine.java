package com.tencent.mobileqq.mini.tfs;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.mini.util.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskFlowEngine
  implements Handler.Callback, BaseTask.Callback
{
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_TASK_DONE = 101;
  public static final String TAG = "TaskFlow";
  private List<BaseTask> mAllTasks = new ArrayList();
  private final List<DependFlow> mFlows = new ArrayList();
  private TaskThreadPool mTaskThreadPool;
  private BaseTask[] mTasks;
  
  public TaskFlowEngine()
  {
    try
    {
      int j = DeviceInfoUtil.getNumberOfCPUCores();
      QLog.w("TaskFlow", 1, "create thread pool, cpuCores=" + j);
      if (j > 0) {
        i = j + 1;
      }
      this.mTaskThreadPool = new TaskThreadPool("TaskFlowEngine", 2, i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TaskFlow", 1, "create thread pool error!", localException);
    }
  }
  
  private void executeTask(BaseTask arg1)
  {
    if (??? == null) {
      return;
    }
    List localList = ???.getDependTasks();
    if ((localList == null) || (localList.size() <= 0))
    {
      ???.run();
      return;
    }
    Object localObject2 = this.mFlows.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (((DependFlow)((Iterator)localObject2).next()).mTask != ???);
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i == 0) {
          localObject2 = new DependFlow(???, localList);
        }
        synchronized (this.mFlows)
        {
          this.mFlows.add(localObject2);
          ??? = localList.iterator();
          if (!???.hasNext()) {
            break;
          }
          executeTask((BaseTask)???.next());
        }
      }
    }
  }
  
  private void initCallback(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    for (;;)
    {
      return;
      paramBaseTask.setCallback(this);
      if (!this.mAllTasks.contains(paramBaseTask)) {
        this.mAllTasks.add(paramBaseTask);
      }
      paramBaseTask = paramBaseTask.getDependTasks();
      if ((paramBaseTask != null) && (paramBaseTask.size() > 0))
      {
        paramBaseTask = paramBaseTask.iterator();
        while (paramBaseTask.hasNext()) {
          initCallback((BaseTask)paramBaseTask.next());
        }
      }
    }
  }
  
  public BaseTask[] getTasks()
  {
    return this.mTasks;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public final void initTasks(BaseTask[] paramArrayOfBaseTask)
  {
    this.mFlows.clear();
    this.mAllTasks.clear();
    this.mTasks = paramArrayOfBaseTask;
    if (this.mTasks == null) {}
    for (;;)
    {
      return;
      paramArrayOfBaseTask = this.mTasks;
      int j = paramArrayOfBaseTask.length;
      int i = 0;
      while (i < j)
      {
        initCallback(paramArrayOfBaseTask[i]);
        i += 1;
      }
    }
  }
  
  public void onTaskBegin(BaseTask paramBaseTask) {}
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    while (!paramBaseTask.isSucceed()) {
      return;
    }
    this.mTaskThreadPool.addExecuteTask(new TaskFlowEngine.2(this, paramBaseTask));
  }
  
  public void resetTaskAndDepends(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    for (;;)
    {
      return;
      paramBaseTask.reset();
      Iterator localIterator = this.mAllTasks.iterator();
      while (localIterator.hasNext())
      {
        BaseTask localBaseTask = (BaseTask)localIterator.next();
        if (localBaseTask.isDependTo(paramBaseTask)) {
          localBaseTask.reset();
        }
      }
    }
  }
  
  public void start()
  {
    if ((this.mTasks == null) || (this.mTasks.length <= 0)) {
      return;
    }
    this.mTaskThreadPool.addExecuteTask(new TaskFlowEngine.1(this));
  }
  
  protected void updateFlow(BaseTask paramBaseTask)
  {
    synchronized (this.mFlows)
    {
      Iterator localIterator = this.mFlows.iterator();
      while (localIterator.hasNext())
      {
        DependFlow localDependFlow = (DependFlow)localIterator.next();
        if (localDependFlow.isDepend(paramBaseTask)) {
          localDependFlow.onDependCompleted();
        }
      }
    }
  }
  
  public class DependFlow
  {
    List<BaseTask> mDependTasks;
    BaseTask mTask;
    
    DependFlow(List<BaseTask> paramList)
    {
      this.mTask = paramList;
      Object localObject;
      this.mDependTasks = localObject;
    }
    
    public boolean isDepend(BaseTask paramBaseTask)
    {
      return (this.mDependTasks != null) && (this.mDependTasks.contains(paramBaseTask));
    }
    
    public void onDependCompleted()
    {
      if (this.mDependTasks != null)
      {
        Iterator localIterator = this.mDependTasks.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (((BaseTask)localIterator.next()).isDone());
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          this.mTask.run();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.TaskFlowEngine
 * JD-Core Version:    0.7.0.1
 */