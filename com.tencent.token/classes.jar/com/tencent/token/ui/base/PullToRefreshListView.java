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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.aao;
import com.tencent.token.xj;

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
  private a k;
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
  
  private static void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int i2 = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i1 = localLayoutParams1.height;
    if (i1 > 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
    } else {
      i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i2, i1);
  }
  
  public final void a(int paramInt)
  {
    this.l = paramInt;
    this.b = LayoutInflater.from(this.j).inflate(2131296378, this, false);
    a(this.b);
    this.a = this.b.getMeasuredHeight();
    if (this.a < 10) {
      this.a = 10;
    }
    this.b.setPadding(0, -this.a, 0, 0);
    addHeaderView(this.b, null, false);
    this.c = ((ImageView)this.b.findViewById(2131165572));
    this.d = ((ProgressBar)this.b.findViewById(2131165575));
    this.e = ((TextView)this.b.findViewById(2131165577));
    this.f = ((TextView)this.b.findViewById(2131165576));
    this.c.setImageResource(2131100028);
    this.g = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.g.setInterpolator(new LinearInterpolator());
    this.g.setDuration(250L);
    this.g.setFillAfter(true);
    this.h = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.h.setInterpolator(new LinearInterpolator());
    this.h.setDuration(250L);
    this.h.setFillAfter(true);
    setOnScrollListener(new b((byte)0));
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
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(paramString.getMessage());
      xj.c(localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(paramString.getMessage());
      xj.c(localStringBuilder.toString());
    }
    return 0L;
  }
  
  public final void b(int paramInt)
  {
    if (paramInt != this.m)
    {
      if (paramInt == 3)
      {
        this.c.clearAnimation();
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        this.f.setVisibility(8);
      }
      else
      {
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.f.setVisibility(0);
      }
      switch (paramInt)
      {
      default: 
        break;
      case 3: 
        this.b.setPadding(0, 0, 0, 0);
        this.b.invalidate();
        this.e.setText(this.l);
        a locala = this.k;
        if (locala != null) {
          locala.onRefresh();
        }
        break;
      case 2: 
        if (this.m == 1)
        {
          this.c.clearAnimation();
          this.c.startAnimation(this.h);
        }
        this.e.setText(2131493313);
        break;
      case 1: 
        if (this.m == 2)
        {
          this.c.clearAnimation();
          this.c.startAnimation(this.g);
        }
        this.e.setText(2131493315);
        break;
      case 0: 
        this.b.setPadding(0, -this.a, 0, 0);
        this.b.invalidate();
        this.e.setText(2131493313);
      }
      this.m = paramInt;
    }
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
      StringBuilder localStringBuilder = new StringBuilder("PullToRefreshListView dispatchDraw");
      localStringBuilder.append(paramCanvas.toString());
      xj.c(localStringBuilder.toString());
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
        case 2: 
          if ((!this.o) && (this.i == 0) && (this.m != 3))
          {
            localStringBuilder = new StringBuilder("DOWN2 ");
            localStringBuilder.append(paramMotionEvent.getY());
            xj.b(localStringBuilder.toString());
            this.o = true;
            this.n = paramMotionEvent.getY();
          }
          if ((this.o) && (this.m != 3))
          {
            localStringBuilder = new StringBuilder("MOVE ");
            localStringBuilder.append(paramMotionEvent.getY());
            xj.b(localStringBuilder.toString());
            float f1 = paramMotionEvent.getY() - this.n;
            if (f1 > 0.0F)
            {
              this.b.setPadding(0, -this.a + (int)(f1 / 2.0F), 0, 0);
              if (f1 <= this.a * 2) {
                b(2);
              } else {
                b(1);
              }
            }
          }
          break;
        case 1: 
          if ((this.o) && (this.m != 3))
          {
            localStringBuilder = new StringBuilder("UP ");
            localStringBuilder.append(paramMotionEvent.getY());
            xj.b(localStringBuilder.toString());
            this.o = false;
            if (this.m == 1) {
              b(3);
            } else {
              b(0);
            }
          }
          break;
        case 0: 
          if ((!this.o) && (this.i == 0) && (this.m != 3))
          {
            localStringBuilder = new StringBuilder("DOWN ");
            localStringBuilder.append(paramMotionEvent.getY());
            xj.b(localStringBuilder.toString());
            this.o = true;
            this.n = paramMotionEvent.getY();
          }
          boolean bool = super.dispatchTouchEvent(paramMotionEvent);
          return bool;
        }
      }
      catch (Exception paramMotionEvent)
      {
        localStringBuilder = new StringBuilder("PullToRefreshListView dispatchTouchEvent");
        localStringBuilder.append(paramMotionEvent.toString());
        xj.c(localStringBuilder.toString());
        return false;
      }
      catch (IndexOutOfBoundsException paramMotionEvent)
      {
        StringBuilder localStringBuilder = new StringBuilder("PullToRefreshListView dispatchTouchEvent");
        localStringBuilder.append(paramMotionEvent.toString());
        xj.c(localStringBuilder.toString());
        return false;
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
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder("PullToRefreshListView onLayout");
      localStringBuilder.append(localException.toString());
      xj.c(localStringBuilder.toString());
      localException.printStackTrace();
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      StringBuilder localStringBuilder = new StringBuilder("PullToRefreshListView onLayout");
      localStringBuilder.append(localIndexOutOfBoundsException.toString());
      xj.c(localStringBuilder.toString());
      localIndexOutOfBoundsException.printStackTrace();
    }
  }
  
  public void setOnRefreshListener(a parama)
  {
    this.k = parama;
  }
  
  public void setRefreshTime(long paramLong)
  {
    this.p = paramLong;
    String str = aao.a(paramLong, '-');
    this.f.setText(str);
  }
  
  public static abstract interface a
  {
    public abstract void onRefresh();
  }
  
  final class b
    implements AbsListView.OnScrollListener
  {
    private b() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      PullToRefreshListView.a(PullToRefreshListView.this, paramInt1);
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.PullToRefreshListView
 * JD-Core Version:    0.7.0.1
 */