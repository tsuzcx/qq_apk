package com.tencent.qqmail.model.task;

import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;

public class QMDownloadTask
  extends QMTask
{
  private String src;
  
  public QMDownloadTask(String paramString)
  {
    this.src = paramString;
    setId(generateId());
  }
  
  public static int generateId(String paramString)
  {
    return QMMath.hashInt(paramString);
  }
  
  public int generateId()
  {
    return generateId(this.src);
  }
  
  public String getSrc()
  {
    return this.src;
  }
  
  protected void handleError(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof QMCancelError)) {
        break label24;
      }
      setTaskState(QMTask.QMTaskState.QMTaskStateCanceled);
    }
    for (;;)
    {
      super.handleError(paramObject);
      return;
      label24:
      setTaskState(QMTask.QMTaskState.QMTaskStateFail);
    }
  }
  
  protected void handleRunning(Long paramLong1, Long paramLong2)
  {
    if (((getTaskState() == QMTask.QMTaskState.QMTaskStateReady) || (getTaskState() == QMTask.QMTaskState.QMTaskStateRunning)) && (getTaskState() == QMTask.QMTaskState.QMTaskStateReady)) {
      setTaskState(QMTask.QMTaskState.QMTaskStateRunning);
    }
    super.handleRunning(paramLong1, paramLong2);
  }
  
  protected void handleSucc(Object paramObject)
  {
    setTaskState(QMTask.QMTaskState.QMTaskStateSuccess);
    super.handleSucc(paramObject);
  }
  
  public void setSrc(String paramString)
  {
    this.src = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMDownloadTask
 * JD-Core Version:    0.7.0.1
 */