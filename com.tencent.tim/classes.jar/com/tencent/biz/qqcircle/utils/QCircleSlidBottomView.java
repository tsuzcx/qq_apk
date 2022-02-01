package com.tencent.biz.qqcircle.utils;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import ankt;
import atau.a;
import ayxa;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.widget.immersive.ImmersiveUtils;
import pdu;
import pdv;
import pdw;
import rxn;
import rze;

public class QCircleSlidBottomView
  extends FrameLayout
  implements NestedScrollingParent
{
  private int Iq;
  private final NestedScrollingParentHelper jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper;
  private a jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView$a;
  private int aDC;
  private ObjectAnimator aJ;
  private ObjectAnimator aK;
  private ObjectAnimator aL;
  private ObjectAnimator aM;
  private boolean azB;
  private boolean azC;
  private int bcD;
  private final int bhH = 0;
  private final int bhI = 1;
  private final int bhJ = ankt.dip2px(50.0F);
  private final int bhK = ankt.dip2px(5.0F);
  private final int bhL;
  private final int bhM;
  private int bhN;
  private int bhO;
  private int bhP;
  private int bhQ;
  private int bhR;
  private int bhS;
  private int bhT;
  protected Interpolator f = new b(1.0D);
  protected Interpolator g = new AccelerateInterpolator();
  private Interpolator mInterpolator = new pdu(this);
  private final int mMaxFlingVelocity;
  private int mScreenHeight;
  private ScrollerCompat mScroller = ScrollerCompat.create(getContext(), this.mInterpolator);
  private final int mTouchSlop;
  private View nR;
  
  public QCircleSlidBottomView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleSlidBottomView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleSlidBottomView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mScreenHeight = ankt.getRealHeight(paramContext);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.bhL = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rv);
    this.bhP = ((int)(paramAttributeSet.getFloat(3, 0.5F) * this.mScreenHeight));
    this.bhO = ((int)paramAttributeSet.getDimension(4, this.bhJ));
    this.bhQ = ((int)paramAttributeSet.getDimension(1, ankt.dip2px(30.0F)));
    this.bhM = ((int)paramAttributeSet.getDimension(0, 0.0F));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.Iq = (ImmersiveUtils.getStatusBarHeight(paramContext) - 1);
    }
    if (ankt.bA(paramContext)) {
      this.bcD = ankt.getNavigationBarHeight(paramContext);
    }
    if (ayxa.enableNotch((Activity)paramContext)) {
      this.bhR = ayxa.bwQ;
    }
    this.bhT = (this.mScreenHeight - this.bhO - Math.max(this.Iq, this.bhR));
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    this.bhN = (this.bhP - this.bhO);
    if (rze.Mp()) {
      setBackgroundColor(Color.parseColor("#00000000"));
    }
  }
  
  private boolean HS()
  {
    return this.aDC == 0;
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    if (HS()) {
      if (!b(paramRecyclerView)) {}
    }
    do
    {
      do
      {
        return true;
      } while (paramInt <= 0);
      return false;
      if (paramInt >= 0) {
        return this.azC;
      }
    } while (!paramRecyclerView.canScrollVertically(-1));
    return false;
  }
  
  private boolean b(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView != null) && ((paramRecyclerView.getAdapter() instanceof rxn))) {
      return ((rxn)paramRecyclerView.getAdapter()).getCount() > 0;
    }
    return false;
  }
  
  private void bkg()
  {
    this.aM = ObjectAnimator.ofInt(this, "ScrollY", new int[] { getScrollY(), 0 }).setDuration(200L);
    this.aM.start();
    this.aDC = 0;
  }
  
  private void bkh()
  {
    this.aK = ObjectAnimator.ofInt(this, "ScrollY", new int[] { getScrollY(), this.bhN }).setDuration(1500L);
    this.aK.setInterpolator(this.f);
    this.aK.start();
    this.aDC = 1;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nR.getLayoutParams();
    localLayoutParams.height = (this.bhT + this.bhK);
    this.nR.setLayoutParams(localLayoutParams);
  }
  
  private void bkj()
  {
    if (this.aJ != null) {
      this.aJ.cancel();
    }
    if (this.aK != null) {
      this.aK.cancel();
    }
    if (this.aM != null) {
      this.aM.cancel();
    }
    if (this.aL != null) {
      this.aL.cancel();
    }
  }
  
  private void fling(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (Math.abs(paramInt2) < this.bhL) {
      i = 0;
    }
    if ((paramInt1 == 0) && (i == 0)) {}
    do
    {
      do
      {
        return;
        bkj();
        paramInt1 = Math.max(-this.mMaxFlingVelocity, Math.min(paramInt1, this.mMaxFlingVelocity));
        paramInt2 = Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity));
      } while (Math.abs(paramInt2) <= Math.abs(paramInt1));
      this.mScroller.abortAnimation();
      this.mScroller.fling(0, getScrollY(), paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    } while (!this.mScroller.computeScrollOffset());
    paramInt1 = this.mScroller.getCurrY();
    paramInt2 = this.mScroller.getFinalY();
    i = paramInt2 - paramInt1;
    if (i > 0) {
      if ((HS()) && (i > this.mScreenHeight / 2)) {
        bkh();
      }
    }
    for (;;)
    {
      QLog.d("QCircleSlidBottomView", 3, "fling start y:" + paramInt1 + "   end y:" + paramInt2);
      return;
      if (i < 0) {
        if (HS())
        {
          if (Math.abs(i) > this.mScreenHeight / 2) {
            bki();
          }
        }
        else if (Math.abs(i) > this.mScreenHeight * 2.0F / 3.0F) {
          bki();
        }
      }
    }
  }
  
  protected void bkf()
  {
    int i = getScrollY();
    i = this.bhS - i;
    QLog.d("QCircleSlidBottomView", 3, "onend:" + this.bhS);
    if (HS()) {
      if (i > 0) {
        if (Math.abs(i) > this.bhT / 6.0F) {
          bki();
        }
      }
    }
    while (i <= 0)
    {
      return;
      bkg();
      return;
      if (Math.abs(i) > this.bhT / 8.0F)
      {
        bkh();
        return;
      }
      bkg();
      return;
    }
    if (Math.abs(i) > this.bhT / 2.0F)
    {
      bki();
      return;
    }
    if (Math.abs(i) > this.bhT / 6.0F)
    {
      bkg();
      return;
    }
    bkh();
  }
  
  public void bki()
  {
    int i = getScrollY();
    QLog.d("QCircleSlidBottomView", 3, "currentY:" + i);
    this.aL = ObjectAnimator.ofInt(this, "ScrollY", new int[] { i, -this.bhT / 2 }).setDuration(200L);
    this.aL.setInterpolator(this.g);
    this.aL.addListener(new pdw(this));
    this.aL.start();
    this.aDC = 0;
  }
  
  public void dI(View paramView)
  {
    this.nR = paramView;
    setVisibility(0);
    this.aJ = ObjectAnimator.ofInt(this, "ScrollY", new int[] { -this.bhT / 2, 0 }).setDuration(1500L);
    this.aJ.addListener(new pdv(this));
    this.aJ.setInterpolator(this.f);
    this.aJ.start();
    this.aDC = 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getChildCount();
    paramInt3 = this.bhP;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (paramInt1 == 0) {
        localView.setPadding(0, 0, 0, this.bhM + this.bcD + this.bhK);
      }
      localView.layout(0, paramInt3, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt3 + this.bhK);
      paramInt1 += 1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramView instanceof NestScrollRecyclerView))
    {
      bool1 = bool2;
      if (a((int)paramFloat2, (NestScrollRecyclerView)paramView))
      {
        fling((int)paramFloat1, (int)paramFloat2);
        bool1 = true;
        QLog.d("QCircleSlidBottomView", 3, "fling:" + paramFloat1 + " " + paramFloat2);
      }
    }
    return bool1;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (((paramView instanceof RecyclerView)) && (a(paramInt2, (RecyclerView)paramView)))
    {
      this.azC = true;
      if ((getScrollY() + paramInt2 > this.bhN) && (paramInt2 > 0)) {
        paramArrayOfInt[1] = paramInt2;
      }
    }
    else
    {
      return;
    }
    bkj();
    if (paramInt2 > this.mTouchSlop * 2) {
      scrollBy(0, this.mTouchSlop * 2);
    }
    for (;;)
    {
      paramArrayOfInt[1] = paramInt2;
      return;
      if (paramInt2 < this.mTouchSlop * -2) {
        scrollBy(0, this.mTouchSlop * -2);
      } else {
        scrollBy(0, paramInt2);
      }
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.bhS = getScrollY();
    QLog.d("QCircleSlidBottomView", 3, "onstart:" + this.bhS);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onStopNestedScroll(paramView);
    if (!this.azB) {
      bkf();
    }
    this.azC = false;
  }
  
  public void setStatusListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
  
  public class b
    implements Interpolator
  {
    private double bf;
    
    public b(double paramDouble)
    {
      this.bf = paramDouble;
    }
    
    public float getInterpolation(float paramFloat)
    {
      return (float)(Math.pow(2.0D, -24.0D * paramFloat) * Math.sin((paramFloat - this.bf / 10.0D) * 6.283185307179586D / this.bf) + 1.0D);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleSlidBottomView
 * JD-Core Version:    0.7.0.1
 */