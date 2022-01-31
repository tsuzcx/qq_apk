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
import com.tencent.token.global.e;
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
  private cp n;
  private View o;
  private RotateAnimation p;
  private RotateAnimation q;
  
  public PullToRefreshLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.f = new Scroller(this.a);
    if (!isInEditMode())
    {
      this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      this.i = ((int)(-50.0F * IndexActivity.S_DENSITY));
      this.o = LayoutInflater.from(this.a).inflate(2130903048, null);
      paramContext = new LinearLayout.LayoutParams(-1, -this.i);
      paramContext.topMargin = this.i;
      paramContext.gravity = 17;
      this.o.setLayoutParams(paramContext);
      addView(this.o, paramContext);
      this.b = ((ImageView)this.o.findViewById(2131296391));
      this.c = ((TextView)this.o.findViewById(2131296392));
      this.p = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
      this.p.setInterpolator(new LinearInterpolator());
      this.p.setDuration(250L);
      this.p.setFillAfter(true);
      this.q = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.q.setInterpolator(new LinearInterpolator());
      this.q.setDuration(250L);
      this.q.setFillAfter(true);
    }
  }
  
  private int b()
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
  
  public final void a()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.topMargin = this.i;
    this.o.setLayoutParams(localLayoutParams);
    this.o.invalidate();
    invalidate();
    this.m = false;
  }
  
  public final void a(cp paramcp)
  {
    this.n = paramcp;
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
      if ((i1 - this.g > 5) && (b() == 0))
      {
        return true;
        e.b("MotionEvent.ACTION_UP");
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
      if ((i3 >= -5) || (b() != 1))
      {
        this.k = true;
        paramMotionEvent = (LinearLayout.LayoutParams)this.o.getLayoutParams();
        float f1 = paramMotionEvent.topMargin;
        paramMotionEvent.topMargin = ((int)(i3 * 0.3F + f1));
        this.o.setLayoutParams(paramMotionEvent);
        this.o.invalidate();
        invalidate();
        this.c.setVisibility(0);
        this.b.setVisibility(0);
        if (paramMotionEvent.topMargin > 0)
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
          break;
          this.c.setText("下拉重新体检");
          this.d = PullToRefreshLinearLayout.Status.PULLTOREFRESH;
          if (this.e != this.d) {
            this.b.startAnimation(this.q);
          }
        }
        e.b("MotionEvent.ACTION_UP");
        paramMotionEvent = (LinearLayout.LayoutParams)this.o.getLayoutParams();
        if (paramMotionEvent.topMargin > 0)
        {
          this.b.setVisibility(8);
          this.c.setVisibility(8);
          paramMotionEvent.topMargin = this.i;
          this.o.setLayoutParams(paramMotionEvent);
          this.o.invalidate();
          invalidate();
          if (this.n != null)
          {
            this.n.onRefresh(this);
            this.m = true;
          }
        }
        else
        {
          this.b.setVisibility(0);
          this.c.setVisibility(0);
          paramMotionEvent.topMargin = this.i;
          this.o.setLayoutParams(paramMotionEvent);
          this.o.invalidate();
          invalidate();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.PullToRefreshLinearLayout
 * JD-Core Version:    0.7.0.1
 */