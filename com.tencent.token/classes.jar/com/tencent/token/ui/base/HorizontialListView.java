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
    public final void onChanged()
    {
      synchronized (HorizontialListView.this)
      {
        HorizontialListView.a(HorizontialListView.this);
        HorizontialListView.this.invalidate();
        HorizontialListView.this.requestLayout();
        return;
      }
    }
    
    public final void onInvalidated()
    {
      HorizontialListView.b(HorizontialListView.this);
      HorizontialListView.this.invalidate();
      HorizontialListView.this.requestLayout();
    }
  };
  private GestureDetector.OnGestureListener p = new GestureDetector.SimpleOnGestureListener()
  {
    public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      return HorizontialListView.this.a();
    }
    
    public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      return HorizontialListView.this.a(paramAnonymousFloat1);
    }
    
    public final boolean onScroll(MotionEvent arg1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      synchronized (HorizontialListView.this)
      {
        paramAnonymousMotionEvent2 = HorizontialListView.this;
        paramAnonymousMotionEvent2.d += (int)paramAnonymousFloat1;
        HorizontialListView.this.requestLayout();
        return true;
      }
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
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
          if (HorizontialListView.c(HorizontialListView.this) != null)
          {
            paramAnonymousMotionEvent = HorizontialListView.c(HorizontialListView.this);
            localObject = HorizontialListView.this;
            paramAnonymousMotionEvent.onItemClick((AdapterView)localObject, localView, HorizontialListView.d((HorizontialListView)localObject) + 1 + i, HorizontialListView.this.b.getItemId(HorizontialListView.d(HorizontialListView.this) + 1 + i));
          }
          if (HorizontialListView.e(HorizontialListView.this) == null) {
            break;
          }
          paramAnonymousMotionEvent = HorizontialListView.e(HorizontialListView.this);
          localObject = HorizontialListView.this;
          paramAnonymousMotionEvent.onItemSelected((AdapterView)localObject, localView, HorizontialListView.d((HorizontialListView)localObject) + 1 + i, HorizontialListView.this.b.getItemId(HorizontialListView.d(HorizontialListView.this) + 1 + i));
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
    for (;;)
    {
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
        localObject1 = getChildAt(0);
        if ((localObject1 != null) && (((View)localObject1).getRight() + paramInt2 <= 0))
        {
          this.i += ((View)localObject1).getMeasuredWidth();
          this.k.offer(localObject1);
          removeViewInLayout((View)localObject1);
          this.f += 1;
          localObject1 = getChildAt(0);
          continue;
        }
        localObject1 = getChildAt(getChildCount() - 1);
        if ((localObject1 != null) && (((View)localObject1).getLeft() + paramInt2 >= getWidth()))
        {
          this.k.offer(localObject1);
          removeViewInLayout((View)localObject1);
          this.g -= 1;
          continue;
        }
        localObject1 = getChildAt(getChildCount() - 1);
        if (localObject1 != null)
        {
          paramInt1 = ((View)localObject1).getRight();
          if ((paramInt1 + paramInt2 < getWidth()) && (this.g < this.b.getCount()))
          {
            localObject1 = this.b.getView(this.g, (View)this.k.poll(), this);
            a((View)localObject1, -1);
            paramInt1 += ((View)localObject1).getMeasuredWidth();
            if (this.g == this.b.getCount() - 1) {
              this.h = (this.c + paramInt1 - getWidth());
            }
            this.g += 1;
            continue;
          }
          localObject1 = getChildAt(0);
          if (localObject1 == null) {
            break label634;
          }
          paramInt1 = ((View)localObject1).getLeft();
          if ((paramInt1 + paramInt2 > 0) && (this.f >= 0))
          {
            localObject1 = this.b.getView(this.f, (View)this.k.poll(), this);
            a((View)localObject1, 0);
            paramInt1 -= ((View)localObject1).getMeasuredWidth();
            this.f -= 1;
            this.i -= ((View)localObject1).getMeasuredWidth();
            continue;
          }
          if (getChildCount() > 0)
          {
            this.i += paramInt2;
            paramInt2 = this.i;
            paramInt1 = 0;
            if (paramInt1 < getChildCount())
            {
              localObject1 = getChildAt(paramInt1);
              paramInt3 = ((View)localObject1).getMeasuredWidth() + paramInt2;
              ((View)localObject1).layout(paramInt2, 0, paramInt3, ((View)localObject1).getMeasuredHeight());
              paramInt1 += 1;
              paramInt2 = paramInt3;
              continue;
            }
          }
          this.c = this.d;
          if (!this.e.isFinished()) {
            post(new Runnable()
            {
              public final void run()
              {
                HorizontialListView.this.requestLayout();
              }
            });
          }
          return;
        }
      }
      finally {}
      paramInt1 = 0;
      continue;
      label634:
      paramInt1 = 0;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ListAdapter localListAdapter = this.b;
    if (localListAdapter != null) {
      localListAdapter.unregisterDataSetObserver(this.o);
    }
    this.b = paramListAdapter;
    this.b.registerDataSetObserver(this.o);
    c();
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