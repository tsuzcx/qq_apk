package com.tencent.qqmail.animation;

import java.util.Stack;

public class SynchronousAnimator
{
  private Stack<Runnable> animationTask = new Stack();
  
  public void animationCompelete()
  {
    if (isAllAnimationComplete()) {
      onAllAnimationComplete();
    }
  }
  
  public boolean isAllAnimationComplete()
  {
    return false;
  }
  
  public boolean isAllAnimationStart()
  {
    return false;
  }
  
  public void onAllAnimationComplete() {}
  
  public void pushAnimation(Runnable paramRunnable)
  {
    try
    {
      this.animationTask.push(paramRunnable);
      if (isAllAnimationStart()) {
        while (!this.animationTask.empty())
        {
          paramRunnable = (Runnable)this.animationTask.pop();
          if (paramRunnable != null) {
            paramRunnable.run();
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.SynchronousAnimator
 * JD-Core Version:    0.7.0.1
 */