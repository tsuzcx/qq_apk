package com.tencent.qplus.task;

import java.util.List;

public abstract interface TaskListener<T, V>
{
  public abstract void cancelled(TaskEvent<Void> paramTaskEvent);
  
  public abstract void doInBackground(TaskEvent<Void> paramTaskEvent);
  
  public abstract void failed(TaskEvent<Throwable> paramTaskEvent);
  
  public abstract void finished(TaskEvent<Void> paramTaskEvent);
  
  public abstract void interrupted(TaskEvent<InterruptedException> paramTaskEvent);
  
  public abstract void process(TaskEvent<List<V>> paramTaskEvent);
  
  public abstract void succeeded(TaskEvent<T> paramTaskEvent);
  
  public static class Adapter<T, V>
    implements TaskListener<T, V>
  {
    public void cancelled(TaskEvent<Void> paramTaskEvent) {}
    
    public void doInBackground(TaskEvent<Void> paramTaskEvent) {}
    
    public void failed(TaskEvent<Throwable> paramTaskEvent) {}
    
    public void finished(TaskEvent<Void> paramTaskEvent) {}
    
    public void interrupted(TaskEvent<InterruptedException> paramTaskEvent) {}
    
    public void process(TaskEvent<List<V>> paramTaskEvent) {}
    
    public void succeeded(TaskEvent<T> paramTaskEvent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.task.TaskListener
 * JD-Core Version:    0.7.0.1
 */