package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import atau.a;
import azbx;
import java.util.ArrayList;

public class QQSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] ATTRS = { 16842901, 16842904 };
  private a a;
  private int aYV;
  private boolean cBn;
  private int dAa = 0;
  private int dss = 5;
  private int dzQ = -7829368;
  private int dzR = -16777216;
  private int dzT = 14;
  private int dzU;
  private int dzV = 52;
  private int dzW = 1;
  private int dzX = -3355444;
  private int dzZ = 0;
  private LinearLayout.LayoutParams h;
  private int mCurrentIndex;
  private int mIndicatorColor = -16776961;
  private int mIndicatorHeight = 4;
  private Paint mPaint;
  private LinearLayout mRootLayout;
  private int mTabPadding = 15;
  private ArrayList<View> zc = new ArrayList(5);
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h(paramContext, paramAttributeSet);
  }
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h(paramContext, paramAttributeSet);
  }
  
  private void Ub(int paramInt)
  {
    View localView = this.mRootLayout.getChildAt(paramInt);
    int i;
    if (localView != null)
    {
      paramInt = getScrollX();
      i = this.mTabPadding * 4;
      int j = localView.getRight() - paramInt - getWidth() + i;
      if (j <= 0) {
        break label53;
      }
      smoothScrollBy(j, 0);
    }
    label53:
    do
    {
      return;
      paramInt = localView.getLeft() - paramInt - i;
    } while (paramInt >= 0);
    smoothScrollBy(paramInt, 0);
  }
  
  private void h(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.h = new LinearLayout.LayoutParams(-2, -1);
    this.mRootLayout = new LinearLayout(paramContext);
    this.mRootLayout.setOrientation(0);
    this.mRootLayout.setLayoutParams(this.h);
    addView(this.mRootLayout);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.dzU = ((int)TypedValue.applyDimension(1, this.dzU, localDisplayMetrics));
    this.dzV = ((int)TypedValue.applyDimension(1, this.dzV, localDisplayMetrics));
    this.mIndicatorHeight = ((int)TypedValue.applyDimension(1, this.mIndicatorHeight, localDisplayMetrics));
    this.dzW = ((int)TypedValue.applyDimension(1, this.dzW, localDisplayMetrics));
    this.mTabPadding = ((int)TypedValue.applyDimension(1, this.mTabPadding, localDisplayMetrics));
    this.dzT = ((int)TypedValue.applyDimension(1, this.dzT, localDisplayMetrics));
    this.dss = ((int)TypedValue.applyDimension(1, this.dss, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rw);
    this.dzU = paramContext.getDimensionPixelSize(4, this.dzU);
    this.mTabPadding = paramContext.getDimensionPixelSize(3, this.mTabPadding);
    this.mIndicatorColor = paramContext.getColor(0, this.mIndicatorColor);
    this.mIndicatorHeight = paramContext.getDimensionPixelSize(1, this.mIndicatorHeight);
    this.dzQ = paramContext.getColor(6, this.dzQ);
    this.dzR = paramContext.getColor(5, this.dzR);
    this.dzX = paramContext.getColor(8, this.dzX);
    this.dzW = paramContext.getDimensionPixelSize(9, this.dzW);
    this.dzT = paramContext.getDimensionPixelSize(7, this.dzT);
    this.dss = paramContext.getDimensionPixelSize(2, this.dss);
    paramContext.recycle();
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(this.mIndicatorColor);
    this.mPaint.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.dAa = azbx.dip2px(this.dzZ);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    View localView = this.mRootLayout.getChildAt(this.mCurrentIndex);
    if (localView != null)
    {
      if (this.cBn)
      {
        this.aYV = localView.getLeft();
        Ub(this.mCurrentIndex);
        this.cBn = false;
      }
      if ((this.mCurrentIndex == 0) && (this.aYV < localView.getLeft())) {
        this.aYV = localView.getLeft();
      }
      float f1 = this.aYV + this.dss;
      float f2 = i - this.mIndicatorHeight;
      int j = this.aYV;
      paramCanvas.drawRoundRect(new RectF(f1, f2, localView.getWidth() + j - this.dss, i), this.dAa, this.dAa, this.mPaint);
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.mIndicatorColor = paramInt;
    this.mPaint.setColor(this.mIndicatorColor);
    invalidate();
  }
  
  public void setTabCheckListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView
 * JD-Core Version:    0.7.0.1
 */