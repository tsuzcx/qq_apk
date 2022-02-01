package com.tencent.qqmail.model.task;

class QMTaskManager$1
  implements Runnable
{
  QMTaskManager$1(QMTaskManager paramQMTaskManager, int paramInt) {}
  
  public void run()
  {
    synchronized (QMTaskManager.access$000(this.this$0))
    {
      if (QMTaskManager.access$000(this.this$0) != null)
      {
        QMTask localQMTask = QMTaskManager.access$000(this.this$0)[this.val$index];
        if (localQMTask != null) {
          localQMTask.run();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMTaskManager.1
 * JD-Core Version:    0.7.0.1
 */