package com.tencent.token;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ez
{
  Runnable a = null;
  Runnable b = null;
  int c = -1;
  private WeakReference<View> d;
  
  ez(View paramView)
  {
    this.d = new WeakReference(paramView);
  }
  
  private void a(final View paramView, final fa paramfa)
  {
    if (paramfa != null)
    {
      paramView.animate().setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          paramfa.c(paramView);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramfa.b(paramView);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          paramfa.a(paramView);
        }
      });
      return;
    }
    paramView.animate().setListener(null);
  }
  
  public final long a()
  {
    View localView = (View)this.d.get();
    if (localView != null) {
      return localView.animate().getDuration();
    }
    return 0L;
  }
  
  public final ez a(float paramFloat)
  {
    View localView = (View)this.d.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    return this;
  }
  
  public final ez a(long paramLong)
  {
    View localView = (View)this.d.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    return this;
  }
  
  public final ez a(Interpolator paramInterpolator)
  {
    View localView = (View)this.d.get();
    if (localView != null) {
      localView.animate().setInterpolator(paramInterpolator);
    }
    return this;
  }
  
  public final ez a(fa paramfa)
  {
    View localView = (View)this.d.get();
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        a(localView, paramfa);
        return this;
      }
      localView.setTag(2113929216, paramfa);
      a(localView, new a(this));
    }
    return this;
  }
  
  public final ez a(final fc paramfc)
  {
    final View localView = (View)this.d.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 19))
    {
      ValueAnimator.AnimatorUpdateListener local2 = null;
      if (paramfc != null) {
        local2 = new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            paramfc.a();
          }
        };
      }
      localView.animate().setUpdateListener(local2);
    }
    return this;
  }
  
  public final ez b(float paramFloat)
  {
    View localView = (View)this.d.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    return this;
  }
  
  public final ez b(long paramLong)
  {
    View localView = (View)this.d.get();
    if (localView != null) {
      localView.animate().setStartDelay(paramLong);
    }
    return this;
  }
  
  public final void b()
  {
    View localView = (View)this.d.get();
    if (localView != null) {
      localView.animate().cancel();
    }
  }
  
  public final void c()
  {
    View localView = (View)this.d.get();
    if (localView != null) {
      localView.animate().start();
    }
  }
  
  static final class a
    implements fa
  {
    ez a;
    boolean b;
    
    a(ez paramez)
    {
      this.a = paramez;
    }
    
    public final void a(View paramView)
    {
      this.b = false;
      int i = this.a.c;
      fa localfa = null;
      if (i >= 0) {
        paramView.setLayerType(2, null);
      }
      if (this.a.a != null)
      {
        localObject = this.a.a;
        this.a.a = null;
        ((Runnable)localObject).run();
      }
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof fa)) {
        localfa = (fa)localObject;
      }
      if (localfa != null) {
        localfa.a(paramView);
      }
    }
    
    public final void b(View paramView)
    {
      int i = this.a.c;
      fa localfa = null;
      if (i >= 0)
      {
        paramView.setLayerType(this.a.c, null);
        this.a.c = -1;
      }
      if ((Build.VERSION.SDK_INT >= 16) || (!this.b))
      {
        if (this.a.b != null)
        {
          localObject = this.a.b;
          this.a.b = null;
          ((Runnable)localObject).run();
        }
        Object localObject = paramView.getTag(2113929216);
        if ((localObject instanceof fa)) {
          localfa = (fa)localObject;
        }
        if (localfa != null) {
          localfa.b(paramView);
        }
        this.b = true;
      }
    }
    
    public final void c(View paramView)
    {
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof fa)) {
        localObject = (fa)localObject;
      } else {
        localObject = null;
      }
      if (localObject != null) {
        ((fa)localObject).c(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ez
 * JD-Core Version:    0.7.0.1
 */