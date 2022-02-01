package com.tencent.tim.filemanager.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.Scroller;
import aufg;
import aufh;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.AdapterView.e;
import java.util.LinkedList;
import java.util.Queue;

public class QfileHorizontalListView
  extends AdapterView<ListAdapter>
{
  private int Fg = -1;
  private int Fh;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new aufg(this);
  private AdapterView.d jdField_a_of_type_ComTencentWidgetAdapterView$d;
  private AdapterView.e c;
  private Queue<View> e = new LinkedList();
  private AdapterView.c j;
  public ListAdapter mAdapter;
  protected int mCurrentX;
  private boolean mDataChanged;
  private int mDisplayOffset;
  private GestureDetector mGesture;
  private int mMaxX = 2147483647;
  public int mNextX;
  private GestureDetector.OnGestureListener mOnGesture = new aufh(this);
  protected Scroller mScroller;
  public boolean pZ = true;
  
  public QfileHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void addAndMeasureChild(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
  }
  
  private void eM(int paramInt)
  {
    for (View localView = getChildAt(0); (localView != null) && (localView.getRight() + paramInt <= 0); localView = getChildAt(0))
    {
      this.mDisplayOffset += localView.getMeasuredWidth();
      this.e.offer(localView);
      removeViewInLayout(localView);
      this.Fg += 1;
    }
    for (localView = getChildAt(getChildCount() - 1); (localView != null) && (localView.getLeft() + paramInt >= getWidth()); localView = getChildAt(getChildCount() - 1))
    {
      this.e.offer(localView);
      removeViewInLayout(localView);
      this.Fh -= 1;
    }
  }
  
  private void eN(int paramInt)
  {
    if (getChildCount() > 0)
    {
      this.mDisplayOffset += paramInt;
      int i = this.mDisplayOffset;
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        View localView = getChildAt(paramInt);
        int k = localView.getMeasuredWidth();
        localView.layout(i, 0, i + k, localView.getMeasuredHeight());
        i += localView.getPaddingRight() + k;
        paramInt += 1;
      }
    }
  }
  
  private void fillList(int paramInt)
  {
    int k = 0;
    View localView = getChildAt(getChildCount() - 1);
    if (localView != null) {}
    for (int i = localView.getRight();; i = 0)
    {
      fillListRight(i, paramInt);
      localView = getChildAt(0);
      i = k;
      if (localView != null) {
        i = localView.getLeft();
      }
      fillListLeft(i, paramInt);
      return;
    }
  }
  
  private void fillListLeft(int paramInt1, int paramInt2)
  {
    while ((paramInt1 + paramInt2 > 0) && (this.Fg >= 0))
    {
      View localView = this.mAdapter.getView(this.Fg, (View)this.e.poll(), this);
      addAndMeasureChild(localView, 0);
      paramInt1 -= localView.getMeasuredWidth();
      this.Fg -= 1;
      this.mDisplayOffset -= localView.getMeasuredWidth();
    }
  }
  
  private void fillListRight(int paramInt1, int paramInt2)
  {
    while ((paramInt1 + paramInt2 < getWidth()) && (this.Fh < this.mAdapter.getCount()))
    {
      View localView = this.mAdapter.getView(this.Fh, (View)this.e.poll(), this);
      addAndMeasureChild(localView, -1);
      paramInt1 += localView.getMeasuredWidth();
      if (this.Fh == this.mAdapter.getCount() - 1) {
        this.mMaxX = (this.mCurrentX + paramInt1 - getWidth());
      }
      if (this.mMaxX < 0) {
        this.mMaxX = 0;
      }
      this.Fh += 1;
    }
  }
  
  private void initView()
  {
    try
    {
      this.Fg = -1;
      this.Fh = 0;
      this.mDisplayOffset = 0;
      this.mCurrentX = 0;
      this.mNextX = 0;
      this.mMaxX = 2147483647;
      this.mScroller = new Scroller(getContext());
      this.mGesture = new GestureDetector(getContext(), this.mOnGesture);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void reset()
  {
    try
    {
      initView();
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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent) | this.mGesture.onTouchEvent(paramMotionEvent);
  }
  
  public ListAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.mScroller.forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    try
    {
      this.mScroller.fling(this.mNextX, 0, (int)-paramFloat1, 0, 0, this.mMaxX, 0, 0);
      requestLayout();
      return true;
    }
    finally {}
  }
  
  /* Error */
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
    //   10: invokespecial 241	com/tencent/widget/AdapterView:onLayout	(ZIIII)V
    //   13: aload_0
    //   14: getfield 169	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mAdapter	Landroid/widget/ListAdapter;
    //   17: astore 6
    //   19: aload 6
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 83	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mDataChanged	Z
    //   31: ifeq +26 -> 57
    //   34: aload_0
    //   35: getfield 186	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mCurrentX	I
    //   38: istore_2
    //   39: aload_0
    //   40: invokespecial 66	com/tencent/tim/filemanager/widget/QfileHorizontalListView:initView	()V
    //   43: aload_0
    //   44: invokevirtual 209	com/tencent/tim/filemanager/widget/QfileHorizontalListView:removeAllViewsInLayout	()V
    //   47: aload_0
    //   48: iload_2
    //   49: putfield 188	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mNextX	I
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 83	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mDataChanged	Z
    //   57: aload_0
    //   58: getfield 199	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mScroller	Landroid/widget/Scroller;
    //   61: invokevirtual 245	android/widget/Scroller:computeScrollOffset	()Z
    //   64: ifeq +14 -> 78
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 199	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mScroller	Landroid/widget/Scroller;
    //   72: invokevirtual 248	android/widget/Scroller:getCurrX	()I
    //   75: putfield 188	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mNextX	I
    //   78: aload_0
    //   79: getfield 188	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mNextX	I
    //   82: ifgt +16 -> 98
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 188	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mNextX	I
    //   90: aload_0
    //   91: getfield 199	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mScroller	Landroid/widget/Scroller;
    //   94: iconst_1
    //   95: invokevirtual 231	android/widget/Scroller:forceFinished	(Z)V
    //   98: aload_0
    //   99: getfield 188	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mNextX	I
    //   102: aload_0
    //   103: getfield 44	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mMaxX	I
    //   106: if_icmplt +19 -> 125
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 44	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mMaxX	I
    //   114: putfield 188	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mNextX	I
    //   117: aload_0
    //   118: getfield 199	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mScroller	Landroid/widget/Scroller;
    //   121: iconst_1
    //   122: invokevirtual 231	android/widget/Scroller:forceFinished	(Z)V
    //   125: aload_0
    //   126: getfield 186	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mCurrentX	I
    //   129: aload_0
    //   130: getfield 188	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mNextX	I
    //   133: isub
    //   134: istore_2
    //   135: aload_0
    //   136: iload_2
    //   137: invokespecial 250	com/tencent/tim/filemanager/widget/QfileHorizontalListView:eM	(I)V
    //   140: aload_0
    //   141: iload_2
    //   142: invokespecial 252	com/tencent/tim/filemanager/widget/QfileHorizontalListView:fillList	(I)V
    //   145: aload_0
    //   146: iload_2
    //   147: invokespecial 254	com/tencent/tim/filemanager/widget/QfileHorizontalListView:eN	(I)V
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 188	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mNextX	I
    //   155: putfield 186	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mCurrentX	I
    //   158: aload_0
    //   159: getfield 199	com/tencent/tim/filemanager/widget/QfileHorizontalListView:mScroller	Landroid/widget/Scroller;
    //   162: invokevirtual 257	android/widget/Scroller:isFinished	()Z
    //   165: ifne -141 -> 24
    //   168: aload_0
    //   169: new 259	com/tencent/tim/filemanager/widget/QfileHorizontalListView$2
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 260	com/tencent/tim/filemanager/widget/QfileHorizontalListView$2:<init>	(Lcom/tencent/tim/filemanager/widget/QfileHorizontalListView;)V
    //   177: invokevirtual 264	com/tencent/tim/filemanager/widget/QfileHorizontalListView:post	(Ljava/lang/Runnable;)Z
    //   180: pop
    //   181: goto -157 -> 24
    //   184: astore 6
    //   186: aload_0
    //   187: monitorexit
    //   188: aload 6
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	QfileHorizontalListView
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
    if (this.mAdapter != null) {
      this.mAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    this.mAdapter = paramListAdapter;
    this.mAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    reset();
  }
  
  public void setOnItemClickListener(AdapterView.c paramc)
  {
    this.j = paramc;
  }
  
  public void setOnItemLongClickListener(AdapterView.d paramd)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$d = paramd;
  }
  
  public void setOnItemSelectedListener(AdapterView.e parame)
  {
    this.c = parame;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.QfileHorizontalListView
 * JD-Core Version:    0.7.0.1
 */