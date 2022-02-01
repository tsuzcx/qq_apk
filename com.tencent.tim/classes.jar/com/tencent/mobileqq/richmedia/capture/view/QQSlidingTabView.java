package com.tencent.mobileqq.richmedia.capture.view;

import alye;
import alyf;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import atau.a;
import com.tencent.mobileqq.widget.RedDotTextView;
import java.util.ArrayList;

public class QQSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] ATTRS = { 16842901, 16842904 };
  private a a;
  private int aYV;
  private boolean cBn;
  private int dAa = 0;
  private int dAb = -1;
  private int dss = 5;
  private int dzQ = -7829368;
  private int dzR = -16777216;
  private int dzS = Color.parseColor("#E62555");
  private int dzT = 14;
  private int dzU;
  private int dzV = 52;
  private int dzW = 1;
  private int dzX = -3355444;
  private int dzY;
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
  
  private void Ua(int paramInt)
  {
    int j = this.mRootLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.mRootLayout.getChildAt(i);
      View localView;
      if ((this.zc != null) && (i < this.zc.size()))
      {
        localView = (View)this.zc.get(i);
        if (i != paramInt) {
          break label186;
        }
        if (!(localView instanceof ImageView)) {
          break label108;
        }
        localObject = (Bundle)localView.getTag();
        if (localObject != null) {
          ((ImageView)localView).setImageResource(((Bundle)localObject).getInt("checked_image_bg_id", 2130847527));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label108:
        if ((localView instanceof RedDotTextView))
        {
          if (this.dAb == i) {
            ((RedDotTextView)localObject).setTextColor(this.dzS);
          }
          for (;;)
          {
            ((RedDotTextView)localObject).showRedDot(false);
            break;
            ((RedDotTextView)localObject).setTextColor(this.dzR);
          }
        }
        if ((localView instanceof TextView))
        {
          ((TextView)localObject).setTextColor(this.dzR);
          continue;
          label186:
          if ((localView instanceof ImageView))
          {
            localObject = (Bundle)localView.getTag();
            if (localObject != null) {
              ((ImageView)localView).setImageResource(((Bundle)localObject).getInt("normal_image_bg_id", 2130847526));
            }
          }
          else if ((localView instanceof RedDotTextView))
          {
            ((RedDotTextView)localObject).setTextColor(this.dzQ);
          }
          else if ((localView instanceof TextView))
          {
            ((TextView)localObject).setTextColor(this.dzQ);
          }
        }
      }
    }
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
  
  private int b(int paramInt, View paramView)
  {
    if (paramInt < 0) {
      return -1;
    }
    paramView.setOnClickListener(new alye(this, paramInt));
    this.zc.add(paramInt, paramView);
    this.mRootLayout.addView(paramView, paramInt);
    return 0;
  }
  
  private void dLy()
  {
    int j = this.mRootLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.mRootLayout.getChildAt(i);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      if (i == 0) {
        localLayoutParams.setMargins(this.dzU, 0, 0, 0);
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        i += 1;
        break;
        if (i == j - 1) {
          localLayoutParams.setMargins(0, 0, this.dzU, 0);
        }
      }
    }
  }
  
  @TargetApi(11)
  private void dLz()
  {
    if (this.dzY != this.mCurrentIndex)
    {
      Object localObject = this.mRootLayout.getChildAt(this.dzY);
      View localView = this.mRootLayout.getChildAt(this.mCurrentIndex);
      int i;
      int j;
      if ((localObject != null) && (localView != null))
      {
        i = ((View)localObject).getLeft();
        j = localView.getLeft();
        if ((i == 0) && (j == 0)) {
          this.cBn = true;
        }
      }
      else
      {
        return;
      }
      this.cBn = false;
      localObject = ValueAnimator.ofInt(new int[] { i, j });
      ((ValueAnimator)localObject).setDuration(100L);
      ((ValueAnimator)localObject).addUpdateListener(new alyf(this));
      ((ValueAnimator)localObject).start();
      return;
    }
    this.aYV = this.mRootLayout.getChildAt(this.mCurrentIndex).getLeft();
    invalidate();
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
    this.dAa = ankt.dip2px(this.dzZ);
  }
  
  public void TX(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.zc.size())) {
      return;
    }
    this.mCurrentIndex = paramInt;
    Ua(paramInt);
    Ub(paramInt);
    dLz();
    if (this.a != null) {
      this.a.TX(paramInt);
    }
    this.dzY = this.mCurrentIndex;
  }
  
  public ArrayList<View> dy()
  {
    return this.zc;
  }
  
  public void eL(ArrayList<b> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.mRootLayout.removeAllViews();
      return;
    }
    this.zc.clear();
    this.mRootLayout.removeAllViews();
    int i = 0;
    int j = -1;
    while (i < paramArrayList.size())
    {
      RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
      localRedDotTextView.setText(((b)paramArrayList.get(i)).tabName);
      localRedDotTextView.setContentDescription(((b)paramArrayList.get(i)).tabName);
      localRedDotTextView.setGravity(17);
      localRedDotTextView.setSingleLine();
      localRedDotTextView.setTextSize(0, this.dzT);
      localRedDotTextView.setPadding(this.mTabPadding, 0, this.mTabPadding, 0);
      localRedDotTextView.showRedDot(((b)paramArrayList.get(i)).needRedDot);
      if (((b)paramArrayList.get(i)).czY) {
        j = i;
      }
      b(i, localRedDotTextView);
      i += 1;
    }
    this.dAb = j;
    dLy();
    Ua(this.mCurrentIndex);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getHeight();
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
      if (this.dAb != this.mCurrentIndex) {
        break label183;
      }
    }
    label183:
    for (int i = this.dzS;; i = this.mIndicatorColor)
    {
      this.mPaint.setColor(i);
      float f1 = this.aYV + this.dss;
      float f2 = j - this.mIndicatorHeight;
      i = this.aYV;
      paramCanvas.drawRoundRect(new RectF(f1, f2, localView.getWidth() + i - this.dss, j), this.dAa, this.dAa, this.mPaint);
      return;
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
  
  public static abstract interface a
  {
    public abstract void TX(int paramInt);
  }
  
  public static class b
  {
    boolean czY;
    boolean needRedDot;
    String tabName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView
 * JD-Core Version:    0.7.0.1
 */