package com.tencent.qqmail.model.task;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.qqmail.model.mail.watcher.QMTaskListChangeWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import moai.core.watcher.Watchers;

public class QMTaskManager
{
  private static final int DEFAULT_RUNNING_TASK_COUNT = 3;
  public static final int QM_TASK_TYPE_DOWNLOAD_ATTACH = 3;
  public static final int QM_TASK_TYPE_LOAD_IMAGE = 2;
  public static final int QM_TASK_TYPE_SENDDRAFT = 4;
  public static final int QM_TASK_TYPE_SENDMAIL = 1;
  private static final SparseArray<QMTaskManager> _instanceMap = new SparseArray();
  private HashMap<Integer, QMTask> _taskHashMap = new HashMap();
  private ArrayList<QMTask> _taskList = new ArrayList();
  private ArrayList<Integer> _waitingQueue = new ArrayList();
  private int cancelCnt = 0;
  private QMTask currentTask;
  private int runningTaskCount = 1;
  private QMTask[] runningTaskList;
  private QMTaskSQLiteHelper sqliteHelper;
  private int taskDoneCnt = 0;
  private int taskIndex = 1;
  private QMTaskQueueState taskQueueState;
  private int taskToDoCnt = 0;
  private int type;
  
  public QMTaskManager(int paramInt)
  {
    this.type = paramInt;
    this.sqliteHelper = null;
    if (paramInt != 1) {
      this.runningTaskCount = 3;
    }
    this.runningTaskList = new QMTask[this.runningTaskCount];
    this.taskQueueState = QMTaskQueueState.QMTaskQueueState_Suspending;
  }
  
  private void _delete(int paramInt)
  {
    QMTask localQMTask = getTask(paramInt);
    if (localQMTask != null)
    {
      this._taskHashMap.remove(Integer.valueOf(localQMTask.getId()));
      this._taskList.remove(localQMTask);
      localQMTask.delete();
    }
  }
  
  private void addToWaitingQueue(QMTask arg1)
  {
    int i = ???.getId();
    synchronized (this._waitingQueue)
    {
      if (!this._waitingQueue.contains(Integer.valueOf(i)))
      {
        QMLog.log(4, "QMTaskManager", "addToQueue : " + i);
        this._waitingQueue.add(Integer.valueOf(i));
      }
      return;
    }
  }
  
  private void deleteTodoCnt()
  {
    try
    {
      this.taskToDoCnt -= 1;
      if (this.taskToDoCnt < 0) {
        this.taskToDoCnt = 0;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int detectIfReachMaxPoolSize()
  {
    int i = getIdleThread();
    if (i == -1) {
      this.taskQueueState = QMTaskQueueState.QMTaskQueueState_Running;
    }
    return i;
  }
  
  private void doAddTask(QMTask paramQMTask)
  {
    synchronized (this._waitingQueue)
    {
      if (paramQMTask.isCanAddToQueue()) {
        addToWaitingQueue(paramQMTask);
      }
    }
  }
  
  private int getIdleThread()
  {
    int i = 0;
    while (i < this.runningTaskList.length)
    {
      if (this.runningTaskList[i] == null) {
        return i;
      }
      i += 1;
    }
    this.taskQueueState = QMTaskQueueState.QMTaskQueueState_Running;
    return -1;
  }
  
  private QMTask getTask(int paramInt)
  {
    QMTask localQMTask2 = (QMTask)this._taskHashMap.get(Integer.valueOf(paramInt));
    QMTask localQMTask1 = localQMTask2;
    if (localQMTask2 == null)
    {
      localQMTask1 = localQMTask2;
      if (getSQLite() != null)
      {
        localQMTask1 = getSQLite().getTask(this.type, paramInt);
        this._taskHashMap.put(Integer.valueOf(paramInt), localQMTask1);
      }
    }
    return localQMTask1;
  }
  
  private void putTaskIntoRunningTaskList(QMTask paramQMTask, int paramInt)
  {
    paramQMTask.setRunningIndex(paramInt);
    this.runningTaskList[paramInt] = paramQMTask;
  }
  
  private void run()
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (this._waitingQueue)
      {
        Object localObject1 = new StringBuilder().append("run : waitingQueueSize=").append(this._waitingQueue.size()).append("; QueueStateIsSuspending=");
        if (this.taskQueueState == QMTaskQueueState.QMTaskQueueState_Suspending) {
          bool = true;
        }
        QMLog.log(4, "QMTaskManager", bool);
        if ((this._waitingQueue.size() > 0) && (this.taskQueueState == QMTaskQueueState.QMTaskQueueState_Suspending))
        {
          i = ((Integer)this._waitingQueue.get(0)).intValue();
          this._waitingQueue.remove(0);
          localObject1 = getTask(i);
          if (localObject1 != null)
          {
            int j = getIdleThread();
            QMLog.log(4, "QMTaskManager", "get task and run! index:" + j);
            if (j > -1)
            {
              putTaskIntoRunningTaskList((QMTask)localObject1, j);
              i = detectIfReachMaxPoolSize();
              Threads.runInBackground(new QMTaskManager.1(this, j));
              if ((i > -1) && (this._waitingQueue.size() > 0)) {
                next();
              }
              return;
            }
          }
        }
      }
      int i = -1;
    }
  }
  
  @NonNull
  public static QMTaskManager sharedInstance(int paramInt)
  {
    Object localObject = (QMTaskManager)_instanceMap.get(paramInt);
    if (localObject == null) {
      synchronized (_instanceMap)
      {
        QMTaskManager localQMTaskManager2 = (QMTaskManager)_instanceMap.get(paramInt);
        localObject = localQMTaskManager2;
        if (localQMTaskManager2 == null)
        {
          localObject = new QMTaskManager(paramInt);
          _instanceMap.put(paramInt, localObject);
        }
        return localObject;
      }
    }
    return localQMTaskManager1;
  }
  
  private final void trigerTaskListWatcherOnComplete(QMTask paramQMTask)
  {
    ((QMTaskListChangeWatcher)Watchers.of(QMTaskListChangeWatcher.class)).onTaskComplete(paramQMTask);
  }
  
  public void addToMainLoop(QMTask paramQMTask)
  {
    
    if (paramQMTask.getTaskManager() == null) {
      paramQMTask.setTaskManager(this);
    }
    if (this._taskHashMap.get(Integer.valueOf(paramQMTask.getId())) == null)
    {
      this._taskHashMap.put(Integer.valueOf(paramQMTask.getId()), paramQMTask);
      this._taskList.add(paramQMTask);
    }
    paramQMTask.saveToDB();
    doAddTask(paramQMTask);
  }
  
  public void autoRestart(int paramInt)
  {
    QMTask localQMTask = getTask(paramInt);
    if (localQMTask != null)
    {
      localQMTask.setTaskState(QMTask.QMTaskState.QMTaskStateWaiting);
      localQMTask.updateToDB();
      doAddTask(localQMTask);
    }
  }
  
  public final void bindTaskListChangeWatcherList(QMTaskListChangeWatcher paramQMTaskListChangeWatcher, boolean paramBoolean)
  {
    Watchers.bind(paramQMTaskListChangeWatcher, paramBoolean);
  }
  
  public void cancel(int paramInt)
  {
    QMTask localQMTask = getTask(paramInt);
    if (localQMTask != null) {
      for (;;)
      {
        try
        {
          deleteTodoCnt();
          QMLog.log(4, "QMTaskManager", "start to cancel task : " + localQMTask.getTaskState() + "; " + localQMTask.getRunningIndex());
          if (((localQMTask.getTaskState() == QMTask.QMTaskState.QMTaskStateReady) || (localQMTask.getTaskState() == QMTask.QMTaskState.QMTaskStateRunning)) && (localQMTask.getRunningIndex() > -1) && (localQMTask.getRunningIndex() < this.runningTaskList.length))
          {
            QMLog.log(4, "QMTaskManager", "cancel abort currentTask");
            if (this.runningTaskList[localQMTask.getRunningIndex()] != null) {
              this.runningTaskList[localQMTask.getRunningIndex()].abort();
            }
            return;
          }
          if (localQMTask.getTaskState() != QMTask.QMTaskState.QMTaskStateWaiting) {
            break label242;
          }
          paramInt = localQMTask.getId();
          if (this._waitingQueue.contains(Integer.valueOf(paramInt)))
          {
            QMLog.log(4, "QMTaskManager", "cancel waiting QMTask");
            this._waitingQueue.remove(Integer.valueOf(paramInt));
            localQMTask.cancel();
            if (this._waitingQueue.size() != 0) {
              continue;
            }
            this.taskQueueState = QMTaskQueueState.QMTaskQueueState_Suspending;
            continue;
          }
          QMLog.log(6, "QMTaskManager", "cancel error1");
        }
        finally {}
        localObject.handleError(new QMCancelError(false));
        localObject.handleComplete();
        continue;
        label242:
        QMLog.log(6, "QMTaskManager", "cancel error2");
        localObject.handleError(new QMCancelError(false));
        localObject.handleComplete();
      }
    }
  }
  
  public void cancelAll()
  {
    int i;
    synchronized (this._waitingQueue)
    {
      if (this._waitingQueue != null)
      {
        i = 0;
        while (i < this._waitingQueue.size())
        {
          cancel(((Integer)this._waitingQueue.get(i)).intValue());
          i += 1;
        }
      }
      ??? = this.runningTaskList;
      i = 0;
    }
    try
    {
      while (i < this.runningTaskList.length)
      {
        QMTask localQMTask = this.runningTaskList[i];
        if (localQMTask != null) {
          cancel(localQMTask.getId());
        }
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      return;
    }
    finally {}
  }
  
  public void delete(int paramInt)
  {
    cancel(paramInt);
    _delete(paramInt);
  }
  
  public void deleteAllTask(ArrayList<Integer> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      _delete(((Integer)paramArrayList.next()).intValue());
    }
  }
  
  public int getCancelCnt()
  {
    return this.cancelCnt;
  }
  
  public QMTaskSQLiteHelper getSQLite()
  {
    return this.sqliteHelper;
  }
  
  public QMTask getTaskById(int paramInt)
  {
    if ((this._taskHashMap != null) && (this._taskHashMap.size() > 0)) {
      return (QMTask)this._taskHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public int getTaskDoneCnt()
  {
    return this.taskDoneCnt;
  }
  
  public int getTaskIndex()
  {
    return this.taskIndex;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public ArrayList<QMTask> getTaskList()
  {
    if ((getSQLite() != null) && ((this._taskList == null) || (this._taskList.size() == 0)))
    {
      this._taskList = getSQLite().getTaskList(this.type);
      if (this._taskHashMap != null) {
        this._taskHashMap.clear();
      }
      for (;;)
      {
        int i = 0;
        while (i < this._taskList.size())
        {
          QMTask localQMTask = (QMTask)this._taskList.get(i);
          this._taskHashMap.put(Integer.valueOf(localQMTask.getId()), localQMTask);
          i += 1;
        }
        this._taskHashMap = new HashMap();
      }
    }
    return this._taskList;
  }
  
  public int getTaskToDoCnt()
  {
    return this.taskToDoCnt;
  }
  
  public boolean isRunning()
  {
    return this.taskQueueState == QMTaskQueueState.QMTaskQueueState_Running;
  }
  
  public void next()
  {
    run();
  }
  
  public void onTaskComplete(QMTask paramQMTask)
  {
    QMLog.log(4, "QMTaskManager", "onTaskComplete : " + paramQMTask.getRunningIndex() + "; " + this.runningTaskCount + "; " + this.runningTaskList.length);
    this.taskQueueState = QMTaskQueueState.QMTaskQueueState_Suspending;
    if ((paramQMTask.getRunningIndex() >= 0) && (paramQMTask.getRunningIndex() < this.runningTaskList.length)) {
      this.runningTaskList[paramQMTask.getRunningIndex()] = null;
    }
    for (;;)
    {
      try
      {
        if (this.taskIndex >= this.taskToDoCnt + this.taskDoneCnt)
        {
          resetState();
          if (paramQMTask.getTaskState() == QMTask.QMTaskState.QMTaskStateSuccess)
          {
            this._taskHashMap.remove(Integer.valueOf(paramQMTask.getId()));
            this._taskList.remove(paramQMTask);
          }
          trigerTaskListWatcherOnComplete(paramQMTask);
          paramQMTask.release();
          next();
          return;
        }
        if (paramQMTask.getTaskState() == QMTask.QMTaskState.QMTaskStateCanceled) {
          this.cancelCnt += 1;
        } else {
          this.taskIndex += 1;
        }
      }
      finally {}
    }
  }
  
  public void onTaskError() {}
  
  public void onTaskSuccess()
  {
    try
    {
      this.taskToDoCnt -= 1;
      this.taskDoneCnt += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void resetState()
  {
    try
    {
      this.taskIndex = 1;
      this.taskDoneCnt = 0;
      this.taskToDoCnt = 0;
      this.cancelCnt = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void restart(int paramInt)
  {
    QMTask localQMTask = getTask(paramInt);
    if (localQMTask != null)
    {
      Log.d("QMTaskManager", "restart1");
      localQMTask.setTaskState(QMTask.QMTaskState.QMTaskStateWaiting);
      if (localQMTask.getVerifyKey() == null) {
        localQMTask.setRetryCount(0);
      }
      localQMTask.updateToDB();
      doAddTask(localQMTask);
    }
  }
  
  /* Error */
  public void revertAllTask()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	com/tencent/qqmail/model/task/QMTaskManager:_taskList	Ljava/util/ArrayList;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 74	com/tencent/qqmail/model/task/QMTaskManager:_taskList	Ljava/util/ArrayList;
    //   13: invokevirtual 166	java/util/ArrayList:size	()I
    //   16: istore_1
    //   17: iload_1
    //   18: ifgt +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 74	com/tencent/qqmail/model/task/QMTaskManager:_taskList	Ljava/util/ArrayList;
    //   28: invokevirtual 347	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface 352 1 0
    //   38: ifeq -17 -> 21
    //   41: aload_2
    //   42: invokeinterface 355 1 0
    //   47: checkcast 82	com/tencent/qqmail/model/task/QMTask
    //   50: astore_3
    //   51: aload_3
    //   52: invokevirtual 297	com/tencent/qqmail/model/task/QMTask:getTaskState	()Lcom/tencent/qqmail/model/task/QMTask$QMTaskState;
    //   55: astore 4
    //   57: aload 4
    //   59: getstatic 311	com/tencent/qqmail/model/task/QMTask$QMTaskState:QMTaskStateRunning	Lcom/tencent/qqmail/model/task/QMTask$QMTaskState;
    //   62: if_acmpeq +19 -> 81
    //   65: aload 4
    //   67: getstatic 308	com/tencent/qqmail/model/task/QMTask$QMTaskState:QMTaskStateReady	Lcom/tencent/qqmail/model/task/QMTask$QMTaskState;
    //   70: if_acmpeq +11 -> 81
    //   73: aload 4
    //   75: getstatic 275	com/tencent/qqmail/model/task/QMTask$QMTaskState:QMTaskStateWaiting	Lcom/tencent/qqmail/model/task/QMTask$QMTaskState;
    //   78: if_acmpne -46 -> 32
    //   81: aload_0
    //   82: aload_3
    //   83: invokevirtual 98	com/tencent/qqmail/model/task/QMTask:getId	()I
    //   86: invokevirtual 339	com/tencent/qqmail/model/task/QMTaskManager:cancel	(I)V
    //   89: aload_3
    //   90: getstatic 413	com/tencent/qqmail/model/task/QMTask$QMTaskState:QMTaskStateFail	Lcom/tencent/qqmail/model/task/QMTask$QMTaskState;
    //   93: invokevirtual 279	com/tencent/qqmail/model/task/QMTask:setTaskState	(Lcom/tencent/qqmail/model/task/QMTask$QMTaskState;)V
    //   96: aload_3
    //   97: invokevirtual 282	com/tencent/qqmail/model/task/QMTask:updateToDB	()V
    //   100: goto -68 -> 32
    //   103: astore_2
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_2
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	QMTaskManager
    //   16	2	1	i	int
    //   31	11	2	localIterator	Iterator
    //   103	4	2	localObject	Object
    //   50	47	3	localQMTask	QMTask
    //   55	19	4	localQMTaskState	QMTask.QMTaskState
    // Exception table:
    //   from	to	target	type
    //   2	17	103	finally
    //   24	32	103	finally
    //   32	81	103	finally
    //   81	100	103	finally
  }
  
  public void setCancelCnt(int paramInt)
  {
    try
    {
      this.cancelCnt = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setRunningTaskCount(int paramInt)
  {
    this.runningTaskCount = paramInt;
    QMTask[] arrayOfQMTask = new QMTask[paramInt];
    int i = 0;
    if (i < paramInt)
    {
      if (i < this.runningTaskList.length) {
        arrayOfQMTask[i] = this.runningTaskList[i];
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfQMTask[i] = null;
      }
    }
    this.runningTaskList = arrayOfQMTask;
  }
  
  public void setSQLite(QMTaskSQLiteHelper paramQMTaskSQLiteHelper)
  {
    this.sqliteHelper = paramQMTaskSQLiteHelper;
  }
  
  public void setTaskDoneCnt(int paramInt)
  {
    try
    {
      this.taskDoneCnt = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setTaskIndex(int paramInt)
  {
    try
    {
      this.taskIndex = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setTaskList(ArrayList<QMTask> paramArrayList)
  {
    this._taskList = paramArrayList;
    if (this._taskHashMap != null) {
      this._taskHashMap.clear();
    }
    for (;;)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        QMTask localQMTask = (QMTask)paramArrayList.next();
        this._taskHashMap.put(Integer.valueOf(localQMTask.getId()), localQMTask);
        if (localQMTask.getTaskManager() == null) {
          localQMTask.setTaskManager(this);
        }
      }
      this._taskHashMap = new HashMap();
    }
  }
  
  public void setTaskToDoCnt(int paramInt)
  {
    try
    {
      this.taskToDoCnt = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void startMainLoop()
  {
    QMLog.log(4, "QMTaskManager", "QMTaskManager startMainLoop");
    ValidateHelper.notMainThread();
    for (;;)
    {
      synchronized (this._waitingQueue)
      {
        ArrayList localArrayList2 = getTaskList();
        if (localArrayList2 == null)
        {
          return;
          if (i < localArrayList2.size())
          {
            QMTask localQMTask = (QMTask)localArrayList2.get(i);
            if (!localQMTask.isCanAddToQueue()) {
              break label123;
            }
            addToWaitingQueue(localQMTask);
            break label123;
          }
        }
      }
      int i = 0;
      continue;
      label123:
      i += 1;
    }
  }
  
  static enum QMTaskQueueState
  {
    QMTaskQueueState_Running,  QMTaskQueueState_Suspending;
    
    private QMTaskQueueState() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMTaskManager
 * JD-Core Version:    0.7.0.1
 */