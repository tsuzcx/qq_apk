package com.tencent.moai.mailsdk.task;

import com.tencent.moai.mailsdk.exception.MessageException;

public abstract interface Task
{
  public abstract void doTask(Handler paramHandler)
    throws MessageException;
  
  public abstract int getPriority();
  
  public abstract String getTag();
  
  public abstract boolean needAuthenticate();
  
  public abstract void setTag(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.task.Task
 * JD-Core Version:    0.7.0.1
 */