package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmail.utilities.thread.Threads;

public class ScrollIndicatorsView
  extends View
  implements ScrollNotifier.ScrollListener
{
  private ScrollNotifier mSource;
  
  public ScrollIndicatorsView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScrollIndicatorsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return this.mSource.computeHorizontalScrollExtent();
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return this.mSource.computeHorizontalScrollOffset();
  }
  
  protected int computeHorizontalScrollRange()
  {
    return this.mSource.computeHorizontalScrollRange();
  }
  
  protected int computeVerticalScrollExtent()
  {
    return this.mSource.computeVerticalScrollExtent();
  }
  
  protected int computeVerticalScrollOffset()
  {
    return this.mSource.computeVerticalScrollOffset();
  }
  
  protected int computeVerticalScrollRange()
  {
    return this.mSource.computeVerticalScrollRange();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onNotifierScroll(int paramInt1, int paramInt2)
  {
    Log.e("went", " " + paramInt1 + " : " + paramInt2);
    Threads.runOnMainThread(new ScrollIndicatorsView.1(this));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    Log.e("alger", "action: " + paramMotionEvent.getActionMasked() + "scrollerview onTouch " + bool);
    return bool;
  }
  
  public void setSourceView(ScrollNotifier paramScrollNotifier)
  {
    this.mSource = paramScrollNotifier;
    this.mSource.addScrollListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.ScrollIndicatorsView
 * JD-Core Version:    0.7.0.1
 */