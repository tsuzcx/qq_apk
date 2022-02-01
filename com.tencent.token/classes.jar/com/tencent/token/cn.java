package com.tencent.token;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class cn
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private final View a;
  private ViewTreeObserver b;
  private final Runnable c;
  
  private cn(View paramView, Runnable paramRunnable)
  {
    this.a = paramView;
    this.b = paramView.getViewTreeObserver();
    this.c = paramRunnable;
  }
  
  public static cn a(View paramView, Runnable paramRunnable)
  {
    paramRunnable = new cn(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    return paramRunnable;
  }
  
  private void a()
  {
    if (this.b.isAlive()) {
      this.b.removeOnPreDrawListener(this);
    } else {
      this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    }
    this.a.removeOnAttachStateChangeListener(this);
  }
  
  public final boolean onPreDraw()
  {
    a();
    this.c.run();
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    this.b = paramView.getViewTreeObserver();
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cn
 * JD-Core Version:    0.7.0.1
 */