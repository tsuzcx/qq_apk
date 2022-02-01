package com.tencent.qqmail.utilities.ui;

import android.database.Observable;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public abstract class AnimationListBaseAdapter<T>
  extends BaseAdapter
  implements InsertionListView.AnimationListAdapter<T>
{
  private boolean mAnimating = false;
  private final AnimationObservable mAnimationObservable = new AnimationObservable(null);
  
  public boolean isAnimating()
  {
    return this.mAnimating;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.mAnimating) {
      throw new IllegalStateException("animating cannot notify");
    }
    super.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    if (this.mAnimating) {
      throw new IllegalStateException("animating cannot notify");
    }
    super.notifyDataSetInvalidated();
  }
  
  public void notifyPrepareAnimation(int paramInt)
  {
    this.mAnimationObservable.notifyPrepareAnimation(paramInt);
  }
  
  public void onRowAdditionAnimationEnd()
  {
    this.mAnimating = false;
  }
  
  public void onRowAdditionAnimationStart()
  {
    this.mAnimating = true;
  }
  
  public void registerAnimationObserver(InsertionListView.AnimationObserver paramAnimationObserver)
  {
    this.mAnimationObservable.registerObserver(paramAnimationObserver);
  }
  
  public void unregisterAnimationObserver(InsertionListView.AnimationObserver paramAnimationObserver)
  {
    this.mAnimationObservable.unregisterObserver(paramAnimationObserver);
  }
  
  static class AnimationObservable
    extends Observable<InsertionListView.AnimationObserver>
  {
    public void notifyPrepareAnimation(int paramInt)
    {
      synchronized (this.mObservers)
      {
        int i = this.mObservers.size() - 1;
        while (i >= 0)
        {
          ((InsertionListView.AnimationObserver)this.mObservers.get(i)).notifyPrepareAnimation(paramInt);
          i -= 1;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.AnimationListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */