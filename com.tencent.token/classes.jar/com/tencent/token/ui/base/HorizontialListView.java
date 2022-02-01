package com.tencent.token.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
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
  extends AdapterView<ListAdapter>
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
  private Queue<View> k = new LinkedList();
  private AdapterView.OnItemSelectedListener l;
  private AdapterView.OnItemClickListener m;
  private boolean n = false;
  private DataSetObserver o = new DataSetObserver()
  {
    public void onChanged()
    {
      synchronized (HorizontialListView.this)
      {
        HorizontialListView.a(HorizontialListView.this, true);
        HorizontialListView.this.invalidate();
        HorizontialListView.this.requestLayout();
        return;
      }
    }
    
    public void onInvalidated()
    {
      HorizontialListView.a(HorizontialListView.this);
      HorizontialListView.this.invalidate();
      HorizontialListView.this.requestLayout();
    }
  };
  private GestureDetector.OnGestureListener p = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      return HorizontialListView.this.a(paramAnonymousMotionEvent);
    }
    
    public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      return HorizontialListView.this.a(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
    }
    
    public boolean onScroll(MotionEvent arg1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      synchronized (HorizontialListView.this)
      {
        paramAnonymousMotionEvent2 = HorizontialListView.this;
        paramAnonymousMotionEvent2.d += (int)paramAnonymousFloat1;
        HorizontialListView.this.requestLayout();
        return true;
      }
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
    {
      Object localObject = new Rect();
      int i = 0;
      while (i < HorizontialListView.this.getChildCount())
      {
        View localView = HorizontialListView.this.getChildAt(i);
        int j = localView.getLeft();
        int k = localView.getRight();
        ((Rect)localObject).set(j, localView.getTop(), k, localView.getBottom());
        if (((Rect)localObject).contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY()))
        {
          if (HorizontialListView.b(HorizontialListView.this) != null)
          {
            paramAnonymousMotionEvent = HorizontialListView.b(HorizontialListView.this);
            localObject = HorizontialListView.this;
            paramAnonymousMotionEvent.onItemClick((AdapterView)localObject, localView, HorizontialListView.c((HorizontialListView)localObject) + 1 + i, HorizontialListView.this.b.getItemId(HorizontialListView.c(HorizontialListView.this) + 1 + i));
          }
          if (HorizontialListView.d(HorizontialListView.this) == null) {
            break;
          }
          paramAnonymousMotionEvent = HorizontialListView.d(HorizontialListView.this);
          localObject = HorizontialListView.this;
          paramAnonymousMotionEvent.onItemSelected((AdapterView)localObject, localView, HorizontialListView.c((HorizontialListView)localObject) + 1 + i, HorizontialListView.this.b.getItemId(HorizontialListView.c(HorizontialListView.this) + 1 + i));
          return true;
        }
        i += 1;
      }
      return true;
    }
  };
  
  public HorizontialListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
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
  
  private void a(int paramInt)
  {
    View localView = getChildAt(getChildCount() - 1);
    int i2 = 0;
    if (localView != null) {
      i1 = localView.getRight();
    } else {
      i1 = 0;
    }
    a(i1, paramInt);
    localView = getChildAt(0);
    int i1 = i2;
    if (localView != null) {
      i1 = localView.getLeft();
    }
    b(i1, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    while ((paramInt1 + paramInt2 < getWidth()) && (this.g < this.b.getCount()))
    {
      View localView = this.b.getView(this.g, (View)this.k.poll(), this);
      a(localView, -1);
      paramInt1 += localView.getMeasuredWidth();
      if (this.g == this.b.getCount() - 1) {
        this.h = (this.c + paramInt1 - getWidth());
      }
      this.g += 1;
    }
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
      a();
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
  
  private void b(int paramInt)
  {
    for (View localView = getChildAt(0); (localView != null) && (localView.getRight() + paramInt <= 0); localView = getChildAt(0))
    {
      this.i += localView.getMeasuredWidth();
      this.k.offer(localView);
      removeViewInLayout(localView);
      this.f += 1;
    }
    for (localView = getChildAt(getChildCount() - 1); (localView != null) && (localView.getLeft() + paramInt >= getWidth()); localView = getChildAt(getChildCount() - 1))
    {
      this.k.offer(localView);
      removeViewInLayout(localView);
      this.g -= 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    while (paramInt1 + paramInt2 > 0)
    {
      int i1 = this.f;
      if (i1 < 0) {
        break;
      }
      View localView = this.b.getView(i1, (View)this.k.poll(), this);
      a(localView, 0);
      paramInt1 -= localView.getMeasuredWidth();
      this.f -= 1;
      this.i -= localView.getMeasuredWidth();
    }
  }
  
  private void c(int paramInt)
  {
    if (getChildCount() > 0)
    {
      this.i += paramInt;
      paramInt = this.i;
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        int i2 = localView.getMeasuredWidth() + paramInt;
        localView.layout(paramInt, 0, i2, localView.getMeasuredHeight());
        i1 += 1;
        paramInt = i2;
      }
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    this.e.forceFinished(true);
    return true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    try
    {
      this.e.fling(this.d, 0, (int)-paramFloat1, 0, 0, this.h, 0, 0);
      requestLayout();
      return true;
    }
    finally {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.j.onTouchEvent(paramMotionEvent);
  }
  
  public ListAdapter getAdapter()
  {
    return this.b;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      ListAdapter localListAdapter = this.b;
      if (localListAdapter == null) {
        return;
      }
      if (this.n)
      {
        paramInt1 = this.c;
        a();
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
      paramInt1 = this.c - this.d;
      b(paramInt1);
      a(paramInt1);
      c(paramInt1);
      this.c = this.d;
      if (!this.e.isFinished()) {
        post(new Runnable()
        {
          public void run()
          {
            HorizontialListView.this.requestLayout();
          }
        });
      }
      return;
    }
    finally {}
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ListAdapter localListAdapter = this.b;
    if (localListAdapter != null) {
      localListAdapter.unregisterDataSetObserver(this.o);
    }
    this.b = paramListAdapter;
    this.b.registerDataSetObserver(this.o);
    b();
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