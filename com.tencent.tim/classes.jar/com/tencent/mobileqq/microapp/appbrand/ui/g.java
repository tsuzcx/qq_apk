package com.tencent.mobileqq.microapp.appbrand.ui;

import android.graphics.drawable.Drawable;
import android.view.View;

final class g
  extends h.a
{
  g(SwipeBackLayout paramSwipeBackLayout) {}
  
  public int a(View paramView)
  {
    return SwipeBackLayout.access$400(this.a);
  }
  
  public int a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return 0;
    }
    return Math.min(paramInt1, SwipeBackLayout.access$400(this.a));
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (SwipeBackLayout.access$200(this.a) >= SwipeBackLayout.access$400(this.a) / 10)
    {
      SwipeBackLayout.access$302(this.a, true);
      SwipeBackLayout.access$600(this.a).a(SwipeBackLayout.access$400(this.a), paramView.getTop());
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      SwipeBackLayout.access$600(this.a).a(0, paramView.getTop());
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SwipeBackLayout.access$002(this.a, Math.abs(paramInt1 / (this.a.mContentView.getWidth() + SwipeBackLayout.access$100(this.a).getIntrinsicWidth())));
    SwipeBackLayout.access$202(this.a, paramInt1);
    if ((SwipeBackLayout.access$300(this.a)) && (SwipeBackLayout.access$200(this.a) == SwipeBackLayout.access$400(this.a)) && (SwipeBackLayout.access$500(this.a) != null)) {
      SwipeBackLayout.access$500(this.a).onSwipeFinish();
    }
  }
  
  public boolean a(View paramView, int paramInt)
  {
    return paramView == this.a.mContentView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.g
 * JD-Core Version:    0.7.0.1
 */