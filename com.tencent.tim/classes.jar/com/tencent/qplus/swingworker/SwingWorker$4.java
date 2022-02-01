package com.tencent.qplus.swingworker;

import java.util.List;

class SwingWorker$4
  extends AccumulativeRunnable<Integer>
{
  SwingWorker$4(SwingWorker paramSwingWorker) {}
  
  public void run(List<Integer> paramList)
  {
    this.this$0.firePropertyChange("progress", paramList.get(0), paramList.get(paramList.size() - 1));
  }
  
  protected void submit()
  {
    SwingWorker.access$0(this.this$0).add(new Runnable[] { this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SwingWorker.4
 * JD-Core Version:    0.7.0.1
 */