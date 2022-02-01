import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zzd
  extends RecyclerView.LayoutManager
{
  private static float jdField_a_of_type_Float = 45.0F;
  private static int jdField_a_of_type_Int = 1;
  private static float jdField_b_of_type_Float = 20.0F;
  private static int jdField_b_of_type_Int = 2;
  private SparseArray<Float> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 1.4F;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float = 225.0F;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public zzd(Context paramContext, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_f_of_type_Float = jdField_a_of_type_Float;
    this.g = 180;
    this.h = 270;
    this.jdField_f_of_type_Int = this.g;
  }
  
  private float a(float paramFloat)
  {
    if ((Math.abs(paramFloat) < this.g) || (Math.abs(paramFloat) > this.h)) {
      return 1.0F;
    }
    return 1.0F + (1.0F - Math.abs(paramFloat - this.jdField_d_of_type_Float) / 45.0F) * (this.jdField_c_of_type_Float - 1.0F);
  }
  
  private int a(float paramFloat)
  {
    return (int)(this.jdField_c_of_type_Int * Math.cos(Math.toRadians(90.0F - paramFloat)));
  }
  
  private void a()
  {
    if (this.jdField_e_of_type_Float < 0.0F) {
      this.jdField_e_of_type_Float = 0.0F;
    }
    if (this.jdField_e_of_type_Float > b()) {
      this.jdField_e_of_type_Float = b();
    }
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    a(paramRecycler, paramState, jdField_b_of_type_Int);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (paramState.isPreLayout()) {
      return;
    }
    int k = 0;
    while (k < getChildCount())
    {
      paramState = getChildAt(k);
      m = getPosition(paramState);
      if ((((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(m)).floatValue() - this.jdField_e_of_type_Float > this.h) || (((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(m)).floatValue() - this.jdField_e_of_type_Float < this.g))
      {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(m, false);
        removeAndRecycleView(paramState, paramRecycler);
      }
      k += 1;
    }
    int m = getItemCount();
    k = 0;
    label126:
    View localView;
    label260:
    float f1;
    if (k < m) {
      if ((this.jdField_a_of_type_AndroidUtilSparseArray.get(k) != null) && (((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).floatValue() - this.jdField_e_of_type_Float <= this.h + jdField_a_of_type_Float) && (((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).floatValue() - this.jdField_e_of_type_Float >= this.g - jdField_a_of_type_Float) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(k)))
      {
        paramState = (ViewGroup)paramRecycler.getViewForPosition(k);
        localView = paramState.getChildAt(0);
        measureChildWithMargins(paramState, 0, 0);
        if (paramInt != jdField_a_of_type_Int) {
          break label420;
        }
        addView(paramState, 0);
        f1 = ((Float)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).floatValue();
        if (m <= 90.0F / jdField_a_of_type_Float + 1.0F) {
          break label428;
        }
        f1 -= this.jdField_e_of_type_Float;
      }
    }
    label420:
    label428:
    for (;;)
    {
      int n = a(f1);
      int i1 = b(f1);
      paramState.setRotation(f1);
      int i2 = this.jdField_d_of_type_Int;
      int i3 = this.jdField_e_of_type_Int;
      int i4 = this.jdField_d_of_type_Int;
      int i5 = this.i;
      int i6 = this.jdField_e_of_type_Int;
      layoutDecorated(paramState, i2 + n, i3 + i1, i5 + (n + i4), this.j + (i6 + i1));
      localView.setRotation(-f1);
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(k, true);
      a(paramState, f1);
      k += 1;
      break label126;
      break;
      addView(paramState);
      break label260;
    }
  }
  
  private void a(ViewGroup paramViewGroup, float paramFloat)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramFloat = a(paramFloat);
      paramViewGroup.setScaleX(paramFloat);
      paramViewGroup.setScaleY(paramFloat);
    }
  }
  
  private float b()
  {
    return (getItemCount() - 1) * this.jdField_f_of_type_Float - 90.0F;
  }
  
  private int b()
  {
    return getWidth() - getPaddingRight() - getPaddingLeft();
  }
  
  private int b(float paramFloat)
  {
    return (int)(this.jdField_c_of_type_Int * Math.sin(Math.toRadians(90.0F - paramFloat)));
  }
  
  private int c()
  {
    return getHeight() - getPaddingBottom() - getPaddingTop();
  }
  
  public float a()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public int a()
  {
    return Math.round(this.jdField_e_of_type_Float / this.jdField_f_of_type_Float);
  }
  
  public int a(int paramInt)
  {
    return (int)((paramInt * this.jdField_f_of_type_Float - this.jdField_e_of_type_Float) * jdField_b_of_type_Float);
  }
  
  public PointF a(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {}
    for (paramInt = -1;; paramInt = 1) {
      return new PointF(paramInt, 0.0F);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean canScrollHorizontally()
  {
    return true;
  }
  
  public boolean canScrollVertically()
  {
    return true;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    removeAllViews();
    this.jdField_e_of_type_Float = 0.0F;
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int k = 0;
    try
    {
      if ((paramState.getItemCount() <= 0) || (paramState.isPreLayout()))
      {
        this.jdField_e_of_type_Float = 0.0F;
        if (paramState.getItemCount() == 0) {
          removeAndRecycleAllViews(paramRecycler);
        }
      }
      else
      {
        View localView = paramRecycler.getViewForPosition(0);
        addView(localView);
        measureChildWithMargins(localView, 0, 0);
        this.i = getDecoratedMeasuredWidth(localView);
        this.j = getDecoratedMeasuredHeight(localView);
        this.jdField_d_of_type_Int = (b() - this.i);
        this.jdField_e_of_type_Int = (c() - this.j);
        float f1 = this.jdField_f_of_type_Int;
        while (k < getItemCount())
        {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(k, Float.valueOf(f1));
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(k, false);
          f1 += this.jdField_f_of_type_Float;
          k += 1;
        }
        detachAndScrapAttachedViews(paramRecycler);
        a();
        a(paramRecycler, paramState);
        return;
      }
    }
    catch (IndexOutOfBoundsException paramRecycler)
    {
      paramRecycler.printStackTrace();
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (90.0F / jdField_a_of_type_Float + 1.0F >= getItemCount()) {
      return 0;
    }
    int k = -paramInt;
    float f1 = -paramInt / jdField_b_of_type_Float + this.jdField_e_of_type_Float;
    if (f1 < 0.0F) {
      k = (int)(-this.jdField_e_of_type_Float * jdField_b_of_type_Float);
    }
    label286:
    for (;;)
    {
      f1 = k / jdField_b_of_type_Float;
      this.jdField_e_of_type_Float += f1;
      int m = 0;
      for (;;)
      {
        if (m < getChildCount())
        {
          ViewGroup localViewGroup = (ViewGroup)getChildAt(m);
          View localView = localViewGroup.getChildAt(0);
          float f2 = localViewGroup.getRotation() - f1;
          int n = a(f2);
          int i1 = b(f2);
          localViewGroup.setRotation(f2);
          int i2 = this.jdField_d_of_type_Int;
          int i3 = this.jdField_e_of_type_Int;
          int i4 = this.jdField_d_of_type_Int;
          int i5 = this.i;
          int i6 = this.jdField_e_of_type_Int;
          layoutDecorated(localViewGroup, i2 + n, i3 + i1, i5 + (n + i4), this.j + (i6 + i1));
          localView.setRotation(-f2);
          a(localViewGroup, f2);
          m += 1;
          continue;
          if (f1 <= b()) {
            break label286;
          }
          k = (int)((b() - this.jdField_e_of_type_Float) * jdField_b_of_type_Float);
          break;
        }
      }
      if (paramInt > 0) {
        a(paramRecycler, paramState, jdField_a_of_type_Int);
      }
      for (;;)
      {
        return k;
        a(paramRecycler, paramState, jdField_b_of_type_Int);
      }
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getItemCount() - 1)) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
      return;
      float f1 = paramInt * this.jdField_f_of_type_Float;
      if (f1 != this.jdField_e_of_type_Float)
      {
        this.jdField_e_of_type_Float = f1;
        a();
        requestLayout();
        Log.i("EditVideoSmartMusicPart", "scrollToPosition pos:" + paramInt);
      }
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollHorizontallyBy(-paramInt, paramRecycler, paramState);
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new zze(this, paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    Log.i("EditVideoSmartMusicPart", "smoothScrollToPosition pos:" + paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    super.startSmoothScroll(paramSmoothScroller);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzd
 * JD-Core Version:    0.7.0.1
 */