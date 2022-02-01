package org.junit.runners.model;

public abstract interface RunnerScheduler
{
  public abstract void finished();
  
  public abstract void schedule(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runners.model.RunnerScheduler
 * JD-Core Version:    0.7.0.1
 */