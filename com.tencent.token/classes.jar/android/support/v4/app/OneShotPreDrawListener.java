package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class OneShotPreDrawListener
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private final Runnable mRunnable;
  private final View mView;
  private ViewTreeObserver mViewTreeObserver;
  
  private OneShotPreDrawListener(View paramView, Runnable paramRunnable)
  {
    this.mView = paramView;
    this.mViewTreeObserver = paramView.getViewTreeObserver();
    this.mRunnable = paramRunnable;
  }
  
  public static OneShotPreDrawListener add(View paramView, Runnable paramRunnable)
  {
    paramRunnable = new OneShotPreDrawListener(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    return paramRunnable;
  }
  
  public boolean onPreDraw()
  {
    removeListener();
    this.mRunnable.run();
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    this.mViewTreeObserver = paramView.getViewTreeObserver();
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    removeListener();
  }
  
  public void removeListener()
  {
    if (this.mViewTreeObserver.isAlive()) {
      this.mViewTreeObserver.removeOnPreDrawListener(this);
    }
    for (;;)
    {
      this.mView.removeOnAttachStateChangeListener(this);
      return;
      this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.OneShotPreDrawListener
 * JD-Core Version:    0.7.0.1
 */