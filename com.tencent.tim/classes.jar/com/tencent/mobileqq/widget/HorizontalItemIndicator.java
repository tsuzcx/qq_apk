package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Scroller;
import android.widget.TextView;
import atau.a;
import com.tencent.widget.AbsSpinner;

public class HorizontalItemIndicator
  extends ViewGroup
{
  private int ST;
  private a a;
  private int dzY;
  private int ego;
  private int egp;
  private int egq;
  private int egr;
  private Paint mPaint = new Paint();
  private Scroller mScroller = new Scroller(getContext());
  
  public HorizontalItemIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HorizontalItemIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalItemIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, atau.a.qO, paramInt, 0);
    try
    {
      this.ST = paramContext.getColor(1, -1711276033);
      this.ego = paramContext.getDimensionPixelSize(2, 28);
      this.egq = paramContext.getColor(0, -1);
      paramContext.recycle();
      this.egp = this.ego;
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(-1);
      setWillNotDraw(false);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private TextView ae()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setTextColor(this.ST);
    localTextView.setTextSize(0, this.ego);
    localTextView.setSingleLine();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
    localMarginLayoutParams.leftMargin = 10;
    localMarginLayoutParams.rightMargin = 10;
    localMarginLayoutParams.topMargin = 10;
    localMarginLayoutParams.bottomMargin = 20;
    localTextView.setLayoutParams(localMarginLayoutParams);
    return localTextView;
  }
  
  private TextView e(int paramInt)
  {
    return (TextView)getChildAt(paramInt);
  }
  
  public void Yv(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {}
    while ((!this.mScroller.isFinished()) || (paramInt == this.egr)) {
      return;
    }
    int i = getChildAt(this.egr).getMeasuredWidth() / 2 + getChildAt(this.egr).getLeft();
    int j = getChildAt(paramInt).getMeasuredWidth() / 2;
    int k = getChildAt(paramInt).getLeft();
    this.dzY = this.egr;
    this.egr = paramInt;
    if (this.a != null) {
      this.a.Yw(paramInt);
    }
    this.mScroller.startScroll(i, 0, j + k - i, 0);
    requestLayout();
  }
  
  public void ab(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addItem(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public void addItem(String paramString)
  {
    TextView localTextView = ae();
    localTextView.setText(paramString);
    addView(localTextView);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    int i;
    if (this.mScroller.computeScrollOffset())
    {
      i = this.mScroller.getCurrX();
      Log.i("tmp", "currMid is " + i);
      postInvalidate();
    }
    for (;;)
    {
      int j = getMeasuredWidth() / 2;
      paramCanvas.save();
      paramCanvas.translate(j - i, 0.0F);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.drawCircle(j, getChildAt(0).getBottom() + 8 + 6, 6.0F, this.mPaint);
      return;
      i = getChildAt(this.egr).getMeasuredWidth() / 2 + getChildAt(this.egr).getLeft();
      if (this.dzY != this.egr)
      {
        localTextView = e(this.dzY);
        localTextView.setTextSize(0, this.ego);
        localTextView.setTextColor(this.ST);
      }
      TextView localTextView = e(this.egr);
      localTextView.setTextSize(0, this.egp);
      localTextView.setTextColor(this.egq);
    }
  }
  
  public void ehZ()
  {
    int i = this.egr + 1;
    if (i >= getChildCount()) {
      return;
    }
    Yv(i);
  }
  
  public void eia()
  {
    int i = this.egr - 1;
    if (i < 0) {
      return;
    }
    Yv(i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramInt2 = getPaddingLeft();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt4 = localView.getMeasuredWidth();
      int i = localView.getMeasuredHeight();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      paramInt2 += localMarginLayoutParams.leftMargin;
      int j = getPaddingTop() + localMarginLayoutParams.topMargin;
      localView.layout(paramInt2, j, paramInt2 + paramInt4, i + j);
      paramInt2 = paramInt2 + paramInt4 + localMarginLayoutParams.rightMargin;
      paramInt1 += 1;
    }
  }
  
  @TargetApi(11)
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = getChildCount();
    measureChildren(paramInt1, paramInt2);
    int k = 0;
    int j = 0;
    int i = 0;
    int m;
    int i1;
    if (k < n)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 8) {
        break label257;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      m = localMarginLayoutParams.leftMargin;
      i1 = localMarginLayoutParams.rightMargin;
      int i2 = localView.getMeasuredWidth();
      int i3 = localMarginLayoutParams.topMargin;
      i = Math.max(i, localMarginLayoutParams.bottomMargin + i3 + localView.getMeasuredHeight());
      m = j + (m + i1 + i2);
      j = i;
      i = m;
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      n = getPaddingLeft();
      i1 = getPaddingRight();
      k = getPaddingTop();
      m = getPaddingBottom();
      j = Math.max(n + i1 + j, getSuggestedMinimumWidth());
      k = Math.max(k + m + i, getSuggestedMinimumHeight());
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramInt1 = resolveSizeAndState(j, paramInt1, 0);
        i = resolveSizeAndState(k, paramInt2, 0);
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt2, paramInt1);
        return;
        i = AbsSpinner.doResolveSizeAndState(j, paramInt1, 0);
        paramInt1 = AbsSpinner.doResolveSizeAndState(k, paramInt2, 0);
        paramInt2 = i;
      }
      label257:
      m = i;
      i = j;
      j = m;
    }
  }
  
  public void setCurrItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {}
    while ((!this.mScroller.isFinished()) || (paramInt == this.egr)) {
      return;
    }
    this.dzY = this.egr;
    this.egr = paramInt;
    if (this.a != null) {
      this.a.Yw(paramInt);
    }
    requestLayout();
  }
  
  public void setNextItem()
  {
    int i = this.egr + 1;
    if (i >= getChildCount()) {
      return;
    }
    setCurrItem(i);
  }
  
  public void setOnItemChanged(a parama)
  {
    this.a = parama;
  }
  
  public void setPrevItem()
  {
    int i = this.egr - 1;
    if (i < 0) {
      return;
    }
    setCurrItem(i);
  }
  
  public static abstract interface a
  {
    public abstract void Yw(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HorizontalItemIndicator
 * JD-Core Version:    0.7.0.1
 */