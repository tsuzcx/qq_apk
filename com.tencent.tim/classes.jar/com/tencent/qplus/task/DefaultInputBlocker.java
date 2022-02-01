package com.tencent.qplus.task;

import android.view.View;

final class DefaultInputBlocker
  extends AbstractTask.InputBlocker
{
  DefaultInputBlocker(Task paramTask, AbstractTask.BlockingScope paramBlockingScope, Object paramObject)
  {
    super(paramTask, paramBlockingScope, paramObject);
  }
  
  private void setComponentTargetBlocked(boolean paramBoolean)
  {
    View localView = (View)getTarget();
    if (paramBoolean) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      localView.setEnabled(paramBoolean);
      return;
    }
  }
  
  protected void block()
  {
    switch (getScope())
    {
    default: 
      return;
    }
    setComponentTargetBlocked(true);
  }
  
  protected void unblock()
  {
    switch (getScope())
    {
    default: 
      return;
    }
    setComponentTargetBlocked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.task.DefaultInputBlocker
 * JD-Core Version:    0.7.0.1
 */