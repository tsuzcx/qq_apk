package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import auut;
import auuu;
import com.tencent.qphone.base.util.QLog;

public class PinnedHeadAndFootExpandableListView
  extends XExpandableListView
  implements AbsListView.e
{
  public View Lv = null;
  View Lw;
  public a a;
  public b a;
  c a;
  public ExpandableListView.c b = null;
  boolean dkJ;
  boolean dkM = false;
  boolean dkN;
  boolean dkO;
  private boolean dkP;
  public int eue = -1;
  int euf;
  int eug;
  int euh = 0;
  int eui = 0;
  int euj = -1;
  public int euk;
  Context mContext = null;
  View mHeaderView = null;
  AbsListView.e mOnScrollListener = null;
  
  public PinnedHeadAndFootExpandableListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$a = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$c = null;
    init(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$a = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$c = null;
    init(paramContext);
  }
  
  public PinnedHeadAndFootExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$a = null;
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$c = null;
    init(paramContext);
  }
  
  private void abl(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$a != null) && (this.Lv != null) && (paramInt < this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$a.getGroupCount()))
    {
      this.eue = paramInt;
      if (paramInt < 1) {
        this.Lv.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.Lv.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$a.j(this.Lv, paramInt);
  }
  
  private View b(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (!(paramView instanceof ViewGroup)) {
      localObject = paramView;
    }
    label58:
    label89:
    label101:
    for (;;)
    {
      return localObject;
      localObject = (ViewGroup)paramView;
      int k = ((ViewGroup)localObject).getChildCount();
      boolean bool = isChildrenDrawingOrderEnabled();
      int i = k - 1;
      int j;
      if (i >= 0) {
        if (bool)
        {
          j = getChildDrawingOrder(k, i);
          paramView = ((ViewGroup)localObject).getChildAt(j);
          if (!e(paramView, paramInt1, paramInt2)) {
            break label89;
          }
        }
      }
      for (;;)
      {
        if (paramView == null) {
          break label101;
        }
        return paramView;
        j = i;
        break label58;
        i -= 1;
        break;
        paramView = null;
      }
    }
  }
  
  private void ck(int paramInt, boolean paramBoolean)
  {
    int i = ExpandableListView.getPackedPositionType(getExpandableListPosition(paramInt));
    int j;
    if (i != 2) {
      if (i == 0) {
        if ((ExpandableListView.getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 0) || (ExpandableListView.getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 2))
        {
          this.euh = -1;
          if (this.euh == -1) {
            break label304;
          }
          if (this.euh != 1) {
            break label296;
          }
          View localView = getChildAt(1);
          j = this.mHeaderView.getMeasuredHeight();
          if (localView == null) {
            break label291;
          }
          i = localView.getTop();
        }
      }
    }
    label93:
    for (this.eui = (j - i);; this.eui = 0)
    {
      this.mHeaderView.setVisibility(0);
      paramInt = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(paramInt));
      if ((paramInt != this.euj) || (paramBoolean) || (this.dkP))
      {
        this.dkP = false;
        this.euj = paramInt;
        this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$a.j(this.mHeaderView, paramInt);
        paramInt = View.MeasureSpec.makeMeasureSpec(this.mHeaderView.getMeasuredWidth(), 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(this.mHeaderView.getMeasuredHeight(), 1073741824);
        this.mHeaderView.measure(paramInt, i);
        this.mHeaderView.layout(0, 0, this.mHeaderView.getMeasuredWidth(), this.mHeaderView.getMeasuredHeight());
      }
      return;
      this.euh = 0;
      break;
      if (getChildAt(0).getBottom() > this.mHeaderView.getMeasuredHeight())
      {
        this.euh = 0;
        break;
      }
      if (ExpandableListView.getPackedPositionType(getExpandableListPosition(paramInt + 1)) == 0)
      {
        this.euh = 1;
        break;
      }
      this.euh = 0;
      break;
      this.euh = -1;
      break;
      i = 0;
      break label93;
    }
    label291:
    label296:
    label304:
    if (paramBoolean) {
      this.dkP = true;
    }
    this.mHeaderView.setVisibility(4);
  }
  
  private boolean e(View paramView, int paramInt1, int paramInt2)
  {
    return (paramView.isClickable()) && (paramInt2 >= paramView.getTop()) && (paramInt2 <= paramView.getBottom()) && (paramInt1 >= paramView.getLeft()) && (paramInt1 <= paramView.getRight());
  }
  
  private void exk()
  {
    setFooterEnable(false);
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$b != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$b.czW();
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
  
  public void addHeaderView(View paramView)
  {
    this.euk = 1;
    super.addHeaderView(paramView);
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
    if ((this.Lv != null) && (this.Lv.getVisibility() == 0)) {
      drawChild(paramCanvas, this.Lv, getDrawingTime());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = (int)f1;
    int j = (int)f2;
    int k = pointToPosition(i, j);
    if ((this.Lv != null) && (this.Lv.getVisibility() == 0) && (j >= this.Lv.getTop()) && (j <= this.Lv.getBottom()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.Lw = b(this.Lv, i, j);
        this.dkN = true;
      }
      while (paramMotionEvent.getAction() != 1) {
        return true;
      }
      if ((b(this.Lv, i, j) == this.Lw) && (this.Lw.isClickable()))
      {
        this.Lw.performClick();
        invalidate(new Rect(0, 0, this.euf, this.eug));
      }
      for (;;)
      {
        this.dkN = false;
        return true;
        if ((!this.dkO) || (ExpandableListView.getPackedPositionGroup(getExpandableListPosition(k)) == -1) || (!this.dkN)) {}
      }
    }
    this.Lw = null;
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
    if (this.Lv != null) {
      iX(this.Lv);
    }
  }
  
  protected void exj()
  {
    if (this.Lv == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PinnedHeadAndFootExpandableListView", 2, "mHeaderView null");
      }
    }
    do
    {
      return;
      localObject = super.getExpandableListAdapter();
      if ((localObject instanceof a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PinnedHeadAndFootExpandableListView", 2, "object null");
    return;
    Object localObject = (a)localObject;
    int i2 = getFirstVisiblePosition();
    int k = getLastVisiblePosition();
    int i3 = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(k));
    int n = this.Lv.getMeasuredHeight();
    int i1 = getHeight();
    int i4 = i1 - n;
    int j = k - 2;
    int m = k - 1;
    int i5 = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(j));
    int i;
    if (i3 == ((a)localObject).getGroupCount() - 1)
    {
      i = 1;
      if ((j < 0) || (i5 == i3)) {
        break label381;
      }
      if (ExpandableListView.getPackedPositionGroup(getExpandableListPosition(m)) != i3) {
        break label445;
      }
    }
    label445:
    for (j = m;; j = k)
    {
      localObject = getChildAt(j - i2);
      if (i1 - ((View)localObject).getTop() >= n)
      {
        abl(i3 + 1);
        k = ((View)localObject).getTop() + n;
        j = k;
        if (k < i1 - n) {
          j = i1 - n;
        }
        if (i != 0)
        {
          this.eue = -1;
          this.Lv.layout(0, -n, this.euf, -n);
          return;
          i = 0;
          break;
        }
        this.Lv.layout(0, j, this.euf, j + n);
        return;
      }
      abl(i3);
      if ((i != 0) && (j != k))
      {
        this.eue = -1;
        this.Lv.layout(0, -n, this.euf, -this.eug);
        return;
      }
      if (ExpandableListView.getPackedPositionType(getExpandableListPosition(m)) == 0)
      {
        exk();
        this.eue = -1;
        this.Lv.layout(0, -n, this.euf, -this.eug);
        return;
      }
      this.Lv.layout(0, i4, this.euf, this.eug + i4);
      return;
      label381:
      if (i != 0)
      {
        this.eue = -1;
        this.Lv.layout(0, -this.eug, this.euf, -this.eug);
      }
      for (;;)
      {
        abl(i3 + 1);
        return;
        this.Lv.layout(0, i4, this.euf, this.eug + i4);
      }
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mHeaderView != null) {
      ck(getFirstVisiblePosition(), true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$c != null) {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$c.b(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mHeaderView != null) {
      measureChild(this.mHeaderView, paramInt1, paramInt2);
    }
    if (this.Lv != null)
    {
      measureChild(this.Lv, paramInt1, paramInt2);
      this.euf = this.Lv.getMeasuredWidth();
      this.eug = this.Lv.getMeasuredHeight();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mHeaderView != null) {
      ck(paramInt1, false);
    }
    if (this.Lv != null) {
      exj();
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
  
  public boolean removeHeaderView(View paramView)
  {
    this.euk = 0;
    return super.removeHeaderView(paramView);
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof a))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$a = ((a)paramExpandableListAdapter);
      int i = this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$a.gj();
      if (i != 0)
      {
        this.mHeaderView = LayoutInflater.from(this.mContext).inflate(i, this, false);
        if (this.mHeaderView != null)
        {
          this.mHeaderView.setTag("headerView");
          this.mHeaderView.setOnTouchListener(new auut(this));
        }
        if ((this.dkJ) && (this.Lv == null))
        {
          this.Lv = LayoutInflater.from(this.mContext).inflate(i, this, false);
          if (this.Lv != null)
          {
            this.Lv.setTag("footerView");
            this.Lv.setOnClickListener(new auuu(this, this));
          }
        }
        requestLayout();
      }
    }
  }
  
  public void setFooterEnable(boolean paramBoolean)
  {
    this.dkJ = paramBoolean;
    if (this.Lv != null)
    {
      if (this.dkJ) {
        this.Lv.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.Lv.setVisibility(8);
  }
  
  public void setFooterListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$b = paramb;
  }
  
  public void setOnGroupClickListener(ExpandableListView.c paramc)
  {
    this.b = paramc;
    super.setOnGroupClickListener(paramc);
  }
  
  public void setOnLayoutListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$c = paramc;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.mOnScrollListener = parame;
  }
  
  public static abstract interface a
    extends ExpandableListAdapter
  {
    public abstract int gj();
    
    public abstract void j(View paramView, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView, View paramView, int paramInt);
    
    public abstract void czW();
  }
  
  public static abstract interface c
  {
    public abstract void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.PinnedHeadAndFootExpandableListView
 * JD-Core Version:    0.7.0.1
 */