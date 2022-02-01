package com.tencent.qqmail.utilities.qmnetwork;

public class QMCancelError
  extends QMNetworkError
{
  public final boolean isUserAborted;
  
  public QMCancelError(boolean paramBoolean)
  {
    super(1, -10002, "请求已经被取消", "");
    this.isUserAborted = paramBoolean;
  }
  
  public String toString()
  {
    return super.toString() + "{aborted:" + this.isUserAborted + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMCancelError
 * JD-Core Version:    0.7.0.1
 */