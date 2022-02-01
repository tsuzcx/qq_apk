package com.tencent.moai.mailsdk.task;

import com.tencent.moai.mailsdk.exception.MessageException;

public class BaseTask
  implements Task
{
  public static final int TASK_PRIORITY_BASE = 1;
  public static final int TASK_PRIORITY_LIST = 3;
  public static final int TASK_PRIORITY_MAIL = 4;
  public static final int TASK_PRIORITY_OPERATION = 2;
  private String tag;
  
  public BaseTask(String paramString)
  {
    this.tag = paramString;
  }
  
  public void doTask(Handler paramHandler)
    throws MessageException
  {}
  
  public int getPriority()
  {
    return 1;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public boolean needAuthenticate()
  {
    return true;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.task.BaseTask
 * JD-Core Version:    0.7.0.1
 */