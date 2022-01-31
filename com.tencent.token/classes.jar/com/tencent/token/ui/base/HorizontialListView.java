package com.tencent.token.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontialListView
  extends AdapterView
{
  public boolean a = true;
  protected ListAdapter b;
  protected int c;
  protected int d;
  protected Scroller e;
  private int f = -1;
  private int g = 0;
  private int h = 2147483647;
  private int i = 0;
  private GestureDetector j;
  private Queue k = new LinkedList();
  private AdapterView.OnItemSelectedListener l;
  private AdapterView.OnItemClickListener m;
  private boolean n = false;
  private DataSetObserver o = new bc(this);
  private GestureDetector.OnGestureListener p = new be(this);
  
  public HorizontialListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void a(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
  }
  
  private void b()
  {
    try
    {
      this.f = -1;
      this.g = 0;
      this.i = 0;
      this.c = 0;
      this.d = 0;
      this.h = 2147483647;
      this.e = new Scroller(getContext());
      this.j = new GestureDetector(getContext(), this.p);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c()
  {
    try
    {
      b();
      removeAllViewsInLayout();
      requestLayout();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(ListAdapter paramListAdapter)
  {
    if (this.b != null) {
      this.b.unregisterDataSetObserver(this.o);
    }
    this.b = paramListAdapter;
    this.b.registerDataSetObserver(this.o);
    c();
  }
  
  protected final boolean a()
  {
    this.e.forceFinished(true);
    return true;
  }
  
  protected final boolean a(float paramFloat)
  {
    try
    {
      this.e.fling(this.d, 0, (int)-paramFloat, 0, 0, this.h, 0, 0);
      requestLayout();
      return true;
    }
    finally {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.j.onTouchEvent(paramMotionEvent);
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      Object localObject1 = this.b;
      if (localObject1 == null) {
        return;
      }
      if (this.n)
      {
        paramInt1 = this.c;
        b();
        removeAllViewsInLayout();
        this.d = paramInt1;
        this.n = false;
      }
      if (this.e.computeScrollOffset()) {
        this.d = this.e.getCurrX();
      }
      if (this.d < 0)
      {
        this.d = 0;
        this.e.forceFinished(true);
      }
      if (this.d > this.h)
      {
        this.d = this.h;
        this.e.forceFinished(true);
      }
      paramInt2 = this.c - this.d;
      for (localObject1 = getChildAt(0); (localObject1 != null) && (((View)localObject1).getRight() + paramInt2 <= 0); localObject1 = getChildAt(0))
      {
        this.i += ((View)localObject1).getMeasuredWidth();
        this.k.offer(localObject1);
        removeViewInLayout((View)localObject1);
        this.f += 1;
      }
      for (;;)
      {
        localObject1 = getChildAt(getChildCount() - 1);
        if ((localObject1 == null) || (((View)localObject1).getLeft() + paramInt2 < getWidth())) {
          break;
        }
        this.k.offer(localObject1);
        removeViewInLayout((View)localObject1);
        this.g -= 1;
      }
      localView = getChildAt(getChildCount() - 1);
    }
    finally {}
    View localView;
    if (localView != null)
    {
      paramInt1 = localView.getRight();
      break label646;
      label307:
      while ((paramInt1 + paramInt2 < getWidth()) && (this.g < this.b.getCount()))
      {
        localView = this.b.getView(this.g, (View)this.k.poll(), this);
        a(localView, -1);
        paramInt1 = localView.getMeasuredWidth() + paramInt1;
        if (this.g == this.b.getCount() - 1) {
          this.h = (this.c + paramInt1 - getWidth());
        }
        this.g += 1;
      }
      localView = getChildAt(0);
      if (localView != null)
      {
        paramInt1 = localView.getLeft();
        break label649;
      }
    }
    label646:
    label649:
    for (;;)
    {
      if ((paramInt1 + paramInt2 > 0) && (this.f >= 0))
      {
        localView = this.b.getView(this.f, (View)this.k.poll(), this);
        a(localView, 0);
        paramInt3 = localView.getMeasuredWidth();
        this.f -= 1;
        this.i -= localView.getMeasuredWidth();
        paramInt1 -= paramInt3;
      }
      else
      {
        if (getChildCount() > 0)
        {
          this.i += paramInt2;
          paramInt2 = this.i;
          paramInt1 = i1;
          while (paramInt1 < getChildCount())
          {
            localView = getChildAt(paramInt1);
            paramInt3 = localView.getMeasuredWidth();
            localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
            paramInt2 += paramInt3;
            paramInt1 += 1;
          }
        }
        this.c = this.d;
        if (this.e.isFinished()) {
          break;
        }
        post(new bd(this));
        break;
        paramInt1 = 0;
        break label649;
        paramInt1 = 0;
        break label307;
      }
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.m = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.l = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.HorizontialListView
 * JD-Core Version:    0.7.0.1
 */