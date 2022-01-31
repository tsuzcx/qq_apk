package com.tencent.token.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.token.global.h;
import com.tencent.token.ui.IndexActivity;

public class PullToRefreshLinearLayout
  extends LinearLayout
{
  private Context a;
  private ImageView b;
  private TextView c;
  private PullToRefreshLinearLayout.Status d = PullToRefreshLinearLayout.Status.INIT;
  private PullToRefreshLinearLayout.Status e = PullToRefreshLinearLayout.Status.INIT;
  private Scroller f;
  private int g;
  private int h;
  private int i;
  private int j;
  private boolean k = false;
  private boolean l = true;
  private boolean m = false;
  private ce n;
  private View o;
  private RotateAnimation p;
  private RotateAnimation q;
  
  public PullToRefreshLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public PullToRefreshLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  private void a(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.topMargin = ((int)(localLayoutParams.topMargin + paramInt * 0.3F));
    this.o.setLayoutParams(localLayoutParams);
    this.o.invalidate();
    invalidate();
    this.c.setVisibility(0);
    this.b.setVisibility(0);
    if (localLayoutParams.topMargin > 0)
    {
      this.d = PullToRefreshLinearLayout.Status.RELEASETOREFRESH;
      this.c.setText("释放立即体检");
      if (this.e != this.d) {
        this.b.startAnimation(this.p);
      }
    }
    for (;;)
    {
      this.e = this.d;
      return;
      this.c.setText("下拉重新体检");
      this.d = PullToRefreshLinearLayout.Status.PULLTOREFRESH;
      if (this.e != this.d) {
        this.b.startAnimation(this.q);
      }
    }
  }
  
  private void c()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    if (localLayoutParams.topMargin > 0)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      localLayoutParams.topMargin = this.i;
      this.o.setLayoutParams(localLayoutParams);
      this.o.invalidate();
      invalidate();
      if (this.n != null)
      {
        this.n.onRefresh(this);
        this.m = true;
      }
      return;
    }
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    localLayoutParams.topMargin = this.i;
    this.o.setLayoutParams(localLayoutParams);
    this.o.invalidate();
    invalidate();
  }
  
  private int getScrollStatus()
  {
    if (getChildCount() > 1)
    {
      View localView = getChildAt(1);
      if ((localView instanceof ScrollView))
      {
        if (((ScrollView)localView).getScrollY() == 0) {
          return 0;
        }
        return -1;
      }
    }
    return -1;
  }
  
  public void a()
  {
    this.f = new Scroller(this.a);
    if (isInEditMode()) {
      return;
    }
    this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.i = ((int)(-50.0F * IndexActivity.S_DENSITY));
    this.o = LayoutInflater.from(this.a).inflate(2130968608, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -this.i);
    localLayoutParams.topMargin = this.i;
    localLayoutParams.gravity = 17;
    this.o.setLayoutParams(localLayoutParams);
    addView(this.o, localLayoutParams);
    this.b = ((ImageView)this.o.findViewById(2131558644));
    this.c = ((TextView)this.o.findViewById(2131558645));
    this.p = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.p.setInterpolator(new LinearInterpolator());
    this.p.setDuration(250L);
    this.p.setFillAfter(true);
    this.q = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.q.setInterpolator(new LinearInterpolator());
    this.q.setDuration(250L);
    this.q.setFillAfter(true);
  }
  
  public void b()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.topMargin = this.i;
    this.o.setLayoutParams(localLayoutParams);
    this.o.invalidate();
    invalidate();
    this.m = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getRawY();
    int i2 = (int)paramMotionEvent.getRawX();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.g = i1;
      this.h = i2;
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i1 - this.g > 5) && (getScrollStatus() == 0))
      {
        return true;
        h.b("MotionEvent.ACTION_UP");
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getRawY();
    int i2 = (int)paramMotionEvent.getRawX();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.g = i1;
      this.h = i2;
      return true;
      this.d = PullToRefreshLinearLayout.Status.PULLTOREFRESH;
      int i3 = i1 - this.g;
      if ((i3 >= -5) || (getScrollStatus() != 1))
      {
        this.k = true;
        a(i3);
        continue;
        h.b("MotionEvent.ACTION_UP");
        c();
      }
    }
  }
  
  public void setRefreshEnabled(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setRefreshListener(ce paramce)
  {
    this.n = paramce;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.PullToRefreshLinearLayout
 * JD-Core Version:    0.7.0.1
 */