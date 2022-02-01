package com.tencent.qplus.swingworker;

import java.util.List;

class SwingWorker$3
  extends AccumulativeRunnable<V>
{
  SwingWorker$3(SwingWorker paramSwingWorker) {}
  
  public void run(List<V> paramList)
  {
    this.this$0.process(paramList);
  }
  
  protected void submit()
  {
    SwingWorker.access$0(this.this$0).add(new Runnable[] { this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SwingWorker.3
 * JD-Core Version:    0.7.0.1
 */