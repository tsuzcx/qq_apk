package com.tencent.token.ui.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;

public class PullToRefreshListView
  extends ListView
{
  private int a;
  private View b;
  private ImageView c;
  private ProgressBar d;
  private TextView e;
  private TextView f;
  private RotateAnimation g;
  private RotateAnimation h;
  private int i;
  private Context j;
  private cq k;
  private int l;
  private int m = 0;
  private float n;
  private boolean o = false;
  private long p;
  
  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.j = paramContext;
  }
  
  private void b(int paramInt)
  {
    if (paramInt != this.m)
    {
      if (paramInt != 3) {
        break label82;
      }
      this.c.clearAnimation();
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.f.setVisibility(8);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.m = paramInt;
      return;
      label82:
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      this.f.setVisibility(0);
      break;
      if (this.m == 1)
      {
        this.c.clearAnimation();
        this.c.startAnimation(this.h);
      }
      this.e.setText(2131362021);
      continue;
      if (this.m == 2)
      {
        this.c.clearAnimation();
        this.c.startAnimation(this.g);
      }
      this.e.setText(2131362022);
      continue;
      this.b.setPadding(0, 0, 0, 0);
      this.b.invalidate();
      this.e.setText(this.l);
      if (this.k != null)
      {
        this.k.onRefresh();
        continue;
        this.b.setPadding(0, -this.a, 0, 0);
        this.b.invalidate();
        this.e.setText(2131362021);
      }
    }
  }
  
  public final void a()
  {
    b(3);
  }
  
  public final void a(int paramInt)
  {
    this.l = paramInt;
    this.b = LayoutInflater.from(this.j).inflate(2130903140, this, false);
    View localView = this.b;
    ViewGroup.LayoutParams localLayoutParams2 = localView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int i1 = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    paramInt = localLayoutParams1.height;
    if (paramInt > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      localView.measure(i1, paramInt);
      this.a = this.b.getMeasuredHeight();
      if (this.a < 10) {
        this.a = 10;
      }
      this.b.setPadding(0, -this.a, 0, 0);
      addHeaderView(this.b, null, false);
      this.c = ((ImageView)this.b.findViewById(2131296393));
      this.d = ((ProgressBar)this.b.findViewById(2131296832));
      this.e = ((TextView)this.b.findViewById(2131296394));
      this.f = ((TextView)this.b.findViewById(2131296833));
      this.c.setImageResource(2130837794);
      this.g = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
      this.g.setInterpolator(new LinearInterpolator());
      this.g.setDuration(250L);
      this.g.setFillAfter(true);
      this.h = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.h.setInterpolator(new LinearInterpolator());
      this.h.setDuration(250L);
      this.h.setFillAfter(true);
      setOnScrollListener(new cr(this));
      return;
    }
  }
  
  public final void a(long paramLong)
  {
    this.p = paramLong;
    String str = s.a(paramLong);
    this.f.setText(str);
  }
  
  public final void a(cq paramcq)
  {
    this.k = paramcq;
  }
  
  public final void a(String paramString)
  {
    try
    {
      paramString = this.j.getSharedPreferences(paramString, 0).edit();
      paramString.putLong("refresh_time", this.p);
      paramString.commit();
      return;
    }
    catch (Exception paramString)
    {
      e.c("SharedPreferences msg " + paramString.getMessage());
    }
  }
  
  public final long b(String paramString)
  {
    try
    {
      long l1 = this.j.getSharedPreferences(paramString, 0).getLong("refresh_time", 0L);
      return l1;
    }
    catch (Exception paramString)
    {
      e.c("SharedPreferences msg " + paramString.getMessage());
    }
    return 0L;
  }
  
  public final void b()
  {
    b(0);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (IndexOutOfBoundsException paramCanvas)
    {
      e.c("PullToRefreshListView dispatchDraw" + paramCanvas.toString());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        switch (paramMotionEvent.getAction())
        {
        case 0: 
          return super.dispatchTouchEvent(paramMotionEvent);
          if ((this.o) || (this.i != 0) || (this.m == 3)) {
            continue;
          }
          e.b("DOWN " + paramMotionEvent.getY());
          this.o = true;
          this.n = paramMotionEvent.getY();
          continue;
        }
      }
      catch (IndexOutOfBoundsException paramMotionEvent)
      {
        e.c("PullToRefreshListView dispatchTouchEvent" + paramMotionEvent.toString());
        return false;
        if ((!this.o) && (this.i == 0) && (this.m != 3))
        {
          e.b("DOWN2 " + paramMotionEvent.getY());
          this.o = true;
          this.n = paramMotionEvent.getY();
        }
        if ((!this.o) || (this.m == 3)) {
          continue;
        }
        e.b("MOVE " + paramMotionEvent.getY());
        float f1 = paramMotionEvent.getY() - this.n;
        if (f1 <= 0.0F) {
          continue;
        }
        this.b.setPadding(0, -this.a + (int)(f1 / 2.0F), 0, 0);
        if (f1 <= this.a * 2)
        {
          b(2);
          continue;
        }
      }
      catch (Exception paramMotionEvent)
      {
        e.c("PullToRefreshListView dispatchTouchEvent" + paramMotionEvent.toString());
        return false;
      }
      b(1);
      continue;
      if ((this.o) && (this.m != 3))
      {
        e.b("UP " + paramMotionEvent.getY());
        this.o = false;
        if (this.m == 1) {
          b(3);
        } else {
          b(0);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      e.c("PullToRefreshListView onLayout" + localIndexOutOfBoundsException.toString());
      localIndexOutOfBoundsException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      e.c("PullToRefreshListView onLayout" + localException.toString());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.PullToRefreshListView
 * JD-Core Version:    0.7.0.1
 */