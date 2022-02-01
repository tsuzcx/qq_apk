package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class VipScaledViewPager
  extends ViewPager
{
  private ViewGroup ba;
  private Rect cs = new Rect();
  private Rect ct = new Rect();
  private Rect cu = new Rect();
  private boolean cwY;
  private AtomicBoolean dB = new AtomicBoolean(false);
  private int dtQ;
  private int dtR;
  private int mGap;
  private int mMaxHeight = -1;
  private int mMaxWidth = -1;
  private float mScale;
  private HashMap<Integer, Integer> mw = new HashMap();
  
  public VipScaledViewPager(Context paramContext)
  {
    super(paramContext);
    setStaticTransformationsEnabled(true);
  }
  
  public VipScaledViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setStaticTransformationsEnabled(true);
    init(paramContext, paramAttributeSet);
  }
  
  private static void a(Point paramPoint1, Point paramPoint2)
  {
    if ((paramPoint2.x >= 0) && (paramPoint1.x > paramPoint2.x)) {
      paramPoint1.x = paramPoint2.x;
    }
    if ((paramPoint2.y >= 0) && (paramPoint1.y > paramPoint2.y)) {
      paramPoint1.y = paramPoint2.y;
    }
  }
  
  private void a(View paramView, Transformation paramTransformation)
  {
    Matrix localMatrix = paramTransformation.getMatrix();
    float f = d(paramView);
    localMatrix.setScale(f, f);
    int i = paramView.getHeight();
    int j = paramView.getWidth();
    localMatrix.preTranslate(-(j / 2), -(i / 2));
    localMatrix.postTranslate(j / 2, i / 2);
    paramTransformation.setAlpha(getAlpha(paramView));
  }
  
  private int getCenterOfCoverflow()
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  private int getCenterOfView(View paramView)
  {
    paramView.getGlobalVisibleRect(this.cs);
    paramView.getLocalVisibleRect(this.ct);
    this.cu.left = ((this.cs.left + this.ct.left) / 2);
    this.cu.right = ((this.cs.right + this.ct.right) / 2);
    return Math.abs(this.cu.right) / 2 - this.cu.left;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    setClipChildren(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sO);
    setMaxWidth(paramContext.getDimensionPixelSize(0, -1));
    setMaxHeight(paramContext.getDimensionPixelSize(1, -1));
    setMatchChildWidth(paramContext.getResourceId(2, 0));
    paramContext.recycle();
  }
  
  public float d(View paramView)
  {
    int i = getCenterOfView(paramView);
    int j = this.dtQ - i;
    i = j;
    if (j <= 0) {
      i = 0;
    }
    float f2 = (getWidth() - i) / getWidth();
    float f1 = f2;
    if (f2 < this.mScale) {
      f1 = this.mScale;
    }
    return f1;
  }
  
  public void dFU()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      this.mw.put(Integer.valueOf(localView.hashCode()), Integer.valueOf(0));
      localView.invalidate();
      i += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.ba != null) {
      this.ba.requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public float getAlpha(View paramView)
  {
    int i = getCenterOfView(paramView);
    int j = this.dtQ - i;
    i = j;
    if (j <= 0) {
      i = 0;
    }
    float f2 = (getWidth() - i * 1.6F) / getWidth();
    float f1 = f2;
    if (f2 < 0.3F) {
      f1 = 0.3F;
    }
    return f1;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipScaledViewPager", 2, "getChildStaticTransformation child = " + paramView.hashCode() + ", mIsScroll = " + this.dB + ", mInvalidateMap = " + this.mw);
    }
    int i = paramView.hashCode();
    a(paramView, paramTransformation);
    if (this.dB.get()) {
      paramView.invalidate();
    }
    do
    {
      return true;
      if (!this.mw.containsKey(Integer.valueOf(i))) {
        break;
      }
    } while (((Integer)this.mw.get(Integer.valueOf(i))).intValue() >= 1);
    this.mw.put(Integer.valueOf(i), Integer.valueOf(1));
    paramView.invalidate();
    return true;
    this.mw.put(Integer.valueOf(i), Integer.valueOf(0));
    return true;
  }
  
  protected void jj(int paramInt1, int paramInt2)
  {
    if (!this.cwY) {}
    do
    {
      do
      {
        return;
        if (this.dtR == 0)
        {
          this.cwY = false;
          return;
        }
      } while (getChildCount() <= 0);
      View localView = getChildAt(0);
      localView.measure(paramInt1, paramInt2);
      paramInt1 = localView.getMeasuredWidth();
      localView = localView.findViewById(this.dtR);
      if (localView == null) {
        throw new NullPointerException("MatchWithChildResId did not find that ID in the first fragment of the ViewPager; is that view defined in the child view's layout? Note that MultiViewPager only measures the child for index 0.");
      }
      paramInt2 = localView.getMeasuredWidth();
    } while (paramInt2 <= 0);
    this.cwY = false;
    setPageMargin(-(int)(paramInt1 - paramInt2 + paramInt2 * (1.0F - this.mScale) * 0.5F - this.mGap));
    setOffscreenPageLimit((int)Math.ceil(paramInt1 / paramInt2) + 1);
    requestLayout();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipScaledViewPager", 2, "onInterceptTouchEvent");
    }
    if (this.ba != null) {
      this.ba.requestDisallowInterceptTouchEvent(true);
    }
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    Point localPoint = new Point(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    if ((this.mMaxWidth >= 0) || (this.mMaxHeight >= 0))
    {
      a(localPoint, new Point(this.mMaxWidth, this.mMaxHeight));
      paramInt1 = View.MeasureSpec.makeMeasureSpec(localPoint.x, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(localPoint.y, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    jj(paramInt1, paramInt2);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dtQ = getCenterOfCoverflow();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.cwY = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public void setGap(int paramInt)
  {
    this.mGap = paramInt;
  }
  
  public void setMatchChildWidth(int paramInt)
  {
    if (this.dtR != paramInt)
    {
      this.dtR = paramInt;
      this.cwY = true;
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
  }
  
  public void setParentView(ViewGroup paramViewGroup)
  {
    this.ba = paramViewGroup;
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
  }
  
  public void startScroll()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipScaledViewPager", 2, "startScroll");
    }
    this.dB.set(true);
    dFU();
  }
  
  public void stopScroll()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipScaledViewPager", 2, "stopScroll");
    }
    this.dB.set(false);
    dFU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipScaledViewPager
 * JD-Core Version:    0.7.0.1
 */