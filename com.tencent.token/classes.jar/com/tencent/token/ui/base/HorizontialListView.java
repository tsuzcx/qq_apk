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
      Rect localRect = new Rect();
      int i = 0;
      for (;;)
      {
        if (i < HorizontialListView.this.getChildCount())
        {
          View localView = HorizontialListView.this.getChildAt(i);
          int j = localView.getLeft();
          int k = localView.getRight();
          localRect.set(j, localView.getTop(), k, localView.getBottom());
          if (!localRect.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY())) {
            break label207;
          }
          if (HorizontialListView.b(HorizontialListView.this) != null) {
            HorizontialListView.b(HorizontialListView.this).onItemClick(HorizontialListView.this, localView, HorizontialListView.c(HorizontialListView.this) + 1 + i, HorizontialListView.this.b.getItemId(HorizontialListView.c(HorizontialListView.this) + 1 + i));
          }
          if (HorizontialListView.d(HorizontialListView.this) != null) {
            HorizontialListView.d(HorizontialListView.this).onItemSelected(HorizontialListView.this, localView, HorizontialListView.c(HorizontialListView.this) + 1 + i, HorizontialListView.this.b.getItemId(HorizontialListView.c(HorizontialListView.this) + 1 + i));
          }
        }
        return true;
        label207:
        i += 1;
      }
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
    int i2 = 0;
    View localView = getChildAt(getChildCount() - 1);
    if (localView != null) {}
    for (int i1 = localView.getRight();; i1 = 0)
    {
      a(i1, paramInt);
      localView = getChildAt(0);
      i1 = i2;
      if (localView != null) {
        i1 = localView.getLeft();
      }
      b(i1, paramInt);
      return;
    }
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
    while ((paramInt1 + paramInt2 > 0) && (this.f >= 0))
    {
      View localView = this.b.getView(this.f, (View)this.k.poll(), this);
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
      int i1 = this.i;
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        View localView = getChildAt(paramInt);
        int i2 = localView.getMeasuredWidth();
        localView.layout(i1, 0, i1 + i2, localView.getMeasuredHeight());
        i1 += i2;
        paramInt += 1;
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
  
  /* Error */
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: iload_2
    //   5: iload_3
    //   6: iload 4
    //   8: iload 5
    //   10: invokespecial 224	android/widget/AdapterView:onLayout	(ZIIII)V
    //   13: aload_0
    //   14: getfield 122	com/tencent/token/ui/base/HorizontialListView:b	Landroid/widget/ListAdapter;
    //   17: astore 6
    //   19: aload 6
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 62	com/tencent/token/ui/base/HorizontialListView:n	Z
    //   31: ifeq +26 -> 57
    //   34: aload_0
    //   35: getfield 75	com/tencent/token/ui/base/HorizontialListView:c	I
    //   38: istore_2
    //   39: aload_0
    //   40: invokespecial 72	com/tencent/token/ui/base/HorizontialListView:a	()V
    //   43: aload_0
    //   44: invokevirtual 177	com/tencent/token/ui/base/HorizontialListView:removeAllViewsInLayout	()V
    //   47: aload_0
    //   48: iload_2
    //   49: putfield 77	com/tencent/token/ui/base/HorizontialListView:d	I
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 62	com/tencent/token/ui/base/HorizontialListView:n	Z
    //   57: aload_0
    //   58: getfield 88	com/tencent/token/ui/base/HorizontialListView:e	Landroid/widget/Scroller;
    //   61: invokevirtual 228	android/widget/Scroller:computeScrollOffset	()Z
    //   64: ifeq +14 -> 78
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 88	com/tencent/token/ui/base/HorizontialListView:e	Landroid/widget/Scroller;
    //   72: invokevirtual 231	android/widget/Scroller:getCurrX	()I
    //   75: putfield 77	com/tencent/token/ui/base/HorizontialListView:d	I
    //   78: aload_0
    //   79: getfield 77	com/tencent/token/ui/base/HorizontialListView:d	I
    //   82: ifge +16 -> 98
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 77	com/tencent/token/ui/base/HorizontialListView:d	I
    //   90: aload_0
    //   91: getfield 88	com/tencent/token/ui/base/HorizontialListView:e	Landroid/widget/Scroller;
    //   94: iconst_1
    //   95: invokevirtual 204	android/widget/Scroller:forceFinished	(Z)V
    //   98: aload_0
    //   99: getfield 77	com/tencent/token/ui/base/HorizontialListView:d	I
    //   102: aload_0
    //   103: getfield 51	com/tencent/token/ui/base/HorizontialListView:h	I
    //   106: if_icmple +19 -> 125
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 51	com/tencent/token/ui/base/HorizontialListView:h	I
    //   114: putfield 77	com/tencent/token/ui/base/HorizontialListView:d	I
    //   117: aload_0
    //   118: getfield 88	com/tencent/token/ui/base/HorizontialListView:e	Landroid/widget/Scroller;
    //   121: iconst_1
    //   122: invokevirtual 204	android/widget/Scroller:forceFinished	(Z)V
    //   125: aload_0
    //   126: getfield 75	com/tencent/token/ui/base/HorizontialListView:c	I
    //   129: aload_0
    //   130: getfield 77	com/tencent/token/ui/base/HorizontialListView:d	I
    //   133: isub
    //   134: istore_2
    //   135: aload_0
    //   136: iload_2
    //   137: invokespecial 233	com/tencent/token/ui/base/HorizontialListView:b	(I)V
    //   140: aload_0
    //   141: iload_2
    //   142: invokespecial 235	com/tencent/token/ui/base/HorizontialListView:a	(I)V
    //   145: aload_0
    //   146: iload_2
    //   147: invokespecial 237	com/tencent/token/ui/base/HorizontialListView:c	(I)V
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 77	com/tencent/token/ui/base/HorizontialListView:d	I
    //   155: putfield 75	com/tencent/token/ui/base/HorizontialListView:c	I
    //   158: aload_0
    //   159: getfield 88	com/tencent/token/ui/base/HorizontialListView:e	Landroid/widget/Scroller;
    //   162: invokevirtual 240	android/widget/Scroller:isFinished	()Z
    //   165: ifne -141 -> 24
    //   168: aload_0
    //   169: new 9	com/tencent/token/ui/base/HorizontialListView$2
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 241	com/tencent/token/ui/base/HorizontialListView$2:<init>	(Lcom/tencent/token/ui/base/HorizontialListView;)V
    //   177: invokevirtual 245	com/tencent/token/ui/base/HorizontialListView:post	(Ljava/lang/Runnable;)Z
    //   180: pop
    //   181: goto -157 -> 24
    //   184: astore 6
    //   186: aload_0
    //   187: monitorexit
    //   188: aload 6
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	HorizontialListView
    //   0	191	1	paramBoolean	boolean
    //   0	191	2	paramInt1	int
    //   0	191	3	paramInt2	int
    //   0	191	4	paramInt3	int
    //   0	191	5	paramInt4	int
    //   17	3	6	localListAdapter	ListAdapter
    //   184	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	184	finally
    //   27	57	184	finally
    //   57	78	184	finally
    //   78	98	184	finally
    //   98	125	184	finally
    //   125	181	184	finally
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.b != null) {
      this.b.unregisterDataSetObserver(this.o);
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