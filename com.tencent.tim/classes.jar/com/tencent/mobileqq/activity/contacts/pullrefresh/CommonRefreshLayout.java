package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import atau.a;
import com.tencent.widget.ListView;
import zbh;
import zbi;
import zbj;
import zbk;
import zbl;

public class CommonRefreshLayout
  extends ViewGroup
  implements AutoScroller.a
{
  private AutoScroller jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$a;
  b jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b = new zbh(this);
  private int aVz;
  private zbi b;
  private boolean bqr;
  private boolean bqs;
  private boolean bqt = true;
  private boolean bqu;
  private int ccD = 200;
  private int ccE = 200;
  private int ccF = 300;
  private int ccG = 500;
  private int ccH = 500;
  private int ccI;
  private int ccJ;
  private int ccK;
  private ViewGroup dC;
  private float jS;
  private float jT;
  private int mActivePointerId;
  private float mLastX;
  private float mLastY;
  private int mStatus = 0;
  private View mTargetView;
  private int mTouchSlop;
  ListView o;
  private float qV = 0.5F;
  private float qW;
  private float qX;
  
  public CommonRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rK, paramInt, 0);
    for (;;)
    {
      try
      {
        int j = paramAttributeSet.getIndexCount();
        paramInt = i;
        if (paramInt >= j) {
          break label313;
        }
        i = paramAttributeSet.getIndex(paramInt);
        if (i == 10) {
          setRefreshEnabled(paramAttributeSet.getBoolean(i, true));
        } else if (i == 2) {
          this.qV = paramAttributeSet.getFloat(i, 0.5F);
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      if (i == 11)
      {
        this.qX = paramAttributeSet.getDimensionPixelOffset(i, 0);
      }
      else if (i == 12)
      {
        this.qW = paramAttributeSet.getDimensionPixelOffset(i, 0);
      }
      else if (i == 16)
      {
        this.ccD = paramAttributeSet.getInt(i, 200);
      }
      else if (i == 14)
      {
        this.ccE = paramAttributeSet.getInt(i, 200);
      }
      else if (i == 8)
      {
        setRefreshCompleteDelayDuration(paramAttributeSet.getInt(i, 300));
      }
      else if (i == 9)
      {
        this.ccG = paramAttributeSet.getInt(i, 500);
      }
      else if (i == 1)
      {
        this.ccH = paramAttributeSet.getInt(i, 500);
        break label362;
        label313:
        paramAttributeSet.recycle();
        this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller = new AutoScroller(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.a(this);
        this.ccK = getResources().getDimensionPixelOffset(2131299308);
        return;
      }
      label362:
      paramInt += 1;
    }
  }
  
  private boolean UZ()
  {
    return (this.bqt) && (!zbl.P(this.mTargetView)) && (this.bqr) && (this.qW > 0.0F);
  }
  
  private void au(float paramFloat)
  {
    if ((c.access$000(this.mStatus)) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$a != null) && (paramFloat > 0.0F))
    {
      setStatus(3);
      if (this.dC.getVisibility() != 0) {
        this.dC.setVisibility(0);
      }
    }
    if (c.hh(this.mStatus))
    {
      if (paramFloat < 0.0F)
      {
        setStatus(2);
        av(paramFloat);
      }
    }
    else
    {
      if ((c.hi(this.mStatus)) || (c.hj(this.mStatus)))
      {
        if (paramFloat >= 0.0F) {
          break label266;
        }
        setStatus(2);
        label103:
        av(paramFloat);
      }
      if (((c.access$000(this.mStatus)) || (c.hi(this.mStatus))) && (paramFloat > 0.0F) && (UZ()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.onPrepare();
        setStatus(-1);
      }
      if (c.access$400(this.mStatus))
      {
        if ((!c.hf(this.mStatus)) && (!c.access$600(this.mStatus))) {
          break label282;
        }
        if (this.ccJ < this.qW) {
          break label274;
        }
        setStatus(-2);
      }
    }
    for (;;)
    {
      av(paramFloat);
      return;
      if (this.ccJ >= this.qW)
      {
        setStatus(4);
        break;
      }
      if (this.ccJ >= (this.qW - this.ccK) / 2.0F)
      {
        setStatus(5);
        break;
      }
      setStatus(3);
      break;
      label266:
      setStatus(1);
      break label103;
      label274:
      setStatus(-1);
      continue;
      label282:
      if ((paramFloat < 0.0F) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$a != null)) {
        setStatus(2);
      }
    }
  }
  
  private void av(float paramFloat)
  {
    float f1 = this.qV * paramFloat;
    float f2 = this.ccJ + f1;
    if ((this.ccJ <= 0) || (f2 >= 0.0F))
    {
      paramFloat = f1;
      if (this.ccJ < 0)
      {
        paramFloat = f1;
        if (f2 <= 0.0F) {}
      }
    }
    else
    {
      paramFloat = -this.ccJ;
    }
    f1 = paramFloat;
    if (this.qX > this.qW)
    {
      f1 = paramFloat;
      if (f2 > this.qX) {
        f1 = this.qX - this.ccJ;
      }
    }
    if (c.access$400(this.mStatus))
    {
      int i = this.ccJ;
      if (Va()) {
        i = this.ccJ - ((int)this.qW - this.ccK);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.o(i, false, false);
    }
    updateScroll(f1);
  }
  
  private void cnH()
  {
    int i = getPaddingTop();
    if (this.mTargetView == null) {}
    do
    {
      return;
      if (this.dC != null)
      {
        localObject = this.dC;
        ((View)localObject).setTop(((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin + i - this.aVz + this.ccI);
      }
    } while (this.mTargetView == null);
    Object localObject = this.mTargetView;
    int j = ((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin + i + this.ccJ;
    i = j;
    if (j < 0) {
      i = 0;
    }
    ((View)localObject).setTop(i);
  }
  
  private void cnI()
  {
    if (c.he(this.mStatus))
    {
      this.ccJ = ((int)(this.qW + 0.5F));
      this.ccI = this.ccJ;
      cnH();
      requestLayout();
      invalidate();
    }
    do
    {
      return;
      if (c.access$000(this.mStatus))
      {
        this.ccJ = 0;
        this.ccI = 0;
        cnH();
        requestLayout();
        invalidate();
        return;
      }
    } while (!c.hi(this.mStatus));
    this.ccJ = ((int)(this.qW + 0.5F) - this.ccK);
    this.ccI = this.ccJ;
    cnH();
    requestLayout();
    invalidate();
  }
  
  private void cnJ()
  {
    if (c.hf(this.mStatus)) {
      if (Va()) {
        cnO();
      }
    }
    do
    {
      return;
      cnL();
      return;
      if (c.access$600(this.mStatus))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.onRelease();
        cnM();
        return;
      }
      if (c.he(this.mStatus))
      {
        cnN();
        return;
      }
      if ((c.hk(this.mStatus)) || (c.hl(this.mStatus)))
      {
        cnO();
        return;
      }
    } while ((!c.hm(this.mStatus)) && (!c.hj(this.mStatus)));
    cnP();
  }
  
  private void cnK()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.isFinished()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.gb((int)(this.qW + 0.5F), this.ccH);
    }
  }
  
  private void cnL()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.isFinished()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.gb(-this.ccI, this.ccD);
    }
  }
  
  private void cnM()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.isFinished()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.gb(this.aVz - this.ccI, this.ccE);
    }
  }
  
  private float getMotionEventX(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return MotionEventCompat.getX(paramMotionEvent, paramInt);
  }
  
  private float getMotionEventY(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return MotionEventCompat.getY(paramMotionEvent, paramInt);
  }
  
  private void layoutChildren()
  {
    int j = getPaddingLeft();
    int i = getPaddingTop();
    if (this.mTargetView == null) {}
    do
    {
      return;
      if (this.dC != null)
      {
        localObject = this.dC;
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        k = localMarginLayoutParams.leftMargin + j;
        int m = localMarginLayoutParams.topMargin + i - this.aVz + this.ccI;
        ((View)localObject).layout(k, m, ((View)localObject).getMeasuredWidth() + k, ((View)localObject).getMeasuredHeight() + m);
      }
    } while (this.mTargetView == null);
    Object localObject = this.mTargetView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
    int k = j + localMarginLayoutParams.leftMargin;
    j = localMarginLayoutParams.topMargin + i + this.ccJ;
    i = j;
    if (j < 0) {
      i = 0;
    }
    ((View)localObject).layout(k, i, ((View)localObject).getMeasuredWidth() + k, ((View)localObject).getMeasuredHeight() + i);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mActivePointerId) {
      if (i != 0) {
        break label33;
      }
    }
    label33:
    for (i = 1;; i = 0)
    {
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      return;
    }
  }
  
  private void setStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  private void updateScroll(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    this.ccJ = ((int)(this.ccJ + paramFloat));
    if ((c.access$400(this.mStatus)) || (c.hg(this.mStatus))) {
      this.ccI = this.ccJ;
    }
    cnH();
    requestLayout();
    invalidate();
  }
  
  public boolean UY()
  {
    return this.bqt;
  }
  
  public boolean Va()
  {
    return this.bqu;
  }
  
  public void at(float paramFloat)
  {
    if (c.hf(this.mStatus)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.o(this.ccJ, false, true);
    }
    for (;;)
    {
      updateScroll(paramFloat);
      return;
      if (c.access$600(this.mStatus)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.o(this.ccJ, false, true);
      } else if (c.he(this.mStatus)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.o(this.ccJ, true, true);
      }
    }
  }
  
  public void cnG()
  {
    if (c.access$600(this.mStatus))
    {
      setStatus(-3);
      cnI();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.onRefresh();
    }
    do
    {
      return;
      if (c.he(this.mStatus))
      {
        if (Va()) {
          setStatus(1);
        }
        for (;;)
        {
          cnI();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.onReset();
          return;
          setStatus(0);
        }
      }
      if (c.hf(this.mStatus))
      {
        if (this.bqs)
        {
          this.bqs = false;
          setStatus(-3);
          cnI();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.onRefresh();
          return;
        }
        if (Va()) {
          setStatus(1);
        }
        for (;;)
        {
          cnI();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.onReset();
          return;
          setStatus(0);
        }
      }
      if ((c.hk(this.mStatus)) || (c.hl(this.mStatus)))
      {
        setStatus(1);
        cnI();
        return;
      }
    } while ((!c.hm(this.mStatus)) && (!c.hj(this.mStatus)));
    setStatus(0);
    cnI();
  }
  
  public void cnN()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.isFinished()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.gb(-this.ccK, this.ccG);
    }
  }
  
  public void cnO()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.isFinished()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.gb((int)(this.qW + 0.5F) - this.ccK - this.ccJ, this.ccG);
    }
  }
  
  public void cnP()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.isFinished()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.gb(-this.ccJ, this.ccG);
    }
  }
  
  public void cnQ()
  {
    setStatus(0);
    cnI();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.onReset();
    this.qW = 0.0F;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$a.onFlingScrollHeader(this.mStatus, -this.ccJ);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$a.onTouchMoving(this, -this.ccJ, paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      cnJ();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getHeaderViewHeight()
  {
    return this.aVz;
  }
  
  public boolean isRefreshing()
  {
    return c.access$400(this.mStatus);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = getChildCount();
    if (i == 0) {}
    do
    {
      return;
      if ((i <= 0) || (i >= 4)) {
        break;
      }
      this.dC = ((ViewGroup)findViewById(2131379044));
      this.mTargetView = findViewById(2131379045);
    } while ((this.mTargetView == null) || (this.dC == null) || (!(this.dC instanceof zbk)));
    this.dC.setVisibility(8);
    return;
    throw new IllegalStateException("Children num must equal or less than 3");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int m = 0;
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (this.o != null) {}
    for (int i = this.o.getListViewScrollY();; i = 0)
    {
      switch (j)
      {
      }
      for (;;)
      {
        boolean bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        label67:
        return bool1;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        float f1 = getMotionEventX(paramMotionEvent, this.mActivePointerId);
        this.jS = f1;
        this.mLastX = f1;
        f1 = getMotionEventY(paramMotionEvent, this.mActivePointerId);
        this.jT = f1;
        this.mLastY = f1;
        if ((c.hf(this.mStatus)) || (c.access$600(this.mStatus))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshAutoScroller.cnF();
        }
        if (((c.hf(this.mStatus)) || (c.access$600(this.mStatus))) && (i == 0))
        {
          return true;
          if (this.mActivePointerId == -1) {
            return false;
          }
          f1 = getMotionEventX(paramMotionEvent, this.mActivePointerId);
          float f2 = getMotionEventY(paramMotionEvent, this.mActivePointerId);
          float f3 = this.jS;
          float f4 = f2 - this.jT;
          this.mLastX = f1;
          this.mLastY = f2;
          if ((Math.abs(f1 - f3) < Math.abs(f4)) && (Math.abs(f4) > this.mTouchSlop)) {}
          for (j = 1;; j = 0)
          {
            int k = m;
            if (f4 > 0.0F)
            {
              k = m;
              if (UZ()) {
                k = 1;
              }
            }
            if ((i != 0) || (j == 0)) {
              break;
            }
            bool1 = bool2;
            if (k != 0) {
              break label67;
            }
            bool1 = bool2;
            if (c.he(this.mStatus)) {
              break label67;
            }
            if (!c.hg(this.mStatus)) {
              break;
            }
            return true;
          }
          this.mActivePointerId = -1;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layoutChildren();
    if (this.dC != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.bqr = paramBoolean;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.dC != null)
    {
      ViewGroup localViewGroup = this.dC;
      measureChildWithMargins(localViewGroup, paramInt1, 0, paramInt2, 0);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localViewGroup.getLayoutParams();
      int i = localViewGroup.getMeasuredHeight();
      int j = localMarginLayoutParams.topMargin;
      this.aVz = (localMarginLayoutParams.bottomMargin + (i + j));
      if (this.qW < this.aVz) {
        this.qW = this.aVz;
      }
    }
    if (this.mTargetView != null) {
      measureChildWithMargins(this.mTargetView, paramInt1, 0, paramInt2, 0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      return true;
      float f1 = getMotionEventX(paramMotionEvent, this.mActivePointerId);
      float f2 = getMotionEventY(paramMotionEvent, this.mActivePointerId);
      float f3 = f1 - this.mLastX;
      float f4 = f2 - this.mLastY;
      this.mLastX = f1;
      this.mLastY = f2;
      if ((Math.abs(f3) >= Math.abs(f4)) && (Math.abs(f3) > this.mTouchSlop)) {
        return false;
      }
      au(f4);
      return true;
      int i = MotionEventCompat.getPointerId(paramMotionEvent, MotionEventCompat.getActionIndex(paramMotionEvent));
      if (i != -1) {
        this.mActivePointerId = i;
      }
      this.mLastX = getMotionEventX(paramMotionEvent, this.mActivePointerId);
      this.mLastY = getMotionEventY(paramMotionEvent, this.mActivePointerId);
      continue;
      onSecondaryPointerUp(paramMotionEvent);
      this.mLastX = getMotionEventX(paramMotionEvent, this.mActivePointerId);
      this.mLastY = getMotionEventY(paramMotionEvent, this.mActivePointerId);
      continue;
      if (this.mActivePointerId == -1) {
        return false;
      }
      this.mActivePointerId = -1;
    }
  }
  
  public void setMiniAppScrollListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$a = parama;
  }
  
  public void setOnRefreshListener(zbi paramzbi)
  {
    this.b = paramzbi;
  }
  
  public void setRefreshCompleteDelayDuration(int paramInt)
  {
    this.ccF = paramInt;
  }
  
  public void setRefreshEnabled(boolean paramBoolean)
  {
    this.bqt = paramBoolean;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((!UY()) || (this.dC == null)) {}
    do
    {
      do
      {
        return;
        this.bqs = paramBoolean;
        if (!paramBoolean) {
          break;
        }
      } while (!c.access$000(this.mStatus));
      setStatus(-1);
      cnK();
      return;
    } while (!c.he(this.mStatus));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout$b.onReset();
    postDelayed(new CommonRefreshLayout.1(this), this.ccF);
  }
  
  public void setShowMiniAppPanel(boolean paramBoolean)
  {
    this.bqu = paramBoolean;
  }
  
  public void setTargetListView(ListView paramListView)
  {
    this.o = paramListView;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFlingScrollHeader(int paramInt1, int paramInt2);
    
    public abstract void onTouchMoving(CommonRefreshLayout paramCommonRefreshLayout, int paramInt, MotionEvent paramMotionEvent);
    
    public abstract int onViewCompleteAfterRefresh(boolean paramBoolean);
  }
  
  public abstract class b
    implements zbj, zbk
  {
    protected b() {}
  }
  
  public static final class c
  {
    private static boolean gS(int paramInt)
    {
      return paramInt == -3;
    }
    
    private static boolean gT(int paramInt)
    {
      return paramInt == -2;
    }
    
    private static boolean gU(int paramInt)
    {
      return paramInt == -1;
    }
    
    private static boolean gV(int paramInt)
    {
      return paramInt < 0;
    }
    
    private static boolean gW(int paramInt)
    {
      return paramInt == 0;
    }
    
    private static boolean gX(int paramInt)
    {
      return paramInt == 1;
    }
    
    private static boolean gY(int paramInt)
    {
      return paramInt == 2;
    }
    
    private static boolean gZ(int paramInt)
    {
      return paramInt == 3;
    }
    
    private static boolean ha(int paramInt)
    {
      return paramInt == 4;
    }
    
    private static boolean hb(int paramInt)
    {
      return paramInt == 5;
    }
    
    private static boolean hc(int paramInt)
    {
      return paramInt > 2;
    }
    
    private static boolean hd(int paramInt)
    {
      return paramInt >= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout
 * JD-Core Version:    0.7.0.1
 */