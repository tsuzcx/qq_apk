package com.tencent.component.animation.rebound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AnimationQueue
{
  private final Queue<Double> mAnimationQueue = new LinkedList();
  private final List<Callback> mCallbacks = new ArrayList();
  private final ChoreographerCompat mChoreographer = ChoreographerCompat.getInstance();
  private final ChoreographerCompat.FrameCallback mChoreographerCallback = new AnimationQueue.1(this);
  private final Queue<Double> mPendingQueue = new LinkedList();
  private boolean mRunning;
  private final ArrayList<Double> mTempValues = new ArrayList();
  
  private void onFrame(long paramLong)
  {
    Double localDouble = (Double)this.mPendingQueue.poll();
    int i;
    int j;
    if (localDouble != null)
    {
      this.mAnimationQueue.offer(localDouble);
      i = 0;
      this.mTempValues.addAll(this.mAnimationQueue);
      j = this.mTempValues.size() - 1;
      label56:
      if (j > -1) {
        break label149;
      }
      this.mTempValues.clear();
    }
    for (;;)
    {
      if (this.mAnimationQueue.size() + i < this.mCallbacks.size())
      {
        if ((!this.mAnimationQueue.isEmpty()) || (!this.mPendingQueue.isEmpty())) {
          break label236;
        }
        this.mRunning = false;
        return;
        i = Math.max(this.mCallbacks.size() - this.mAnimationQueue.size(), 0);
        break;
        label149:
        localDouble = (Double)this.mTempValues.get(j);
        int k = this.mTempValues.size() - 1 - j + i;
        if (this.mCallbacks.size() > k) {
          ((Callback)this.mCallbacks.get(k)).onFrame(localDouble);
        }
        j -= 1;
        break label56;
      }
      this.mAnimationQueue.poll();
    }
    label236:
    this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
  }
  
  private void runIfIdle()
  {
    if (!this.mRunning)
    {
      this.mRunning = true;
      this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
    }
  }
  
  public void addAllValues(Collection<Double> paramCollection)
  {
    this.mPendingQueue.addAll(paramCollection);
    runIfIdle();
  }
  
  public void addCallback(Callback paramCallback)
  {
    this.mCallbacks.add(paramCallback);
  }
  
  public void addValue(Double paramDouble)
  {
    this.mPendingQueue.add(paramDouble);
    runIfIdle();
  }
  
  public void clearCallbacks()
  {
    this.mCallbacks.clear();
  }
  
  public void clearValues()
  {
    this.mPendingQueue.clear();
  }
  
  public void removeCallback(Callback paramCallback)
  {
    this.mCallbacks.remove(paramCallback);
  }
  
  public static abstract interface Callback
  {
    public abstract void onFrame(Double paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.AnimationQueue
 * JD-Core Version:    0.7.0.1
 */