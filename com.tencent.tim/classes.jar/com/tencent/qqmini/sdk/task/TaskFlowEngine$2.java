package com.tencent.qqmini.sdk.task;

class TaskFlowEngine$2
  implements Runnable
{
  TaskFlowEngine$2(TaskFlowEngine paramTaskFlowEngine) {}
  
  public void run()
  {
    BaseTask[] arrayOfBaseTask = this.this$0.mTasks;
    int j = arrayOfBaseTask.length;
    int i = 0;
    while (i < j)
    {
      BaseTask localBaseTask = arrayOfBaseTask[i];
      this.this$0.executeTask(localBaseTask);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskFlowEngine.2
 * JD-Core Version:    0.7.0.1
 */