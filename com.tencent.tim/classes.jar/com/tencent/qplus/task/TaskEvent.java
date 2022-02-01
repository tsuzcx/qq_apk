package com.tencent.qplus.task;

import java.util.EventObject;

public class TaskEvent<T>
  extends EventObject
{
  private final T value;
  
  public TaskEvent(AbstractTask paramAbstractTask, T paramT)
  {
    super(paramAbstractTask);
    this.value = paramT;
  }
  
  public final T getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.task.TaskEvent
 * JD-Core Version:    0.7.0.1
 */