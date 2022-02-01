package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import auuv;

public class PinnedHeaderExpandableListView
  extends XExpandableListView
  implements AbsListView.e
{
  private a jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a;
  private b jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$b;
  private ExpandableListView.c b;
  private boolean dkM;
  private boolean dkP;
  protected boolean dkQ = true;
  private int euh = 0;
  private int eui;
  private int euj = -1;
  private Context mContext;
  private View mHeaderView;
  private AbsListView.e mOnScrollListener;
  
  public PinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void ck(int paramInt, boolean paramBoolean)
  {
    int j = 1;
    int k = getPackedPositionType(getExpandableListPosition(paramInt));
    View localView;
    if (k != 2) {
      if (k == 0) {
        if ((getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 0) || (getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 2))
        {
          this.euh = -1;
          if (this.euh == -1) {
            break label425;
          }
          if (this.euh != 1) {
            break label303;
          }
          localView = getChildAt(1);
          int m = this.mHeaderView.getMeasuredHeight();
          if (localView == null) {
            break label298;
          }
          i = localView.getTop();
          label99:
          this.eui = (m - i);
          label107:
          if (!this.dkQ) {
            break label316;
          }
          this.mHeaderView.setVisibility(0);
          if (!this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.Pw()) {
            break label316;
          }
          if (k != 0) {
            break label506;
          }
          localView = getChildAt(0);
          if ((localView == null) || (isDirectChildHeaderOrFooter(localView))) {
            break label506;
          }
          localView.setVisibility(4);
        }
      }
    }
    label298:
    label303:
    label316:
    label506:
    for (int i = 1;; i = 0)
    {
      k = getChildCount();
      if (i != 0) {
        i = j;
      }
      for (;;)
      {
        if (i >= k) {
          break label316;
        }
        localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() != 0) && (!isDirectChildHeaderOrFooter(localView))) {
          localView.setVisibility(0);
        }
        i += 1;
        continue;
        this.euh = 0;
        break;
        if (getChildAt(0).getBottom() > this.mHeaderView.getMeasuredHeight())
        {
          this.euh = 0;
          break;
        }
        if (getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 0)
        {
          this.euh = 1;
          break;
        }
        this.euh = 0;
        break;
        this.euh = -1;
        break;
        i = 0;
        break label99;
        this.eui = 0;
        break label107;
        i = 0;
      }
      paramInt = getPackedPositionGroup(getExpandableListPosition(paramInt));
      if ((paramInt != this.euj) || (paramBoolean) || (this.dkP))
      {
        this.dkP = false;
        this.euj = paramInt;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.j(this.mHeaderView, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.mHeaderView.getMeasuredWidth(), 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(this.mHeaderView.getMeasuredHeight(), 1073741824);
        this.mHeaderView.measure(paramInt, i);
        this.mHeaderView.layout(0, 0, this.mHeaderView.getMeasuredWidth(), this.mHeaderView.getMeasuredHeight());
      }
      for (;;)
      {
        return;
        if (paramBoolean) {
          this.dkP = true;
        }
        this.mHeaderView.setVisibility(4);
        if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.Pw())
        {
          i = getChildCount();
          paramInt = 0;
          while (paramInt < i)
          {
            localView = getChildAt(paramInt);
            if ((localView != null) && (localView.getVisibility() != 0) && (!isDirectChildHeaderOrFooter(localView))) {
              localView.setVisibility(0);
            }
            paramInt += 1;
          }
        }
      }
    }
  }
  
  private void iX(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        iX(localViewGroup.getChildAt(i));
        i += 1;
      }
    }
    paramView.refreshDrawableState();
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    super.setOnScrollListener(this);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.mHeaderView != null) && (this.mHeaderView.getVisibility() == 0))
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.eui);
      drawChild(paramCanvas, this.mHeaderView, getDrawingTime());
      paramCanvas.restore();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.dkM)
    {
      if ((this.mHeaderView != null) && (this.mHeaderView.dispatchTouchEvent(paramMotionEvent))) {}
      for (boolean bool = true;; bool = false)
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          this.dkM = false;
        }
        return bool;
      }
    }
    if ((this.mHeaderView != null) && (f1 >= 0.0F) && (f1 <= this.mHeaderView.getMeasuredWidth()) && (f2 >= 0.0F) && (f2 <= this.mHeaderView.getMeasuredHeight() - this.eui) && (paramMotionEvent.getAction() == 0) && (this.mHeaderView.getVisibility() == 0) && (this.mHeaderView.dispatchTouchEvent(paramMotionEvent)))
    {
      this.dkM = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mHeaderView != null) {
      iX(this.mHeaderView);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mHeaderView != null) {
      ck(getFirstVisiblePosition(), true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$b != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$b.b(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mHeaderView != null) {
      measureChild(this.mHeaderView, paramInt1, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mHeaderView != null) {
      ck(paramInt1, false);
    }
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof a))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a = ((a)paramExpandableListAdapter);
      int i = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$a.gj();
      if (i != 0)
      {
        this.mHeaderView = LayoutInflater.from(this.mContext).inflate(i, this, false);
        if (this.mHeaderView != null) {
          this.mHeaderView.setOnTouchListener(new auuv(this));
        }
        requestLayout();
      }
    }
  }
  
  public void setHeaderViewShouldShow(boolean paramBoolean)
  {
    this.dkQ = paramBoolean;
  }
  
  public void setOnGroupClickListener(ExpandableListView.c paramc)
  {
    this.b = paramc;
    super.setOnGroupClickListener(paramc);
  }
  
  public void setOnLayoutListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$b = paramb;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.mOnScrollListener = parame;
  }
  
  public static abstract class a
    extends BaseExpandableListAdapter
  {
    public boolean Pw()
    {
      return false;
    }
    
    public abstract int gj();
    
    public abstract void j(View paramView, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.PinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */