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

public class srq
  extends RecyclerView.LayoutManager
{
  private static int byK = 1;
  private static int byL = 2;
  private static float oo = 45.0F;
  private static float op = 20.0F;
  private boolean aME = true;
  private int ahj;
  private SparseArray<Float> bi = new SparseArray();
  private int byM;
  private int byN;
  private int byO;
  private int byP;
  private int byQ;
  private int byR;
  private SparseBooleanArray m = new SparseBooleanArray();
  private int mRadius;
  private float maxScale = 1.4F;
  private float oq = 225.0F;
  private float or;
  private float os;
  
  public srq(Context paramContext, int paramInt)
  {
    this.mRadius = paramInt;
    this.or = 0.0F;
    this.os = oo;
    this.byO = 180;
    this.byP = 270;
    this.byN = this.byO;
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    a(paramRecycler, paramState, byL);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (paramState.isPreLayout()) {
      return;
    }
    int i = 0;
    while (i < getChildCount())
    {
      paramState = getChildAt(i);
      j = getPosition(paramState);
      if ((((Float)this.bi.get(j)).floatValue() - this.or > this.byP) || (((Float)this.bi.get(j)).floatValue() - this.or < this.byO))
      {
        this.m.put(j, false);
        removeAndRecycleView(paramState, paramRecycler);
      }
      i += 1;
    }
    int j = getItemCount();
    i = 0;
    label126:
    View localView;
    label260:
    float f;
    if (i < j) {
      if ((this.bi.get(i) != null) && (((Float)this.bi.get(i)).floatValue() - this.or <= this.byP + oo) && (((Float)this.bi.get(i)).floatValue() - this.or >= this.byO - oo) && (!this.m.get(i)))
      {
        paramState = (ViewGroup)paramRecycler.getViewForPosition(i);
        localView = paramState.getChildAt(0);
        measureChildWithMargins(paramState, 0, 0);
        if (paramInt != byK) {
          break label420;
        }
        addView(paramState, 0);
        f = ((Float)this.bi.get(i)).floatValue();
        if (j <= 90.0F / oo + 1.0F) {
          break label428;
        }
        f -= this.or;
      }
    }
    label420:
    label428:
    for (;;)
    {
      int k = n(f);
      int n = o(f);
      paramState.setRotation(f);
      int i1 = this.byM;
      int i2 = this.ahj;
      int i3 = this.byM;
      int i4 = this.byQ;
      int i5 = this.ahj;
      layoutDecorated(paramState, i1 + k, i2 + n, i4 + (k + i3), this.byR + (i5 + n));
      localView.setRotation(-f);
      this.m.put(i, true);
      a(paramState, f);
      i += 1;
      break label126;
      break;
      addView(paramState);
      break label260;
    }
  }
  
  private void a(ViewGroup paramViewGroup, float paramFloat)
  {
    if (this.aME)
    {
      paramFloat = s(paramFloat);
      paramViewGroup.setScaleX(paramFloat);
      paramViewGroup.setScaleY(paramFloat);
    }
  }
  
  private float aD()
  {
    return (getItemCount() - 1) * this.os - 90.0F;
  }
  
  private void bAi()
  {
    if (this.or < 0.0F) {
      this.or = 0.0F;
    }
    if (this.or > aD()) {
      this.or = aD();
    }
  }
  
  private int getHorizontalSpace()
  {
    return getWidth() - getPaddingRight() - getPaddingLeft();
  }
  
  private int n(float paramFloat)
  {
    return (int)(this.mRadius * Math.cos(Math.toRadians(90.0F - paramFloat)));
  }
  
  private int o(float paramFloat)
  {
    return (int)(this.mRadius * Math.sin(Math.toRadians(90.0F - paramFloat)));
  }
  
  private float s(float paramFloat)
  {
    if ((Math.abs(paramFloat) < this.byO) || (Math.abs(paramFloat) > this.byP)) {
      return 1.0F;
    }
    return 1.0F + (1.0F - Math.abs(paramFloat - this.oq) / 45.0F) * (this.maxScale - 1.0F);
  }
  
  private int ur()
  {
    return getHeight() - getPaddingBottom() - getPaddingTop();
  }
  
  public boolean canScrollHorizontally()
  {
    return true;
  }
  
  public boolean canScrollVertically()
  {
    return true;
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {}
    for (paramInt = -1;; paramInt = 1) {
      return new PointF(paramInt, 0.0F);
    }
  }
  
  public int eq(int paramInt)
  {
    return (int)((paramInt * this.os - this.or) * op);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public int getCurrentPosition()
  {
    return Math.round(this.or / this.os);
  }
  
  public float getMaxScale()
  {
    return this.maxScale;
  }
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    removeAllViews();
    this.or = 0.0F;
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i = 0;
    try
    {
      if ((paramState.getItemCount() <= 0) || (paramState.isPreLayout()))
      {
        this.or = 0.0F;
        if (paramState.getItemCount() == 0) {
          removeAndRecycleAllViews(paramRecycler);
        }
      }
      else
      {
        View localView = paramRecycler.getViewForPosition(0);
        addView(localView);
        measureChildWithMargins(localView, 0, 0);
        this.byQ = getDecoratedMeasuredWidth(localView);
        this.byR = getDecoratedMeasuredHeight(localView);
        this.byM = (getHorizontalSpace() - this.byQ);
        this.ahj = (ur() - this.byR);
        float f = this.byN;
        while (i < getItemCount())
        {
          this.bi.put(i, Float.valueOf(f));
          this.m.put(i, false);
          f += this.os;
          i += 1;
        }
        detachAndScrapAttachedViews(paramRecycler);
        bAi();
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
    if (90.0F / oo + 1.0F >= getItemCount()) {
      return 0;
    }
    int i = -paramInt;
    float f1 = -paramInt / op + this.or;
    if (f1 < 0.0F) {
      i = (int)(-this.or * op);
    }
    label286:
    for (;;)
    {
      f1 = i / op;
      this.or += f1;
      int j = 0;
      for (;;)
      {
        if (j < getChildCount())
        {
          ViewGroup localViewGroup = (ViewGroup)getChildAt(j);
          View localView = localViewGroup.getChildAt(0);
          float f2 = localViewGroup.getRotation() - f1;
          int k = n(f2);
          int n = o(f2);
          localViewGroup.setRotation(f2);
          int i1 = this.byM;
          int i2 = this.ahj;
          int i3 = this.byM;
          int i4 = this.byQ;
          int i5 = this.ahj;
          layoutDecorated(localViewGroup, i1 + k, i2 + n, i4 + (k + i3), this.byR + (i5 + n));
          localView.setRotation(-f2);
          a(localViewGroup, f2);
          j += 1;
          continue;
          if (f1 <= aD()) {
            break label286;
          }
          i = (int)((aD() - this.or) * op);
          break;
        }
      }
      if (paramInt > 0) {
        a(paramRecycler, paramState, byK);
      }
      for (;;)
      {
        return i;
        a(paramRecycler, paramState, byL);
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
      float f = paramInt * this.os;
      if (f != this.or)
      {
        this.or = f;
        bAi();
        requestLayout();
        Log.i("EditVideoSmartMusicPart", "scrollToPosition pos:" + paramInt);
      }
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollHorizontallyBy(-paramInt, paramRecycler, paramState);
  }
  
  public void setNeedScale(boolean paramBoolean)
  {
    this.aME = paramBoolean;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new srr(this, paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    Log.i("EditVideoSmartMusicPart", "smoothScrollToPosition pos:" + paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    super.startSmoothScroll(paramSmoothScroller);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srq
 * JD-Core Version:    0.7.0.1
 */